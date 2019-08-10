package testingforest

class Feed {

    String feed
    String testCase
    Date dateCreated

    static mapping = {
        sort dateCreated: 'desc'
    }

    static belongsTo = [user: User, project: Project]

    static constraints = {
        testCase nullable: true
    }
}
