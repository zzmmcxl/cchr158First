package android.support.v4.app;

import android.os.IBinder;
import android.os.Bundle;

class BundleCompatJellybeanMR2
{
    BundleCompatJellybeanMR2() {
        super();
    }
    
    public static IBinder getBinder(final Bundle bundle, final String s) {
        return bundle.getBinder(s);
    }
    
    public static void putBinder(final Bundle bundle, final String s, final IBinder binder) {
        bundle.putBinder(s, binder);
    }
}
