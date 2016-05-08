package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.media.MediaBrowserCompat$ConnectionCallback;
import android.support.v4.media.MediaBrowserCompat$ItemCallback;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi23;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceImplBase;
import android.support.v4.media.MediaBrowserCompat$SubscriptionCallback;
import android.support.v4.media.session.MediaSessionCompat$Token;

public final class MediaBrowserCompat {
   public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
   public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
   private static final String TAG = "MediaBrowserCompat";
   private final MediaBrowserCompat$MediaBrowserImpl mImpl;

   public MediaBrowserCompat(Context var1, ComponentName var2, MediaBrowserCompat$ConnectionCallback var3, Bundle var4) {
      if(VERSION.SDK_INT >= 23) {
         this.mImpl = new MediaBrowserCompat$MediaBrowserImplApi23(var1, var2, var3, var4);
      } else if(VERSION.SDK_INT >= 21) {
         this.mImpl = new MediaBrowserCompat$MediaBrowserImplApi21(var1, var2, var3, var4);
      } else {
         this.mImpl = new MediaBrowserCompat$MediaBrowserServiceImplBase(var1, var2, var3, var4);
      }
   }

   public void connect() {
      this.mImpl.connect();
   }

   public void disconnect() {
      this.mImpl.disconnect();
   }

   @Nullable
   public Bundle getExtras() {
      return this.mImpl.getExtras();
   }

   public void getItem(@NonNull String var1, @NonNull MediaBrowserCompat$ItemCallback var2) {
      this.mImpl.getItem(var1, var2);
   }

   @NonNull
   public String getRoot() {
      return this.mImpl.getRoot();
   }

   @NonNull
   public ComponentName getServiceComponent() {
      return this.mImpl.getServiceComponent();
   }

   @NonNull
   public MediaSessionCompat$Token getSessionToken() {
      return this.mImpl.getSessionToken();
   }

   public boolean isConnected() {
      return this.mImpl.isConnected();
   }

   public void subscribe(@NonNull String var1, @NonNull Bundle var2, @NonNull MediaBrowserCompat$SubscriptionCallback var3) {
      if(var2 == null) {
         throw new IllegalArgumentException("options are null");
      } else {
         this.mImpl.subscribe(var1, var2, var3);
      }
   }

   public void subscribe(@NonNull String var1, @NonNull MediaBrowserCompat$SubscriptionCallback var2) {
      this.mImpl.subscribe(var1, (Bundle)null, var2);
   }

   public void unsubscribe(@NonNull String var1) {
      this.mImpl.unsubscribe(var1, (Bundle)null);
   }

   public void unsubscribe(@NonNull String var1, @NonNull Bundle var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("options are null");
      } else {
         this.mImpl.unsubscribe(var1, var2);
      }
   }
}
