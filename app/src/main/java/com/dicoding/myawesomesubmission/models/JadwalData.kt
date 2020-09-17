package com.dicoding.myawesomesubmission.models

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Calendar
import kotlin.collections.ArrayList

object JadwalData{
    private val datas = arrayOf(
        arrayOf(
            "Bahasa Indonesia",
            "D2.3",
            "1"
        ),
        arrayOf(
            "Bahasa Inggris",
            "D2.2",
            "2"
        ),
        arrayOf(
            "Bahasa Sunda",
            "D2.1",
            "2"
        ),
        arrayOf(
            "Bahasa Jerman",
            "D1.1",
            "1"
        ),
        arrayOf(
            "Bahasa Indonesia",
            "D2.3",
            "1"
        ),
        arrayOf(
            "Bahasa Inggris",
            "D2.2",
            "2"
        ),
        arrayOf(
            "Bahasa Sunda",
            "D2.1",
            "2"
        ),
        arrayOf(
            "Bahasa Jerman",
            "D1.1",
            "1"
        )
    )
    val listJadwal: ArrayList<JadwalModel>
        @RequiresApi(Build.VERSION_CODES.O)
        get() {
            val list = arrayListOf<JadwalModel>()

            var formatter = SimpleDateFormat("dd/MMMM/yyyy")
            val dateHour = SimpleDateFormat("HH:mm")
            var date = Date()
            var formattedDate = formatter.format(date)
            var hour = dateHour.format(date)
            val calendar: Calendar = Calendar.getInstance()
            calendar.setTime(dateHour.parse(hour))
            var it: Int = 0

            for (data in datas) {
                val jadwal  = JadwalModel()
                jadwal.mapel = data[0]
                jadwal.jampel1 = dateHour.format(calendar.time)
                it += 3
                calendar.set(Calendar.HOUR, it)
                jadwal.jampel2 = dateHour.format(calendar.time)
                jadwal.ruang = data[1]
                jadwal.jmlTugas = data[2]
                jadwal.waktu = formattedDate
                list.add(jadwal)
            }
            return list
        }

    var formatter = SimpleDateFormat("dd MMMM yyyy")
    var date = Date()
    var formattedDate = formatter.format(date)

    private val tugas = arrayOf(
        arrayOf(
            "Bahasa Indonesia",
            "Membuat Makalah",
            formattedDate
        ),
        arrayOf(
            "Bahasa Sunda",
            "Membuat Biantara",
            formattedDate
        ),
        arrayOf(
            "Bahasa Inggris",
            "Presentation",
            formattedDate
        ),
        arrayOf(
            "Bahasa Jerman",
            "Gutten Morgen",
            formattedDate
        ),
        arrayOf(
            "Bahasa Indonesia",
            "Membuat Makalah",
            formattedDate
        ),
        arrayOf(
            "Bahasa Sunda",
            "Membuat Biantara",
            formattedDate
        ),
        arrayOf(
            "Bahasa Inggris",
            "Presentation",
            formattedDate
        ),
        arrayOf(
            "Bahasa Jerman",
            "Gutten Morgen",
            formattedDate
        )
    )

    val listTugas: ArrayList<TugasModel>
        get() {
            val list = arrayListOf<TugasModel>()

            for (data in tugas) {
                val tugas = TugasModel()
                tugas.tugasMapel = data[0]
                tugas.tugas = data[1]
                tugas.tanggal = data[2]
                list.add(tugas)
            }
            return list
        }


    val listTanggal: ArrayList<JadwalDetailModel>
        get() {
            val list = arrayListOf<JadwalDetailModel>()
            var tanggalNo = SimpleDateFormat("dd")
            var calendare: Calendar = Calendar.getInstance()
            val tanggal = arrayOf("M", "T", "W", "T", "F", "S", "S")
            var ite: Int = 0

            for (data in tanggal) {
                val tanggal = JadwalDetailModel()
                tanggal.hari = data
                tanggal.tanggalNo = tanggalNo.format(calendare.time)
                list.add(tanggal)
                ite = ite + 1
                calendare.set(Calendar.DATE, ite)
            }
            return list
        }

}