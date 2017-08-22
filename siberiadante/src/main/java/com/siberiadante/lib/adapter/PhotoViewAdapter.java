//package com.siberiadante.lib.adapter;
//
//import android.support.v4.view.PagerAdapter;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.github.chrisbanes.photoview.PhotoView;
//import com.siberiadante.R;
//import com.squareup.picasso.Picasso;
//
//import java.util.List;
//
//
///**
// * Created by SiberiaDante
// * Describe: 图片查看器的适配器
// * Time: 2017/5/4.
// * Email: 994537867@qq.com
// * GitHub: https://github.com/SiberiaDante
// * 博客园： http://www.cnblogs.com/shen-hua/
// */
//
//public class PhotoViewAdapter extends PagerAdapter {
//    public static final String TAG = PhotoViewAdapter.class.getSimpleName();
//    private List<String> imageUrls;
//    private AppCompatActivity activity;
//
//    public PhotoViewAdapter(List<String> imageUrls, AppCompatActivity activity) {
//        this.imageUrls = imageUrls;
//        this.activity = activity;
//    }
//
//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//        String url = imageUrls.get(position);
//        PhotoView photoView = new PhotoView(activity);
//        Picasso.with(activity)
//                .load(url)
//                .into(photoView);
//        photoView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                activity.finish();
//                activity.overridePendingTransition(R.anim.photo_activity_before_enter, R.anim.photo_activity_exit);
//            }
//        });
////        photoView.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
////            @Override
////            public void onPhotoTap(View view, float x, float y) {
////                activity.finish();
////                activity.overridePendingTransition(R.anim.photo_activity_before_enter, R.anim.photo_activity_exit);
////            }
////
////            @Override
////            public void onOutsidePhotoTap() {
////
////            }
////        });
//        container.addView(photoView);
//        return photoView;
//    }
//
//    @Override
//    public int getCount() {
//        return imageUrls != null ? imageUrls.size() : 0;
//    }
//
//    @Override
//    public boolean isViewFromObject(View view, Object object) {
//        return view == object;
//    }
//
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        container.removeView((View) object);
//    }
//
//    @Override
//    public int getItemPosition(Object object) {
//        return POSITION_NONE;
//    }
//}
