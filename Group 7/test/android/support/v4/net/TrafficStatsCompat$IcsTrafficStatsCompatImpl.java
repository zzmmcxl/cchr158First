package android.support.v4.net;

import android.support.v4.net.TrafficStatsCompat$TrafficStatsCompatImpl;
import android.support.v4.net.TrafficStatsCompatIcs;
import java.net.Socket;
import java.net.SocketException;

class TrafficStatsCompat$IcsTrafficStatsCompatImpl implements TrafficStatsCompat$TrafficStatsCompatImpl {
   public void clearThreadStatsTag() {
      TrafficStatsCompatIcs.clearThreadStatsTag();
   }

   public int getThreadStatsTag() {
      return TrafficStatsCompatIcs.getThreadStatsTag();
   }

   public void incrementOperationCount(int var1) {
      TrafficStatsCompatIcs.incrementOperationCount(var1);
   }

   public void incrementOperationCount(int var1, int var2) {
      TrafficStatsCompatIcs.incrementOperationCount(var1, var2);
   }

   public void setThreadStatsTag(int var1) {
      TrafficStatsCompatIcs.setThreadStatsTag(var1);
   }

   public void tagSocket(Socket var1) throws SocketException {
      TrafficStatsCompatIcs.tagSocket(var1);
   }

   public void untagSocket(Socket var1) throws SocketException {
      TrafficStatsCompatIcs.untagSocket(var1);
   }
}
