package android.support.v4.media.session;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.KeyEvent;
import java.util.List;

public class MediaButtonReceiver extends BroadcastReceiver {
   public static KeyEvent handleIntent(MediaSessionCompat var0, Intent var1) {
      if(var0 != null && var1 != null && "android.intent.action.MEDIA_BUTTON".equals(var1.getAction()) && var1.hasExtra("android.intent.extra.KEY_EVENT")) {
         KeyEvent var2 = (KeyEvent)var1.getParcelableExtra("android.intent.extra.KEY_EVENT");
         var0.getController().dispatchMediaButtonEvent(var2);
         return var2;
      } else {
         return null;
      }
   }

   public void onReceive(Context var1, Intent var2) {
      Intent var5 = new Intent("android.intent.action.MEDIA_BUTTON");
      var5.setPackage(var1.getPackageName());
      PackageManager var6 = var1.getPackageManager();
      List var4 = var6.queryIntentServices(var5, 0);
      List var3 = var4;
      if(var4.isEmpty()) {
         var5.setAction("android.media.browse.MediaBrowserService");
         var3 = var6.queryIntentServices(var5, 0);
      }

      if(var3.isEmpty()) {
         throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or a media browser service implementation");
      } else if(var3.size() != 1) {
         throw new IllegalStateException("Expected 1 Service that handles " + var5.getAction() + ", found " + var3.size());
      } else {
         ResolveInfo var7 = (ResolveInfo)var3.get(0);
         var2.setComponent(new ComponentName(var7.serviceInfo.packageName, var7.serviceInfo.name));
         var1.startService(var2);
      }
   }
}
