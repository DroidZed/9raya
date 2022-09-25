package tn.esprit.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import tn.esprit.diceroll.data.Dice

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton = findViewById<Button>(R.id.rollBtn)

        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val d = Dice(6)
        val diceRoll = d.roll()
        val diceImageView = findViewById<ImageView>(R.id.dice)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_1
        }

        diceImageView.setImageResource(drawableResource)
    }
}