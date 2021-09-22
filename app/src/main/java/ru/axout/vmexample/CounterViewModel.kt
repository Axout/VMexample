package ru.axout.vmexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {

    private val mutableState = MutableLiveData(CounterState(counter = 0))

    val state: LiveData<CounterState>
        get() = mutableState

    fun incrementCounter() {
        mutableState.value = CounterState(mutableState.value!!.counter + 1)
    }

    fun decrementCounter() {
        mutableState.value = CounterState(mutableState.value!!.counter - 1)
    }
}