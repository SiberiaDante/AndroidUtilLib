package com.siberiadante.custom.util;

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

/**
 * @Created SiberiaDante
 * @Describe： Fresco图片加载框架
 * @Time: 2017/9/5
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class ImageLoadUtil {


    /**
     * 设置图片url
     *
     * @param url
     * @param imageView
     */
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

    /**
     * 设置图片URL，默认圆角10
     *
     * @param url
     * @param imageView
     */
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

    /**
     * 设置圆角图片URL
     *
     * @param url
     * @param imageView
     * @param radius
     */
    public static void frescoImageRadius(String url, SimpleDraweeView imageView, int radius) {
        GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(MyApplication.getInstance().getResources());
        GenericDraweeHierarchy hierarchy = builder
                .setFadeDuration(300)
                .setPlaceholderImage(R.mipmap.ic_launcher)
                .setRoundingParams(new RoundingParams().setCornersRadius(radius))
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
