package com.example.restaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val categorias = arrayOf("Categorias", "Recomendaciones", "Bebidas")
        val spinner = findViewById<Spinner>(R.id.mySpinner)
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categorias)
        spinner.adapter = arrayAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val intent = when (position) {
                    1 -> Intent(this@MainActivity, Recomendaciones::class.java)
                    2 -> Intent(this@MainActivity, Bebidas::class.java)
                    3 -> Intent(this@MainActivity, PlatoPrincipal::class.java)
                    4 -> Intent(this@MainActivity, Ensaladas::class.java)
                    5 -> Intent(this@MainActivity, Postres::class.java)
                    else -> null
                }
                intent?.let {
                    it.putExtra("spinnerSelection", position)
                    startActivity(it)
                    finish()
                }
                Toast.makeText(this@MainActivity, "Seleccionado: " + categorias[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // No hace nada
            }
        }
    }
}
