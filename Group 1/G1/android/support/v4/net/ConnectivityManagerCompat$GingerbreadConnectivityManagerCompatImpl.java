package android.support.v4.net;

import android.net.ConnectivityManager;

static class GingerbreadConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl
{
    GingerbreadConnectivityManagerCompatImpl() {
        super();
    }
    
    @Override
    public boolean isActiveNetworkMetered(final ConnectivityManager connectivityManager) {
        return ConnectivityManagerCompatGingerbread.isActiveNetworkMetered(connectivityManager);
    }
}
