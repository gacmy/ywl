package com.gac.ywl.view.fragment;

import android.os.Build;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.gac.ywl.R;
import com.gac.ywl.base.BaseMVPFragment;
import com.gac.ywl.base.IPresenter;
import com.gac.ywl.base.IView;
import com.gac.ywl.utils.SystemUtils;
import com.gac.ywl.widget.web.ActionSelectListener;
import com.gac.ywl.widget.web.CustomActionWebView;
import com.gac.ywl.widget.web.CustomWebClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @描述：
 * @file_name：com.gac.ywl.view.fragment
 * @author：gac
 * @time：2018/6/22:14:09
 */

public class ContentFragment extends BaseMVPFragment {
    @BindView(R.id.webview) CustomActionWebView webView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_content;
    }

    @Override
    protected void initView() {
        initWebView(webView);
    }
    private void initWebView(CustomActionWebView webView){

        List<String> list = new ArrayList<>();
        list.add("复制文字");
        list.add("生成图片");

        webView.setWebViewClient(new CustomWebClient(getContext(),true));

        webView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
//                LogUtil.e("webview title:"+title+" VERSION:"+ Build.VERSION.SDK_INT);
//                if((title.contains("404 Not Found")||title.contains("可听404"))&& Build.VERSION.SDK_INT<23){
//                    RxBus.getInstance().post(new Net404Event());
//                }
            }
        });

        //设置item
        webView.setActionList(list);

        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        //使用javascript
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        //链接js注入接口，使能选中返回数据
        webView.linkJSInterface();

        //增加点击回调
        webView.setActionSelectListener(new ActionSelectListener() {
            @Override
            public void onClick(String title, String selectText) {
                if(title.equals("生成图片")) {

//                    Bundle bundle = new Bundle();
//                    bundle.putString("type", "content");
//                    bundle.putString("audioName",viewModel.getAudioName());
//                    bundle.putString("text", selectText);
//                    bundle.putString("shareUrl", Http.HTTP_URL+"shareAudio/audioId/" + viewModel.getAudioId()+"?audioId="+viewModel.getAudioId()+"&type="+viewModel.getColumnId()+"&rid="+relattionId);
//                    bundle.putString("hbTitle","我制作了一张海报，点击链接阅读原文。");
//                    bundle.putString("hbSummery","");
//                    bundle.putString("hbUrl", Http.HTTP_URL+"shareAudio/audioId/" + viewModel.getAudioId()+"?audioId="+viewModel.getAudioId()+"&type="+viewModel.getColumnId()+"&rid="+relattionId);
//
//                    bundle.putString("relationId",relattionId);
//                    bundle.putString("relationType",relationType);
//                    bundle.putString("audioId",audioId);
//                    if(Util.isNotEmpty(viewModel.voliceListen))
//                        bundle.putString("fromTitle",viewModel.voliceListen);
//
//                    ShareImageActivity.goPage(mContext,bundle);
                    return;
                }else {
                    SystemUtils.copyText(selectText);
                }
            }

            @Override
            public void showImage(int index, String[] urls) {
//                showToast("showImage "+index+" "+urls.size());
//                LogUtil.e("showImage "+index+" "+urls[0]+" "+urls.length);
//
//                if (Util.isNotEmpty(urls)){
//                    ArrayList<String> imgList = new ArrayList<>(urls.length);
//                    for (int i=0;i<urls.length;i++){
//                        imgList.add(urls[i]);
//                    }
//                    ImageBrowseActivity.startActivity(mContext,imgList,index);
                }

        });

    }
    @Override
    protected void lazyLoad() {

    }

    @Override
    protected void initBaseView(IView view) {

    }

    @Override
    protected void initPresenter(IPresenter presenter) {

    }
}
