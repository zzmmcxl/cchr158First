package android.support.v4.app;

import android.os.Parcelable;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;

static class SavedState extends View$BaseSavedState
{
    public static final Parcelable$Creator<SavedState> CREATOR;
    String curTab;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<SavedState>() {
            FragmentTabHost$SavedState$1() {
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
    
    private SavedState(final Parcel parcel) {
        super(parcel);
        this.curTab = parcel.readString();
    }
    
    SavedState(final Parcel parcel, final FragmentTabHost$1 object) {
        this(parcel);
    }
    
    SavedState(final Parcelable parcelable) {
        super(parcelable);
    }
    
    public String toString() {
        return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode((Object)this)) + " curTab=" + curTab + "}";
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        super.writeToParcel(parcel, n);
        parcel.writeString(curTab);
    }
}
