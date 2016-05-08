package android.support.v7.util;

import android.support.v4.content.ParallelExecutorCompat;
import android.support.v7.util.MessageThreadUtil;
import android.support.v7.util.MessageThreadUtil$2$1;
import android.support.v7.util.MessageThreadUtil$MessageQueue;
import android.support.v7.util.MessageThreadUtil$SyncQueueItem;
import android.support.v7.util.ThreadUtil$BackgroundCallback;
import android.support.v7.util.TileList$Tile;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class MessageThreadUtil$2 implements ThreadUtil$BackgroundCallback<T> {
   private static final int LOAD_TILE = 3;
   private static final int RECYCLE_TILE = 4;
   private static final int REFRESH = 1;
   private static final int UPDATE_RANGE = 2;
   private Runnable mBackgroundRunnable;
   AtomicBoolean mBackgroundRunning;
   private final Executor mExecutor;
   private final MessageThreadUtil$MessageQueue mQueue;

   MessageThreadUtil$2(MessageThreadUtil var1, ThreadUtil$BackgroundCallback var2) {
      this.this$0 = var1;
      this.val$callback = var2;
      this.mQueue = new MessageThreadUtil$MessageQueue();
      this.mExecutor = ParallelExecutorCompat.getParallelExecutor();
      this.mBackgroundRunning = new AtomicBoolean(false);
      this.mBackgroundRunnable = new MessageThreadUtil$2$1(this);
   }

   private void maybeExecuteBackgroundRunnable() {
      if(this.mBackgroundRunning.compareAndSet(false, true)) {
         this.mExecutor.execute(this.mBackgroundRunnable);
      }

   }

   private void sendMessage(MessageThreadUtil$SyncQueueItem var1) {
      this.mQueue.sendMessage(var1);
      this.maybeExecuteBackgroundRunnable();
   }

   private void sendMessageAtFrontOfQueue(MessageThreadUtil$SyncQueueItem var1) {
      this.mQueue.sendMessageAtFrontOfQueue(var1);
      this.maybeExecuteBackgroundRunnable();
   }

   public void loadTile(int var1, int var2) {
      this.sendMessage(MessageThreadUtil$SyncQueueItem.obtainMessage(3, var1, var2));
   }

   public void recycleTile(TileList$Tile<T> var1) {
      this.sendMessage(MessageThreadUtil$SyncQueueItem.obtainMessage(4, 0, var1));
   }

   public void refresh(int var1) {
      this.sendMessageAtFrontOfQueue(MessageThreadUtil$SyncQueueItem.obtainMessage(1, var1, (Object)null));
   }

   public void updateRange(int var1, int var2, int var3, int var4, int var5) {
      this.sendMessageAtFrontOfQueue(MessageThreadUtil$SyncQueueItem.obtainMessage(2, var1, var2, var3, var4, var5, (Object)null));
   }
}
