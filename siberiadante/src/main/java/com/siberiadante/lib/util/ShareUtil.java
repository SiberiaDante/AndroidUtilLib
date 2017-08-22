package com.siberiadante.lib.util;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/7/12
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class ShareUtil {


//    private static final String TAG = ShareUtil.class.getSimpleName();
//    private Activity mActivity;
//    private String mThumb, mTitle, mSUrl, mDes;
//    private int mType;
//    private Bitmap mBmp;
//
//    /**
//     *
//     * @param activity
//     * @param thumb 分享缩略图
//     * @param title 分享的标题
//     * @param sUrl 分享的连接
//     * @param des 分享的描述
//     */
//    public ShareUtil(Activity activity, String thumb, String title, String sUrl, String des) {
//        this.mActivity = activity;
//        this.mThumb = thumb;
//        this.mTitle = title;
//        this.mSUrl = sUrl;
//        this.mDes = des;
//    }
//
//    public void goToShareToQQ(int type) {
////        Tencent.SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN，分享时自动打开分享到QZone的对话框。      2
////        Tencent.SHARE_TO_QQ_FLAG_QZONE_ITEM_HIDE，分享时隐藏分享到QZone按钮      1
//        final Bundle params = new Bundle();
////        if (mType==1) {
////            mTargetScene = QQShare.SHARE_TO_QQ_FLAG_QZONE_ITEM_HIDE;
////        }
//        params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
//        params.putString(QQShare.SHARE_TO_QQ_TITLE, mActivity.getResources().getString(R.string.app_name));
//        params.putString(QQShare.SHARE_TO_QQ_SUMMARY, mDes);
//        params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, mSUrl);
//        params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, mThumb);
//        params.putString(QQShare.SHARE_TO_QQ_APP_NAME, mActivity.getResources().getString(R.string.app_name));
//        params.putInt(QQShare.SHARE_TO_QQ_EXT_INT, type);//mType=1分享到空间 or mType=2分享到qq好友;
//        mTencent.shareToQQ(mActivity, params, new BaseApiListener());
//    }
//
//    public void goToShareToWeiBo() {
//        if (mThumb.equals("")) {
//            gotoShareToWB();
//        } else {
//            gotoDownLoadSharePic(RequestCode.WB_DOWNLOAD_IMAGE_MESSAGE);
//        }
//    }
//
//    /**
//     *
//     * @param type 0:微信好友;1:微信朋友圈;2:微信分享;
//     */
//    public void goToShareToWeChat(int type) {
//        this.mType = type;
//        if (!XBLiveApplication.api.isWXAppInstalled()) {
//            ToastUtils.toast(mActivity.getString(R.string.YourPhoneUnInstalledWeChat));
//            return;
//        }
//        if (XBLiveApplication.api == null) {
//            XBLiveApplication.api = WXAPIFactory.createWXAPI(mActivity, Constants.WX_APP_ID, true);
//        }
//        if (mThumb.equals("")) {
//            shareToWeChat(type);
//        } else {
//            gotoDownLoadSharePic(RequestCode.WX_DOWNLOAD_IMAGE_MESSAGE);
//        }
//    }
//
//    private void shareToWeChat(int type) {
//        /*
//        0:微信好友
//        1:微信朋友圈
//        2:微信分享
//         */
//        WXWebpageObject mWebPage = new WXWebpageObject();
//        mWebPage.webpageUrl = mSUrl;
//        WXMediaMessage msg = new WXMediaMessage(mWebPage);
//        if (type == SendMessageToWX.Req.WXSceneTimeline || type == SendMessageToWX.Req.WXSceneFavorite) {
//            msg.title = mTitle;
//        } else {
//            msg.title = mTitle;
//            msg.description = mDes;
//        }
//        if (mBmp == null || mThumb.equals("")) {
//            mBmp = BitmapFactory.decodeResource(mActivity.getResources(), R.mipmap.icon_xb);
//        }
//        mBmp = Bitmap.createScaledBitmap(mBmp, 120, 120, true);//压缩Bitmap.微信分享图片不能超过64K
//
//        msg.setThumbImage(mBmp);
//        SendMessageToWX.Req req = new SendMessageToWX.Req();
//        req.transaction = buildTransaction("webpage");
//        req.message = msg;
//        req.scene = type;
//        XBLiveApplication.api.sendReq(req);
//    }
//
//    private String buildTransaction(final String type) {
//        return (type == null) ? String.valueOf(System.currentTimeMillis()) : type + System.currentTimeMillis();
//    }
//
//    private void gotoDownLoadSharePic(final int message) {
//        Log.d(TAG, "gotoDownLoadSharePic: " + mThumb);
//        new Thread() {
//            @Override
//            public void run() {
//                try {
//                    URL iconUrl = new URL(mThumb);
//                    URLConnection conn = iconUrl.openConnection();
//                    HttpURLConnection http = (HttpURLConnection) conn;
//
//                    int length = http.getContentLength();
//                    conn.connect();
//                    // 获得图像的字符流
//                    InputStream is = conn.getInputStream();
//                    BufferedInputStream bis = new BufferedInputStream(is, length);
//                    mBmp = BitmapFactory.decodeStream(bis);
//                    bis.close();
//                    is.close();// 关闭流
//                    Log.d(TAG, "run: bmpbmpbmpbmpbmpbmpbmpbmpbmpbmp" + mBmp);
//                    if (message == RequestCode.WX_DOWNLOAD_IMAGE_MESSAGE) {
//                        shareToWeChat(mType);
//                    } else if (message == RequestCode.WB_DOWNLOAD_IMAGE_MESSAGE) {
//                        gotoShareToWB();
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();
//    }
//
//    private void gotoShareToWB() {
//        if (mWeiboShareAPI.isWeiboAppSupportAPI()) {
//            int supportApi = mWeiboShareAPI.getWeiboAppSupportAPI();
//            if (supportApi >= ApiUtils.BUILD_INT_VER_2_2 /*ApiUtils.BUILD_INT_VER_2_2*/) {
//                //多条分享
//                sendMultiMessage();
//            } else {
//                //单条分享
//                sendSingleMessage();
//            }
//        } else {
//            ToastUtils.toast("微博客户端不支持");
//        }
//    }
//
//    private void sendMultiMessage() {
//        WeiboMultiMessage weiboMessage = new WeiboMultiMessage();
//        weiboMessage.mediaObject = getWebpageObj();
//        weiboMessage.textObject = getTextObj();
//        weiboMessage.imageObject = getImageObj();
//
//        // 2. 初始化从第三方到微博的消息请求
//        SendMultiMessageToWeiboRequest request = new SendMultiMessageToWeiboRequest();
//        // 用transaction唯一标识一个请求
//        request.transaction = String.valueOf(System.currentTimeMillis());
//        request.multiMessage = weiboMessage;
//        mWeiboShareAPI.sendRequest(mActivity, request);
//    }
//
//    private void sendSingleMessage() {
//        WeiboMessage weiboMessage = new WeiboMessage();
//        weiboMessage.mediaObject = getWebpageObj();
//        // 2. 初始化从第三方到微博的消息请求
//        SendMessageToWeiboRequest request = new SendMessageToWeiboRequest();
//        // 用transaction唯一标识一个请求
//        request.transaction = String.valueOf(System.currentTimeMillis());
//        request.message = weiboMessage;
//        // 3. 发送请求消息到微博，唤起微博分享界面
//        mWeiboShareAPI.sendRequest(mActivity, request);
//    }
//
//    private WebpageObject getWebpageObj() {
//        WebpageObject mediaObject = new WebpageObject();
//        mediaObject.identify = Utility.generateGUID();
//        mediaObject.title = mActivity.getResources().getString(R.string.app_name);
//        mediaObject.description = mTitle;
//        if (mBmp == null) {
//            mBmp = BitmapFactory.decodeResource(mActivity.getResources(), R.mipmap.icon_xb);
//        }
//        mBmp = Bitmap.createScaledBitmap(mBmp, 60, 60, true);//压缩Bitmap.微博分享图片不能超过32KB
//
//        // bmp<32kb。
//        mediaObject.setThumbImage(mBmp);
//        mediaObject.actionUrl = mSUrl;
////        mediaObject.defaultText = "_";
//        return mediaObject;
//    }
//
//    private TextObject getTextObj() {
//        TextObject textObject = new TextObject();
//        textObject.text = mTitle;
//        return textObject;
//    }
//
//    private ImageObject getImageObj() {
//        ImageObject imageObject = new ImageObject();
//        if (mBmp == null || mThumb.equals("")) {
//            mBmp = BitmapFactory.decodeResource(mActivity.getResources(), R.mipmap.icon_xb);
//        }
//        mBmp = Bitmap.createScaledBitmap(mBmp, 60, 60, true);//压缩Bitmap.微博分享图片不能超过32KB
//
//        Log.d(TAG, "getImageObj: 2");
//        //设置缩略图。 注意：最终压缩过的缩略图大小不得超过 32kb。
//        imageObject.setImageObject(mBmp);
//        return imageObject;
//    }



}
