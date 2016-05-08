package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.support.v4.media.MediaDescriptionCompat$1;
import android.support.v4.media.MediaDescriptionCompat$Builder;
import android.support.v4.media.MediaDescriptionCompatApi21;
import android.support.v4.media.MediaDescriptionCompatApi21$Builder;
import android.support.v4.media.MediaDescriptionCompatApi23;
import android.support.v4.media.MediaDescriptionCompatApi23$Builder;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
   public static final Creator<MediaDescriptionCompat> CREATOR = new MediaDescriptionCompat$1();
   public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
   public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
   private final CharSequence mDescription;
   private Object mDescriptionObj;
   private final Bundle mExtras;
   private final Bitmap mIcon;
   private final Uri mIconUri;
   private final String mMediaId;
   private final Uri mMediaUri;
   private final CharSequence mSubtitle;
   private final CharSequence mTitle;

   private MediaDescriptionCompat(Parcel var1) {
      this.mMediaId = var1.readString();
      this.mTitle = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(var1);
      this.mSubtitle = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(var1);
      this.mDescription = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(var1);
      this.mIcon = (Bitmap)var1.readParcelable((ClassLoader)null);
      this.mIconUri = (Uri)var1.readParcelable((ClassLoader)null);
      this.mExtras = var1.readBundle();
      this.mMediaUri = (Uri)var1.readParcelable((ClassLoader)null);
   }

   private MediaDescriptionCompat(String var1, CharSequence var2, CharSequence var3, CharSequence var4, Bitmap var5, Uri var6, Bundle var7, Uri var8) {
      this.mMediaId = var1;
      this.mTitle = var2;
      this.mSubtitle = var3;
      this.mDescription = var4;
      this.mIcon = var5;
      this.mIconUri = var6;
      this.mExtras = var7;
      this.mMediaUri = var8;
   }

   public static MediaDescriptionCompat fromMediaDescription(Object var0) {
      if(var0 != null && VERSION.SDK_INT >= 21) {
         MediaDescriptionCompat$Builder var4 = new MediaDescriptionCompat$Builder();
         var4.setMediaId(MediaDescriptionCompatApi21.getMediaId(var0));
         var4.setTitle(MediaDescriptionCompatApi21.getTitle(var0));
         var4.setSubtitle(MediaDescriptionCompatApi21.getSubtitle(var0));
         var4.setDescription(MediaDescriptionCompatApi21.getDescription(var0));
         var4.setIconBitmap(MediaDescriptionCompatApi21.getIconBitmap(var0));
         var4.setIconUri(MediaDescriptionCompatApi21.getIconUri(var0));
         Bundle var3 = MediaDescriptionCompatApi21.getExtras(var0);
         Uri var1;
         if(var3 == null) {
            var1 = null;
         } else {
            var1 = (Uri)var3.getParcelable("android.support.v4.media.description.MEDIA_URI");
         }

         Bundle var2 = var3;
         if(var1 != null) {
            if(var3.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && var3.size() == 2) {
               var2 = null;
            } else {
               var3.remove("android.support.v4.media.description.MEDIA_URI");
               var3.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
               var2 = var3;
            }
         }

         var4.setExtras(var2);
         if(var1 != null) {
            var4.setMediaUri(var1);
         } else if(VERSION.SDK_INT >= 23) {
            var4.setMediaUri(MediaDescriptionCompatApi23.getMediaUri(var0));
         }

         MediaDescriptionCompat var5 = var4.build();
         var5.mDescriptionObj = var0;
         return var5;
      } else {
         return null;
      }
   }

   public int describeContents() {
      return 0;
   }

   @Nullable
   public CharSequence getDescription() {
      return this.mDescription;
   }

   @Nullable
   public Bundle getExtras() {
      return this.mExtras;
   }

   @Nullable
   public Bitmap getIconBitmap() {
      return this.mIcon;
   }

   @Nullable
   public Uri getIconUri() {
      return this.mIconUri;
   }

   public Object getMediaDescription() {
      if(this.mDescriptionObj == null && VERSION.SDK_INT >= 21) {
         Object var3 = MediaDescriptionCompatApi21$Builder.newInstance();
         MediaDescriptionCompatApi21$Builder.setMediaId(var3, this.mMediaId);
         MediaDescriptionCompatApi21$Builder.setTitle(var3, this.mTitle);
         MediaDescriptionCompatApi21$Builder.setSubtitle(var3, this.mSubtitle);
         MediaDescriptionCompatApi21$Builder.setDescription(var3, this.mDescription);
         MediaDescriptionCompatApi21$Builder.setIconBitmap(var3, this.mIcon);
         MediaDescriptionCompatApi21$Builder.setIconUri(var3, this.mIconUri);
         Bundle var2 = this.mExtras;
         Bundle var1 = var2;
         if(VERSION.SDK_INT < 23) {
            var1 = var2;
            if(this.mMediaUri != null) {
               var1 = var2;
               if(var2 == null) {
                  var1 = new Bundle();
                  var1.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
               }

               var1.putParcelable("android.support.v4.media.description.MEDIA_URI", this.mMediaUri);
            }
         }

         MediaDescriptionCompatApi21$Builder.setExtras(var3, var1);
         if(VERSION.SDK_INT >= 23) {
            MediaDescriptionCompatApi23$Builder.setMediaUri(var3, this.mMediaUri);
         }

         this.mDescriptionObj = MediaDescriptionCompatApi21$Builder.build(var3);
         return this.mDescriptionObj;
      } else {
         return this.mDescriptionObj;
      }
   }

   @Nullable
   public String getMediaId() {
      return this.mMediaId;
   }

   @Nullable
   public Uri getMediaUri() {
      return this.mMediaUri;
   }

   @Nullable
   public CharSequence getSubtitle() {
      return this.mSubtitle;
   }

   @Nullable
   public CharSequence getTitle() {
      return this.mTitle;
   }

   public String toString() {
      return this.mTitle + ", " + this.mSubtitle + ", " + this.mDescription;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(VERSION.SDK_INT < 21) {
         var1.writeString(this.mMediaId);
         TextUtils.writeToParcel(this.mTitle, var1, var2);
         TextUtils.writeToParcel(this.mSubtitle, var1, var2);
         TextUtils.writeToParcel(this.mDescription, var1, var2);
         var1.writeParcelable(this.mIcon, var2);
         var1.writeParcelable(this.mIconUri, var2);
         var1.writeBundle(this.mExtras);
         var1.writeParcelable(this.mMediaUri, var2);
      } else {
         MediaDescriptionCompatApi21.writeToParcel(this.getMediaDescription(), var1, var2);
      }
   }
}
