package testingforest

class TestCaseDocument {

    String name
    String type
    byte[] data
    long sizeData

    static belongsTo = [testCase:TestCase]

    static constraints = {
        type(blank:true, nullable:false)
        name size: 0..255, nullable:false
        sizeData min: new Long(1), max: new Long(1073741824) // max of 4GB
    }
}
