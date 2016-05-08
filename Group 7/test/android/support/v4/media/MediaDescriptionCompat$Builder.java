package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaDescriptionCompat$1;

public final class MediaDescriptionCompat$Builder {
   private CharSequence mDescription;
   private Bundle mExtras;
   private Bitmap mIcon;
   private Uri mIconUri;
   private String mMediaId;
   private Uri mMediaUri;
   private CharSequence mSubtitle;
   private CharSequence mTitle;

   public MediaDescriptionCompat build() {
      return new MediaDescriptionCompat(this.mMediaId, this.mTitle, this.mSubtitle, this.mDescription, this.mIcon, this.mIconUri, this.mExtras, this.mMediaUri, (MediaDescriptionCompat$1)null);
   }

   public MediaDescriptionCompat$Builder setDescription(@Nullable CharSequence var1) {
      this.mDescription = var1;
      return this;
   }

   public MediaDescriptionCompat$Builder setExtras(@Nullable Bundle var1) {
      this.mExtras = var1;
      return this;
   }

   public MediaDescriptionCompat$Builder setIconBitmap(@Nullable Bitmap var1) {
      this.mIcon = var1;
      return this;
   }

   public MediaDescriptionCompat$Builder setIconUri(@Nullable Uri var1) {
      this.mIconUri = var1;
      return this;
   }

   public MediaDescriptionCompat$Builder setMediaId(@Nullable String var1) {
      this.mMediaId = var1;
      return this;
   }

   public MediaDescriptionCompat$Builder setMediaUri(@Nullable Uri var1) {
      this.mMediaUri = var1;
      return this;
   }

   public MediaDescriptionCompat$Builder setSubtitle(@Nullable CharSequence var1) {
      this.mSubtitle = var1;
      return this;
   }

   public MediaDescriptionCompat$Builder setTitle(@Nullable CharSequence var1) {
      this.mTitle = var1;
      return this;
   }
}
