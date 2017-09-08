package com.siberiadante.custom.util;

import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.siberiadante.custom.R;
import com.siberiadante.custom.ui.MyApplication;
import com.siberiadante.lib.util.StringUtil;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/9/5
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class ImageLoadUtil {


    public static void frescoImage(String url, SimpleDraweeView imageView) {
        GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(MyApplication.getInstance().getResources());
        GenericDraweeHierarchy hierarchy = builder
                .setFadeDuration(300)
                .setActualImageScaleType(ScalingUtils.ScaleType.CENTER)//修改缩放类型
                .setPlaceholderImage(R.mipmap.ic_launcher, ScalingUtils.ScaleType.CENTER)
                .setFailureImage(R.mipmap.ic_launcher, ScalingUtils.ScaleType.CENTER)
                .build();
        imageView.setHierarchy(hierarchy);
        imageView.setImageURI(url);
    }

    public static void frescoImageRadius(String url, SimpleDraweeView imageView) {
        GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(MyApplication.getInstance().getResources());
        GenericDraweeHierarchy hierarchy = builder
                .setFadeDuration(300)
                .setPlaceholderImage(R.mipmap.ic_launcher)
                .setRoundingParams(new RoundingParams().setCornersRadius(10))
                .setFailureImage(R.mipmap.ic_launcher)
                .build();
        imageView.setHierarchy(hierarchy);
        imageView.setImageURI(url);

    }

    public static void frescoImageLoad(String uri, SimpleDraweeView simpleDraweeView) {

        BaseControllerListener listener = new BaseControllerListener() {
        };

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setTapToRetryEnabled(true)
                .setOldController(simpleDraweeView.getController())
                .setControllerListener(listener)
                .build();
        simpleDraweeView.setController(controller);

    }
}
