package android.support.v7.util;

import android.util.Log;

class MessageThreadUtil$2$1 implements Runnable {
    final /* synthetic */ MessageThreadUtil$2 this$1;
    
    MessageThreadUtil$2$1(final MessageThreadUtil$2 this$1) {
        this$1 = this$1;
        super();
    }
    
    @Override
    public void run() {
        while (true) {
            final SyncQueueItem next = MessageThreadUtil$2.access$100(this$1).next();
            if (next == null) {
                break;
            }
            switch (next.what) {
                default:
                    Log.e("ThreadUtil", "Unsupported message, what=" + next.what);
                    continue;
                case 1:
                    MessageThreadUtil$2.access$100(this$1).removeMessages(1);
                    val$callback.refresh(next.arg1);
                    continue;
                case 2:
                    MessageThreadUtil$2.access$100(this$1).removeMessages(2);
                    MessageThreadUtil$2.access$100(this$1).removeMessages(3);
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
}