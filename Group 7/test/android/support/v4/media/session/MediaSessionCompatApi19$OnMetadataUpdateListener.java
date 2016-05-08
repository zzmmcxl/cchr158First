package android.support.v4.media.session;

import android.media.Rating;
import android.media.RemoteControlClient.OnMetadataUpdateListener;
import android.support.v4.media.session.MediaSessionCompatApi19$Callback;

class MediaSessionCompatApi19$OnMetadataUpdateListener<T extends MediaSessionCompatApi19$Callback> implements OnMetadataUpdateListener {
   protected final T mCallback;

   public MediaSessionCompatApi19$OnMetadataUpdateListener(T var1) {
      this.mCallback = var1;
   }

   public void onMetadataUpdate(int var1, Object var2) {
      if(var1 == 268435457 && var2 instanceof Rating) {
         this.mCallback.onSetRating(var2);
      }

   }
}
