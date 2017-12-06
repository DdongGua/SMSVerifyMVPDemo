package com.example.smsverifymvpdemo.base;

import com.example.smsverifymvpdemo.ui.login.LoginContract;
import com.example.smsverifymvpdemo.utils.NetWorkUtil;

/**
 * Created by 亮亮 on 2017/12/6.
 */



public class BasePresenterImpl implements BasePresenter {
    BaseView baseView;
    BaseActivity baseActivity;

    public BasePresenterImpl(BaseView baseView) {
        this.baseView = baseView;
        //一初始化presenter的时候就检查网络
        checkNetWorkStatus();
    }

    @Override
    public void checkNetWorkStatus() {
        baseActivity=(BaseActivity)baseView;
        int i = NetWorkUtil.checkNetWorkStatus(baseActivity);
        switch (i){
            case 0:
                //表示没有网
                baseActivity.noNetWork();
                break;
            case 1:
                //表示wifi
                break;
            default:
                //默认是移动网

                break;

        }



    }
}
