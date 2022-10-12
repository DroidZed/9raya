package tn.esprit.lolrecyclerview.utils

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ChampInfo(
    val champImageId: Int,
    val champName: String,
    val champRole: String
) : Parcelable
