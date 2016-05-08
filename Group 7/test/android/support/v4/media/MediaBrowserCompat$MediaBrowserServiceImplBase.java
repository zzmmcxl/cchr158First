package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.media.MediaBrowserCompat$1;
import android.support.v4.media.MediaBrowserCompat$CallbackHandler;
import android.support.v4.media.MediaBrowserCompat$ConnectionCallback;
import android.support.v4.media.MediaBrowserCompat$ItemCallback;
import android.support.v4.media.MediaBrowserCompat$ItemReceiver;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceCallbackImpl;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceImplBase$1;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceImplBase$2;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceImplBase$3;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceImplBase$MediaServiceConnection;
import android.support.v4.media.MediaBrowserCompat$ServiceBinderWrapper;
import android.support.v4.media.MediaBrowserCompat$Subscription;
import android.support.v4.media.MediaBrowserCompat$SubscriptionCallback;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.util.List;

class MediaBrowserCompat$MediaBrowserServiceImplBase implements MediaBrowserCompat$MediaBrowserImpl, MediaBrowserCompat$MediaBrowserServiceCallbackImpl {
   private static final int CONNECT_STATE_CONNECTED = 2;
   private static final int CONNECT_STATE_CONNECTING = 1;
   private static final int CONNECT_STATE_DISCONNECTED = 0;
   private static final int CONNECT_STATE_SUSPENDED = 3;
   private static final boolean DBG = false;
   private final MediaBrowserCompat$ConnectionCallback mCallback;
   private Messenger mCallbacksMessenger;
   private final Context mContext;
   private Bundle mExtras;
   private final MediaBrowserCompat$CallbackHandler mHandler = new MediaBrowserCompat$CallbackHandler(this);
   private MediaSessionCompat$Token mMediaSessionToken;
   private final Bundle mRootHints;
   private String mRootId;
   private MediaBrowserCompat$ServiceBinderWrapper mServiceBinderWrapper;
   private final ComponentName mServiceComponent;
   private MediaBrowserCompat$MediaBrowserServiceImplBase$MediaServiceConnection mServiceConnection;
   private int mState = 0;
   private final ArrayMap<String, MediaBrowserCompat$Subscription> mSubscriptions = new ArrayMap();

   public MediaBrowserCompat$MediaBrowserServiceImplBase(Context var1, ComponentName var2, MediaBrowserCompat$ConnectionCallback var3, Bundle var4) {
      if(var1 == null) {
         throw new IllegalArgumentException("context must not be null");
      } else if(var2 == null) {
         throw new IllegalArgumentException("service component must not be null");
      } else if(var3 == null) {
         throw new IllegalArgumentException("connection callback must not be null");
      } else {
         this.mContext = var1;
         this.mServiceComponent = var2;
         this.mCallback = var3;
         this.mRootHints = var4;
      }
   }

   private void forceCloseConnection() {
      if(this.mServiceConnection != null) {
         this.mContext.unbindService(this.mServiceConnection);
      }

      this.mState = 0;
      this.mServiceConnection = null;
      this.mServiceBinderWrapper = null;
      this.mCallbacksMessenger = null;
      this.mRootId = null;
      this.mMediaSessionToken = null;
   }

   private static String getStateLabel(int var0) {
      switch(var0) {
      case 0:
         return "CONNECT_STATE_DISCONNECTED";
      case 1:
         return "CONNECT_STATE_CONNECTING";
      case 2:
         return "CONNECT_STATE_CONNECTED";
      case 3:
         return "CONNECT_STATE_SUSPENDED";
      default:
         return "UNKNOWN/" + var0;
      }
   }

   private boolean isCurrent(Messenger var1, String var2) {
      if(this.mCallbacksMessenger != var1) {
         if(this.mState != 0) {
            Log.i("MediaBrowserCompat", var2 + " for " + this.mServiceComponent + " with mCallbacksMessenger=" + this.mCallbacksMessenger + " this=" + this);
         }

         return false;
      } else {
         return true;
      }
   }

   public void connect() {
      if(this.mState != 0) {
         throw new IllegalStateException("connect() called while not disconnected (state=" + getStateLabel(this.mState) + ")");
      } else if(this.mServiceBinderWrapper != null) {
         throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + this.mServiceBinderWrapper);
      } else if(this.mCallbacksMessenger != null) {
         throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + this.mCallbacksMessenger);
      } else {
         this.mState = 1;
         Intent var4 = new Intent("android.media.browse.MediaBrowserService");
         var4.setComponent(this.mServiceComponent);
         MediaBrowserCompat$MediaBrowserServiceImplBase$MediaServiceConnection var3 = new MediaBrowserCompat$MediaBrowserServiceImplBase$MediaServiceConnection(this, (MediaBrowserCompat$1)null);
         this.mServiceConnection = var3;
         boolean var1 = false;

         label24: {
            boolean var2;
            try {
               var2 = this.mContext.bindService(var4, this.mServiceConnection, 1);
            } catch (Exception var5) {
               Log.e("MediaBrowserCompat", "Failed binding to service " + this.mServiceComponent);
               break label24;
            }

            var1 = var2;
         }

         if(!var1) {
            this.mHandler.post(new MediaBrowserCompat$MediaBrowserServiceImplBase$1(this, var3));
         }

      }
   }

   public void disconnect() {
      if(this.mCallbacksMessenger != null) {
         try {
            this.mServiceBinderWrapper.disconnect(this.mCallbacksMessenger);
         } catch (RemoteException var2) {
            Log.w("MediaBrowserCompat", "RemoteException during connect for " + this.mServiceComponent);
         }
      }

      this.forceCloseConnection();
   }

   void dump() {
      Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
      Log.d("MediaBrowserCompat", "  mServiceComponent=" + this.mServiceComponent);
      Log.d("MediaBrowserCompat", "  mCallback=" + this.mCallback);
      Log.d("MediaBrowserCompat", "  mRootHints=" + this.mRootHints);
      Log.d("MediaBrowserCompat", "  mState=" + getStateLabel(this.mState));
      Log.d("MediaBrowserCompat", "  mServiceConnection=" + this.mServiceConnection);
      Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + this.mServiceBinderWrapper);
      Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + this.mCallbacksMessenger);
      Log.d("MediaBrowserCompat", "  mRootId=" + this.mRootId);
      Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + this.mMediaSessionToken);
   }

   @Nullable
   public Bundle getExtras() {
      if(!this.isConnected()) {
         throw new IllegalStateException("getExtras() called while not connected (state=" + getStateLabel(this.mState) + ")");
      } else {
         return this.mExtras;
      }
   }

   public void getItem(@NonNull String var1, @NonNull MediaBrowserCompat$ItemCallback var2) {
      if(TextUtils.isEmpty(var1)) {
         throw new IllegalArgumentException("mediaId is empty.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("cb is null.");
      } else if(this.mState != 2) {
         Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
         this.mHandler.post(new MediaBrowserCompat$MediaBrowserServiceImplBase$2(this, var2, var1));
      } else {
         MediaBrowserCompat$ItemReceiver var3 = new MediaBrowserCompat$ItemReceiver(var1, var2, this.mHandler);

         try {
            this.mServiceBinderWrapper.getMediaItem(var1, var3);
         } catch (RemoteException var4) {
            Log.i("MediaBrowserCompat", "Remote error getting media item.");
            this.mHandler.post(new MediaBrowserCompat$MediaBrowserServiceImplBase$3(this, var2, var1));
         }
      }
   }

   @NonNull
   public String getRoot() {
      if(!this.isConnected()) {
         throw new IllegalStateException("getRoot() called while not connected(state=" + getStateLabel(this.mState) + ")");
      } else {
         return this.mRootId;
      }
   }

   @NonNull
   public ComponentName getServiceComponent() {
      if(!this.isConnected()) {
         throw new IllegalStateException("getServiceComponent() called while not connected (state=" + this.mState + ")");
      } else {
         return this.mServiceComponent;
      }
   }

   @NonNull
   public MediaSessionCompat$Token getSessionToken() {
      if(!this.isConnected()) {
         throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
      } else {
         return this.mMediaSessionToken;
      }
   }

   public boolean isConnected() {
      return this.mState == 2;
   }

   public void onConnectionFailed(Messenger var1) {
      Log.e("MediaBrowserCompat", "onConnectFailed for " + this.mServiceComponent);
      if(this.isCurrent(var1, "onConnectFailed")) {
         if(this.mState != 1) {
            Log.w("MediaBrowserCompat", "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
         } else {
            this.forceCloseConnection();
            this.mCallback.onConnectionFailed();
         }
      }
   }

   public void onLoadChildren(Messenger var1, String var2, List var3, Bundle var4) {
      if(this.isCurrent(var1, "onLoadChildren")) {
         MediaBrowserCompat$Subscription var5 = (MediaBrowserCompat$Subscription)this.mSubscriptions.get(var2);
         if(var5 != null) {
            MediaBrowserCompat$SubscriptionCallback var6 = var5.getCallback(var4);
            if(var6 != null) {
               if(var4 == null) {
                  var6.onChildrenLoaded(var2, var3);
                  return;
               }

               var6.onChildrenLoaded(var2, var3, var4);
               return;
            }
         }
      }

   }

   public void onServiceConnected(Messenger param1, String param2, MediaSessionCompat$Token param3, Bundle param4) {
      // $FF: Couldn't be decompiled
   }

   public void subscribe(@NonNull String var1, Bundle var2, @NonNull MediaBrowserCompat$SubscriptionCallback var3) {
      if(TextUtils.isEmpty(var1)) {
         throw new IllegalArgumentException("parentId is empty.");
      } else if(var3 == null) {
         throw new IllegalArgumentException("callback is null");
      } else {
         MediaBrowserCompat$Subscription var5 = (MediaBrowserCompat$Subscription)this.mSubscriptions.get(var1);
         MediaBrowserCompat$Subscription var4 = var5;
         if(var5 == null) {
            var4 = new MediaBrowserCompat$Subscription();
            this.mSubscriptions.put(var1, var4);
         }

         var4.setCallbackForOptions(var3, var2);
         if(this.mState == 2) {
            try {
               this.mServiceBinderWrapper.addSubscription(var1, var2, this.mCallbacksMessenger);
            } catch (RemoteException var6) {
               Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException parentId=" + var1);
               return;
            }
         }

      }
   }

   public void unsubscribe(@NonNull String var1, Bundle var2) {
      if(TextUtils.isEmpty(var1)) {
         throw new IllegalArgumentException("parentId is empty.");
      } else {
         MediaBrowserCompat$Subscription var3 = (MediaBrowserCompat$Subscription)this.mSubscriptions.get(var1);
         if(var3 != null && var3.remove(var2) && this.mState == 2) {
            try {
               this.mServiceBinderWrapper.removeSubscription(var1, var2, this.mCallbacksMessenger);
            } catch (RemoteException var4) {
               Log.d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + var1);
            }
         }

         if(var3 != null && var3.isEmpty()) {
            this.mSubscriptions.remove(var1);
         }

      }
   }
}
