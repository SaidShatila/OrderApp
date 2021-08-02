package com.app.sqlitetest.dbhelper

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.app.sqlitetest.model.UserModel

class DbHelper(context: Context) : SQLiteOpenHelper(context, "DATABASE", null, 4) {
    val TAG = "DbHelper"
    val TABLE = "logs"

    companion object {
        val TBL_USER = "tbl_user"
        val ID: String = "_id"
        val Name: String = "NAME"
        val Email: String = "EMAIL"
        val Password: String = "PASSWORD"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTblUser = ("CREATE TABLE" + TBL_USER + "(" +
                ID + "INTEGER PRIMARY KEY," + Name + "NAME," +
                "EMAIL," + Email + "PASSWORD," + Password + ")"
                )
        db?.execSQL(createTblUser)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TBL_USER")
        onCreate(db)
    }

    fun insertUser(std: UserModel): Long {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(ID, std.id)
        contentValues.put(Name, std.name)
        contentValues.put(Email, std.email)
        contentValues.put(Password, std.password)

        val success = db.insert(TBL_USER, null, contentValues)
        db.close()
        return success
    }

    fun getAllUsers(): ArrayList<UserModel> {
        val stdList: ArrayList<UserModel> = ArrayList()
        val selectQuery: ArrayList<UserModel> = ArrayList()
        val db = this.readableDatabase

        val cursor: Cursor?

        try {
            cursor = db.rawQuery(selectQuery.toString(), null)
        } catch (e: Exception) {
            e.printStackTrace()
            db.execSQL(selectQuery.toString())
            return ArrayList()
        }
        var id: Int
        var name: String
        var email: String
        var password: String

        if (cursor.moveToFirst()) {
            do {
                id = cursor.getInt(cursor.getColumnIndex("id"))
                name = cursor.getString(cursor.getColumnIndex("name"))
                email = cursor.getString(cursor.getColumnIndex("email"))
                password = cursor.getString(cursor.getColumnIndex("passowrd"))
            } while (cursor.moveToNext())
        }
        return stdList
    }
}