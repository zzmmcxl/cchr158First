package android.support.v4.app;

import android.content.Context;

private static class AppOpsManagerImpl
{
    private AppOpsManagerImpl() {
        super();
    }
    
    AppOpsManagerImpl(final AppOpsManagerCompat$1 object) {
        this();
    }
    
    public int noteOp(final Context context, final String s, final int n, final String s2) {
        return 1;
    }
    
    public int noteProxyOp(final Context context, final String s, final String s2) {
        return 1;
    }
    
    public String permissionToOp(final String s) {
        return null;
    }
}
