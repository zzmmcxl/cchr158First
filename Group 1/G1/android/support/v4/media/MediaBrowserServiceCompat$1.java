package android.support.v4.media;

import java.util.Iterator;
import android.os.RemoteException;
import android.util.Log;
import android.os.IBinder;
import android.support.v4.media.session.MediaSessionCompat;

class MediaBrowserServiceCompat$1 implements Runnable {
    final /* synthetic */ MediaBrowserServiceCompat this$0;
    final /* synthetic */ MediaSessionCompat.Token val$token;
    
    MediaBrowserServiceCompat$1(final MediaBrowserServiceCompat this$0, final MediaSessionCompat.Token val$token) {
        this$0 = this$0;
        val$token = val$token;
        super();
    }
    
    @Override
    public void run() {
        for (final IBinder binder : MediaBrowserServiceCompat.access$500(this$0).keySet()) {
            final ConnectionRecord connectionRecord = (ConnectionRecord)MediaBrowserServiceCompat.access$500(this$0).get(binder);
            try {
                connectionRecord.callbacks.onConnect(connectionRecord.root.getRootId(), val$token, connectionRecord.root.getExtras());
            }
            catch (RemoteException ex) {
                Log.w("MediaBrowserServiceCompat", "Connection for " + connectionRecord.pkg + " is no longer valid.");
                MediaBrowserServiceCompat.access$500(this$0).remove(binder);
            }
        }
    }
}