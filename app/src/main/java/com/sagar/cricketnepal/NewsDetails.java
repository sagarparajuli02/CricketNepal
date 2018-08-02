package com.sagar.cricketnepal;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class NewsDetails extends AppCompatActivity {


        ProgressBar progressBar;
        WebView webView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_news_details);
            if(getSupportActionBar()!=null){
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);;
                getSupportActionBar().setDisplayShowHomeEnabled(true);
            }
            progressBar= (ProgressBar) findViewById(R.id.progressbar) ;
            webView= (WebView) findViewById(R.id.webview);
            webView.setVisibility(View.INVISIBLE);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebChromeClient(new WebChromeClient());
            webView.setWebViewClient(new WebViewClient(){

                @Override
                public  void onPageStarted (WebView view, String url , Bitmap favicon){
                    super.onPageStarted(view, url, favicon);
                }
                @Override
                public  void  onPageFinished(WebView view, String url){
                    super.onPageFinished(view, url);
                    progressBar.setVisibility(View.GONE);
                    webView.setVisibility(View.VISIBLE);
                }
            });



            webView.loadUrl(getIntent().getStringExtra("Link"));
        }



        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            if (item.getItemId()==android.R.id.home);
            finish();
            return super.onOptionsItemSelected(item);
        }
    }

