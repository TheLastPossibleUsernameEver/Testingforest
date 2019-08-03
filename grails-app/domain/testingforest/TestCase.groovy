package testingforest

class TestCase {

    String caseName
    String typeCase
    Long sizeData
    Date dateCreated
    Date lastUpdated

    static belongsTo = [project: Project]
    static hasOne = [userCreated: User]

    static constraints = {
        caseName size: 1..255
        typeCase inList: ["public","private"]
        sizeData min: new Long(0)
    }
}
