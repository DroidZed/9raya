package tn.esprit.curriculumvitaev2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tn.esprit.curriculumvitaev2.R
import tn.esprit.curriculumvitaev2.utils.ListItemData
import tn.esprit.curriculumvitaev2.viewholders.ExpViewHolder

class ExpAdapter(private val dataSet: List<ListItemData>) : RecyclerView.Adapter<ExpViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpViewHolder =
        ExpViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.layout_exp_card, parent, false)
        )

    override fun onBindViewHolder(holder: ExpViewHolder, position: Int) {

        holder.apply {
            companyName!!.text = dataSet[position].companyName
            companyAddress!!.text = dataSet[position].companyAddress
            startDate!!.text = dataSet[position].startDate
            endDate!!.text = dataSet[position].endDate
            companyImage!!.setImageResource(dataSet[position].imageUri)
        }
    }

    override fun getItemCount(): Int = dataSet.size
}