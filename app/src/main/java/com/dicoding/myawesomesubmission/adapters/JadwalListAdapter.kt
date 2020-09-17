package com.dicoding.myawesomesubmission.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.myawesomesubmission.R
import com.dicoding.myawesomesubmission.models.JadwalModel

class JadwalListAdapter(private val listHeroes: ArrayList<JadwalModel>) : RecyclerView.Adapter<JadwalListHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): JadwalListHolder {
        return JadwalListHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.rv_jadwal, viewGroup, false))
    }

    override fun onBindViewHolder(holder: JadwalListHolder, position: Int) {
        val (mapel, jampel1, ruang, jmlTugas) = listHeroes[position]

        holder.mapel.text = mapel
        holder.status.text = jampel1
        holder.ruang.text = ruang
        holder.tugas.text = "Tugas $jmlTugas"

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listHeroes[holder.adapterPosition]) }

    }

    override fun getItemCount(): Int = listHeroes.size

    interface OnItemClickCallback {
        fun onItemClicked(data: JadwalModel)
    }

}

class JadwalListHolder(view: View) : RecyclerView.ViewHolder(view) {
    var mapel: TextView = view.findViewById(R.id.mapel)
    var status: TextView = view.findViewById(R.id.status)
    var ruang: TextView = view.findViewById(R.id.ruang)
    var tugas: TextView = view.findViewById(R.id.jmlTugas)
}


