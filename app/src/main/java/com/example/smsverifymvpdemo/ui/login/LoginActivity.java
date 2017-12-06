package com.example.smsverifymvpdemo.ui.login;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.smsverifymvpdemo.R;
import com.example.smsverifymvpdemo.base.BaseActivity;
import com.example.smsverifymvpdemo.model.engine.SmsTextWatcher;
import com.example.smsverifymvpdemo.utils.ToastUtil;

/**
 * Created by 亮亮 on 2017/12/6.
 */

public class LoginActivity extends BaseActivity implements LoginContract.LoginView {
    public EditText phone;
    public EditText sms;
    public TextView sendsms;
    public Button login;
    //声明presenter
    LoginContract.Presenter loginPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        //请求验证码
        requestSms();
    }
    private void requestSms() {
        loginPresenter.requestVerifyCode();

    }


    //本身已经被调用过了
    @Override
    public void setPresenter() {
        loginPresenter=new LoginPresenter(this);
    }

    private void initView() {
        sendsms = findViewById(R.id.sendsms);
        sms = findViewById(R.id.sms);
        phone = findViewById(R.id.phone);
        login = findViewById(R.id.login);
    }

    @Override
    public void setLoginButtonEnable(boolean value) {
        //设置登录按钮可用并且颜色变成红色
        if (value) {
            login.setBackgroundColor(Color.RED);
        } else {
            login.setBackgroundColor(Color.YELLOW);
        }

    }

    @Override
    public void showVerifyError() {
        //提示验证码校验失败
        ToastUtil.show(this, R.string.verifycode_error);

    }

    @Override
    public void showVerifySuccess() {
        //提示校验成功，可以登录了
        ToastUtil.show(this, R.string.verifycode_success);


    }

    @Override
    public void showPhoneNumEmpty() {
        //手机号为空时 点击发送验证码的界面
        ToastUtil.show(this, R.string.phonenum_empty);


    }

    @Override
    public void showPhoneNumError() {
        //手机验证码错误
        ToastUtil.show(this, R.string.phonenum_error);

    }

    @Override
    public void listenSmsEditTextStatus() {
        sms.addTextChangedListener(new SmsTextWatcher(new SmsTextWatcher.OnSmsComplete() {
            @Override
            public void onComplete() {
                //让点击登录的按钮可用
                setLoginButtonEnable(true);
            }

            @Override
            public void onEdit() {
                setLoginButtonEnable(false);
            }
        }));

    }
}
