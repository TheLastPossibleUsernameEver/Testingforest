<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
</head>
<body>
<div class="nav" role="navigation">
    <ul>
        <li>
            <g:link uri="/project/${params.projectId}/testCase/list">
                <g:message code="testCase.list.label.button"/>
            </g:link>
        </li>
        <li>
            <g:link uri="/project/${this.project.id}/addUserProject">
                <g:message code="project.label.addUserToProject.button"/>
            </g:link>
        </li>
        <li>
            <g:link uri="/user/logout">
                <g:message code="logout.label"/>
            </g:link>
        </li>
    </ul>
</div>
<div class="fieldcontain">
    <label>
        <g:message code="project.name.label.field"/>
    </label>
    <g:fieldValue bean="${project}" field="projectName" />
</div>
<div class="fieldcontain">
    <label>
        <g:message code="project.dateCreated.label.field"/>
    </label>
    <g:formatDate date="${project.dateCreated}" type="datetime" style="MEDIUM"/>
</div>
<div class="fieldcontain">
    <label>
        <g:message code="project.lastUpdated.label.field"/>
    </label>
    <g:formatDate date="${project.lastUpdated}" type="datetime" style="MEDIUM"/>
</div>
<div class="fieldcontain">
    <ul>
        <label class="property-label">
            <g:message code="project.teamList.label.field"/>
        </label>
        <g:each in="${project.teamList}">
            <li class="property-value">
                <g:fieldValue bean="${it}" field="login" />
            </li>
        </g:each>
    </ul>
</div>
<div class="fieldcontain">
    <label class="property-label">
        <g:message code="project.count.testcase.label.field"/>
    </label>
    ${params.sizeTestCaseList}
</div>
<div class="buttons">
    <g:form uri="/project/leaveProject/${params.projectId}" method="PUT">
        <g:submitButton name="leaveProject"
                        value="${message(code: 'project.leave.label.button')}"
                        onclick="return confirm('${message(code:
                                'project.button.leave.confirm.message',
                                args: [params.projectName])}');"/>
    </g:form>
    <g:form uri="/project/delete/${params.projectId}" method="DELETE">
        <g:submitButton name="delete"
                        value="${message(code: 'project.delete.label.button')}"
                        onclick="return confirm('${message(code:
                                'project.button.delete.confirm.message',
                                args: [params.projectName])}');"/>
    </g:form>
</div>
</body>
</html>
