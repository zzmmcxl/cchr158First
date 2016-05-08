package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.ConnectionCallback;
import android.media.browse.MediaBrowser.SubscriptionCallback;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompatApi21$ConnectionCallback;
import android.support.v4.media.MediaBrowserCompatApi21$ConnectionCallbackProxy;
import android.support.v4.media.MediaBrowserCompatApi21$SubscriptionCallback;
import android.support.v4.media.MediaBrowserCompatApi21$SubscriptionCallbackProxy;

class MediaBrowserCompatApi21 {
   static final String NULL_MEDIA_ITEM_ID = "android.support.v4.media.MediaBrowserCompat.NULL_MEDIA_ITEM";

   public static void connect(Object var0) {
      ((MediaBrowser)var0).connect();
   }

   public static Object createBrowser(Context var0, ComponentName var1, Object var2, Bundle var3) {
      return new MediaBrowser(var0, var1, (ConnectionCallback)var2, var3);
   }

   public static Object createConnectionCallback(MediaBrowserCompatApi21$ConnectionCallback var0) {
      return new MediaBrowserCompatApi21$ConnectionCallbackProxy(var0);
   }

   public static Object createSubscriptionCallback(MediaBrowserCompatApi21$SubscriptionCallback var0) {
      return new MediaBrowserCompatApi21$SubscriptionCallbackProxy(var0);
   }

   public static void disconnect(Object var0) {
      ((MediaBrowser)var0).disconnect();
   }

   public static Bundle getExtras(Object var0) {
      return ((MediaBrowser)var0).getExtras();
   }

   public static String getRoot(Object var0) {
      return ((MediaBrowser)var0).getRoot();
   }

   public static ComponentName getServiceComponent(Object var0) {
      return ((MediaBrowser)var0).getServiceComponent();
   }

   public static Object getSessionToken(Object var0) {
      return ((MediaBrowser)var0).getSessionToken();
   }

   public static boolean isConnected(Object var0) {
      return ((MediaBrowser)var0).isConnected();
   }

   public static void subscribe(Object var0, String var1, Object var2) {
      ((MediaBrowser)var0).subscribe(var1, (SubscriptionCallback)var2);
   }

   public static void unsubscribe(Object var0, String var1) {
      ((MediaBrowser)var0).unsubscribe(var1);
   }
}
