package com.yuguo.mydoctor.index;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yuguo.mydoctor.R;
import com.yuguo.mydoctor.index.adapter.IndexAdapter;

import java.util.ArrayList;

public class IndexFragment extends Fragment{

    private Context mContext;
    private View rootView;
    private PullToRefreshListView listView;
    private IndexAdapter indexAdapter;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

        mContext = getActivity();
		return rootView = inflater.inflate(R.layout.activity_index_fragment, container, false);
	}

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        intView();
    }

    private void intView(){
        listView = (PullToRefreshListView)rootView.findViewById(R.id.listview);
        listView.setMode(PullToRefreshBase.Mode.BOTH);
        ArrayList<String> mList = new ArrayList<String>();
        mList.add("1");
        mList.add("12");
        mList.add("13");
        mList.add("14");
        mList.add("15");
        mList.add("16");
        mList.add("1s");
        mList.add("123");
        mList.add("132");
        mList.add("134");
        mList.add("154");
        mList.add("165");
        mList.add("16");
        mList.add("127");
        mList.add("138");
        mList.add("149");
        mList.add("150");
        mList.add("1643");
        indexAdapter = new IndexAdapter(mContext,mList);
        listView.setAdapter(indexAdapter);
    }
}
