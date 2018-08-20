package com.principa.subnetting.easy.Viewers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.principa.subnetting.easy.R;

public class CalculatorViewfinder extends AppCompatActivity {

    final String url = "http://www.calculadora-redes.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_visor);

        WebView web =(WebView) findViewById(R.id.miVisor1);
        web.setWebViewClient(new MyWebViewClient());
        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true);
        web.loadUrl(url);
    }

    private class MyWebViewClient extends WebViewClient
    {

        public boolean shouldOverrideUrlLogding(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}