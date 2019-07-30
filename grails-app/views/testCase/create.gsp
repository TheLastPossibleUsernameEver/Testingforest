<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
</head>
<body>
<div class="nav" role="navigation">
    <u1>
        <li>
            <g:link uri="/project/${projectId}/testCase/list">
                <g:message code="testCase.list.label.button"/>
            </g:link>
        </li>
    </u1>
</div>
<div id="create-testCase" class="content scaffold-create" role="main">
    <h1>
        <g:message code="testCase.create.label"/>
    </h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">
            ${flash.message}
        </div>
    </g:if>
    <g:hasErrors bean="${this.testCase}">
        <ul class="errors" role="alert">
            <g:eachError bean="${this.testCase}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}"> data-field-id="${error.field}" </g:if>>
                    <g:message error="${error}"/>
                </li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form action="save">
        <fieldset class="form">
            <div class="fieldcontain ${hasErrors(bean: testCase, field: 'caseName','error')}">
                <label>
                    <g:message code="testCase.caseName.label.field"/>
                </label>
                <g:textField name="caseName" value="${testCase.caseName}"/>
            </div>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="save"  value="${message(code: 'testCase.create.label.button')}" />
        </fieldset>
    </g:form>
</div>
</body>
</html>