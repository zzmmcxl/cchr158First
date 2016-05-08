package android.support.v4.media.session;

import android.media.RemoteControlClient.OnPlaybackPositionUpdateListener;
import android.support.v4.media.session.MediaSessionCompatApi18$Callback;

class MediaSessionCompatApi18$OnPlaybackPositionUpdateListener<T extends MediaSessionCompatApi18$Callback> implements OnPlaybackPositionUpdateListener {
   protected final T mCallback;

   public MediaSessionCompatApi18$OnPlaybackPositionUpdateListener(T var1) {
      this.mCallback = var1;
   }

   public void onPlaybackPositionUpdate(long var1) {
      this.mCallback.onSeekTo(var1);
   }
}
