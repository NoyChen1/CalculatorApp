package com.example.calculatorapp

import android.app.Activity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() , View.OnClickListener {


    //Button addBtn; in Java
    lateinit var addBtn : Button
    lateinit var subBtn : Button
    lateinit var mulBtn : Button
    lateinit var divBtn : Button

    lateinit var etA : EditText
    lateinit var etB : EditText
    lateinit var etRes : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //same as Java
        addBtn = findViewById(R.id.add_btn)
        subBtn = findViewById(R.id.sub_btn)
        mulBtn = findViewById(R.id.mul_btn)
        divBtn = findViewById(R.id.div_btn)

        etA = findViewById(R.id.a_et)
        etA.inputType = InputType.TYPE_CLASS_NUMBER
        etB = findViewById(R.id.b_et)
        etB.inputType = InputType.TYPE_CLASS_NUMBER
        etRes = findViewById(R.id.res_et)


        addBtn.setOnClickListener(this)
        subBtn.setOnClickListener(this)
        mulBtn.setOnClickListener(this)
        divBtn.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        var a = etA.text.toString().toDouble()
        var b = etB.text.toString().toDouble()
        var res = 0.0 //to make it double

        //in kotlin we dont have switch case so we use the "when"
        //? makes it null safe
        when(v?.id){
            R.id.add_btn ->{
                res = a+b
                dismissKeyboard(this)
            }
            R.id.sub_btn ->{
                res = a-b
                dismissKeyboard(this)
            }
            R.id.mul_btn ->{
                res = a*b
                dismissKeyboard(this)
            }
            R.id.div_btn ->{
                res = a/b
                dismissKeyboard(this)
            }
        }

        etRes.text = "Result: $res"
    }
    fun dismissKeyboard(activity: Activity) {
        val imm = activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        if (null != activity.currentFocus) imm.hideSoftInputFromWindow(
            activity.currentFocus!!
                .applicationWindowToken, 0
        )
    }

}