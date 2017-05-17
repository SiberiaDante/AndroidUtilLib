# Android 保存图片到本地并显示出来
## 可参考[sample/src/main/activity/PhotoViewActivity]
* 下载图片并保存至本地相册
```
public static final String ALBUM_PATH = Environment.getExternalStorageDirectory() + "/sample/";

public void saveFile(Bitmap bmp, long currentTimeMillis) {
        String mFilePath = ALBUM_PATH + String.valueOf(currentTimeMillis) + ".jpg";
        File tmp = new File(ALBUM_PATH);
        if (!tmp.exists()) {
            tmp.mkdir();
        }
        File photoFile = new File(mFilePath);
        Uri photoUri = Uri.fromFile(photoFile);
        try {
            photoFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileOutputStream fOut = null;
        try {
            fOut = new FileOutputStream(photoFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bmp.compress(Bitmap.CompressFormat.PNG, 100, fOut);
        mHandler.sendEmptyMessage(SEND_TOAST);//发送图片保存成功的通知
        try {
            fOut.flush();
            fOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

```
* 将图片插入到系统相册
```
try {
       MediaStore.Images.Media.insertImage(getApplicationContext().getContentResolver(),
                    photoFile.getAbsolutePath(), mFilePath, "");
//            if (photoFile.exists()) {
//                boolean delete = photoFile.delete();
//                Log.d(TAG, "saveFile: delete------"+delete);
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
```
发送广播通知刷新图库（没有此操作在相册下是看不到图片的在，只有进入sd卡根路径下才能看到）

```
Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
Uri uri = Uri.fromFile(photoFile);
intent.setData(uri);
context.sendBroadcast(intent)
```
或者
```
getApplicationContext().sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                photoUri));
```


[sample/src/main/activity/PhotoViewActivity]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/sample/src/main/java/com/sample/activity/PhotoViewActivity.java