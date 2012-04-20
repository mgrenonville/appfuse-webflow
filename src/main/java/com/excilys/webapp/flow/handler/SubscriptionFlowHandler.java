package com.excilys.webapp.flow.handler;

import org.springframework.webflow.execution.FlowExecutionOutcome;
import org.springframework.webflow.mvc.servlet.AbstractFlowHandler;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@FlowHandler("subscription")
public class SubscriptionFlowHandler extends AbstractFlowHandler {
    @Override
    public String handleExecutionOutcome(FlowExecutionOutcome outcome, HttpServletRequest request, HttpServletResponse response) {
        return super.handleExecutionOutcome(outcome, request, response);
    }
}
