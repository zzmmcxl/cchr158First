package android.support.v4.media;

import android.media.RemoteControlClient.OnGetPlaybackPositionListener;
import android.support.v4.media.TransportMediatorJellybeanMR2;

class TransportMediatorJellybeanMR2$5 implements OnGetPlaybackPositionListener {
   TransportMediatorJellybeanMR2$5(TransportMediatorJellybeanMR2 var1) {
      this.this$0 = var1;
   }

   public long onGetPlaybackPosition() {
      return this.this$0.mTransportCallback.getPlaybackPosition();
   }
}
