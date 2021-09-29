package com.example.kotlincoroutinesscope.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlincoroutinesscope.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UsersViewModel : ViewModel() {
    private val TAG = "QuoteViewModel"
    val users = MutableLiveData<List<User>>()


    fun refresh() {
        viewModelScope.launch {
            users as MutableLiveData
            val quotes1 = async { getUsers() }
        }
    }

    private suspend fun getUsers() {
        return withContext(Dispatchers.IO) {
            Log.i(TAG, "Getting Quotes")
            //  MyApi().getUsersList().body()?.data

        }
    }

}