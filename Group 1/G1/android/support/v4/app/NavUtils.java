package android.support.v4.app;

import android.util.Log;
import android.content.pm.ActivityInfo;
import android.support.annotation.Nullable;
import android.content.pm.PackageManager$NameNotFoundException;
import android.support.v4.content.IntentCompat;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.app.Activity;
import android.os.Build$VERSION;

public final class NavUtils
{
    private static final NavUtilsImpl IMPL;
    public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
    private static final String TAG = "NavUtils";
    
    static {
        if (Build$VERSION.SDK_INT >= 16) {
            IMPL = (NavUtilsImpl)new NavUtilsImplJB();
            return;
        }
        IMPL = (NavUtilsImpl)new NavUtilsImplBase();
    }
    
    private NavUtils() {
        super();
    }
    
    public static Intent getParentActivityIntent(final Activity activity) {
        return IMPL.getParentActivityIntent(activity);
    }
    
    public static Intent getParentActivityIntent(final Context context, final ComponentName componentName) throws PackageManager$NameNotFoundException {
        final String parentActivityName = getParentActivityName(context, componentName);
        if (parentActivityName == null) {
            return null;
        }
        final ComponentName component = new ComponentName(componentName.getPackageName(), parentActivityName);
        if (getParentActivityName(context, component) == null) {
            return IntentCompat.makeMainActivity(component);
        }
        return new Intent().setComponent(component);
    }
    
    public static Intent getParentActivityIntent(final Context context, final Class<?> clazz) throws PackageManager$NameNotFoundException {
        final String parentActivityName = getParentActivityName(context, new ComponentName(context, (Class)clazz));
        if (parentActivityName == null) {
            return null;
        }
        final ComponentName component = new ComponentName(context, parentActivityName);
        if (getParentActivityName(context, component) == null) {
            return IntentCompat.makeMainActivity(component);
        }
        return new Intent().setComponent(component);
    }
    
    @Nullable
    public static String getParentActivityName(final Activity activity) {
        try {
            return getParentActivityName((Context)activity, activity.getComponentName());
        }
        catch (PackageManager$NameNotFoundException ex) {
            throw new IllegalArgumentException((Throwable)ex);
        }
    }
    
    @Nullable
    public static String getParentActivityName(final Context context, final ComponentName componentName) throws PackageManager$NameNotFoundException {
        return IMPL.getParentActivityName(context, context.getPackageManager().getActivityInfo(componentName, 128));
    }
    
    public static void navigateUpFromSameTask(final Activity activity) {
        final Intent parentActivityIntent = getParentActivityIntent(activity);
        if (parentActivityIntent == null) {
            throw new IllegalArgumentException("Activity " + activity.getClass().getSimpleName() + " does not have a parent activity name specified." + " (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data> " + " element in your manifest?)");
        }
        navigateUpTo(activity, parentActivityIntent);
    }
    
    public static void navigateUpTo(final Activity activity, final Intent intent) {
        IMPL.navigateUpTo(activity, intent);
    }
    
    public static boolean shouldUpRecreateTask(final Activity activity, final Intent intent) {
        return IMPL.shouldUpRecreateTask(activity, intent);
    }
}
