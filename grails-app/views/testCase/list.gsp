<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
</head>
<body>
<div>
    <table class="main">
        <thead>
            <tr>
                <td>Name</td>
                <td>Type</td>
                <td>Date Created</td>
                <td>Last Updated</td>
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
                        <g:formatDate date="${it.dateCreated}" type="datetime" style="SHORT" />
                    </td>
                    <td>
                        <g:formatDate date="${it.lastUpdated}" type="datetime" style="SHORT"/>
                    </td>
                </tr>
            </g:each>
        </tbody>
    </table>
</div>
</body>
</html>