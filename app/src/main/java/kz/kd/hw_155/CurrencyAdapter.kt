package kz.kd.hw_155

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class CurrencyAdapter(private val layoutInflater: LayoutInflater):RecyclerView.Adapter<ViewHolder>() {
    private val currencyList: MutableList<Currency> = mutableListOf()

    override fun getItemViewType(position: Int): Int {
        return if (position + 1 == currencyList.size) {
            1
        } else {
            0
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutId = if (viewType == 1) {
            R.layout.btn_add
        } else {
            R.layout.card_currency
        }
        val view = layoutInflater.inflate(layoutId, parent, false)
        val viewHolder = if (viewType == 1) {
            ButtonViewHolder(view)
        } else {
            CurrencyViewHolder(view)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currency = currencyList[position]
        if (holder is CurrencyViewHolder) {
            holder.bind(currency)
        }
    }

    override fun getItemCount(): Int {
        return currencyList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateDataSet(newDataSet: List<Currency>) {
        currencyList.clear()
        currencyList.addAll(newDataSet)
        notifyDataSetChanged()
    }

}