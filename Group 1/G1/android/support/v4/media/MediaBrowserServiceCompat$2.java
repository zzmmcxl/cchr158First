package android.support.v4.media;

import java.util.Iterator;
import java.util.List;
import android.os.IBinder;
import android.os.Bundle;

class MediaBrowserServiceCompat$2 implements Runnable {
    final /* synthetic */ MediaBrowserServiceCompat this$0;
    final /* synthetic */ Bundle val$options;
    final /* synthetic */ String val$parentId;
    
    MediaBrowserServiceCompat$2(final MediaBrowserServiceCompat this$0, final String val$parentId, final Bundle val$options) {
        this$0 = this$0;
        val$parentId = val$parentId;
        val$options = val$options;
        super();
    }
    
    @Override
    public void run() {
        final Iterator<IBinder> iterator = MediaBrowserServiceCompat.access$500(this$0).keySet().iterator();
        while (iterator.hasNext()) {
            final ConnectionRecord connectionRecord = (ConnectionRecord)MediaBrowserServiceCompat.access$500(this$0).get(iterator.next());
            final List<Bundle> list = (List<Bundle>)connectionRecord.subscriptions.get(val$parentId);
            if (list != null) {
                for (final Bundle bundle : list) {
                    if (MediaBrowserCompatUtils.hasDuplicatedItems(val$options, bundle)) {
                        MediaBrowserServiceCompat.access$1000(this$0, val$parentId, connectionRecord, bundle);
                        break;
                    }
                }
            }
        }
    }
}