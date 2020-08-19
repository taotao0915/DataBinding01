package com.one8.data_bindingtest.java.observable;

import android.view.View;
import androidx.databinding.BindingConversion;

public class ConverterUtil {

    public static boolean isZero(int number){
        return number==0;
    }

    @BindingConversion
    public static int boolToVisibility(boolean isNotVisible){
        if (isNotVisible){
            return View.GONE;
        } else {
            return View.VISIBLE;
        }
    }
}
