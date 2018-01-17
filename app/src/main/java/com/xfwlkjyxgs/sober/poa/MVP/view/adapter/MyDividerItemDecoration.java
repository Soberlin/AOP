package com.xfwlkjyxgs.sober.poa.MVP.view.adapter;

/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2018/1/17.
 * 你能我就能****
 */
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * 为RecyclerView添加分割线
 */
public class MyDividerItemDecoration extends RecyclerView.ItemDecoration{
    private  static  final  int[] attrs=new int[]{android.R.attr.listDivider};
    public static final int HORIZONTAL_LIST= LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LIST=LinearLayoutManager.VERTICAL;
    private  int  mOrientaion;
    private Drawable mDriver;
    /**
     * 默认2px
     */
    private  int  mDriverHeight=2;
    private Paint mpaint;
    /**
     * 添加分割线
     */
    /*mMain_recyclerview.addItemDecoration(new MyDividerItemDecoration(this, MyDividerItemDecoration.VERTICAL_LIST));*/
    /**
     * 默认分割线
     * @param context
     * @param orientaion
     */
    public MyDividerItemDecoration(Context context,int orientaion) {
        final   TypedArray typedArray =  context.obtainStyledAttributes(attrs);
        mDriver=typedArray.getDrawable(0);
        typedArray.recycle();
        setOrientaion(orientaion);
    }
    /**
     * 自定义分割线
     * @param context
     * @param orientaion  列表方向
     * @param drawableId  分割线图片
     */
    public MyDividerItemDecoration(Context context,int orientaion,int drawableId) {
        this(context, orientaion);
        mDriver= ContextCompat.getDrawable(context,drawableId);
        mDriverHeight=mDriver.getIntrinsicHeight();
    }

    /**
     *自定义分割线
     * @param context
     * @param orientaion  列表方向
     * @param dividerHeight 分割线高度
     * @param dividerColor  分割线颜色
     */
    public MyDividerItemDecoration(Context context,int orientaion, int dividerHeight,int dividerColor) {
        this(context, orientaion);
        mDriverHeight=dividerHeight;
        mpaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mpaint.setColor(dividerColor);
        mpaint.setStyle(Paint.Style.FILL);
    }

    /**
     * 设置分割线的方向
     * @param orientaion
     */
    private void setOrientaion(int orientaion)
    {
      if (orientaion!=HORIZONTAL_LIST&&orientaion!=VERTICAL_LIST)
      {
          throw  new IllegalArgumentException("invalid orientaion");
       }
        mOrientaion=orientaion;
    }


    @Override
    public void onDraw(Canvas c, RecyclerView parent) {


    }


}
