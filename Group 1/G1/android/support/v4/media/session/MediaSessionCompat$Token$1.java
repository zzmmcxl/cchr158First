package android.support.v4.media.session;

import android.os.Build$VERSION;
import android.os.Parcel;
import android.os.Parcelable$Creator;

static final class MediaSessionCompat$Token$1 implements Parcelable$Creator<Token> {
    MediaSessionCompat$Token$1() {
        super();
    }
    
    public Token createFromParcel(final Parcel parcel) {
        Object o;
        if (Build$VERSION.SDK_INT >= 21) {
            o = parcel.readParcelable((ClassLoader)null);
        }
        else {
            o = parcel.readStrongBinder();
        }
        return new Token(o);
    }
    
    public /* bridge */ Object createFromParcel(final Parcel parcel) {
        return this.createFromParcel(parcel);
    }
    
    public Token[] newArray(final int n) {
        return new Token[n];
    }
    
    public /* bridge */ Object[] newArray(final int n) {
        return this.newArray(n);
    }
}