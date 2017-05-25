package com.eshop.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.eshop.R;
import com.eshop.entity.CategoryBase;
import com.eshop.entity.CategoryPrimary;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 子分类的适配器
 * Created by Administrator on 2017/5/23.
 */

public class ChildrenAdapter extends BaseListAdapter<CategoryBase,ChildrenAdapter.ViewHolder>{
    //Item的布局
    @Override
    protected int getItemViewLayout() {
        return R.layout.item_children_category;
    }
    //子类具体的ViewHolder
    @Override
    protected ChildrenAdapter.ViewHolder getItemViewHolder(View view) {
        return new ViewHolder(view);
    }

     class ViewHolder extends BaseListAdapter.ViewHolder{
        @BindView(R.id.text_category)
        TextView mTvCategory;

         public ViewHolder(View itemView) {
             super(itemView);
         }

         //数据的绑定
        @Override
        protected void bind(int position) {
           mTvCategory.setText(getItem(position).getName());
        }
    }
}
