package android.support.v4.net;

import android.net.NetworkInfo;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build$VERSION;

public final class ConnectivityManagerCompat
{
    private static final ConnectivityManagerCompatImpl IMPL;
    
    static {
        if (Build$VERSION.SDK_INT >= 16) {
            IMPL = (ConnectivityManagerCompatImpl)new JellyBeanConnectivityManagerCompatImpl();
            return;
        }
        if (Build$VERSION.SDK_INT >= 13) {
            IMPL = (ConnectivityManagerCompatImpl)new HoneycombMR2ConnectivityManagerCompatImpl();
            return;
        }
        if (Build$VERSION.SDK_INT >= 8) {
            IMPL = (ConnectivityManagerCompatImpl)new GingerbreadConnectivityManagerCompatImpl();
            return;
        }
        IMPL = (ConnectivityManagerCompatImpl)new BaseConnectivityManagerCompatImpl();
    }
    
    private ConnectivityManagerCompat() {
        super();
    }
    
    public static NetworkInfo getNetworkInfoFromBroadcast(final ConnectivityManager connectivityManager, final Intent intent) {
        final NetworkInfo networkInfo = (NetworkInfo)intent.getParcelableExtra("networkInfo");
        if (networkInfo != null) {
            return connectivityManager.getNetworkInfo(networkInfo.getType());
        }
        return null;
    }
    
    public static boolean isActiveNetworkMetered(final ConnectivityManager connectivityManager) {
        return IMPL.isActiveNetworkMetered(connectivityManager);
    }
}
