<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title>
            <g:message code="title.user.edit"/>
        </title>
    </head>
    <body>
        <div class="nav" role="navigation">
            <ul>
                <li>
                    <g:link uri="/user/showInfo">
                        <g:message code="user.label.show.info"/>
                    </g:link>
                </li>
                <li>
                    <g:link uri="/user/logout">
                        <g:message code="logout.label"/>
                    </g:link>
                </li>
            </ul>
        </div>
        <div id="edit-user" class="content" role="main">
            <h1>
                <g:message code="user.edit.label"/>
            </h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">
                    ${flash.message}
                </div>
            </g:if>
            <g:hasErrors bean="${this.user}">
                <ul class="errors" role="alert">
                    <g:eachError bean="${this.user}" var="error">
                        <li<g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>>
                            <g:message error="${error}"/>
                        </li>
                    </g:eachError>
                </ul>
            </g:hasErrors>
            <g:form resource="${this.user}" method="PUT">
                <fieldset class="form">
                    <div class="fieldcontain">
                        <label>
                            <g:message code="user.name.label.field" />
                        </label>
                        <g:textField name="name" value="${user.name}" />
                    </div>
                    <div class="fieldcontain">
                        <label>
                            <g:message code="user.login.label.field" />
                        </label>
                        <g:textField name="login" value="${user.login}" />
                    </div>
                    <div class="fieldcontain">
                        <label>
                            <g:message code="user.password.label.field" />
                        </label>
                        <g:passwordField name="password"/>
                    </div>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="saveEdit" class="save" value="${message(code: 'user.edit.save.label.button')}"/>
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
