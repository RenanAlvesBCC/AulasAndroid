package com.example.renanalves.emprestimoapp.Model

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.renanalves.emprestimoapp.R

class EmprestimoAdapter constructor(var context: Context, private var emprestimos: List<Emprestimo>): BaseAdapter() {

    private val mInflator: LayoutInflater
    internal var emp: List<Emprestimo>

    init {
        this.mInflator = LayoutInflater.from(context)
        this.emp = emprestimos
    }

    override fun getCount(): Int {
        return emp.size
    }

    override fun getItem(position: Int): Any {
        return emp[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val emprestimo = emp[position]


        val view: View
        val vh: ListRowHolder

        if (convertView == null) {
            view = mInflator.inflate(R.layout.viewlist, parent, false)
            vh = ListRowHolder(view)
            view.tag = vh
        } else {
            view = convertView
            vh = view.tag as ListRowHolder
        }


        vh.nomeR.setText(emprestimo.nomeObjeto)
        vh.dataEm.setText(emprestimo.dataEmprestimo)
        vh.dataDv.setText(emprestimo.dataEntrega)
        vh.fotoPr.setImageURI(Uri.parse(emprestimo.fotoObjeto))

        return view
    }


    private class ListRowHolder(row: View?) {
        val nomeR: TextView
        val dataEm: TextView
        val dataDv: TextView
        val fotoPr: ImageView

        init {
            this.nomeR = row?.findViewById<TextView>(R.id.nomeProduto) as TextView
            this.dataEm = row?.findViewById<TextView>(R.id.dataEmprestimo) as TextView
            this.dataDv = row?.findViewById<TextView>(R.id.dataDevolucao) as TextView
            this.fotoPr = row?.findViewById<ImageView>(R.id.imgProduto) as ImageView
        }
    }
}