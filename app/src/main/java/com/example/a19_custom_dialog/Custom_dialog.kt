package com.example.a19_custom_dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_dialog.*
import java.text.FieldPosition

class Custom_dialog(context: Context, activity: MainActivity): Dialog(context) {

    var pos: Int = 0

    private val adapterdialog = DialogListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_dialog)

        recyclerdialog.adapter = adapterdialog
        setData()
        btnCancel.setOnClickListener {
            dismiss()
        }
    }

    fun setData(){
        val sanlar: MutableList<MyModel> = mutableListOf()
        for(i in 0 until 50){
            sanlar.add(MyModel(i+1, false))
        }
        adapterdialog.models = sanlar
    }

    fun onCliskDialog(position: Int){
        pos = position
    }

}