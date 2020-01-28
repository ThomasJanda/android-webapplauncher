package com.example.webapplauncher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //hide the title bar
        getSupportActionBar().hide();

        //load main activity
        setContentView(R.layout.activity_main);

        //enable all feature on the browser
        android.webkit.WebView oWebView = (android.webkit.WebView) findViewById(R.id.webView);
        oWebView.getSettings().setDomStorageEnabled(true);
        oWebView.getSettings().setJavaScriptEnabled(true);
        oWebView.setWebViewClient(new android.webkit.WebViewClient());
        oWebView.loadUrl(String.format(getResources().getString(R.string.app_url)));
    }
}
