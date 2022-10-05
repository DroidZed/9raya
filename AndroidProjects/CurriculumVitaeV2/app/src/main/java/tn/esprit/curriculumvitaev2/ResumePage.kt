package tn.esprit.curriculumvitaev2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import logic.CvObject

class ResumePage : AppCompatActivity() {

    private lateinit var name: TextView
    private lateinit var email: TextView
    private lateinit var age: TextView
    private lateinit var gender: TextView
    private lateinit var androidSkill: TextView
    private lateinit var iosSkill: TextView
    private lateinit var flutterSkill: TextView
    private lateinit var lang: TextView
    private lateinit var hobbies: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resume_page)

        supportActionBar?.title = resources.getString(R.string.title2)

        val cv = intent.getParcelableExtra<CvObject>("cv")

        name = findViewById(R.id.name)
        email = findViewById(R.id.email)
        age = findViewById(R.id.age)
        gender = findViewById(R.id.gender)
        androidSkill = findViewById(R.id.andrSkill)
        iosSkill = findViewById(R.id.iosSkill)
        flutterSkill = findViewById(R.id.fltrSkill)
        lang = findViewById(R.id.lang)
        hobbies = findViewById(R.id.hobbies)

        name.text = "Name: ${cv?.fullName}"
        email.text = "Email: ${cv?.email}"
        age.text = "Age: ${cv?.age}"
        gender.text = "Gender: ${cv?.gender}"
        androidSkill.text = "Android skill: ${cv?.skillsScore?.get("Android")}"
        iosSkill.text = "iOS skill: ${cv?.skillsScore?.get("iOS")}"
        flutterSkill.text = "Flutter skill: ${cv?.skillsScore?.get("Flutter")}"
        lang.text = "languages: ${cv?.languages?.joinToString(separator = ", ")}"
        hobbies.text = "Hobbies: ${cv?.hobbies?.joinToString(separator = ", ")}"

    }
}
