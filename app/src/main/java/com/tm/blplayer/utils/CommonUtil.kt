package com.tm.blplayer.utils

import android.annotation.TargetApi
import android.app.Activity
import android.app.ActivityManager
import android.app.KeyguardManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Rect
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.Settings
import android.telephony.TelephonyManager
import android.text.TextUtils
import android.util.DisplayMetrics
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import java.io.File
import java.util.*

/**
 * @author wutongming
 * *
 * @description
 * *
 * @since 2017/4/17
 */

class CommonUtil {

    //判断手机连接的网络类型(2G,3G,4G)
    object Constants {
        /**
         * Unknown network class
         */
        val NETWORK_CLASS_UNKNOWN = 0

        /**
         * wifi net work
         */
        val NETWORK_WIFI = 1

        /**
         * "2G" networks
         */
        val NETWORK_CLASS_2_G = 2

        /**
         * "3G" networks
         */
        val NETWORK_CLASS_3_G = 3

        /**
         * "4G" networks
         */
        val NETWORK_CLASS_4_G = 4

    }

    companion object {
        /**
         * 检测服务是否启动
         */
        fun isServiceStarted(context: Context, className: String): Boolean {
            val myManager = context.getSystemService(
                    Context.ACTIVITY_SERVICE) as ActivityManager
            val runningService = myManager
                    .getRunningServices(30) as ArrayList<ActivityManager.RunningServiceInfo>
            return runningService.any { it.service.className == className }
        }

        //跳转至拨号界面
        fun callDial(context: Context, phoneNumber: String) {
            context.startActivity(Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:" + phoneNumber)))
        }

        //发送短信
        fun sendSms(context: Context, phoneNumber: String, content: String) {
            val uri = Uri.parse("smsto:" + if (TextUtils.isEmpty(phoneNumber)) "" else phoneNumber)
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", if (TextUtils.isEmpty(content)) "" else content)
            context.startActivity(intent)
        }

        //唤醒屏幕并解锁
        /*
    * 需要的权限:
    * <uses-permission android:name="android.permission.WAKE_LOCK" />
<uses-permission android:name="android.permission.DISABLE_KEYGUARD" />
    * */
        /*public static void wakeUpAndUnlock(Context context){
        KeyguardManager km = (KeyguardManager) context.getSystemService(context.KEYGUARD_SERVICE);
        KeyguardManager.KeyguardLock keyguardLock = km.newKeyguardLock("unlock");
        //解锁
        keyguardLock.disableKeyguard();
        //获取电源管理器对象
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        //获取PowerManager.WakeLock对象,后面的参数|表示同时传入两个值,最后的是LogCat里用的Tag
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.SCREEN_DIM_WAKE_LOCK,"bright");
        //点亮屏幕
        wl.acquire();
        //释放
        wl.release();
    }*/

        //判断当前app处于前台还是后台
        /*
    * <uses-permission
     android:name="android.permission.GET_TASKS" />
    * */
        fun isApplicationBackground(context: Context): Boolean {
            val am = context
                    .getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            val tasks = am.getRunningTasks(1)
            if (!tasks.isEmpty()) {
                val topActivity = tasks[0].topActivity
                if (topActivity.packageName != context.packageName) {
                    return true
                }
            }
            return false
        }

        //判断当前手机是否处于锁屏(睡眠)状态
        fun isSleeping(context: Context): Boolean {
            val kgMgr = context
                    .getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
            return kgMgr.inKeyguardRestrictedInputMode()
        }

        //判断当前是否有网络连接
        fun isOnline(context: Context): Boolean {
            val manager = context
                    .getSystemService(Activity.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = manager.activeNetworkInfo
            return info != null && info.isConnected
        }

        //判断当前是否是WIFI连接状态
        fun isWifiConnected(context: Context): Boolean {
            val connectivityManager = context
                    .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val wifiNetworkInfo = connectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_WIFI)
            return wifiNetworkInfo.isConnected
        }

        //判断网络是否可用
        fun isNet(act: Context): Boolean {

            val manager = act
                    .applicationContext.getSystemService(
                    Context.CONNECTIVITY_SERVICE) as ConnectivityManager ?: return false

            val networkinfo = manager.activeNetworkInfo

            return !(networkinfo == null || !networkinfo.isAvailable)

        }

        //安装APK
        fun installApk(context: Context, file: File) {
            val intent = Intent()
            intent.action = "android.intent.action.VIEW"
            intent.addCategory("android.intent.category.DEFAULT")
            intent.type = "application/vnd.android.package-archive"
            intent.setDataAndType(Uri.fromFile(file),
                    "application/vnd.android.package-archive")
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }

        //判断当前设备是否为手机
        fun isPhone(context: Context): Boolean {
            val telephony = context
                    .getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            return telephony.phoneType != TelephonyManager.PHONE_TYPE_NONE
        }

        /**
         * 获取当前屏幕宽，不包括虚拟键，单位px
         */
        fun getScreenWidth(context: Context): Int {
            val manager = context
                    .getSystemService(Context.WINDOW_SERVICE) as WindowManager
            return manager.defaultDisplay.width
        }

        /**
         * 获取当前屏幕高，不包括虚拟键，单位px
         */
        fun getScreenHeight(context: Context): Int {
            val manager = context
                    .getSystemService(Context.WINDOW_SERVICE) as WindowManager
            return manager.defaultDisplay.height
        }

        /**
         * 获取设备实际高度
         * 返回 px
         */
        fun getDeviceHeight(activity: Activity): Int {
            var px = 0
            val display = activity.windowManager.defaultDisplay
            val dm = DisplayMetrics()
            val c: Class<*>
            try {
                c = Class.forName("android.view.Display")
                val method = c.getMethod("getRealMetrics", DisplayMetrics::class.java)
                method.invoke(display, dm)
                px = dm.heightPixels
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return px
        }

        fun getDeviceWidth(activity: Activity): Int {
            var px = 0
            val display = activity.windowManager.defaultDisplay
            val dm = DisplayMetrics()
            val c: Class<*>
            try {
                c = Class.forName("android.view.Display")
                val method = c.getMethod("getRealMetrics", DisplayMetrics::class.java)
                method.invoke(display, dm)
                px = dm.widthPixels
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return px
        }

        //获取当前设备的IMEI，需要与上面的isPhone()一起使用
        @TargetApi(Build.VERSION_CODES.CUPCAKE)
        fun getDeviceIMEI(context: Context): String {
            val deviceId: String
            if (isPhone(context)) {
                val telephony = context
                        .getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
                deviceId = telephony.deviceId
            } else {
                deviceId = Settings.Secure.getString(context.contentResolver,
                        Settings.Secure.ANDROID_ID)

            }
            return deviceId
        }

        //获取当前设备的MAC地址
        /*public static String getMacAddress(Context context) {
        String macAddress;
        WifiManager wifi = (WifiManager) context
                .getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        macAddress = info.getMacAddress();
        if (null == macAddress) {
            return "";
        }
        macAddress = macAddress.replace(":", "");
        return macAddress;
    }*/

        //获取当前程序的版本号
        fun getAppVersion(context: Context): String {
            var version = "0"
            try {
                version = context.packageManager.getPackageInfo(
                        context.packageName, 0).versionName
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }

            return version
        }

        //收集设备信息，用于信息统计分析
        /*public static Properties collectDeviceInfo(Context context) {
        Properties mDeviceCrashInfo = new Properties();
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(),
                    PackageManager.GET_ACTIVITIES);
            if (pi != null) {
                mDeviceCrashInfo.put(VERSION_NAME,
                        pi.versionName == null ? "not set" : pi.versionName);
                mDeviceCrashInfo.put(VERSION_CODE, pi.versionCode);
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Error while collect package info", e);
        }
        Field[] fields = Build.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                mDeviceCrashInfo.put(field.getName(), field.get(null));
            } catch (Exception e) {
                Log.e(TAG, "Error while collect crash info", e);
            }
        }
        return mDeviceCrashInfo;
    }
    public static String collectDeviceInfoStr(Context context) {
        Properties prop = collectDeviceInfo(context);
        Set deviceInfos = prop.keySet();
        StringBuilder deviceInfoStr = new StringBuilder("{\n");
        for (Iterator iter = deviceInfos.iterator(); iter.hasNext();) {
            Object item = iter.next();
            deviceInfoStr.append("\t\t\t" + item + ":" + prop.get(item)
                    + ", \n");
        }
        deviceInfoStr.append("}");
        return deviceInfoStr.toString();
    }*/

        //是否有SD卡
        fun haveSDCard(): Boolean {
            return android.os.Environment.getExternalStorageState() == android.os.Environment.MEDIA_MOUNTED
        }

        //动态隐藏软键盘
        fun hideSoftInput(activity: Activity) {
            val view = activity.window.peekDecorView()
            if (view != null) {
                val inputmanger = activity
                        .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputmanger.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }

        fun hideSoftInput(context: Context, edit: EditText) {
            edit.clearFocus()
            val inputmanger = context
                    .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputmanger.hideSoftInputFromWindow(edit.windowToken, 0)
        }

        //动态显示软键盘
        fun showSoftInput(context: Context, edit: EditText) {
            edit.isFocusable = true
            edit.isFocusableInTouchMode = true
            edit.requestFocus()
            val inputManager = context
                    .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.showSoftInput(edit, 0)
        }

        //动态显示或者是隐藏软键盘
        fun toggleSoftInput(context: Context, edit: EditText) {
            edit.isFocusable = true
            edit.isFocusableInTouchMode = true
            edit.requestFocus()
            val inputManager = context
                    .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        }

        //主动回到Home，后台运行
        fun goHome(context: Context) {
            val mHomeIntent = Intent(Intent.ACTION_MAIN)
            mHomeIntent.addCategory(Intent.CATEGORY_HOME)
            mHomeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
            context.startActivity(mHomeIntent)
        }

        //获取状态栏高度
        @TargetApi(Build.VERSION_CODES.CUPCAKE)
        fun getStatusBarHeight(activity: Activity): Int {
            val frame = Rect()
            activity.window.decorView.getWindowVisibleDisplayFrame(frame)
            return frame.top
        }

        //获取MCC+MNC代码 (SIM卡运营商国家代码和运营商网络代码)
        fun getNetworkOperator(context: Context): String {
            val telephonyManager = context
                    .getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            return telephonyManager.networkOperator
        }

        //返回移动网络运营商的名字
        fun getNetworkOperatorName(context: Context): String {
            val telephonyManager = context
                    .getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            return telephonyManager.networkOperatorName
        }

        //返回移动终端类型
        fun getPhoneType(context: Context): Int {
            val telephonyManager = context
                    .getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            return telephonyManager.phoneType
        }

        fun getNetWorkClass(context: Context): Int {
            val telephonyManager = context
                    .getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

            when (telephonyManager.networkType) {
                TelephonyManager.NETWORK_TYPE_GPRS, TelephonyManager.NETWORK_TYPE_EDGE, TelephonyManager.NETWORK_TYPE_CDMA, TelephonyManager.NETWORK_TYPE_1xRTT, TelephonyManager.NETWORK_TYPE_IDEN -> return Constants.NETWORK_CLASS_2_G

                TelephonyManager.NETWORK_TYPE_UMTS, TelephonyManager.NETWORK_TYPE_EVDO_0, TelephonyManager.NETWORK_TYPE_EVDO_A, TelephonyManager.NETWORK_TYPE_HSDPA, TelephonyManager.NETWORK_TYPE_HSUPA, TelephonyManager.NETWORK_TYPE_HSPA, TelephonyManager.NETWORK_TYPE_EVDO_B, TelephonyManager.NETWORK_TYPE_EHRPD, TelephonyManager.NETWORK_TYPE_HSPAP -> return Constants.NETWORK_CLASS_3_G

                TelephonyManager.NETWORK_TYPE_LTE -> return Constants.NETWORK_CLASS_4_G

                else -> return Constants.NETWORK_CLASS_UNKNOWN
            }
        }

        //判断当前手机的网络类型(WIFI还是2,3,4G)
        fun getNetWorkStatus(context: Context): Int {
            var netWorkType = Constants.NETWORK_CLASS_UNKNOWN

            val connectivityManager = context
                    .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo

            if (networkInfo != null && networkInfo.isConnected) {
                val type = networkInfo.type

                if (type == ConnectivityManager.TYPE_WIFI) {
                    netWorkType = Constants.NETWORK_WIFI
                } else if (type == ConnectivityManager.TYPE_MOBILE) {
                    netWorkType = getNetWorkClass(context)
                }
            }
            return netWorkType
        }

        //px-dp转换
        fun dip2px(context: Context, dpValue: Float): Int {
            val scale = context.resources.displayMetrics.density
            return (dpValue * scale + 0.5f).toInt()
        }

        fun px2dip(context: Context, pxValue: Float): Int {
            val scale = context.resources.displayMetrics.density
            return (pxValue / scale + 0.5f).toInt()
        }

        //px-sp转换
        fun px2sp(context: Context, pxValue: Float): Int {
            val fontScale = context.resources.displayMetrics.scaledDensity
            return (pxValue / fontScale + 0.5f).toInt()
        }

        fun sp2px(context: Context, spValue: Float): Int {
            val fontScale = context.resources.displayMetrics.scaledDensity
            return (spValue * fontScale + 0.5f).toInt()
        }

        /**
         * 获取系统亮度
         * 取值在(0 -- 255)之间
         */
        fun getSystemScreenBrightness(context: Context): Int {
            var values = 0
            try {
                values = Settings.System.getInt(context.contentResolver, Settings.System.SCREEN_BRIGHTNESS)
            } catch (e: Settings.SettingNotFoundException) {
                e.printStackTrace()
            }

            return values
        }

        /**
         * 设置系统亮度

         * @param brightness 返回的亮度值是处于0-255之间的整型数值
         */
        fun setScreenBrightness(activity: Activity, brightness: Int) {
            val window = activity.window
            val lp = window.attributes
            if (brightness == -1) {
                lp.screenBrightness = WindowManager.LayoutParams.BRIGHTNESS_OVERRIDE_NONE
            } else {
                lp.screenBrightness = (if (brightness <= 0) 1 else brightness) / 255f
            }
            window.attributes = lp
        }

        /**
         * 系统是否自动调节亮度
         * return true 是自动调节亮度   return false 不是自动调节亮度
         */
        fun isAutoBrightness(activity: Activity): Boolean {
            var autoBrightness = Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC
            try {
                autoBrightness = Settings.System.getInt(activity.contentResolver, Settings.System.SCREEN_BRIGHTNESS_MODE)
            } catch (e: Settings.SettingNotFoundException) {
                e.printStackTrace()
            }

            return autoBrightness == Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC
        }

        /**
         * 关闭系统自动调节亮度
         */
        fun stopAutoBrightness(activity: Activity) {
            Settings.System.putInt(activity.contentResolver, Settings.System.SCREEN_BRIGHTNESS_MODE,
                    Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL)
        }

        /**
         * 打开系统自动调节亮度
         */
        fun startAutoBrightness(activity: Activity) {
            Settings.System.putInt(activity.contentResolver, Settings.System.SCREEN_BRIGHTNESS_MODE,
                    Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC)
        }

        /**
         * 请求屏幕常亮

         * @param activity
         */
        fun requireScreenOn(activity: Activity) {
            activity.window.setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                    WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        }

        /**
         * 取消屏幕常亮

         * @param activity
         */
        fun releaseScreenOn(activity: Activity) {
            activity.window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        }

        //把一个毫秒数转化成时间字符串
        //格式为小时/分/秒/毫秒（如：24903600 –> 06小时55分03秒600毫秒）

        /**
         * @param millis   要转化的毫秒数。
         * *
         * @param isWhole  是否强制全部显示小时/分/秒/毫秒。
         * *
         * @param isFormat 时间数字是否要格式化，如果true：少位数前面补全；如果false：少位数前面不补全。
         * *
         * @return 返回时间字符串：小时/分/秒/毫秒的格式（如：24903600 --> 06小时55分03秒600毫秒）。
         */
        fun millisToString(millis: Long, isWhole: Boolean,
                           isFormat: Boolean): String {
            var h = ""
            var m = ""
            var s = ""
            var mi = ""
            if (isWhole) {
                h = if (isFormat) "00小时" else "0小时"
                m = if (isFormat) "00分" else "0分"
                s = if (isFormat) "00秒" else "0秒"
                mi = if (isFormat) "00毫秒" else "0毫秒"
            }

            var temp = millis

            val hper = (60 * 60 * 1000).toLong()
            val mper = (60 * 1000).toLong()
            val sper: Long = 1000

            if (temp / hper > 0) {
                if (isFormat) {
                    h = if (temp / hper < 10) "0" + temp / hper else (temp / hper).toString() + ""
                } else {
                    h = (temp / hper).toString() + ""
                }
                h += "小时"
            }
            temp = temp % hper

            if (temp / mper > 0) {
                if (isFormat) {
                    m = if (temp / mper < 10) "0" + temp / mper else (temp / mper).toString() + ""
                } else {
                    m = (temp / mper).toString() + ""
                }
                m += "分"
            }
            temp = temp % mper

            if (temp / sper > 0) {
                if (isFormat) {
                    s = if (temp / sper < 10) "0" + temp / sper else (temp / sper).toString() + ""
                } else {
                    s = (temp / sper).toString() + ""
                }
                s += "秒"
            }
            temp = temp % sper
            mi = temp.toString() + ""

            if (isFormat) {
                if (temp < 100 && temp >= 10) {
                    mi = "0" + temp
                }
                if (temp < 10) {
                    mi = "00" + temp
                }
            }

            mi += "毫秒"
            return h + m + s + mi
        }

        @JvmOverloads fun millisToStringMiddle(millis: Long, isWhole: Boolean,
                                               isFormat: Boolean, hUnit: String = "小时", mUnit: String = "分钟", sUnit: String = "秒"): String {
            var h = ""
            var m = ""
            var s = ""
            if (isWhole) {
                h = if (isFormat) "00" + hUnit else "0" + hUnit
                m = if (isFormat) "00" + mUnit else "0" + mUnit
                s = if (isFormat) "00" + sUnit else "0" + sUnit
            }

            var temp = millis

            val hper = (60 * 60 * 1000).toLong()
            val mper = (60 * 1000).toLong()
            val sper: Long = 1000

            if (temp / hper > 0) {
                if (isFormat) {
                    h = if (temp / hper < 10) "0" + temp / hper else (temp / hper).toString() + ""
                } else {
                    h = (temp / hper).toString() + ""
                }
                h += hUnit
            }
            temp = temp % hper

            if (temp / mper > 0) {
                if (isFormat) {
                    m = if (temp / mper < 10) "0" + temp / mper else (temp / mper).toString() + ""
                } else {
                    m = (temp / mper).toString() + ""
                }
                m += mUnit
            }
            temp = temp % mper

            if (temp / sper > 0) {
                if (isFormat) {
                    s = if (temp / sper < 10) "0" + temp / sper else (temp / sper).toString() + ""
                } else {
                    s = (temp / sper).toString() + ""
                }
                s += sUnit
            }
            return h + m + s
        }

        //把一个毫秒数转化成时间字符串。格式为小时/分/秒/毫秒（如：24903600 –> 06小时55分钟）

        /**
         * @param millis   要转化的毫秒数。
         * *
         * @param isWhole  是否强制全部显示小时/分。
         * *
         * @param isFormat 时间数字是否要格式化，如果true：少位数前面补全；如果false：少位数前面不补全。
         * *
         * @return 返回时间字符串：小时/分/秒/毫秒的格式（如：24903600 --> 06小时55分钟）。
         */
        fun millisToStringShort(millis: Long, isWhole: Boolean,
                                isFormat: Boolean): String {
            var h = ""
            var m = ""
            if (isWhole) {
                h = if (isFormat) "00小时" else "0小时"
                m = if (isFormat) "00分钟" else "0分钟"
            }

            var temp = millis

            val hper = (60 * 60 * 1000).toLong()
            val mper = (60 * 1000).toLong()
            val sper: Long = 1000

            if (temp / hper > 0) {
                if (isFormat) {
                    h = if (temp / hper < 10) "0" + temp / hper else (temp / hper).toString() + ""
                } else {
                    h = (temp / hper).toString() + ""
                }
                h += "小时"
            }
            temp = temp % hper

            if (temp / mper > 0) {
                if (isFormat) {
                    m = if (temp / mper < 10) "0" + temp / mper else (temp / mper).toString() + ""
                } else {
                    m = (temp / mper).toString() + ""
                }
                m += "分钟"
            }

            return h + m
        }


        //获取内置SD卡剩余容量
        val availableSize: Long
            get() {
                val file = Environment.getDataDirectory()
                return file.freeSpace
            }
    }
}//格式为小时/分/秒/毫秒（如：24903600 –> 06小时55分03秒）。
/**
 * @param millis   要转化的毫秒数。
 * *
 * @param isWhole  是否强制全部显示小时/分/秒/毫秒。
 * *
 * @param isFormat 时间数字是否要格式化，如果true：少位数前面补全；如果false：少位数前面不补全。
 * *
 * @return 返回时间字符串：小时/分/秒/毫秒的格式（如：24903600 --> 06小时55分03秒）。
 */
