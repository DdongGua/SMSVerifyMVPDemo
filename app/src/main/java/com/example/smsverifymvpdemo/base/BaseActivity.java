package com.example.smsverifymvpdemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.smsverifymvpdemo.R;
import com.example.smsverifymvpdemo.utils.ToastUtil;

/**
 * Created by 亮亮 on 2017/12/6.
 */



public abstract class BaseActivity extends Activity implements BaseView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter();
    }

    //强制让子类去设置presenter
    public  abstract  void  setPresenter();


    public void noNetWork() {
        ToastUtil.show(this, R.string.nonetwork);
    }
}

