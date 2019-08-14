<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <title>
        <g:message code="title.testCase.list"/>
    </title>
</head>
    <body>
        <div class="nav border-bottom" role="navigation" >
            <g:link class="btn btn-sm btn-outline-dark mt-2 mb-2 ml-2 mr-1" uri="/project/index">
                <g:message code="project.list.label.button"/>
            </g:link>
            <g:link class="btn btn-sm btn-outline-dark mt-2 mb-2 ml-2 mr-1" uri="/project/show/${params.projectId}">
                <g:message code="project.show.label.button"/>
            </g:link>
            <g:link class="btn btn-sm btn-outline-dark mt-2 mb-2 ml-2 mr-1" uri="/project/${params.projectId}/testCase/create">
                <g:message code="testCase.create.label.button"/>
            </g:link>
        </div>
        <div class="h4 mt-3 mb-3 ml-5 ">
            <g:message code="testCase.list.label" args="[params.projectName]"/>
        </div>
        <div role="main">
            <g:if test="${params.sizeTestCaseListFiltered == 0}">
                <div class="h5 mt-3 mb-3 ml-5" style="font-weight: normal;">
                    <g:message code="testCase.list.empty.label"/>
                </div>
            </g:if>
            <g:else>
                <table class="table table-light shadow-sm">
                    <thead class="bg-light">
                        <tr>
                            <th style="width: 20%" >
                                <g:message code="testCase.caseName.label.field"/>
                            </th>
                            <th style="width: 15%">
                                <g:message code="testCase.typeCase.label.field"/>
                            </th>
                            <th style="width: 17%">
                                <g:message code="testCase.sizeData.label.field"/>
                            </th>
                            <th style="width: 15%">
                                <g:message code="testCase.dateCreated.label.field"/>
                            </th>
                            <th style="width: 15%">
                                <g:message code="testCase.lastUpdated.label.field"/>
                            </th>
                            <th style="text-align: center; width: 15%">
                                <g:message code="testCaseDocument.download"/>
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <g:each in ="${params.testCaseListFiltered}">
                            <tr>
                                <td>
                                    <g:link url="/testCase/show/${it.id}">
                                        <g:fieldValue bean="${it}" field="caseName" />
                                    </g:link>
                                </td>
                                <td>
                                    <g:message code="testCase.type.label.${it.typeCase}"/>
                                </td>
                                <td>
                                    <g:fieldValue bean="${it}" field="caseData.sizeData" />
                                </td>
                                <td>
                                    <g:formatDate date="${it.dateCreated}" type="datetime" style="SHORT" />
                                </td>
                                <td>
                                    <g:formatDate date="${it.lastUpdated}" type="datetime" style="SHORT"/>
                                </td>
                                <td style="text-align: center">
                                    <g:link url="/project/${params.projectId}/testCaseDocument/downloadDocument/${it.id}">
                                        <g:img dir="images" file="download.png" width="30" height="30"/>
                                    </g:link>
                                </td>
                            </tr>
                        </g:each>
                    </tbody>
                </table>
            </g:else>
        </div>
    </body>
</html>
