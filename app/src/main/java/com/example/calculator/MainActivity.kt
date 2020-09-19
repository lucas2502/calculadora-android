package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        numberZero.setOnClickListener { AddOneExpression(string = "0", clearAll = true) }
        numberOne.setOnClickListener { AddOneExpression(string = "1", clearAll = true) }
        numberTwo.setOnClickListener { AddOneExpression(string= "2", clearAll= true) }
        numberThree.setOnClickListener { AddOneExpression(string ="3", clearAll= true) }
        numberFour.setOnClickListener { AddOneExpression(string= "4", clearAll= true) }
        numberFive.setOnClickListener { AddOneExpression(string= "5", clearAll= true) }
        numberSix.setOnClickListener { AddOneExpression(string= "6", clearAll= true) }
        numberSeven.setOnClickListener { AddOneExpression(string= "7", clearAll= true) }
        numberEite.setOnClickListener { AddOneExpression(string= "8", clearAll= true) }
        numberNine.setOnClickListener { AddOneExpression(string= "9", clearAll= true) }
        point.setOnClickListener { AddOneExpression(string= ".", clearAll= true) }

        sum.setOnClickListener { AddOneExpression(string= "+", clearAll= false) }
        sub.setOnClickListener { AddOneExpression(string= "-", clearAll= false) }
        divider.setOnClickListener { AddOneExpression(string= "/", clearAll= false) }
        multiple.setOnClickListener { AddOneExpression(string= "*", clearAll= false) }

        clear.setOnClickListener {
           expresion.text = ""
            result.text = ""
        }
        backscape.setOnClickListener {
            val string = expresion.text.toString()

            if(string.isNotBlank()){
                expresion.text = string.substring(0, string.length-1)
            }

            result.text = ""
        }

        equal.setOnClickListener {
            try{
                val expression = ExpressionBuilder(expresion.text.toString()).build()

                val localResult = expression.evaluate()
                val longResult = localResult.toLong()

                if(localResult == longResult.toDouble()){
                    result.text = longResult.toString()
                } else{
                    result.text = result.toString()
                }
            }catch (err: Exception) {

            }
        }


    }

    private fun AddOneExpression(string: String, clearAll : Boolean){
        if (result.text.isNotEmpty()){
            result.text = ""
        }

        if (clearAll){
            result.text = ""
            expresion.append(string)
        }else{
            expresion.append(result.text)
            expresion.append(string)
            result.text = ""
        }
    }
}