package ru.axout.vmexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private var data = 0
    private lateinit var counterTVwithVM: TextView
    private lateinit var counterTVwithoutVM: TextView
    private val viewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        counterTVwithVM = findViewById(R.id.tv_counter)
        counterTVwithoutVM = findViewById(R.id.tv_counterWithoutVM)

        findViewById<Button>(R.id.bt_increase).setOnClickListener {
            viewModel.incrementCounter()

            data++
            counterTVwithoutVM.text = data.toString()
        }

        findViewById<Button>(R.id.bt_decrease).setOnClickListener {
            viewModel.decrementCounter()

            data--
            counterTVwithoutVM.text = data.toString()
        }

        viewModel.state.observe(this) { state ->
            counterTVwithVM.text = state.counter.toString()
        }
    }
}