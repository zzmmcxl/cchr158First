package android.support.v4.media;

import java.util.List;
import java.util.HashMap;
import android.os.Bundle;

private class ConnectionRecord
{
    ServiceCallbacks callbacks;
    String pkg;
    BrowserRoot root;
    Bundle rootHints;
    HashMap<String, List<Bundle>> subscriptions;
    final /* synthetic */ MediaBrowserServiceCompat this$0;
    
    private ConnectionRecord(final MediaBrowserServiceCompat this$0) {
        this$0 = this$0;
        super();
        subscriptions = new HashMap<String, List<Bundle>>();
    }
    
    ConnectionRecord(final MediaBrowserServiceCompat mediaBrowserServiceCompat, final MediaBrowserServiceCompat$1 runnable) {
        this(mediaBrowserServiceCompat);
    }
}
