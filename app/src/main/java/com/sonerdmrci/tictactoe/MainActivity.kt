package com.sonerdmrci.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.sonerdmrci.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var player = "P1"
    var pointX = 0
    var pointY = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewScore.setText("Score: X: $pointX      O: $pointY")
        binding.b1.setOnClickListener {
            buttonClick(binding.b1)
        }

        binding.b2.setOnClickListener {
            buttonClick(binding.b2)
        }

        binding.b3.setOnClickListener {
            buttonClick(binding.b3)
        }

        binding.b4.setOnClickListener {
            buttonClick(binding.b4)
        }

        binding.b5.setOnClickListener {
            buttonClick(binding.b5)
        }

        binding.b6.setOnClickListener {
            buttonClick(binding.b6)
        }

        binding.b7.setOnClickListener {
            buttonClick(binding.b7)
        }

        binding.b8.setOnClickListener {
            buttonClick(binding.b8)
        }

        binding.b9.setOnClickListener {
            buttonClick(binding.b9)
        }

    }

    fun buttonClick(button: Button){
        if (button.text == "") {
            if (player == "P1"){
                button.text ="X"
                player = "P2"
            } else {
                button.text = "O"
                player = "P1"
            }
        }
        win()
    }

    fun win() {
        if ((binding.b1.text == "X" && binding.b2.text == "X" && binding.b3.text == "X")
                || (binding.b4.text == "X" && binding.b5.text == "X" && binding.b6.text == "X")
                || (binding.b7.text == "X" && binding.b8.text == "X" && binding.b9.text == "X")
                || (binding.b1.text == "X" && binding.b5.text == "X" && binding.b9.text == "X")
                || (binding.b3.text == "X" && binding.b5.text == "X" && binding.b7.text == "X")
                || (binding.b1.text == "X" && binding.b4.text == "X" && binding.b7.text == "X")
                || (binding.b2.text == "X" && binding.b5.text == "X" && binding.b8.text == "X")
                || (binding.b3.text == "X" && binding.b6.text == "X" && binding.b9.text == "X"))
        {
            alert("X")
        } else if ((binding.b1.text == "O" && binding.b2.text == "O" && binding.b3.text == "O")
                || (binding.b4.text == "O" && binding.b5.text == "O" && binding.b6.text == "O")
                || (binding.b4.text == "O" && binding.b5.text == "O" && binding.b6.text == "O")
                || (binding.b7.text == "O" && binding.b8.text == "O" && binding.b9.text == "O")
                || (binding.b1.text == "O" && binding.b5.text == "O" && binding.b9.text == "O")
                || (binding.b3.text == "O" && binding.b5.text == "O" && binding.b7.text == "O")
                || (binding.b1.text == "O" && binding.b4.text == "O" && binding.b7.text == "O")
                || (binding.b2.text == "O" && binding.b5.text == "O" && binding.b8.text == "O")
                || (binding.b3.text == "O" && binding.b6.text == "O" && binding.b9.text == "O"))
        {
            alert("O")
        } else if ((binding.b1.text != "") && (binding.b2.text != "") && (binding.b3.text != "")
                && (binding.b4.text != "") && (binding.b5.text != "") && (binding.b6.text != "")
                && (binding.b7.text != "") && (binding.b8.text != "") && (binding.b9.text != ""))
        {
            alert("Tie")
        }

    }

    fun alert(wins: String){
        var alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle(wins)
        alertDialog.setMessage("$wins !!! Play Again?")
        alertDialog.setPositiveButton("Yes") { dialog, which ->
            clear()
            if (wins == "X") {
                pointX++
            } else {
                pointY++
            }
            binding.textViewScore.setText("Score: X: $pointX      O: $pointY")
            Toast.makeText(applicationContext,"Reset", Toast.LENGTH_SHORT).show()

        }.setNegativeButton("No") { dialog, which ->

        }
        alertDialog.show()
    }

    fun clear(){
        binding.b1.text= ""
        binding.b2.text= ""
        binding.b3.text= ""
        binding.b4.text= ""
        binding.b5.text= ""
        binding.b6.text= ""
        binding.b7.text= ""
        binding.b8.text= ""
        binding.b9.text= ""
    }
}







