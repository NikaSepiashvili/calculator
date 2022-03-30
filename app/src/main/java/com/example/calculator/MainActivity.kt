package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private lateinit var operator: String
    private lateinit var dotButton: Button
    private lateinit var equalButton: Button
    private var operand: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultTextView = findViewById(R.id.textView)
        dotButton = findViewById(R.id.dotButton)
        equalButton = findViewById(R.id.equalButton)
    }

    fun buttonClick(view: View) {
        if (view is Button) {
            var result = resultTextView.text.toString()

            if (result == "0"){
                result = ""
            }

            val btn = view.text.toString()
            val sum = result + btn
            resultTextView.text = sum
        }
        if (resultTextView.text.contains(".")) {
            dotButton.isEnabled = false
        }
    }

    fun operatorClick(view: View){
        if (view is Button){
            val operator = view.text.toString()
            this.operator = operator
            val result = resultTextView.text.toString()
            if(!result.isNullOrEmpty()){
                operand = result.toDouble()
            }

            resultTextView.text = ""
        }
    }

    fun equalsClick(view: View) {
        val secOperand = resultTextView.text.toString()
        var sec = 0.0

        if(!secOperand.isNullOrEmpty()){
            sec = secOperand.toDouble()
        }


        when(operator){
            "+" -> resultTextView.text = (operand + sec).toString()
            "-" -> resultTextView.text = (operand - sec).toString()
            "*" -> resultTextView.text = (operand * sec).toString()
            "/" -> resultTextView.text = (operand / sec).toString()
            "+/-" -> resultTextView.text = (operand * -1).toString()
            "√" -> resultTextView.text = (sqrt(sec)).toString()
            "%" -> resultTextView.text = (operand * sec/100).toString()

        }
    }

    fun clearClick(view: View) {
        val text = resultTextView.text
        if (!text.isNullOrEmpty()) {
            resultTextView.text = text.drop(text.length)
        }
    }


}