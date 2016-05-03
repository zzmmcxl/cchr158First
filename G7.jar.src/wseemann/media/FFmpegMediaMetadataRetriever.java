package wseemann.media;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import java.io.FileDescriptor;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;

public class FFmpegMediaMetadataRetriever
{
  public static Bitmap.Config IN_PREFERRED_CONFIG;
  private static final String[] JNI_LIBRARIES = { "avutil", "swscale", "avcodec", "avformat", "ffmpeg_mediametadataretriever_jni" };
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
  
  static
  {
    int i = 0;
    while (i < JNI_LIBRARIES.length)
    {
      System.loadLibrary(JNI_LIBRARIES[i]);
      i += 1;
    }
    native_init();
  }
  
  public FFmpegMediaMetadataRetriever()
  {
    native_setup();
  }
  
  private native byte[] _getFrameAtTime(long paramLong, int paramInt);
  
  private native byte[] _getScaledFrameAtTime(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  private native void _setDataSource(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
    throws IllegalArgumentException;
  
  private final native void native_finalize();
  
  private final native HashMap<String, String> native_getMetadata(boolean paramBoolean1, boolean paramBoolean2, HashMap<String, String> paramHashMap);
  
  private static native void native_init();
  
  private native void native_setup();
  
  public native String extractMetadata(String paramString);
  
  public native String extractMetadataFromChapter(String paramString, int paramInt);
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      native_finalize();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public native byte[] getEmbeddedPicture();
  
  public Bitmap getFrameAtTime()
  {
    return getFrameAtTime(-1L, 2);
  }
  
  public Bitmap getFrameAtTime(long paramLong)
  {
    Bitmap localBitmap = null;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDither = false;
    byte[] arrayOfByte = _getFrameAtTime(paramLong, 2);
    if (arrayOfByte != null) {
      localBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
    }
    return localBitmap;
  }
  
  public Bitmap getFrameAtTime(long paramLong, int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 3)) {
      throw new IllegalArgumentException("Unsupported option: " + paramInt);
    }
    Bitmap localBitmap = null;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDither = false;
    byte[] arrayOfByte = _getFrameAtTime(paramLong, paramInt);
    if (arrayOfByte != null) {
      localBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
    }
    return localBitmap;
  }
  
  public Metadata getMetadata()
  {
    Metadata localMetadata2 = new Metadata();
    HashMap localHashMap = native_getMetadata(false, false, null);
    Metadata localMetadata1;
    if (localHashMap == null) {
      localMetadata1 = null;
    }
    do
    {
      return localMetadata1;
      localMetadata1 = localMetadata2;
    } while (localMetadata2.parse(localHashMap));
    return null;
  }
  
  public Bitmap getScaledFrameAtTime(long paramLong, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = null;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDither = false;
    byte[] arrayOfByte = _getScaledFrameAtTime(paramLong, 2, paramInt1, paramInt2);
    if (arrayOfByte != null) {
      localBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
    }
    return localBitmap;
  }
  
  public Bitmap getScaledFrameAtTime(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt1 > 3)) {
      throw new IllegalArgumentException("Unsupported option: " + paramInt1);
    }
    Bitmap localBitmap = null;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDither = false;
    byte[] arrayOfByte = _getScaledFrameAtTime(paramLong, paramInt1, paramInt2, paramInt3);
    if (arrayOfByte != null) {
      localBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
    }
    return localBitmap;
  }
  
  public native void release();
  
  /* Error */
  public void setDataSource(android.content.Context paramContext, android.net.Uri paramUri)
    throws IllegalArgumentException, java.lang.SecurityException
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +11 -> 12
    //   4: new 159	java/lang/IllegalArgumentException
    //   7: dup
    //   8: invokespecial 243	java/lang/IllegalArgumentException:<init>	()V
    //   11: athrow
    //   12: aload_2
    //   13: invokevirtual 248	android/net/Uri:getScheme	()Ljava/lang/String;
    //   16: astore_3
    //   17: aload_3
    //   18: ifnull +12 -> 30
    //   21: aload_3
    //   22: ldc -6
    //   24: invokevirtual 254	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   27: ifeq +12 -> 39
    //   30: aload_0
    //   31: aload_2
    //   32: invokevirtual 257	android/net/Uri:getPath	()Ljava/lang/String;
    //   35: invokevirtual 259	wseemann/media/FFmpegMediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   38: return
    //   39: aconst_null
    //   40: astore 6
    //   42: aconst_null
    //   43: astore 5
    //   45: aload 5
    //   47: astore_3
    //   48: aload 6
    //   50: astore 4
    //   52: aload_1
    //   53: invokevirtual 265	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   56: astore_1
    //   57: aload 5
    //   59: astore_3
    //   60: aload 6
    //   62: astore 4
    //   64: aload_1
    //   65: aload_2
    //   66: ldc_w 267
    //   69: invokevirtual 273	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   72: astore_1
    //   73: aload_1
    //   74: ifnonnull +63 -> 137
    //   77: aload_1
    //   78: astore_3
    //   79: aload_1
    //   80: astore 4
    //   82: new 159	java/lang/IllegalArgumentException
    //   85: dup
    //   86: invokespecial 243	java/lang/IllegalArgumentException:<init>	()V
    //   89: athrow
    //   90: astore_1
    //   91: aload_3
    //   92: ifnull +7 -> 99
    //   95: aload_3
    //   96: invokevirtual 278	android/content/res/AssetFileDescriptor:close	()V
    //   99: aload_0
    //   100: aload_2
    //   101: invokevirtual 279	android/net/Uri:toString	()Ljava/lang/String;
    //   104: invokevirtual 259	wseemann/media/FFmpegMediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   107: return
    //   108: astore_1
    //   109: aload 5
    //   111: astore_3
    //   112: aload 6
    //   114: astore 4
    //   116: new 159	java/lang/IllegalArgumentException
    //   119: dup
    //   120: invokespecial 243	java/lang/IllegalArgumentException:<init>	()V
    //   123: athrow
    //   124: astore_1
    //   125: aload 4
    //   127: ifnull +8 -> 135
    //   130: aload 4
    //   132: invokevirtual 278	android/content/res/AssetFileDescriptor:close	()V
    //   135: aload_1
    //   136: athrow
    //   137: aload_1
    //   138: astore_3
    //   139: aload_1
    //   140: astore 4
    //   142: aload_1
    //   143: invokevirtual 283	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   146: astore 5
    //   148: aload_1
    //   149: astore_3
    //   150: aload_1
    //   151: astore 4
    //   153: aload 5
    //   155: invokevirtual 289	java/io/FileDescriptor:valid	()Z
    //   158: ifne +16 -> 174
    //   161: aload_1
    //   162: astore_3
    //   163: aload_1
    //   164: astore 4
    //   166: new 159	java/lang/IllegalArgumentException
    //   169: dup
    //   170: invokespecial 243	java/lang/IllegalArgumentException:<init>	()V
    //   173: athrow
    //   174: aload_1
    //   175: astore_3
    //   176: aload_1
    //   177: astore 4
    //   179: aload_1
    //   180: invokevirtual 293	android/content/res/AssetFileDescriptor:getDeclaredLength	()J
    //   183: lconst_0
    //   184: lcmp
    //   185: ifge +25 -> 210
    //   188: aload_1
    //   189: astore_3
    //   190: aload_1
    //   191: astore 4
    //   193: aload_0
    //   194: aload 5
    //   196: invokevirtual 296	wseemann/media/FFmpegMediaMetadataRetriever:setDataSource	(Ljava/io/FileDescriptor;)V
    //   199: aload_1
    //   200: ifnull -162 -> 38
    //   203: aload_1
    //   204: invokevirtual 278	android/content/res/AssetFileDescriptor:close	()V
    //   207: return
    //   208: astore_1
    //   209: return
    //   210: aload_1
    //   211: astore_3
    //   212: aload_1
    //   213: astore 4
    //   215: aload_0
    //   216: aload 5
    //   218: aload_1
    //   219: invokevirtual 299	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   222: aload_1
    //   223: invokevirtual 293	android/content/res/AssetFileDescriptor:getDeclaredLength	()J
    //   226: invokevirtual 302	wseemann/media/FFmpegMediaMetadataRetriever:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   229: goto -30 -> 199
    //   232: astore_1
    //   233: goto -134 -> 99
    //   236: astore_2
    //   237: goto -102 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	this	FFmpegMediaMetadataRetriever
    //   0	240	1	paramContext	android.content.Context
    //   0	240	2	paramUri	android.net.Uri
    //   16	196	3	localObject1	Object
    //   50	164	4	localObject2	Object
    //   43	174	5	localFileDescriptor	FileDescriptor
    //   40	73	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   52	57	90	java/lang/SecurityException
    //   64	73	90	java/lang/SecurityException
    //   82	90	90	java/lang/SecurityException
    //   116	124	90	java/lang/SecurityException
    //   142	148	90	java/lang/SecurityException
    //   153	161	90	java/lang/SecurityException
    //   166	174	90	java/lang/SecurityException
    //   179	188	90	java/lang/SecurityException
    //   193	199	90	java/lang/SecurityException
    //   215	229	90	java/lang/SecurityException
    //   64	73	108	java/io/FileNotFoundException
    //   52	57	124	finally
    //   64	73	124	finally
    //   82	90	124	finally
    //   116	124	124	finally
    //   142	148	124	finally
    //   153	161	124	finally
    //   166	174	124	finally
    //   179	188	124	finally
    //   193	199	124	finally
    //   215	229	124	finally
    //   203	207	208	java/io/IOException
    //   95	99	232	java/io/IOException
    //   130	135	236	java/io/IOException
  }
  
  public void setDataSource(FileDescriptor paramFileDescriptor)
    throws IllegalArgumentException
  {
    setDataSource(paramFileDescriptor, 0L, 576460752303423487L);
  }
  
  public native void setDataSource(FileDescriptor paramFileDescriptor, long paramLong1, long paramLong2)
    throws IllegalArgumentException;
  
  public native void setDataSource(String paramString)
    throws IllegalArgumentException;
  
  public void setDataSource(String paramString, Map<String, String> paramMap)
    throws IllegalArgumentException
  {
    int i = 0;
    String[] arrayOfString1 = new String[paramMap.size()];
    String[] arrayOfString2 = new String[paramMap.size()];
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      arrayOfString1[i] = ((String)localEntry.getKey());
      arrayOfString2[i] = ((String)localEntry.getValue());
      i += 1;
    }
    _setDataSource(paramString, arrayOfString1, arrayOfString2);
  }
  
  public native void setSurface(Object paramObject);
  
  public class Metadata
  {
    public static final int BOOLEAN_VAL = 3;
    public static final int BYTE_ARRAY_VAL = 7;
    public static final int DATE_VAL = 6;
    public static final int DOUBLE_VAL = 5;
    public static final int INTEGER_VAL = 2;
    public static final int LONG_VAL = 4;
    public static final int STRING_VAL = 1;
    private HashMap<String, String> mParcel;
    
    public Metadata() {}
    
    private boolean checkMetadataId(String paramString)
    {
      return true;
    }
    
    private void checkType(String paramString, int paramInt)
    {
      paramString = (String)this.mParcel.get(paramString);
      if (paramString == null) {
        throw new IllegalStateException("Wrong type " + paramInt + " but got " + paramString);
      }
    }
    
    public HashMap<String, String> getAll()
    {
      return this.mParcel;
    }
    
    public boolean getBoolean(String paramString)
    {
      checkType(paramString, 3);
      return Integer.valueOf((String)this.mParcel.get(paramString)).intValue() == 1;
    }
    
    public byte[] getByteArray(String paramString)
    {
      checkType(paramString, 7);
      return ((String)this.mParcel.get(paramString)).getBytes();
    }
    
    public Date getDate(String paramString)
    {
      checkType(paramString, 6);
      long l = Long.valueOf((String)this.mParcel.get(paramString)).longValue();
      paramString = (String)this.mParcel.get(paramString);
      if (paramString.length() == 0) {
        return new Date(l);
      }
      paramString = Calendar.getInstance(TimeZone.getTimeZone(paramString));
      paramString.setTimeInMillis(l);
      return paramString.getTime();
    }
    
    public double getDouble(String paramString)
    {
      checkType(paramString, 5);
      return Double.valueOf((String)this.mParcel.get(paramString)).doubleValue();
    }
    
    public int getInt(String paramString)
    {
      checkType(paramString, 2);
      return Integer.valueOf((String)this.mParcel.get(paramString)).intValue();
    }
    
    public long getLong(String paramString)
    {
      checkType(paramString, 4);
      return Long.valueOf((String)this.mParcel.get(paramString)).longValue();
    }
    
    public String getString(String paramString)
    {
      checkType(paramString, 1);
      return String.valueOf(this.mParcel.get(paramString));
    }
    
    public boolean has(String paramString)
    {
      if (!checkMetadataId(paramString)) {
        throw new IllegalArgumentException("Invalid key: " + paramString);
      }
      return this.mParcel.containsKey(paramString);
    }
    
    public boolean parse(HashMap<String, String> paramHashMap)
    {
      if (paramHashMap == null) {
        return false;
      }
      this.mParcel = paramHashMap;
      return true;
    }
  }
}


/* Location:              C:\Users\colin\Documents\GitHub\cchr158First\G7.jar!\wseemann\media\FFmpegMediaMetadataRetriever.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */