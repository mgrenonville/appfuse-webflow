package com.excilys.webapp.flow.handler;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface FlowHandler {
    /**
     * The bean name must match the id of the flow the handler should apply to.
     */
    String value();
}