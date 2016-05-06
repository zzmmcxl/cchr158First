package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public static class SavedState implements Parcelable
{
    public static final Parcelable$Creator<SavedState> CREATOR;
    boolean mAnchorLayoutFromEnd;
    int mAnchorOffset;
    int mAnchorPosition;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<SavedState>() {
            LinearLayoutManager$SavedState$1() {
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
    
    public SavedState() {
        super();
    }
    
    SavedState(final Parcel parcel) {
        boolean mAnchorLayoutFromEnd = true;
        super();
        this.mAnchorPosition = parcel.readInt();
        this.mAnchorOffset = parcel.readInt();
        if (parcel.readInt() != (mAnchorLayoutFromEnd ? 1 : 0)) {
            mAnchorLayoutFromEnd = false;
        }
        this.mAnchorLayoutFromEnd = mAnchorLayoutFromEnd;
    }
    
    public SavedState(final SavedState savedState) {
        super();
        this.mAnchorPosition = savedState.mAnchorPosition;
        this.mAnchorOffset = savedState.mAnchorOffset;
        this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
    }
    
    public int describeContents() {
        return 0;
    }
    
    boolean hasValidAnchor() {
        return mAnchorPosition >= 0;
    }
    
    void invalidateAnchor() {
        mAnchorPosition = -1;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt(mAnchorPosition);
        parcel.writeInt(mAnchorOffset);
        int n2;
        if (mAnchorLayoutFromEnd) {
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        parcel.writeInt(n2);
    }
}
