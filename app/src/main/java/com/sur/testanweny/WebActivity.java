package com.sur.testanweny;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.just.library.AgentWeb;

public class WebActivity extends AppCompatActivity {

    private LinearLayout webLinear;

    private AgentWeb mAgentWeb;
    private ImageView tv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);


        webLinear = ((LinearLayout) findViewById(R.id.webLinear));
        tv_back = ((ImageView) findViewById(R.id.tv_back));
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mAgentWeb = AgentWeb.with(this)//
                .setAgentWebParent(webLinear,new LinearLayout.LayoutParams(-1,-1) )//
                .useDefaultIndicator()//
                .defaultProgressBarColor()
                .setWebChromeClient(mWebChromeClient)
                .setWebViewClient(mWebViewClient)
                .setSecutityType(AgentWeb.SecurityType.strict)
                .createAgentWeb()//
                .ready()
                .go("https://m.huaxiafinance.com/newPage/invite/inviteH5Page.spring?activityId=20170912&amp;channelId=C02100036&amp;shareId=22");
    }



    //WebViewClient
    private WebViewClient mWebViewClient=new WebViewClient(){


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            Log.e("SSSSS","====拦截   2222==url=="+url);

            if(url.contains("https://m.huaxiafinance.com/newPage/invite/inviteH5Page.spring?activityId=20170912&amp;channelId=C02100036&amp;shareId=22")){

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
