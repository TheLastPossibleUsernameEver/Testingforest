<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'testCaseDocument.label', default: 'TestCaseDocument')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div content-type="plain/text" src="${createLink(controller: 'testCaseDocument', action: 'showDocument',
                id:"${testCaseDocument.id}")}" width="300" heighth="400"></div>
            height="400">
        <a href src="${createLink(controller: 'testCaseDocument', action: 'downloadDocument',
                id:"${testCaseDocument.id}")}" download="Download">
        </a>
        <g:fieldValue field="type" bean="${testCaseDocument}"/>
        <g:fieldValue field="name" bean="${testCaseDocument}"/>
        <g:message code="TestCaseDocument.dateCreated.label" default="DateCreated"/>
    </body>
</html>
