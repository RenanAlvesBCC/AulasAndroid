package com.example.renanalves.requisicao

import android.app.Activity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnRequisicao.setOnClickListener {
            consultaCep(edtCep.text.toString())
        }
    }

    private fun consultaCep(cep: String) {
        val url = "https://viacep.com.br/ws/${cep}/json/"
        var list = mutableListOf<String>()

        val que = Volley.newRequestQueue(this@MainActivity)
        val req = JsonObjectRequest(Request.Method.GET, url, null, Response.Listener { response ->
            //            var uf = response["uf"].toString()
            list.add(0, response["bairro"].toString())
            list.add(1, response["localidade"].toString())
            list.add(2, response["uf"].toString())
            list.add(3,response["logradouro"].toString())

            preencheDadosCep(list)

        }, Response.ErrorListener {
            print("Fail")
        })
        que.add(req)
    }

    fun preencheDadosCep(list: List<String>) {
        tvCep.setText("Cep: "+edtCep.text.toString())
        edtBairro.setText("Bairro: "+ list[0])
        edtLocalidade.setText("Localidade: "+list[1])
        edtUF.setText("UF: "+list[2])
        edtLogradouro.setText("Logradouro: "+list[3])
    }
}
