package android.support.v4.net;

import android.support.v4.net.TrafficStatsCompat$1;
import android.support.v4.net.TrafficStatsCompat$BaseTrafficStatsCompatImpl;
import android.support.v4.net.TrafficStatsCompat$BaseTrafficStatsCompatImpl$SocketTags;

class TrafficStatsCompat$BaseTrafficStatsCompatImpl$1 extends ThreadLocal<TrafficStatsCompat$BaseTrafficStatsCompatImpl$SocketTags> {
   TrafficStatsCompat$BaseTrafficStatsCompatImpl$1(TrafficStatsCompat$BaseTrafficStatsCompatImpl var1) {
      this.this$0 = var1;
   }

   protected TrafficStatsCompat$BaseTrafficStatsCompatImpl$SocketTags initialValue() {
      return new TrafficStatsCompat$BaseTrafficStatsCompatImpl$SocketTags((TrafficStatsCompat$1)null);
   }
}
