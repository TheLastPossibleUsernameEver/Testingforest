package testingforest

class Feed {

    String feed
    String user
    String testCase
    Date dateCreated

    static mapping = {
        sort dateCreated: 'desc'
    }

    static belongsTo = [project: Project]

    static constraints = {
        testCase nullable: true
    }
}
