package android.support.v4.app;

import android.support.annotation.NonNull;
import android.content.Context;
import android.os.Build$VERSION;

public final class AppOpsManagerCompat
{
    private static final AppOpsManagerImpl IMPL;
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_IGNORED = 1;
    
    static {
        if (Build$VERSION.SDK_INT >= 23) {
            IMPL = (AppOpsManagerImpl)new AppOpsManager23();
            return;
        }
        IMPL = new AppOpsManagerImpl();
    }
    
    private AppOpsManagerCompat() {
        super();
    }
    
    public static int noteOp(@NonNull final Context context, @NonNull final String s, final int n, @NonNull final String s2) {
        return IMPL.noteOp(context, s, n, s2);
    }
    
    public static int noteProxyOp(@NonNull final Context context, @NonNull final String s, @NonNull final String s2) {
        return IMPL.noteProxyOp(context, s, s2);
    }
    
    public static String permissionToOp(@NonNull final String s) {
        return IMPL.permissionToOp(s);
    }
}
