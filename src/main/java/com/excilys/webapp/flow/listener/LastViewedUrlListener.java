package com.excilys.webapp.flow.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.webflow.core.collection.SharedAttributeMap;
import org.springframework.webflow.definition.StateDefinition;
import org.springframework.webflow.execution.FlowExecutionListenerAdapter;
import org.springframework.webflow.execution.RequestContext;
import org.springframework.webflow.execution.View;

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


        String flowExecutionUrl = context.getFlowExecutionUrl();
        logger.debug("last execution url rendered is '{}'", flowExecutionUrl);

        sessionMap.put(KEY, flowExecutionUrl);
    }

}
