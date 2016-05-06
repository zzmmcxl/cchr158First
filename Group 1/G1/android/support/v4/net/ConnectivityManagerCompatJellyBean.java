package android.support.v4.net;

import android.net.ConnectivityManager;

class ConnectivityManagerCompatJellyBean
{
    ConnectivityManagerCompatJellyBean() {
        super();
    }
    
    public static boolean isActiveNetworkMetered(final ConnectivityManager connectivityManager) {
        return connectivityManager.isActiveNetworkMetered();
    }
}
