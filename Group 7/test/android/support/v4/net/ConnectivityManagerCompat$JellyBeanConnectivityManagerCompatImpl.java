package android.support.v4.net;

import android.net.ConnectivityManager;
import android.support.v4.net.ConnectivityManagerCompat$ConnectivityManagerCompatImpl;
import android.support.v4.net.ConnectivityManagerCompatJellyBean;

class ConnectivityManagerCompat$JellyBeanConnectivityManagerCompatImpl implements ConnectivityManagerCompat$ConnectivityManagerCompatImpl {
   public boolean isActiveNetworkMetered(ConnectivityManager var1) {
      return ConnectivityManagerCompatJellyBean.isActiveNetworkMetered(var1);
   }
}
