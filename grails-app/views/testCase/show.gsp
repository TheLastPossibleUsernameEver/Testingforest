<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'testCase.label', default: 'TestCase')}" />
    <title>
            Test-case info - Testingforest
    </title>
</head>
<body>
<div id="show-testCase" class="content scaffold-show" role="main">
    <div class="nav" role="navigation">
        <ul>
            <li><g:link class="home" uri="/"><g:message code="default.home.label"/></g:link></li>
            <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        </ul>
    </div>
    <f:display bean="testCase" />
    <g:form resource="${this.testCase}" method="DELETE">
        <fieldset class="buttons">
            <g:link class="edit" action="edit" resource="${this.testCase}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
            <input class="delete" type="submit" value="Delete" />
        </fieldset>
    </g:form>
</div>
</body>
</html>