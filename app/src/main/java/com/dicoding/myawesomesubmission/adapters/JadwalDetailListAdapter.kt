package com.dicoding.myawesomesubmission.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.myawesomesubmission.R
import com.dicoding.myawesomesubmission.models.JadwalModel

class JadwalDetailListAdapter(private val listHeroes: ArrayList<JadwalModel>) : RecyclerView.Adapter<JadwalDetailListHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): JadwalDetailListHolder {
        return JadwalDetailListHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.rv_stepper, viewGroup, false))
    }

    override fun onBindViewHolder(holder: JadwalDetailListHolder, position: Int) {
        val (mapel, jampel1, jampel2, ruang, jmlTugas) = listHeroes[position]

        holder.mapel.text = mapel
        holder.jampel1.text = jampel1
        holder.ruang.text = ruang
        holder.tugas.text = "Tugas $jmlTugas"
        holder.jampelMin.text = "$jampel1 - $jampel2"

    }

    override fun getItemCount(): Int = listHeroes.size

}

class JadwalDetailListHolder(view: View) : RecyclerView.ViewHolder(view) {
    var mapel: TextView = view.findViewById(R.id.mapel)
    var jampel1: TextView = view.findViewById(R.id.jampel1)
    var ruang: TextView = view.findViewById(R.id.ruang)
    var tugas: TextView = view.findViewById(R.id.jmlTugas)
    var jampelMin: TextView = view.findViewById(R.id.jampelMin)
}


