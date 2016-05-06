package android.support.v7.util;

import android.os.Looper;
import android.os.Handler;
import android.util.Log;
import android.support.v4.content.ParallelExecutorCompat;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class MessageThreadUtil<T> implements ThreadUtil<T>
{
    MessageThreadUtil() {
        super();
    }
    
    @Override
    public BackgroundCallback<T> getBackgroundProxy(final BackgroundCallback<T> backgroundCallback) {
        return new BackgroundCallback<T>() {
            private static final int LOAD_TILE = 3;
            private static final int RECYCLE_TILE = 4;
            private static final int REFRESH = 1;
            private static final int UPDATE_RANGE = 2;
            private Runnable mBackgroundRunnable = new Runnable() {
                final /* synthetic */ MessageThreadUtil$2 this$1;
                
                MessageThreadUtil$2$1() {
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
                                backgroundCallback.refresh(next.arg1);
                                continue;
                            case 2:
                                mQueue.removeMessages(2);
                                mQueue.removeMessages(3);
                                backgroundCallback.updateRange(next.arg1, next.arg2, next.arg3, next.arg4, next.arg5);
                                continue;
                            case 3:
                                backgroundCallback.loadTile(next.arg1, next.arg2);
                                continue;
                            case 4:
                                backgroundCallback.recycleTile((TileList.Tile)next.data);
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
            
            MessageThreadUtil$2() {
                this$0 = this$0;
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
        };
    }
    
    @Override
    public MainThreadCallback<T> getMainThreadProxy(final MainThreadCallback<T> mainThreadCallback) {
        return new MainThreadCallback<T>() {
            private static final int ADD_TILE = 2;
            private static final int REMOVE_TILE = 3;
            private static final int UPDATE_ITEM_COUNT = 1;
            private final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
            private Runnable mMainThreadRunnable = new Runnable() {
                final /* synthetic */ MessageThreadUtil$1 this$1;
                
                MessageThreadUtil$1$1() {
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
                                mainThreadCallback.updateItemCount(syncQueueItem.arg1, syncQueueItem.arg2);
                                break;
                            case 2:
                                mainThreadCallback.addTile(syncQueueItem.arg1, (TileList.Tile)syncQueueItem.data);
                                break;
                            case 3:
                                mainThreadCallback.removeTile(syncQueueItem.arg1, syncQueueItem.arg2);
                                break;
                        }
                    }
                }
            };
            private final MessageQueue mQueue = new MessageQueue();
            final /* synthetic */ MessageThreadUtil this$0;
            final /* synthetic */ MainThreadCallback val$callback;
            
            MessageThreadUtil$1() {
                this$0 = this$0;
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
        };
    }
}
