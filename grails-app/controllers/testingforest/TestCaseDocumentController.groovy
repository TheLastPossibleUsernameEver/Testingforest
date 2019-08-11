package testingforest

class TestCaseDocumentController {

    def download(Long testCaseId){
        TestCaseDocument testCaseDocument = TestCaseDocument.get(testCaseId)
        if (testCaseDocument == null) {
            log.error("Error downloading file ${testCaseDocument.name}: file not found")

            flash.error = message(code:"data.error")
            redirect (uri:"/project/${session.projectId}/testCase/list")
        } else {
            response.setContentType("APPLICATION/OCTET-STREAM")
            response.setHeader("Content-Disposition",
                    "Attachment;Filename=\"${testCaseDocument.name}\"")

            def outputStream = response.getOutputStream()
            outputStream << testCaseDocument.data
            outputStream.flush()
            outputStream.close()
            log.info("Downloading ${testCaseDocument.name}")
        }
    }

    def update (Long testCaseId, Long testCaseDocumentId){
        def uploadedFile = params.data
        TestCaseDocument testCaseDocument = TestCaseDocument.get(testCaseDocumentId)
        def testCase = session.testCase
        if (uploadedFile != null) {

            testCaseDocument.data = uploadedFile.getBytes()
            testCaseDocument.name = uploadedFile.originalFilename
            testCaseDocument.type = uploadedFile.contentType
            testCaseDocument.length = testCaseDocument.data.length
            testCase.setCaseData(testCaseDocument)
            testCaseDocument.setTestCase(testCase)
        }
        if (testCase.validate()) {
            if (testCaseDocument.validate()){
                testCaseDocument.save(flush:true)
                testCase.save(flush:true)
                flash.message = message(code: "testCase.create.success.message", args: [testCase.caseName])
                redirect uri: "/project/${session.projectId}/testCase/create"
            } else {
                respond testCaseDocument.errors, view: "create"

            }
        } else {
            respond testCase.errors, view: 'create'
        }
    }
}