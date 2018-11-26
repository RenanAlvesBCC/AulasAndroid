package com.example.renanalves.emprestimo

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import com.example.renanalves.emprestimo.DataBase.DBHelper
import com.example.renanalves.emprestimo.Model.Emprestimo
import kotlinx.android.synthetic.main.activity_add_emprestimo.*
import java.text.SimpleDateFormat
import java.util.*

class AddEmprestimo : Activity() {

    val cal = Calendar.getInstance()
    val year = cal.get(Calendar.YEAR)
    val month = cal.get(Calendar.MONTH)
    val day = cal.get(Calendar.DAY_OF_MONTH)
    val CAMERA_REQUEST_CODE = 0
    var currentUri: Uri? = null
    var emprestimo: Emprestimo = Emprestimo()
    internal lateinit var db: DBHelper
    var formataData: SimpleDateFormat = SimpleDateFormat("dd/MM/yyyy")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_emprestimo)

        addFoto.setOnClickListener {
            val callCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (callCameraIntent.resolveActivity(packageManager) != null) {
                startActivityForResult(callCameraIntent, CAMERA_REQUEST_CODE)
            }
        }

        dataEntregaPicker.setOnClickListener {
            val date = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                dataEntregaPicker.setText(""+mDay+"/"+mMonth+"/"+mYear)
            },year,month,day)
            date.show()
        }

        confirmaCadastro.setOnClickListener {
            emprestimo = Emprestimo(intent.getIntExtra("id",0),nomeStamp.toString(),cepStamp.toString(),telefoneStamp.toString(), produtoStamp.editableText.toString(),currentUri.toString(), getDataAtual().toString(), dataEntregaPicker.text.toString())
            db = DBHelper(this)
            db.addEmprestimo(emprestimo)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
            AlertReceiver().sendNotification(this, emprestimo.nomeObjeto.toString(), "Hora de recuperar a seu objeto emprestado!" )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode) {
            CAMERA_REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK && data!= null) {
                    currentUri = saveImage(data.extras.get("data") as Bitmap, "")
                    fotoObjeto.setImageBitmap(data.extras.get("data") as Bitmap)
                }
            }
            else -> {
                Toast.makeText(this, "Unrecognized request code", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun saveImage(bitmap: Bitmap, title: String): Uri {

        val savedImageURL = MediaStore.Images.Media.insertImage(
            contentResolver,
            bitmap,
            title,
            "Image of $title"
        )

        return Uri.parse(savedImageURL)
    }

    fun getDataAtual(): String {
        var data = Date()
        var dataFormatada = formataData.format(data)
        return dataFormatada
    }
}
