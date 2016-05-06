package android.support.v4.app;

import android.app.Activity;

class ActivityCompatApi23
{
    ActivityCompatApi23() {
        super();
    }
    
    public static void requestPermissions(final Activity activity, final String[] array, final int n) {
        if (activity instanceof RequestPermissionsRequestCodeValidator) {
            ((RequestPermissionsRequestCodeValidator)activity).validateRequestPermissionsRequestCode(n);
        }
        activity.requestPermissions(array, n);
    }
    
    public static boolean shouldShowRequestPermissionRationale(final Activity activity, final String s) {
        return activity.shouldShowRequestPermissionRationale(s);
    }
}
