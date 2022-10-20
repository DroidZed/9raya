package tn.esprit.curriculumvitaev2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tn.esprit.curriculumvitaev2.R
import tn.esprit.curriculumvitaev2.utils.ListItemData
import tn.esprit.curriculumvitaev2.viewholders.EduViewHolder

class EduAdapter(private val dataSet: List<ListItemData>) : RecyclerView.Adapter<EduViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EduViewHolder =
        EduViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.layout_edu_card, parent, false)
        )

    override fun onBindViewHolder(holder: EduViewHolder, position: Int) {
        holder.apply {
            cName!!.text = dataSet[position].companyName
            cAddr!!.text = dataSet[position].companyAddress
            stDate!!.text = dataSet[position].startDate
            fDate!!.text = dataSet[position].endDate
            schoolImage!!.setImageResource(dataSet[position].imageUri)
        }
    }

    override fun getItemCount(): Int = dataSet.size
}