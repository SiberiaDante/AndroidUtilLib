
### SDActivityManagerUtil
```
addActivity(Activity activity)
removeActivity(Activity activity)
removeAndFinishActivity(Activity activity)
currentActivity()
removeCurrentActivity()
removeAndFinishCurrentActivity()
appExit()
finishAllActivity()
```

### SDActivityUtil
```
isActivityRunning(Activity activity)
isActivityExists(@NonNull String packageName, @NonNull String activityName)
getLauncherActivity(String packageName)
```

### SDAppUtil
```
getAppName()
getAppName(String packageName)
getAppVersionName()
getAppVersionName(Context context)
getAppVersionName(String packageName)
getAppVersionCode()
getAppVersionCode(String packageName)
getAppVersionCode(Context context)
getAppIcon()
getAppIcon(String packageName) 
getAppInfo()
getAppInfo(String packageName)
getPackageName()
getPackageName(String apkPath)
isInstalledApp()
isInstalledApp(String packageName)
getAppPath()
getAppPath(String packageName)
isAppDebug()
isAppDebug(String packageName)
isAppRoot()
getAppSignature()
getAppSignature(String packageName)
getAppSignatureSHA1()
getAppSignatureSHA1(String packageName)
isNotificationEnable()
isNotificationEnable(Context context) 
isAppInForeground() 
isAppInForeground(String packageName) 
launchApp()
launchApp(String packageName)
launchApp(Activity activity, String packageName, int requestCode)
installApp(Context context, String filePath, String authority)
installApp(Context context, File file, String authority)
unInstallApp(String packageName)
unInstallApp(Activity activity, String packageName, int requestCode) {
getInstallAppInfo()
getInstallAppInfo(Context context)
getInstallAppInfo(Context context, boolean showSystemApp)
installAppSilent(String filePath) 
isSystemApp()
```

### SDBitmapUtil
```

```

### SDCacheUtil
```
getTotalCacheSize()
getFolderSize(File file)
getFormatSize(double size)
```

### SDCleanUtil
```
clearAllCache()
cleanInternalCache()
cleanInternalFiles()
cleanInternalDbs()
cleanInternalDbByName(String dbName)
cleanInternalSP()
cleanExternalCache()
cleanCustomCache(String dirPath)
cleanCustomCache(File dir)
```

### SDCloseUtil
```
closeIO(Closeable... closeables)
```

### SDCrashHandler
```
```

### SDDataUtil
```
intsGetSum(int[] ints) 
```

### SDDateUtil
```
getYear()
getTimeStamp()
getMonth()
getDay()
getHour()
getMinute()
getSecond() 
getSDFTimeHm()          15:44
getSDFTimeHmA()         3:44 下午
getSDFTimeHms()         15:44:40
getSDFTimeYMd()         2016-08-12
getSDFTimeYMdHm()       2016-08-12 15:44
getSDFTimeYMdHms()      2016-08-12 15:44:40
getSDFTimeCST()                     2016.08.12 公元 at 15:44:40 CST
getStrToTime(String str)            yyyy-MM-dd HH:mm:ss
getStrToTime()                      yyyy年MM月dd日 HH时mm分ss秒
getStrToTimeHm(String str)          15:44
getStrToTimeHms(String str)         15:44:40
getStrToTimeYMdHm(String str)        2016-08-12 15:44
getTimeStampFromFormat(String str, String format)
getCurrentSDFTime(String format)
getConstellation(int month, int day)  获取星座
isLeapYear(int year)
isLeapYear(long millis)
isLeapYear(Date date) 
isLeapYear(String time)
isLeapYear(String time, String pattern)
string2Date(String time, String pattern)
string2Millis(String time, String pattern)
getSDFDateFromMillisTimeStamp(String millisecond, String pattern) 
millis2Date(long millis)
getWeek(long millis)
getWeek(Date date) 
getWeek(String time, String pattern)
getWeekIndex(Date date)
getWeekIndex(long millis)
getWeekIndex(String time, String pattern) 
getWeekOfMonth(long millis)
getWeekOfMonth(Date date)
getWeekOfMonth(String time, String pattern)
getWeekOfYear(long millis)
getWeekOfYear(Date date)
getWeekOfYear(String time, String pattern)
getMonthOfDay(int year, int month)
getChineseZodiac(int year)       获取生肖
getChineseZodiac(Date date)
getChineseZodiac(long millis)
getChineseZodiac(String time, String pattern)
```