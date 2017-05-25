package com.eshop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.style.UpdateLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.eshop.R;
import com.eshop.adapter.CategoryAdapter;
import com.eshop.adapter.ChildrenAdapter;
import com.eshop.entity.CategoryBase;
import com.eshop.entity.CategoryPrimary;
import com.eshop.entity.CategoryRsp;
import com.eshop.utils.EShopClient;
import com.eshop.utils.UICallBack;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 分类的界面
 * Created by Administrator on 2017/5/23.
 */

public class CategoryFragment extends BaseFragment {
    @BindView(R.id.standard_toolbar_title)
    TextView mTvToolBarTitle;
    @BindView(R.id.standard_toolbar)
    Toolbar mToolBar;
    @BindView(R.id.list_category)
    ListView mListCategory;
    @BindView(R.id.list_children)
    ListView mListChildren;
    private List<CategoryPrimary> mData;
    private CategoryAdapter mCategoryAdapter;
    private ChildrenAdapter mChildrenAdapter;

    public static CategoryFragment newInstance(){
        return new CategoryFragment();
    }

    //布局填充
    @Override
    protected int getContentViewLayout() {
        return R.layout.fragment_category;
    }

    //视图的初始化
    protected void initView() {
        //toolbar的处理
        initToolBar();
        //ListView设置适配器
        mCategoryAdapter = new CategoryAdapter();
        mListCategory.setAdapter(mCategoryAdapter);
        mChildrenAdapter = new ChildrenAdapter();
        mListChildren.setAdapter(mChildrenAdapter);
        //去拿数据
        if (mData!=null){
            //直接去更新UI
            UpdateCategory();
        }else{
            //去进行网络请求数据
            Call call = EShopClient.getInstance().getCategory();
            call.enqueue(new UICallBack() {
                //请求失败
                @Override
                public void onFailureInUI(Call call, IOException e) {
                    Toast.makeText(getContext(), "请求失败"+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                //请求成功
                @Override
                public void onResponseInUI(Call call, Response response) {
                    if (response.isSuccessful()){
                        try {
                            CategoryRsp categoryRsp = new Gson().fromJson(response.body().string(), CategoryRsp.class);
                            //是不是成功返回数据了
                            if (categoryRsp.getStatus().isSucceed()){
                                mData = categoryRsp.getData();
                                Log.e("aaa", "onResponseInUI: "+mData);
                                /**
                                 * 数据有了之后更新UI，拿到的data是一级分类里面的信息，
                                 *    一级里面又包括二级分类的信息
                                 *  数据先给一级分类，默认选择一级分类的第一条，二级分类的数据才能展示
                                 */
                                 UpdateCategory();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    /**
     * 更新数据分类，数据的填充
     */
    private void UpdateCategory() {
        mCategoryAdapter.reset(mData);
        //切换展示二级界面
        chooseCategory(0);
    }

    /**
     * 根据一级分类的某一项展示二级分类
     * @param position
     */
    private void chooseCategory(int position) {
        mListCategory.setItemChecked(position,true);
        //填充二级分类
        mChildrenAdapter.reset(mCategoryAdapter.getItem(position).getChildren());
    }
    //点击一级界面的Item，切换展示二级分类的信息
    @OnItemClick(R.id.list_category)
    public void OnItemClick(int position){
        chooseCategory(position);
    }
    //点击二级分类的Item，跳转页面
    @OnItemClick(R.id.list_children)
    public void onChildrenClick(int position){
        // TODO: 2017/5/23 跳转到搜索的页面 
        Toast.makeText(getContext(), mChildrenAdapter.getItem(position).getName(), Toast.LENGTH_SHORT).show();
    }


    //toolBar的处理
    private void initToolBar() {
        //让Fragment显示出来选项菜单
        setHasOptionsMenu(true);
        //让toolbar作为ActionBar展示
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(mToolBar);
        //处理不让ActionBar展示默认的标题
        activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
        /**
         * 展示左上方的返回箭头：ActionBar已经提供好了一个方法，可以直接展示，
         *    返回箭头的id，默认是 android.id.home  返回箭头是作为选项菜单去处理的
         *    处理返回箭头的事件需要在onOptionsItemSelected()去完成
         */
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //设置文本
        mTvToolBarTitle.setText(R.string.category_title);
    }
    /**
     * 处理搜索图标的展示，作为ActionBar的一个选项菜单
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_category,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //点击的是返回箭头
        if (id==android.R.id.home){
            getActivity().onBackPressed();
            return true;
        }
        //点击搜索图片的事件
        if (id==R.id.menu_search){
            // TODO: 2017/5/23 跳转到搜索页面 
            Toast.makeText(getContext(), "点击了搜索图标", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
