package testingforest

class TestCaseDocument {

    String name
    String type
    byte[] data
    long sizeData

    static belongsTo = [testCase:TestCase]

    static constraints = {
        type blank:true
        name size: 0..255
        sizeData min: new Long(1), max: new Long( 5252880) // 5MB
    }
}
