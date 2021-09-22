package ru.axout.vmexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewModel: CounterViewModel by viewModels()

    private lateinit var editText: EditText
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        editText = findViewById(R.id.edit_text)
        textView = findViewById(R.id.textView)

        editText.addTextChangedListener {
            viewModel.setData(editText.text.length)
        }

        viewModel.state.observe(this) { state ->
            textView.text = state.counter.toString()
        }
    }
}