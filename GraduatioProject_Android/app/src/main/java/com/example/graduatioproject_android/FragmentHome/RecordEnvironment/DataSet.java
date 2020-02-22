package com.example.graduatioproject_android.FragmentHome.RecordEnvironment;

public class DataSet {
    String id=null;
    String time=null;
    String data=null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public DataSet(String id, String time, String data){
        this.id=id;
        this.time=time;
        this.data=data;
    }
}
