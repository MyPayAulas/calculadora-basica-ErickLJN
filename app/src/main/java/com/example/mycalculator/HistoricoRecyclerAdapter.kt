package com.example.mycalculator

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_calculo.view.*

class HistoricoRecyclerAdapter(
    val context: Context,
    val listaCalculos: MutableList<Calculo>,
    val callback: (String) -> Unit,

) : RecyclerView.Adapter<HistoricoRecyclerAdapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v: View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_calculo,
            parent,
            false)

        val vh = VH(v)
        vh.itemView.setOnClickListener {
            val expressao: String = listaCalculos[vh.adapterPosition].toString()
            callback(expressao)
        }
        return  vh

    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.txtId.text = position.toString()
        holder.txtExpressao.text = listaCalculos[position].toString()
    }

    override fun getItemCount() = listaCalculos.size

    class VH(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtId: TextView = itemView.txtidCalculo
        val txtExpressao: TextView = itemView.txtExpressao
    }
}
