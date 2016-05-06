package android.support.v4.widget;

import android.os.Parcelable;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;

protected static class SavedState extends View$BaseSavedState
{
    public static final Parcelable$Creator<SavedState> CREATOR;
    int lockModeEnd;
    int lockModeLeft;
    int lockModeRight;
    int lockModeStart;
    int openDrawerGravity;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<SavedState>() {
            DrawerLayout$SavedState$1() {
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
        this.openDrawerGravity = 0;
        this.openDrawerGravity = parcel.readInt();
        this.lockModeLeft = parcel.readInt();
        this.lockModeRight = parcel.readInt();
        this.lockModeStart = parcel.readInt();
        this.lockModeEnd = parcel.readInt();
    }
    
    public SavedState(final Parcelable parcelable) {
        super(parcelable);
        this.openDrawerGravity = 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        super.writeToParcel(parcel, n);
        parcel.writeInt(openDrawerGravity);
        parcel.writeInt(lockModeLeft);
        parcel.writeInt(lockModeRight);
        parcel.writeInt(lockModeStart);
        parcel.writeInt(lockModeEnd);
    }
}
