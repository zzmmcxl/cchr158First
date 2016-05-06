package android.support.v7.util;

import android.util.Log;
import android.support.v4.content.ParallelExecutorCompat;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class MessageThreadUtil$2 implements BackgroundCallback<T> {
    private static final int LOAD_TILE = 3;
    private static final int RECYCLE_TILE = 4;
    private static final int REFRESH = 1;
    private static final int UPDATE_RANGE = 2;
    private Runnable mBackgroundRunnable = new Runnable() {
        final /* synthetic */ MessageThreadUtil$2 this$1;
        
        MessageThreadUtil$2$1(final MessageThreadUtil$2 this$1) {
            this$1 = this$1;
            super();
        }
        
        @Override
        public void run() {
            while (true) {
                final SyncQueueItem next = mQueue.next();
                if (next == null) {
                    break;
                }
                switch (next.what) {
                    default:
                        Log.e("ThreadUtil", "Unsupported message, what=" + next.what);
                        continue;
                    case 1:
                        mQueue.removeMessages(1);
                        val$callback.refresh(next.arg1);
                        continue;
                    case 2:
                        mQueue.removeMessages(2);
                        mQueue.removeMessages(3);
                        val$callback.updateRange(next.arg1, next.arg2, next.arg3, next.arg4, next.arg5);
                        continue;
                    case 3:
                        val$callback.loadTile(next.arg1, next.arg2);
                        continue;
                    case 4:
                        val$callback.recycleTile((TileList.Tile)next.data);
                        continue;
                }
            }
            mBackgroundRunning.set(false);
        }
    };
    AtomicBoolean mBackgroundRunning = new AtomicBoolean(false);
    private final Executor mExecutor = ParallelExecutorCompat.getParallelExecutor();
    private final MessageQueue mQueue = new MessageQueue();
    final /* synthetic */ MessageThreadUtil this$0;
    final /* synthetic */ BackgroundCallback val$callback;
    
    MessageThreadUtil$2(final MessageThreadUtil this$0, final BackgroundCallback val$callback) {
        this$0 = this$0;
        val$callback = val$callback;
        super();
    }
    
    static /* synthetic */ MessageQueue access$100(final MessageThreadUtil$2 backgroundCallback) {
        return backgroundCallback.mQueue;
    }
    
    private void maybeExecuteBackgroundRunnable() {
        if (mBackgroundRunning.compareAndSet(false, true)) {
            mExecutor.execute(mBackgroundRunnable);
        }
    }
    
    private void sendMessage(final SyncQueueItem syncQueueItem) {
        mQueue.sendMessage(syncQueueItem);
        this.maybeExecuteBackgroundRunnable();
    }
    
    private void sendMessageAtFrontOfQueue(final SyncQueueItem syncQueueItem) {
        mQueue.sendMessageAtFrontOfQueue(syncQueueItem);
        this.maybeExecuteBackgroundRunnable();
    }
    
    @Override
    public void loadTile(final int n, final int n2) {
        this.sendMessage(SyncQueueItem.obtainMessage(3, n, n2));
    }
    
    @Override
    public void recycleTile(final TileList.Tile<T> tile) {
        this.sendMessage(SyncQueueItem.obtainMessage(4, 0, (Object)tile));
    }
    
    @Override
    public void refresh(final int n) {
        this.sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(1, n, (Object)null));
    }
    
    @Override
    public void updateRange(final int n, final int n2, final int n3, final int n4, final int n5) {
        this.sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(2, n, n2, n3, n4, n5, (Object)null));
    }
}