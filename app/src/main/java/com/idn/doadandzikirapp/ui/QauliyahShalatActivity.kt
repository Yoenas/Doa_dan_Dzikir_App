package com.idn.doadandzikirapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.idn.doadandzikirapp.R
import com.idn.doadandzikirapp.adapter.DzikirDoaAdapter
import com.idn.doadandzikirapp.model.DataDzikirDoa

class QauliyahShalatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_qauliyah_shalat)

        val rvQauliyah = findViewById<RecyclerView>(R.id.rv_qauliyah_shalat)
        rvQauliyah.layoutManager = LinearLayoutManager(this)

        rvQauliyah.adapter = DzikirDoaAdapter(DataDzikirDoa.listQauliyah)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}