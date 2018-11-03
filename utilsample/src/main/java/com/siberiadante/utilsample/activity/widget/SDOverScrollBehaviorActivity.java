package com.siberiadante.utilsample.activity.widget;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.siberiadante.androidutil.adapter.BaseTabLayoutAdapter;
import com.siberiadante.androidutil.util.SDLogUtil;
import com.siberiadante.androidutil.util.SDStatusBarUtil;
import com.siberiadante.androidutil.util.SDTransitionUtil;
import com.siberiadante.androidutil.widget.imageview.SDCircleImageView;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.SampleUtils;
import com.siberiadante.utilsample.activity.base.BaseActivity;
import com.siberiadante.utilsample.fragment.DocumentFragment;
import com.siberiadante.utilsample.fragment.SDUtilFragment;
import com.siberiadante.utilsample.fragment.SDViewFragment;
import com.siberiadante.utilsample.fragment.SDWidgetFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class SDOverScrollBehaviorActivity extends BaseActivity {


    public static final String TAG = SDOverScrollBehaviorActivity.class.getSimpleName();
    @BindView(R.id.iv_header)
    ImageView ivHeader;
    @BindView(R.id.user_head_container)
    RelativeLayout userHeadContainer;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar_layout)
    AppBarLayout appbarLayout;
    @BindView(R.id.magic_indicator)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.container)
    CoordinatorLayout container;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.toolbar_avatar)
    SDCircleImageView toolbarAvatar;
    @BindView(R.id.toolbar_username)
    TextView toolbarUsername;
    @BindView(R.id.buttonBarLayout)
    ButtonBarLayout buttonBarLayout;
    @BindView(R.id.iv_menu)
    ImageView ivMenu;
    @BindView(R.id.title_layout)
    LinearLayout titleLayout;
    private int mScrollY = 0;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdover_scroll_behavior;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        SampleUtils.immersive(this);
        SampleUtils.setPaddingSmart(this, toolbar);
        appbarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            int lastScrollY = 0;
            int h = SDTransitionUtil.dp2px(170);
            int color = ContextCompat.getColor(getApplicationContext(), R.color.colorWhite) & 0x00ffffff;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                SDLogUtil.d(TAG, "---:" + verticalOffset + "#####:" + Math.abs(verticalOffset) + "----h----" + h);
                int scrollY = Math.abs(verticalOffset);
                if (lastScrollY < h) {
                    SDLogUtil.d(TAG, "--------lastScrollY < h-------");
                    scrollY = Math.min(h, scrollY);
                    mScrollY = scrollY > h ? h : scrollY;
                    buttonBarLayout.setAlpha(1f * mScrollY / h);
                    toolbar.setBackgroundColor(((255 * mScrollY / h) << 24) | color);
                }
                if (scrollY == 0) {
                    ivBack.setImageResource(R.drawable.back_white);
                    ivMenu.setImageResource(R.drawable.icon_menu_white);
                } else {
                    ivBack.setImageResource(R.drawable.back_black);
                    ivMenu.setImageResource(R.drawable.icon_menu_black);
                }
                lastScrollY = scrollY;
            }
        });
        buttonBarLayout.setAlpha(0);
        int statusBarHeight = SDStatusBarUtil.getStatusBarHeight();
        CollapsingToolbarLayout.LayoutParams titleLayoutLayoutParams = (CollapsingToolbarLayout.LayoutParams) titleLayout.getLayoutParams();
        titleLayoutLayoutParams.topMargin = statusBarHeight;
        titleLayout.setLayoutParams(titleLayoutLayoutParams);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void initData() {
        super.initData();
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(SDUtilFragment.getInstance());
        fragments.add(SDViewFragment.getInstance());
        fragments.add(SDWidgetFragment.getInstance());
        fragments.add(DocumentFragment.getInstance());
        String[] titles = new String[]{"Utils", "Views", "Widgets", "Others"};

        viewPager.setAdapter(new BaseTabLayoutAdapter(getSupportFragmentManager(), fragments,titles));
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(4);
        mTabLayout.setupWithViewPager(viewPager);
    }


}
