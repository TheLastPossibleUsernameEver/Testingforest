package testingforest

class TestCaseDocumentController {

    def download(Long testCaseId){
        TestCase testCase = TestCase.get(testCaseId)
        TestCaseDocument testCaseDocument = TestCaseDocument.get(testCase.getCaseData().getId())
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

}