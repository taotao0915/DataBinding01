package com.one8.data_bindingtest.java.observable;

import android.widget.ImageView;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;

@BindingMethods(
        @BindingMethod(type = ImageView.class,
        attribute = "app:srcCompat",
        method = "setImageResource"))
public class MyBindingMethods{

}
