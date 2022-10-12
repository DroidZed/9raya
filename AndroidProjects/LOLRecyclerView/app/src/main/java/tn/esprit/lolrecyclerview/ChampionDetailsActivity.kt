package tn.esprit.lolrecyclerview

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import tn.esprit.lolrecyclerview.utils.CHAMP_ITEM_KEY
import tn.esprit.lolrecyclerview.utils.ChampInfo

class ChampionDetailsActivity : AppCompatActivity() {

    private lateinit var champImage: ImageView
    private lateinit var champName: TextView
    private lateinit var champRole: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_champion_details)

        champImage = findViewById(R.id.champImage)
        champName = findViewById(R.id.champName)
        champRole = findViewById(R.id.champRole)

        val champData = intent.getParcelableExtra<ChampInfo>(CHAMP_ITEM_KEY)!!

        supportActionBar?.title = "${champData.champName} Detail"

        champImage.setImageResource(champData.champImageId)
        champName.text = champData.champName
        champRole.text = champData.champRole
    }
}