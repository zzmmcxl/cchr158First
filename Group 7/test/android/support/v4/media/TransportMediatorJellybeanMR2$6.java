package android.support.v4.media;

import android.media.RemoteControlClient.OnPlaybackPositionUpdateListener;
import android.support.v4.media.TransportMediatorJellybeanMR2;

class TransportMediatorJellybeanMR2$6 implements OnPlaybackPositionUpdateListener {
   TransportMediatorJellybeanMR2$6(TransportMediatorJellybeanMR2 var1) {
      this.this$0 = var1;
   }

   public void onPlaybackPositionUpdate(long var1) {
      this.this$0.mTransportCallback.playbackPositionUpdate(var1);
   }
}
