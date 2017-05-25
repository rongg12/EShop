package com.eshop.adapter;

import android.icu.util.ULocale;
import android.view.View;
import android.widget.TextView;

import com.eshop.R;
import com.eshop.entity.CategoryPrimary;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/5/24.
 */

public class CategoryAdapter extends BaseListAdapter<CategoryPrimary,CategoryAdapter.ViewHolder> {
    //
    @Override
    protected int getItemViewLayout() {
        return R.layout.item_primary_category;
    }

    @Override
    protected ViewHolder getItemViewHolder(View view) {
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
