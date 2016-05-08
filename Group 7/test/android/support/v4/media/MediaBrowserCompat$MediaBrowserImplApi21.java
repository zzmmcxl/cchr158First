package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.MediaBrowserCompat$CallbackHandler;
import android.support.v4.media.MediaBrowserCompat$ConnectionCallback;
import android.support.v4.media.MediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal;
import android.support.v4.media.MediaBrowserCompat$ItemCallback;
import android.support.v4.media.MediaBrowserCompat$ItemReceiver;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$1;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$2;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$3;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceCallbackImpl;
import android.support.v4.media.MediaBrowserCompat$ServiceBinderWrapper;
import android.support.v4.media.MediaBrowserCompat$Subscription;
import android.support.v4.media.MediaBrowserCompat$SubscriptionCallback;
import android.support.v4.media.MediaBrowserCompat$SubscriptionCallbackApi21;
import android.support.v4.media.MediaBrowserCompatApi21;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

class MediaBrowserCompat$MediaBrowserImplApi21 implements MediaBrowserCompat$MediaBrowserImpl, MediaBrowserCompat$MediaBrowserServiceCallbackImpl, MediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal {
   private static final boolean DBG = false;
   protected Object mBrowserObj;
   private Messenger mCallbacksMessenger;
   private final MediaBrowserCompat$CallbackHandler mHandler = new MediaBrowserCompat$CallbackHandler(this);
   private MediaBrowserCompat$ServiceBinderWrapper mServiceBinderWrapper;
   private final ComponentName mServiceComponent;
   private final ArrayMap<String, MediaBrowserCompat$Subscription> mSubscriptions = new ArrayMap();

   public MediaBrowserCompat$MediaBrowserImplApi21(Context var1, ComponentName var2, MediaBrowserCompat$ConnectionCallback var3, Bundle var4) {
      this.mServiceComponent = var2;
      var3.setInternalConnectionCallback(this);
      this.mBrowserObj = MediaBrowserCompatApi21.createBrowser(var1, var2, var3.mConnectionCallbackObj, var4);
   }

   public void connect() {
      MediaBrowserCompatApi21.connect(this.mBrowserObj);
   }

   public void disconnect() {
      MediaBrowserCompatApi21.disconnect(this.mBrowserObj);
   }

   @Nullable
   public Bundle getExtras() {
      return MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
   }

   public void getItem(@NonNull String var1, @NonNull MediaBrowserCompat$ItemCallback var2) {
      if(TextUtils.isEmpty(var1)) {
         throw new IllegalArgumentException("mediaId is empty.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("cb is null.");
      } else if(!MediaBrowserCompatApi21.isConnected(this.mBrowserObj)) {
         Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
         this.mHandler.post(new MediaBrowserCompat$MediaBrowserImplApi21$1(this, var2, var1));
      } else if(this.mServiceBinderWrapper == null) {
         this.mHandler.post(new MediaBrowserCompat$MediaBrowserImplApi21$2(this, var2));
      } else {
         MediaBrowserCompat$ItemReceiver var3 = new MediaBrowserCompat$ItemReceiver(var1, var2, this.mHandler);

         try {
            this.mServiceBinderWrapper.getMediaItem(var1, var3);
         } catch (RemoteException var4) {
            Log.i("MediaBrowserCompat", "Remote error getting media item: " + var1);
            this.mHandler.post(new MediaBrowserCompat$MediaBrowserImplApi21$3(this, var2, var1));
         }
      }
   }

   @NonNull
   public String getRoot() {
      return MediaBrowserCompatApi21.getRoot(this.mBrowserObj);
   }

   public ComponentName getServiceComponent() {
      return MediaBrowserCompatApi21.getServiceComponent(this.mBrowserObj);
   }

   @NonNull
   public MediaSessionCompat$Token getSessionToken() {
      return MediaSessionCompat$Token.fromToken(MediaBrowserCompatApi21.getSessionToken(this.mBrowserObj));
   }

   public boolean isConnected() {
      return MediaBrowserCompatApi21.isConnected(this.mBrowserObj);
   }

   public void onConnected() {
      Bundle var1 = MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
      if(var1 != null) {
         IBinder var3 = BundleCompat.getBinder(var1, "extra_messenger");
         if(var3 != null) {
            this.mServiceBinderWrapper = new MediaBrowserCompat$ServiceBinderWrapper(var3);
            this.mCallbacksMessenger = new Messenger(this.mHandler);
            this.mHandler.setCallbacksMessenger(this.mCallbacksMessenger);

            try {
               this.mServiceBinderWrapper.registerCallbackMessenger(this.mCallbacksMessenger);
            } catch (RemoteException var2) {
               Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
            }

            this.onServiceConnected(this.mCallbacksMessenger, (String)null, (MediaSessionCompat$Token)null, (Bundle)null);
            return;
         }
      }

   }

   public void onConnectionFailed() {
   }

   public void onConnectionFailed(Messenger var1) {
   }

   public void onConnectionSuspended() {
      this.mServiceBinderWrapper = null;
      this.mCallbacksMessenger = null;
   }

   public void onLoadChildren(Messenger var1, String var2, List var3, @NonNull Bundle var4) {
      if(this.mCallbacksMessenger == var1) {
         MediaBrowserCompat$Subscription var5 = (MediaBrowserCompat$Subscription)this.mSubscriptions.get(var2);
         if(var5 != null) {
            var5.getCallback(var4).onChildrenLoaded(var2, var3, var4);
            return;
         }
      }

   }

   public void onServiceConnected(Messenger var1, String var2, MediaSessionCompat$Token var3, Bundle var4) {
      Iterator var8 = this.mSubscriptions.entrySet().iterator();

      while(var8.hasNext()) {
         Entry var9 = (Entry)var8.next();
         var2 = (String)var9.getKey();
         MediaBrowserCompat$Subscription var11 = (MediaBrowserCompat$Subscription)var9.getValue();
         List var10 = var11.getOptionsList();
         List var12 = var11.getCallbacks();

         for(int var5 = 0; var5 < var10.size(); ++var5) {
            if(var10.get(var5) == null) {
               MediaBrowserCompatApi21.subscribe(this.mBrowserObj, var2, MediaBrowserCompat$SubscriptionCallbackApi21.access$1800((MediaBrowserCompat$SubscriptionCallbackApi21)var12.get(var5)));
            } else {
               try {
                  this.mServiceBinderWrapper.addSubscription(var2, (Bundle)var10.get(var5), this.mCallbacksMessenger);
               } catch (RemoteException var7) {
                  Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException parentId=" + var2);
               }
            }
         }
      }

   }

   public void subscribe(@NonNull String var1, Bundle var2, @NonNull MediaBrowserCompat$SubscriptionCallback var3) {
      MediaBrowserCompat$SubscriptionCallbackApi21 var5 = new MediaBrowserCompat$SubscriptionCallbackApi21(var3, var2);
      MediaBrowserCompat$Subscription var4 = (MediaBrowserCompat$Subscription)this.mSubscriptions.get(var1);
      MediaBrowserCompat$Subscription var7 = var4;
      if(var4 == null) {
         var7 = new MediaBrowserCompat$Subscription();
         this.mSubscriptions.put(var1, var7);
      }

      var7.setCallbackForOptions(var5, var2);
      if(MediaBrowserCompatApi21.isConnected(this.mBrowserObj)) {
         if(var2 != null && this.mServiceBinderWrapper != null) {
            try {
               this.mServiceBinderWrapper.addSubscription(var1, var2, this.mCallbacksMessenger);
               return;
            } catch (RemoteException var6) {
               Log.i("MediaBrowserCompat", "Remote error subscribing media item: " + var1);
               return;
            }
         }

         MediaBrowserCompatApi21.subscribe(this.mBrowserObj, var1, MediaBrowserCompat$SubscriptionCallbackApi21.access$1800(var5));
      }

   }

   public void unsubscribe(@NonNull String var1, Bundle var2) {
      if(TextUtils.isEmpty(var1)) {
         throw new IllegalArgumentException("parentId is empty.");
      } else {
         MediaBrowserCompat$Subscription var3 = (MediaBrowserCompat$Subscription)this.mSubscriptions.get(var1);
         if(var3 != null && var3.remove(var2)) {
            if(var2 != null && this.mServiceBinderWrapper != null) {
               if(this.mServiceBinderWrapper == null) {
                  try {
                     this.mServiceBinderWrapper.removeSubscription(var1, var2, this.mCallbacksMessenger);
                  } catch (RemoteException var4) {
                     Log.d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + var1);
                  }
               }
            } else if(this.mServiceBinderWrapper != null || var3.isEmpty()) {
               MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, var1);
            }
         }

         if(var3 != null && var3.isEmpty()) {
            this.mSubscriptions.remove(var1);
         }

      }
   }
}
