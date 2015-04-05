package com.yuguo.mydoctor.main.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;

import com.yuguo.mydoctor.R;
import com.yuguo.mydoctor.index.IndexFragment;
import com.yuguo.mydoctor.order.ui.OrderFragment;
import com.yuguo.mydoctor.sickness.ui.SicknessFragment;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private static FragmentManager fragmentManager;

    private RadioButton indexButton;
    private RadioButton orderButton;
    private RadioButton sicknessButton;
    private RadioButton serverButton;
    private RadioButton mineButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        getWindow().setBackgroundDrawable(null);

        //获取FragmentManager实例
        fragmentManager = getSupportFragmentManager();
        initFragment();
        initBottomButtons();
    }

    /**
     * 初始化首个Fragment
     */
    private void initFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        IndexFragment indexFragment = new IndexFragment();
        fragmentTransaction.add(R.id.fragmentRoot, indexFragment, "indexFragment");
        fragmentTransaction.addToBackStack("indexFragment");
        fragmentTransaction.commit();
    }
    /**
     * 处理底部点击事件
     */
    private void initBottomButtons() {

        indexButton = (RadioButton)findViewById(R.id.index_id);
        orderButton = (RadioButton)findViewById(R.id.order_id);
        sicknessButton = (RadioButton)findViewById(R.id.sickness_id);
        serverButton = (RadioButton)findViewById(R.id.server_id);
        mineButton = (RadioButton)findViewById(R.id.mine_id);

        indexButton.setOnClickListener(this);
        orderButton.setOnClickListener(this);
        sicknessButton.setOnClickListener(this);
        serverButton.setOnClickListener(this);
        mineButton.setOnClickListener(this);
    }

    /**
     * 从back stack弹出所有的fragment，保留首页的那个
     */
    public static void saveFirstFragment() {
        for (int i = 0, count = fragmentManager.getBackStackEntryCount() - 1; i < count; i++) {
            fragmentManager.popBackStack();
        }
    }
    //点击返回按钮
    @Override
    public void onBackPressed() {
        if(fragmentManager.findFragmentByTag("indexFragment")!=null && fragmentManager.findFragmentByTag("indexFragment").isVisible()) {
            MainActivity.this.finish();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View view) {

        FragmentTransaction ft = fragmentManager.beginTransaction();

        switch (view.getId()){
            case R.id.index_id:
                if(fragmentManager.findFragmentByTag("indexFragment")!=null && fragmentManager.findFragmentByTag("indexFragment").isVisible()) {
                    return;
                }
                saveFirstFragment();
                break;
            case R.id.order_id:
                saveFirstFragment();
                ft.hide(fragmentManager.findFragmentByTag("indexFragment"));
                OrderFragment orderFragment = new OrderFragment();
                ft.add(R.id.fragmentRoot, orderFragment, "sicknessFragment");
                ft.addToBackStack("sicknessFragment");
                ft.commit();
                break;
            case R.id.sickness_id:
                saveFirstFragment();
                ft.hide(fragmentManager.findFragmentByTag("indexFragment"));
                SicknessFragment sicknessFragment = new SicknessFragment();
                ft.add(R.id.fragmentRoot, sicknessFragment, "sicknessFragment");
                ft.addToBackStack("sicknessFragment");
                ft.commit();
                break;
            case R.id.server_id:
                saveFirstFragment();
                ft.hide(fragmentManager.findFragmentByTag("indexFragment"));
                ServerFragment serverFragment = new ServerFragment();
                ft.add(R.id.fragmentRoot, serverFragment, "ServerFragment");
                ft.addToBackStack("ServerFragment");
                ft.commit();
                break;
            case R.id.mine_id:
                saveFirstFragment();
                ft.hide(fragmentManager.findFragmentByTag("indexFragment"));
                MineFragment mineFragment = new MineFragment();
                ft.add(R.id.fragmentRoot, mineFragment, "MeFragment");
                ft.addToBackStack("MeFragment");
                ft.commit();
                break;
        }
    }
}