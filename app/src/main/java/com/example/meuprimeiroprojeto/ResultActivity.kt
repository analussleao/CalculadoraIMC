package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textView_result)
        val tvClassificacao = findViewById<TextView>(R.id.tvClassificacao)
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        var classificacao = " "

        if (result < 18.50f) {
            classificacao = "Abaixo do Peso"
        } else if (result in 18.50f..24.99f) {
            classificacao = "Normal"
        } else if (result in 25.00f..29.99f) {
            classificacao = "Sobrepeso"
        } else if (result in 30.00f..39.99f) {
            classificacao = "Obesidade"
        } else { (result >= 40.00f)
            classificacao = "Obesidade Grave"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)

    }
        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            finish()
            return super.onOptionsItemSelected(item)



    }
}
