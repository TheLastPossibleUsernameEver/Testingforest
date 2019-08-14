databaseChangeLog = {

    changeSet(author: "nikita (generated)", id: "1565732609717-3") {
        addColumn(tableName: "feed") {
            column(name: "user", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }


    changeSet(author: "nikita (generated)", id: "1565732609717-4") {
        dropForeignKeyConstraint(baseTableName: "feed", constraintName: "FKeupe1ba7u2e7sr6r3fa4dhdo7")
    }

    changeSet(author: "nikita (generated)", id: "1565732609717-5") {
        dropColumn(columnName: "user_id", tableName: "feed")
    }

    changeSet(author: "nikita (generated)", id: "1565732609717-1") {
        dropNotNullConstraint(columnDataType: "bigint", columnName: "user_created_id", tableName: "test_case")
    }

    changeSet(author: "nikita (generated)", id: "1565732609717-2") {
        dropUniqueConstraint(constraintName: "UC_USERLOGIN_COL", tableName: "user")

        addUniqueConstraint(columnNames: "login", constraintName: "UC_USERLOGIN_COL", tableName: "user")
    }
}
