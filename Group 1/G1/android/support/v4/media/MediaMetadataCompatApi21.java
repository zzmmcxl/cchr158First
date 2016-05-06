package android.support.v4.media;

import android.media.Rating;
import android.media.MediaMetadata$Builder;
import java.util.Set;
import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.os.Parcel;

class MediaMetadataCompatApi21
{
    MediaMetadataCompatApi21() {
        super();
    }
    
    public static Object createFromParcel(final Parcel parcel) {
        return MediaMetadata.CREATOR.createFromParcel(parcel);
    }
    
    public static Bitmap getBitmap(final Object o, final String s) {
        return ((MediaMetadata)o).getBitmap(s);
    }
    
    public static long getLong(final Object o, final String s) {
        return ((MediaMetadata)o).getLong(s);
    }
    
    public static Object getRating(final Object o, final String s) {
        return ((MediaMetadata)o).getRating(s);
    }
    
    public static CharSequence getText(final Object o, final String s) {
        return ((MediaMetadata)o).getText(s);
    }
    
    public static Set<String> keySet(final Object o) {
        return (Set<String>)((MediaMetadata)o).keySet();
    }
    
    public static void writeToParcel(final Object o, final Parcel parcel, final int n) {
        ((MediaMetadata)o).writeToParcel(parcel, n);
    }
}
