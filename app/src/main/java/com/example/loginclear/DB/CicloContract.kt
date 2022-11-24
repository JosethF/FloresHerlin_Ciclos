package com.example.loginclear.DB

object LibrossContract {
    val TABLE_NAME = "ciclos"
    val COLUMN_NAME_TITLE = "title"
    val COLUMN_NAME_EDITORIAL = "editorial"

    val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${TABLE_NAME} (" +
                "id INTEGER PRIMARY KEY," +
                "${COLUMN_NAME_TITLE} TEXT," +
                "${COLUMN_NAME_EDITORIAL} TEXT)"

    val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${TABLE_NAME}"

}
