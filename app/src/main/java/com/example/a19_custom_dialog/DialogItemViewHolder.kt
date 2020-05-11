package com.example.a19_custom_dialog

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_dialog.view.*

class DialogItemViewHolder(itemView: View, val  adapter: DialogListAdapter): RecyclerView.ViewHolder(itemView) {

    fun populateModel(model: MyModel, pos: Int, activity: Custom_dialog){
        itemView.tvNumber.text = model.number.toString()

        if (model.isselected){
            itemView.imageNumber.setBackgroundResource(R.drawable.selector_bg)
            activity.pos = model.number
        }

        itemView.setOnClickListener {
            model.isselected = true
            adapter.selectedItemPosition = pos
        }

    }

}