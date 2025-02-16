package com.sap.db
import com.sap.flickersearch.db.Database
import testDbConnection
import kotlin.test.BeforeTest

open class DatabaseQueriesTest {

    lateinit var dbRef: Database

    @BeforeTest
    open fun beforeTest() {
        dbRef = Database(testDbConnection())
    }
}