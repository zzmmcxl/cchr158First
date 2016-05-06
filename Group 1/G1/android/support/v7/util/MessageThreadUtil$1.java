package android.support.v7.util;

import android.util.Log;
import android.os.Looper;
import android.os.Handler;

class MessageThreadUtil$1 implements MainThreadCallback<T> {
    private static final int ADD_TILE = 2;
    private static final int REMOVE_TILE = 3;
    private static final int UPDATE_ITEM_COUNT = 1;
    private final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
    private Runnable mMainThreadRunnable = new Runnable() {
        final /* synthetic */ MessageThreadUtil$1 this$1;
        
        MessageThreadUtil$1$1(final MessageThreadUtil$1 this$1) {
            this$1 = this$1;
            super();
        }
        
        @Override
        public void run() {
            for (SyncQueueItem syncQueueItem = mQueue.next(); syncQueueItem != null; syncQueueItem = mQueue.next()) {
                switch (syncQueueItem.what) {
                    default:
                        Log.e("ThreadUtil", "Unsupported message, what=" + syncQueueItem.what);
                        break;
                    case 1:
                        val$callback.updateItemCount(syncQueueItem.arg1, syncQueueItem.arg2);
                        break;
                    case 2:
                        val$callback.addTile(syncQueueItem.arg1, (TileList.Tile)syncQueueItem.data);
                        break;
                    case 3:
                        val$callback.removeTile(syncQueueItem.arg1, syncQueueItem.arg2);
                        break;
                }
            }
        }
    };
    private final MessageQueue mQueue = new MessageQueue();
    final /* synthetic */ MessageThreadUtil this$0;
    final /* synthetic */ MainThreadCallback val$callback;
    
    MessageThreadUtil$1(final MessageThreadUtil this$0, final MainThreadCallback val$callback) {
        this$0 = this$0;
        val$callback = val$callback;
        super();
    }
    
    static /* synthetic */ MessageQueue access$000(final MessageThreadUtil$1 mainThreadCallback) {
        return mainThreadCallback.mQueue;
    }
    
    private void sendMessage(final SyncQueueItem syncQueueItem) {
        mQueue.sendMessage(syncQueueItem);
        mMainThreadHandler.post(mMainThreadRunnable);
    }
    
    @Override
    public void addTile(final int n, final TileList.Tile<T> tile) {
        this.sendMessage(SyncQueueItem.obtainMessage(2, n, (Object)tile));
    }
    
    @Override
    public void removeTile(final int n, final int n2) {
        this.sendMessage(SyncQueueItem.obtainMessage(3, n, n2));
    }
    
    @Override
    public void updateItemCount(final int n, final int n2) {
        this.sendMessage(SyncQueueItem.obtainMessage(1, n, n2));
    }
}