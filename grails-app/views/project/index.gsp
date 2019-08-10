<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <title>
        <g:message code="title.project.index"/>
    </title>
</head>
<body>
<div class="nav" role="navigation">
    <ul>
        <li><g:link class="list" uri="/feed/list">
            <g:message code="feed.list.label"/>
        </g:link></li>
        <li><g:link class="create" action="create">
            <g:message code="project.index.create.button"/>
        </g:link></li>
        <li><g:link class="list" uri="/user/showInfo">
            <g:message code="user.label.show.info"/>
        </g:link></li>
        <li><g:link class="list" uri="/user/logout">
            <g:message code="logout.label"/>
        </g:link></li>
    </ul>
</div>
<div>
    <g:if test="${params.sizeList == 0}">
        <h1><g:message code="project.label.no.project"/></h1>
    </g:if>
    <g:else>
        <table class="main">
            <thead>
            <tr>
                <td><g:message code="project.name.label.field"/></td>
                <td><g:message code="project.dateCreated.label.field"/></td>
                <td><g:message code="project.lastUpdated.label.field"/></td>
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
