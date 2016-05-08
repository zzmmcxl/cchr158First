package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaDescriptionCompat$Builder;
import android.support.v4.media.MediaMetadataCompat$1;
import android.support.v4.media.MediaMetadataCompatApi21;
import android.support.v4.media.RatingCompat;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.util.Set;

public final class MediaMetadataCompat implements Parcelable {
   public static final Creator<MediaMetadataCompat> CREATOR;
   private static final ArrayMap<String, Integer> METADATA_KEYS_TYPE = new ArrayMap();
   public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
   public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
   public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
   public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
   public static final String METADATA_KEY_ART = "android.media.metadata.ART";
   public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
   public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
   public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
   public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
   public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
   public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
   public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
   public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
   public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
   public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
   public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
   public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
   public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
   public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
   public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
   public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
   public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
   public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
   public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
   public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
   public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
   public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
   private static final int METADATA_TYPE_BITMAP = 2;
   private static final int METADATA_TYPE_LONG = 0;
   private static final int METADATA_TYPE_RATING = 3;
   private static final int METADATA_TYPE_TEXT = 1;
   private static final String[] PREFERRED_BITMAP_ORDER;
   private static final String[] PREFERRED_DESCRIPTION_ORDER;
   private static final String[] PREFERRED_URI_ORDER;
   private static final String TAG = "MediaMetadata";
   private final Bundle mBundle;
   private MediaDescriptionCompat mDescription;
   private Object mMetadataObj;

   static {
      METADATA_KEYS_TYPE.put("android.media.metadata.TITLE", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.ARTIST", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.DURATION", Integer.valueOf(0));
      METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.AUTHOR", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.WRITER", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.COMPOSER", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.COMPILATION", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.DATE", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.YEAR", Integer.valueOf(0));
      METADATA_KEYS_TYPE.put("android.media.metadata.GENRE", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.TRACK_NUMBER", Integer.valueOf(0));
      METADATA_KEYS_TYPE.put("android.media.metadata.NUM_TRACKS", Integer.valueOf(0));
      METADATA_KEYS_TYPE.put("android.media.metadata.DISC_NUMBER", Integer.valueOf(0));
      METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ARTIST", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.ART", Integer.valueOf(2));
      METADATA_KEYS_TYPE.put("android.media.metadata.ART_URI", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ART", Integer.valueOf(2));
      METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ART_URI", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.USER_RATING", Integer.valueOf(3));
      METADATA_KEYS_TYPE.put("android.media.metadata.RATING", Integer.valueOf(3));
      METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_TITLE", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_SUBTITLE", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_DESCRIPTION", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_ICON", Integer.valueOf(2));
      METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_ICON_URI", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.MEDIA_ID", Integer.valueOf(1));
      PREFERRED_DESCRIPTION_ORDER = new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
      PREFERRED_BITMAP_ORDER = new String[]{"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
      PREFERRED_URI_ORDER = new String[]{"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};
      CREATOR = new MediaMetadataCompat$1();
   }

   private MediaMetadataCompat(Bundle var1) {
      this.mBundle = new Bundle(var1);
   }

   private MediaMetadataCompat(Parcel var1) {
      this.mBundle = var1.readBundle();
   }

   public static MediaMetadataCompat fromMediaMetadata(Object var0) {
      if(var0 != null && VERSION.SDK_INT >= 21) {
         Parcel var1 = Parcel.obtain();
         MediaMetadataCompatApi21.writeToParcel(var0, var1, 0);
         var1.setDataPosition(0);
         MediaMetadataCompat var2 = (MediaMetadataCompat)CREATOR.createFromParcel(var1);
         var1.recycle();
         var2.mMetadataObj = var0;
         return var2;
      } else {
         return null;
      }
   }

   public boolean containsKey(String var1) {
      return this.mBundle.containsKey(var1);
   }

   public int describeContents() {
      return 0;
   }

   public Bitmap getBitmap(String var1) {
      try {
         Bitmap var3 = (Bitmap)this.mBundle.getParcelable(var1);
         return var3;
      } catch (Exception var2) {
         Log.w("MediaMetadata", "Failed to retrieve a key as Bitmap.", var2);
         return null;
      }
   }

   public Bundle getBundle() {
      return this.mBundle;
   }

   public MediaDescriptionCompat getDescription() {
      if(this.mDescription != null) {
         return this.mDescription;
      } else {
         String var7 = this.getString("android.media.metadata.MEDIA_ID");
         CharSequence[] var8 = new CharSequence[3];
         Uri var5 = null;
         MediaDescriptionCompat$Builder var6 = null;
         CharSequence var4 = this.getText("android.media.metadata.DISPLAY_TITLE");
         int var1;
         if(!TextUtils.isEmpty(var4)) {
            var8[0] = var4;
            var8[1] = this.getText("android.media.metadata.DISPLAY_SUBTITLE");
            var8[2] = this.getText("android.media.metadata.DISPLAY_DESCRIPTION");
         } else {
            int var2 = 0;

            int var3;
            for(var1 = 0; var2 < var8.length && var1 < PREFERRED_DESCRIPTION_ORDER.length; var2 = var3) {
               var4 = this.getText(PREFERRED_DESCRIPTION_ORDER[var1]);
               var3 = var2;
               if(!TextUtils.isEmpty(var4)) {
                  var8[var2] = var4;
                  var3 = var2 + 1;
               }

               ++var1;
            }
         }

         var1 = 0;

         Bitmap var9;
         while(true) {
            var9 = var5;
            if(var1 >= PREFERRED_BITMAP_ORDER.length) {
               break;
            }

            var9 = this.getBitmap(PREFERRED_BITMAP_ORDER[var1]);
            if(var9 != null) {
               break;
            }

            ++var1;
         }

         var1 = 0;

         while(true) {
            var5 = var6;
            if(var1 >= PREFERRED_URI_ORDER.length) {
               break;
            }

            String var10 = this.getString(PREFERRED_URI_ORDER[var1]);
            if(!TextUtils.isEmpty(var10)) {
               var5 = Uri.parse(var10);
               break;
            }

            ++var1;
         }

         var6 = new MediaDescriptionCompat$Builder();
         var6.setMediaId(var7);
         var6.setTitle(var8[0]);
         var6.setSubtitle(var8[1]);
         var6.setDescription(var8[2]);
         var6.setIconBitmap(var9);
         var6.setIconUri(var5);
         this.mDescription = var6.build();
         return this.mDescription;
      }
   }

   public long getLong(String var1) {
      return this.mBundle.getLong(var1, 0L);
   }

   public Object getMediaMetadata() {
      if(this.mMetadataObj == null && VERSION.SDK_INT >= 21) {
         Parcel var1 = Parcel.obtain();
         this.writeToParcel(var1, 0);
         var1.setDataPosition(0);
         this.mMetadataObj = MediaMetadataCompatApi21.createFromParcel(var1);
         var1.recycle();
         return this.mMetadataObj;
      } else {
         return this.mMetadataObj;
      }
   }

   public RatingCompat getRating(String var1) {
      try {
         if(VERSION.SDK_INT >= 21) {
            return RatingCompat.fromRating(this.mBundle.getParcelable(var1));
         } else {
            RatingCompat var3 = (RatingCompat)this.mBundle.getParcelable(var1);
            return var3;
         }
      } catch (Exception var2) {
         Log.w("MediaMetadata", "Failed to retrieve a key as Rating.", var2);
         return null;
      }
   }

   public String getString(String var1) {
      CharSequence var2 = this.mBundle.getCharSequence(var1);
      return var2 != null?var2.toString():null;
   }

   public CharSequence getText(String var1) {
      return this.mBundle.getCharSequence(var1);
   }

   public Set<String> keySet() {
      return this.mBundle.keySet();
   }

   public int size() {
      return this.mBundle.size();
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeBundle(this.mBundle);
   }
}
