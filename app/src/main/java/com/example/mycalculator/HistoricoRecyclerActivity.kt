package com.example.mycalculator

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycalculator.ui.main.HistoricoCalculos
import kotlinx.android.synthetic.main.activity_screen2.*

class HistoricoRecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen2)

        val historico = intent.getParcelableExtra<HistoricoCalculos>("historico")

        if(historico != null){
            rvHistorico.layoutManager = LinearLayoutManager(this)
            rvHistorico.adapter = HistoricoRecyclerAdapter(this, historico.listaCalculos, ::onItemClick)
            rvHistorico.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))
        }
    }

    private  fun onItemClick(expressao: String){
        Toast.makeText(this, expressao,  Toast.LENGTH_SHORT).show()
    }
}