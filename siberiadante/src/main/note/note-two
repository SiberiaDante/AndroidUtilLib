# Android常用的系统广播

* Intent.ACTION_AIRPLANE_MODE_CHANGED;
//关闭或打开飞行模式时的广播

* <strong>Intent.ACTION_BATTERY_CHANGED;
//充电状态，或者电池的电量发生变化
//电池的充电状态、电荷级别改变，不能通过组建声明接收这个广播，只有通过Context.registerReceiver()注册

* <strong>Intent.ACTION_BATTERY_LOW;
//表示电池电量低

* <strong>Intent.ACTION_BATTERY_OKAY;
//表示电池电量充足，即从电池电量低变化到饱满时会发出广播

* Intent.ACTION_BOOT_COMPLETED;
//在系统启动完成后，这个动作被广播一次（只有一次）。

* Intent.ACTION_CAMERA_BUTTON;
//按下照相时的拍照按键(硬件按键)时发出的广播

* Intent.ACTION_CLOSE_SYSTEM_DIALOGS;
//当屏幕超时进行锁屏时,当用户按下电源按钮,长按或短按(不管有没跳出话框)，进行锁屏时,android系统都会广播此Action消息

* Intent.ACTION_CONFIGURATION_CHANGED;
//设备当前设置被改变时发出的广播(包括的改变:界面语言，设备方向，等，请参考Configuration.java)

* Intent.ACTION_DATE_CHANGED;
//设备日期发生改变时会发出此广播

* Intent.ACTION_DEVICE_STORAGE_LOW;
//设备内存不足时发出的广播,此广播只能由系统使用，其它APP不可用？

* Intent.ACTION_DEVICE_STORAGE_OK;
//设备内存从不足到充足时发出的广播,此广播只能由系统使用，其它APP不可用？

* Intent.ACTION_DOCK_EVENT;
//发出此广播的地方frameworks\base\services\java\com\android\server\DockObserver.java

* Intent.ACTION_EXTERNAL_APPLICATIONS_AVAILABLE;
//移动APP完成之后，发出的广播(移动是指:APP2SD)

* Intent.ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE;
//正在移动APP时，发出的广播(移动是指:APP2SD)

* Intent.ACTION_GTALK_SERVICE_CONNECTED;
//Gtalk已建立连接时发出的广播

* Intent.ACTION_GTALK_SERVICE_DISCONNECTED;
//Gtalk已断开连接时发出的广播

* Intent.ACTION_HEADSET_PLUG;
//在耳机口上插入耳机时发出的广播

* Intent.ACTION_INPUT_METHOD_CHANGED;
//改变输入法时发出的广播

* Intent.ACTION_LOCALE_CHANGED;
//设备当前区域设置已更改时发出的广播

* Intent.ACTION_MANAGE_PACKAGE_STORAGE;
//

* Intent.ACTION_MEDIA_BAD_REMOVAL;
//未正确移除SD卡(正确移除SD卡的方法:设置--SD卡和设备内存--卸载SD卡)，但已把SD卡取出来时发出的广播
//广播：扩展介质（扩展卡）已经从 SD 卡插槽拔出，但是挂载点 (mount point) 还没解除 (unmount)

* Intent.ACTION_MEDIA_BUTTON;
//按下"Media Button" 按键时发出的广播,假如有"Media Button" 按键的话(硬件按键)

* Intent.ACTION_MEDIA_CHECKING;
//插入外部储存装置，比如SD卡时，系统会检验SD卡，此时发出的广播?

* Intent.ACTION_MEDIA_EJECT;
//已拔掉外部大容量储存设备发出的广播（比如SD卡，或移动硬盘）,不管有没有正确卸载都会发出此广播?
//广播：用户想要移除扩展介质（拔掉扩展卡）。
* Intent.ACTION_MEDIA_MOUNTED;
//插入SD卡并且已正确安装（识别）时发出的广播
//广播：扩展介质被插入，而且已经被挂载。
* Intent.ACTION_MEDIA_NOFS;
//
* Intent.ACTION_MEDIA_REMOVED;
//外部储存设备已被移除，不管有没正确卸载,都会发出此广播？
// 广播：扩展介质被移除。
* Intent.ACTION_MEDIA_SCANNER_FINISHED;
//广播：已经扫描完介质的一个目录
* Intent.ACTION_MEDIA_SCANNER_SCAN_FILE;
//
* Intent.ACTION_MEDIA_SCANNER_STARTED;
//广播：开始扫描介质的一个目录

* Intent.ACTION_MEDIA_SHARED;
// 广播：扩展介质的挂载被解除 (unmount)，因为它已经作为 USB 大容量存储被共享。
* Intent.ACTION_MEDIA_UNMOUNTABLE;
//
* Intent.ACTION_MEDIA_UNMOUNTED
// 广播：扩展介质存在，但是还没有被挂载 (mount)。
* Intent.ACTION_NEW_OUTGOING_CALL;

* Intent.ACTION_PACKAGE_ADDED;
//成功的安装APK之后
//广播：设备上新安装了一个应用程序包。
//一个新应用包已经安装在设备上，数据包括包名（最新安装的包程序不能接收到这个广播）
* Intent.ACTION_PACKAGE_CHANGED;
//一个已存在的应用程序包已经改变，包括包名
* Intent.ACTION_PACKAGE_DATA_CLEARED;
//清除一个应用程序的数据时发出的广播(在设置－－应用管理－－选中某个应用，之后点清除数据时?)
//用户已经清除一个包的数据，包括包名（清除包程序不能接收到这个广播）

Intent.ACTION_PACKAGE_INSTALL;
//触发一个下载并且完成安装时发出的广播，比如在电子市场里下载应用？
//
* Intent.ACTION_PACKAGE_REMOVED;
//成功的删除某个APK之后发出的广播
//一个已存在的应用程序包已经从设备上移除，包括包名（正在被安装的包程序不能接收到这个广播）

* Intent.ACTION_PACKAGE_REPLACED;
//替换一个现有的安装包时发出的广播（不管现在安装的APP比之前的新还是旧，都会发出此广播？）
* Intent.ACTION_PACKAGE_RESTARTED;
//用户重新开始一个包，包的所有进程将被杀死，所有与其联系的运行时间状态应该被移除，包括包名（重新开始包程序不能接收到这个广播）
* Intent.ACTION_POWER_CONNECTED;
//插上外部电源时发出的广播
* Intent.ACTION_POWER_DISCONNECTED;
//已断开外部电源连接时发出的广播
* Intent.ACTION_PROVIDER_CHANGED;
//

* Intent.ACTION_REBOOT;
//重启设备时的广播

* Intent.ACTION_SCREEN_OFF;
//屏幕被关闭之后的广播

* Intent.ACTION_SCREEN_ON;
//屏幕被打开之后的广播

* Intent.ACTION_SHUTDOWN;
//关闭系统时发出的广播

* Intent.ACTION_TIMEZONE_CHANGED;
//时区发生改变时发出的广播

* Intent.ACTION_TIME_CHANGED;
//时间被设置时发出的广播

* Intent.ACTION_TIME_TICK;
//广播：当前时间已经变化（正常的时间流逝）。
//当前时间改变，每分钟都发送，不能通过组件声明来接收，只有通过Context.registerReceiver()方法来注册

* Intent.ACTION_UID_REMOVED;
//一个用户ID已经从系统中移除发出的广播
//

* Intent.ACTION_UMS_CONNECTED;
//设备已进入USB大容量储存状态时发出的广播？

* Intent.ACTION_UMS_DISCONNECTED;
//设备已从USB大容量储存状态转为正常状态时发出的广播？

* Intent.ACTION_USER_PRESENT;
//

* Intent.ACTION_WALLPAPER_CHANGED;
//设备墙纸已改变时发出的广播