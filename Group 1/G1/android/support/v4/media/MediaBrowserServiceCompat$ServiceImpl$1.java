package android.support.v4.media;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.os.Bundle;

class MediaBrowserServiceCompat$ServiceImpl$1 implements Runnable {
    final /* synthetic */ ServiceImpl this$1;
    final /* synthetic */ ServiceCallbacks val$callbacks;
    final /* synthetic */ String val$pkg;
    final /* synthetic */ Bundle val$rootHints;
    final /* synthetic */ int val$uid;
    
    MediaBrowserServiceCompat$ServiceImpl$1(final ServiceImpl this$1, final ServiceCallbacks val$callbacks, final String val$pkg, final Bundle val$rootHints, final int val$uid) {
        this$1 = this$1;
        val$callbacks = val$callbacks;
        val$pkg = val$pkg;
        val$rootHints = val$rootHints;
        val$uid = val$uid;
        super();
    }
    
    @Override
    public void run() {
        final IBinder binder = val$callbacks.asBinder();
        MediaBrowserServiceCompat.access$500(this$0).remove(binder);
        final ConnectionRecord connectionRecord = this$0.new ConnectionRecord();
        connectionRecord.pkg = val$pkg;
        connectionRecord.rootHints = val$rootHints;
        connectionRecord.callbacks = val$callbacks;
        connectionRecord.root = this$0.onGetRoot(val$pkg, val$uid, val$rootHints);
        Label_0182: {
            if (connectionRecord.root != null) {
                break Label_0182;
            }
            Log.i("MediaBrowserServiceCompat", "No root for client " + val$pkg + " from service " + this.getClass().getName());
            try {
                val$callbacks.onConnectFailed();
                return;
            }
            catch (RemoteException ex) {
                Log.w("MediaBrowserServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + val$pkg);
                return;
            }
            try {
                MediaBrowserServiceCompat.access$500(this$0).put(binder, connectionRecord);
                if (mSession != null) {
                    val$callbacks.onConnect(connectionRecord.root.getRootId(), mSession, connectionRecord.root.getExtras());
                }
            }
            catch (RemoteException ex2) {
                Log.w("MediaBrowserServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + val$pkg);
                MediaBrowserServiceCompat.access$500(this$0).remove(binder);
            }
        }
    }
}