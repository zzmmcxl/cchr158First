package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.PlaybackStateCompat$1;
import android.support.v4.media.session.PlaybackStateCompat$CustomAction;

final class PlaybackStateCompat$CustomAction$1 implements Creator<PlaybackStateCompat$CustomAction> {
   public PlaybackStateCompat$CustomAction createFromParcel(Parcel var1) {
      return new PlaybackStateCompat$CustomAction(var1, (PlaybackStateCompat$1)null);
   }

   public PlaybackStateCompat$CustomAction[] newArray(int var1) {
      return new PlaybackStateCompat$CustomAction[var1];
   }
}
