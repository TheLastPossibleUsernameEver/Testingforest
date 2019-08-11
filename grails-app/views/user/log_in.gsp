<html>
    <head>
        <meta name="layout" content="signin" />
        <title><g:message code="title.user.authentication"/></title>
    </head>
    <body class="text-center">
        <g:form class="form-signin" controller="user" action="authenticate">
            <asset:image class="mx-auto d-block" src="Logo - Testing Forest Login.png"
                         alt="Testing Forest Logo" width="103,333" height="120"/>
            <h1 class="h3 mb-3 font-weight-normal text-center">
                <g:message code="login.label"/>
            </h1>
            <g:if test="${flash.error}">
                <div class="alert alert-danger text-center" role="alert">
                    ${flash.error}
                </div>
            </g:if>
            <g:if test="${flash.message}">
                <div class="alert alert-primary text-center" role="status">
                    ${flash.message}
                </div>
            </g:if>
            <div>
                <label for="inputLogin" class="sr-only">
                    <g:message code="user.login.label.field"/>
                </label>
                <g:textField type="login" id="inputLogin"
                             class="form-control mb-2 ${hasErrors(bean: userInstance, field: 'login','is-invalid')}"
                             placeholder="${message(code: 'user.login.label.field')}" name="login" value="${userInstance?.login}"/>
            </div>
            <div>
                <label for="inputPassword" class="sr-only">
                    <g:message code="user.password.label.field"/>
                </label>
                <g:passwordField type="password" id="inputPassword"
                                 class="form-control ${hasErrors(bean: userInstance, field: 'password','is-invalid')}"
                                 placeholder="${message(code: 'user.password.label.field')}" name="password" value="${userInstance?.password}"/>
            </div>
            <g:submitButton class="btn btn-lg btn-primary btn-block mt-4" name="log_in" value="${message(code: 'login.label.button')}"/>
            <div class="nav justify-content-center mt-1">
                <g:link class="nav-link" action="create">
                    <g:message code="registration.link"/>
                </g:link>
            </div>
            <p class="mt-5 mb-2 text-muted text-center">
                Testing Forest
                <br>
                2019
            </p>
        </g:form>
    </body>
</html>