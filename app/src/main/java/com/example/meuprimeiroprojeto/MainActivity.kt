package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btncalcular: Button = findViewById(R.id.btncalcular)
        val edtPeso : EditText = findViewById(R.id.edtTextPeso)
        val edtAltura :EditText = findViewById(R.id.edtTextAltura)
        val tvResult : TextView = findViewById(R.id.txtMsg)

        btncalcular.setOnClickListener {

            val alturaStr = edtAltura.text.toString ()
            val pesoStr = edtPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {

                val altura: Float = alturaStr.toFloat()
                val peso: Float = pesoStr.toFloat()

                val altura_Final: Float = altura * altura
                val result: Float = peso / altura_Final

                tvResult.text = result.toString()


                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }


                startActivity(intent)
            } else {
                Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_LONG).show()
            }
    }
}}