package android.support.v4.net;

import android.net.ConnectivityManager;
import android.support.v4.net.ConnectivityManagerCompat$ConnectivityManagerCompatImpl;
import android.support.v4.net.ConnectivityManagerCompatHoneycombMR2;

class ConnectivityManagerCompat$HoneycombMR2ConnectivityManagerCompatImpl implements ConnectivityManagerCompat$ConnectivityManagerCompatImpl {
   public boolean isActiveNetworkMetered(ConnectivityManager var1) {
      return ConnectivityManagerCompatHoneycombMR2.isActiveNetworkMetered(var1);
   }
}
