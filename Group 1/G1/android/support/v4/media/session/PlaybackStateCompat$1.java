package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable$Creator;

static final class PlaybackStateCompat$1 implements Parcelable$Creator<PlaybackStateCompat> {
    PlaybackStateCompat$1() {
        super();
    }
    
    public PlaybackStateCompat createFromParcel(final Parcel parcel) {
        return new PlaybackStateCompat(parcel, null);
    }
    
    public /* bridge */ Object createFromParcel(final Parcel parcel) {
        return this.createFromParcel(parcel);
    }
    
    public PlaybackStateCompat[] newArray(final int n) {
        return new PlaybackStateCompat[n];
    }
    
    public /* bridge */ Object[] newArray(final int n) {
        return this.newArray(n);
    }
}