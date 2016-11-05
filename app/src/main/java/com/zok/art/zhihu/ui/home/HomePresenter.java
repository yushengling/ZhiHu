package com.zok.art.zhihu.ui.home;

import android.os.Bundle;

import com.zok.art.zhihu.R;
import com.zok.art.zhihu.api.ApiService;
import com.zok.art.zhihu.bean.StoriesLatestBean;
import com.zok.art.zhihu.bean.StoryListItemBean;
import com.zok.art.zhihu.ui.refresh.RefreshPresenter;
import com.zok.art.zhihu.utils.AppUtil;

import java.util.List;

import rx.Observable;

/**
 * @author 赵坤
 * @email artzok@163.com
 */
public class HomePresenter extends RefreshPresenter<StoriesLatestBean, HomeContract.View, Object>
        implements HomeContract.Presenter {

    public HomePresenter(Bundle initParams) {
        super(initParams);
    }

    @Override
    protected Observable<StoriesLatestBean> getLatestObservable(ApiService apiService, Object params) {
        return apiService.latestNewsStories();
    }

    @Override
    public List<StoryListItemBean> getListBeans(StoriesLatestBean mode) {
        return mode.getListStories();
    }

    @Override
    public String getTitle() {
        return AppUtil.getString(R.string.menu_home_tip);
    }
}