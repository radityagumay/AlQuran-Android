package android.alquran.radityalabs.net.alquran.presentation.adapter

import android.alquran.radityalabs.net.alquran.R
import android.alquran.radityalabs.net.alquran.data.network.response.SurahData
import android.alquran.radityalabs.net.alquran.presentation.adapter.viewholder.SurahViewHolder
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by radityagumay on 8/13/17.
 */
class SurahAdapter(val listOfSurah: List<SurahData>?) : RecyclerView.Adapter<SurahViewHolder>() {

    private val list: List<SurahData>? = listOfSurah

    fun setNotifyDataChanges(newList: List<SurahData>) {
        list?.let {
            it.plus(newList)
            notifyDataSetChanged()
        }
    }

    fun setNotifyItemChanges(item: SurahData, position: Int) {
        list?.let {
            it.plus(item)
            notifyItemChanged(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SurahViewHolder {
        return SurahViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.list_item_surah, parent, false))
    }

    override fun getItemCount() = list?.size ?: 0

    override fun onBindViewHolder(holder: SurahViewHolder?, position: Int) {
    }
}