package com.example.renanalves.emprestimo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import com.example.renanalves.emprestimo.DataBase.DBHelper
import com.example.renanalves.emprestimo.Model.Emprestimo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    internal lateinit var db: DBHelper
    internal var emprestimos: List<Emprestimo> = ArrayList<Emprestimo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = DBHelper(this)
        setupListView()

        listViewEmprestimos.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, DetailEmprestimoActivity::class.java)
            intent.putExtra("emprestimo",emprestimos[position])
            startActivity(intent)
        }
    }

    private fun setupListView() {
        emprestimos = db.allEmprestimos

        var emprestimosAdapter = EmprestimoAdapter(this, emprestimos)
        var listViewEmprestimos = findViewById<ListView>(R.id.listViewEmprestimos)
        listViewEmprestimos.adapter = emprestimosAdapter
        addButton.setOnClickListener {
            var intent = Intent(this,AddEmprestimo::class.java)
            intent.putExtra("id",emprestimos.count())
            startActivity(intent)
            finish()
        }
    }
}
