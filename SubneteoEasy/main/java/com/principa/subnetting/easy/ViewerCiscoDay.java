package com.principa.subnetting.easy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ViewerCiscoDay extends AppCompatActivity {

    final String url = "http://www.utng.edu.mx/index.php/296-utng-cisco-day";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewer_cisco_day);


        WebView web = findViewById(R.id.visorCisco);


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
