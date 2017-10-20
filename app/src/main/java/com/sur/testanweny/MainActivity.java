package com.sur.testanweny;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.just.library.AgentWeb;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private AgentWeb mAgentWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        linearLayout = ((LinearLayout) findViewById(R.id.linearLayout));


        mAgentWeb = AgentWeb.with(this)//
                .setAgentWebParent(linearLayout,new LinearLayout.LayoutParams(-1,-1) )//
                .useDefaultIndicator()//
                .defaultProgressBarColor()
                .setWebChromeClient(mWebChromeClient)
                .setWebViewClient(mWebViewClient)
                .setSecutityType(AgentWeb.SecurityType.strict)
                .createAgentWeb()//
                .ready()
                .go("http://mobile.anweny.com/");

    }

    //WebViewClient
    private WebViewClient mWebViewClient=new WebViewClient(){

        @Override
        public WebResourceResponse shouldInterceptRequest(WebView view, String url) {

//            Log.e("SSSSS","====拦截==url=="+url);
//            if(url.contains("https://m.huaxiafinance.com/favicon.ico")){
//                Toast.makeText(MainActivity.this, "前往平台投资", Toast.LENGTH_SHORT).show();
//
//            }else{
//            }
            return super.shouldInterceptRequest(view, url);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.e("SSSSS","====拦截==url=="+url);

            if(url.contains("https://m.huaxiafinance.com/newPage/invite/inviteH5Page.spring?activityId=20170912&amp;channelId=C02100036&amp;shareId=22")){
                startActivity(new Intent(MainActivity.this,WebActivity.class));

                return true;
            }else{
                return super.shouldOverrideUrlLoading(view, url);
            }
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            //do you  work
        }
    };
    //WebChromeClient
    private WebChromeClient mWebChromeClient=new WebChromeClient(){
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            //do you work
        }
    };
}
