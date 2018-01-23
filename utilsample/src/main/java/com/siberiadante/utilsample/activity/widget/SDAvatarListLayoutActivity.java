package com.siberiadante.utilsample.activity.widget;

import android.os.Bundle;
import android.view.View;

import com.siberiadante.androidutil.widget.horizontalscroll.SDAvatarListLayout;
import com.siberiadante.androidutil.widget.imageview.SDCircleImageView;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class SDAvatarListLayoutActivity extends BaseActivity {
    @BindView(R.id.avatar_layout1)
    SDAvatarListLayout avatarLayout1;
    @BindView(R.id.avatar_layout2)
    SDAvatarListLayout avatarLayout2;
    @BindView(R.id.avatar_layout3)
    SDAvatarListLayout avatarLayout3;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdavatar_list_layout;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        final List<Integer> imageDatas = new ArrayList<>();
        imageDatas.add(R.drawable.ic_launcher_background);
        imageDatas.add(R.drawable.meinv);
        imageDatas.add(R.drawable.meinv);
        imageDatas.add(R.drawable.meinv);
        //加载本地资源
        avatarLayout1.setAvatarListListener(imageDatas);
        //顺序加载图片使用任意框架加载
        avatarLayout2.setAvatarListListener(new SDAvatarListLayout.ShowAvatarListener() {
            @Override
            public void showImageView(List<SDCircleImageView> imageViewList) {
                //创建的ImageView的数量
                int imageSize = imageViewList.size();
                //实际需要显示的图片的数量
                int realDataSize = imageDatas.size();
                int mul = imageSize - realDataSize;
                for (int i = 0; i < imageSize; i++) {
                    if (i >= mul) {//6
                        //可以替换为网络图片处理
                        imageViewList.get(i).setImageResource(imageDatas.get(realDataSize - (i - mul) - 1));
                        imageViewList.get(i).setVisibility(View.VISIBLE);
                    } else {
                        imageViewList.get(i).setVisibility(View.GONE);
                    }
                }
            }
        });
        //逆序加载图片使用任意框架加载
        avatarLayout3.setAvatarListListener(new SDAvatarListLayout.ShowAvatarListener() {
            @Override
            public void showImageView(List<SDCircleImageView> imageViewList) {
                //创建的ImageView的数量
                int imageSize = imageViewList.size();
                //实际需要显示的图片的数量
                int realDataSize = imageDatas.size();
                int mul = imageSize - realDataSize;
                for (int i = 0; i < imageSize; i++) {
                    if (i >= mul) {//6
                        //可以替换为网络图片处理
                        imageViewList.get(i).setImageResource(imageDatas.get(i - mul));
                        imageViewList.get(i).setVisibility(View.VISIBLE);
                    } else {
                        imageViewList.get(i).setVisibility(View.GONE);
                    }
                }
            }
        });
    }
}
