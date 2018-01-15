package com.xfwlkjyxgs.sober.poa.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2018/1/15.
 * 你能我就能****
 */
public class BaseRecyclerHolder  extends RecyclerView.ViewHolder{
    private SparseArray<View> views;
    private Context context;


    public BaseRecyclerHolder(View itemView,Context context) {
        super(itemView);
        this.context=context;
        views=new SparseArray<>(8);
    }

    /**
     * 获取一个BaseRecyclerview对象
     * @param context
     * @param itemView
     * @return
     */
    public   static  BaseRecyclerHolder  getRecyclerHolder(Context context,View itemView){
        return  new BaseRecyclerHolder(itemView,context);
    }
    /**
     * 得到views
     * @return
     */
    public SparseArray<View> getViews() {
        return this.views;
    }
    /**
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View>T  getView(int viewId){
        View  view=views.get(viewId);
        if (view==null){
            view=itemView.findViewById(viewId);
            views.put(viewId,view);
        }
        return (T) view;
    }


    /**
     * 设置字符串
     */
    public  BaseRecyclerHolder  setText(int viewId,String text){
        TextView tv=getView(viewId);
        tv.setText(text);
        return  this;
    }

    /**
     * 设置图片
     */
    public BaseRecyclerHolder setImageResource(int viewId,int drawableId){
        ImageView iv = getView(viewId);
        iv.setImageResource(drawableId);
        return this;
    }
    /**
     * 设置图片
     */
    public BaseRecyclerHolder setImageByUrl(int viewId, String url){
        Glide.with(context).load(url).into((ImageView) getView(viewId));
        return this;
    }



}
