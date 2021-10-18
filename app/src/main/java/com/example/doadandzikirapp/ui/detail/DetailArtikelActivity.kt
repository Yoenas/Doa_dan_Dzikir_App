package com.example.doadandzikirapp.ui.detail

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.doadandzikirapp.R
import com.example.doadandzikirapp.model.Artikel

class DetailArtikelActivity : AppCompatActivity() {

    private lateinit var imgDetail: ImageView
    private lateinit var tvTitle: TextView
    private lateinit var tvDesc: TextView

    companion object {
        const val DATA_TITLE = "title"
        const val DATA_DESC = "data"
        const val DATA_IMAGE = "image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Artikel Islami"
        setContentView(R.layout.activity_detail_artikel)

        val dataTitle = intent.getStringExtra(DATA_TITLE)
        val dataDesc = intent.getStringExtra(DATA_DESC)
        val dataImage = intent.getIntExtra(DATA_IMAGE, 0)

        val tvTitle: TextView = findViewById(R.id.tv_detail_title)
        tvTitle.text = dataTitle
        val tvDesc: TextView = findViewById(R.id.tv_detail_desc)
        tvDesc.text = dataDesc
        val imgArtikel: ImageView = findViewById(R.id.img_detail)
        imgArtikel.setImageResource(dataImage)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}