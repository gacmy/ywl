package com.gac.ywl.widget.web;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.gac.ywl.utils.RxBus;

public class CustomWebClient extends WebViewClient {

    private boolean mLastLoadFailed = false;
    private boolean needPass = false;
    private Context mContext;
    private boolean mIsShowLoading = true;
    public CustomWebClient(){}
    public CustomWebClient(Context context,boolean needPass){
        this.needPass = needPass;
        this.mContext=context;
    }

    public CustomWebClient(Context context,boolean needPass,boolean isShowLoading){
        this.needPass = needPass;
        this.mContext=context;
        this.mIsShowLoading=isShowLoading;
    }


    @Override
    public void onPageFinished(WebView webView, String url) {
        super.onPageFinished(webView, url);
       // LogUtil.i("voiceDetail onPageFinished "+url+" "+mLastLoadFailed);
        if(!mLastLoadFailed){
            webView.setVisibility(View.VISIBLE);
//            if(webView instanceof CustomActionWebView){
//                CustomActionWebView customActionWebView = (CustomActionWebView) webView;
//                customActionWebView.linkJSInterface();
//            }
        }
        if(mIsShowLoading) {
            //DialogUtils.dismiss();
        }
    }


    @Override
    public void onPageStarted(WebView webView, String url, Bitmap favicon) {
        super.onPageStarted(webView, url, favicon);
       // LogUtil.i("voiceDetail onPageStarted "+url);
        if(mIsShowLoading) {
          //  DialogUtils.showProgressDialogWithMessage(webView.getContext(), "");
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        operateOverrideUrl(view,request.getUrl().toString());
        return true;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        operateOverrideUrl(view,url);
        return true;
    }

    private void operateOverrideUrl(WebView view, String url){
       // LogUtil.i("operateOverrideUrl "+url+" "+needPass);
        //test
        if (url!=null) {
            Uri uri = Uri.parse(url);
            String scheme = uri.getScheme();
            String host=uri.getHost();
           // LogUtil.i("operateOverrideUrl ===87===>scheme=" + scheme+",host="+host);
            if ("keting".equals(scheme)) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
//               mContext.startActivity(intent);
                 //SchemeUtil.goPage(intent, mContext);
               // MainActivity.goPage(mContext, uri);
                return;
            }
            if("a4apag.mlinks.cc".equals(host)){
                //LogUtil.i("operateOverrideUrl ===97===>scheme=" + scheme+",host="+host);
                return;
            }
        }
        //
        if (url!=null&&!url.startsWith("http://") && !url.startsWith("https://")) {
            return;
        }

        if(needPass){
            //LogUtil.i("operateOverrideUrl ===100===>"+url+" "+needPass);
           // BannerPage.goPage(view.getContext(),url,"");
        }else {
           // LogUtil.i("operateOverrideUrl ===103===>"+url+" "+needPass);
            view.loadUrl(url);
        }
    }

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
       // LogUtil.i("voiceDetail onReceivedError ");
        receiveError(view,"");
    }

    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        //LogUtil.i("voiceDetail onReceivedError 22"+errorCode+" "+description);
        receiveError(view,description);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
        super.onReceivedHttpError(view, request, errorResponse);
//        LogUtil.i("voiceDetail onReceivedHttpError "+errorResponse.toString());
//        if(errorResponse!=null){
//            LogUtil.e("errorCode:"+errorResponse.getStatusCode()+","+errorResponse.getReasonPhrase()+","+errorResponse.getEncoding());
//        }
//        if(errorResponse!=null&&errorResponse.getStatusCode()==404){
//            receiveError(view,"");
//        }
    }

    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        //super.onReceivedSslError(view, handler, error);
        //LogUtil.i("voiceDetail onReceivedSslError  "+error.toString());
        handler.proceed();
//        receiveError(view,"");
    }

    private void receiveError(WebView view, String description){
        mLastLoadFailed = true;
        view.setVisibility(View.INVISIBLE);
        if(!needPass){
           // RxBus.getInstance().post(new Net404Event());
        }
        //LogUtil.i("voiceDetail receiveError all ");
    }
}