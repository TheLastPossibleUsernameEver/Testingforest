databaseChangeLog = {

    changeSet(author: "root (generated)", id: "1564127613927-2") {
        addColumn(tableName: "test_case_document") {
            column(name: "test_case_id", type: "bigint") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "root (generated)", id: "1564127613927-3") {
        addForeignKeyConstraint(baseColumnNames: "test_case_id", baseTableName: "test_case_document", constraintName: "FK6nh8nv1fsy4omrsb46qnve5be", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "test_case", validate: "true")
    }

    changeSet(author: "root (generated)", id: "1564127613927-4") {
        dropForeignKeyConstraint(baseTableName: "test_case_document", constraintName: "FKgvbfwr5ubqu7remk7369yw06d")
    }

    changeSet(author: "root (generated)", id: "1564127613927-5") {
        dropColumn(columnName: "testcase_id", tableName: "test_case_document")
    }

    changeSet(author: "root (generated)", id: "1564127613927-1") {
        dropUniqueConstraint(constraintName: "UC_USERLOGIN_COL", tableName: "user")

        addUniqueConstraint(columnNames: "login", constraintName: "UC_USERLOGIN_COL", tableName: "user")
    }
}
