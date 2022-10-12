package tn.esprit.lolrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import tn.esprit.lolrecyclerview.utils.ChampInfo

class MainActivity : AppCompatActivity() {

    private lateinit var champList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        champList = findViewById(R.id.champList)

        val champs = listOf(
            ChampInfo(R.drawable.ic_leesin, "Lee Sin", "COMBATTANT: Jungler"),
            ChampInfo(R.drawable.ic_missfortune, "Miss Fortune", "TIREUR: ADC"),
            ChampInfo(R.drawable.ic_thresh, "Thresh", "SUPPORT"),
            ChampInfo(R.drawable.ic_nasus, "Nasus", "COMBATTANT: Top"),
            ChampInfo(R.drawable.ic_ahri, "Ahri", "MAGE: MID"),
            ChampInfo(R.drawable.ic_annie, "Annie", "MAGE: MID"),
            ChampInfo(R.drawable.ic_ashe, "Ashe", "TIREUR: ADC"),
            ChampInfo(R.drawable.ic_blitzcrank, "Blitzcrank", "TANK: Support"),
            ChampInfo(R.drawable.ic_ekko, "Ekko", "ASSASSIN: MID/Jungler"),
        )

        val champsAdapter = ChampListAdapter(champs)

        champList.adapter = champsAdapter

    }
}