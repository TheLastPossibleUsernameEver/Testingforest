<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <title>
        <g:message code="title.testCase.show"/>
    </title>
</head>
<body>
    <div class="nav border-bottom" role="navigation">
        <g:link class="btn btn-sm btn-outline-dark mt-2 mb-2 ml-2 mr-1" uri="/project/${params.projectId}/testCase/list">
            <g:message code="testCase.list.label.button"/>
        </g:link>
    </div>

    <div class="h4 mt-3 mb-3 ml-5 ">
        <g:message code="testCase.show.label"/>
    </div>

    <form>
        <div class="form-group row ml-4">
            <label for="caseName" class="col-sm-2 ml-5 col-form-label">
                <g:message code="testCase.caseName.label.field"/>
            </label>
            <div class="form-control-plaintext col-sm-9">
                <g:fieldValue type="text" id="caseName" bean="${testCase}" field="caseName" />
            </div>

            <label for="typeCase" class="col-sm-2 ml-5 col-form-label">
                <g:message code="testCase.typeCase.label.field"/>
            </label>
            <div class="form-control-plaintext col-sm-9">
                <g:fieldValue type="text" id="typeCase" bean="${testCase}" field="typeCase" />
            </div>

            <label for="projectName" class="col-sm-2 ml-5 col-form-label">
                <g:message code="testCase.projectName.label.field"/>
            </label>
            <div class="form-control-plaintext col-sm-9">
                <g:fieldValue type="text" id="projectName" bean="${testCase.project}" field="projectName" />
            </div>

            <label for="lastUpdated" class="col-sm-2 ml-5 col-form-label">
                <g:message code="testCase.lastUpdated.label.field"/>
            </label>
            <div class="form-control-plaintext col-sm-9">
                <g:fieldValue type="text" id="lastUpdated" bean="${testCase}" field="lastUpdated" />
            </div>

            <label for="userName" class="col-sm-2 ml-5 col-form-label">
                <g:message code="testCase.userCreated.label.field"/>
            </label>
            <div class="form-control-plaintext col-sm-9">
                <g:fieldValue type="text" id="userName" bean="${testCase.userCreated}" field="name" />
            </div>


            <label for="fileName" class="col-sm-2 h6 mt-3 mb-0 ml-5 col-form-label">
                <g:message code="testCaseDocument.file.label"/>
            </label>
            <div class="form-control-plaintext col-sm-9">
            </div>


            <label for="fileName" class="col-sm-2 ml-5 col-form-label">
                <g:message code="testCase.fileName.label.field"/>
            </label>
            <div class="form-control-plaintext col-sm-9">
                <g:fieldValue type="text" id="fileName" bean="${testCase.caseData}" field="name" />
            </div>

            <label for="fileType" class="col-sm-2 ml-5 col-form-label">
                <g:message code="testCase.fileType.label.field"/>
            </label>
            <div class="form-control-plaintext col-sm-9">
                <g:fieldValue type="text" id="fileType" bean="${testCase.caseData}" field="type" />
            </div>

            <label for="fileSize" class="col-sm-2 ml-5 col-form-label">
                <g:message code="testCase.sizeData.label.field"/>
            </label>
            <div class="form-control-plaintext col-sm-9">
                <g:fieldValue type="text" id="fileSize" bean="${testCase.caseData}" field="sizeData" />
            </div>

            <label for="fileDownload" class="col-sm-2 ml-5 col-form-label">
                <g:message code="testCaseDocument.download"/>
            </label>
            <div class="form-control-plaintext col-sm-9" style="text-align: left">
                <g:link id="fileDownload" url="/project/${testCase.project.id}/testCaseDocument/downloadDocument/${testCase.id}">
                    <g:img dir="images" file="download.png" width="25" height="25"/>
                </g:link>
            </div>

            <div class="col-sm-10 mt-3 ml-5">
                <g:link class="btn btn-outline-info" uri="/testCase/edit/${testCase.id}">
                    <g:message code="testCase.edit.label.button"/>
                </g:link>
            </div>
        </div>
    </form>
    <div class="row mb-3 ml-4">
        <g:form class="col-sm-10  ml-5" uri="/testCase/delete/${testCase.id}" method="DELETE">
            <g:submitButton class="btn btn-outline-danger"
                            name="delete"
                            value="${message(code: 'testCase.delete.label.button')}"
                            onclick="return confirm('${message(code:
                                    'testCase.button.delete.confirm.message',
                                    args: [testCase.caseName])}');"/>
        </g:form>
    </div>
</body>
</html>