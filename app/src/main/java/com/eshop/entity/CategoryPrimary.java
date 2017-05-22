package com.eshop.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.List;

/**
 * 商品一级分类.
 */
public class CategoryPrimary extends CategoryBase {

    @SerializedName("children")
    private List<CategoryBase> mChildren;

    public List<CategoryBase> getChildren() {
        return mChildren;
    }
}
