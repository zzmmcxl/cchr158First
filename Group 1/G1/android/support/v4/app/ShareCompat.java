package android.support.v4.app;

import android.text.Spanned;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.util.Log;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.support.annotation.StringRes;
import android.os.Parcelable;
import android.net.Uri;
import android.content.Intent;
import java.util.ArrayList;
import android.content.ComponentName;
import android.app.Activity;
import android.view.MenuItem;
import android.view.Menu;
import android.os.Build$VERSION;

public final class ShareCompat
{
    public static final String EXTRA_CALLING_ACTIVITY = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_PACKAGE = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
    private static ShareCompatImpl IMPL;
    
    static {
        if (Build$VERSION.SDK_INT >= 16) {
            IMPL = (ShareCompatImpl)new ShareCompatImplJB();
            return;
        }
        if (Build$VERSION.SDK_INT >= 14) {
            IMPL = (ShareCompatImpl)new ShareCompatImplICS();
            return;
        }
        IMPL = (ShareCompatImpl)new ShareCompatImplBase();
    }
    
    private ShareCompat() {
        super();
    }
    
    static /* synthetic */ ShareCompatImpl access$000() {
        return IMPL;
    }
    
    public static void configureMenuItem(final Menu menu, final int n, final IntentBuilder intentBuilder) {
        final MenuItem item = menu.findItem(n);
        if (item == null) {
            throw new IllegalArgumentException("Could not find menu item with id " + n + " in the supplied menu");
        }
        configureMenuItem(item, intentBuilder);
    }
    
    public static void configureMenuItem(final MenuItem menuItem, final IntentBuilder intentBuilder) {
        IMPL.configureMenuItem(menuItem, intentBuilder);
    }
    
    public static ComponentName getCallingActivity(final Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity == null) {
            callingActivity = (ComponentName)activity.getIntent().getParcelableExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY");
        }
        return callingActivity;
    }
    
    public static String getCallingPackage(final Activity activity) {
        String s = activity.getCallingPackage();
        if (s == null) {
            s = activity.getIntent().getStringExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE");
        }
        return s;
    }
}
