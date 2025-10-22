package com.example.tp2_calculatrice

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var sign: String? = null
    private var tempDouble1: Double? = null

    private lateinit var output: TextView
    private lateinit var tvVisits: TextView
    
    // Flag to check if an operator was just pressed
    private var operatorJustPressed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        output = findViewById(R.id.editText)
        tvVisits = findViewById(R.id.tvVisits)

        val button0: Button = findViewById(R.id.button0)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)

        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        val buttonSubtract: Button = findViewById(R.id.buttonSubtract)
        val buttonMultiply: Button = findViewById(R.id.buttonMultiply)
        val buttonDivide: Button = findViewById(R.id.buttonDivide)
        val buttonC: Button = findViewById(R.id.buttonC)
        val buttonE: Button = findViewById(R.id.buttonE)

        // Set click listeners for numbers
        val numberClickListener = View.OnClickListener { v ->
            val button = v as Button
            // If operator was just pressed, clear the output first
            if (operatorJustPressed) {
                output.text = ""
                operatorJustPressed = false
            }
            output.append(button.text)
        }
        button0.setOnClickListener(numberClickListener)
        button1.setOnClickListener(numberClickListener)
        button2.setOnClickListener(numberClickListener)
        button3.setOnClickListener(numberClickListener)
        button4.setOnClickListener(numberClickListener)
        button5.setOnClickListener(numberClickListener)
        button6.setOnClickListener(numberClickListener)
        button7.setOnClickListener(numberClickListener)
        button8.setOnClickListener(numberClickListener)
        button9.setOnClickListener(numberClickListener)

        // Set click listener for "C"
        buttonC.setOnClickListener {
            output.text = ""
            tempDouble1 = null
            sign = null
            operatorJustPressed = false
        }

        // Set click listeners for operators
        val operatorClickListener = View.OnClickListener { v ->
            val button = v as Button
            if (output.text.isNotEmpty()) {
                tempDouble1 = output.text.toString().toDoubleOrNull()
                if (tempDouble1 != null) {
                    sign = button.text.toString()
                    operatorJustPressed = true // Set the flag, but don't clear the output
                }
            }
        }
        buttonAdd.setOnClickListener(operatorClickListener)
        buttonSubtract.setOnClickListener(operatorClickListener)
        buttonMultiply.setOnClickListener(operatorClickListener)
        buttonDivide.setOnClickListener(operatorClickListener)

        // Set click listener for "="
        buttonE.setOnClickListener {
            if (output.text.isNotEmpty() && tempDouble1 != null && sign != null && !operatorJustPressed) {
                val tempDouble2 = output.text.toString().toDouble()
                var result = 0.0
                when (sign) {
                    "+" -> result = tempDouble1!! + tempDouble2
                    "-" -> result = tempDouble1!! - tempDouble2
                    "*" -> result = tempDouble1!! * tempDouble2
                    "/" -> {
                        if (tempDouble2 == 0.0) {
                            output.text = "Error"
                            operatorJustPressed = true
                            return@setOnClickListener
                        }
                        result = tempDouble1!! / tempDouble2
                    }
                }
                output.text = result.toString()
                tempDouble1 = null
                sign = null
                operatorJustPressed = true // After a calculation, prepare for a new input
            }
        }
        
        // SharedPreferences logic
        val prefs: SharedPreferences = getSharedPreferences("visits_prefs", Context.MODE_PRIVATE)
        var visits = prefs.getInt("visits", 0)
        visits++
        
        val editor = prefs.edit()
        editor.putInt("visits", visits)
        editor.apply()

        tvVisits.text = "Visits: $visits"
    }
}
