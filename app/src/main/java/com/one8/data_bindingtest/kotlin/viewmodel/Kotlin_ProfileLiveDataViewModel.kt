package com.one8.data_bindingtest.kotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class Kotlin_ProfileLiveDataViewModel: ViewModel() {
    val name:LiveData<String> = MutableLiveData("Ada");
    val lastName:LiveData<String> = MutableLiveData("Ada");
    val likes = MutableLiveData(0);

    // popularity is exposed as LiveData using a Transformation instead of a @Bindable property.
    val popularity:LiveData<Popularity> = Transformations.map(likes){
        when{
            it>9 -> Popularity.STAR
            it>4 -> Popularity.POPULAR
            else -> Popularity.NORMAL
        }
    }

    fun onLike(){
        likes.value = (likes.value?:0)+1
    }
}

enum class Popularity {
    NORMAL,
    POPULAR,
    STAR
}