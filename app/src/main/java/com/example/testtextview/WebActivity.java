package com.example.testtextview;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class WebActivity extends AppCompatActivity {

    Button bgo, bback, bnaver, bdaum, bgoogle;
    EditText eturl;
    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        bgo = (Button) findViewById(R.id.btngo);
        bback = (Button) findViewById(R.id.btnback);
        bnaver = (Button) findViewById(R.id.naver);
        bdaum = (Button) findViewById(R.id.daum);
        bgoogle = (Button) findViewById(R.id.google);
        eturl = (EditText) findViewById(R.id.url);
        wv = (WebView) findViewById(R.id.webview);

        wv.setWebViewClient(new WebViewClient());
        wv.getSettings().setJavaScriptEnabled(true);

        bgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv.loadUrl("https://" + eturl.getText().toString());
            }
        });

        bback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv.goBack();
            }
        });

        bnaver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv.loadUrl("https://m.naver.com");
            }
        });

        bdaum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv.loadUrl("https://m.daum.net");
            }
        });

        bgoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv.loadUrl("https://www.google.com");
            }
        });
    }
}