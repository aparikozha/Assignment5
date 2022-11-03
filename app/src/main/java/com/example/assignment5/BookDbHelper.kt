package com.example.assignment5

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class BookDbHelper(context : Context) : SQLiteOpenHelper(context, DbConfig.DATABASE_NAME, null,DbConfig.VERSION) {

    companion object {
        private const val SQL_CREATE_TABLE =
                "CREATE TABLE ${Book.TABLE_NAME}(" +
                        "${Book.BookColumns.ID} INTEGER PRIMARY KEY, " +
                        "${Book.BookColumns.NAME} TEXT ," +
                        "${Book.BookColumns.AUTHOR} TEXT," +
                        "${Book.BookColumns.YEAR_OF_RELEASE} INTEGER)"

        private const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS ${Book.TABLE_NAME}"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(SQL_DELETE_TABLE)
        onCreate(db)


    }

    fun insert(bookName: String, bookAuthor: String, bookYear: Int) {
        val cv = ContentValues().apply {
            put(Book.BookColumns.NAME, bookName)
            put(Book.BookColumns.AUTHOR, bookAuthor)
            put(Book.BookColumns.YEAR_OF_RELEASE, bookYear)

        }

        writableDatabase.insert(Book.TABLE_NAME, null, cv)

    }

    fun updateBook(bookId: Int, bookName: String) {
        val cv = ContentValues().apply {
            put(Book.BookColumns.ID, bookId)
            put(Book.BookColumns.NAME, bookName)

        }

        val where = "${Book.BookColumns.ID} = ?"
        val args = arrayOf(bookId.toString())

        writableDatabase.update(Book.TABLE_NAME, cv, where, args )

    }

    fun deleteBook(bookId: Int){
        val where = "${Book.BookColumns.ID} = ?"
        val args = arrayOf(bookId.toString())

        writableDatabase.delete(Book.TABLE_NAME, where, args)

    }

    fun delete(){
        writableDatabase.delete(Book.TABLE_NAME, null, null)
    }

    @SuppressLint("Range")
    fun select(){

        val ordering = "${Book.BookColumns.YEAR_OF_RELEASE} DESC"


        val projection = arrayOf(
            Book.BookColumns.NAME,
            Book.BookColumns.AUTHOR,
            Book.BookColumns.ID
        )

        val cursor = readableDatabase.query(
            Book.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            ordering)

        while (cursor.moveToNext()){
            val name = cursor.getString(cursor.getColumnIndex(Book.BookColumns.NAME))
            val id = cursor.getString(cursor.getColumnIndex(Book.BookColumns.ID))
            val author = cursor.getString(cursor.getColumnIndex(Book.BookColumns.AUTHOR))

            Log.d("MyData", "$name - $author - $id")

        }

        cursor.close()

    }


}

