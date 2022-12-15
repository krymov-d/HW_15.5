package kz.kd.hw_155

import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CurrencyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val etSum: EditText = itemView.findViewById(R.id.et_it_sum)
    private val ivFlag: ImageView = itemView.findViewById(R.id.iv_flag)
    private val tvDescription: TextView = itemView.findViewById(R.id.tv_description)

    fun bind(currency: Currency){
        etSum.setText(currency.sum)
        ivFlag.setImageResource(currency.image)
        tvDescription.text = currency.description
    }
}