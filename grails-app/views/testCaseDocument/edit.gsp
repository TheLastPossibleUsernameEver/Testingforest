<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'testCaseDocumentInstance.label', default: 'TestCaseDocument')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <g:form url="[resource:testCaseDocumentInstance, action:'update']"
                method="POST" enctype="multipart/form-data">
            <g:hiddenField name="version"
                           value="${testCaseDocumentInstance?.version}"/>
            <input type="file" id="data" name="data"/>

            <fieldset class="buttons">
                <g:actionSubmit value="${message(code:'default.button.update.label', default:
                        'Update')}"/>
            </fieldset>
        </g:form>
    </body>
</html>
