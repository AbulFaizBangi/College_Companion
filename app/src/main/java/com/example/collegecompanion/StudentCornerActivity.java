package com.example.collegecompanion;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StudentCornerActivity extends AppCompatActivity {
    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_corner);

        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true); // Enable DOM storage
        webView.clearCache(true); // Clear WebView cache
        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);

        // Set desktop mode initially
        setDesktopMode(webView, true);

        webView.loadUrl("http://pvgcoetonline.org/(S(3ldupd0pltsn30eclwqpwf3y))/frm/frmLogin.aspx");

        // Enable WebView debugging for remote debugging with Chrome DevTools
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }

        // Add the button click listener
        Button toggleModeButton = findViewById(R.id.toggleModeButton);
        toggleModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle between mobile and desktop modes
                boolean isDesktopMode = webView.getSettings().getUserAgentString().contains("Linux x86_64");
                setDesktopMode(webView, !isDesktopMode);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        webView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        webView.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webView.destroy();
    }

    public void setDesktopMode(WebView webView, boolean enabled) {
        String newUserAgent = webView.getSettings().getUserAgentString();
        if (enabled) {
            try {
                String ua = webView.getSettings().getUserAgentString();
                String androidOSString = webView.getSettings().getUserAgentString().substring(ua.indexOf("("), ua.indexOf(")") + 1);
                newUserAgent = webView.getSettings().getUserAgentString().replace(androidOSString, "(X11; Linux x86_64)");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            newUserAgent = null;
        }

        webView.getSettings().setUserAgentString(newUserAgent);
        webView.getSettings().setUseWideViewPort(enabled);
        webView.getSettings().setLoadWithOverviewMode(enabled);
        webView.reload();
    }
}
