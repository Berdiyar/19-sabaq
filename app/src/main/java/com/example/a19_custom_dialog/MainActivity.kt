package com.example.a19_custom_dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_dialog.*
import kotlinx.android.synthetic.main.custom_dialog.view.*
import kotlinx.android.synthetic.main.custom_dialog.view.btnOk

class MainActivity : AppCompatActivity() {

    private val adapter: ListAdapter = ListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        setData(1)
    }

    private fun setData(count: Int) {
        val models: MutableList<User> = mutableListOf()
        for(i in 0 until count) {
            val model = User()
            model.title = "Title ${i+1}"
            model.description = "Description ${i+1}"
            models.add(model)
        }
        adapter.setData(models)
    }

    fun onOptionsButtonClick(view: View, position: Int) {
        val optionsMenu = PopupMenu(this, view)
        val menuInflater = optionsMenu.menuInflater
        menuInflater.inflate(R.menu.menu_item_options, optionsMenu.menu)
        optionsMenu.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.itemAdd -> {
                    val dialog = Custom_dialog(this,this)
                    dialog.show()
                    dialog.btnOk.setOnClickListener {
                        adapter.addUser(position, "Title ${dialog.pos}","Description ${dialog.pos}" )
                        dialog.dismiss()
                    }
                }
                R.id.itemDelete -> {
                    val dialog = AlertDialog.Builder(this)
                        .setTitle("Aniq o'shirejaqsizba?")
                        .setMessage("Eger bul item o'shse oni tiklewdin' ilaji joq.")
                        .setPositiveButton("Awa"){
                            dialog, which ->
                            adapter.remove(position)
                        }
                        .setNegativeButton("Yaq"){
                            dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
            return@setOnMenuItemClickListener true
        }
        optionsMenu.show()
    }
}
