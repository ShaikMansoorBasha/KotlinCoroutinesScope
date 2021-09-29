package com.example.kotlincoroutinesscope

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class LifeCycleScopeActivity : AppCompatActivity() {
    val TAG = "==== "
    var goToThirdActivity: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle_scope)
        lifecycleScope.launch {
            Log.d(TAG, "LifecycleScope I'm alive on ${Thread.currentThread().name}!")
        }
        goToThirdActivity = findViewById(R.id.goToThirdActivity)
        goToThirdActivity?.setOnClickListener {
            val viewModelScopeIntent = Intent(this, ViewModelScopeActivity::class.java)
            startActivity(viewModelScopeIntent)

        }
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "LifecycleScope I'm exiting! ${Thread.currentThread().name}")
    }

}