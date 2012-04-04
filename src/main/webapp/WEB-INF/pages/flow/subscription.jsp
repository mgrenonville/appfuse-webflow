<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="signup.title"/></title>
    <meta name="heading" content="<fmt:message key='signup.heading'/>"/>
</head>
<body id="signup">


<spring:bind path="userInformationCommand.userInformationCommand.*">
    <c:if test="${not empty status.errorMessages}">
    <div class="error">
        <c:forEach var="error" items="${status.errorMessages}">
            <img src="<c:url value="/images/iconWarning.gif"/>"
                alt="<fmt:message key="icon.warning"/>" class="icon" />
            <c:out value="${error}" escapeXml="false"/><br />
        </c:forEach>
    </div>
    </c:if>
</spring:bind>

<div class="separator"></div>

<ul>
    <li class="info">
        <fmt:message key="signup.message"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="user.username"/>
        <form:errors path="userInformationCommand.username" cssClass="fieldError"/>
        <form:input path="userInformationCommand.username" id="username" cssClass="text large" cssErrorClass="text large error"/>
    </li>
    <li>
        <div>
            <div class="left">
                <appfuse:label styleClass="desc" key="user.password"/>
                <form:errors path="userInformationCommand.password" cssClass="fieldError"/>
                <form:password path="userInformationCommand.password" id="password" cssClass="text medium" cssErrorClass="text medium error" showPassword="true"/>
            </div>
            <div>
                <appfuse:label styleClass="desc" key="user.confirmPassword"/>
                <form:errors path="userInformationCommand.confirmPassword" cssClass="fieldError"/>
                <form:password path="userInformationCommand.confirmPassword" id="confirmPassword" cssClass="text medium" cssErrorClass="text medium error" showPassword="true"/>
            </div>
        </div>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="user.passwordHint"/>
        <form:errors path="userInformationCommand.passwordHint" cssClass="fieldError"/>
        <form:input path="userInformationCommand.passwordHint" id="passwordHint" cssClass="text large" cssErrorClass="text large error"/>
    </li>
    <li>
        <div class="left">
            <appfuse:label styleClass="desc" key="user.firstName"/>
            <form:errors path="userInformationCommand.firstName" cssClass="fieldError"/>
            <form:input path="userInformationCommand.firstName" id="firstName" cssClass="text medium" cssErrorClass="text medium error" maxlength="50"/>
        </div>
        <div>
            <appfuse:label styleClass="desc" key="user.lastName"/>
            <form:errors path="userInformationCommand.lastName" cssClass="fieldError"/>
            <form:input path="userInformationCommand.lastName" id="lastName" cssClass="text medium" cssErrorClass="text medium error" maxlength="50"/>
        </div>
    </li>
    <li>
        <div>
            <div class="left">
                <appfuse:label styleClass="desc" key="user.email"/>
                <form:errors path="userInformationCommand.email" cssClass="fieldError"/>
                <form:input path="userInformationCommand.email" id="email" cssClass="text medium" cssErrorClass="text medium error"/>
            </div>
            <div>
                <appfuse:label styleClass="desc" key="user.phoneNumber"/>
                <form:errors path="userInformationCommand.phoneNumber" cssClass="fieldError"/>
                <form:input path="userInformationCommand.phoneNumber" id="phoneNumber" cssClass="text medium" cssErrorClass="text medium error"/>
            </div>
        </div>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="user.website"/>
        <form:errors path="userInformationCommand.website" cssClass="fieldError"/>
        <form:input path="userInformationCommand.website" id="website" cssClass="text large" cssErrorClass="text large error"/>
    </li>
</ul>
<a href="${flowExecutionUrl}&_eventId=subscription">Next</a>

</body>
