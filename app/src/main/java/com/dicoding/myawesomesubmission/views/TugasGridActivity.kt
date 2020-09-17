package com.dicoding.myawesomesubmission.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.myawesomesubmission.R
import com.dicoding.myawesomesubmission.adapters.TugasGridAdapter
import com.dicoding.myawesomesubmission.models.JadwalData
import com.dicoding.myawesomesubmission.models.TugasModel
import java.util.*

class TugasGridActivity : AppCompatActivity() {

    private lateinit var rvTugas: RecyclerView
    private var listTugas: ArrayList<TugasModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tugas_grid)
        setActionBar("Tugas")

        rvTugas = findViewById(R.id.recyclerViewTugasGrid)
        rvTugas.setHasFixedSize(true)

        listTugas.addAll(JadwalData.listTugas)
        rvTugas.layoutManager = GridLayoutManager(this, 2)
        val jadwalDetailAdapter = TugasGridAdapter(listTugas)
        rvTugas.adapter = jadwalDetailAdapter

    }

    private fun setActionBar(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }
}
