package com.tm.blplayer.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;
import com.tm.blplayer.R;
import com.tm.blplayer.bean.BannerItem;
import com.tm.blplayer.bean.HomeData;
import com.tm.blplayer.bean.VideoItem;
import com.tm.blplayer.listener.OnItemClickListener;
import com.tm.blplayer.mvp.presenter.RecommendPresenter;
import com.tm.blplayer.mvp.view.BaseView;
import com.tm.blplayer.ui.activity.VideoDetailActivity;
import com.tm.blplayer.ui.adapter.VideoCardAdapter;
import com.tm.blplayer.utils.CommonUtil;
import com.tm.blplayer.utils.ToastUtils;
import com.tm.blplayer.utils.constants.Constants;
import com.tm.blplayer.widget.GridSpacingItemDecoration;
import com.yyydjk.library.BannerLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author wutongming
 * @description 推荐
 * @since 2017/4/18
 */

public class RecommendFragment extends BaseFragment implements BaseView {

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.banner)
    BannerLayout mBannerLayout;
    @BindView(R.id.rv_recommend)
    RecyclerView mRecyclerView;

    private List<VideoItem> mData = new ArrayList<>();

//    private RecommendPresenter mRecommendPresenter;
    private VideoCardAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initView() {
        initRefreshLayout();
        initBannerLayout();
        initRecyclerView();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createPresenter();
        getData();
    }

    /**
     * 初始化刷新控件
     */
    private void initRefreshLayout() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });
    }

    /**
     * 根据手机分辨率设置bannerLayout大小  -->  图片比例2:1
     */
    private void initBannerLayout() {
        int width = CommonUtil.getScreenWidth(getActivity());
        ViewGroup.LayoutParams params = mBannerLayout.getLayoutParams();
        params.height = width / 2;
        mBannerLayout.setLayoutParams(params);
    }

    /**
     * 初始化RecyclerView
     */
    private void initRecyclerView() {
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        mAdapter = new VideoCardAdapter(getActivity(), mData);
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(Object object, int position) {
                VideoItem item = (VideoItem) object;
                if (item != null) {
                    Intent intent = new Intent(getActivity(), VideoDetailActivity.class);
                    intent.putExtra(Constants.VIDEO_AID, item.getAid());
                    startActivity(intent);
                }
            }
        });
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(2, Constants.CARD_MARGIN, true));
    }

    /**
     * 刷新控件开关
     */
    private void toggleRefresh(final boolean refresh) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(refresh);
            }
        });
    }

    /**
     * 创建presenter
     */
    private void createPresenter() {
        if (presenter == null) {
            presenter = new RecommendPresenter();
        }
        presenter.onAttach(this);
    }

    /**
     * 获取数据
     */
    private void getData() {
        toggleRefresh(true);
        presenter.requestData(null);
    }

    @Override
    public void onNetworkSuccess(Object result) {
        toggleRefresh(false);
        HomeData data = (HomeData) result;
        if (data != null && data.getVideo_list().size() > 0) {
            mBannerLayout.setViewUrls(filterBannerUrls(data.getBanner()));
            mBannerLayout.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    // TODO: 2017/5/17 banner点击跳转
                }
            });
            mData.clear();
            mData.addAll(data.getVideo_list());
            mAdapter.notifyDataSetChanged();
        } else {
            //空处理,展示空布局
            Logger.e("获取不到数据");
        }
    }

    /**
     * 清洗banner中的url
     */
    private List<String> filterBannerUrls(List<BannerItem> bannerItemList) {
        List<String> result = new ArrayList<>();
        for (BannerItem item : bannerItemList) {
            result.add(item.getPic());
        }
        return result;
    }

    @Override
    public void onNetworkFailed(int code, String errorMsg) {
        toggleRefresh(false);
        ToastUtils.showShortToast(getActivity(), errorMsg);
    }

    @Override
    public void onNetworkError(String error) {
        toggleRefresh(false);
        ToastUtils.showShortToast(getActivity(), error);
    }
}
