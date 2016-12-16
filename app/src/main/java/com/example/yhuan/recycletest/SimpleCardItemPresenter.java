package com.example.yhuan.recycletest;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SimpleCardItemPresenter extends RecyclerView.ViewHolder {
    @Bind(R.id.cardview)
    CardView cardview;
    @Bind(R.id.item_img)
    ImageView itemImg;
    @Bind(R.id.item_title)
    TextView itemTitle;
    private R.id data;

    public SimpleCardItemPresenter(LayoutInflater inflater, ViewGroup parent) {
        this(inflater.inflate(R.layout.simple_card_item, parent, false));
    }

    public SimpleCardItemPresenter(View view) {
        super(view);
        ButterKnife.bind(this, itemView);
    }

    public R.id getData() {
        return data;
    }

    public void refresh() {
        if (data != null) {
            itemView.setVisibility(View.VISIBLE);
        } else {
            itemView.setVisibility(View.GONE);
        }
    }

    public void swapData(R.id data) {
        this.data = data;
        refresh();
    }
}
