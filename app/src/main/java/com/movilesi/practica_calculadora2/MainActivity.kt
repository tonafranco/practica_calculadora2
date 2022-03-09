package com.movilesi.practica_calculadora2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.movilesi.practica_calculadora2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var firstValue: Double = 0.0
    var operator: Char = '0'

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonClear.setOnClickListener {
            binding.editTextNumber.text.clear()
        }
        binding.buttonDelete.setOnClickListener {
            binding.editTextNumber.setText(binding.editTextNumber.text.dropLast(1))
        }

        binding.buttonEquals.setOnClickListener{
            when(operator){
                 'x'->{
                    binding.editTextNumber.setText("${firstValue * binding.editTextNumber.text.toString().toDouble()}")
                }
                '/' ->{
                    binding.editTextNumber.setText("${firstValue / binding.editTextNumber.text.toString().toDouble()}")
                }
                '+' ->{
                    binding.editTextNumber.setText("${firstValue + binding.editTextNumber.text.toString().toDouble()}")
                }
                '-' ->{
                    binding.editTextNumber.setText("${firstValue - binding.editTextNumber.text.toString().toDouble()}")
                }
                else -> { }
            }
        }

        binding.buttonPercentage.setOnClickListener{
            binding.editTextNumber.setText("${binding.editTextNumber.text.toString().toDouble() / 100}")
        }

    }

    fun numberButtonClicked(view: View){
        val button = view as Button

        if (button.id.equals(binding.buttonDecimal.id) ){
            if ( !binding.editTextNumber.text.contains('.')){
                binding.editTextNumber.text.append(button.text)
            }
        }else{
            binding.editTextNumber.text.append(button.text)
        }
    }

    fun getOperator(view: View){
        val button = view as Button
        operator = when(button.id){
            binding.buttonMultiplication.id -> {'x'}
            binding.buttonDivision.id -> {'/'}
            binding.buttonAddition.id -> {'+'}
            binding.buttonSubtraction.id -> {'-'}
            else ->{'0'}
        }

        firstValue = binding.editTextNumber.text.toString().toDouble()

        binding.editTextNumber.text.clear()
    }
}