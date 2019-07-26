package com.example.randomuserapp.data;

import java.util.List;

public class RandomUserData {

    private List<Results> results;
    private Info info;

    public void setResults(List<Results> results){
        this.results = results;
    }
    public List<Results> getResults(){
        return this.results;
    }
    public void setInfo(Info info){
        this.info = info;
    }
    public Info getInfo(){
        return this.info;
    }

}
