<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="feed" />
    <title>
        <g:message code="title.project.index"/>
    </title>
</head>
<body class="bg-light">
    <nav class="navbar fixed-top bg-dark shadow-sm">
        <div class="nav nav-underline">
            <a class="nav-link text-light bar-text-size" href="/feed/list">News</a>
            <a class="nav-link text-light bar-text-size" href="/project/index">Projects</a>
      </div>
    </nav>
    <main role="main" class="container">
        <div class="d-flex align-items-center p-3 my-3 rounded shadow-sm bg-dark">
            <asset:image class="mr-3" src="Logo - Testing Forest Login.png"
                         alt="Testing Forest Logo" width="48" height="55"/>
          <div>
             <h1 class="mb-3 text-light ">Новости</h1>
          </div>
        </div>
        <div class="my-3 p-3 bg-white rounded shadow-sm">
            <h6 class="border-bottom border-gray pb-2 mb-0 text-dark">Последние новости</h6>
            <g:if test="${params.sizeList == 0}">
                <h1><g:message code="project.label.no.project"/></h1>
            </g:if>
            <g:each in ="${feedList}">
                <div class="media text-muted pt-3">
                    <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                        <strong class="d-block user">
                            <a class="none-underline" href="/user/show/${it.user.id}">
                                <g:fieldValue bean="${it}" field="user.login" />
                            </a>
                            <br>
                        </strong>
                    <td>

                    <g:formatDate date="${it.dateCreated}" type="datetime" style="SHORT" />
                    </td>
                        <br><br>
                        <strong class="text-feed">
                        <b>
                        <g:fieldValue bean="${it}" field="feed" />
                        <a class="none-underline" href="/project/show/${it.project.id}">
                            <g:fieldValue bean="${it}" field="project.projectName" />
                        </a>
                        </b>
                        </strong>
                    </p>
                </div>
            </g:each>
        </div>
    </main>
</body>
</html>
