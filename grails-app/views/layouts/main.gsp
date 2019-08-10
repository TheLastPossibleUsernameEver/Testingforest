<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Service for storing test-cases - Testing Forest"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <asset:link rel="icon" href="Logo - Testing Forest Favicon.png" type="image/x-png"/>
    <asset:stylesheet src="footer.css"/>
    <asset:stylesheet src="bootstrap.css"/>
    <asset:stylesheet src="main.css"/>
    <asset:javascript src="application.js"/>
    <g:layoutHead/>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light shadow-sm navbar-static-top">
        <div class="navbar-brand ml-2">
            <asset:image src="Logo - Testing Forest.png"
                         alt="Testing Forest Logo" width="269.522" height="50"/>
        </div>
        <div class="collapse navbar-collapse justify-content-end mr-3">
            <ul class="navbar-nav h6" style="font-size: 18px; font-family: 'Montserrat';">
                <li class="nav-item active mr-3">
                    <g:link class="nav-link"  controller="project" action="index">
                        <g:message code="header.project.label"/>
                    </g:link>
                </li>
                <li class="nav-item active mr-3">
                    <g:link class="nav-link" controller="feed" action="list">
                        <g:message code="header.news.label"/>
                    </g:link>
                </li>
                <li class="nav-item active">
                    <g:link class="nav-link" controller="user" action="logout">
                        <g:message code="header.signout.label"/>
                    </g:link>
                </li>
            </ul>
        </div>
    </nav>

    <g:layoutBody/>

    <footer class="footer shadow-lg text-muted" role = "contentinfo" style="text-align: center">
        <g:message code="footer"/>
        <a href="https://github.com/TheLastPossibleUsernameEver/testingforest">
            Github
        </a>
    </footer>
</body>
</html>
