package android.support.v4.app;

import java.util.Map;
import java.util.List;
import android.os.Parcelable;
import android.graphics.RectF;
import android.graphics.Matrix;
import android.view.View;
import android.net.Uri;
import android.content.Context;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.os.Build$VERSION;
import android.app.Activity;
import android.support.v4.content.ContextCompat;

public class ActivityCompat extends ContextCompat
{
    public ActivityCompat() {
        super();
    }
    
    private static ActivityCompat21.SharedElementCallback21 createCallback(final SharedElementCallback sharedElementCallback) {
        ActivityCompat21.SharedElementCallback21 sharedElementCallback2 = null;
        if (sharedElementCallback != null) {
            sharedElementCallback2 = new SharedElementCallback21Impl(sharedElementCallback);
        }
        return sharedElementCallback2;
    }
    
    public static void finishAffinity(final Activity activity) {
        if (Build$VERSION.SDK_INT >= 16) {
            ActivityCompatJB.finishAffinity(activity);
            return;
        }
        activity.finish();
    }
    
    public static void finishAfterTransition(final Activity activity) {
        if (Build$VERSION.SDK_INT >= 21) {
            ActivityCompat21.finishAfterTransition(activity);
            return;
        }
        activity.finish();
    }
    
    public static boolean invalidateOptionsMenu(final Activity activity) {
        if (Build$VERSION.SDK_INT >= 11) {
            ActivityCompatHoneycomb.invalidateOptionsMenu(activity);
            return true;
        }
        return false;
    }
    
    public static void postponeEnterTransition(final Activity activity) {
        if (Build$VERSION.SDK_INT >= 21) {
            ActivityCompat21.postponeEnterTransition(activity);
        }
    }
    
    public static void requestPermissions(@NonNull final Activity activity, @NonNull final String[] array, final int n) {
        if (Build$VERSION.SDK_INT >= 23) {
            ActivityCompatApi23.requestPermissions(activity, array, n);
        }
        else if (activity instanceof OnRequestPermissionsResultCallback) {
            new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
                final /* synthetic */ Activity val$activity;
                final /* synthetic */ String[] val$permissions;
                final /* synthetic */ int val$requestCode;
                
                ActivityCompat$1() {
                    super();
                }
                
                @Override
                public void run() {
                    final int[] array = new int[array.length];
                    final PackageManager packageManager = activity.getPackageManager();
                    final String packageName = activity.getPackageName();
                    for (int length = array.length, i = 0; i < length; ++i) {
                        array[i] = packageManager.checkPermission(array[i], packageName);
                    }
                    ((OnRequestPermissionsResultCallback)activity).onRequestPermissionsResult(n, array, array);
                }
            });
        }
    }
    
    public static void setEnterSharedElementCallback(final Activity activity, final SharedElementCallback sharedElementCallback) {
        if (Build$VERSION.SDK_INT >= 21) {
            ActivityCompat21.setEnterSharedElementCallback(activity, createCallback(sharedElementCallback));
        }
    }
    
    public static void setExitSharedElementCallback(final Activity activity, final SharedElementCallback sharedElementCallback) {
        if (Build$VERSION.SDK_INT >= 21) {
            ActivityCompat21.setExitSharedElementCallback(activity, createCallback(sharedElementCallback));
        }
    }
    
    public static boolean shouldShowRequestPermissionRationale(@NonNull final Activity activity, @NonNull final String s) {
        return Build$VERSION.SDK_INT >= 23 && ActivityCompatApi23.shouldShowRequestPermissionRationale(activity, s);
    }
    
    public static void startActivity(final Activity activity, final Intent intent, @Nullable final Bundle bundle) {
        if (Build$VERSION.SDK_INT >= 16) {
            ActivityCompatJB.startActivity((Context)activity, intent, bundle);
            return;
        }
        activity.startActivity(intent);
    }
    
    public static void startActivityForResult(final Activity activity, final Intent intent, final int n, @Nullable final Bundle bundle) {
        if (Build$VERSION.SDK_INT >= 16) {
            ActivityCompatJB.startActivityForResult(activity, intent, n, bundle);
            return;
        }
        activity.startActivityForResult(intent, n);
    }
    
    public static void startPostponedEnterTransition(final Activity activity) {
        if (Build$VERSION.SDK_INT >= 21) {
            ActivityCompat21.startPostponedEnterTransition(activity);
        }
    }
    
    public Uri getReferrer(final Activity activity) {
        Uri referrer;
        if (Build$VERSION.SDK_INT >= 22) {
            referrer = ActivityCompat22.getReferrer(activity);
        }
        else {
            final Intent intent = activity.getIntent();
            referrer = (Uri)intent.getParcelableExtra("android.intent.extra.REFERRER");
            if (referrer == null) {
                final String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                if (stringExtra != null) {
                    return Uri.parse(stringExtra);
                }
                return null;
            }
        }
        return referrer;
    }
}
