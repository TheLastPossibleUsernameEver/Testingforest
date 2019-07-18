<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
</head>
<body>
<div class="nav" role="navigation">
    <ul>
        <li><g:link class="list" action="index">Back</g:link> </li>
        <li><g:link class="list" action="addUserProject">Add users to project</g:link></li>
    </ul>
</div>
<div id="show-project" class="content scaffold-show" role="main">
    <f:display bean="project" />
</div>
</body>
</html>
