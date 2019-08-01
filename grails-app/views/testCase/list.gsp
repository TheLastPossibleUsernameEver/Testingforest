<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <title>
        <g:message code="title.testCase.list"/>
    </title>
</head>
    <body>
        <div class="nav" role="navigation" >
            <ul>
                <li>
                    <g:link uri="/project/index">
                        <g:message code="project.list.label.button"/>
                    </g:link>
                </li>
                <li>
                    <g:link uri="/project/show/${params.projectId}">
                        <g:message code="project.show.label.button"/>
                    </g:link>
                </li>
                <li>
                    <g:link uri="/project/${params.projectId}/testCase/create">
                        <g:message code="testCase.create.label.button"/>
                    </g:link>
                </li>
                <li>
                    <g:link uri="/user/logout">
                        <g:message code="logout.label"/>
                    </g:link>
                </li>
            </ul>
        </div>
        <div class="content" role="main">
            <h1>
                <g:message code="testCase.list.label" args="[params.projectName]"/>
            </h1>
            <g:if test="${params.sizeTestCaseList == 0}">
                <label>
                    <g:message code="testCase.list.empty.label"/>
                </label>
            </g:if>
            <g:else>
                <table class="main">
                    <thead>
                        <tr>
                            <th>
                                <g:message code="testCase.caseName.label.field"/>
                            </th>
                            <th>
                                <g:message code="testCase.typeCase.label.field"/>
                            </th>
                            <th>
                                <g:message code="testCase.sizeData.label.field"/>
                            </th>
                            <th>
                                <g:message code="testCase.dateCreated.label.field"/>
                            </th>
                            <th>
                                <g:message code="testCase.lastUpdated.label.field"/>
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <g:each in ="${testCaseSet}">
                            <tr>
                                <td>
                                    <g:link url="/testCase/show/${it.id}">
                                        <g:fieldValue bean="${it}" field="caseName" />
                                    </g:link>
                                </td>
                                <td>
                                    <g:fieldValue bean="${it}" field="typeCase" />
                                </td>
                                <td>
                                    <g:fieldValue bean="${it}" field="sizeData" />
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
