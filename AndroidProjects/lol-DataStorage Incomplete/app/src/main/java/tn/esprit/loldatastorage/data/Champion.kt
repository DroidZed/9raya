package tn.esprit.loldatastorage.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Champion(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val champPic: Int,

    val champName: String,

    val champRole: String
)