package com.sandhya.activityfragmentinteraction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var count = 0
    lateinit var tvCount : TextView
    lateinit var activityInterface: ActivityInterface
    var etName : EditText?= null
    var btnChangeFragment : Button? = null
    var btnRed : Button? = null
    var btnBlue : Button? = null
    var btnGreen : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvCount = findViewById(R.id.tvCount)
        etName = findViewById(R.id.etName)
        btnChangeFragment = findViewById(R.id.btnChangeFragment)
        btnRed = findViewById(R.id.btnRed)
        btnBlue = findViewById(R.id.btnblue)
        btnGreen = findViewById(R.id.btnGreen)

        btnChangeFragment?.setOnClickListener {
            if (etName?.text.toString().trim().isNullOrEmpty()){
                etName?.error = "Enter something"
            }else{
                activityInterface.getValue(etName?.text.toString())
            }
        }
        btnRed?.setOnClickListener {
            activityInterface.getColorRed(value = toString())
        }
        btnBlue?.setOnClickListener {
            activityInterface.getColorBlue(value = toString())
        }
        btnGreen?.setOnClickListener {
            activityInterface.getColorGreen(value = toString())
        }
    }

    fun incrementNumber(){
        count = count + 1
        tvCount.setText(count.toString())
    }

    fun decrementNumber(){
        if (count >= 1) {
            count = count - 1
            tvCount.setText(count.toString())
        }
    }
}