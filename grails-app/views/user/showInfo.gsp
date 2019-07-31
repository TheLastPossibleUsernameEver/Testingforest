<html>
<head>
    <meta name="layout" content="main" />
    <title>User Info</title>
</head>
<body>

<div class="nav" role="navigation">
    <u1> 
       <li><a class="list" href="/user/logout"><g:message code="logout.label"/></a></li> 
       <li><a class="list" href="/project/index"><g:message code="user.info.button.projectList"/></a></li> 
    </u1>
</div>
<div class="body">     
    <h1>
      <g:message code="user.info.pageName" />
    </h1>
<hr>
    <p>
        <g:message code="user.info.login" /> 
     </p> 
      <p>
        <g:field readonly="true"  name="login"  value="${session.user.login}" />
     </p>
     <p> 
      <g:message code="user.info.name" />
     </p>
     <p>  
      <g:field readonly="true"  name="name"  value="${session.user.name}" />
     </p>
    <p> 
     <g:message code="user.info.regDate" />
     </p>
     <p>
       <g:field readonly="true"  name="regDate"  value="${session.user.dateCreated}" /> 
      </p>  
<hr>    
<table>
<th>
<g:message code="user.info.button.projectList"/>
</th>
  <g:each var="project" in="${projects}" >
         <tr>
           <td>
             <g:link url="/project/show/${project.id}">  ${project.projectName}                         
             </g:link>
           </td>
         </tr>
      </g:each>
</table>
<h4><g:message code="user.info.testcases" /></h4>
<hr>
<table>
      <th>
      <g:message code="user.testcase.caseName" /></th>
      <th><g:message code="user.testcase.type" /></th>
      <th><g:message code="user.testcase.dateCreated" /></th>
      <th><g:message code="user.testcase.lastUpdated" /></th>
      <g:each var="testcase" in="${testCases}" >
         <tr>
           <td>
             <g:link url="/testCase/show/${testcase.id}">  ${testcase.caseName}                         
             </g:link>
           </td>
           <td>${testcase.typeCase}</td>
           <td>${testcase.dateCreated}</td>
           <td>${testcase.lastUpdated}</td>
         </tr>
      </g:each>
</table>
</div>
  <g:form uri="/user/deleteCurrentUser" method="DELETE">
        <g:submitButton name="delete"
                        value="${message(code: 'user.info.button.deleteAccount')}"
                        onclick="return confirm('${message(code:
                                'user.button.delete.confirm.message',
                                args: [params.projectName])}');"/>
   </g:form>
</div>
</body>
</html>
