package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaBrowserServiceCompat$BrowserRoot;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceCallbacks;
import java.util.HashMap;
import java.util.List;

class MediaBrowserServiceCompat$ConnectionRecord {
   MediaBrowserServiceCompat$ServiceCallbacks callbacks;
   String pkg;
   MediaBrowserServiceCompat$BrowserRoot root;
   Bundle rootHints;
   HashMap<String, List<Bundle>> subscriptions;

   private MediaBrowserServiceCompat$ConnectionRecord(MediaBrowserServiceCompat var1) {
      this.this$0 = var1;
      this.subscriptions = new HashMap();
   }
}
