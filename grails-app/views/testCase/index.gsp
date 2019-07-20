<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
</head>
<body>
<div id="list-case" class="content scaffold-list" role="main">
    <f:table collection="${testCaseList}"
             properties="['caseName', 'typeCase', 'sizeData', 'dateCreated','lastUpdated']" />
</div>
</body>
</html>