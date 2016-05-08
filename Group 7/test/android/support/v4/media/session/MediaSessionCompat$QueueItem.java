package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.MediaSessionCompat$QueueItem$1;
import android.support.v4.media.session.MediaSessionCompatApi21$QueueItem;

public final class MediaSessionCompat$QueueItem implements Parcelable {
   public static final Creator<MediaSessionCompat$QueueItem> CREATOR = new MediaSessionCompat$QueueItem$1();
   public static final int UNKNOWN_ID = -1;
   private final MediaDescriptionCompat mDescription;
   private final long mId;
   private Object mItem;

   private MediaSessionCompat$QueueItem(Parcel var1) {
      this.mDescription = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(var1);
      this.mId = var1.readLong();
   }

   public MediaSessionCompat$QueueItem(MediaDescriptionCompat var1, long var2) {
      this((Object)null, var1, var2);
   }

   private MediaSessionCompat$QueueItem(Object var1, MediaDescriptionCompat var2, long var3) {
      if(var2 == null) {
         throw new IllegalArgumentException("Description cannot be null.");
      } else if(var3 == -1L) {
         throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
      } else {
         this.mDescription = var2;
         this.mId = var3;
         this.mItem = var1;
      }
   }

   public static MediaSessionCompat$QueueItem obtain(Object var0) {
      return new MediaSessionCompat$QueueItem(var0, MediaDescriptionCompat.fromMediaDescription(MediaSessionCompatApi21$QueueItem.getDescription(var0)), MediaSessionCompatApi21$QueueItem.getQueueId(var0));
   }

   public int describeContents() {
      return 0;
   }

   public MediaDescriptionCompat getDescription() {
      return this.mDescription;
   }

   public long getQueueId() {
      return this.mId;
   }

   public Object getQueueItem() {
      if(this.mItem == null && VERSION.SDK_INT >= 21) {
         this.mItem = MediaSessionCompatApi21$QueueItem.createItem(this.mDescription.getMediaDescription(), this.mId);
         return this.mItem;
      } else {
         return this.mItem;
      }
   }

   public String toString() {
      return "MediaSession.QueueItem {Description=" + this.mDescription + ", Id=" + this.mId + " }";
   }

   public void writeToParcel(Parcel var1, int var2) {
      this.mDescription.writeToParcel(var1, var2);
      var1.writeLong(this.mId);
   }
}
