package android.support.v4.os;

import android.os.Parcel;
import android.os.Build$VERSION;
import android.os.Parcelable$Creator;

public final class ParcelableCompat
{
    private ParcelableCompat() {
        super();
    }
    
    public static <T> Parcelable$Creator<T> newCreator(final ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
        if (Build$VERSION.SDK_INT >= 13) {
            return ParcelableCompatCreatorHoneycombMR2Stub.<T>instantiate(parcelableCompatCreatorCallbacks);
        }
        return (Parcelable$Creator<T>)new CompatCreator((ParcelableCompatCreatorCallbacks<Object>)parcelableCompatCreatorCallbacks);
    }
}
