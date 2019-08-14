<html>
<head>
    <meta name="layout" content="signup" />
    <title><g:message code="title.user.registration"/></title>
</head>
<body class="text-center">
<g:form class="form-signup" resource="${this.user}" method="POST">
    <asset:image class="mx-auto d-block" src="Logo - Testing Forest Login.png"
                 alt="Testing Forest Logo" width="103,333" height="120"/>
    <div class="h4 mt-3 mb-3 font-weight-normal text-center" style="line-height: 140%">
        <g:message code="registration.label"/>
    </div>
    <g:if test="${flash.message}">
        <div class="alert alert-primary text-center" role="status">
            ${flash.message}
        </div>
    </g:if>
    <g:hasErrors bean="${this.user}">
        <ul class="alert alert-danger" style="list-style-position: inside;" role="alert">
            <g:eachError bean="${this.user}" var="error">
                <li>
                    <g:message error="${error}"/>
                </li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <div>
        <label for="inputName" class="sr-only">
            <g:message code="user.name.label.field"/>
        </label>
        <g:textField type="name" id="inputName"
                     class="form-control mb-2 ${hasErrors(bean: this.user, field: 'name','is-invalid')}"
                     placeholder="${message(code: 'user.name.label.field')}" name="name" value="${this.user?.name}"/>
    </div>
    <div>
        <label for="inputLogin" class="sr-only">
            <g:message code="user.login.label.field"/>
        </label>
        <g:textField type="login" id="inputLogin"
                     class="form-control mb-2 ${hasErrors(bean: this.user, field: 'login','is-invalid')}"
                     placeholder="${message(code: 'user.login.label.field')}" name="login" value="${this.user?.login}"/>
    </div>
    <div>
        <label for="inputPassword" class="sr-only">
            <g:message code="user.password.label.field"/>
        </label>
        <g:passwordField type="password" id="inputPassword"
                         class="form-control mb-2 ${hasErrors(bean: this.user, field: 'password','is-invalid')}"
                         placeholder="${message(code: 'user.password.label.field')}" name="password" value="${this.user?.password}"/>
    </div>
    <div>
        <label for="inputEmail" class="sr-only">
            <g:message code="user.email.label.field"/>
        </label>
        <g:textField type="email" id="inputEmail"
                     class="form-control mb-2 ${hasErrors(bean: this.user, field: 'email','is-invalid')}"
                     placeholder = "${message(code: 'user.email.label.field')}" name="email" value="${this.user?.email}"/>
    </div>
    <g:submitButton class="btn btn-lg btn-primary btn-block mt-4" name="create" value="${message(code: 'registration.label.button')}"/>
    <div class="nav justify-content-center mt-1">
        <g:link class="nav-link" action="log_in">
            <g:message code="login.link"/>
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
