package android.support.v4.app;

import android.os.Build$VERSION;
import android.os.IBinder;
import android.os.Bundle;

public final class BundleCompat
{
    private BundleCompat() {
        super();
    }
    
    public static IBinder getBinder(final Bundle bundle, final String s) {
        if (Build$VERSION.SDK_INT >= 18) {
            return BundleCompatJellybeanMR2.getBinder(bundle, s);
        }
        return BundleCompatDonut.getBinder(bundle, s);
    }
    
    public static void putBinder(final Bundle bundle, final String s, final IBinder binder) {
        if (Build$VERSION.SDK_INT >= 18) {
            BundleCompatJellybeanMR2.putBinder(bundle, s, binder);
            return;
        }
        BundleCompatDonut.putBinder(bundle, s, binder);
    }
}
