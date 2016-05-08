package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.v4.media.MediaBrowserCompat$MediaItem$1;
import android.support.v4.media.MediaDescriptionCompat;
import android.text.TextUtils;

public class MediaBrowserCompat$MediaItem implements Parcelable {
   public static final Creator<MediaBrowserCompat$MediaItem> CREATOR = new MediaBrowserCompat$MediaItem$1();
   public static final int FLAG_BROWSABLE = 1;
   public static final int FLAG_PLAYABLE = 2;
   private final MediaDescriptionCompat mDescription;
   private final int mFlags;

   private MediaBrowserCompat$MediaItem(Parcel var1) {
      this.mFlags = var1.readInt();
      this.mDescription = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(var1);
   }

   public MediaBrowserCompat$MediaItem(@NonNull MediaDescriptionCompat var1, int var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("description cannot be null");
      } else if(TextUtils.isEmpty(var1.getMediaId())) {
         throw new IllegalArgumentException("description must have a non-empty media id");
      } else {
         this.mFlags = var2;
         this.mDescription = var1;
      }
   }

   public int describeContents() {
      return 0;
   }

   @NonNull
   public MediaDescriptionCompat getDescription() {
      return this.mDescription;
   }

   public int getFlags() {
      return this.mFlags;
   }

   @NonNull
   public String getMediaId() {
      return this.mDescription.getMediaId();
   }

   public boolean isBrowsable() {
      return (this.mFlags & 1) != 0;
   }

   public boolean isPlayable() {
      return (this.mFlags & 2) != 0;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("MediaItem{");
      var1.append("mFlags=").append(this.mFlags);
      var1.append(", mDescription=").append(this.mDescription);
      var1.append('}');
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeInt(this.mFlags);
      this.mDescription.writeToParcel(var1, var2);
   }
}
