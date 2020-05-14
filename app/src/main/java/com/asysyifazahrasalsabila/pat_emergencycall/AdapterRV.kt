package com.asysyifazahrasalsabila.pat_emergencycall

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item.view.*

class AdapterRV (private val list: ArrayList<Model>) : RecyclerView.Adapter<AdapterRV.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterRV.Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AdapterRV.Holder, position: Int) {
        val data = list[position]
        holder.txtName.text = data.name
        Glide.with(holder.itemView.context).load(data.photo).into(holder.imgPhoto)

        holder.itemView.setOnClickListener{
            var intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("name", data.name)
            intent.putExtra("photo", data.photo)
            intent.putExtra("detail", data.detail)
            holder.itemView.context.startActivity(intent)
        }
    }

    class Holder (view: View) : RecyclerView.ViewHolder(view) {
        var txtName: TextView = view.findViewById(R.id.txtList)
        val imgPhoto: ImageView = view.findViewById(R.id.imgList)
    }
}