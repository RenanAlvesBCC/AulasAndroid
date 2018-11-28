package com.example.renanalves.emprestimoapp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import com.example.renanalves.emprestimoapp.DataBase.DBHelper
import com.example.renanalves.emprestimoapp.Model.Emprestimo
import com.example.renanalves.emprestimoapp.Model.EmprestimoAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    internal lateinit var db: DBHelper
    internal var emprestimos: List<Emprestimo> = ArrayList<Emprestimo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        db = DBHelper(this)
        setupListView()

        listViewEmprestimos.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, DetailEmprestimoActivity::class.java)
            intent.putExtra("emprestimo",emprestimos[position])
            startActivity(intent)
        }

        fab.setOnClickListener {
            var intent = Intent(this,AddEmprestimoActivity::class.java)
            intent.putExtra("id",emprestimos.count())
            startActivity(intent)
            finish()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    private fun setupListView() {
        emprestimos = db.allEmprestimos

        var emprestimosAdapter = EmprestimoAdapter(this, emprestimos)
        var listViewEmprestimos = findViewById<ListView>(R.id.listViewEmprestimos)
        listViewEmprestimos.adapter = emprestimosAdapter
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
//            R.id.nav_gallery -> {
//
//            }
//            R.id.nav_slideshow -> {
//
//            }
//            R.id.nav_manage -> {
//
//            }
//            R.id.nav_share -> {
//
//            }
//            R.id.nav_send -> {
//
//            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
