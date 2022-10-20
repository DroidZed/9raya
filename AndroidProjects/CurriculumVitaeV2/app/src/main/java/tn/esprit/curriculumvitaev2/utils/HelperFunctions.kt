package tn.esprit.curriculumvitaev2.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

fun navigateToFragment(
    fragContainer: Int,
    fragManager: FragmentManager,
    fragment: Fragment,
    navStack: String
) {
    fragManager.beginTransaction().replace(
        fragContainer, fragment
    ).addToBackStack(navStack).commit()
}