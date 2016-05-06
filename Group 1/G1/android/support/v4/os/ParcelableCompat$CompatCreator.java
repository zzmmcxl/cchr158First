package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable$Creator;

static class CompatCreator<T> implements Parcelable$Creator<T>
{
    final ParcelableCompatCreatorCallbacks<T> mCallbacks;
    
    public CompatCreator(final ParcelableCompatCreatorCallbacks<T> mCallbacks) {
        super();
        this.mCallbacks = mCallbacks;
    }
    
    public T createFromParcel(final Parcel parcel) {
        return mCallbacks.createFromParcel(parcel, null);
    }
    
    public T[] newArray(final int n) {
        return mCallbacks.newArray(n);
    }
}
