package logic

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CvObject(
    var fullName: String,
    var email: String,
    var age: Int,
    var gender: String,
    var skillsScore: HashMap<String,Int>? = null,
    var languages: List<CharSequence>? = null,
    var hobbies: List<CharSequence>? = null,
) : Parcelable