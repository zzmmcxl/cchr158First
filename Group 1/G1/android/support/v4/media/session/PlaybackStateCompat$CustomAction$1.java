package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable$Creator;

static final class PlaybackStateCompat$CustomAction$1 implements Parcelable$Creator<CustomAction> {
    PlaybackStateCompat$CustomAction$1() {
        super();
    }
    
    public CustomAction createFromParcel(final Parcel parcel) {
        return new CustomAction(parcel);
    }
    
    public /* bridge */ Object createFromParcel(final Parcel parcel) {
        return this.createFromParcel(parcel);
    }
    
    public CustomAction[] newArray(final int n) {
        return new CustomAction[n];
    }
    
    public /* bridge */ Object[] newArray(final int n) {
        return this.newArray(n);
    }
}