package android.support.v7.util;

import android.util.Log;

class MessageThreadUtil$1$1 implements Runnable {
    final /* synthetic */ MessageThreadUtil$1 this$1;
    
    MessageThreadUtil$1$1(final MessageThreadUtil$1 this$1) {
        this$1 = this$1;
        super();
    }
    
    @Override
    public void run() {
        for (SyncQueueItem syncQueueItem = MessageThreadUtil$1.access$000(this$1).next(); syncQueueItem != null; syncQueueItem = MessageThreadUtil$1.access$000(this$1).next()) {
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
}