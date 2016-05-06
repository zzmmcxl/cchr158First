package android.support.v4.media.session;

import android.os.IBinder;
import android.os.Build$VERSION;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public static final class Token implements Parcelable
{
    public static final Parcelable$Creator<Token> CREATOR;
    private final Object mInner;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<Token>() {
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
        };
    }
    
    Token(final Object mInner) {
        super();
        this.mInner = mInner;
    }
    
    public static Token fromToken(final Object o) {
        if (o == null || Build$VERSION.SDK_INT < 21) {
            return null;
        }
        return new Token(MediaSessionCompatApi21.verifyToken(o));
    }
    
    public int describeContents() {
        return 0;
    }
    
    public Object getToken() {
        return mInner;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        if (Build$VERSION.SDK_INT >= 21) {
            parcel.writeParcelable((Parcelable)mInner, n);
            return;
        }
        parcel.writeStrongBinder((IBinder)mInner);
    }
}
