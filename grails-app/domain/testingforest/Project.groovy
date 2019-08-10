package testingforest

class Project {

    String projectName
    Date dateCreated
    Date lastUpdated

    static hasMany = [teamList: User, testCaseList: TestCase, feedList: Feed]

    static mapping = {
        sort lastUpdated: 'desc'
        testCaseList sort: 'lastUpdated', order: 'desc'
        feedList sort: 'dateCreated', order: 'desc'
    }

    static constraints = {
        projectName size: 1..255
        testCaseList nullable: true
        feedList nullable: true
    }
}
