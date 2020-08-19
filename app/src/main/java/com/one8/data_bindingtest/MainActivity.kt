package com.one8.data_bindingtest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.one8.data_bindingtest.databinding.ActivityMainBinding
import com.one8.data_bindingtest.java.observable.ObservableActivity
import com.one8.data_bindingtest.java.viewmodel.ViewModelActivity
import com.one8.data_bindingtest.kotlin.observable.KotlinObservableActivity
import com.one8.data_bindingtest.kotlin.viewmodel.Kotlin_ViewModelActivity

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.button1.setOnClickListener {
            startActivity(Intent(this,ObservableActivity::class.java))
        }
        binding.button2.setOnClickListener {
            startActivity(Intent(this,KotlinObservableActivity::class.java))
        }
        binding.button3.setOnClickListener {
            startActivity(Intent(this,ViewModelActivity::class.java))
        }
        binding.button4.setOnClickListener {
            startActivity(Intent(this,Kotlin_ViewModelActivity::class.java))
        }

    }


}