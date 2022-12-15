package kz.kd.hw_155

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var currencyAdapter: CurrencyAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupCurrency()
        fillCurrency()
    }

    private fun setupCurrency() {
        currencyAdapter = CurrencyAdapter(layoutInflater)
        val currencyManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val rvConverter: RecyclerView = findViewById(R.id.rv_convertor)
        rvConverter.layoutManager = currencyManager
        rvConverter.adapter = currencyAdapter
    }

    private fun fillCurrency() {
        val currencies = mutableListOf<Currency>()
        currencies.add(Currency("1 500 000", R.drawable.ic_kz, "Тенге, Казахстан"))
        currencies.add(Currency("23 450", R.drawable.ic_usa, "Доллары, США"))
        currencies.add(Currency("23 450", R.drawable.ic_usa, "Доллары, США"))
        currencies.add(Currency("23 450", R.drawable.ic_usa, "Доллары, США"))
        currencies.add(Currency("23 450", R.drawable.ic_usa, "Доллары, США"))
        currencies.add(Currency("", 0, ""))
        currencyAdapter.updateDataSet(currencies)
    }
}