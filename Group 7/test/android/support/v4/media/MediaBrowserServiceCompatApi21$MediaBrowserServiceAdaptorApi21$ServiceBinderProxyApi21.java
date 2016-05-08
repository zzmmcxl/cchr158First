package android.support.v4.media;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.media.IMediaBrowserServiceAdapterApi21$Stub;
import android.support.v4.media.MediaBrowserServiceCompatApi21$ServiceCallbacksApi21;
import android.support.v4.media.MediaBrowserServiceCompatApi21$ServiceImplApi21;

class MediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptorApi21$ServiceBinderProxyApi21 extends IMediaBrowserServiceAdapterApi21$Stub {
   final MediaBrowserServiceCompatApi21$ServiceImplApi21 mServiceImpl;

   MediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptorApi21$ServiceBinderProxyApi21(MediaBrowserServiceCompatApi21$ServiceImplApi21 var1) {
      this.mServiceImpl = var1;
   }

   public void addSubscription(String var1, Object var2) {
      this.mServiceImpl.addSubscription(var1, new MediaBrowserServiceCompatApi21$ServiceCallbacksApi21(var2));
   }

   public void connect(String var1, Bundle var2, Object var3) {
      this.mServiceImpl.connect(var1, var2, new MediaBrowserServiceCompatApi21$ServiceCallbacksApi21(var3));
   }

   public void disconnect(Object var1) {
      this.mServiceImpl.disconnect(new MediaBrowserServiceCompatApi21$ServiceCallbacksApi21(var1));
   }

   public void getMediaItem(String var1, ResultReceiver var2) {
   }

   public void removeSubscription(String var1, Object var2) {
      this.mServiceImpl.removeSubscription(var1, new MediaBrowserServiceCompatApi21$ServiceCallbacksApi21(var2));
   }
}
