<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <title>
        <g:message code="title.project.create"/>
    </title>
</head>
<body>
    <div class="nav border-bottom" role="navigation">
        <g:link class="btn btn-sm btn-outline-dark mt-2 mb-2 ml-2 mr-1 " action="index">
            <g:message code="project.list.label.button"/>
        </g:link>
    </div>
    <div class="h4 mt-3 mb-3 ml-5 ">
        <g:message code="project.create.label"/>
    </div>
    <g:hasErrors bean="${this.project}">
        <ul class="alert alert-danger" style="list-style-position: inside;" role="alert">
            <div class="ml-4">
            <g:eachError bean="${this.project}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}"> data-field-id="${error.field}" </g:if>><g:message error="${error}"/></li>
            </g:eachError>
            </div>
        </ul>
    </g:hasErrors>
    <g:form resource="${this.project}" class="mt-3" method="POST">
        <div>
            <label for="projectName" class="ml-5 mr-4">
                <g:message code="project.name.label.field"/>
            </label>
            <g:textField class="form-control ml-5 mb-4 col-sm-4 ${hasErrors(bean: project, field: 'projectName','is-invalid')}"
                         name="projectName" value="${project.projectName}"/>
        </div>
        <g:submitButton class="btn ml-5 mt-1 mb-4 btn-outline-success" name="create" value="${message(code: 'project.index.create.button')}" />
    </g:form>
</body>
</html>