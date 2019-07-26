package testingforest

class TestCase {

    String caseName
    String typeCase
    Date dateCreated
    Date lastUpdated

    @Override
    String toString() {
        return caseName
    }

    static belongsTo = [project: Project]
    static hasOne = [userCreated: User, document: TestCaseDocument]

    static constraints = {
        caseName size: 1..255
        typeCase inList: ["public","protected","private"]
        document (blank:true, nullable:true)
    }
}
