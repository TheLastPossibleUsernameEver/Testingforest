package testingforest

class Project {

    String projectName
    Date dateCreated

    static hasMany = [teamList : User]

    static mapping = {
    }

    static constraints = {
        projectName size: 1..255
        teamList cascade: 'all'
        teamList nullable: true
    }

}
