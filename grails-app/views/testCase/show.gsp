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

    <div class="h4 mt-3 mb-3 ml-5 ">
        <g:message code="user.info.pageName"/>
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

            <label for="projectName" class="col-sm-2 ml-5 col-form-label">
                <g:message code="testCase.projectName.label.field"/>
            </label>
            <div class="form-control-plaintext col-sm-9">
                <g:fieldValue type="text" id="projectName" bean="${testCase.project}" field="projectName" />
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
            <div class="form-control-plaintext col-sm-9" style="text-align: center">
                <g:link id="fileDownload" url="/project/${testCase.project.id}/testCaseDocument/downloadDocument/${testCase.id}">
                    <g:img dir="images" file="download.png" width="30" height="30"/>
                </g:link>
            </div>



            <div class="col-sm-2 mb-3 mt-3 ml-5">
                <g:link class="btn btn-sm btn-outline-info" uri="/user/edit/${session.user.id}">
                    <g:message code="user.edit.label.button"/>
                </g:link>
            </div>
        </div>
    </form>

</body>
</html>