databaseChangeLog = {

    changeSet(author: "nikita (generated)", id: "1564413682876-2") {
        addColumn(tableName: "test_case") {
            column(name: "size_data", type: "bigint") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "nikita (generated)", id: "1564413682876-3") {
        dropColumn(columnName: "date_created", tableName: "test_case_document")
    }

    changeSet(author: "nikita (generated)", id: "1564413682876-4") {
        dropColumn(columnName: "last_updated", tableName: "test_case_document")
    }

    changeSet(author: "nikita (generated)", id: "1564413682876-5") {
        dropColumn(columnName: "upload_date", tableName: "test_case_document")
    }

    changeSet(author: "nikita (generated)", id: "1564413682876-1") {
        dropUniqueConstraint(constraintName: "UC_USERLOGIN_COL", tableName: "user")

        addUniqueConstraint(columnNames: "login", constraintName: "UC_USERLOGIN_COL", tableName: "user")
    }
}
