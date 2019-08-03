package testingforest


class TestCaseInterceptor {

    int order = LOWEST_PRECEDENCE

    TestCaseInterceptor() {
        match(controller: "testCase", action: "show")
        match(controller: "testCase", action: "edit")
    }

    boolean before() {
        TestCase testCase = TestCase.get(params.testCaseId)
        if (testCase.typeCase == "public" ||
                ( testCase.typeCase == "private" && testCase.userCreated.id == session.user.id)) {
            true
        } else {
            redirect uri: "/project/index"
            false
        }
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
