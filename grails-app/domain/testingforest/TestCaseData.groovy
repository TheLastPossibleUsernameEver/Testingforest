package testingforest

class TestCaseData {

    String name
    String type
    byte[] data
    Date dateCreated
    Date lastUpdated
    Date uploadDate = new Date()

    static constraints = {
        data(nullable:false, maxSize: 1073741824) // max of 4GB
        type(blank:true, nullable:false)
        name(blank:true, nullable:true)
    }
}
