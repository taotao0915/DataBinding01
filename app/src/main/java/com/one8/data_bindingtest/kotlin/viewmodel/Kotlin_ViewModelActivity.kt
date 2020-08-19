package com.one8.data_bindingtest.kotlin.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.one8.data_bindingtest.R
import com.one8.data_bindingtest.databinding.KotlinViewModelProfileBinding

class Kotlin_ViewModelActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Obtain ViewModel from ViewModelProviders
        val viewModel = ViewModelProviders.of(this).get(Kotlin_ProfileLiveDataViewModel::class.java)
        // An alternative ViewModel using Observable fields and @Bindable properties can be used:
        // val viewModel = ViewModelProviders.of(this).get(Kotlin_ProfileObservableViewModel::class.java)
        val binding:KotlinViewModelProfileBinding = DataBindingUtil.setContentView(this, R.layout.kotlin_view_model_profile);
        // Bind layout with ViewModel
        binding.viewmodel = viewModel
        // LiveData needs the lifecycle owner
        binding.lifecycleOwner = this
    }
}