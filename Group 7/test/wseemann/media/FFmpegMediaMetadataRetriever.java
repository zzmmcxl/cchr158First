package wseemann.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import java.io.FileDescriptor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import wseemann.media.FFmpegMediaMetadataRetriever$Metadata;

public class FFmpegMediaMetadataRetriever {
   public static Config IN_PREFERRED_CONFIG;
   private static final String[] JNI_LIBRARIES = new String[]{"avutil", "swscale", "avcodec", "avformat", "ffmpeg_mediametadataretriever_jni"};
   public static final String METADATA_CHAPTER_COUNT = "chapter_count";
   public static final String METADATA_KEY_ALBUM = "album";
   public static final String METADATA_KEY_ALBUM_ARTIST = "album_artist";
   public static final String METADATA_KEY_ARTIST = "artist";
   public static final String METADATA_KEY_AUDIO_CODEC = "audio_codec";
   public static final String METADATA_KEY_CHAPTER_END_TIME = "chapter_end_time";
   public static final String METADATA_KEY_CHAPTER_START_TIME = "chapter_start_time";
   public static final String METADATA_KEY_COMMENT = "comment";
   public static final String METADATA_KEY_COMPOSER = "composer";
   public static final String METADATA_KEY_COPYRIGHT = "copyright";
   public static final String METADATA_KEY_CREATION_TIME = "creation_time";
   public static final String METADATA_KEY_DATE = "date";
   public static final String METADATA_KEY_DISC = "disc";
   public static final String METADATA_KEY_DURATION = "duration";
   public static final String METADATA_KEY_ENCODED_BY = "encoded_by";
   public static final String METADATA_KEY_ENCODER = "encoder";
   public static final String METADATA_KEY_FILENAME = "filename";
   public static final String METADATA_KEY_FILESIZE = "filesize";
   public static final String METADATA_KEY_FRAMERATE = "framerate";
   public static final String METADATA_KEY_GENRE = "genre";
   public static final String METADATA_KEY_ICY_METADATA = "icy_metadata";
   public static final String METADATA_KEY_LANGUAGE = "language";
   public static final String METADATA_KEY_PERFORMER = "performer";
   public static final String METADATA_KEY_PUBLISHER = "publisher";
   public static final String METADATA_KEY_SERVICE_NAME = "service_name";
   public static final String METADATA_KEY_SERVICE_PROVIDER = "service_provider";
   public static final String METADATA_KEY_TITLE = "title";
   public static final String METADATA_KEY_TRACK = "track";
   public static final String METADATA_KEY_VARIANT_BITRATE = "bitrate";
   public static final String METADATA_KEY_VIDEO_CODEC = "video_codec";
   public static final String METADATA_KEY_VIDEO_ROTATION = "rotate";
   public static final int OPTION_CLOSEST = 3;
   public static final int OPTION_CLOSEST_SYNC = 2;
   public static final int OPTION_NEXT_SYNC = 1;
   public static final int OPTION_PREVIOUS_SYNC = 0;
   private static final String TAG = "FFmpegMediaMetadataRetriever";
   private long mNativeContext;

   static {
      for(int var0 = 0; var0 < JNI_LIBRARIES.length; ++var0) {
         System.loadLibrary(JNI_LIBRARIES[var0]);
      }

      native_init();
   }

   public FFmpegMediaMetadataRetriever() {
      this.native_setup();
   }

   private native byte[] _getFrameAtTime(long var1, int var3);

   private native byte[] _getScaledFrameAtTime(long var1, int var3, int var4, int var5);

   private native void _setDataSource(String var1, String[] var2, String[] var3) throws IllegalArgumentException;

   private final native void native_finalize();

   private final native HashMap<String, String> native_getMetadata(boolean var1, boolean var2, HashMap<String, String> var3);

   private static native void native_init();

   private native void native_setup();

   public native String extractMetadata(String var1);

   public native String extractMetadataFromChapter(String var1, int var2);

   protected void finalize() throws Throwable {
      boolean var3 = false;

      try {
         var3 = true;
         this.native_finalize();
         var3 = false;
      } finally {
         if(var3) {
            super.finalize();
         }
      }

      super.finalize();
   }

   public native byte[] getEmbeddedPicture();

   public Bitmap getFrameAtTime() {
      return this.getFrameAtTime(-1L, 2);
   }

   public Bitmap getFrameAtTime(long var1) {
      Bitmap var3 = null;
      Options var4 = new Options();
      var4.inDither = false;
      byte[] var5 = this._getFrameAtTime(var1, 2);
      if(var5 != null) {
         var3 = BitmapFactory.decodeByteArray(var5, 0, var5.length, var4);
      }

      return var3;
   }

   public Bitmap getFrameAtTime(long var1, int var3) {
      if(var3 >= 0 && var3 <= 3) {
         Bitmap var4 = null;
         Options var5 = new Options();
         var5.inDither = false;
         byte[] var6 = this._getFrameAtTime(var1, var3);
         if(var6 != null) {
            var4 = BitmapFactory.decodeByteArray(var6, 0, var6.length, var5);
         }

         return var4;
      } else {
         throw new IllegalArgumentException("Unsupported option: " + var3);
      }
   }

   public FFmpegMediaMetadataRetriever$Metadata getMetadata() {
      FFmpegMediaMetadataRetriever$Metadata var2 = new FFmpegMediaMetadataRetriever$Metadata(this);
      HashMap var3 = this.native_getMetadata(false, false, (HashMap)null);
      FFmpegMediaMetadataRetriever$Metadata var1;
      if(var3 == null) {
         var1 = null;
      } else {
         var1 = var2;
         if(!var2.parse(var3)) {
            return null;
         }
      }

      return var1;
   }

   public Bitmap getScaledFrameAtTime(long var1, int var3, int var4) {
      Bitmap var5 = null;
      Options var6 = new Options();
      var6.inDither = false;
      byte[] var7 = this._getScaledFrameAtTime(var1, 2, var3, var4);
      if(var7 != null) {
         var5 = BitmapFactory.decodeByteArray(var7, 0, var7.length, var6);
      }

      return var5;
   }

   public Bitmap getScaledFrameAtTime(long var1, int var3, int var4, int var5) {
      if(var3 >= 0 && var3 <= 3) {
         Bitmap var6 = null;
         Options var7 = new Options();
         var7.inDither = false;
         byte[] var8 = this._getScaledFrameAtTime(var1, var3, var4, var5);
         if(var8 != null) {
            var6 = BitmapFactory.decodeByteArray(var8, 0, var8.length, var7);
         }

         return var6;
      } else {
         throw new IllegalArgumentException("Unsupported option: " + var3);
      }
   }

   public native void release();

   public void setDataSource(Context param1, Uri param2) throws IllegalArgumentException, SecurityException {
      // $FF: Couldn't be decompiled
   }

   public void setDataSource(FileDescriptor var1) throws IllegalArgumentException {
      this.setDataSource(var1, 0L, 576460752303423487L);
   }

   public native void setDataSource(FileDescriptor var1, long var2, long var4) throws IllegalArgumentException;

   public native void setDataSource(String var1) throws IllegalArgumentException;

   public void setDataSource(String var1, Map<String, String> var2) throws IllegalArgumentException {
      int var3 = 0;
      String[] var4 = new String[var2.size()];
      String[] var5 = new String[var2.size()];

      for(Iterator var7 = var2.entrySet().iterator(); var7.hasNext(); ++var3) {
         Entry var6 = (Entry)var7.next();
         var4[var3] = (String)var6.getKey();
         var5[var3] = (String)var6.getValue();
      }

      this._setDataSource(var1, var4, var5);
   }

   public native void setSurface(Object var1);
}
