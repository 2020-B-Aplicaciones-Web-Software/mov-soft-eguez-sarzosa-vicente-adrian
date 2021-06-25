package com.example.moviles_software_2021_a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class BListView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blist_view)

        val arregloNumeros = arrayListOf<Int>(1, 2, 3)

        val adaptador = ArrayAdapter(
            this, // Contexto
            android.R.layout.simple_list_item_1, // Layout (visual)
            arregloNumeros // Arreglo
        )

        val listViewEjemplo = findViewById<ListView>(R.id.txv_ejemplo)
        listViewEjemplo.adapter = adaptador
        val botonListView = findViewById<Button>(R.id.btn_list_view_anadir)
        botonListView
            .setOnClickListener { anadirItemsAlListView(1, arregloNumeros, adaptador) }

//        listViewEjemplo
//            .setOnItemLongClickListener { adapterView, view, posicion, id ->
//                Log.i("list-view", "Dio click ${posicion}")
//                return@setOnItemLongClickListener true
//            }
        registerForContextMenu(listViewEjemplo)

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)

    }


















    fun anadirItemsAlListView(
        valor: Int,
        arreglo: ArrayList<Int>,
        adaptador: ArrayAdapter<Int>
    ) {
        arreglo.add(valor)
        adaptador.notifyDataSetChanged()
    }
}