package android.support.v4.content;

import android.content.Intent;
import android.content.ComponentName;
import android.os.Build$VERSION;

public final class IntentCompat
{
    public static final String ACTION_EXTERNAL_APPLICATIONS_AVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";
    public static final String ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";
    public static final String EXTRA_CHANGED_PACKAGE_LIST = "android.intent.extra.changed_package_list";
    public static final String EXTRA_CHANGED_UID_LIST = "android.intent.extra.changed_uid_list";
    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    public static final int FLAG_ACTIVITY_CLEAR_TASK = 32768;
    public static final int FLAG_ACTIVITY_TASK_ON_HOME = 16384;
    private static final IntentCompatImpl IMPL;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 15) {
            IMPL = (IntentCompatImpl)new IntentCompatImplIcsMr1();
            return;
        }
        if (sdk_INT >= 11) {
            IMPL = (IntentCompatImpl)new IntentCompatImplHC();
            return;
        }
        IMPL = (IntentCompatImpl)new IntentCompatImplBase();
    }
    
    private IntentCompat() {
        super();
    }
    
    public static Intent makeMainActivity(final ComponentName componentName) {
        return IMPL.makeMainActivity(componentName);
    }
    
    public static Intent makeMainSelectorActivity(final String s, final String s2) {
        return IMPL.makeMainSelectorActivity(s, s2);
    }
    
    public static Intent makeRestartActivityTask(final ComponentName componentName) {
        return IMPL.makeRestartActivityTask(componentName);
    }
}
