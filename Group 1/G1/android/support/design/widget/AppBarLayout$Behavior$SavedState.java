package android.support.design.widget;

import android.os.Parcelable;
import android.support.v4.os.ParcelableCompat;
import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;

protected static class SavedState extends View$BaseSavedState
{
    public static final Parcelable$Creator<SavedState> CREATOR;
    boolean firstVisibileChildAtMinimumHeight;
    float firstVisibileChildPercentageShown;
    int firstVisibleChildIndex;
    
    static {
        CREATOR = ParcelableCompat.<SavedState>newCreator((ParcelableCompatCreatorCallbacks<SavedState>)new ParcelableCompatCreatorCallbacks<SavedState>() {
            AppBarLayout$Behavior$SavedState$1() {
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
    
    public SavedState(final Parcel parcel, final ClassLoader classLoader) {
        super(parcel);
        this.firstVisibleChildIndex = parcel.readInt();
        this.firstVisibileChildPercentageShown = parcel.readFloat();
        this.firstVisibileChildAtMinimumHeight = (parcel.readByte() != 0);
    }
    
    public SavedState(final Parcelable parcelable) {
        super(parcelable);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        super.writeToParcel(parcel, n);
        parcel.writeInt(firstVisibleChildIndex);
        parcel.writeFloat(firstVisibileChildPercentageShown);
        boolean b;
        if (firstVisibileChildAtMinimumHeight) {
            b = true;
        }
        else {
            b = false;
        }
        parcel.writeByte((byte)(byte)(b ? 1 : 0));
    }
}
