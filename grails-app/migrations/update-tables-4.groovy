databaseChangeLog = {

    changeSet(author: "root (generated)", id: "1564388490890-1") {
        addNotNullConstraint(columnDataType: "varchar(255)", columnName: "name", tableName: "test_case_document")
    }

    changeSet(author: "root (generated)", id: "1564388490890-2") {
        dropUniqueConstraint(constraintName: "UC_USERLOGIN_COL", tableName: "user")

        addUniqueConstraint(columnNames: "login", constraintName: "UC_USERLOGIN_COL", tableName: "user")
    }
}
