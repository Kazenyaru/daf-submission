package com.dicoding.myawesomesubmission.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.myawesomesubmission.R
import com.dicoding.myawesomesubmission.models.JadwalDetailModel

class JadwalDetailAdapter(private val listHeroes: ArrayList<JadwalDetailModel>) : RecyclerView.Adapter<JadwalDetailHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): JadwalDetailHolder {
        return JadwalDetailHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.rv_tanggal_jadwal_detail, viewGroup, false))
    }

    override fun onBindViewHolder(holder: JadwalDetailHolder, position: Int) {
        val (hari, tanggalNo) = listHeroes[position]

        holder.hari.text = hari
        holder.tanggalNo.text = tanggalNo

    }

    override fun getItemCount(): Int = listHeroes.size


}

class JadwalDetailHolder(view: View) : RecyclerView.ViewHolder(view) {
    var hari: TextView = view.findViewById(R.id.hari_jadwal_detail)
    var tanggalNo: TextView = view.findViewById(R.id.tanggal_no)
}