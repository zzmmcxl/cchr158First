package android.support.v7.util;

import android.support.v7.util.MessageThreadUtil$2;
import android.support.v7.util.MessageThreadUtil$SyncQueueItem;
import android.support.v7.util.TileList$Tile;
import android.util.Log;

class MessageThreadUtil$2$1 implements Runnable {
   MessageThreadUtil$2$1(MessageThreadUtil$2 var1) {
      this.this$1 = var1;
   }

   public void run() {
      while(true) {
         MessageThreadUtil$SyncQueueItem var1 = MessageThreadUtil$2.access$100(this.this$1).next();
         if(var1 == null) {
            this.this$1.mBackgroundRunning.set(false);
            return;
         }

         switch(var1.what) {
         case 1:
            MessageThreadUtil$2.access$100(this.this$1).removeMessages(1);
            this.this$1.val$callback.refresh(var1.arg1);
            break;
         case 2:
            MessageThreadUtil$2.access$100(this.this$1).removeMessages(2);
            MessageThreadUtil$2.access$100(this.this$1).removeMessages(3);
            this.this$1.val$callback.updateRange(var1.arg1, var1.arg2, var1.arg3, var1.arg4, var1.arg5);
            break;
         case 3:
            this.this$1.val$callback.loadTile(var1.arg1, var1.arg2);
            break;
         case 4:
            this.this$1.val$callback.recycleTile((TileList$Tile)var1.data);
            break;
         default:
            Log.e("ThreadUtil", "Unsupported message, what=" + var1.what);
         }
      }
   }
}
