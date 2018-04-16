package com.agolovachev.fandroidvktest.model.view;

import android.view.View;

import com.agolovachev.fandroidvktest.model.WallItem;
import com.agolovachev.fandroidvktest.ui.holder.NewsItemBodyHolder;

public class NewsFeedItemBodyViewModel extends BaseViewModel {
    private int mId;
    private String mText;

    public NewsFeedItemBodyViewModel(WallItem wallItem) {
        this.mId = wallItem.getId();
        this.mText = wallItem.getText();
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.NewsFeedItemBody;
    }

    @Override
    public NewsItemBodyHolder onCreateViewHolder(View view) {
        return new NewsItemBodyHolder(view);
    }

    public String getText() {
        return mText;
    }

    public int getId() {
        return mId;
    }
}
