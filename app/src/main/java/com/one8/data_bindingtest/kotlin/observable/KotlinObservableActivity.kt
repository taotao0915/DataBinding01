package com.one8.data_bindingtest.kotlin.observable

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableInt
import com.one8.data_bindingtest.R
import com.one8.data_bindingtest.databinding.KotlinObservableProfileBinding

class KotlinObservableActivity : AppCompatActivity() {
    private val entity: KotlinObservableFieldProfile = KotlinObservableFieldProfile("Ada", "Lovelace", ObservableInt(0));

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:KotlinObservableProfileBinding = DataBindingUtil.setContentView(this, R.layout.kotlin_observable_profile);
        binding.user = entity;
    }


    fun onLike(view: View){
        entity.like.set(entity.like.get()+1)
    }

}