package com.example.moviles_software_2021_a

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    val CODIGO_RESPUESTA_INTENT_EXPLICITO = 401
    val CODIGO_RESPUESTA_INTENT_IMPLICITO = 402

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // this.findViewById<>()
        val botonIrACicloVida = findViewById<Button>(
            R.id.btn_ciclo_vida
        )
        botonIrACicloVida
            .setOnClickListener {
                abrirCicloVida(
                    ACicloVida::class.java
                )
            }
        val botonIrListView = findViewById<Button>(
            R.id.btn_ir_list_view
        )
        botonIrListView
            .setOnClickListener {
                abrirCicloVida(
                    BListView::class.java
                )
            }

        val botonIntenExplicito = findViewById<Button>(R.id.btn_ir_intent)
        botonIntenExplicito
            .setOnClickListener {
                abrirActividadConParametros(CIntentExplicitoParametros::class.java)
            }

        val botonAbrirIntenImplicito = findViewById<Button>(R.id.btn_intent_implicito)
        botonAbrirIntenImplicito
            .setOnClickListener {
                val intentConRespuestaImplicito = Intent(
                        Intent.ACTION_PICK, // Accion
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI // Solicitamos URI
                    )
                startActivityForResult(intentConRespuestaImplicito, CODIGO_RESPUESTA_INTENT_IMPLICITO)
            }

        val botonIrRecyclerView = findViewById<Button>(R.id.btn_ir_recycler_view)
        botonIrRecyclerView
            .setOnClickListener {
                abrirActividadConParametros(GRecyclerView::class.java)
            }

        val botonIrHttp = findViewById<Button>(R.id.btn_ir_http)
        botonIrHttp
            .setOnClickListener {
                abrirActividadConParametros(HHttpActivity::class.java)
            }

    }

    fun abrirActividadConParametros(
        clase: Class<*>
    ) {
        val intentExplicito = Intent(
            this,
            clase
        )
        intentExplicito.putExtra("nombre", "Adrian")
        intentExplicito.putExtra("apellido", "Eguez")
        intentExplicito.putExtra("edad", 32)
        intentExplicito.putExtra("entrenador",
            BEntrenador("Adrian", "Eguez", null)
        )

        startActivityForResult(intentExplicito, CODIGO_RESPUESTA_INTENT_EXPLICITO)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            CODIGO_RESPUESTA_INTENT_EXPLICITO -> {
                if (resultCode == RESULT_OK) {
                    Log.i("intent-explicito", "SI actualizo los datos")
                    if (data != null) {
                        val nombre = data.getStringExtra("nombreModificado")
                        val edad = data.getIntExtra("edadModificado", 0)

                        Log.i("intent-explicito", "${nombre}")
                        Log.i("intent-explicito", "${edad}")

                    }
                }
            }
            CODIGO_RESPUESTA_INTENT_IMPLICITO ->{
                if(resultCode == RESULT_OK){
                    if(data !=null){
                        val uri: Uri = data.data!!
                        val cursor = contentResolver.query(
                            uri,
                            null,
                            null,
                            null,
                            null,
                            null
                        )
                        cursor?.moveToFirst()
                        val indiceTelefono = cursor?.getColumnIndex(
                            ContactsContract.CommonDataKinds.Phone.NUMBER
                        )
                        val telefono = cursor?.getString(
                            indiceTelefono!!
                        )
                        cursor?.close()
                        Log.i("resultado", "Telefono ${telefono}")
                    }
                }
            }
        }
    }


    fun abrirCicloVida(
        clase: Class<*>
    ) {
        val intentExplicito = Intent(
            this,
            clase
        )
        // this.startActivity(intent)
        startActivity(intentExplicito)
    }
}