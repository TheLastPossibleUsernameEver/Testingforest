<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <title>
        <g:message code="title.project.show"/>
    </title>
</head>
<body>
    <div class="nav border-bottom" role="navigation">
        <g:link class="btn btn-sm btn-outline-dark mt-2 mb-2 ml-2 mr-1" uri="/project/${params.projectId}/testCase/list">
            <g:message code="testCase.list.label.button"/>
        </g:link>
        <g:link class="btn btn-sm btn-outline-dark mt-2 mb-2 ml-2 mr-1" uri="/project/${this.project.id}/addUserProject">
            <g:message code="project.label.addUserToProject.button"/>
        </g:link>
    </div>
    <div class="h4 mt-3 mb-3 ml-5 ">
        <g:message code="project.label.show.info"/>
    </div>
    <form>
        <div class="form-group row ml-4">
            <label for="projectName" class="col-sm-2 ml-5 col-form-label">
                <g:message code="project.name.label.field"/>
            </label>
            <div class="form-control-plaintext col-sm-9">
                <g:fieldValue type="text" id="projectName" bean="${project}" field="projectName"/>
            </div>

            <label for="dateCreated" class="col-sm-2 ml-5 col-form-label">
                <g:message code="project.dateCreated.label.field"/>
            </label>
            <div class="form-control-plaintext col-sm-9">
                <g:formatDate id="dateCreated" date="${project.dateCreated}" type="datetime" style="SHORT"/>
            </div>

            <label for="lastUpdated" class="col-sm-2 ml-5 col-form-label">
                <g:message code="project.lastUpdated.label.field"/>
            </label>
            <div class="form-control-plaintext col-sm-9">
                <g:formatDate id="lastUpdated" date="${project.lastUpdated}" type="datetime" style="SHORT"/>
            </div>

            <label for="sizeTestCaseList" class="col-sm-2 ml-5 col-form-label">
                <g:message code="project.count.testcase.label.field"/>
            </label>
            <div id="sizeTestCaseList" class="form-control-plaintext col-sm-9">
                ${params.sizeTestCaseList}
            </div>

            <label for="teamList" class="col-sm-2 mb-1 ml-5 col-form-label">
                <g:message code="project.teamList.label.field"/>
            </label>
            <div id="teamList" class="form-control-plaintext col-sm-9">
                <ul style="list-style-position: inside;">
                    <g:each in="${project.teamList}">
                        <li>
                            <g:fieldValue bean="${it}" field="login" />
                        </li>
                    </g:each>
                </ul>
            </div>

            <div class="col-sm-2 mb-3 mt-2 ml-5">
                <g:link class="btn btn-sm btn-outline-info" uri="/project/edit/${params.projectId}">
                    <g:message code="project.edit.label.button"/>
                </g:link>
            </div>
        </div>
    </form>
    <div class="row ml-5 mb-4 mt-4">
        <g:form uri="/project/leaveProject/${params.projectId}" method="PUT">
            <g:submitButton class="btn btn-outline-danger"
                            name="leaveProject"
                            value="${message(code: 'project.leave.label.button')}"
                            onclick="return confirm('${message(code:
                                    'project.button.leave.confirm.message',
                                    args: [params.projectName])}');"/>
        </g:form>
        <g:form uri="/project/delete/${params.projectId}" method="DELETE">
            <g:submitButton class="btn ml-4 btn-outline-danger"
                            name="delete"
                            value="${message(code: 'project.delete.label.button')}"
                            onclick="return confirm('${message(code:
                                    'project.button.delete.confirm.message',
                                    args: [params.projectName])}');"/>
        </g:form>
    </div>
</body>
</html>
