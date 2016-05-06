package android.support.v4.media;

import android.os.RemoteException;
import android.util.Log;
import android.os.Bundle;
import java.util.List;

class MediaBrowserServiceCompat$3 extends Result<List<MediaBrowserCompat.MediaItem>> {
    final /* synthetic */ MediaBrowserServiceCompat this$0;
    final /* synthetic */ ConnectionRecord val$connection;
    final /* synthetic */ Bundle val$options;
    final /* synthetic */ String val$parentId;
    
    MediaBrowserServiceCompat$3(final MediaBrowserServiceCompat this$0, final Object o, final ConnectionRecord val$connection, final String val$parentId, final Bundle val$options) {
        this$0 = this$0;
        val$connection = val$connection;
        val$parentId = val$parentId;
        val$options = val$options;
        super(o);
    }
    
    @Override
    /* bridge */ void onResultSent(final Object o, final int n) {
        this.onResultSent((List<MediaBrowserCompat.MediaItem>)o, n);
    }
    
    void onResultSent(final List<MediaBrowserCompat.MediaItem> list, final int n) {
        if (MediaBrowserServiceCompat.access$500(this$0).get(val$connection.callbacks.asBinder()) != val$connection) {
            return;
        }
        while (true) {
            Label_0113: {
                if ((n & 0x1) == 0x0) {
                    break Label_0113;
                }
                final List<MediaBrowserCompat.MediaItem> applyOptions = MediaBrowserCompatUtils.applyOptions(list, val$options);
                try {
                    val$connection.callbacks.onLoadChildren(val$parentId, applyOptions, val$options);
                    return;
                }
                catch (RemoteException ex) {
                    Log.w("MediaBrowserServiceCompat", "Calling onLoadChildren() failed for id=" + val$parentId + " package=" + val$connection.pkg);
                    return;
                }
            }
            final List<MediaBrowserCompat.MediaItem> applyOptions = list;
            continue;
        }
    }
}