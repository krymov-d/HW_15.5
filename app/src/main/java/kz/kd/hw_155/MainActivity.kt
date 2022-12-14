package kz.kd.hw_155

import android.icu.util.Currency
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupCurrency()
    }

    private fun setupCurrency() {
        val currencyAdapter = CurrencyAdapter(
            clickListener = {
                Log.d("currency", "1")
            }
        )

        val currencyManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val rvConverter: RecyclerView = findViewById(R.id.rv_convertor)
        rvConverter.apply {
            adapter = currencyAdapter
            layoutManager = currencyManager
        }

        val currencyList = listOf("1 500 000","1 000 000","2 000 000",
            "1500", "8000", "90 000", "75 000", "500", "450", "351684",
        "546464", "78900000", "852698741", "4545454545454",
        "884884884")

        currencyAdapter.setItems(currencyList)
    }
}