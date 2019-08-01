<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'testCaseDocumentInstance.label', default: 'TestCaseDocument')}" />
        <title>
            <g:message code=""/>
        </title>
    </head>
    <body>
        <g:form url="[resource: testCaseDocument, action:'update']"
                method="POST" enctype="multipart/form-data">
            <g:hiddenField name="version"
                           value="${testCaseDocument?.version}"/>
            <input type="file" id="data" name="data"/>

            <fieldset class="buttons">
                <g:actionSubmit value="${message(code:'default.button.update.label', default:
                        'Update')}"/>
            </fieldset>
        </g:form>
    </body>
</html>
