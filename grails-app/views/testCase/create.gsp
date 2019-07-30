<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'user.label', default: 'Test-Case')}" />
</head>
<body>
<div class="nav" role="navigation">
    <u1>
        <li><g:link class="list" action="index">Back</g:link> </li>
    </u1>
</div>
<div id="create-testCase" class="content scaffold-create" role="main">
    <h1><g:message code="default.create.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${this.testCase}">
        <ul class="errors" role="alert">
            <g:eachError bean="${this.testCase}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}"> data-field-id="${error.field}" </g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form action="save">
        <fieldset class="form">
            <div class="fieldcontain ${hasErrors(bean: testCase, field: 'caseName','error')}">
                <label>Test-case name:</label>
                <g:textField name="caseName" value="${testCase.caseName}"/>
            </div>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="save" class="save" type="submit" value="Create test-case" />
        </fieldset>
    </g:form>
</div>
</body>
</html>