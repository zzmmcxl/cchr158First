package android.support.v4.media;

import android.os.Build$VERSION;
import android.os.Parcel;
import android.os.Parcelable$Creator;

static final class MediaDescriptionCompat$1 implements Parcelable$Creator<MediaDescriptionCompat> {
    MediaDescriptionCompat$1() {
        super();
    }
    
    public MediaDescriptionCompat createFromParcel(final Parcel parcel) {
        if (Build$VERSION.SDK_INT < 21) {
            return new MediaDescriptionCompat(parcel, null);
        }
        return MediaDescriptionCompat.fromMediaDescription(MediaDescriptionCompatApi21.fromParcel(parcel));
    }
    
    public /* bridge */ Object createFromParcel(final Parcel parcel) {
        return this.createFromParcel(parcel);
    }
    
    public MediaDescriptionCompat[] newArray(final int n) {
        return new MediaDescriptionCompat[n];
    }
    
    public /* bridge */ Object[] newArray(final int n) {
        return this.newArray(n);
    }
}