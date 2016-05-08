package android.support.v7.util;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.util.MessageThreadUtil;
import android.support.v7.util.MessageThreadUtil$1$1;
import android.support.v7.util.MessageThreadUtil$MessageQueue;
import android.support.v7.util.MessageThreadUtil$SyncQueueItem;
import android.support.v7.util.ThreadUtil$MainThreadCallback;
import android.support.v7.util.TileList$Tile;

class MessageThreadUtil$1 implements ThreadUtil$MainThreadCallback<T> {
   private static final int ADD_TILE = 2;
   private static final int REMOVE_TILE = 3;
   private static final int UPDATE_ITEM_COUNT = 1;
   private final Handler mMainThreadHandler;
   private Runnable mMainThreadRunnable;
   private final MessageThreadUtil$MessageQueue mQueue;

   MessageThreadUtil$1(MessageThreadUtil var1, ThreadUtil$MainThreadCallback var2) {
      this.this$0 = var1;
      this.val$callback = var2;
      this.mQueue = new MessageThreadUtil$MessageQueue();
      this.mMainThreadHandler = new Handler(Looper.getMainLooper());
      this.mMainThreadRunnable = new MessageThreadUtil$1$1(this);
   }

   private void sendMessage(MessageThreadUtil$SyncQueueItem var1) {
      this.mQueue.sendMessage(var1);
      this.mMainThreadHandler.post(this.mMainThreadRunnable);
   }

   public void addTile(int var1, TileList$Tile<T> var2) {
      this.sendMessage(MessageThreadUtil$SyncQueueItem.obtainMessage(2, var1, var2));
   }

   public void removeTile(int var1, int var2) {
      this.sendMessage(MessageThreadUtil$SyncQueueItem.obtainMessage(3, var1, var2));
   }

   public void updateItemCount(int var1, int var2) {
      this.sendMessage(MessageThreadUtil$SyncQueueItem.obtainMessage(1, var1, var2));
   }
}
