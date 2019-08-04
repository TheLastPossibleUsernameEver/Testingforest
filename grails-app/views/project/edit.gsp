<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <title>
        <g:message code="title.project.edit"/>
    </title>
</head>
<body>
<div class="nav" role="navigation">
    <ul>
        <li>
            <g:link uri="/project/show/${params.projectId}">
                <g:message code="project.show.label.button"/>
            </g:link>
        </li>
    </ul>
</div>
<div id="edit-user" class="content" role="main">
    <h1>
        <g:message code="project.edit.label"/>
    </h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">
            ${flash.message}
        </div>
    </g:if>
    <g:hasErrors bean="${this.project}">
        <ul class="errors" role="alert">
            <g:eachError bean="${this.project}" var="error">
                <li<g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>>
                 <g:message error="${error}"/>
                </li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form resource="${this.project}" method="PUT">
        <fieldset class="form">
            <div class="fieldcontain">
                <label>
                    <g:message code="project.name.label.field" />
                </label>
                <g:textField name="projectName" value="${project.projectName}" />
            </div>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="saveEdit" class="save" value="${message(code: 'project.edit.save.label.button')}"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>