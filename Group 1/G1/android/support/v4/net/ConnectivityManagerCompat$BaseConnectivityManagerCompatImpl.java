package android.support.v4.net;

import android.net.NetworkInfo;
import android.net.ConnectivityManager;

static class BaseConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl
{
    BaseConnectivityManagerCompatImpl() {
        super();
    }
    
    @Override
    public boolean isActiveNetworkMetered(final ConnectivityManager connectivityManager) {
        final NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            switch (activeNetworkInfo.getType()) {
                case 0:
                    break;
                default:
                    return true;
                case 1:
                    return false;
            }
        }
        return true;
    }
}
