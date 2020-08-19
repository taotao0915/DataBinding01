package com.one8.data_bindingtest.java.observable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableInt;
import android.os.Bundle;
import android.view.View;
import com.one8.data_bindingtest.R;
import com.one8.data_bindingtest.databinding.ObservableProfileBinding;


public class ObservableActivity extends AppCompatActivity {
    ObservableFieldProfile observableFieldProfile = new ObservableFieldProfile("Ada","Lovelace",new ObservableInt(0));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ObservableProfileBinding observableProfileBinding = DataBindingUtil.setContentView(this, R.layout.observable_profile);
        observableProfileBinding.setUser(observableFieldProfile);
//        ObservableProfileBinding binding = ObservableProfileBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//        binding.setUser(observableFieldProfile);
    }

    public void onLike(View view){
        observableFieldProfile.getLike().set(observableFieldProfile.getLike().get()+1);
    }
}