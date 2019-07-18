<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
</head>
<body>
<div class="nav" role="navigation">
    <ul>
        <li><g:link class="create" action="create">Create project</g:link></li>
    </ul>
</div>
<div id="list-project" class="content scaffold-list" role="main">
    <f:table collection="${projectList}"
             properties="['projectName', 'dateCreated']" />
</div>
</body>
</html>
