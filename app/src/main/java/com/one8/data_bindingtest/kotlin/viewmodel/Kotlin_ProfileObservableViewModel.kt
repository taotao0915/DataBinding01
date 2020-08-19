package com.one8.data_bindingtest.kotlin.viewmodel

import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.one8.data_bindingtest.BR

/**
 * As an alternative to LiveData, you can use Observable Fields and binding properties.
 *
 * `Popularity` is exposed here as a `@Bindable` property so it's necessary to call
 * `notifyPropertyChanged` when any of the dependent properties change (`likes` in this case).
 */
class Kotlin_ProfileObservableViewModel : Kotlin_ObservableViewModel(){
    val name = ObservableField("Ada")
    val lastName = ObservableField("Lovelace")
    val likes = ObservableInt(0)

    fun onLike(){
        likes.increment()
        // You control when the @Bindable properties are updated using `notifyPropertyChanged()`.
        notifyPropertyChanged(BR.popularity)
    }

    @Bindable
    fun getPopularity(): Popularity {
        return likes.get().let {
            when {
                it > 9 -> Popularity.STAR
                it > 4 -> Popularity.POPULAR
                else -> Popularity.NORMAL
            }
        }
    }

}



private fun ObservableInt.increment() {
    set(get()+1)
}
