package com.xfwlkjyxgs.sober.poa.base;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2017/11/21.
 * 你能我就能****
 */
public abstract  class BaseFragment extends Fragment{
    public Context mContext;
    protected View mRootView;
    private static final String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";
    /**
     * 是否为可见状态
     */
    protected boolean isVisible;
    /**
     * 是否初始视图完成
     */
    private   boolean isPrepared;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();

        if (savedInstanceState!=null){
            boolean isSupportHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN);
            FragmentTransaction ft = getFragmentManager().beginTransaction();

            if (isSupportHidden) {
                ft.hide(this);
            } else {
                ft.show(this);
            }
            ft.commit();
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = bindLayout(inflater);
        initView();
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //这里 初始化view的各控件 数据
        isPrepared = true;
        lazyLoad();
    }

    /**
     * setUserVisibleHint是在onCreateView之前调用的
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {

        super.setUserVisibleHint(isVisibleToUser);

        /**
         * 判断是否可见
         */
        if(getUserVisibleHint()) {

            isVisible = true;
            //执行可见方法-初始化数据之类
            onVisible();

        } else {

            isVisible = false;
            //不可见
            onInvisible();
        }
    }


    /**
     * 可见做懒加载
     */
    private void onVisible() {
        lazyLoad();
    }

    /**
     * 懒加载
     */
    private void lazyLoad() {
        /**
         * 判断是否可见，或者 初始化view的各控件
         */
        if(!isVisible || !isPrepared) {
            return;
        }
        //可见 或者 控件初始化完成 就 加载数据
        initData();
    }

    /**
     * 不可见-做一些销毁工作
     */
    protected void onInvisible() {


    }

    /**
     * 绑定布局
     *
     * @param inflater
     * @return
     */
    public abstract View bindLayout(LayoutInflater inflater);

    /**
     * 初始化布局
     */
    public abstract void initView();


    /**
     * 初始化数据
     */
    protected abstract void initData();

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden());
    }

}
