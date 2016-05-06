package android.support.v7.app;

import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;

static final class AppCompatDelegateImplV7$PanelFeatureState$SavedState$1 implements ParcelableCompatCreatorCallbacks<SavedState> {
    AppCompatDelegateImplV7$PanelFeatureState$SavedState$1() {
        super();
    }
    
    @Override
    public SavedState createFromParcel(final Parcel parcel, final ClassLoader classLoader) {
        return SavedState.access$1300(parcel, classLoader);
    }
    
    @Override
    public /* bridge */ Object createFromParcel(final Parcel parcel, final ClassLoader classLoader) {
        return this.createFromParcel(parcel, classLoader);
    }
    
    @Override
    public SavedState[] newArray(final int n) {
        return new SavedState[n];
    }
    
    @Override
    public /* bridge */ Object[] newArray(final int n) {
        return this.newArray(n);
    }
}