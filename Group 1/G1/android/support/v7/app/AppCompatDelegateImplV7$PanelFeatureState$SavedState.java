package android.support.v7.app;

import android.support.v4.os.ParcelableCompat;
import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

private static class SavedState implements Parcelable
{
    public static final Parcelable$Creator<SavedState> CREATOR;
    int featureId;
    boolean isOpen;
    Bundle menuState;
    
    static {
        CREATOR = ParcelableCompat.<SavedState>newCreator((ParcelableCompatCreatorCallbacks<SavedState>)new ParcelableCompatCreatorCallbacks<SavedState>() {
            AppCompatDelegateImplV7$PanelFeatureState$SavedState$1() {
                super();
            }
            
            @Override
            public SavedState createFromParcel(final Parcel parcel, final ClassLoader classLoader) {
                return readFromParcel(parcel, classLoader);
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
        });
    }
    
    private SavedState() {
        super();
    }
    
    SavedState(final AppCompatDelegateImplV7$1 runnable) {
        this();
    }
    
    static /* synthetic */ SavedState access$1300(final Parcel parcel, final ClassLoader classLoader) {
        return readFromParcel(parcel, classLoader);
    }
    
    private static SavedState readFromParcel(final Parcel parcel, final ClassLoader classLoader) {
        boolean isOpen = true;
        final SavedState savedState = new SavedState();
        savedState.featureId = parcel.readInt();
        if (parcel.readInt() != (isOpen ? 1 : 0)) {
            isOpen = false;
        }
        savedState.isOpen = isOpen;
        if (savedState.isOpen) {
            savedState.menuState = parcel.readBundle(classLoader);
        }
        return savedState;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt(featureId);
        int n2;
        if (isOpen) {
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        parcel.writeInt(n2);
        if (isOpen) {
            parcel.writeBundle(menuState);
        }
    }
}
