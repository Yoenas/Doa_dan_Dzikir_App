package com.example.doadandzikirapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.doadandzikirapp.R
import com.example.doadandzikirapp.helper.OnItemClickCallback
import com.example.doadandzikirapp.model.Artikel
import com.example.doadandzikirapp.ui.detail.DetailArtikelActivity

class ArtikelAdapter(private val listArtikel: ArrayList<Artikel>) :
    RecyclerView.Adapter<ArtikelAdapter.MyViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

//    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
//        this.onItemClickCallback = onItemClickCallback
//    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgArtikel: ImageView = view.findViewById(R.id.img_artikel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.fragment_artikel, parent, false)
    )

    override fun getItemCount() = listArtikel.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val holderImage = holder.imgArtikel
        holderImage.apply {
            setImageResource(listArtikel[position].imageArtikel)
            setOnClickListener {
                val intent = Intent(context, DetailArtikelActivity::class.java)
                intent.putExtra(DetailArtikelActivity.DATA_TITLE, listArtikel[position].titleArtikel)
                intent.putExtra(DetailArtikelActivity.DATA_DESC, listArtikel[position].descArtikel)
                intent.putExtra(DetailArtikelActivity.DATA_IMAGE, listArtikel[position].imageArtikel)
                context.startActivity(intent)
            }
        }
    }
}