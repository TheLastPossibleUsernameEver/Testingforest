<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <title>
        <g:message code="title.feed.list"/>
    </title>
</head>
<body class="bg-light">
    <main role="main" class="container">
        <div class="my-3 p-3 bg-white rounded shadow-sm">
            <div class="border-bottom border-gray pb-2 mb-0 h4 text-dark">
                <g:message code="feed.title.last.news"/>
            </div>
            <g:if test="${params.sizeList == 0}">
                <div class="h5 mt-3">
                    <g:message code="feed.label.no.news"/>
                </div>
            </g:if>
            <g:each in ="${feedList}">
                <div class="media text-muted pt-3">
                    <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray ">
                        <strong class="text-feed">
                            <g:if bean="${it}" test = "${it.testCase != null}">
                                <g:message bean="${it}" code="${it.feed}" args="${ [it.user.login, it.project.projectName, it.testCase]}"/>
                            </g:if>
                            <g:else>
                                <g:message bean="${it}" code="${it.feed}" args="${ [it.user.login, it.project.projectName, ""]}"/>
                            </g:else>
                            <strong class="right-side date-feed">
                            <g:formatDate format="HH:mm MM/dd" date="${it.dateCreated}" />
                            </strong>
                        </strong>
                    </p>
                </div>
            </g:each>
        </div>
    </main>
</body>
</html>
