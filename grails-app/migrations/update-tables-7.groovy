databaseChangeLog = {

    changeSet(author: "nikita (generated)", id: "1564857531154-2") {
        addColumn(tableName: "test_case_document") {
            column(name: "size_data", type: "bigint") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "nikita (generated)", id: "1564857531154-3") {
        addColumn(tableName: "test_case_document") {
            column(name: "test_case_id", type: "bigint") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "nikita (generated)", id: "1564857531154-4") {
        addForeignKeyConstraint(baseColumnNames: "test_case_id", baseTableName: "test_case_document", constraintName: "FK6nh8nv1fsy4omrsb46qnve5be", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "test_case", validate: "true")
    }

    changeSet(author: "nikita (generated)", id: "1564857531154-5") {
        dropColumn(columnName: "size_data", tableName: "test_case")
    }

    changeSet(author: "nikita (generated)", id: "1564857531154-1") {
        dropUniqueConstraint(constraintName: "UC_USERLOGIN_COL", tableName: "user")

        addUniqueConstraint(columnNames: "login", constraintName: "UC_USERLOGIN_COL", tableName: "user")
    }
}
