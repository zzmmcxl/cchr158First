package android.support.v4.media;

import android.content.ComponentName;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.media.MediaBrowserCompat$ItemCallback;
import android.support.v4.media.MediaBrowserCompat$SubscriptionCallback;
import android.support.v4.media.session.MediaSessionCompat$Token;

interface MediaBrowserCompat$MediaBrowserImpl {
   void connect();

   void disconnect();

   @Nullable
   Bundle getExtras();

   void getItem(@NonNull String var1, @NonNull MediaBrowserCompat$ItemCallback var2);

   @NonNull
   String getRoot();

   ComponentName getServiceComponent();

   @NonNull
   MediaSessionCompat$Token getSessionToken();

   boolean isConnected();

   void subscribe(@NonNull String var1, Bundle var2, @NonNull MediaBrowserCompat$SubscriptionCallback var3);

   void unsubscribe(@NonNull String var1, Bundle var2);
}
