package com.example.kotlincoroutinesscope.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlincoroutinesscope.model.UserList
import com.example.kotlincoroutinesscope.repositories.ViewModelScopeUserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewModelScope : ViewModel() {
    private var viewModelScopeUserRepository = ViewModelScopeUserRepository()
    var users: MutableLiveData<List<UserList>> = MutableLiveData()
    fun getUsersData() {
        /**We can Launch the coroutine by this way and if the view model is cancel automatically coroutine will also
        clear**/
        viewModelScope.launch {
            var result: List<UserList>? = null
            //Write the code hear
            withContext(Dispatchers.IO) {
                result = viewModelScopeUserRepository.fetchUsers()

            }
            users.value = result

        }
    }
}