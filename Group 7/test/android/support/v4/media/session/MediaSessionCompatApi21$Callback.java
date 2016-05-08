package android.support.v4.media.session;

import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.media.session.MediaSessionCompatApi19$Callback;

interface MediaSessionCompatApi21$Callback extends MediaSessionCompatApi19$Callback {
   void onCommand(String var1, Bundle var2, ResultReceiver var3);

   void onCustomAction(String var1, Bundle var2);

   void onFastForward();

   boolean onMediaButtonEvent(Intent var1);

   void onPause();

   void onPlay();

   void onPlayFromMediaId(String var1, Bundle var2);

   void onPlayFromSearch(String var1, Bundle var2);

   void onRewind();

   void onSkipToNext();

   void onSkipToPrevious();

   void onSkipToQueueItem(long var1);

   void onStop();
}
