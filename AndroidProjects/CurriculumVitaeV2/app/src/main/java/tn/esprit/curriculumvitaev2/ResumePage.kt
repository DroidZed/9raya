package tn.esprit.curriculumvitaev2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentContainerView
import tn.esprit.curriculumvitaev2.fragments.BasicInfoFragment
import tn.esprit.curriculumvitaev2.fragments.HobbiesFragment
import tn.esprit.curriculumvitaev2.fragments.LanguageFragment
import tn.esprit.curriculumvitaev2.fragments.SkillsFragment
import tn.esprit.curriculumvitaev2.utils.*

class ResumePage : AppCompatActivity() {

    private lateinit var name: TextView
    private lateinit var email: TextView
    private lateinit var profileImage: ImageView

    private lateinit var skillsBtn: Button
    private lateinit var hobbiesBtn: Button
    private lateinit var langBtn: Button
    private lateinit var careerBtn: Button


    private lateinit var toolbar: Toolbar

    private lateinit var fragContainer: FragmentContainerView

    private lateinit var basicInfoFragment: BasicInfoFragment

    private lateinit var cv: CvObject

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        R.id.action_info -> {
            navigateToFragment(R.id.fragContainer, supportFragmentManager, basicInfoFragment, "nav")
            true
        }

        else -> super.onOptionsItemSelected(item)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_resume_page)

        toolbar = findViewById(R.id.toolBar)

        cv = intent.getParcelableExtra("cv")!!

        name = findViewById(R.id.nameText)
        email = findViewById(R.id.emailText)
        profileImage = findViewById(R.id.profilePic)
        fragContainer = findViewById(R.id.fragContainer)

        skillsBtn = findViewById(R.id.skillsBtn)
        hobbiesBtn = findViewById(R.id.hobbiesBtn)
        langBtn = findViewById(R.id.langBtn)
        careerBtn = findViewById(R.id.careerBtn)

        setSupportActionBar(toolbar)

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
            navigateToFragment(R.id.fragContainer, supportFragmentManager, skillsFragment, "nav")
        }

        hobbiesBtn.setOnClickListener {
            navigateToFragment(R.id.fragContainer, supportFragmentManager, hobbiesFragment, "nav")
        }

        langBtn.setOnClickListener {
            navigateToFragment(R.id.fragContainer, supportFragmentManager, languageFragment, "nav")
        }

        careerBtn.setOnClickListener {
            Intent(this, CareerActivity::class.java).apply {
                startActivity(this)
            }
        }


    }
}
