package com.example.android11lesson8dz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android11lesson8dz.`interface`.OnItemTextListener
import com.example.android11lesson8dz.data.CatModel
import com.example.android11lesson8dz.databinding.ItemProgramBinding

class ProgAdapter(
    private var listCat: MutableList<CatModel>,
    private val onItemTextListener: OnItemTextListener

) : RecyclerView.Adapter<ProgAdapter.ProgViewHolder>(), OnLongClickListener {

    inner class ProgViewHolder(var binding: ItemProgramBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(catModel: CatModel) {
            binding.txtStatusCodeProg.text = catModel.name
            Glide.with(binding.imageCatProg.context).load(catModel.image).into(binding.imageCatProg)
            itemView.setOnClickListener {
                onItemTextListener.onItemClick(catModel)
                binding.txtStatusCodeProg.text = catModel.toString()
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgViewHolder {
        return ProgViewHolder(
            ItemProgramBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProgViewHolder, position: Int) {
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