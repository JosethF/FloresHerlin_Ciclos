package com.example.loginclear.DB

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.loginclear.Ciclo
import com.example.loginclear.DB.LibrossContract.COLUMN_NAME_EDITORIAL
import com.example.loginclear.DB.LibrossContract.COLUMN_NAME_TITLE
import com.example.loginclear.DB.LibrossContract.SQL_CREATE_ENTRIES
import com.example.loginclear.DB.LibrossContract.SQL_DELETE_ENTRIES
import com.example.loginclear.DB.LibrossContract.TABLE_NAME

class CicloDBHelper (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "ciclos.db"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    fun insertCiclo(l: Ciclo) {
        val values = ContentValues()
        values.put(COLUMN_NAME_TITLE, l.title)
        values.put(COLUMN_NAME_EDITORIAL, l.fullName)

        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
    }

    fun getAllData():MutableList<Ciclo>{
        var db = this.readableDatabase
        var rs = db.rawQuery("SELECT * FROM $TABLE_NAME",null)
        var llistat: MutableList<Ciclo>  = ArrayList()

        if(rs.moveToFirst()){
            do{
                val title = rs.getString(1)
                val editorial = rs.getString(2)
                val ciclo = Ciclo(title,editorial)
                llistat.add(ciclo);
            }while(rs.moveToNext())
        }
        return llistat;
    }

    fun deleteAllData() {
        //var db = this.writableDatabase
        var db = this.readableDatabase
        db.execSQL("DELETE FROM $TABLE_NAME");
    }

    fun logListData(){
        var db = this.readableDatabase
        var rs = db.rawQuery("SELECT * FROM $TABLE_NAME",null)

        if(rs.moveToFirst()){
            do{
                val title = rs.getString(1)
                val editorial = rs.getString(2)
                val ciclo = Ciclo(title,editorial)
                val cicloString = ciclo.getTitle()+", "+ciclo.getFullName()
                Log.i("LOG CICLOS",cicloString)
            }while(rs.moveToNext())
        }
    }

}