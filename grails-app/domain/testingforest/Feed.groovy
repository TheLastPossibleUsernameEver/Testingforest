package testingforest

class Feed {

    String feed
    Date dateCreated

    static mapping = {
        sort dateCreated: 'desc'
    }

    static belongsTo = [user: User, project: Project]

    static constraints = {
    }
}
