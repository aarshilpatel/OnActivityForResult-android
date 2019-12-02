package com.example.aarshil.onactivityforresult;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebviewActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        webView = (WebView)findViewById(R.id.webview);
        webView.setWebViewClient(new MyWebview());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.loadUrl("https://www.javatpoint.com");


    }

    private class MyWebview extends WebViewClient {


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {


            view.loadUrl(url);

            return true;
        }
    }


    @Override
    public void onBackPressed() {

       if (webView.canGoBack()){

           webView.goBack();
       }else {

           finish();
       }

        //super.onBackPressed();
    }
}
