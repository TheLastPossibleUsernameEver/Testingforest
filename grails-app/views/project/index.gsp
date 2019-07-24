<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
</head>
<body>
<div class="nav" role="navigation">
    <ul>
        <li><g:link class="create" action="create">Create project</g:link></li>
        <li><g:link class="list" uri="/user/show/${this.session.user.id}">User info</g:link></li>
        <li><g:link class="list" uri="/user/logout">Log out</g:link></li>
    </ul>
</div>
<div>
    <g:if test="${params.sizeList == 0}">
        <h1>You have no projects. Create it!</h1>
    </g:if>
    <g:else>
        <table class="main">
            <thead>
            <tr>
                <td>Name</td>
                <td>Date Created</td>
                <td>Last Updated</td>
            </tr>
            </thead>
            <tbody>
            <g:each in ="${projectList}">
                <tr>
                    <td>
                        <g:link url="/project/${it.id}/testCase/list">
                            <g:fieldValue bean="${it}" field="projectName" />
                        </g:link>
                    </td>
                    <td>
                        <g:formatDate date="${it.dateCreated}" type="datetime" style="SHORT" />
                    </td>
                    <td>
                        <g:formatDate date="${it.lastUpdated}" type="datetime" style="SHORT"/>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </g:else>
</div>
</body>
</html>
