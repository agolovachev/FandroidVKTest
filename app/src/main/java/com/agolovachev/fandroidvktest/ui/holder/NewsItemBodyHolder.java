package com.agolovachev.fandroidvktest.ui.holder;

import android.view.View;
import android.widget.TextView;

import com.agolovachev.fandroidvktest.R;
import com.agolovachev.fandroidvktest.model.view.NewsFeedItemBodyViewModel;

public class NewsItemBodyHolder extends BaseViewHolder<NewsFeedItemBodyViewModel> {

    public TextView tvText;

    public NewsItemBodyHolder(View itemView) {
        super(itemView);

        tvText = itemView.findViewById(R.id.tv_text);
    }

    @Override
    public void bindViewHolder(NewsFeedItemBodyViewModel item) {
        tvText.setText(item.getText());
    }

    @Override
    public void unbindViewHolder() {
        tvText.setText(null);
    }
}