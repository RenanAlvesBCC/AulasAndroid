package com.example.renanalves.emprestimo.DataBase

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.renanalves.emprestimo.Model.Emprestimo

class DBHelper(context: Context):SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERS) {
    companion object {
        private val DATABASE_NAME = "EMPRESTIMO.db"
        private val DATABASE_VERS = 1
    }

    //Table
    private val TABLE_NAME = "emprestados"
    private val COL_ID = "Id"
    private val COL_NAME_PESSOA = "NomePessoa"
    private val COL_CEP_PESSOA = "CEP"
    private val COL_TEL_PESSOA = "Telefone"
    private val COL_NOME_OBJETO = "NomeObjeto"
    private val COL_FOTO_OBJETO = "FotoObjeto"
    private val COL_DATA_EMPRESTIMO = "DataEmprestimo"
    private val COL_DATA_ENTREGA = "DataEntrega"

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY = ("CREATE TABLE $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY,$COL_NAME_PESSOA TEXT,$COL_CEP_PESSOA TEXT,$COL_TEL_PESSOA TEXT,$COL_NOME_OBJETO TEXT,$COL_FOTO_OBJETO TEXT,$COL_DATA_EMPRESTIMO TEXT,$COL_DATA_ENTREGA TEXT)")
        db!!.execSQL(CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db!!)
    }

    val allEmprestimos: List<Emprestimo>
        get() {
            val lEmprestimos = ArrayList<Emprestimo>()
            val selectQuery = "SELECT * FROM $TABLE_NAME"
            val db: SQLiteDatabase = this.writableDatabase
            val cursor: Cursor = db.rawQuery(selectQuery,null)
            if(cursor.moveToFirst()) {
                do{
                    val emprestimo = Emprestimo()
                    emprestimo.id = cursor.getInt(cursor.getColumnIndex(COL_ID))
                    emprestimo.nomePessoa = cursor.getString(cursor.getColumnIndex(COL_NAME_PESSOA))
                    emprestimo.cepPessoa = cursor.getString(cursor.getColumnIndex(COL_CEP_PESSOA))
                    emprestimo.telPessoa = cursor.getString(cursor.getColumnIndex(COL_TEL_PESSOA))
                    emprestimo.nomeObjeto = cursor.getString(cursor.getColumnIndex(COL_NOME_OBJETO))
                    emprestimo.fotoObjeto = cursor.getString(cursor.getColumnIndex(COL_FOTO_OBJETO))
                    emprestimo.dataEmprestimo = cursor.getString(cursor.getColumnIndex(COL_DATA_EMPRESTIMO))
                    emprestimo.dataEntrega = cursor.getString(cursor.getColumnIndex(COL_DATA_ENTREGA))
                    lEmprestimos.add(emprestimo)
                }while (cursor.moveToNext())
            }
            db.close()
            return lEmprestimos
        }

    fun addEmprestimo(emprestimo: Emprestimo) {
        val db: SQLiteDatabase = this.writableDatabase
        val values = ContentValues()

        values.put(COL_ID,emprestimo.id)
        values.put(COL_NAME_PESSOA,emprestimo.nomePessoa)
        values.put(COL_CEP_PESSOA,emprestimo.cepPessoa)
        values.put(COL_TEL_PESSOA,emprestimo.telPessoa)
        values.put(COL_NOME_OBJETO,emprestimo.nomeObjeto)
        values.put(COL_DATA_EMPRESTIMO,emprestimo.dataEmprestimo)
        values.put(COL_DATA_ENTREGA,emprestimo.dataEntrega)
        values.put(COL_FOTO_OBJETO,emprestimo.fotoObjeto)

        db.insert(TABLE_NAME,null,values)
        db.close()
    }
}