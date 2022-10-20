package tn.esprit.loldatastorage.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import tn.esprit.loldatastorage.data.Champion

@Dao
interface ChampionDao {

    @Query("SELECT * FROM Champion")
    fun getAllChampions(): List<Champion>

    @Query("SELECT * FROM Champion where id = :id")
    fun getChampById(id: Int): Champion

    @Insert
    fun addChamp(champ: Champion)

    @Delete
    fun deleteChamp(champ: Champion)
}