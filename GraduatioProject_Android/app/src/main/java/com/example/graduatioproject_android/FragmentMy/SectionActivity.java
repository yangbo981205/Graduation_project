package com.example.graduatioproject_android.FragmentMy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.graduatioproject_android.R;

public class SectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);
        getWindow().setStatusBarColor(0xff4f4f4f);
    }
}
