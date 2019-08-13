databaseChangeLog = {

    changeSet(author: "root (generated)", id: "1565713214067-2") {
        addColumn(tableName: "user") {
            column(name: "email", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "root (generated)", id: "1565713214067-3") {
        addUniqueConstraint(columnNames: "email", constraintName: "UC_USEREMAIL_COL", tableName: "user")
    }

    changeSet(author: "root (generated)", id: "1565713214067-1") {
        dropUniqueConstraint(constraintName: "UC_USERLOGIN_COL", tableName: "user")

        addUniqueConstraint(columnNames: "login", constraintName: "UC_USERLOGIN_COL", tableName: "user")
    }
}
