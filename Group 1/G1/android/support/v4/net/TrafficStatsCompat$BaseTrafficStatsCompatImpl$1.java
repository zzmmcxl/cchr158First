package android.support.v4.net;

class TrafficStatsCompat$BaseTrafficStatsCompatImpl$1 extends ThreadLocal<SocketTags> {
    final /* synthetic */ BaseTrafficStatsCompatImpl this$0;
    
    TrafficStatsCompat$BaseTrafficStatsCompatImpl$1(final BaseTrafficStatsCompatImpl this$0) {
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
}