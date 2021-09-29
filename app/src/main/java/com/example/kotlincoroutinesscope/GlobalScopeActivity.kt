package com.example.kotlincoroutinesscope

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.ViewModelProviders
import com.example.kotlincoroutinesscope.viewModel.UsersViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GlobalScopeActivity : AppCompatActivity() {
    val TAG = "==== "
    var btnStartActivity: Button? = null
    lateinit var viewModel: UsersViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_global_scope)
        btnStartActivity = findViewById(R.id.btnStartActivity)
        viewModel = ViewModelProviders.of(this).get(UsersViewModel::class.java)
        viewModel.refresh()
        GlobalScope.launch {
            Dispatchers.Main
            Log.d(TAG, "Global Scope I'm alive on${Thread.currentThread().name.toString()}")
//            val users=fetchUser()
//            showUsersList(users)

        }
        Log.d(TAG, "Global Scope I'm exiting! ${Thread.currentThread().name.toString()}")
        btnStartActivity?.setOnClickListener {
            // new activity will get intended on click of Second Activity
            val intent = Intent(this@GlobalScopeActivity, LifeCycleScopeActivity::class.java)
            startActivity(intent)

        }
    }

}