package com.example.yhuan.recycletest;

import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import butterknife.Bind;
import butterknife.ButterKnife;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class WaterfallActivity extends ActionBarActivity {
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private List<String> mDatas = null;

    private SimpleRecyclerCardAdapter mSimpleRecyclerAdapter;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.app_recyclerview)
    RecyclerView mRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.app_recyclerview);

//        initAppToolBar();
        initDataAndView();
    }

    private void initDataAndView() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i <= 'z'; i++) {
            mDatas.add(String.valueOf((char) i));
        }
        mSimpleRecyclerAdapter = new SimpleRecyclerCardAdapter(this, mDatas);
        mRecyclerView.setAdapter(mSimpleRecyclerAdapter);
        //设置网格布局管理器
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        mSimpleRecyclerAdapter.setOnItemActionListener(new SimpleRecyclerCardAdapter.OnItemActionListener() {

            @Override
            public boolean onItemLongClickListener(View v, int pos) {
                Toast.makeText(WaterfallActivity.this, "-长按-" + pos, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public void onItemClickListener(View v, int pos) {
                Toast.makeText(WaterfallActivity.this, "-单击-" + pos, Toast.LENGTH_SHORT).show();
            }
        });

    }

//    /**
//     * init app bar
//     */
//    private void initAppToolBar() {
//        mToolbar.setNavigationIcon(R.drawable.ktv_ic_main_hot_pressed);
//        mToolbar.setTitle("Rocko");// 标题的文字需在setSupportActionBar之前，不然会无效
//        mToolbar.inflateMenu(R.menu.main);
//        setShortcutsVisible(mToolbar.getMenu());
//        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.action_settings:
//                        break;
//                    case R.id.action_mail:
//                        break;
//                    case R.id.action_plus:
//                        break;
//                    default:
//                        break;
//                }
//                return true;
//            }
//        });
//
//        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Log.e("Navigation", "Click");
//            }
//        });
//    }

    private void setShortcutsVisible(Menu menu) {
        if (MenuBuilder.class.isInstance(menu)) {
            MenuBuilder builder = (MenuBuilder) menu;
            builder.setShortcutsVisible(true);
            try {
                Method m = menu.getClass().getDeclaredMethod(
                        "setOptionalIconsVisible", Boolean.TYPE);
                m.setAccessible(true);
                m.invoke(builder, true);
            } catch (Exception ie) {
            }
        }
    }
}