<html>
<head>
    <meta name="layout" content="main" />
    <title>Login</title>
</head>
<body>

<div class="nav" role="navigation">
    <u1>
        <li><a class="home" href="${createLink(uri: '/')}">Home</a></li>
        <li><g:link class="list" action="logout">Logout</g:link> </li>
        <li><g:link class="list" action="create">Registration</g:link> </li>
    </u1>
</div>
<div class="body">
    <h1>Login</h1>
    <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
    </g:if>
    <g:form action="authenticate" >
        <fieldset class="form">
            <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'login','error')}">
                <label>login:</label>
                <g:textField name="login" value="${userInstance?.login}"/>
            </div>
            <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password','error')}">
                <label>password:</label>
                <g:field type="password" name="password" value="${userInstance?.password}"/>
            </div>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="log_in" class="save" value="Login"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>