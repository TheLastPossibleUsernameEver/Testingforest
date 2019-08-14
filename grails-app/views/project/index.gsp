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
        <g:link class="btn btn-sm btn-outline-dark mt-2 mb-2 ml-2 mr-1" action="create">
            <g:message  code="project.index.create.button"/>
        </g:link>
        <g:link class="btn btn-sm btn-outline-dark mt-2 mb-2 ml-1 mr-2" uri="/user/showInfo">
            <g:message code="user.label.show.info"/>
        </g:link>
    </div>

    <div class="h4 mt-3 mb-3 ml-5">
        <g:message code="project.list.label"/>
    </div>

    <g:if test="${params.sizeList == 0}">
        <div class="h5 mt-3 mb-3 ml-5" style="font-weight: normal;">
            <g:message code="project.label.no.project"/>
        </div>
    </g:if>
    <g:else>
        <table class="table table-light shadow-sm">
            <thead class="bg-light">
            <tr>
                <th style="width: 30%"><g:message code="project.name.label.field"/></th>
                <th style="width: 15%"><g:message code="project.dateCreated.label.field"/></th>
                <th style="width: 15%"><g:message code="project.lastUpdated.label.field"/></th>
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
</body>
</html>
