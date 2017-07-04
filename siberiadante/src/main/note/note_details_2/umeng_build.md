## 友盟多渠道打包
* Manifest.xml中
```
          <meta-data
              android:name="UMENG_APPKEY"
              android:value="你的友盟APP key" />
          <meta-data
              android:name="UMENG_CHANNEL"
              android:value="${UMENG_CHANNEL_VALUE}" />
```
* build.gradle中：
```
 buildTypes {
        release {
            minifyEnabled false
            // 自定义输出配置
            applicationVariants.all { variant ->
                variant.outputs.each { output ->
                    def outputFile = output.outputFile
                    if (outputFile != null && outputFile.name.endsWith('.apk')) {
                        // 输出apk名称为japan_story_v1.0_wandoujia.apk
                        def fileName = "japan_story_${defaultConfig.versionName}_${variant.productFlavors[0].name}.apk"
                        output.outputFile = new File(outputFile.parent, fileName)
                    }
                }
            }
        }
    }
    productFlavors {
        wandoujia {}
        baidu {}
        xiaomi {}
        huawei {}
        anzhuoyuan {}
        vivo {}
        oppo {}
        meizu {}
        qh360 {}
        yingyongbao {}
        browser {}
        baiduandroid {}
        baidu91 {}
        productFlavors.all { flavor ->
            flavor.manifestPlaceholders = [UMENG_CHANNEL_VALUE: name]
        }
    }
```
集成友盟SDK：
```
compile 'com.umeng.analytics:analytics:latest.integration'
```

