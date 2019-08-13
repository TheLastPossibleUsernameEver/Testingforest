databaseChangeLog = {

    changeSet(author: "nikita (generated)", id: "1565472865085-2") {
        addColumn(tableName: "feed") {
            column(name: "test_case", type: "varchar(255)")
        }
    }

    changeSet(author: "nikita (generated)", id: "1565472865085-1") {
        dropUniqueConstraint(constraintName: "UC_USERLOGIN_COL", tableName: "user")

        addUniqueConstraint(columnNames: "login", constraintName: "UC_USERLOGIN_COL", tableName: "user")
    }
}
