package testingforest

class Project {

    String projectName
    Date dateCreated
    Date lastUpdated

    static hasMany = [teamList: User, testCaseList: TestCase]

    static mapping = {
        sort lastUpdated: 'desc'
        testCaseList sort: 'lastUpdated', order: 'desc'
    }

    static constraints = {
        projectName size: 1..255
        testCaseList nullable: true
    }
}
