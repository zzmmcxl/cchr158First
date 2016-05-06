package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;

public static class SavedState extends View$BaseSavedState
{
    public static final Parcelable$Creator<SavedState> CREATOR;
    Parcelable mLayoutState;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<SavedState>() {
            RecyclerView$SavedState$1() {
                super();
            }
            
            public SavedState createFromParcel(final Parcel parcel) {
                return new SavedState(parcel);
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.createFromParcel(parcel);
            }
            
            public SavedState[] newArray(final int n) {
                return new SavedState[n];
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.newArray(n);
            }
        };
    }
    
    SavedState(final Parcel parcel) {
        super(parcel);
        this.mLayoutState = parcel.readParcelable(LayoutManager.class.getClassLoader());
    }
    
    SavedState(final Parcelable parcelable) {
        super(parcelable);
    }
    
    static /* synthetic */ void access$1900(final SavedState savedState, final SavedState savedState2) {
        savedState.copyFrom(savedState2);
    }
    
    private void copyFrom(final SavedState savedState) {
        mLayoutState = mLayoutState;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        super.writeToParcel(parcel, n);
        parcel.writeParcelable(mLayoutState, 0);
    }
}
