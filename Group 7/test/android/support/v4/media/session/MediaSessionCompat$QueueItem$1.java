package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.MediaSessionCompat$1;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;

final class MediaSessionCompat$QueueItem$1 implements Creator<MediaSessionCompat$QueueItem> {
   public MediaSessionCompat$QueueItem createFromParcel(Parcel var1) {
      return new MediaSessionCompat$QueueItem(var1, (MediaSessionCompat$1)null);
   }

   public MediaSessionCompat$QueueItem[] newArray(int var1) {
      return new MediaSessionCompat$QueueItem[var1];
   }
}
