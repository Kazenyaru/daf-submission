package com.dicoding.myawesomesubmission.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.myawesomesubmission.R
import com.dicoding.myawesomesubmission.models.TugasModel

class TugasGridAdapter(private val listHeroes: ArrayList<TugasModel>) : RecyclerView.Adapter<TugasGridHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): TugasGridHolder {
        return TugasGridHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.rv_tugas_grid, viewGroup, false))
    }

    override fun onBindViewHolder(holder: TugasGridHolder, position: Int) {
        val (mapelTugas, tugas, tanggal) = listHeroes[position]

        holder.mapelTugas.text = mapelTugas
        holder.tugas.text = tugas
        holder.tenggat.text = tanggal

    }

    override fun getItemCount(): Int = listHeroes.size

}

class TugasGridHolder(view: View) : RecyclerView.ViewHolder(view) {
    var mapelTugas: TextView = view.findViewById(R.id.mapelTugas)
    var tugas: TextView = view.findViewById(R.id.tugas)
    var tenggat: TextView = view.findViewById(R.id.tenggat)
}