<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title>
            <g:message code="title.user.edit"/>
        </title>
    </head>
    <body>
        <div class="nav border-bottom" role="navigation">
            <g:link class="btn btn-sm btn-outline-dark mt-2 mb-2 ml-2 mr-1 " uri="/user/showInfo">
                <g:message code="user.label.show.info"/>
            </g:link>
        </div>
    <div class="h4 mt-3 mb-3 ml-5 ">
        <g:message code="user.edit.label"/>
    </div>
    <g:if test="${flash.message}">
        <div  class="alert alert-primary ml-4" role="status">
            ${flash.message}
        </div>
    </g:if>
    <g:hasErrors bean="${this.user}">
        <ul class="alert alert-danger" style="list-style-position: inside;" role="alert">
        <g:eachError bean="${this.user}" var="error">
            <li<g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>>
            <g:message error="${error}"/>
            </li>
        </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form resource="${this.user}" class="mt-3" method="PUT">
        <div>
            <label class="ml-5 mr-4">
                <g:message code="user.name.label.field" />
            </label>
            <g:textField class="form-control ml-5 mb-4 col-sm-4 ${hasErrors(bean: user, field: 'name','is-invalid')}"
                         name="name" value="${user.name}" />
        </div>
        <div>
            <label class="ml-5 mr-4">
                <g:message code="user.login.label.field" />
            </label>
            <g:textField class="form-control ml-5 mb-4 col-sm-4 ${hasErrors(bean: user, field: 'login','is-invalid')}"
                         name="login" value="${user.login}" />
        </div>
        <div>
            <label class="ml-5 mr-4">
            <g:message code="user.password.label.field" />
        </label>
            <g:passwordField class="form-control ml-5 mb-4 col-sm-4 ${hasErrors(bean: user, field: 'password','is-invalid')}"
                             name="password"/>
        </div>
        <g:submitButton class="btn ml-5 mt-1 mb-4 btn-outline-success" name="saveEdit" value="${message(code: 'user.edit.save.label.button')}"/>
    </g:form>
    </body>
</html>
