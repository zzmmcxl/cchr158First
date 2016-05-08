package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.net.ConnectivityManagerCompat$ConnectivityManagerCompatImpl;

class ConnectivityManagerCompat$BaseConnectivityManagerCompatImpl implements ConnectivityManagerCompat$ConnectivityManagerCompatImpl {
   public boolean isActiveNetworkMetered(ConnectivityManager var1) {
      NetworkInfo var2 = var1.getActiveNetworkInfo();
      if(var2 != null) {
         switch(var2.getType()) {
         case 0:
            break;
         case 1:
            return false;
         default:
            return true;
         }
      }

      return true;
   }
}
