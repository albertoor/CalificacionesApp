package com.albertoornelas.calificacionesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.math.round



/**
 * This my View Binding
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get references
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val txtScore = findViewById<EditText>(R.id.txtRecord)
        val txtFirstPartial = findViewById<EditText>(R.id.txtFirstPartial)
        val txtSecondPartial = findViewById<EditText>(R.id.txtSecondPartial)
        val txtThirdPartial = findViewById<EditText>(R.id.txtThirdPartial)


        btnCalcular.setOnClickListener {
            val scoreObj = Score(txtScore.text.toString(), txtFirstPartial.text.toString().toDouble(),
                txtSecondPartial.text.toString().toDouble(), txtThirdPartial.text.toString().toDouble())
            val score = calculateScore(scoreObj.fPartial, scoreObj.sPartial, scoreObj.tPartial)
            val text = "La calificacion para el expediente ${scoreObj.record} es : $score"
            Toast.makeText(this, text, Toast.LENGTH_LONG).show()
        }

    }

    private fun calculateScore(p1: Double, p2: Double, p3: Double): Double{
        return round((p1 + p2 + p3) / 3)
    }
}