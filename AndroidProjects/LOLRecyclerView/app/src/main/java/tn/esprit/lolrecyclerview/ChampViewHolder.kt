package tn.esprit.lolrecyclerview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChampViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

      var  champItemIcon: ImageView? = null
      var  champItemName: TextView? = null
      var  champItemRole: TextView? = null

    init {
        champItemIcon = itemView.findViewById(R.id.champItemIcon)
        champItemName = itemView.findViewById(R.id.champItemName)
        champItemRole = itemView.findViewById(R.id.champItemRole)
    }
}