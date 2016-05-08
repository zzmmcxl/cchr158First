package android.support.v4.media.session;

import android.os.Bundle;

public interface MediaControllerCompatApi21$Callback {
   void onMetadataChanged(Object var1);

   void onPlaybackStateChanged(Object var1);

   void onSessionDestroyed();

   void onSessionEvent(String var1, Bundle var2);
}
