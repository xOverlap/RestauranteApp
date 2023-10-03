package com.example.restaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.Toast

class Recomendaciones : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recomendaciones)

        val refrescoLayout = findViewById<LinearLayout>(R.id.cazuelaLayout)
        refrescoLayout.setOnClickListener {
            val intent = Intent(this, Cazuela::class.java)
            startActivity(intent)
        }

        val categorias = arrayOf("Categorias", "Recomendaciones", "Bebidas")
        val spinner = findViewById<Spinner>(R.id.mySpinner)
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categorias)
        spinner.adapter = arrayAdapter

        val spinnerSelection = intent.getIntExtra("spinnerSelection", 0)
        spinner.setSelection(spinnerSelection)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                if (position != spinnerSelection) {
                    val intent = when (position) {
                        0 ->  Intent(this@Recomendaciones, MainActivity::class.java)
                        1 -> Intent(this@Recomendaciones, Recomendaciones::class.java)
                        2 -> Intent(this@Recomendaciones, Bebidas::class.java)
                        3 -> Intent(this@Recomendaciones, PlatoPrincipal::class.java)
                        4 -> Intent(this@Recomendaciones, Ensaladas::class.java)
                        5 -> Intent(this@Recomendaciones, Postres::class.java)
                        else -> null
                    }
                    intent?.let {
                        it.putExtra("spinnerSelection", position)
                        startActivity(it)
                        finish()
                    }
                }
                Toast.makeText(this@Recomendaciones, "Seleccionado: " + categorias[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // No hace nada
            }
        }
    }
}
