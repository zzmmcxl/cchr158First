package android.support.design.internal;

import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;

static final class ParcelableSparseArray$1 implements ParcelableCompatCreatorCallbacks<ParcelableSparseArray> {
    ParcelableSparseArray$1() {
        super();
    }
    
    @Override
    public ParcelableSparseArray createFromParcel(final Parcel parcel, final ClassLoader classLoader) {
        return new ParcelableSparseArray(parcel, classLoader);
    }
    
    @Override
    public /* bridge */ Object createFromParcel(final Parcel parcel, final ClassLoader classLoader) {
        return this.createFromParcel(parcel, classLoader);
    }
    
    @Override
    public ParcelableSparseArray[] newArray(final int n) {
        return new ParcelableSparseArray[n];
    }
    
    @Override
    public /* bridge */ Object[] newArray(final int n) {
        return this.newArray(n);
    }
}