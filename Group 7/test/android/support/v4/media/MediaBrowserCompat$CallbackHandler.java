package android.support.v4.media;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceCallbackImpl;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.util.Log;
import java.lang.ref.WeakReference;

class MediaBrowserCompat$CallbackHandler extends Handler {
   private final MediaBrowserCompat$MediaBrowserServiceCallbackImpl mCallbackImpl;
   private WeakReference<Messenger> mCallbacksMessengerRef;

   MediaBrowserCompat$CallbackHandler(MediaBrowserCompat$MediaBrowserServiceCallbackImpl var1) {
      this.mCallbackImpl = var1;
   }

   public void handleMessage(Message var1) {
      if(this.mCallbacksMessengerRef != null) {
         Bundle var2 = var1.getData();
         var2.setClassLoader(MediaSessionCompat.class.getClassLoader());
         switch(var1.what) {
         case 1:
            this.mCallbackImpl.onServiceConnected((Messenger)this.mCallbacksMessengerRef.get(), var2.getString("data_media_item_id"), (MediaSessionCompat$Token)var2.getParcelable("data_media_session_token"), var2.getBundle("data_root_hints"));
            return;
         case 2:
            this.mCallbackImpl.onConnectionFailed((Messenger)this.mCallbacksMessengerRef.get());
            return;
         case 3:
            this.mCallbackImpl.onLoadChildren((Messenger)this.mCallbacksMessengerRef.get(), var2.getString("data_media_item_id"), var2.getParcelableArrayList("data_media_item_list"), var2.getBundle("data_options"));
            return;
         default:
            Log.w("MediaBrowserCompat", "Unhandled message: " + var1 + "\n  Client version: " + 1 + "\n  Service version: " + var1.arg1);
         }
      }
   }

   void setCallbacksMessenger(Messenger var1) {
      this.mCallbacksMessengerRef = new WeakReference(var1);
   }
}
