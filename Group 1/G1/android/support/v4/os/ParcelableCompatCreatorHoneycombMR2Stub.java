package android.support.v4.os;

import android.os.Parcelable$Creator;

class ParcelableCompatCreatorHoneycombMR2Stub
{
    ParcelableCompatCreatorHoneycombMR2Stub() {
        super();
    }
    
    static <T> Parcelable$Creator<T> instantiate(final ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
        return (Parcelable$Creator<T>)new ParcelableCompatCreatorHoneycombMR2((ParcelableCompatCreatorCallbacks<Object>)parcelableCompatCreatorCallbacks);
    }
}
