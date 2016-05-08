package android.support.v4.net;

import android.net.ConnectivityManager;
import android.support.v4.net.ConnectivityManagerCompat$ConnectivityManagerCompatImpl;
import android.support.v4.net.ConnectivityManagerCompatGingerbread;

class ConnectivityManagerCompat$GingerbreadConnectivityManagerCompatImpl implements ConnectivityManagerCompat$ConnectivityManagerCompatImpl {
   public boolean isActiveNetworkMetered(ConnectivityManager var1) {
      return ConnectivityManagerCompatGingerbread.isActiveNetworkMetered(var1);
   }
}
