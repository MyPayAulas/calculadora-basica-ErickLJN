package com.example.mycalculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    var digit_on_screen = StringBuilder()
    var operation: Char = ' '
    var leftHandSide: Double = 0.0
    var rightHandSide: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result_id.text = "0"

        initializeButtons()
    }

    private fun initializeButtons() {
        functionalButtons()
        operationalButtons()
        numericalButtons()
        extraButtons()
    }

    private fun numericalButtons() {

        one_btn.setOnClickListener {
            appendToDigitOnScreen("1")
        }

        two_btn.setOnClickListener {
            appendToDigitOnScreen("2")
        }

        three_btn.setOnClickListener {
            appendToDigitOnScreen("3")
        }

        four_btn.setOnClickListener {
            appendToDigitOnScreen("4")
        }

        five_btn.setOnClickListener {
            appendToDigitOnScreen("5")
        }

        six_btn.setOnClickListener {
            appendToDigitOnScreen("6")
        }

        seven_btn.setOnClickListener {
            appendToDigitOnScreen("7")
        }

        eight_btn.setOnClickListener {
            appendToDigitOnScreen("8")
        }

        nine_btn.setOnClickListener {
            appendToDigitOnScreen("9")
        }

        zero_btn.setOnClickListener {
            appendToDigitOnScreen("0")
        }

        dot_btn.setOnClickListener {
            appendToDigitOnScreen(".")
        }

        pi_btn.setOnClickListener(){
            appendToDigitOnScreen("3.14159265359")
        }
    }

    private fun appendToDigitOnScreen(digit: String) {

        digit_on_screen.append(digit)

        result_id.text = digit_on_screen.toString()
    }

        private fun operationalButtons() {

        addition_btn.setOnClickListener {
            selectOperation('A')
        }

        subtract_btn.setOnClickListener {
            selectOperation('S')
        }

        divide_btn.setOnClickListener {
            selectOperation('D')
        }

        multipy_btn.setOnClickListener {
            selectOperation('M')
        }

        power_btn.setOnClickListener(){
            selectOperation('P')
        }
    }

        private fun selectOperation(c: Char) {

        operation = c
        leftHandSide = digit_on_screen.toString().toDouble()
        digit_on_screen.clear()
        result_id.text = "$digit_on_screen"
        }

        class OperationsHelper {

        companion object {

            fun add(left_hand_side: Double, right_hand_side: Double): Double {
                val sum = left_hand_side + right_hand_side
                return sum
            }

            fun subtraction(left_hand_side: Double, right_hand_side: Double): Double {
                val subtract = left_hand_side - right_hand_side
                return subtract
            }

            fun division(left_hand_side: Double, right_hand_side: Double): Double {
                val divide = left_hand_side / right_hand_side
                return divide
            }

            fun multiply(left_hand_side: Double, right_hand_side: Double): Double {
                val product = left_hand_side * right_hand_side
                return product
            }

            fun pow(left_hand_side: Double, right_hand_side: Double): Double {
                val exponential = left_hand_side.pow(right_hand_side)
                return exponential
            }
        }
    }

    private fun functionalButtons() {

        clear_everything_btn.setOnClickListener {
            digit_on_screen.clear()
            result_id.text = digit_on_screen.toString()
        }

        clear_btn.setOnClickListener {
            clearDigit()
        }

        equal_btn.setOnClickListener {
            performMathOperation()
        }

    }

    private fun extraButtons(){

        hist_btn.setOnClickListener(){
            val intent = Intent(this, ActivityHistory::class.java)
            intent.putExtra("VarTestString", "my text")
            intent.putExtra("VarTestInt", 55)
            intent.putExtra("VarTestFloat", 228.5F)

            val history = CalculationHistory(mutableListOf(Calculation("1 + 1", "2")))
            intent.putExtra("ObjectTest", history)
            startActivity(intent)
        }
    }

    private fun performMathOperation() {

        rightHandSide = digit_on_screen.toString().toDouble()
        digit_on_screen.clear()

        when (operation) {

            'A' -> {
                val sum = OperationsHelper.add(leftHandSide, rightHandSide)
                result_id.text = sum.toString()
                digit_on_screen.append(sum)
            }
            'S' -> {
                val subtract = OperationsHelper.subtraction(leftHandSide, rightHandSide)
                result_id.text = subtract.toString()
                digit_on_screen.append(subtract)
            }
            'M' -> {
                val multiply = OperationsHelper.multiply(leftHandSide, rightHandSide)
                result_id.text = multiply.toString()
                digit_on_screen.append(multiply)
            }
            'D' -> {
                val divide = OperationsHelper.division(leftHandSide, rightHandSide)
                result_id.text = divide.toString()
                digit_on_screen.append(divide)
            }
            'P' -> {
                val exponential = OperationsHelper.pow(leftHandSide, rightHandSide)
                result_id.text = exponential.toString()
                digit_on_screen.append(exponential)
            }
        }
    }

    private fun clearDigit() {

        digit_on_screen.clear()
        result_id.text = digit_on_screen.toString()
    }
}