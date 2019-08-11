<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'user.label', default: 'Test-Case')}" />
    <title>
        <g:message code="title.testCase.create"/>
    </title>
</head>
<body>
    <div class="nav border-bottom" role="navigation">
        <g:link class="btn btn-sm btn-outline-dark mt-2 mb-2 ml-2 mr-1" uri="/project/${params.projectId}/testCase/list">
            <g:message code="testCase.list.label.button"/>
        </g:link>
    </div>

    <div class="h4 mt-3 mb-3 ml-5 ">
        <g:message code="testCase.create.label"/>
    </div>

    <g:if test="${flash.message}">
        <div class="alert alert-primary " role="status">
            <div class="ml-4">
                ${flash.message}
            </div>
        </div>
    </g:if>

    <g:hasErrors bean="${this.testCase}">
        <ul class="alert alert-danger" style="list-style-position: inside;" role="alert">
            <div class="ml-4">
                <g:eachError bean="${this.testCase}" var="error">
                    <li <g:if test="${error in org.springframework.validation.FieldError}"> data-field-id="${error.field}" </g:if>>
                        <g:message error="${error}"/>
                    </li>
                </g:eachError>
            </div>
        </ul>
    </g:hasErrors>

    <g:hasErrors bean="${this.testCaseDocument}">
        <ul class="alert alert-danger" style="list-style-position: inside;" role="alert">
            <div class="ml-4">
                <g:eachError bean="${this.testCaseDocument}" var="error">
                    <li <g:if test="${error in org.springframework.validation.FieldError}"> data-field-id="${error.field}" </g:if>>
                        <g:message error="${error}"/>
                    </li>
                </g:eachError>
            </div>
        </ul>
    </g:hasErrors>



    <g:form action="save" enctype="multipart/form-data">
        <div>
            <label for="caseName" class="ml-5 mr-4">
                <g:message code="testCase.caseName.label.field"/>
            </label>
            <g:textField class="form-control ml-5 mb-3 col-sm-4 ${hasErrors(bean: testCase, field: 'caseName','is-invalid')}"
                         name="caseName" value="${testCase.caseName}"/>
        </div>

        <div>
            <label for="typeCase" class="ml-5 mr-4">
                <g:message code="testCase.typeCase.label.field"/>
            </label>
            <g:select class="form-control ml-5 mb-3 col-sm-4 ${hasErrors(bean: testCase, field: 'typeCase','is-invalid')}"
                      name="typeCase"
                      from="${testCase.getConstrainedProperties().typeCase.inList}"
                      value="${testCase.getConstrainedProperties().typeCase.inList[0]}"
                      valueMessagePrefix="testCase.type.label" />
        </div>

        <div class="ml-5 mb-2">
            <g:message code="testCaseDocument.data.label.field"/>
        </div>
        <div class="input-group ml-5 mb-4">
            <div class="custom-file col-sm-4">
                <label class="custom-file-label" for="data">
                    <g:message code="testCaseDocument.data.placeholder"/>
                </label>
                <input type="file" id="data" name="data"
                       class="custom-file-input col-sm-4"
                       code="testCaseDocument.upload"/>
            </div>
        </div>

        <script>
            $(".custom-file-input").on("change", function() {
                var fileName = $(this).val().split("\\").pop();
            });
        </script>

        <g:submitButton class="btn ml-5 mt-1 mb-4 btn-outline-success" name="save" value="${message(code: 'testCase.create.label.button')}" />
    </g:form>
</body>
</html>