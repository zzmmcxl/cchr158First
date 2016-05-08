package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.MediaBrowserCompat$1;
import android.support.v4.media.MediaBrowserCompat$MediaItem;

final class MediaBrowserCompat$MediaItem$1 implements Creator<MediaBrowserCompat$MediaItem> {
   public MediaBrowserCompat$MediaItem createFromParcel(Parcel var1) {
      return new MediaBrowserCompat$MediaItem(var1, (MediaBrowserCompat$1)null);
   }

   public MediaBrowserCompat$MediaItem[] newArray(int var1) {
      return new MediaBrowserCompat$MediaItem[var1];
   }
}
