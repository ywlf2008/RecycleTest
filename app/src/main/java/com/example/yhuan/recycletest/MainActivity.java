package com.example.yhuan.recycletest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.recyclerview)
    RecyclerView mRecyclerView;
    @Bind(R.id.water)
    Button waterBtn;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    private List<String> mDatas;
    private MyRecyclerViewAdapter mAdapter;
    private FragmentManager fm;
    private Map<Integer, Fragment> fMaps = new HashMap<Integer, Fragment>();
    private MyPagerAdapter mPagerAdapter;
    private List<Fragment> mFragments = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(manager);
        mAdapter = new MyRecyclerViewAdapter(this, mDatas);
        mAdapter.setOnRecyclerViewItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                ContentFragment fragment = ContentFragment.newInstance("第" + position + "个fragment");
//                fm.beginTransaction().replace(R.id.content_layout, fragment).commit();
//                Fragment fragment = fMaps.get(position);
//                if (fragment == null) {
//                    fragment = ContentFragment.newInstance("第" + (position + 1) + "个fragment");
//                    fMaps.put(position, fragment);
//                    mPagerAdapter.notifyDataSetChanged();
//                }
                viewpager.setCurrentItem(position);
            }
        });
        mRecyclerView.setAdapter(mAdapter);
//        fm = getFragmentManager();
//        Fragment fragment = new ContentFragment();
//        fm.beginTransaction().replace(R.id.content_layout, fragment).commit();
//        ContentFragment fragment = new ContentFragment();
//        fMaps.put(0, fragment);
//        mPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), fMaps);
        for (int i = 0 ; i < mDatas.size() ; i++){
            Fragment fragment = ContentFragment.newInstance("第" + (i + 1) + "个fragment");
            mFragments.add(fragment);
        }
        mPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(),mFragments);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mRecyclerView.scrollToPosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewpager.setAdapter(mPagerAdapter);

    }

    private void initData() {
        mDatas = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

    @OnClick(R.id.water)
    public void onClick() {
        startActivity(new Intent(MainActivity.this, WaterfallActivity.class));
    }

}
