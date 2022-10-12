package tn.esprit.leagueoflegends

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import tn.esprit.leagueoflegends.fragments.ChampsFragment
import tn.esprit.leagueoflegends.fragments.LolInfoFragment
import tn.esprit.leagueoflegends.fragments.SpellsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var fragContainer: FragmentContainerView
    private lateinit var btnChamps: Button
    private lateinit var btnSpells: Button
    private lateinit var toolbar: Toolbar

    private lateinit var champsFragment: ChampsFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolBar)

        champsFragment = ChampsFragment()

        // enabling the action bar on this activity:
        setSupportActionBar(toolbar)

        fragContainer = findViewById(R.id.fragContainer)

        supportFragmentManager.beginTransaction().add(
            R.id.fragContainer, champsFragment
        ).commit()

        btnChamps = findViewById(R.id.btnChamps)
        btnSpells = findViewById(R.id.btnSpells)


        btnSpells.setOnClickListener {
            navigateToFragment(SpellsFragment())
        }

        btnChamps.setOnClickListener {
            navigateToFragment(ChampsFragment())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        R.id.info -> {
            navigateToFragment(LolInfoFragment())
            true
        }

        else -> super.onOptionsItemSelected(item)
    }

    private fun navigateToFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(
            R.id.fragContainer, fragment
        ).addToBackStack("nav").commit()
    }

}