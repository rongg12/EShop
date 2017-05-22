package com.eshop.utils;

import com.eshop.entity.CategoryRsp;
import com.google.gson.Gson;

import org.junit.Test;

import okhttp3.Call;
import okhttp3.Response;

import static org.junit.Assert.*;

/**
 * 单元测试
 * Created by Administrator on 2017/5/22.
 */
public class EShopClientTest {
    @Test
    public void getInstance() throws Exception {

    }

    @Test
    public void getCategory() throws Exception {
        Call call = EShopClient.getInstance().getCategory();
        Response response = call.execute();
        String json = response.body().string();
        //解析
        CategoryRsp categoryRsp = new Gson().fromJson(json, CategoryRsp.class);
        //怎么去验证数据是不是正确的
        //断言类：断言方法，主要是为我们做一个判断
        assertTrue(categoryRsp.getStatus().isSucceed());
    }

}