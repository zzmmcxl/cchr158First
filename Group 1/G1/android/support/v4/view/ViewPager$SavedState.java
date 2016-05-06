package android.support.v4.view;

import android.support.v4.os.ParcelableCompat;
import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;

public static class SavedState extends View$BaseSavedState
{
    public static final Parcelable$Creator<SavedState> CREATOR;
    Parcelable adapterState;
    ClassLoader loader;
    int position;
    
    static {
        CREATOR = ParcelableCompat.<SavedState>newCreator((ParcelableCompatCreatorCallbacks<SavedState>)new ParcelableCompatCreatorCallbacks<SavedState>() {
            ViewPager$SavedState$1() {
                super();
            }
            
            @Override
            public SavedState createFromParcel(final Parcel parcel, final ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
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
    
    SavedState(final Parcel parcel, ClassLoader classLoader) {
        super(parcel);
        if (classLoader == null) {
            classLoader = this.getClass().getClassLoader();
        }
        this.position = parcel.readInt();
        this.adapterState = parcel.readParcelable(classLoader);
        this.loader = classLoader;
    }
    
    public SavedState(final Parcelable parcelable) {
        super(parcelable);
    }
    
    public String toString() {
        return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode((Object)this)) + " position=" + position + "}";
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        super.writeToParcel(parcel, n);
        parcel.writeInt(position);
        parcel.writeParcelable(adapterState, n);
    }
}
