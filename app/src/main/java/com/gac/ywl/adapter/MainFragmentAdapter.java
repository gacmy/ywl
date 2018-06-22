package com.gac.ywl.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.gac.ywl.view.fragment.ContentFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @描述：
 * @file_name：com.gac.ywl.adapter
 * @author：gac
 * @time：2018/6/22:14:06
 */

public class MainFragmentAdapter extends FragmentListPageAdapter {
    private List<String> ids = new ArrayList<>();

    public MainFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setDatas(List<String> ids){
        this.ids.clear();
        this.ids.addAll(ids);
        notifyDataSetChanged();
    }

    public void addDatas(List<String> ids){
        this.ids.addAll(ids);
        notifyDataSetChanged();
    }
    public List<String> getDatas(){
        return ids;
    }
    public int size(){
        return ids.size();
    }
    @Override
    public Fragment getItem(int position) {
        ContentFragment fragment = new ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id",ids.get(position));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return ids.size();
    }
}
