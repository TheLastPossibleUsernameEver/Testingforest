<html>
<head>
    <meta name="layout" content="main">
    <title>
        <g:message code="title.project.addUserProject"/>
    </title>
</head>
<body>
    <div class="nav border-bottom" role="navigation">
        <g:link class="btn btn-sm btn-outline-dark mt-2 mb-2 ml-2 mr-1" uri="/project/show/${this.project.id}">
                <g:message code="project.label.show.info"/>
        </g:link>
    </div>

    <div class="h4 mt-3 mb-3 ml-5 ">
        <g:message code="project.label.addUserProject"/>
    </div>

    <g:if test="${flash.error}">
        <div class="alert alert-danger" role="alert">
            <div class="ml-4">
                ${flash.error}
            </div>
        </div>
    </g:if>
    <g:if test="${flash.message}">
        <div class="alert alert-primary " role="status">
            <div class="ml-4">
                ${flash.message}
            </div>
        </div>
    </g:if>

    <g:form action="addingUser" class="mt-3">
        <div>
            <label for="login" class="ml-5 mr-4">
                <g:message code="user.login.label.field"/>
            </label>
            <g:textField class="form-control ml-5 mb-4 col-sm-3"
                         name="login" value="${userInstance?.login}"/>
        </div>
        <g:submitButton class="btn ml-5 mt-1 mb-4 btn-outline-success" name="addUser"
                        value="${message(code: 'project.label.addUserProject')}" />
    </g:form>
</body>
</html>