package tn.esprit.curriculumvitaev2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tn.esprit.curriculumvitaev2.R
import tn.esprit.curriculumvitaev2.adapters.EduAdapter
import tn.esprit.curriculumvitaev2.utils.ListItemData


class EduFragment : Fragment() {

    private lateinit var schoolsRV: RecyclerView
    private lateinit var eduAdapter: EduAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_edu, container, false)

        schoolsRV = v.findViewById(R.id.schoolsRV)

        val schoolsList = listOf(
            ListItemData(
                companyName = "Massachusetts",
                companyAddress = "United States",
                startDate = "01/09/2020",
                endDate = "TODAY",
                imageUri = R.drawable.ic_logo_massachusetts
            ),
            ListItemData(
                companyName = "Oxford",
                companyAddress = "United Kingdom",
                startDate = "01/09/2018",
                endDate = "31/08/2020",
                imageUri = R.drawable.ic_logo_oxford
            ),
            ListItemData(
                companyName = "Stanford",
                companyAddress = "United States",
                startDate = "01/09/2016",
                endDate = "31/08/2018",
                imageUri = R.drawable.ic_logo_stanford
            ),
            ListItemData(
                companyName = "Cambridge",
                companyAddress = "United States",
                startDate = "01/09/2014",
                endDate = "31/08/2016",
                imageUri = R.drawable.ic_logo_cambridge
            ),
            ListItemData(
                companyName = "Harvard",
                companyAddress = "United States",
                startDate = "01/09/2012",
                endDate = "31/08/2014",
                imageUri = R.drawable.ic_logo_harvard
            ),
            ListItemData(
                companyName = "Esprit",
                companyAddress = "Tunisia",
                startDate = "01/09/2009",
                endDate = "01/08/2012",
                imageUri = R.drawable.ic_logo_esprit
            ),
        )

        eduAdapter = EduAdapter(schoolsList)

        schoolsRV.adapter = eduAdapter

        schoolsRV.layoutManager = LinearLayoutManager(v.context)

        return v
    }
}