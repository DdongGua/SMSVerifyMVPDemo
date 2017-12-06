package com.example.smsverifymvpdemo;

import com.example.smsverifymvpdemo.http.OkHttpUtil;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by 亮亮 on 2017/11/30.
 */

public class TestMethod {
    @Test
    public void connectMethod() throws Exception {
        String newUrl = OkHttpUtil.getInstance().getNewUrl("http://hahhahha/", null);
        assertEquals(newUrl);
    }

    private void assertEquals(String newUrl) {
    }
}
