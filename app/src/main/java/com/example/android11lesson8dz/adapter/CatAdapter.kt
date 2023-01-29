package com.example.android11lesson8dz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android11lesson8dz.`interface`.OnItemTextListener
import com.example.android11lesson8dz.data.CatModel
import com.example.android11lesson8dz.databinding.ItemCatBinding

class CatAdapter(
    var listCat: MutableList<CatModel>,
    private val onItemTextListener: OnItemTextListener


) : RecyclerView.Adapter<CatAdapter.CatViewHolder>(), OnLongClickListener {

    inner class CatViewHolder(var binding: ItemCatBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(catModel: CatModel) {
            binding.txtStatusCode.text = catModel.name
            Glide.with(binding.imageCat.context).load(catModel.image).into(binding.imageCat)
            itemView.setOnClickListener {
                onItemTextListener.onItemClick(catModel)
                binding.txtStatusCode.text = catModel.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        return CatViewHolder(
            ItemCatBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.onBind(listCat[position])
        holder.itemView.setOnLongClickListener(this)
        holder.onBind(listCat[position])
        holder.itemView.setOnLongClickListener {
            listCat.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
            true
        }
    }

    override fun getItemCount(): Int =
        listCat.size

    override fun onLongClick(v: View?): Boolean {
        onItemTextListener  .onLongClick(v?.tag as CatModel)
        return true
    }

}