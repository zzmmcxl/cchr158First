package android.support.v4.media;

import android.media.browse.MediaBrowser.MediaItem;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.support.v4.media.MediaBrowserServiceCompatApi23$ItemCallback;
import android.support.v4.media.MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptorApi23$ServiceBinderProxyApi23;

class MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptorApi23$ServiceBinderProxyApi23$1 implements MediaBrowserServiceCompatApi23$ItemCallback {
   MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptorApi23$ServiceBinderProxyApi23$1(MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptorApi23$ServiceBinderProxyApi23 var1, String var2, ResultReceiver var3) {
      this.this$0 = var1;
      this.val$KEY_MEDIA_ITEM = var2;
      this.val$receiver = var3;
   }

   public void onItemLoaded(int var1, Bundle var2, Parcel var3) {
      if(var3 != null) {
         var3.setDataPosition(0);
         MediaItem var4 = (MediaItem)MediaItem.CREATOR.createFromParcel(var3);
         var2.putParcelable(this.val$KEY_MEDIA_ITEM, var4);
         var3.recycle();
      }

      this.val$receiver.send(var1, var2);
   }
}
