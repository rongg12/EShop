package com.eshop.utils;

/**
 * Created by Administrator on 2017/5/22.
 */

public class Costants {
    //接口基础URL
    public static final String BASE_URL="http://106.14.32.204/eshop/emobile/?url=";
    //品牌LOGO图片基础URL
    public static final String IMAGE_BASE_URL="http://106.14.32.204/eshop/data/brandlogo/";
    //首页的轮播图(首页主广告)和促销商品
    public static final String HOME_DATA_URL=BASE_URL+"/home/data";
    //商品的一级分类和推荐
    public static final String HOME_CATEGORY_URL=BASE_URL+"/home/category";
    //搜索商品
    public static final String SEARCH_URL=BASE_URL+"/search";
    //获取分类
    public static final String CATEGORY_URL=BASE_URL+"/category";
    //获取品牌
    public static final String BRAND_URL=BASE_URL+"/brand";
    //获取价格区间
    public static final String PRICE_URL=BASE_URL+"/price_range";
    //商品详情
    public static final String GOODS_URL=BASE_URL+"/goods";
    //商品描述
    public static final String DESC_URL=BASE_URL+"/goods/desc";
    //收藏商品
    public static final String COLLECT_URL=BASE_URL+"/user/collect/create";
    //取消收藏商品
    public static final String COLLECT_DELETE_URL=BASE_URL+"/user/collect/delete";
    //获取收藏列表
    public static final String COLLECT_LIST_URL=BASE_URL+"/user/collect/list";
    //用户登陆
    public static final String SIGNIN_URL=BASE_URL+"/user/signin";
    //获取注册字段
    public static final String SIGNUPFIELDS_URL=BASE_URL+"/user/signupFields";
    //用户注册
    public static final String SIGNUP_LIST_URL=BASE_URL+"/user/signup";

}
