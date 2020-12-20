package com.example.mycalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_screen2.*

class ActivityHistory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen2)

        var historyStr: String = """
            ${intent.getStringExtra("VarTestString")}
            ${intent.getIntExtra("VarTestInt",0)}
            ${intent.getFloatExtra("VarTestFloat", 228.5F)}
        """.trimIndent()

        intent.getParcelableExtra<CalculationHistory>("ObjectTest",)?.calculationList?.map{
            historyStr += "\n${it.express} = ${it.results}"
        }

        txtPrint.text = historyStr
    }
}