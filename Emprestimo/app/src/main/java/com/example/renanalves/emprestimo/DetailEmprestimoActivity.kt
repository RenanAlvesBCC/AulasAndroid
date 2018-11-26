package com.example.renanalves.emprestimo

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.renanalves.emprestimo.Model.Emprestimo
import kotlinx.android.synthetic.main.activity_detail_emprestimo.*
import java.net.URI

class DetailEmprestimoActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_emprestimo)
        var emprestimo : Emprestimo = intent.getSerializableExtra("emprestimo") as Emprestimo
        imgItem.setImageURI(Uri.parse(emprestimo.fotoObjeto))
        tvNomeItem.setText(emprestimo.nomeObjeto)
        tvDataEmp.setText(emprestimo.dataEmprestimo)
        tvDataEnt.setText(emprestimo.dataEntrega)
        edtCep.setText(emprestimo.cepPessoa)
        consultaCep(emprestimo.cepPessoa!!)
    }

    fun consultaCep(cep: String) {

        val url = "https://viacep.com.br/ws/${cep}/json/"
        var list = mutableListOf<String>()

        val que = Volley.newRequestQueue(this@DetailEmprestimoActivity)
        val req = JsonObjectRequest(Request.Method.GET, url, null, Response.Listener { response ->
            //            var uf = response["uf"].toString()
            list.add(0, response["bairro"].toString())
            list.add(1, response["localidade"].toString())
            list.add(2, response["uf"].toString())

            preencheDadosCep(list)

        }, Response.ErrorListener {
            print("Fail")
        })
        que.add(req)
    }

    fun preencheDadosCep(list: List<String>) {
        edtBairro.setText("Bairro: "+ list[0])
        edtLocalidade.setText("Localidade: "+list[1])
        edtUF.setText("UF: "+list[2])
    }
}
