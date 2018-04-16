package com.agolovachev.fandroidvktest.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.agolovachev.fandroidvktest.MyApplication;
import com.agolovachev.fandroidvktest.R;
import com.agolovachev.fandroidvktest.common.BaseAdapter;
import com.agolovachev.fandroidvktest.model.WallItem;
import com.agolovachev.fandroidvktest.model.view.NewsFeedItemBodyViewModel;
import com.agolovachev.fandroidvktest.rest.api.WallApi;
import com.agolovachev.fandroidvktest.rest.model.request.WallGetRequestModel;
import com.agolovachev.fandroidvktest.rest.model.response.WallGetResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFeedFragment extends BaseFragment {

    @Inject
    WallApi mWallApi;

    RecyclerView mRecyclerView;
    BaseAdapter mAdapter;

    public NewsFeedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mWallApi.get(new WallGetRequestModel(-86529522).toMap()).enqueue(new Callback<WallGetResponse>() {
            @Override
            public void onResponse(Call<WallGetResponse> call, Response<WallGetResponse> response) {
                List<NewsFeedItemBodyViewModel> list = new ArrayList<>();

                for (WallItem item : response.body().response.getItems()) {
                    list.add(new NewsFeedItemBodyViewModel(item));
                }

                mAdapter.addItems(list);

                Toast.makeText(getActivity(), "Likes: " + response.body().response.getItems().get(0).getLikes().getCount(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<WallGetResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRecyclerView(view);
        setUpAdapter(mRecyclerView);
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_feed;
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }

    private void setUpRecyclerView(View rootView) {
        mRecyclerView = rootView.findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setUpAdapter(RecyclerView rv) {
        mAdapter = new BaseAdapter();
        rv.setAdapter(mAdapter);
    }
}
