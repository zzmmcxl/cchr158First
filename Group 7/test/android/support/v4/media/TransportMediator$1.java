package android.support.v4.media;

import android.support.v4.media.TransportMediator;
import android.support.v4.media.TransportMediatorCallback;
import android.view.KeyEvent;

class TransportMediator$1 implements TransportMediatorCallback {
   TransportMediator$1(TransportMediator var1) {
      this.this$0 = var1;
   }

   public long getPlaybackPosition() {
      return this.this$0.mCallbacks.onGetCurrentPosition();
   }

   public void handleAudioFocusChange(int var1) {
      this.this$0.mCallbacks.onAudioFocusChange(var1);
   }

   public void handleKey(KeyEvent var1) {
      var1.dispatch(this.this$0.mKeyEventCallback);
   }

   public void playbackPositionUpdate(long var1) {
      this.this$0.mCallbacks.onSeekTo(var1);
   }
}
