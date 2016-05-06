package android.support.v7.widget;

import android.os.Parcelable;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;

static class SavedState extends View$BaseSavedState
{
    public static final Parcelable$Creator<SavedState> CREATOR;
    boolean isIconified;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<SavedState>() {
            SearchView$SavedState$1() {
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
        this.isIconified = (boolean)parcel.readValue((ClassLoader)null);
    }
    
    SavedState(final Parcelable parcelable) {
        super(parcelable);
    }
    
    public String toString() {
        return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode((Object)this)) + " isIconified=" + isIconified + "}";
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        super.writeToParcel(parcel, n);
        parcel.writeValue((Object)isIconified);
    }
}
