package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.PlaybackStateCompat$CustomAction;

public abstract class MediaControllerCompat$TransportControls {
   public abstract void fastForward();

   public abstract void pause();

   public abstract void play();

   public abstract void playFromMediaId(String var1, Bundle var2);

   public abstract void playFromSearch(String var1, Bundle var2);

   public abstract void playFromUri(Uri var1, Bundle var2);

   public abstract void rewind();

   public abstract void seekTo(long var1);

   public abstract void sendCustomAction(PlaybackStateCompat$CustomAction var1, Bundle var2);

   public abstract void sendCustomAction(String var1, Bundle var2);

   public abstract void setRating(RatingCompat var1);

   public abstract void skipToNext();

   public abstract void skipToPrevious();

   public abstract void skipToQueueItem(long var1);

   public abstract void stop();
}
