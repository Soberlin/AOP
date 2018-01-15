package com.xfwlkjyxgs.sober.poa.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2017/12/18.
 * 你能我就能****
 */

/**
 * recyclerView  可以自己定义下划线
 * @param <T>
 */


public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseRecyclerHolder> {
    private Context context;
    /**
     * 数据源
     */
    private List<T> list;
    /**
     * 布局器
     */
    private LayoutInflater inflater;
    /**
     * 布局id
     */
    private int itemLayoutId;
    /**
     * 是否在滚动
     */
    private boolean isScrolling;

    private RecyclerView recyclerView;

    /**
     * 点击事件监听器
     */
    private OnItemClickListener onItemClicklistener;

    /**
     * 长按事件监听器
     */
    private OnItemLongClickListener onItemLongClickListener;


    /**
     * 在recyclerView提供数据的时候调用
     *
     * @param recyclerView
     */
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }

    /**
     * 点击事件
     */
    public interface OnItemClickListener {
        void onItemClick(RecyclerView parent, View view, int poisition);
    }

    /**
     * 长按事件
     */
    public interface OnItemLongClickListener {
        void onItemLongClick(RecyclerView parent, View view, int poisiton);
    }

    public void setonItemClicklistener(OnItemClickListener listener) {
        this.onItemClicklistener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    /**
     * 插入一项
     *
     * @param item
     * @param poisiton
     */
    public void insert(T item, int poisiton) {
        list.add(poisiton, item);
    }

    /**
     * 删除一项
     *
     * @param poisiton
     */
    public void delete(int poisiton) {
        list.remove(poisiton);
        notifyItemChanged(poisiton);
    }


    /**
     * 构造函数
     *
     * @param context
     * @param list
     * @param itemLayoutId
     */
    public BaseRecyclerViewAdapter(Context context, List<T> list, int itemLayoutId) {
        this.context = context;
        this.list = list;
        this.itemLayoutId = itemLayoutId;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public BaseRecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(itemLayoutId, parent, false);
        return BaseRecyclerHolder.getRecyclerHolder(context, view);
    }

    @Override
    public void onBindViewHolder(BaseRecyclerHolder holder, int position) {

        /**
         * 单击事件
         */
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClicklistener != null && view != null && recyclerView != null) {
                    final int poisiton = recyclerView.getChildAdapterPosition(view);
                    onItemClicklistener.onItemClick(recyclerView, view, poisiton);

                }

            }
        });
        /**
         * 长按事件
         */
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onItemLongClickListener != null && v != null&&recyclerView!=null){
                 final int poisiton=recyclerView.getChildAdapterPosition(v);
                 onItemLongClickListener.onItemLongClick(recyclerView,v,poisiton);
                 return  true;
                }
                return false;
            }
        });
        convert(holder,list.get(position),isScrolling);
    }


    /**
     * 子类需要重写
     * @param holder
     * @param  item
     * @param isScrolling
     */
    public  abstract void convert(BaseRecyclerHolder holder, T item, boolean isScrolling);

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }




}
