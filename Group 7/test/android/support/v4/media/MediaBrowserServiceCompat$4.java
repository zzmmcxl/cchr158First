package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaBrowserServiceCompat$Result;
import android.support.v4.os.ResultReceiver;

class MediaBrowserServiceCompat$4 extends MediaBrowserServiceCompat$Result<MediaBrowserCompat$MediaItem> {
   MediaBrowserServiceCompat$4(MediaBrowserServiceCompat var1, Object var2, ResultReceiver var3) {
      super(var2);
      this.this$0 = var1;
      this.val$receiver = var3;
   }

   void onResultSent(MediaBrowserCompat$MediaItem var1, int var2) {
      Bundle var3 = new Bundle();
      var3.putParcelable("media_item", var1);
      this.val$receiver.send(0, var3);
   }
}
