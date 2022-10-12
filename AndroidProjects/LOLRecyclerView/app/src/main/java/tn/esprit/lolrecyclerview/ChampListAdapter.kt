package tn.esprit.lolrecyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import tn.esprit.lolrecyclerview.utils.CHAMP_ITEM_KEY
import tn.esprit.lolrecyclerview.utils.ChampInfo

class ChampListAdapter(private val dataSet: List<ChampInfo>) :
    RecyclerView.Adapter<ChampViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampViewHolder =
        ChampViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.recycler_single_item, parent, false)
        )


    override fun onBindViewHolder(holder: ChampViewHolder, position: Int) {

        holder.apply {
            champItemName!!.text = dataSet[position].champName
            champItemRole!!.text = dataSet[position].champRole
            champItemIcon!!.setImageResource(dataSet[position].champImageId)
            itemView.setOnClickListener {

                Intent((it.context as MainActivity), ChampionDetailsActivity::class.java).let { i ->
                    i.putExtra(CHAMP_ITEM_KEY, dataSet[position])
                    startActivity((it.context as MainActivity), i, null)
                }
            }
        }
    }

    override fun getItemCount(): Int = dataSet.size
}