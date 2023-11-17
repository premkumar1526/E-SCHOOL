package com.cts.eschool;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String sName;
    private int sId;
    private double score;

    public Student(int sId, String sName, double score){
        this.sId = sId;
        this.sName = sName;
        this.score = score;
    }
    public String getsName() {
        return sName;
    }

    public int getsId() {
        return sId;
    }

    public double getScore() {
        return score;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public void setScore(double score) {
        this.score = score;
    }


}
