package com.example.android11lesson8dz.`interface`

import com.example.android11lesson8dz.adapter.CatAdapter
import com.example.android11lesson8dz.data.CatModel

interface OnItemTextListener {
    fun onItemClick(model : CatModel )
    fun onLongClick (model : CatModel ): Boolean
}