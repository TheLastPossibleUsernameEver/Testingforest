<html>
<head>
    <meta name="layout" content="main">
    <title>
        <g:message code="title.project.addUserProject"/>
    </title>
</head>
<body>

<div class="nav" role="navigation">
    <u1>
        <li><g:link class="list" uri="/project/show/${this.project.id}">
            <g:message code="project.label.show.info"/>
        </g:link></li>
    </u1>
</div>
<div class="body">
    <h1>
        <g:message code="project.label.addUserProject"/>
    </h1>
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
    <g:form action="addingUser" >
        <fieldset class="form">
            <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'login','error')}">
                <label>
                    <g:message code="user.login.label.field"/>
                </label>
                <g:textField name="login" value="${userInstance?.login}"/>
            </div>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="addUserProject" class="save" value="${message(code: 'project.label.addUserProject')}"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>