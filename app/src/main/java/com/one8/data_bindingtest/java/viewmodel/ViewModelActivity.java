package com.one8.data_bindingtest.java.viewmodel;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.util.Function;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelProviders;
import com.one8.data_bindingtest.R;
import com.one8.data_bindingtest.databinding.ViewModelProfileBinding;


public class ViewModelActivity extends AppCompatActivity {
    public MutableLiveData<Integer> likes = new MutableLiveData<Integer>(0);
    public LiveData<Popularity> popularity = Transformations.map(likes, new Function<Integer, Popularity>() {
        @Override
        public Popularity apply(Integer input) {
            Log.i("TAG","----------"+input);
            if(input>9){
                return Popularity.STAR;
            }else if(input>4){
                return Popularity.POPULAR;
            }
            return Popularity.NORMAL;
        }
    });

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ProfileLiveDataViewModel profileLiveDataViewModel = ViewModelProviders.of(this).get(ProfileLiveDataViewModel.class);
        profileLiveDataViewModel.setName(new MutableLiveData<String>("Ada"));
        profileLiveDataViewModel.setLikes(likes);
        profileLiveDataViewModel.setLastName(new MutableLiveData<String>("Lovelace"));
        profileLiveDataViewModel.setPopularity(popularity);

        ViewModelProfileBinding binding = DataBindingUtil.setContentView(this, R.layout.view_model_profile);
        binding.setViewmodel(profileLiveDataViewModel);
        binding.setLifecycleOwner(this);
    }
}
