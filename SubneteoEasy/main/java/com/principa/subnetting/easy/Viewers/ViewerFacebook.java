package com.principa.subnetting.easy.Viewers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.principa.subnetting.easy.R;

public class ViewerFacebook extends AppCompatActivity {

    final String url = "https://www.facebook.com/UTNGDOLORESHIDALGO-222209577812067/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewer_facebook);


        WebView web =(WebView) findViewById(R.id.visorFace);


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
