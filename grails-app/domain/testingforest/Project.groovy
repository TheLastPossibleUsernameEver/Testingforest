package testingforest

class Project {

    String projectName

    static hasMany = [teamList : User , testCaseList : TestCase]

    static belongsTo = [projectCreator : User]

    static mapping = {
        autoTimestamp true
    }

    static constraints = {
        projectName size: 1..255
        teamList cascade: 'all'
        teamList nullable: true
        testCaseList nullable: true
    }
}
