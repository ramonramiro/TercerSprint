package com.principa.subnetting.easy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;



public class ViewerByeIpv extends AppCompatActivity {

    final String url = "https://www.xatakamovil.com/conectividad/se-acabaron-las-direcciones-ipv4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bye_ipv_viewer);


        WebView web =(WebView) findViewById(R.id.visorByeIpv);


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
