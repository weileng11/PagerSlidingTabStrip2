package com.xzx.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PagerModelManager {
    private List<CharSequence> titleList    = new ArrayList();
    private List<Fragment> fragmentList = new ArrayList();
    public static final String TYPE              = "type";

    public PagerModelManager() {
    }

    public Fragment getItem(int position) {
        return this.fragmentList.get(position);
    }

    public int getFragmentCount() {
        return this.fragmentList.size();
    }

    public boolean hasTitles() {
        return this.titleList.size() != 0;
    }

    public CharSequence getTitle(int position) {
        return this.titleList.get(position);
    }

    public PagerModelManager addFragment(Fragment fragment, CharSequence title) {
        this.titleList.add(title);
        this.addFragment(fragment);
        return this;
    }

    public PagerModelManager addFragment(Fragment fragment) {
        this.fragmentList.add(fragment);
        return this;
    }

    public PagerModelManager addCommonFragment(Class<?> c, List<? extends Serializable> list,
                                               List<String> titleList, List<String> type) {
        this.titleList.addAll(titleList);
        this.addCommonFragment(c, list, type);
        return this;
    }

    public PagerModelManager addCommonFragment(Class<?> c, List<? extends Serializable> list,
                                               List<String> type) {
        try {
            for (int e = 0; e < list.size(); ++e) {
                Fragment fragment = (Fragment) c.newInstance();
                Bundle bundle = new Bundle();
                bundle.putString(TYPE, type.get(e));
                fragment.setArguments(bundle);
                this.fragmentList.add(fragment);
            }
        } catch (InstantiationException var6) {
            var6.printStackTrace();
        } catch (IllegalAccessException var7) {
            var7.printStackTrace();
        }

        return this;
    }

    public PagerModelManager addCommonFragment(List<? extends Fragment> list) {
        this.fragmentList.addAll(list);
        return this;
    }

    public PagerModelManager addCommonFragment(List<? extends Fragment> list, List<String> titleList) {
        List<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.clear();
        this.fragmentList.addAll(list);
        this.titleList.addAll(titleList);
        this.addCommonFragment(fragmentList);
        return this;
    }

    public PagerModelManager addCommonFragment(List<? extends Fragment> list,
                                               List<String> titleList, List<String> type) {
        List<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.clear();
        for (int i = 0; i < titleList.size(); i++) {
            Fragment fragment = list.get(i);
            Bundle bundle = new Bundle();
            bundle.putString(TYPE, type.get(i));
            fragment.setArguments(bundle);
            fragmentList.add(fragment);
        }
        this.titleList.addAll(titleList);
        this.addCommonFragment(fragmentList);
        return this;
    }

    public PagerModelManager addCommonFragmentObject(List<? extends Fragment> list,
                                                     List<String> titleList,
                                                     List<? extends Serializable> type) {
        List<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.clear();
        for (int i = 0; i < titleList.size(); i++) {
            Fragment fragment = list.get(i);
            Bundle bundle = new Bundle();
            bundle.putSerializable(TYPE, type.get(i));
            fragment.setArguments(bundle);
            fragmentList.add(fragment);
        }
        this.titleList.addAll(titleList);
        this.addCommonFragment(fragmentList);
        return this;
    }
}
