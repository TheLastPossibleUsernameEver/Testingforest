<html>
<head>
    <meta name="layout" content="main" />
    <title> Sign In - TestingForest</title>
</head>
<body>
<div class="nav" role="navigation">
    <u1>
        <li>
            <g:link action="create">
                <g:message code="registration.label"/>
            </g:link>
        </li>
    </u1>
</div>
<div class="content" role="main">
    <h1><g:message code="login.label"/></h1>
    <g:if test="${flash.error}">
        <div class="errors">
            ${flash.error}
        </div>
    </g:if>
    <g:if test="${flash.message}">
        <div class="message">
            ${flash.message}
        </div>
    </g:if>
    <g:form action="authenticate">
        <fieldset class="form">
            <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'login','error')}">
                <label><g:message code="login.label"/></label>
                <g:textField name="login" value="${userInstance?.login}"/>
            </div>
            <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password','error')}">
                <label><g:message code="password.label"/></label>
                <g:passwordField type="password" name="password" value="${userInstance?.password}"/>
            </div>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="log_in" value="${message(code: 'login.label')}"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>