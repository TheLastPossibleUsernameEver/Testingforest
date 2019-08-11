<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <title>
        <g:message code="title.project.create"/>
    </title>
</head>
<body>
<div class="nav" role="navigation">
    <u1>
        <li>
            <g:link class="list" action="index">
                <g:message code="project.list.label.button"/>
            </g:link>
        </li>
    </u1>
</div>
<g:hasErrors bean="${this.project}">
    <ul class="errors" role="alert">
        <g:eachError bean="${this.project}" var="error">
            <li <g:if test="${error in org.springframework.validation.FieldError}"> data-field-id="${error.field}" </g:if>><g:message error="${error}"/></li>
        </g:eachError>
    </ul>
</g:hasErrors>
<div id="create-project" class="content scaffold-create" role="main">
    <g:form resource="${this.project}" method="POST">
        <fieldset class="form">
            <div class="fieldcontain ${hasErrors(bean: project, field: 'projectName','error')}">
                <label>
                    <g:message code="project.name.label.field"/>
                </label>
                <g:textField name="projectName" value="${project.projectName}"/>
            </div>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="create" class="save" value="${message(code: 'project.index.create.button')}" />
        </fieldset>
    </g:form>
</div>
</body>
</html>