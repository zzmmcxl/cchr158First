package android.support.v7.util;

import android.support.v7.util.MessageThreadUtil$SyncQueueItem;

class MessageThreadUtil$MessageQueue {
   private MessageThreadUtil$SyncQueueItem mRoot;

   MessageThreadUtil$SyncQueueItem next() {
      // $FF: Couldn't be decompiled
   }

   void removeMessages(int param1) {
      // $FF: Couldn't be decompiled
   }

   void sendMessage(MessageThreadUtil$SyncQueueItem param1) {
      // $FF: Couldn't be decompiled
   }

   void sendMessageAtFrontOfQueue(MessageThreadUtil$SyncQueueItem var1) {
      synchronized(this){}
      boolean var3 = false;

      try {
         var3 = true;
         MessageThreadUtil$SyncQueueItem.access$202(var1, this.mRoot);
         this.mRoot = var1;
         var3 = false;
      } finally {
         if(var3) {
            ;
         }
      }

   }
}
