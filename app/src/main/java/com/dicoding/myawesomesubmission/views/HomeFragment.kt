package com.dicoding.myawesomesubmission.views

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.myawesomesubmission.R
import com.dicoding.myawesomesubmission.adapters.JadwalListAdapter
import com.dicoding.myawesomesubmission.adapters.TugasAdapter
import com.dicoding.myawesomesubmission.models.JadwalData
import com.dicoding.myawesomesubmission.models.JadwalModel
import com.dicoding.myawesomesubmission.models.TugasModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    companion object {

        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    // putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    private var listJadwal: ArrayList<JadwalModel> = arrayListOf()
    private var listTugas: ArrayList<TugasModel> = arrayListOf()
    private lateinit var onItemClickCallback: JadwalListAdapter.OnItemClickCallback

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        listJadwal.addAll(JadwalData.listJadwal)
        listTugas.addAll(JadwalData.listTugas)

        recyclerViewJadwal.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        var jadwalAdapter = JadwalListAdapter(listJadwal)
        recyclerViewJadwal.adapter = jadwalAdapter

        recyclerViewTugas.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        var tugasAdapter = TugasAdapter(listTugas)
        recyclerViewTugas.adapter = tugasAdapter



        jadwalAdapter.setOnItemClickCallback(object : JadwalListAdapter.OnItemClickCallback {
            override fun onItemClicked(data: JadwalModel) {
                showSelectedJadwal(data)
            }
        })

        tugasAdapter.setOnItemClickCallback(object : TugasAdapter.OnItemClickCallback {
            override fun onItemClicked(data: TugasModel) {
                showSelectedTugas(data)
            }
        })

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView =  inflater.inflate(R.layout.fragment_home, container, false)

        return rootView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
//             columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    private fun showSelectedJadwal(hero: JadwalModel) {
        val moveToJadwalDetail = Intent(activity, JadwalDetailActivity::class.java)
        startActivity(moveToJadwalDetail)
//        Toast.makeText(activity, "Kamu Memilih " + hero.mapel, Toast.LENGTH_SHORT).show()
    }

    private fun showSelectedTugas(hero: TugasModel) {
        val moveToTugasGrid = Intent(activity, TugasGridActivity::class.java)
        startActivity(moveToTugasGrid)
    }


}