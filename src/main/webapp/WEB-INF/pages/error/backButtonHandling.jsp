<%@ page import="org.springframework.webflow.execution.repository.FlowExecutionRestorationFailureException" %>
<%@ page import="org.springframework.webflow.execution.repository.support.CompositeFlowExecutionKey" %>
<%@ page import="java.io.Serializable" %>
<%@ page import="java.util.Map" %>
<%@ include file="/common/taglibs.jsp" %>

<title><spring:message code="backbuttonhandling.title" /></title>
<head>
    <meta name="heading" content="<spring:message code="backbuttonhandling.title" />"/>
</head>

<p>

    <spring:message code="backbuttonhandling.text" />
    <%--See com.excilys.webapp.flow.listener.LastViewedUrlListener  --%>
	<a href="${sessionScope['LAST_VIEW_RENDERED_URL'][exception.flowExecutionKey.executionId]}" ><spring:message code="backbuttonhandling.resumelink.text" /></a>
</p>

<!--
<% 
((Exception) request.getAttribute("exception")).printStackTrace(new java.io.PrintWriter(out));  
%>
-->


