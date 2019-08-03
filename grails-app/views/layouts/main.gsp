<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Hub web-service for storing and managing test-cases - TestingForest"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
    <asset:stylesheet src="application.css"/>
    <g:layoutHead/>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark navbar-static-top" role="navigation">
    <a class="navbar-brand" href="/#"><asset:image src="grails.svg" alt="Grails Logo"/></a>
</nav>
<g:layoutBody/>
<div class="footer" role = "contentinfo" style="text-align: center">
    <table>
        <tr>
        <p><g:message code="footer"/></p>
        <a href="https://github.com/TheLastPossibleUsernameEver/testingforest"><g:message code="github"/></a>
        </tr>
    </table>
</div>
<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>
<asset:javascript src="application.js"/>
</body>
</html>
