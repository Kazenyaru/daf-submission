package com.dicoding.myawesomesubmission.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.myawesomesubmission.R
import com.dicoding.myawesomesubmission.adapters.JadwalDetailAdapter
import com.dicoding.myawesomesubmission.adapters.JadwalDetailListAdapter
import com.dicoding.myawesomesubmission.models.JadwalData
import com.dicoding.myawesomesubmission.models.JadwalDetailModel
import com.dicoding.myawesomesubmission.models.JadwalModel
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class JadwalDetailActivity : AppCompatActivity() {

    private lateinit var rvTanggal: RecyclerView
    private lateinit var rvJadwalDetail: RecyclerView
    private var listJadwalListDetail: ArrayList<JadwalModel> = arrayListOf()
    private var list: ArrayList<JadwalDetailModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jadwal_detail)
        setActionBar("Jadwal")

        rvTanggal = findViewById(R.id.recyclerViewTanggal)
        rvTanggal.setHasFixedSize(true)

        list.addAll(JadwalData.listTanggal)
        rvTanggal.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val jadwalDetailAdapter = JadwalDetailAdapter(list)
        rvTanggal.adapter = jadwalDetailAdapter

        var formatter = SimpleDateFormat("EEE, dd MMMM yyyy")
        var date = Date()
        var formattedDate = formatter.format(date)
        var tanggalClick: TextView = findViewById(R.id.tanggal_jadwal_detail)
        tanggalClick.text = formattedDate

        rvJadwalDetail = findViewById(R.id.recyclerViewJadwalDetail)
        rvJadwalDetail.setHasFixedSize(true)
        listJadwalListDetail.addAll(JadwalData.listJadwal)

        rvJadwalDetail.layoutManager = LinearLayoutManager(this)
        val jadwalDetailListAdapter = JadwalDetailListAdapter(listJadwalListDetail)
        rvJadwalDetail.adapter = jadwalDetailListAdapter

    }

    private fun setActionBar(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }

}
