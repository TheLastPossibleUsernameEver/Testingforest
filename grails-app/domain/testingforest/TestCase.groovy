package testingforest

class TestCase {

    String caseName
    String typeCase
    Long sizeData
    Date dateCreated
    Date lastUpdated

    @Override
    String toString() {
        return caseName
    }

    static belongsTo = [project: Project]
    static hasOne = [userCreated: User]

    static constraints = {
        caseName range: 1..255
        typeCase inList: ["public","protected","private"]
        sizeData min: new Long(0)
    }
}
