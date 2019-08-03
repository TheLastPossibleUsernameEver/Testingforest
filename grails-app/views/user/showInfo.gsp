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
      <div class="content">
         <h1>
            <g:message code="user.info.pageName"/>
         </h1>
      </div>
      <div class="fields">
         <fieldset class="form">
            <div class="fieldcontain">
               <label>
                  <g:message code="user.info.name" />
               </label>
               <g:fieldValue bean="${session.user}" field="name" />
            </div>
            <div class="fieldcontain">
               <label>
                  <g:message code="user.info.login" />
               </label>
               <g:fieldValue bean="${session.user}" field="login" />
            </div>
            <div class="fieldcontain">
               <label >
                  <g:message code="user.info.regDate" />
               </label>
               <g:formatDate date="${session.user.dateCreated}" type="datetime" style="SHORT"/>
            </div>
         </fieldset>
      </div>
         <div class="content">
            <h1 >
               <g:message code="user.info.testCase.list.label" />
            </h1>
         <table>
            <tr>
               <th>
                  <g:message code="user.testcase.caseName" />
               </th>
               <th>
                  <g:message code="user.project.projectName" />
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
            </tr>
            <g:each var="testcase" in="${testCases}" >
               <tr>
                  <td>
                     <g:link uri="/testCase/show/${testcase.id}">
                        <g:fieldValue bean="${testcase}" field="caseName" />
                     </g:link>
                  </td>
                  <td>
                     <g:link uri="/project/show/${testcase.project.id}">
                        <g:fieldValue bean="${testcase.project}" field="projectName" />
                     </g:link>
                  </td>
                  <td>
                     <g:fieldValue bean="${testcase}" field="typeCase" />
                  </td>
                  <td>
                     <g:formatDate date="${testcase.dateCreated}" type="datetime" style="MEDIUM"/>
                  </td>
                  <td>
                     <g:formatDate date="${testcase.lastUpdated}" type="datetime" style="MEDIUM"/>
                  </td>
               </tr>
            </g:each>
         </table>
      </div>
      <fieldset class="buttons">
         <g:form uri="/user/deleteCurrentUser" method="DELETE">
            <g:submitButton name="delete"
                            value="${message(code: 'user.info.button.deleteAccount')}"
                            onclick="return confirm('${message(code:
                                    'user.button.delete.confirm.message')}')"/>
         </g:form>
      </fieldset>
   </body>
</html>
