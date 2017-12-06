package com.example.smsverifymvpdemo.bean;

/**
 * Created by 亮亮 on 2017/12/6.
 */

public class BaseBean<T> {

    /**
     * code : 200
     * obj : {"phone":"13461321475","sms":"0325"}
     */

    private int code;
    private T obj;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

}
