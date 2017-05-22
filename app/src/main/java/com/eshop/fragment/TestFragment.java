package com.eshop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.eshop.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 *
 * Created by Administrator on 2017/5/19.
 */

public class TestFragment extends Fragment {
    public static final String ARGUMENTS_TEXT="fragment";
    @BindView(R.id.text)
    TextView mTv;

    //不建议在构造方法中传递数据，官方推荐的方式是采用setArgument()的方法传递数据
    public static TestFragment newInstance(String text){
        TestFragment testFragment=new TestFragment();
        Bundle bundle=new Bundle();  //传递数据
        bundle.putString(ARGUMENTS_TEXT,text);
        testFragment.setArguments(bundle);
        return testFragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        ButterKnife.bind(this,view);
        //切换不同的Fragment,展示不同文本
        mTv.setText(getArgumentsText());
        return view;
    }

    /**
     * 拿到传递的数据
     * @return
     */
    public String getArgumentsText(){
        return getArguments().getString(ARGUMENTS_TEXT);
    }


}
