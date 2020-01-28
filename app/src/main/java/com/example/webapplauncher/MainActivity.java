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
        oWebView.addJavascriptInterface(new WebAppInterface(this), String.format(getResources().getString(R.string.app_javascript_namespace)));
        oWebView.getSettings().setDomStorageEnabled(true);
        oWebView.getSettings().setJavaScriptEnabled(true);
        oWebView.getSettings().setUserAgentString(String.format(getResources().getString(R.string.app_useragent)));

        //load only from same domain
        oWebView.setWebViewClient(new android.webkit.WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(android.webkit.WebView view, android.webkit.WebResourceRequest request) {

                String sUrl = request.getUrl().toString();
                String sOriginHost = android.net.Uri.parse(String.format(view.getContext().getResources().getString(R.string.app_url))).getHost();

                if (sOriginHost.equals(android.net.Uri.parse(sUrl).getHost())) {
                    // This is my website, so do not override; let my WebView load the page
                    return false;
                }

                // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
                android.content.Intent intent = new android.content.Intent(android.content.Intent.ACTION_VIEW, android.net.Uri.parse(sUrl));
                view.getContext().startActivity(intent);
                return true;
            }
        });

        //load start page
        oWebView.loadUrl(String.format(getResources().getString(R.string.app_url)));
    }
}
