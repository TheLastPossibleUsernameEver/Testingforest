<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'testCaseDocument.label', default: 'Document')}" />
    <title>Document upload - TestingForest</title>
</head>
<body>
    <g:form url="[resource: testCaseDocument, action:'save']" enctype="multipart/form-data">
        <input type="file" id="data" name="data" value="Upload your file"/>
        <input type="submit" value="upload"/>
        <fieldset class="buttons">
    </g:form>
</body>
</html>
