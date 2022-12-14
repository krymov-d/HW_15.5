package kz.kd.hw_155

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener
import java.util.Currency

class CurrencyAdapter(
    private val clickListener: (name: String) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val data = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CurrencyViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CurrencyViewHolder).bind(data[position], clickListener)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(list: List<String>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    private class CurrencyViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.convertor_kz, parent, false)) {
        private val nameTextView = itemView.findViewById<TextView>(R.id.tv_sum)

        fun bind(item: String, clickListener: (name: String) -> Unit) {
            nameTextView.text = item
            nameTextView.setOnClickListener {
                clickListener(item)
            }
        }
    }
}