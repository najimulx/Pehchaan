package com.example.dell.firstcry.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import com.example.dell.firstcry.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;



/**
 * A simple {@link Fragment} subclass.
 */
public class CommerceFragment extends Fragment {

    public WebView mWebView;
    FloatingActionButton fab_back;
    public CommerceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_commerce, container, false);

        mWebView = v.findViewById(R.id.webView_ecom);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebChromeClient(new WebChromeClient());
        fab_back = v.findViewById(R.id.fab_back);
        loadPage();
        fab_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mWebView.canGoBack()){
                    mWebView.goBack();
                }
            }
        });

        return v;
    }

    void loadPage(){
        mWebView.loadUrl("https://pehchaanec.herokuapp.com/");
    }

}
