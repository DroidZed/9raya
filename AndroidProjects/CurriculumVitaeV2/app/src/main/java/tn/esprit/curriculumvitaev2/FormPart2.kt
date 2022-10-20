package tn.esprit.curriculumvitaev2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import tn.esprit.curriculumvitaev2.utils.*

class FormPart2 : AppCompatActivity() {

    private lateinit var androidSk: SeekBar
    private lateinit var iosSk: SeekBar
    private lateinit var flutterSk: SeekBar

    private lateinit var arabicChbx: CheckBox
    private lateinit var frenchChbx: CheckBox
    private lateinit var englishChbx: CheckBox

    private lateinit var musicChbx: CheckBox
    private lateinit var sportChbx: CheckBox
    private lateinit var gamesChbx: CheckBox

    private lateinit var submitBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_part2)

        supportActionBar?.title = resources.getString(R.string.title1)

        androidSk = findViewById(R.id.andrSkBar)
        iosSk = findViewById(R.id.iosSkBar)
        flutterSk = findViewById(R.id.fltrSkBar)

        arabicChbx = findViewById(R.id.ar)
        frenchChbx = findViewById(R.id.fr)
        englishChbx = findViewById(R.id.en)

        musicChbx = findViewById(R.id.music)
        sportChbx = findViewById(R.id.sport)
        gamesChbx = findViewById(R.id.games)

        submitBtn = findViewById(R.id.submitBtn)

        submitBtn.setOnClickListener {

            val scores = hashMapOf(
                Pair(ANDROID_KEY, androidSk.progress),
                Pair(iOS_KEY, iosSk.progress),
                Pair(FLUTTER_KEY, flutterSk.progress)
            )

            val checkedLanguages =
                hashMapOf(
                    Pair(EN, englishChbx.isChecked),
                    Pair(AR, arabicChbx.isChecked),
                    Pair(FR, frenchChbx.isChecked)
                )

            val checkedHobbies =
                hashMapOf(
                    Pair(GAMES, gamesChbx.isChecked),
                    Pair(SPORT, sportChbx.isChecked),
                    Pair(MUSIC, musicChbx.isChecked)
                )

            val cv = intent.getParcelableExtra<CvObject>("cv")

            cv?.apply {
                skillsScore = scores
                languages = checkedLanguages
                hobbies = checkedHobbies
            }

            Intent(this, ResumePage::class.java).let { i ->
                i.putExtra("cv", cv)
                startActivity(i)
            }

        }

    }
}