package android.support.v4.net;

import java.net.Socket;

static class BaseTrafficStatsCompatImpl implements TrafficStatsCompatImpl
{
    private ThreadLocal<SocketTags> mThreadSocketTags;
    
    BaseTrafficStatsCompatImpl() {
        super();
        this.mThreadSocketTags = new ThreadLocal<SocketTags>() {
            final /* synthetic */ BaseTrafficStatsCompatImpl this$0;
            
            TrafficStatsCompat$BaseTrafficStatsCompatImpl$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            protected SocketTags initialValue() {
                return new SocketTags();
            }
            
            @Override
            protected /* bridge */ Object initialValue() {
                return this.initialValue();
            }
        };
    }
    
    @Override
    public void clearThreadStatsTag() {
        ((SocketTags)mThreadSocketTags.get()).statsTag = -1;
    }
    
    @Override
    public int getThreadStatsTag() {
        return ((SocketTags)mThreadSocketTags.get()).statsTag;
    }
    
    @Override
    public void incrementOperationCount(final int n) {
    }
    
    @Override
    public void incrementOperationCount(final int n, final int n2) {
    }
    
    @Override
    public void setThreadStatsTag(final int statsTag) {
        ((SocketTags)mThreadSocketTags.get()).statsTag = statsTag;
    }
    
    @Override
    public void tagSocket(final Socket socket) {
    }
    
    @Override
    public void untagSocket(final Socket socket) {
    }
}
