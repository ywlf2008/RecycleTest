package com.example.yhuan.recycletest;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ContentFragment extends Fragment {

    @Bind(R.id.content_text)
    TextView contentText;

    public ContentFragment(){
    }

    public static ContentFragment newInstance(String text){
        ContentFragment fragment = new ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text",text);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_content, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String text = bundle.getString("text");
            if (text != null) {
                contentText.setText(text);
            }
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
