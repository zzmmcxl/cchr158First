package android.support.v7.util;

static class SyncQueueItem
{
    private static SyncQueueItem sPool;
    private static final Object sPoolLock;
    public int arg1;
    public int arg2;
    public int arg3;
    public int arg4;
    public int arg5;
    public Object data;
    private SyncQueueItem next;
    public int what;
    
    static {
        sPoolLock = new Object();
    }
    
    SyncQueueItem() {
        super();
    }
    
    static /* synthetic */ SyncQueueItem access$200(final SyncQueueItem syncQueueItem) {
        return syncQueueItem.next;
    }
    
    static /* synthetic */ SyncQueueItem access$202(final SyncQueueItem syncQueueItem, final SyncQueueItem next) {
        return syncQueueItem.next = next;
    }
    
    static SyncQueueItem obtainMessage(final int n, final int n2, final int n3) {
        return obtainMessage(n, n2, n3, 0, 0, 0, null);
    }
    
    static SyncQueueItem obtainMessage(final int what, final int arg1, final int arg2, final int arg3, final int arg4, final int arg5, final Object data) {
        synchronized (sPoolLock) {
            SyncQueueItem sPool;
            if (SyncQueueItem.sPool == null) {
                sPool = new SyncQueueItem();
            }
            else {
                sPool = SyncQueueItem.sPool;
                SyncQueueItem.sPool = SyncQueueItem.sPool.next;
                sPool.next = null;
            }
            sPool.what = what;
            sPool.arg1 = arg1;
            sPool.arg2 = arg2;
            sPool.arg3 = arg3;
            sPool.arg4 = arg4;
            sPool.arg5 = arg5;
            sPool.data = data;
            return sPool;
        }
    }
    
    static SyncQueueItem obtainMessage(final int n, final int n2, final Object o) {
        return obtainMessage(n, n2, 0, 0, 0, 0, o);
    }
    
    void recycle() {
        next = null;
        arg5 = 0;
        arg4 = 0;
        arg3 = 0;
        arg2 = 0;
        arg1 = 0;
        what = 0;
        data = null;
        synchronized (sPoolLock) {
            if (sPool != null) {
                next = sPool;
            }
            sPool = this;
        }
    }
}
