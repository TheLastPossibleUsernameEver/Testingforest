<html>
   <head>
      <meta name="layout" content="main" />
      <title>
         <g:message code="user.info.pageName" />
      </title>
   </head>
   <body>
      <div class="nav" role="navigation">
         <u1>
            <li>
               <g:link class="list" uri="/user/logout">
                  <g:message code="logout.label"/>
               </g:link>
            </li>
            <li>
               <g:link class="list" uri="/project/index">
                  <g:message code="user.info.button.projectList"/>
               </g:link>
            </li>
         </u1>
      </div>
      <div class="body">
         <div class="fields">
            <h1>
               <g:message code="user.info.pageName" />
            </h1>
            <hr>
            <fieldset class="form">
               <p>
                  <g:message code="user.info.login" />
               </p>
               <p>
                  <g:textField readonly="true"  name="login"  value="${session.user.login}" />
               </p>
               <p>
                  <g:message code="user.info.name" />
               </p>
               <p>
                  <g:textField readonly="true"  name="name"  value="${session.user.name}" />
               </p>
               <p>
                  <g:message code="user.info.regDate" />
               </p>
               <p>
                  <g:textField readonly="true"  name="regDate"  value="${session.user.dateCreated}" />
               </p>
         </div>
         </fieldset>
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
         <h4>
            <g:message code="user.info.testcases" />
         </h4>
         <hr>
         <table>
            <th>
               <g:message code="user.testcase.caseName" />
            </th>
            <th>
               <g:message code="user.testcase.type" />
            </th>
            <th>
               <g:message code="user.testcase.dateCreated" />
            </th>
            <th>
               <g:message code="user.testcase.lastUpdated" />
            </th>
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
      </div>
      <fieldset class="button">
         <g:form uri="/user/deleteCurrentUser" method="DELETE">
            <g:submitButton name="delete" 
               value="${message(code: 'user.info.button.deleteAccount')}"
               onclick="return confirm('${message(code:
               'user.button.delete.confirm.message')}')"/>
         </g:form>
      </fieldset>
   </body>
</html>
