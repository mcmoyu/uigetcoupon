package com.moyu.uigetcoupon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.moyu.uigetcoupon.tools.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RadioGroup mRg_main; // 导航栏
    private LinearLayout home_Hs; // Hs卡片
    private List<View> mView;
    private int position = 0;
    private LinearLayout linearLayout;
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StatusBarUtil.setTransparent(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.lay_content);
        inflater = LayoutInflater.from(this);

        initView(); // 初始化View
        initLinearLayout(); // 初始化LinearLayout
        setListener(); // 设置RadioGroup的监听

        LinearLayout l = findViewById(R.id.lay_root);
        mView.get(4).setLayoutParams(new LinearLayout.LayoutParams(getWindowManager().getDefaultDisplay().getWidth(), StatusBarUtil.checkDeviceHasNavigationBar(this) ? StatusBarUtil.getNavigationBarHeight(this) : 0));
        l.addView(mView.get(4));
    }

    private void setListener() {
        mRg_main.setOnCheckedChangeListener(new MyOnCheckedChangeListener()); // 设置监听事件
        mRg_main.check(R.id.rb_home); // 设置默认选中首页
    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rb_home:// 首页
                    position = 0;
                    break;
                case R.id.rb_class:// 分类
                    position = 1;
                    break;
                case R.id.rb_user:// 我的
                    position = 2;
                    break;
            }
            turnLayout(mView.get(position));
        }
    }
    /**
     *
     * @param to 马上要切换到的LinearLayout，一会要显示
     */
    @SuppressLint("ResourceType")
    private void turnLayout(View to) {
        linearLayout.removeAllViews();
        switch (position) {
            case 0:
                WindowManager manager = this.getWindowManager();
                DisplayMetrics outMetrics = new DisplayMetrics();
                manager.getDefaultDisplay().getMetrics(outMetrics);
                int width = outMetrics.widthPixels;
//                int height = outMetrics.heightPixels;
                mView.get(3).setLayoutParams(new LinearLayout.LayoutParams(width, StatusBarUtil.getStatusBarHeight(this)));
                linearLayout.addView(mView.get(3));
                break;
            case 1:

                break;
            case 2:

                break;
        }
        linearLayout.addView(to);
    }

    private void initLinearLayout() {
        mView = new ArrayList<>();
        mView.add(inflater.inflate(R.layout.activity_home, null)); // 首页
        mView.add(inflater.inflate(R.layout.activity_class, null)); // 分类
        mView.add(inflater.inflate(R.layout.activity_user, null)); // 我的
        mView.add(inflater.inflate(R.layout.home_status_bar, null)); // 首页_状态栏
        mView.add(inflater.inflate(R.layout.navigation_bar, null)); // 底部_导航栏
    }

    private void initView() {
        mRg_main = findViewById(R.id.rg_main);
//        home_Hs = findViewById(R.id.home_hs);
    }
}
