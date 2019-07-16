databaseChangeLog = {

    changeSet(author: "pogre (generated)", id: "1563222136314-1") {
        createTable(tableName: "project") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "projectPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "date_created", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "project_name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "pogre (generated)", id: "1563222136314-2") {
        createTable(tableName: "project_user") {
            column(name: "project_team_list_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "user_id", type: "BIGINT")
        }
    }

    changeSet(author: "pogre (generated)", id: "1563222136314-3") {
        createTable(tableName: "test_case") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "test_casePK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "date_created", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "type_case", type: "VARCHAR(9)") {
                constraints(nullable: "false")
            }

            column(name: "case_name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "user_created_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "size_data", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "project_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "pogre (generated)", id: "1563222136314-4") {
        createTable(tableName: "user") {
            column(autoIncrement: "true", name: "user_id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "userPK")
            }

            column(name: "login", type: "VARCHAR(45)") {
                constraints(nullable: "false",unique: "true")
            }

            column(name: "role", type: "VARCHAR(45)") {
                constraints(nullable: "false")
            }

            column(name: "password", type: "VARCHAR(45)") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(45)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "pogre (generated)", id: "1563222136314-5") {
        addUniqueConstraint(columnNames: "login", constraintName: "UC_USERLOGIN_COL", tableName: "user")
    }

    changeSet(author: "pogre (generated)", id: "1563222136314-6") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "project_user", constraintName: "FK4jl2o131jivd80xsuw6pivnbx", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "user_id", referencedTableName: "user")
    }

    changeSet(author: "pogre (generated)", id: "1563222136314-7") {
        addForeignKeyConstraint(baseColumnNames: "user_created_id", baseTableName: "test_case", constraintName: "FK57td41jyxfewpu950nn2itic7", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "user_id", referencedTableName: "user")
    }

    changeSet(author: "pogre (generated)", id: "1563222136314-8") {
        addForeignKeyConstraint(baseColumnNames: "project_team_list_id", baseTableName: "project_user", constraintName: "FKaksochooeywok2p98dfsb0r9b", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "project")
    }

    changeSet(author: "pogre (generated)", id: "1563222136314-9") {
        addForeignKeyConstraint(baseColumnNames: "project_id", baseTableName: "test_case", constraintName: "FKit9gxtn7qhwml7ni05l11syb8", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "project")
    }
}

