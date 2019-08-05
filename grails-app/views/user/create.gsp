<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="title.user.registration"/></title>
    </head>
    <body>
        <div class="nav" role="navigation">
            <ul>
                <li>
                    <g:link action="log_in">
                        <g:message code="login.label.button"/>
                    </g:link>
                </li>
            </ul>
        </div>
        <div class="content" role="main">
            <h1>
                <g:message code="registration.label"/>
            </h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">
                    ${flash.message}
                </div>
            </g:if>
            <g:hasErrors bean="${this.user}">
                <ul class="errors" role="alert">
                    <g:eachError bean="${this.user}" var="error">
                        <li>
                            <g:message error="${error}"/>
                        </li>
                    </g:eachError>
                </ul>
            </g:hasErrors>
            <g:form resource="${this.user}" method="POST">
                <fieldset class="form">
                    <div class="fieldcontain ${hasErrors(bean: this.user, field: 'name','error')}">
                        <label>
                            <g:message code="user.name.label.field"/>
                        </label>
                        <g:textField name="name" value="${this.user?.name}"/>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: this.user, field: 'login','error')}">
                        <label>
                            <g:message code="user.login.label.field"/>
                        </label>
                        <g:textField name="login" value="${this.user?.login}"/>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: this.user, field: 'password','error')}">
                        <label>
                            <g:message code="user.password.label.field"/>
                        </label>
                        <g:passwordField name="password" value="${this.user?.password}"/>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: this.user, field: 'passwordRepeat','error')}">
                        <label>
                            <g:message code="user.passwordRepeat.label.field"/>
                        </label>
                        <g:passwordField name="passwordRepeat" value="${this.user?.password}"/>
                    </div>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" value="${message(code: 'registration.label.button')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
