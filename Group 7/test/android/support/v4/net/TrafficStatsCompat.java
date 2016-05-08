package android.support.v4.net;

import android.os.Build.VERSION;
import android.support.v4.net.TrafficStatsCompat$BaseTrafficStatsCompatImpl;
import android.support.v4.net.TrafficStatsCompat$IcsTrafficStatsCompatImpl;
import android.support.v4.net.TrafficStatsCompat$TrafficStatsCompatImpl;
import java.net.Socket;
import java.net.SocketException;

public final class TrafficStatsCompat {
   private static final TrafficStatsCompat$TrafficStatsCompatImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 14) {
         IMPL = new TrafficStatsCompat$IcsTrafficStatsCompatImpl();
      } else {
         IMPL = new TrafficStatsCompat$BaseTrafficStatsCompatImpl();
      }
   }

   public static void clearThreadStatsTag() {
      IMPL.clearThreadStatsTag();
   }

   public static int getThreadStatsTag() {
      return IMPL.getThreadStatsTag();
   }

   public static void incrementOperationCount(int var0) {
      IMPL.incrementOperationCount(var0);
   }

   public static void incrementOperationCount(int var0, int var1) {
      IMPL.incrementOperationCount(var0, var1);
   }

   public static void setThreadStatsTag(int var0) {
      IMPL.setThreadStatsTag(var0);
   }

   public static void tagSocket(Socket var0) throws SocketException {
      IMPL.tagSocket(var0);
   }

   public static void untagSocket(Socket var0) throws SocketException {
      IMPL.untagSocket(var0);
   }
}
