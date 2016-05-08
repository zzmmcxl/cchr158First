package android.support.v4.net;

import java.net.Socket;
import java.net.SocketException;

interface TrafficStatsCompat$TrafficStatsCompatImpl {
   void clearThreadStatsTag();

   int getThreadStatsTag();

   void incrementOperationCount(int var1);

   void incrementOperationCount(int var1, int var2);

   void setThreadStatsTag(int var1);

   void tagSocket(Socket var1) throws SocketException;

   void untagSocket(Socket var1) throws SocketException;
}
