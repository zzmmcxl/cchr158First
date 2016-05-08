package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.MediaBrowserCompatUtils;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaBrowserServiceCompat$ConnectionRecord;
import java.util.Iterator;
import java.util.List;

class MediaBrowserServiceCompat$2 implements Runnable {
   MediaBrowserServiceCompat$2(MediaBrowserServiceCompat var1, String var2, Bundle var3) {
      this.this$0 = var1;
      this.val$parentId = var2;
      this.val$options = var3;
   }

   public void run() {
      Iterator var1 = MediaBrowserServiceCompat.access$500(this.this$0).keySet().iterator();

      while(true) {
         while(true) {
            List var3;
            MediaBrowserServiceCompat$ConnectionRecord var5;
            do {
               if(!var1.hasNext()) {
                  return;
               }

               IBinder var2 = (IBinder)var1.next();
               var5 = (MediaBrowserServiceCompat$ConnectionRecord)MediaBrowserServiceCompat.access$500(this.this$0).get(var2);
               var3 = (List)var5.subscriptions.get(this.val$parentId);
            } while(var3 == null);

            Iterator var6 = var3.iterator();

            while(var6.hasNext()) {
               Bundle var4 = (Bundle)var6.next();
               if(MediaBrowserCompatUtils.hasDuplicatedItems(this.val$options, var4)) {
                  MediaBrowserServiceCompat.access$1000(this.this$0, this.val$parentId, var5, var4);
                  break;
               }
            }
         }
      }
   }
}
