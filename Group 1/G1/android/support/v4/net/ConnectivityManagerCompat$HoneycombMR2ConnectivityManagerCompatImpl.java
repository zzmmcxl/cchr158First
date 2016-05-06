package android.support.v4.net;

import android.net.ConnectivityManager;

static class HoneycombMR2ConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl
{
    HoneycombMR2ConnectivityManagerCompatImpl() {
        super();
    }
    
    @Override
    public boolean isActiveNetworkMetered(final ConnectivityManager connectivityManager) {
        return ConnectivityManagerCompatHoneycombMR2.isActiveNetworkMetered(connectivityManager);
    }
}
