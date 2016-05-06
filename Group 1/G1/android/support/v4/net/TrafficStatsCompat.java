package android.support.v4.net;

import java.net.SocketException;
import java.net.Socket;
import android.os.Build$VERSION;

public final class TrafficStatsCompat
{
    private static final TrafficStatsCompatImpl IMPL;
    
    static {
        if (Build$VERSION.SDK_INT >= 14) {
            IMPL = (TrafficStatsCompatImpl)new IcsTrafficStatsCompatImpl();
            return;
        }
        IMPL = (TrafficStatsCompatImpl)new BaseTrafficStatsCompatImpl();
    }
    
    private TrafficStatsCompat() {
        super();
    }
    
    public static void clearThreadStatsTag() {
        IMPL.clearThreadStatsTag();
    }
    
    public static int getThreadStatsTag() {
        return IMPL.getThreadStatsTag();
    }
    
    public static void incrementOperationCount(final int n) {
        IMPL.incrementOperationCount(n);
    }
    
    public static void incrementOperationCount(final int n, final int n2) {
        IMPL.incrementOperationCount(n, n2);
    }
    
    public static void setThreadStatsTag(final int threadStatsTag) {
        IMPL.setThreadStatsTag(threadStatsTag);
    }
    
    public static void tagSocket(final Socket socket) throws SocketException {
        IMPL.tagSocket(socket);
    }
    
    public static void untagSocket(final Socket socket) throws SocketException {
        IMPL.untagSocket(socket);
    }
}
