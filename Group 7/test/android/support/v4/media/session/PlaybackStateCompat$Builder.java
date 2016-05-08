package android.support.v4.media.session;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.session.PlaybackStateCompat$1;
import android.support.v4.media.session.PlaybackStateCompat$CustomAction;
import java.util.ArrayList;
import java.util.List;

public final class PlaybackStateCompat$Builder {
   private long mActions;
   private long mActiveItemId = -1L;
   private long mBufferedPosition;
   private final List<PlaybackStateCompat$CustomAction> mCustomActions = new ArrayList();
   private CharSequence mErrorMessage;
   private Bundle mExtras;
   private long mPosition;
   private float mRate;
   private int mState;
   private long mUpdateTime;

   public PlaybackStateCompat$Builder() {
   }

   public PlaybackStateCompat$Builder(PlaybackStateCompat var1) {
      this.mState = PlaybackStateCompat.access$300(var1);
      this.mPosition = PlaybackStateCompat.access$400(var1);
      this.mRate = PlaybackStateCompat.access$500(var1);
      this.mUpdateTime = PlaybackStateCompat.access$600(var1);
      this.mBufferedPosition = PlaybackStateCompat.access$700(var1);
      this.mActions = PlaybackStateCompat.access$800(var1);
      this.mErrorMessage = PlaybackStateCompat.access$900(var1);
      if(PlaybackStateCompat.access$1000(var1) != null) {
         this.mCustomActions.addAll(PlaybackStateCompat.access$1000(var1));
      }

      this.mActiveItemId = PlaybackStateCompat.access$1100(var1);
      this.mExtras = PlaybackStateCompat.access$1200(var1);
   }

   public PlaybackStateCompat$Builder addCustomAction(PlaybackStateCompat$CustomAction var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat.");
      } else {
         this.mCustomActions.add(var1);
         return this;
      }
   }

   public PlaybackStateCompat$Builder addCustomAction(String var1, String var2, int var3) {
      return this.addCustomAction(new PlaybackStateCompat$CustomAction(var1, var2, var3, (Bundle)null, (PlaybackStateCompat$1)null));
   }

   public PlaybackStateCompat build() {
      return new PlaybackStateCompat(this.mState, this.mPosition, this.mBufferedPosition, this.mRate, this.mActions, this.mErrorMessage, this.mUpdateTime, this.mCustomActions, this.mActiveItemId, this.mExtras, (PlaybackStateCompat$1)null);
   }

   public PlaybackStateCompat$Builder setActions(long var1) {
      this.mActions = var1;
      return this;
   }

   public PlaybackStateCompat$Builder setActiveQueueItemId(long var1) {
      this.mActiveItemId = var1;
      return this;
   }

   public PlaybackStateCompat$Builder setBufferedPosition(long var1) {
      this.mBufferedPosition = var1;
      return this;
   }

   public PlaybackStateCompat$Builder setErrorMessage(CharSequence var1) {
      this.mErrorMessage = var1;
      return this;
   }

   public PlaybackStateCompat$Builder setExtras(Bundle var1) {
      this.mExtras = var1;
      return this;
   }

   public PlaybackStateCompat$Builder setState(int var1, long var2, float var4) {
      return this.setState(var1, var2, var4, SystemClock.elapsedRealtime());
   }

   public PlaybackStateCompat$Builder setState(int var1, long var2, float var4, long var5) {
      this.mState = var1;
      this.mPosition = var2;
      this.mUpdateTime = var5;
      this.mRate = var4;
      return this;
   }
}
