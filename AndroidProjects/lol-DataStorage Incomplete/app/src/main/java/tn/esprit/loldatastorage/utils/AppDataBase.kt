package tn.esprit.loldatastorage.utils

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import tn.esprit.loldatastorage.dao.ChampionDao
import tn.esprit.loldatastorage.data.Champion

@Database(entities = [Champion::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun champDao(): ChampionDao

    companion object {
        @Volatile
        private var instance: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            if (instance == null) {
                synchronized(this) {
                   instance = Room.databaseBuilder(
                        context,
                        AppDataBase::class.java,
                        "champions-db"
                    )
                       .allowMainThreadQueries()
                       .build()
                }
            }
            return instance!!
        }
    }
}


