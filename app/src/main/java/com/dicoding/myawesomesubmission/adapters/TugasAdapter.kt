package com.dicoding.myawesomesubmission.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.myawesomesubmission.R
import com.dicoding.myawesomesubmission.models.TugasModel

class TugasAdapter(private val listHeroes: ArrayList<TugasModel>) : RecyclerView.Adapter<TugasHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): TugasHolder {
        return TugasHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.rv_tugas, viewGroup, false))
    }

    override fun onBindViewHolder(holder: TugasHolder, position: Int) {
        val (mapelTugas, tugas, tanggal) = listHeroes[position]

        holder.mapelTugas.text = mapelTugas
        holder.tugas.text = tugas
        holder.tenggat.text = tanggal

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listHeroes[holder.adapterPosition]) }

    }

    override fun getItemCount(): Int = listHeroes.size

    interface OnItemClickCallback {
        fun onItemClicked(data: TugasModel)
    }

}

class TugasHolder(view: View) : RecyclerView.ViewHolder(view) {
    var mapelTugas: TextView = view.findViewById(R.id.mapelTugas)
    var tugas: TextView = view.findViewById(R.id.tugas)
    var tenggat: TextView = view.findViewById(R.id.tenggat)
}