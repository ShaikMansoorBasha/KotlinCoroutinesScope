package com.example.kotlincoroutinesscope

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kotlincoroutinesscope.viewModel.ViewModelScope

class ViewModelScopeActivity : AppCompatActivity() {
    val TAG = "==== "
    private lateinit var viewModelScope: ViewModelScope
    lateinit var txt_Name: TextView
    lateinit var btn_GotoNextActivity: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model_scope)
        viewModelScope = ViewModelProviders.of(this).get(ViewModelScope::class.java)
        viewModelScope.getUsersData()
        txt_Name = findViewById(R.id.txt_Name)
        btn_GotoNextActivity = findViewById(R.id.btn_GotoNextActivity)
        viewModelScope.users.observe(this, Observer { myUsers ->
            myUsers.forEach {
                Log.d(TAG, "onCreate: " + it + "==" + it.name)
                txt_Name.text = it.name
            }
        })
        btn_GotoNextActivity.setOnClickListener {
            val goToNextActivity = Intent(this, NextActivity::class.java)
            startActivity(goToNextActivity)

        }
        Log.d(TAG, "ViewModelScope I'm alive on ${Thread.currentThread().name}!")
        /*  lifecycleScope.launch() {
              Log.d(TAG, "ViewModelScope I'm alive on ${Thread.currentThread().name}!")
          }
          Log.d(TAG, "ViewModelScope I'm exiting! ${Thread.currentThread().name}")*/
    }

}