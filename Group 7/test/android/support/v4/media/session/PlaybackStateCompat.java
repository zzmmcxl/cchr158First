package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.support.v4.media.session.PlaybackStateCompat$1;
import android.support.v4.media.session.PlaybackStateCompat$CustomAction;
import android.support.v4.media.session.PlaybackStateCompatApi21;
import android.support.v4.media.session.PlaybackStateCompatApi22;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
   public static final long ACTION_FAST_FORWARD = 64L;
   public static final long ACTION_PAUSE = 2L;
   public static final long ACTION_PLAY = 4L;
   public static final long ACTION_PLAY_FROM_MEDIA_ID = 1024L;
   public static final long ACTION_PLAY_FROM_SEARCH = 2048L;
   public static final long ACTION_PLAY_FROM_URI = 8192L;
   public static final long ACTION_PLAY_PAUSE = 512L;
   public static final long ACTION_REWIND = 8L;
   public static final long ACTION_SEEK_TO = 256L;
   public static final long ACTION_SET_RATING = 128L;
   public static final long ACTION_SKIP_TO_NEXT = 32L;
   public static final long ACTION_SKIP_TO_PREVIOUS = 16L;
   public static final long ACTION_SKIP_TO_QUEUE_ITEM = 4096L;
   public static final long ACTION_STOP = 1L;
   public static final Creator<PlaybackStateCompat> CREATOR = new PlaybackStateCompat$1();
   public static final long PLAYBACK_POSITION_UNKNOWN = -1L;
   public static final int STATE_BUFFERING = 6;
   public static final int STATE_CONNECTING = 8;
   public static final int STATE_ERROR = 7;
   public static final int STATE_FAST_FORWARDING = 4;
   public static final int STATE_NONE = 0;
   public static final int STATE_PAUSED = 2;
   public static final int STATE_PLAYING = 3;
   public static final int STATE_REWINDING = 5;
   public static final int STATE_SKIPPING_TO_NEXT = 10;
   public static final int STATE_SKIPPING_TO_PREVIOUS = 9;
   public static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11;
   public static final int STATE_STOPPED = 1;
   private final long mActions;
   private final long mActiveItemId;
   private final long mBufferedPosition;
   private List<PlaybackStateCompat$CustomAction> mCustomActions;
   private final CharSequence mErrorMessage;
   private final Bundle mExtras;
   private final long mPosition;
   private final float mSpeed;
   private final int mState;
   private Object mStateObj;
   private final long mUpdateTime;

   private PlaybackStateCompat(int var1, long var2, long var4, float var6, long var7, CharSequence var9, long var10, List<PlaybackStateCompat$CustomAction> var12, long var13, Bundle var15) {
      this.mState = var1;
      this.mPosition = var2;
      this.mBufferedPosition = var4;
      this.mSpeed = var6;
      this.mActions = var7;
      this.mErrorMessage = var9;
      this.mUpdateTime = var10;
      this.mCustomActions = new ArrayList(var12);
      this.mActiveItemId = var13;
      this.mExtras = var15;
   }

   private PlaybackStateCompat(Parcel var1) {
      this.mState = var1.readInt();
      this.mPosition = var1.readLong();
      this.mSpeed = var1.readFloat();
      this.mUpdateTime = var1.readLong();
      this.mBufferedPosition = var1.readLong();
      this.mActions = var1.readLong();
      this.mErrorMessage = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(var1);
      this.mCustomActions = var1.createTypedArrayList(PlaybackStateCompat$CustomAction.CREATOR);
      this.mActiveItemId = var1.readLong();
      this.mExtras = var1.readBundle();
   }

   public static PlaybackStateCompat fromPlaybackState(Object var0) {
      if(var0 != null && VERSION.SDK_INT >= 21) {
         List var3 = PlaybackStateCompatApi21.getCustomActions(var0);
         ArrayList var1 = null;
         if(var3 != null) {
            ArrayList var2 = new ArrayList(var3.size());
            Iterator var6 = var3.iterator();

            while(true) {
               var1 = var2;
               if(!var6.hasNext()) {
                  break;
               }

               var2.add(PlaybackStateCompat$CustomAction.fromCustomAction(var6.next()));
            }
         }

         Bundle var5;
         if(VERSION.SDK_INT >= 22) {
            var5 = PlaybackStateCompatApi22.getExtras(var0);
         } else {
            var5 = null;
         }

         PlaybackStateCompat var4 = new PlaybackStateCompat(PlaybackStateCompatApi21.getState(var0), PlaybackStateCompatApi21.getPosition(var0), PlaybackStateCompatApi21.getBufferedPosition(var0), PlaybackStateCompatApi21.getPlaybackSpeed(var0), PlaybackStateCompatApi21.getActions(var0), PlaybackStateCompatApi21.getErrorMessage(var0), PlaybackStateCompatApi21.getLastPositionUpdateTime(var0), var1, PlaybackStateCompatApi21.getActiveQueueItemId(var0), var5);
         var4.mStateObj = var0;
         return var4;
      } else {
         return null;
      }
   }

   public int describeContents() {
      return 0;
   }

   public long getActions() {
      return this.mActions;
   }

   public long getActiveQueueItemId() {
      return this.mActiveItemId;
   }

   public long getBufferedPosition() {
      return this.mBufferedPosition;
   }

   public List<PlaybackStateCompat$CustomAction> getCustomActions() {
      return this.mCustomActions;
   }

   public CharSequence getErrorMessage() {
      return this.mErrorMessage;
   }

   @Nullable
   public Bundle getExtras() {
      return this.mExtras;
   }

   public long getLastPositionUpdateTime() {
      return this.mUpdateTime;
   }

   public float getPlaybackSpeed() {
      return this.mSpeed;
   }

   public Object getPlaybackState() {
      if(this.mStateObj == null && VERSION.SDK_INT >= 21) {
         ArrayList var1 = null;
         if(this.mCustomActions != null) {
            ArrayList var2 = new ArrayList(this.mCustomActions.size());
            Iterator var3 = this.mCustomActions.iterator();

            while(true) {
               var1 = var2;
               if(!var3.hasNext()) {
                  break;
               }

               var2.add(((PlaybackStateCompat$CustomAction)var3.next()).getCustomAction());
            }
         }

         if(VERSION.SDK_INT >= 22) {
            this.mStateObj = PlaybackStateCompatApi22.newInstance(this.mState, this.mPosition, this.mBufferedPosition, this.mSpeed, this.mActions, this.mErrorMessage, this.mUpdateTime, var1, this.mActiveItemId, this.mExtras);
         } else {
            this.mStateObj = PlaybackStateCompatApi21.newInstance(this.mState, this.mPosition, this.mBufferedPosition, this.mSpeed, this.mActions, this.mErrorMessage, this.mUpdateTime, var1, this.mActiveItemId);
         }

         return this.mStateObj;
      } else {
         return this.mStateObj;
      }
   }

   public long getPosition() {
      return this.mPosition;
   }

   public int getState() {
      return this.mState;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("PlaybackState {");
      var1.append("state=").append(this.mState);
      var1.append(", position=").append(this.mPosition);
      var1.append(", buffered position=").append(this.mBufferedPosition);
      var1.append(", speed=").append(this.mSpeed);
      var1.append(", updated=").append(this.mUpdateTime);
      var1.append(", actions=").append(this.mActions);
      var1.append(", error=").append(this.mErrorMessage);
      var1.append(", custom actions=").append(this.mCustomActions);
      var1.append(", active item id=").append(this.mActiveItemId);
      var1.append("}");
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeInt(this.mState);
      var1.writeLong(this.mPosition);
      var1.writeFloat(this.mSpeed);
      var1.writeLong(this.mUpdateTime);
      var1.writeLong(this.mBufferedPosition);
      var1.writeLong(this.mActions);
      TextUtils.writeToParcel(this.mErrorMessage, var1, var2);
      var1.writeTypedList(this.mCustomActions);
      var1.writeLong(this.mActiveItemId);
      var1.writeBundle(this.mExtras);
   }
}
