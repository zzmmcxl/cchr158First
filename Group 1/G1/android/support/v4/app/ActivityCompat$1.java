package android.support.v4.app;

import android.content.pm.PackageManager;
import android.app.Activity;

static final class ActivityCompat$1 implements Runnable {
    final /* synthetic */ Activity val$activity;
    final /* synthetic */ String[] val$permissions;
    final /* synthetic */ int val$requestCode;
    
    ActivityCompat$1(final String[] val$permissions, final Activity val$activity, final int val$requestCode) {
        this.val$permissions = val$permissions;
        this.val$activity = val$activity;
        this.val$requestCode = val$requestCode;
        super();
    }
    
    @Override
    public void run() {
        final int[] array = new int[val$permissions.length];
        final PackageManager packageManager = val$activity.getPackageManager();
        final String packageName = val$activity.getPackageName();
        for (int length = val$permissions.length, i = 0; i < length; ++i) {
            array[i] = packageManager.checkPermission(val$permissions[i], packageName);
        }
        ((OnRequestPermissionsResultCallback)val$activity).onRequestPermissionsResult(val$requestCode, val$permissions, array);
    }
}