package android.alquran.radityalabs.net.alquran.presentation.adapter.viewholder

import android.alquran.radityalabs.net.alquran.R
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

/**
 * Created by radityagumay on 8/13/17.
 */
class SurahViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var number: TextView = itemView.findViewById(R.id.number)
    var arabicName: TextView = itemView.findViewById(R.id.arabicName)
    var englishName: TextView = itemView.findViewById(R.id.englishName)
}