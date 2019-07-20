package testingforest

class Project {

    String projectName
    Date dateCreated
    Date lastUpdated

    @Override
    String toString() {
        return projectName
    }
    static hasMany = [teamList: User, testCaseList: TestCase]

    static constraints = {
        projectName size: 1..255
        testCaseList nullable: true
    }
}
