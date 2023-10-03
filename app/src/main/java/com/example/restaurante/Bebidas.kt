package com.example.restaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class Bebidas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bebidas)
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
                        0 ->  Intent(this@Bebidas, MainActivity::class.java)
                        1 -> Intent(this@Bebidas, Recomendaciones::class.java)
                        2 -> Intent(this@Bebidas, Bebidas::class.java)
                        3 -> Intent(this@Bebidas, PlatoPrincipal::class.java)
                        4 -> Intent(this@Bebidas, Ensaladas::class.java)
                        5 -> Intent(this@Bebidas, Postres::class.java)
                        else -> null
                    }
                    intent?.let {
                        it.putExtra("spinnerSelection", position)
                        startActivity(it)
                        finish()
                    }
                }
                Toast.makeText(this@Bebidas, "Seleccionado: " + categorias[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // No hace nada
            }
        }
    }
}