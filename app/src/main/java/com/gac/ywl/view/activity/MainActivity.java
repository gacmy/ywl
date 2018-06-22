package com.gac.ywl.view.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.EdgeEffectCompat;

import com.gac.ywl.R;
import com.gac.ywl.adapter.MainFragmentAdapter;
import com.gac.ywl.base.BaseActivity;
import com.gac.ywl.utils.StatusBarUtils;
import com.gac.ywl.utils.ToastUtils;
import com.gac.ywl.utils.ViewUtils;

import java.lang.reflect.Field;

import butterknife.BindView;

/**
 * @描述：
 * @file_name：com.gac.ywl.view
 * @author：gac
 * @time：2018/6/22:10:48
 */

public class MainActivity extends BaseActivity {
    @BindView(R.id.drawlayout) DrawerLayout drawerLayout;
    @BindView(R.id.vp_content) ViewPager vp_content;
    MainFragmentAdapter adapter;
    EdgeEffectCompat leftEdge;
    EdgeEffectCompat rightEdge;
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        StatusBarUtils.setFitSystemWindow(true,this);
        setSwipeEnabled(false);
        ViewUtils.setDrawerLeftEdgeSize(this,drawerLayout,0.1f);
        adapter = new MainFragmentAdapter(getSupportFragmentManager());
        vp_content.setAdapter(adapter);
        initViewPager(vp_content);
    }

    private void initViewPager(ViewPager vp){
        try {

            Field leftEdgeField = vp.getClass().getDeclaredField("mLeftEdge");
            Field rightEdgeField = vp.getClass().getDeclaredField("mRightEdge");
            if (leftEdgeField != null && rightEdgeField != null) {
                leftEdgeField.setAccessible(true);
                rightEdgeField.setAccessible(true);
                leftEdge = (EdgeEffectCompat) leftEdgeField.get(vp);
                rightEdge = (EdgeEffectCompat) rightEdgeField.get(vp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (rightEdge != null && !rightEdge.isFinished()) {//到了最后一张并且还继续拖动，出现蓝色限制边条了
                    ToastUtils.getInstance().showToast("到达最后一页");
                }
                if(leftEdge != null && !leftEdge.isFinished()){
                    ToastUtils.getInstance().showToast("已经第一页");
                }
            }
        });
    }
}
