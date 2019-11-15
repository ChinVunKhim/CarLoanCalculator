package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import com.example.carloancalculator.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val btn = findViewById<Button>(R.id.calculateButton)

        btn.setOnClickListener {
            val inputCarPrice = binding.editCarPrice.text.toString().toDouble()
            val inputDownPayment = binding.editDownPayment.text.toString().toDouble()
            val inputLoanPeriod = binding.editLoanPeriod.text.toString().toInt()
            val inputInterestRate = binding.editInterestRate.text.toString().toInt()

            val calcLoanAmount:Double = inputCarPrice - inputDownPayment
            val calcInterestAmount:Double = calcLoanAmount * (inputInterestRate/100.0) * inputLoanPeriod
            val calcPaymentAmount:Double = (calcLoanAmount+calcInterestAmount)/inputLoanPeriod/12.00000

            carLoanAmount.text = "RM%.2f".format(calcLoanAmount)
            interestAmount.text = "RM%.2f".format(calcInterestAmount)
            monthyPaymentAmount.text = "RM%.2f".format(calcPaymentAmount)
        }
    }
}
