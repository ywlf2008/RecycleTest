package com.example.yhuan.recycletest;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.recyclerview)
    RecyclerView mRecyclerView;
    @Bind(R.id.water)
    Button waterBtn;
    private List<String> mDatas;
    private MyRecyclerViewAdapter mAdapter;
    private FragmentManager fm;

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
            public void onItemClick(View view, String position) {
                ContentFragment fragment = ContentFragment.newInstance("第" + position + "个fragment");
                fm.beginTransaction().replace(R.id.content_layout, fragment).commit();
            }
        });
        mRecyclerView.setAdapter(mAdapter);
        fm = getFragmentManager();
        Fragment fragment = new ContentFragment();
        fm.beginTransaction().replace(R.id.content_layout, fragment).commit();

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
