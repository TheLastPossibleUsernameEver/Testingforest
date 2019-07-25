<html>
<head>
    <meta name="layout" content="main" />
    <title>Add user</title>
</head>
<body>

<div class="nav" role="navigation">
    <u1>
        <li><g:link class="list" uri="/project/show/${this.project.id}">Project info</g:link></li>
        <li><g:link class="list" uri="/user/logout">Log out</g:link></li>
    </u1>
</div>
<div class="body">
    <h1>Add user</h1>
    <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
    </g:if>
    <g:form action="addingUser" >
        <fieldset class="form">
            <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'login','error')}">
                <label>User login:</label>
                <g:textField name="login" value="${userInstance?.login}"/>
            </div>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="addUserProject" class="save" value="Add"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>