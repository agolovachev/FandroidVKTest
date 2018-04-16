package com.agolovachev.fandroidvktest.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.agolovachev.fandroidvktest.model.view.BaseViewModel;

public abstract class BaseViewHolder<Item extends BaseViewModel> extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindViewHolder(Item item);

    public abstract void unbindViewHolder();
}
