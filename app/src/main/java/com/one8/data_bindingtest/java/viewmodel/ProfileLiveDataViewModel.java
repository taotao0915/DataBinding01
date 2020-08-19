package com.one8.data_bindingtest.java.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class ProfileLiveDataViewModel extends ViewModel {
    public LiveData<String> name;
    public LiveData<String> lastName;
    public MutableLiveData<Integer> likes;
    public LiveData<Popularity> popularity;

    public void onLike(){
        likes.setValue(getLikes().getValue()+1);
    }


    public LiveData<String> getName() {
        return name;
    }

    public void setName(LiveData<String> name) {
        this.name = name;
    }

    public LiveData<String> getLastName() {
        return lastName;
    }

    public void setLastName(LiveData<String> lastName) {
        this.lastName = lastName;
    }

    public MutableLiveData<Integer> getLikes() {
        return likes;
    }

    public void setLikes(MutableLiveData<Integer> likes) {
        this.likes = likes;
    }

    public LiveData<Popularity> getPopularity() {
        return popularity;
    }

    public void setPopularity(LiveData<Popularity> popularity) {
        this.popularity = popularity;
    }
}

