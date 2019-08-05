package testingforest

class TestCase {

    String caseName
    String typeCase
    Date dateCreated
    Date lastUpdated

    static belongsTo = [project: Project]
    static hasOne = [userCreated: User, caseData: TestCaseDocument]

    static constraints = {
        caseName size: 1..255
        typeCase inList: ["public","private"]
    }
}
