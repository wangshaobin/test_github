package com.yuguo.mydoctor.index.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yuguo.mydoctor.R;

import java.util.ArrayList;

/**
 * Created by wangshaobin on 2015/3/31.
 */
public class IndexAdapter extends BaseAdapter{

    private Context mContext;
    private ArrayList<String> mIndexList;

    public IndexAdapter(Context context,ArrayList<String> indexlist){
        this.mContext = context;
        this.mIndexList = indexlist;
    }
    @Override
    public int getCount() {
        return mIndexList.size();
    }

    @Override
    public Object getItem(int i) {
        return mIndexList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.activity_item,null);

            viewHolder.textView = (TextView)convertView.findViewById(R.id.item_id);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.textView.setText(mIndexList.get(position));

        return convertView;
    }

    class ViewHolder{
        TextView textView;
    }
}
