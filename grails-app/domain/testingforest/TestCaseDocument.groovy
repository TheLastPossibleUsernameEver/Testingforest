package testingforest

class TestCaseDocument {

    String name
    String type
    byte[] data

    static constraints = {
        data(nullable:false, maxSize: 1073741824) // max of 4GB
        type(blank:true, nullable:false)
        name(blank:true, nullable:false)
    }
}
