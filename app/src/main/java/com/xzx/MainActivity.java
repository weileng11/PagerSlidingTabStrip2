package com.xzx;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.xzx.adapter.ModelPagerAdapter;
import com.xzx.adapter.PagerModelManager;
import com.xzx.widget.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private PagerSlidingTabStrip mTabStrip;
    private ModelPagerAdapter   adapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabStrip= (PagerSlidingTabStrip) findViewById(R.id.pagertab);
        viewPager= (ViewPager) findViewById(R.id.view_pager);

        PagerModelManager factory = new PagerModelManager();
        factory.addCommonFragment(getFragments(), getTitles());
        adapter = new ModelPagerAdapter(getSupportFragmentManager(), factory);
        viewPager.setAdapter(adapter);
        mTabStrip.setViewPager(viewPager);

    }

    private List<String> getTitles() {
        List<String> list = new ArrayList<>();
        list.add("哈哈");
        list.add("啦啦啦");
        list.add("呵呵呵呵");
        return list;
    }

    private List<Fragment> getFragments() {
        List<Fragment> list = new ArrayList<>();
        Fragment testFragment1 = new TestFragment1();
        Fragment testFragment2 = new TestFragment2();
        Fragment testFragment3 = new TestFragment3();
        list.add(testFragment1);
        list.add(testFragment2);
        list.add(testFragment3);
        return list;
    }
}
