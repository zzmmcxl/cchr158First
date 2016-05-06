package android.support.v4.app;

import android.app.ActivityManager;

class ActivityManagerCompatKitKat
{
    ActivityManagerCompatKitKat() {
        super();
    }
    
    public static boolean isLowRamDevice(final ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }
}
