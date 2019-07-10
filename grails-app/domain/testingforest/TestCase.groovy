package testingforest

class TestCase {

    String caseName
    String typeCase
    Long sizeData

    static belongsTo = [project : Project]
    static hasOne = [userCreated: User]

    static mapping = {
        autoTimestamp true
    }

    static constraints = {
        caseName range: 1..255
        typeCase inList: ["public","protected","private"]
        sizeData min: new Long(0)
    }
}
