<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title><g:message code="title.diagnostic"/></title>
    </head>
    <body>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="/">Home</a></li>
            </ul>
        </div>
		  <div id="list-userCase" class="content scaffold-list" role="main">
    <f:table collection="${userList}"
             properties="['login','name']" />
	Users Total:	<g:formatNumber number="${userCount}" type="number"/>
</div>
		
      <div id="list-testCase" class="content scaffold-list" role="main">
    <f:table collection="${testCaseList}"
             properties="['caseName','typeCase','sizeData']" />
	TestCases Total:	<g:formatNumber number="${testCaseCount}" type="number"/>
</div>
	<div id="list-project" class="content scaffold-list" role="main">
    <f:table collection="${projectList}"
             properties="['projectName']" />
	Projects Total:	<g:formatNumber number="${projectCount}" type="number"/>
</div>
    </body>
</html>