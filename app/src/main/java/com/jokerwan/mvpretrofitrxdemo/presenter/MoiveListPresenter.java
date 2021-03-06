package com.jokerwan.mvpretrofitrxdemo.presenter;

import com.jokerwan.mvpretrofitrxdemo.api.ApiSubscriber;
import com.jokerwan.mvpretrofitrxdemo.api.ApiUtils;
import com.jokerwan.mvpretrofitrxdemo.base.AWanBasePresenter;
import com.jokerwan.mvpretrofitrxdemo.model.MoiveListResponse;
import com.jokerwan.mvpretrofitrxdemo.view.IMoiveListView;

/**
 * Created by JokerWan on 2017/12/11.
 * WeChat: wjc398556712
 * Function:
 */

public class MoiveListPresenter extends AWanBasePresenter<IMoiveListView> {

    public void getMoiveList(){

        wApi.getMoiveList()
                .compose(ApiUtils.getScheduler())
                .subscribe(new ApiSubscriber<MoiveListResponse>() {
                    @Override
                    public void onNext(MoiveListResponse moiveListResponse) {
                        if(moiveListResponse != null) {
                            getView().onLoadSucess(moiveListResponse);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        getView().onLoadFail(t.getMessage());
                    }
                });
    }

    @Override
    public void onDestroyPersenter() {
        super.onDestroyPersenter();
    }
}
