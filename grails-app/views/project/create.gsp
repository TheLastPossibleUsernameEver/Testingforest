<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <title>
        New project - TestingForest
    </title>
</head>
<body>
<div class="nav" role="navigation">
    <u1>
        <li><g:link class="list" action="index">Back</g:link> </li>
    </u1>
</div>
<div id="create-project" class="content scaffold-create" role="main">
    <g:form resource="${this.project}" method="POST">
        <fieldset class="form">
            <div class="fieldcontain ${hasErrors(bean: project, field: 'projectName','error')}">
                <label>Project name:</label>
                <g:textField name="projectName" value="${project.projectName}"/>
            </div>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="create" class="save" value="Create" />
        </fieldset>
    </g:form>
</div>
</body>
</html>