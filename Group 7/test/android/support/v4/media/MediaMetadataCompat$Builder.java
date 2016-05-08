package android.support.v4.media;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.MediaMetadataCompat$1;
import android.support.v4.media.RatingCompat;

public final class MediaMetadataCompat$Builder {
   private final Bundle mBundle;

   public MediaMetadataCompat$Builder() {
      this.mBundle = new Bundle();
   }

   public MediaMetadataCompat$Builder(MediaMetadataCompat var1) {
      this.mBundle = new Bundle(MediaMetadataCompat.access$100(var1));
   }

   public MediaMetadataCompat build() {
      return new MediaMetadataCompat(this.mBundle, (MediaMetadataCompat$1)null);
   }

   public MediaMetadataCompat$Builder putBitmap(String var1, Bitmap var2) {
      if(MediaMetadataCompat.access$200().containsKey(var1) && ((Integer)MediaMetadataCompat.access$200().get(var1)).intValue() != 2) {
         throw new IllegalArgumentException("The " + var1 + " key cannot be used to put a Bitmap");
      } else {
         this.mBundle.putParcelable(var1, var2);
         return this;
      }
   }

   public MediaMetadataCompat$Builder putLong(String var1, long var2) {
      if(MediaMetadataCompat.access$200().containsKey(var1) && ((Integer)MediaMetadataCompat.access$200().get(var1)).intValue() != 0) {
         throw new IllegalArgumentException("The " + var1 + " key cannot be used to put a long");
      } else {
         this.mBundle.putLong(var1, var2);
         return this;
      }
   }

   public MediaMetadataCompat$Builder putRating(String var1, RatingCompat var2) {
      if(MediaMetadataCompat.access$200().containsKey(var1) && ((Integer)MediaMetadataCompat.access$200().get(var1)).intValue() != 3) {
         throw new IllegalArgumentException("The " + var1 + " key cannot be used to put a Rating");
      } else if(VERSION.SDK_INT >= 21) {
         this.mBundle.putParcelable(var1, (Parcelable)var2.getRating());
         return this;
      } else {
         this.mBundle.putParcelable(var1, var2);
         return this;
      }
   }

   public MediaMetadataCompat$Builder putString(String var1, String var2) {
      if(MediaMetadataCompat.access$200().containsKey(var1) && ((Integer)MediaMetadataCompat.access$200().get(var1)).intValue() != 1) {
         throw new IllegalArgumentException("The " + var1 + " key cannot be used to put a String");
      } else {
         this.mBundle.putCharSequence(var1, var2);
         return this;
      }
   }

   public MediaMetadataCompat$Builder putText(String var1, CharSequence var2) {
      if(MediaMetadataCompat.access$200().containsKey(var1) && ((Integer)MediaMetadataCompat.access$200().get(var1)).intValue() != 1) {
         throw new IllegalArgumentException("The " + var1 + " key cannot be used to put a CharSequence");
      } else {
         this.mBundle.putCharSequence(var1, var2);
         return this;
      }
   }
}
