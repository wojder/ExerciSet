package com.example.wojder.exerciset.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by root on 22.05.17.
 */

public class Media {

    @SerializedName("m")
    @Expose
    private String m;

    public Media(String m) {
        this.m = m;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }
}
