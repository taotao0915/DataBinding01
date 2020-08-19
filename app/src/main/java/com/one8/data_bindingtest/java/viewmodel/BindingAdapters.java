package com.one8.data_bindingtest.java.viewmodel;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;
import com.one8.data_bindingtest.R;

public class BindingAdapters {
    /**
     * A Binding Adapter that is called whenever the value of the attribute `app:popularityIcon`
     * changes. Receives a popularity level that determines the icon and tint color to use.
     */
    @BindingAdapter("app:popularityIcon")
    public static void popularityIcon(ImageView view,Popularity popularity){
        int color = getAssociatedColor(popularity, view.getContext());

        view.setImageTintList(ColorStateList.valueOf(color));

        view.setImageDrawable(getDrawablePopularity(popularity, view.getContext()));
    }

    /**
     * A Binding Adapter that is called whenever the value of the attribute `android:progressTint`
     * changes. Depending on the value it determines the color of the progress bar.
     */
    @BindingAdapter("app:progressTint")
    public static void tintPopularity(ProgressBar view,Popularity popularity){
        int color = getAssociatedColor(popularity, view.getContext());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            view.setProgressTintList(ColorStateList.valueOf(color));
        }
    }

    /**
     *  Sets the value of the progress bar so that 5 likes will fill it up.
     *
     *  Showcases Binding Adapters with multiple attributes. Note that this adapter is called
     *  whenever any of the attribute changes.
     */
    @BindingAdapter(value = {"app:progressScaled", "android:max"}, requireAll = true)
    public static void setProgress(ProgressBar progressBar,int like,int max){
        if((like * max / 5)>max){
            progressBar.setProgress(max);
        }else{
            progressBar.setProgress(like * max / 5);
        }
    }

    /**
     * Unused Binding Adapter to replace the Binding Converter that hides a view if the number
     * of likes is zero.
     */
    @BindingAdapter("app:hideIfZero")
    public static void hideIfZero(View view, int number) {
        if(number==0){
            view.setVisibility(View.GONE);
        }else {
            view.setVisibility(View.VISIBLE);
        }
    }


    private static int getAssociatedColor(Popularity popularity, Context context) {
        if(popularity==Popularity.POPULAR){
            return context.getResources().getColor(R.color.popular);
        }else if(popularity==Popularity.STAR){
            return context.getResources().getColor(R.color.star);
        }else{
            return context.getResources().getColor(R.color.colorAccent);
        }
    }

    private static Drawable getDrawablePopularity(Popularity popularity, Context context) {
        if(popularity==Popularity.POPULAR){
            return ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp);
        }else if(popularity==Popularity.STAR){
            return ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp);
        }else{
            return ContextCompat.getDrawable(context, R.drawable.ic_person_black_96dp);
        }
    }

}
