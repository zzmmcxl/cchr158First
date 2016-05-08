package android.support.v4.media;

import android.os.Binder;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceCallbacksApi21;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceImpl;
import android.support.v4.media.MediaBrowserServiceCompatApi21$ServiceCallbacks;
import android.support.v4.media.MediaBrowserServiceCompatApi21$ServiceImplApi21;

class MediaBrowserServiceCompat$ServiceImplApi21 implements MediaBrowserServiceCompatApi21$ServiceImplApi21 {
   final MediaBrowserServiceCompat$ServiceImpl mServiceImpl;

   MediaBrowserServiceCompat$ServiceImplApi21(MediaBrowserServiceCompat var1) {
      this.this$0 = var1;
      this.mServiceImpl = MediaBrowserServiceCompat.access$100(var1).getServiceImpl();
   }

   public void addSubscription(String var1, MediaBrowserServiceCompatApi21$ServiceCallbacks var2) {
      this.mServiceImpl.addSubscription(var1, (Bundle)null, new MediaBrowserServiceCompat$ServiceCallbacksApi21(this.this$0, var2));
   }

   public void connect(String var1, Bundle var2, MediaBrowserServiceCompatApi21$ServiceCallbacks var3) {
      this.mServiceImpl.connect(var1, Binder.getCallingUid(), var2, new MediaBrowserServiceCompat$ServiceCallbacksApi21(this.this$0, var3));
   }

   public void disconnect(MediaBrowserServiceCompatApi21$ServiceCallbacks var1) {
      this.mServiceImpl.disconnect(new MediaBrowserServiceCompat$ServiceCallbacksApi21(this.this$0, var1));
   }

   public void removeSubscription(String var1, MediaBrowserServiceCompatApi21$ServiceCallbacks var2) {
      this.mServiceImpl.removeSubscription(var1, (Bundle)null, new MediaBrowserServiceCompat$ServiceCallbacksApi21(this.this$0, var2));
   }
}
