package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private WebView TemperatureWW=null;
    private WebView RecommendWW=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TemperatureWW=(WebView)findViewById(R.id.TemperatureWW);
        RecommendWW=(WebView)findViewById(R.id.RecommendWW);

        TemperatureWW.getSettings().setJavaScriptEnabled(true);
        RecommendWW.getSettings().setJavaScriptEnabled(true);

        TemperatureWW.setWebViewClient(new WebViewClient());
        RecommendWW.setWebViewClient(new WebViewClient());

        TemperatureWW.loadUrl("http://t.pae.baidu.com/s?s=bai-3zjn5d");
        RecommendWW.loadUrl("https://m.baidu.com/sf?pd=life_compare_weather&from_sf=1&openapi=1&dspName=iphone&word=%E5%A4%AA%E5%8E%9F&title=%E7%94%9F%E6%B4%BB%E6%B0%94%E8%B1%A1%E6%8C%87%E6%95%B0&resource_id=4600&ext={%22sf_tab_name%22:%22chuyou%22,%22bar_sort%22:%22chuyou,chuanyi,fangshai,ganmao,xiche,huazhuang%22}&county_id=101100101&lid=6809126878420256731&referlid=6809126878420256731&ms=1&frsrcid=4514&frorder=1");

    }
}
