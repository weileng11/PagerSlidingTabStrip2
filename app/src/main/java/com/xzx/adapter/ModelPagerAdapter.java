package com.xzx.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

public class ModelPagerAdapter extends FragmentStatePagerAdapter {
    protected PagerModelManager pagerModelManager;
    private FragmentManager fm;

    public ModelPagerAdapter(FragmentManager fm, PagerModelManager pagerModelManager) {
        super(fm);
        this.fm = fm;
        this.pagerModelManager = pagerModelManager;
    }

    public Fragment getItem(int position) {
        return this.pagerModelManager.getItem(position);
    }

    public int getCount() {
        return this.pagerModelManager.getFragmentCount();
    }

    public CharSequence getPageTitle(int position) {
        return this.pagerModelManager.hasTitles() ? this.pagerModelManager.getTitle(position)
                : super.getPageTitle(position);
    }

    @Override
    public Fragment instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        fm.beginTransaction().show(fragment).commit();
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // super.destroyItem(container, position, object);
        Fragment fragment = pagerModelManager.getItem(position);
        fm.beginTransaction().hide(fragment).commit();
    }
}
