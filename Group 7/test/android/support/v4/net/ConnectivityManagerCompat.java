package android.support.v4.net;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.support.v4.net.ConnectivityManagerCompat$BaseConnectivityManagerCompatImpl;
import android.support.v4.net.ConnectivityManagerCompat$ConnectivityManagerCompatImpl;
import android.support.v4.net.ConnectivityManagerCompat$GingerbreadConnectivityManagerCompatImpl;
import android.support.v4.net.ConnectivityManagerCompat$HoneycombMR2ConnectivityManagerCompatImpl;
import android.support.v4.net.ConnectivityManagerCompat$JellyBeanConnectivityManagerCompatImpl;

public final class ConnectivityManagerCompat {
   private static final ConnectivityManagerCompat$ConnectivityManagerCompatImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 16) {
         IMPL = new ConnectivityManagerCompat$JellyBeanConnectivityManagerCompatImpl();
      } else if(VERSION.SDK_INT >= 13) {
         IMPL = new ConnectivityManagerCompat$HoneycombMR2ConnectivityManagerCompatImpl();
      } else if(VERSION.SDK_INT >= 8) {
         IMPL = new ConnectivityManagerCompat$GingerbreadConnectivityManagerCompatImpl();
      } else {
         IMPL = new ConnectivityManagerCompat$BaseConnectivityManagerCompatImpl();
      }
   }

   public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager var0, Intent var1) {
      NetworkInfo var2 = (NetworkInfo)var1.getParcelableExtra("networkInfo");
      return var2 != null?var0.getNetworkInfo(var2.getType()):null;
   }

   public static boolean isActiveNetworkMetered(ConnectivityManager var0) {
      return IMPL.isActiveNetworkMetered(var0);
   }
}
