package com.whenhi.hi.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.TextView;

import com.aspsine.fragmentnavigator.FragmentNavigator;
import com.whenhi.hi.Constants;
import com.whenhi.hi.R;
import com.whenhi.hi.fragment.OtherFragmentAdapter;

public class CraftActivity extends BaseActivity{

    private static final String TAG =CraftActivity.class.getSimpleName();

    private FragmentNavigator mFragmentNavigator;
    private  Toolbar mToolbar;
    private TextView mTextView;
    private ActionBar mActionBar;
    private OtherFragmentAdapter mOtherFragmentAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_craft);

        mToolbar = (Toolbar) findViewById(R.id.toolbar).findViewById(R.id.toolbar);
        mTextView = (TextView) findViewById(R.id.toolbar).findViewById(R.id.toolbar_title);
        mTextView.setText("时光穿梭");
        setSupportActionBar(mToolbar);


        initView(savedInstanceState);

    }

    private void initView(Bundle savedInstanceState){
        mOtherFragmentAdapter = new OtherFragmentAdapter();
        mFragmentNavigator = new FragmentNavigator(getSupportFragmentManager(), mOtherFragmentAdapter, R.id.fragment_other_craft_container);
        mFragmentNavigator.onCreate(savedInstanceState);
        setDefaultFrag();
    }


    /*设置默认Fragment*/
    private void setDefaultFrag() {
        mFragmentNavigator.showFragment(Constants.OTHER_CRAFT);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFragmentNavigator = null;
        mToolbar = null;
        mTextView = null;
        mActionBar = null;
        mOtherFragmentAdapter.destroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}




