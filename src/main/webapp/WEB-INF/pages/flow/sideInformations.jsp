<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="signup.title"/></title>
    <meta name="heading" content="<fmt:message key='signup.heading'/>"/>
</head>
<body id="signup">


<div class="separator"></div>
<form action="${flowExecutionUrl}" method="POST">

    <spring:bind path="addressCommand.*">
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
    <ul>
    <li class="info">
        <fmt:message key="signup.message"/>
    </li>
        <li>
                <label class="desc"><fmt:message key="user.address.address"/></label>
                <div class="group">
                    <div>
                        <form:input path="addressCommand.address" id="address.address" cssClass="text large" cssErrorClass="text large error"/>
                        <form:errors path="addressCommand.address" cssClass="fieldError"/>
                        <p><appfuse:label key="user.address.address"/></p>
                    </div>
                    <div class="left">
                        <form:input path="addressCommand.city" id="address.city" cssClass="text medium" cssErrorClass="text medium error"/>
                        <form:errors path="addressCommand.city" cssClass="fieldError"/>
                        <p><appfuse:label key="user.address.city"/></p>
                    </div>
                    <div>
                        <form:input path="addressCommand.state" id="address.state" cssClass="text state" cssErrorClass="text state error"/>
                        <form:errors path="addressCommand.state" cssClass="fieldError"/>
                        <p><appfuse:label key="user.address.province"/></p>
                    </div>
                    <div class="left">
                        <form:input path="addressCommand.postalCode" id="address.postalCode" cssClass="text medium" cssErrorClass="text medium error"/>
                        <form:errors path="addressCommand.postalCode" cssClass="fieldError"/>
                        <p><appfuse:label key="user.address.postalCode"/></p>
                    </div>
                    <div>
                        <appfuse:country name="country" prompt="" default="${addressCommand.country}"/>
                        <p><appfuse:label key="user.address.country"/></p>
                    </div>
                </div>
            </li>
</ul>
    <input type="submit" name="_eventId_back" value="Back" />
    <input type="submit" name="_eventId_finish" value="Next" />

</form>
</body>
