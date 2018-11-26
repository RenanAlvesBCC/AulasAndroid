package com.example.renanalves.emprestimo.Model

import java.io.Serializable

class Emprestimo: Serializable {

    var id: Int = 0
    var nomePessoa: String? = null
    var cepPessoa: String? = null
    var telPessoa: String? = null
    var nomeObjeto: String? = null
    var fotoObjeto: String? = null
    var dataEmprestimo: String? = null
    var dataEntrega: String? = null

    constructor()

    constructor(id: Int, nomeP: String, cepP: String, telP: String, nomeO: String, fotoO: String, dataEmp: String, dataEnt: String) {
        this.id = id
        this.nomePessoa = nomeP
        this.cepPessoa = cepP
        this.telPessoa = telP
        this.nomeObjeto = nomeO
        this.fotoObjeto = fotoO
        this.dataEntrega = dataEnt
        this.dataEmprestimo = dataEmp
    }
}