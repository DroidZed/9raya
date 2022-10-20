package tn.esprit.curriculumvitaev2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tn.esprit.curriculumvitaev2.R
import tn.esprit.curriculumvitaev2.adapters.ExpAdapter
import tn.esprit.curriculumvitaev2.utils.ListItemData


class ExpFragment : Fragment() {

    private lateinit var companiesRV: RecyclerView
    private lateinit var expAdapter: ExpAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_exp, container, false)

        companiesRV = v.findViewById(R.id.companiesRV)

        val companiesList = listOf(
            ListItemData(
                companyName = "Amazon",
                companyAddress = "United States",
                startDate = "01/09/2019",
                endDate = "TODAY",
                imageUri = R.drawable.ic_logo_amazon
            ),
            ListItemData(
                companyName = "Facebook",
                companyAddress = "France",
                startDate = "01/09/2018",
                endDate = "31/08/2019",
                imageUri = R.drawable.ic_logo_facebook
            ),
            ListItemData(
                companyName = "Google",
                companyAddress = "United States",
                startDate = "01/09/2017",
                endDate = "31/08/2018",
                imageUri = R.drawable.ic_logo_google
            ),
            ListItemData(
                companyName = "Linkedin",
                companyAddress = "United States",
                startDate = "01/09/2016",
                endDate = "31/08/2017",
                imageUri = R.drawable.ic_logo_linkedin
            ),
            ListItemData(
                companyName = "Microsoft",
                companyAddress = "United States",
                startDate = "01/09/2015",
                endDate = "31/08/2016",
                imageUri = R.drawable.ic_logo_microsoft
            ),
            ListItemData(
                companyName = "Esprit",
                companyAddress = "Tunisia",
                startDate = "01/09/2013",
                endDate = "31/08/2015",
                imageUri = R.drawable.ic_logo_esprit
            ),

            )

        expAdapter = ExpAdapter(companiesList)

        companiesRV.adapter = expAdapter

        companiesRV.layoutManager = LinearLayoutManager(v.context)

        return v
    }
}