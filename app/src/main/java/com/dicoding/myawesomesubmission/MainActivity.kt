package com.dicoding.myawesomesubmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import com.dicoding.myawesomesubmission.views.HomeFragment
import com.dicoding.myawesomesubmission.views.JadwalDetailActivity
import com.dicoding.myawesomesubmission.views.ProfileFragment
import com.dicoding.myawesomesubmission.views.TugasGridActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        toolbar.setTitle("")

        val bottomNav: BottomNavigationView = findViewById(R.id.bottomAppBar)
        bottomNav.setOnNavigationItemSelectedListener(navListener)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                HomeFragment()
            ).commit()
        }

    }

    private val navListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item: MenuItem ->
            var selectedFragment: Fragment = HomeFragment()

            when (item.itemId) {
                R.id.nav_home -> selectedFragment = HomeFragment()
                R.id.nav_jadwal -> {
                    startActivity(Intent(this, JadwalDetailActivity::class.java))
                }
                R.id.nav_tugas -> {
                    startActivity(Intent(this, TugasGridActivity::class.java))
                }
                R.id.nav_about -> selectedFragment = ProfileFragment()
            }

            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                selectedFragment
            ).commit()

            true
        }

}
