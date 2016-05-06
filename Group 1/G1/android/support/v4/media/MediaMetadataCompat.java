package android.support.v4.media;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;
import java.util.Set;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.graphics.Bitmap;
import android.os.Build$VERSION;
import android.os.Parcel;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class MediaMetadataCompat implements Parcelable
{
    public static final Parcelable$Creator<MediaMetadataCompat> CREATOR;
    private static final ArrayMap<String, Integer> METADATA_KEYS_TYPE;
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
        (METADATA_KEYS_TYPE = new ArrayMap<String, Integer>()).put("android.media.metadata.TITLE", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.ARTIST", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.DURATION", 0);
        METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.AUTHOR", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.WRITER", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.COMPOSER", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.COMPILATION", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.DATE", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.YEAR", 0);
        METADATA_KEYS_TYPE.put("android.media.metadata.GENRE", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.TRACK_NUMBER", 0);
        METADATA_KEYS_TYPE.put("android.media.metadata.NUM_TRACKS", 0);
        METADATA_KEYS_TYPE.put("android.media.metadata.DISC_NUMBER", 0);
        METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ARTIST", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.ART", 2);
        METADATA_KEYS_TYPE.put("android.media.metadata.ART_URI", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ART", 2);
        METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ART_URI", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.USER_RATING", 3);
        METADATA_KEYS_TYPE.put("android.media.metadata.RATING", 3);
        METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_TITLE", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_SUBTITLE", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_DESCRIPTION", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_ICON", 2);
        METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_ICON_URI", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.MEDIA_ID", 1);
        PREFERRED_DESCRIPTION_ORDER = new String[] { "android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER" };
        PREFERRED_BITMAP_ORDER = new String[] { "android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART" };
        PREFERRED_URI_ORDER = new String[] { "android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI" };
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<MediaMetadataCompat>() {
            MediaMetadataCompat$1() {
                super();
            }
            
            public MediaMetadataCompat createFromParcel(final Parcel parcel) {
                return new MediaMetadataCompat(parcel, null);
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.createFromParcel(parcel);
            }
            
            public MediaMetadataCompat[] newArray(final int n) {
                return new MediaMetadataCompat[n];
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.newArray(n);
            }
        };
    }
    
    private MediaMetadataCompat(final Bundle bundle) {
        super();
        mBundle = new Bundle(bundle);
    }
    
    MediaMetadataCompat(final Bundle bundle, final MediaMetadataCompat$1 parcelable$Creator) {
        this(bundle);
    }
    
    private MediaMetadataCompat(final Parcel parcel) {
        super();
        mBundle = parcel.readBundle();
    }
    
    MediaMetadataCompat(final Parcel parcel, final MediaMetadataCompat$1 parcelable$Creator) {
        this(parcel);
    }
    
    static /* synthetic */ Bundle access$100(final MediaMetadataCompat mediaMetadataCompat) {
        return mediaMetadataCompat.mBundle;
    }
    
    static /* synthetic */ ArrayMap access$200() {
        return METADATA_KEYS_TYPE;
    }
    
    public static MediaMetadataCompat fromMediaMetadata(final Object mMetadataObj) {
        if (mMetadataObj == null || Build$VERSION.SDK_INT < 21) {
            return null;
        }
        final Parcel obtain = Parcel.obtain();
        MediaMetadataCompatApi21.writeToParcel(mMetadataObj, obtain, 0);
        obtain.setDataPosition(0);
        final MediaMetadataCompat mediaMetadataCompat = (MediaMetadataCompat)CREATOR.createFromParcel(obtain);
        obtain.recycle();
        mediaMetadataCompat.mMetadataObj = mMetadataObj;
        return mediaMetadataCompat;
    }
    
    public boolean containsKey(final String s) {
        return mBundle.containsKey(s);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public Bitmap getBitmap(final String s) {
        try {
            return (Bitmap)mBundle.getParcelable(s);
        }
        catch (Exception ex) {
            Log.w("MediaMetadata", "Failed to retrieve a key as Bitmap.", (Throwable)ex);
            return null;
        }
    }
    
    public Bundle getBundle() {
        return mBundle;
    }
    
    public MediaDescriptionCompat getDescription() {
        if (mDescription != null) {
            return mDescription;
        }
        final String string = this.getString("android.media.metadata.MEDIA_ID");
        final CharSequence[] array = new CharSequence[3];
        final CharSequence text = this.getText("android.media.metadata.DISPLAY_TITLE");
        if (!TextUtils.isEmpty(text)) {
            array[0] = text;
            array[1] = this.getText("android.media.metadata.DISPLAY_SUBTITLE");
            array[2] = this.getText("android.media.metadata.DISPLAY_DESCRIPTION");
        }
        else {
            int n3;
            for (int n = 0, n2 = 0; n < array.length && n2 < PREFERRED_DESCRIPTION_ORDER.length; n2 = n3) {
                final String[] preferred_DESCRIPTION_ORDER = PREFERRED_DESCRIPTION_ORDER;
                n3 = n2 + 1;
                final CharSequence text2 = this.getText(preferred_DESCRIPTION_ORDER[n2]);
                if (!TextUtils.isEmpty(text2)) {
                    final int n4 = n + 1;
                    array[n] = text2;
                    n = n4;
                }
            }
        }
        int n5 = 0;
        Bitmap iconBitmap;
        while (true) {
            final int length = PREFERRED_BITMAP_ORDER.length;
            iconBitmap = null;
            if (n5 >= length) {
                break;
            }
            final Bitmap bitmap = this.getBitmap(PREFERRED_BITMAP_ORDER[n5]);
            if (bitmap != null) {
                iconBitmap = bitmap;
                break;
            }
            ++n5;
        }
        int n6 = 0;
        Uri parse;
        while (true) {
            final int length2 = PREFERRED_URI_ORDER.length;
            parse = null;
            if (n6 >= length2) {
                break;
            }
            final String string2 = this.getString(PREFERRED_URI_ORDER[n6]);
            if (!TextUtils.isEmpty((CharSequence)string2)) {
                parse = Uri.parse(string2);
                break;
            }
            ++n6;
        }
        final MediaDescriptionCompat.Builder builder = new MediaDescriptionCompat.Builder();
        builder.setMediaId(string);
        builder.setTitle(array[0]);
        builder.setSubtitle(array[1]);
        builder.setDescription(array[2]);
        builder.setIconBitmap(iconBitmap);
        builder.setIconUri(parse);
        return mDescription = builder.build();
    }
    
    public long getLong(final String s) {
        return mBundle.getLong(s, 0L);
    }
    
    public Object getMediaMetadata() {
        if (mMetadataObj != null || Build$VERSION.SDK_INT < 21) {
            return mMetadataObj;
        }
        final Parcel obtain = Parcel.obtain();
        this.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        mMetadataObj = MediaMetadataCompatApi21.createFromParcel(obtain);
        obtain.recycle();
        return mMetadataObj;
    }
    
    public RatingCompat getRating(final String s) {
        try {
            if (Build$VERSION.SDK_INT >= 21) {
                return RatingCompat.fromRating(mBundle.getParcelable(s));
            }
            return (RatingCompat)mBundle.getParcelable(s);
        }
        catch (Exception ex) {
            Log.w("MediaMetadata", "Failed to retrieve a key as Rating.", (Throwable)ex);
            return null;
        }
    }
    
    public String getString(final String s) {
        final CharSequence charSequence = mBundle.getCharSequence(s);
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }
    
    public CharSequence getText(final String s) {
        return mBundle.getCharSequence(s);
    }
    
    public Set<String> keySet() {
        return (Set<String>)mBundle.keySet();
    }
    
    public int size() {
        return mBundle.size();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeBundle(mBundle);
    }
}
