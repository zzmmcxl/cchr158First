package android.support.v4.widget;

import android.os.Parcelable;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;

static class SavedState extends View$BaseSavedState
{
    public static final Parcelable$Creator<SavedState> CREATOR;
    public int scrollPosition;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<SavedState>() {
            NestedScrollView$SavedState$1() {
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
    
    public SavedState(final Parcel parcel) {
        super(parcel);
        this.scrollPosition = parcel.readInt();
    }
    
    SavedState(final Parcelable parcelable) {
        super(parcelable);
    }
    
    public String toString() {
        return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode((Object)this)) + " scrollPosition=" + scrollPosition + "}";
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        super.writeToParcel(parcel, n);
        parcel.writeInt(scrollPosition);
    }
}
