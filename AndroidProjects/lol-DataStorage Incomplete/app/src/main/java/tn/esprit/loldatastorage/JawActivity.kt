package tn.esprit.loldatastorage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tn.esprit.loldatastorage.dao.ChampionDao
import tn.esprit.loldatastorage.data.Champion
import tn.esprit.loldatastorage.utils.AppDataBase

class JawActivity : AppCompatActivity() {

    private lateinit var dataBase: AppDataBase

    private lateinit var championDao: ChampionDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jaw)

        dataBase = AppDataBase.getDatabase(this)

        championDao = dataBase.champDao()

        val champList: MutableList<Champion> = championDao.getAllChampions().toMutableList()

        val champ = Champion(
            1,
            R.drawable.ic_blitzcrank,
            "Blitz",
            "Support"
        )

        championDao.addChamp(champ)

        champList.add(champ)

        championDao.deleteChamp(champ)

        champList.remove(champ)
    }
}