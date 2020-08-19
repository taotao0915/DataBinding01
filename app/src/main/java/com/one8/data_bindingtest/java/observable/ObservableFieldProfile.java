package com.one8.data_bindingtest.java.observable;

import androidx.databinding.ObservableInt;

public class ObservableFieldProfile {
    private String name;
    private String lastName;
    private ObservableInt like;

    public ObservableFieldProfile(String name, String lastName,ObservableInt like) {
        this.name = name;
        this.lastName = lastName;
        this.like = like;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ObservableInt getLike() {
        return like;
    }

    public void setLike(ObservableInt like) {
        this.like = like;
    }
}
