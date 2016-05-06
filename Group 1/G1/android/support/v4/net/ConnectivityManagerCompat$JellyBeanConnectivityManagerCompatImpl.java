package android.support.v4.net;

import android.net.ConnectivityManager;

static class JellyBeanConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl
{
    JellyBeanConnectivityManagerCompatImpl() {
        super();
    }
    
    @Override
    public boolean isActiveNetworkMetered(final ConnectivityManager connectivityManager) {
        return ConnectivityManagerCompatJellyBean.isActiveNetworkMetered(connectivityManager);
    }
}
