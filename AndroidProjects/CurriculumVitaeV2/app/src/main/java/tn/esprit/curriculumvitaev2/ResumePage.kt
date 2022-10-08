package tn.esprit.curriculumvitaev2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import logic.*
import tn.esprit.curriculumvitaev2.fragments.BasicInfoFragment
import tn.esprit.curriculumvitaev2.fragments.HobbiesFragment
import tn.esprit.curriculumvitaev2.fragments.LanguageFragment
import tn.esprit.curriculumvitaev2.fragments.SkillsFragment

class ResumePage : AppCompatActivity() {

    private lateinit var name: TextView
    private lateinit var email: TextView
    private lateinit var profileImage: ImageView

    private lateinit var skillsBtn: Button
    private lateinit var hobbiesBtn: Button
    private lateinit var langBtn: Button

    private lateinit var fragContainer: FragmentContainerView

    private lateinit var basicInfoFragment: BasicInfoFragment

    private lateinit var cv: CvObject

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        R.id.action_info -> {
            navigateToFragment(basicInfoFragment)
            true
        }

        else -> super.onOptionsItemSelected(item)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resume_page)

        cv = intent.getParcelableExtra("cv")!!

        name = findViewById(R.id.nameText)
        email = findViewById(R.id.emailText)
        profileImage = findViewById(R.id.profilePic)
        fragContainer = findViewById(R.id.fragContainer)

        skillsBtn = findViewById(R.id.skillsBtn)
        hobbiesBtn = findViewById(R.id.hobbiesBtn)
        langBtn = findViewById(R.id.langBtn)

        name.text = cv.fullName
        email.text = cv.email
        profileImage.setImageURI(cv.imgURI)

        basicInfoFragment = BasicInfoFragment.new(
            cv.fullName!!, cv.gender!!, cv.age!!, cv.email!!
        )

        val skillsFragment = SkillsFragment.new(
            androidP = cv.skillsScore!![ANDROID_KEY]!!,
            flutterP = cv.skillsScore!![FLUTTER_KEY]!!,
            iosP = cv.skillsScore!![iOS_KEY]!!,
        )

        val hobbiesFragment = HobbiesFragment.new(
            isMusic = cv.hobbies!![MUSIC]!!,
            isGames = cv.hobbies!![GAMES]!!,
            isSport = cv.hobbies!![SPORT]!!
        )

        val languageFragment = LanguageFragment.new(
            isArabic = cv.languages!![AR]!!,
            isEnglish = cv.languages!![EN]!!,
            isFrench = cv.languages!![FR]!!
        )

        supportFragmentManager.beginTransaction().add(
            R.id.fragContainer, skillsFragment
        ).commit()

        skillsBtn.setOnClickListener {
            navigateToFragment(skillsFragment)
        }

        hobbiesBtn.setOnClickListener {
            navigateToFragment(hobbiesFragment)
        }

        langBtn.setOnClickListener {
            navigateToFragment(languageFragment)
        }
    }

    private fun navigateToFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(
            R.id.fragContainer, fragment
        ).commit()
    }
}
