package com.example.doadandzikirapp

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.doadandzikirapp.adapter.ArtikelAdapter
import com.example.doadandzikirapp.model.Artikel
import com.example.doadandzikirapp.ui.HarianDzikirDoaActivity
import com.example.doadandzikirapp.ui.PagiPetangDzikirActivity
import com.example.doadandzikirapp.ui.QauliyahShalatActivity
import com.example.doadandzikirapp.ui.SetiapSaatDzikirActivity

class MainActivity : AppCompatActivity() {

    private lateinit var vpArtikel: ViewPager2
    private lateinit var sliderIndicator: Array<ImageView?>

    private val listArtikel: ArrayList<Artikel> = arrayListOf()

    private val slidingCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            for (i in 0 until listArtikel.size) {
                sliderIndicator[i]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.dot_inactive)
                )
            }

            sliderIndicator[position]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext, R.drawable.dot_active)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        initView()
        setupViewPager()
    }

    private fun setupViewPager() {
        // Use this if using parcelable for passing data
        /* val artikelAdapter = ArtikelAdapter(artikelArray)
         artikelAdapter.setOnItemClickCallback(object : OnItemClickCallback {
             override fun onItemClicked(data: Artikel) {
                 val intent = Intent(applicationContext, DetailArtikelActivity::class.java)

 //                intent.putExtra("title", data.titleArtikel)
 //                intent.putExtra("desc", data.descArtikel)
 //                intent.putExtra("image", data.imageArtikel)

                 intent.putExtra("data", data)
                 startActivity(intent)
             }
         })*/

        val llSliderDots: LinearLayout = findViewById(R.id.ll_slider_dots)

        sliderIndicator = arrayOfNulls(listArtikel.size)

        for (i in 0 until listArtikel.size) {
            sliderIndicator[i] = ImageView(this)
            sliderIndicator[i]?.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext, R.drawable.dot_inactive
                )
            )

            // menentukan lebar dan tinggi indicator
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            // mengatur jarak antar indicator
            params.setMargins(9, 0, 8, 0)
            // mengatur posisi indicator
            params.gravity = Gravity.CENTER_VERTICAL
            // menerapkan params sebagai aturan bagaimana indicator ditampilkan
            llSliderDots.addView(sliderIndicator[i], params)
        }

        sliderIndicator[0]?.setImageDrawable(
            ContextCompat.getDrawable(
                applicationContext, R.drawable.dot_active
            )
        )
    }

    private fun initData() {
        // bagian artikel
        val titleArtikel = resources.getStringArray(R.array.arr_title_artikel)
        val descArtikel = resources.getStringArray(R.array.arr_desc_artikel)
        val imgArtikel = resources.obtainTypedArray(R.array.arr_img_artikel)

        for (data in titleArtikel.indices) {
            val artikel = Artikel(
                imgArtikel.getResourceId(data, 0),
                titleArtikel[data],
                descArtikel[data]
            )
            listArtikel.add(artikel)
        }
        imgArtikel.recycle()
    }

    private fun initView() {
        val llDzikirDoaShalat: LinearLayout = findViewById(R.id.ll_dzikir_doa_shalat)
        llDzikirDoaShalat.setOnClickListener {
            startActivity(Intent(this, QauliyahShalatActivity::class.java))
        }

        val llDzikirSetiapSaat = findViewById<LinearLayout>(R.id.ll_dzikir_setiap_saat)
        llDzikirSetiapSaat.setOnClickListener {
            startActivity(Intent(this, SetiapSaatDzikirActivity::class.java))
        }

        val llDzikirDoaHarian: LinearLayout = findViewById(R.id.ll_dzikir_doa_harian)
        llDzikirDoaHarian.setOnClickListener {
            startActivity(Intent(this, HarianDzikirDoaActivity::class.java))
        }

        val llDzikirPagiPetang: LinearLayout = findViewById(R.id.ll_dzikir_pagi_petang)
        llDzikirPagiPetang.setOnClickListener {
            startActivity(Intent(this, PagiPetangDzikirActivity::class.java))
        }

        vpArtikel = findViewById(R.id.vp_artikel)
        vpArtikel.adapter = ArtikelAdapter(listArtikel)
        vpArtikel.registerOnPageChangeCallback(slidingCallback)
    }

    override fun onDestroy() {
        super.onDestroy()
        vpArtikel.unregisterOnPageChangeCallback(slidingCallback)
    }
}