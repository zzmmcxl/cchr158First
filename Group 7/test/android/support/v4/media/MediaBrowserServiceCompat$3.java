package android.support.v4.media;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.MediaBrowserCompatUtils;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaBrowserServiceCompat$ConnectionRecord;
import android.support.v4.media.MediaBrowserServiceCompat$Result;
import android.util.Log;
import java.util.List;

class MediaBrowserServiceCompat$3 extends MediaBrowserServiceCompat$Result<List<MediaBrowserCompat$MediaItem>> {
   MediaBrowserServiceCompat$3(MediaBrowserServiceCompat var1, Object var2, MediaBrowserServiceCompat$ConnectionRecord var3, String var4, Bundle var5) {
      super(var2);
      this.this$0 = var1;
      this.val$connection = var3;
      this.val$parentId = var4;
      this.val$options = var5;
   }

   void onResultSent(List<MediaBrowserCompat$MediaItem> var1, int var2) {
      if(MediaBrowserServiceCompat.access$500(this.this$0).get(this.val$connection.callbacks.asBinder()) == this.val$connection) {
         if((var2 & 1) != 0) {
            var1 = MediaBrowserCompatUtils.applyOptions(var1, this.val$options);
         }

         try {
            this.val$connection.callbacks.onLoadChildren(this.val$parentId, var1, this.val$options);
         } catch (RemoteException var3) {
            Log.w("MediaBrowserServiceCompat", "Calling onLoadChildren() failed for id=" + this.val$parentId + " package=" + this.val$connection.pkg);
         }
      }
   }
}
