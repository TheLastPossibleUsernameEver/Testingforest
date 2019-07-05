databaseChangeLog = {

    changeSet(author: "Оля (generated)", id: "1562323400724-1") {
        createTable(tableName: "case") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "casePK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "surname", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "Оля (generated)", id: "1562323400724-2") {
        createTable(tableName: "project") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "projectPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "Оля (generated)", id: "1562323400724-3") {
        createTable(tableName: "project_user_mapping") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "project_user_mappingPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "Оля (generated)", id: "1562323400724-4") {
        createTable(tableName: "test") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "testPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "sfsdfsd", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "Оля (generated)", id: "1562323400724-5") {
        createTable(tableName: "user") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "userPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }
}
