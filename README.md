# HeavenlyUpdate #
Heavenlyupdateapk是Heavenlymoudle的一个子模块 下载链接：[https://github.com/xiaoxiangyeyuHeaven/HeavenlyModule](https://github.com/xiaoxiangyeyuHeaven/HeavenlyModule)     
Heavenlyupdate是对下载apk以及安装的简单封装
## 混淆  

     -dontwarn com.heavenly.updateapk.**
     -keep class com.heavenly.updateapk.**{*;}
##基本配置
**权限**  

    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS"/>    
**初始化**    

     heavenlyUpadate = HeavenlyUpadate.getInstance()
                .init(this)；    

**application配置（可选）**  
例如：android:installLocation = "auto"   

auto:表示先查看手机内存是否足够，如果够就安装在手机内存上，不够就安装在外部储存卡卡上；

internalOnly:表示安装在手机内存上.  

preferExternal:表示安装在外部储存卡卡上  
  
## HeavenlyUpdate（方法调用）
|方法名|描述
|---|---|---|
|setUpadeUrl| 设置下载apk地址
|setDownLoadManager| 设置是否使用DownLoadManager
|setFileName| 设置apk文件名
|setUpdateDirectory| 设置下载路径
|setIcon| 设置下载时显示图标 
|setTitle| 设置下载时显示文字
|startUpdate| 开始下载
|requestPermission| 申请6.0权限
|setProviderName| provider的authorities

**注意**  

android7.0FileProvider和android6.0权限问题