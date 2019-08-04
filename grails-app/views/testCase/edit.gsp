<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'testCase.label', default: 'TestCase')}" />
    <title>
        <g:message code="title.testCase.edit"/>
    </title>
</head>
<body>
<div class="nav" role="navigation">
    <ul>
        <li>
            <g:link class="home" uri="/">
                <g:message code="project.list.label.button"/>
            </g:link>
        </li>
        <li><g:link class="list" uri="/project/${session.projectId}/testCase/list">
            <g:message code="testCase.list.label.button"/>
            </g:link>
        </li>
        <li>
            <g:link uri="/user/logout">
                <g:message code="logout.label"/>
            </g:link>
        </li>
    </ul>
</div>
<div id="edit-testCase" class="content scaffold-edit" role="main">
    <h1><g:message code="testCase.edit.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${this.testCase}">
        <ul class="errors" role="alert">
            <g:eachError bean="${this.testCase}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form resource="${this.testCase}" method="PUT">
        <fieldset class="form">
            <div class="fieldcontain ${hasErrors(bean: testCase, field: 'caseName','error')}">
                <label><g:message code="testCase.caseName.label.field"/></label>
                <g:textField name="caseName" value="${testCase.caseName}"/>
            </div>
        </fieldset>
        <fieldset class="buttons">
            <input class="save" type="submit" value="${message(code: 'testCase.save.label.button', default: 'Update')}" />
        </fieldset>
    </g:form>
</div>
</body>
</html>
