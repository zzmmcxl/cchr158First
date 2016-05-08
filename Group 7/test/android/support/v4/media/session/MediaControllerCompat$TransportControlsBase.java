package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaControllerCompat$TransportControls;
import android.support.v4.media.session.PlaybackStateCompat$CustomAction;
import android.util.Log;

class MediaControllerCompat$TransportControlsBase extends MediaControllerCompat$TransportControls {
   private IMediaSession mBinder;

   public MediaControllerCompat$TransportControlsBase(IMediaSession var1) {
      this.mBinder = var1;
   }

   public void fastForward() {
      try {
         this.mBinder.fastForward();
      } catch (RemoteException var2) {
         Log.e("MediaControllerCompat", "Dead object in fastForward. " + var2);
      }
   }

   public void pause() {
      try {
         this.mBinder.pause();
      } catch (RemoteException var2) {
         Log.e("MediaControllerCompat", "Dead object in pause. " + var2);
      }
   }

   public void play() {
      try {
         this.mBinder.play();
      } catch (RemoteException var2) {
         Log.e("MediaControllerCompat", "Dead object in play. " + var2);
      }
   }

   public void playFromMediaId(String var1, Bundle var2) {
      try {
         this.mBinder.playFromMediaId(var1, var2);
      } catch (RemoteException var3) {
         Log.e("MediaControllerCompat", "Dead object in playFromMediaId. " + var3);
      }
   }

   public void playFromSearch(String var1, Bundle var2) {
      try {
         this.mBinder.playFromSearch(var1, var2);
      } catch (RemoteException var3) {
         Log.e("MediaControllerCompat", "Dead object in playFromSearch. " + var3);
      }
   }

   public void playFromUri(Uri var1, Bundle var2) {
      try {
         this.mBinder.playFromUri(var1, var2);
      } catch (RemoteException var3) {
         Log.e("MediaControllerCompat", "Dead object in playFromUri. " + var3);
      }
   }

   public void rewind() {
      try {
         this.mBinder.rewind();
      } catch (RemoteException var2) {
         Log.e("MediaControllerCompat", "Dead object in rewind. " + var2);
      }
   }

   public void seekTo(long var1) {
      try {
         this.mBinder.seekTo(var1);
      } catch (RemoteException var4) {
         Log.e("MediaControllerCompat", "Dead object in seekTo. " + var4);
      }
   }

   public void sendCustomAction(PlaybackStateCompat$CustomAction var1, Bundle var2) {
      this.sendCustomAction(var1.getAction(), var2);
   }

   public void sendCustomAction(String var1, Bundle var2) {
      try {
         this.mBinder.sendCustomAction(var1, var2);
      } catch (RemoteException var3) {
         Log.e("MediaControllerCompat", "Dead object in sendCustomAction. " + var3);
      }
   }

   public void setRating(RatingCompat var1) {
      try {
         this.mBinder.rate(var1);
      } catch (RemoteException var2) {
         Log.e("MediaControllerCompat", "Dead object in setRating. " + var2);
      }
   }

   public void skipToNext() {
      try {
         this.mBinder.next();
      } catch (RemoteException var2) {
         Log.e("MediaControllerCompat", "Dead object in skipToNext. " + var2);
      }
   }

   public void skipToPrevious() {
      try {
         this.mBinder.previous();
      } catch (RemoteException var2) {
         Log.e("MediaControllerCompat", "Dead object in skipToPrevious. " + var2);
      }
   }

   public void skipToQueueItem(long var1) {
      try {
         this.mBinder.skipToQueueItem(var1);
      } catch (RemoteException var4) {
         Log.e("MediaControllerCompat", "Dead object in skipToQueueItem. " + var4);
      }
   }

   public void stop() {
      try {
         this.mBinder.stop();
      } catch (RemoteException var2) {
         Log.e("MediaControllerCompat", "Dead object in stop. " + var2);
      }
   }
}
