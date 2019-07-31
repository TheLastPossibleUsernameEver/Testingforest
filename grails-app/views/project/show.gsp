<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <title>Project info - TestingForest</title>
</head>
<body>
<div class="nav" role="navigation">
    <ul>
        <li><g:link class="list" action="index">Back</g:link> </li>
        <li><g:link class="list" uri="/project/${this.project.id}/addUserProject">Add members to project</g:link></li>
    </ul>
</div>
<div id="show-project" class="content scaffold-show" role="main">
    <f:display bean="project" />
</div>
</body>
</html>
