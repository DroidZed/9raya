package tn.esprit.loldatastorage.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import tn.esprit.loldatastorage.utils.NAME
import tn.esprit.loldatastorage.utils.PICTURE
import tn.esprit.loldatastorage.utils.ROLE


@Entity
data class Champion(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val champPic: Int,

    val champName: String,

    val champRole: String
)