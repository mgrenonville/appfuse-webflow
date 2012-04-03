package com.excilys.webapp.flow.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.webflow.core.collection.MutableAttributeMap;
import org.springframework.webflow.core.collection.SharedAttributeMap;
import org.springframework.webflow.definition.StateDefinition;
import org.springframework.webflow.execution.*;
import org.springframework.webflow.execution.repository.support.CompositeFlowExecutionKey;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * This Listener declares in the session an attribute named 'LAST_VIEW_RENDERED_URL' to allow the error view and other
 * view to resume the execution of the flow.
 * <p/>
 * It maintains the attribute up-to-date on every view rendering.
 *
 * @author mgrenonville
 */
@Component
public class LastViewedUrlListener extends FlowExecutionListenerAdapter {

    public static final String KEY = "LAST_VIEW_RENDERED_URL";

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void viewRendered(RequestContext context, View view, StateDefinition viewState) {

        SharedAttributeMap sessionMap = context.getExternalContext().getSessionMap();

        Map<Serializable, String> lastViewedUrlByExecution = retrieveLastViewedUrlByExecutionMap(context);

        Serializable executionId = retrieveExecutionId(context);

        String flowExecutionUrl = context.getFlowExecutionUrl();
        logger.debug("last execution url rendered is '{}' for execution '{}'", flowExecutionUrl, executionId);
        lastViewedUrlByExecution.put(executionId, flowExecutionUrl);
        sessionMap.put(KEY, lastViewedUrlByExecution);
    }

    private Serializable retrieveExecutionId(RequestContext context) {
        FlowExecutionKey executionKey = context.getFlowExecutionContext().getKey();
        Serializable executionId = "DEFAULT";
        if(executionKey instanceof CompositeFlowExecutionKey){
            executionId = ((CompositeFlowExecutionKey) executionKey).getExecutionId();
        }
        return executionId;
    }

    private Map<Serializable, String> retrieveLastViewedUrlByExecutionMap(RequestContext context) {
        SharedAttributeMap sessionMap = context.getExternalContext().getSessionMap();
        Map<Serializable, String> lastViewedUrlByExecution = (Map<Serializable, String>) sessionMap.get(KEY);
        if(lastViewedUrlByExecution == null){
             lastViewedUrlByExecution = new HashMap<Serializable, String>();
        }
        return lastViewedUrlByExecution;
    }

    @Override
    public void sessionStarted(RequestContext context, FlowSession session) {
        Map<Serializable, String> serializableStringMap = retrieveLastViewedUrlByExecutionMap(context);
        serializableStringMap.put(retrieveExecutionId(context), "");
    }
    @Override
    public void sessionEnding(RequestContext context, FlowSession session, String outcome, MutableAttributeMap output) {
        Map<Serializable, String> serializableStringMap = retrieveLastViewedUrlByExecutionMap(context);
        serializableStringMap.remove(retrieveExecutionId(context));
    }
}
