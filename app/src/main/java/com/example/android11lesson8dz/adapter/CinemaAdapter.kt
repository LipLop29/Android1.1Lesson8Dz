package com.example.android11lesson8dz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android11lesson8dz.`interface`.OnItemTextListener
import com.example.android11lesson8dz.data.CatModel
import com.example.android11lesson8dz.databinding.ItemCinemaBinding

class CinemaAdapter(
    private var listCat: MutableList<CatModel>,
    private val onItemTextListener: OnItemTextListener

) : RecyclerView.Adapter<CinemaAdapter.CinemaViewHolder>(), OnLongClickListener {

    inner class CinemaViewHolder(var binding: ItemCinemaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(catModel: CatModel) {
            binding.txtStatusCodeCinema.text = catModel.name
            Glide.with(binding.imageCatCinema.context).load(catModel.image)
                .into(binding.imageCatCinema)
            itemView.setOnClickListener {
                onItemTextListener.onItemClick(catModel)
                binding.txtStatusCodeCinema.text = catModel.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CinemaViewHolder {
        return CinemaViewHolder(
            ItemCinemaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CinemaViewHolder, position: Int) {
        holder.onBind(listCat[position])
        holder.itemView.setOnLongClickListener(this)
        holder.onBind(listCat[position])
        holder.itemView.setOnLongClickListener {
            listCat.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
            true
        }
    }

    override fun getItemCount(): Int = listCat.size

    override fun onLongClick(v: View?): Boolean {
        TODO("Not yet implemented")
    }
}