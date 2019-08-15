<html>
   <head>
      <meta name="layout" content="main" />
      <title>
         <g:message code="user.info.pageName" />
      </title>
   </head>
   <body>
      <div class="nav border-bottom" role="navigation">
         <g:link class="btn btn-sm btn-outline-dark mt-2 mb-2 ml-2 mr-1" uri="/project/index">
            <g:message code="user.info.button.projectList"/>
         </g:link>
      </div>
      <div class="h4 mt-3 mb-3 ml-5 ">
         <g:message code="user.info.pageName"/>
      </div>
      <form>
         <div class="form-group row ml-4">
            <label for="name" class="col-sm-2 ml-5 col-form-label">
               <g:message code="user.info.name"/>
            </label>
            <div class="form-control-plaintext col-sm-9">
               <g:fieldValue type="text" id="name" bean="${session.user}" field="name" />
            </div>

            <label for="login" class="col-sm-2 ml-5 col-form-label">
               <g:message code="user.info.login"/>
            </label>
            <div class="form-control-plaintext col-sm-9">
               <g:fieldValue type="text" id="login" bean="${session.user}" field="login" />
            </div>

            <label for="dateCreated" class="col-sm-2 mb-1 ml-5 col-form-label">
               <g:message code="user.info.regDate"/>
            </label>
            <div class="form-control-plaintext col-sm-9">
               <g:formatDate id="dateCreated" date="${session.user.dateCreated}" type="datetime" style="SHORT"/>
            </div>

            <div class="col-sm-2 mb-3 mt-3 ml-5">
               <g:link class="btn btn-sm btn-outline-info" uri="/user/edit/${session.user.id}">
                  <g:message code="user.edit.label.button"/>
               </g:link>
            </div>
         </div>
      </form>

      <div class="mt-4">
         <div class="h5 mt-3 mb-3 ml-5 ">
            <g:message code="user.info.testCase.list.label" />
         </div>
         <table class="table table-light shadow-sm">
            <thead class="bg-light">
               <tr>
                  <th style="width: 20%"><g:message code="user.testcase.caseName"/></th>
                  <th style="width: 20%"><g:message code="user.project.projectName"/></th>
                  <th style="width: 3%"><g:message code="user.testcase.type"/></th>
                  <th style="width: 8%"><g:message code="user.testcase.sizeData"/></th>
                  <th style="width: 8%"><g:message code="user.testcase.dateCreated"/></th>
                  <th style="width: 10%"><g:message code="user.testcase.lastUpdated"/></th>
                  <th style="text-align: center; width: 10%"><g:message code="testCaseDocument.download"/></th>
               </tr>
            </thead>
            <tbody>
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
                        <g:message code="testCase.type.label.${testcase.typeCase}"/>
                     </td>
                     <td>
                        <g:fieldValue bean="${testcase}" field="caseData.sizeData" />
                     </td>
                     <td>
                        <g:formatDate date="${testcase.dateCreated}" type="datetime" style="SHORT"/>
                     </td>
                     <td>
                        <g:formatDate date="${testcase.lastUpdated}" type="datetime" style="SHORT"/>
                     </td>
                     <td style="text-align: center">
                        <g:link url="/project/${testcase.project.id}/testCaseDocument/downloadDocument/${testcase.id}">
                           <g:img dir="images" file="download.png" width="25" height="25"/>
                        </g:link>
                     </td>
                  </tr>
               </g:each>
            </tbody>
         </table>
      </div>
      <div class="ml-5 mb-4 mt-4">
         <g:form uri="/user/deleteCurrentUser" method="DELETE">
            <g:submitButton class="btn btn-outline-danger"
                            name="delete"
                            value="${message(code: 'user.info.button.deleteAccount')}"
                            onclick="return confirm('${message(code:
                                    'user.button.delete.confirm.message')}')"/>
         </g:form>
      </div>
   </body>
</html>
