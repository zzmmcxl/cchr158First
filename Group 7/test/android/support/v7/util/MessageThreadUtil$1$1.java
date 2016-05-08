package android.support.v7.util;

import android.support.v7.util.MessageThreadUtil$1;
import android.support.v7.util.MessageThreadUtil$SyncQueueItem;
import android.support.v7.util.TileList$Tile;
import android.util.Log;

class MessageThreadUtil$1$1 implements Runnable {
   MessageThreadUtil$1$1(MessageThreadUtil$1 var1) {
      this.this$1 = var1;
   }

   public void run() {
      for(MessageThreadUtil$SyncQueueItem var1 = MessageThreadUtil$1.access$000(this.this$1).next(); var1 != null; var1 = MessageThreadUtil$1.access$000(this.this$1).next()) {
         switch(var1.what) {
         case 1:
            this.this$1.val$callback.updateItemCount(var1.arg1, var1.arg2);
            break;
         case 2:
            this.this$1.val$callback.addTile(var1.arg1, (TileList$Tile)var1.data);
            break;
         case 3:
            this.this$1.val$callback.removeTile(var1.arg1, var1.arg2);
            break;
         default:
            Log.e("ThreadUtil", "Unsupported message, what=" + var1.what);
         }
      }

   }
}
