package android.support.v7.widget;

import android.os.Parcel;
import java.util.List;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public static class SavedState implements Parcelable
{
    public static final Parcelable$Creator<SavedState> CREATOR;
    boolean mAnchorLayoutFromEnd;
    int mAnchorPosition;
    List<FullSpanItem> mFullSpanItems;
    boolean mLastLayoutRTL;
    boolean mReverseLayout;
    int[] mSpanLookup;
    int mSpanLookupSize;
    int[] mSpanOffsets;
    int mSpanOffsetsSize;
    int mVisibleAnchorPosition;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<SavedState>() {
            StaggeredGridLayoutManager$SavedState$1() {
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
        boolean mLastLayoutRTL = true;
        super();
        this.mAnchorPosition = parcel.readInt();
        this.mVisibleAnchorPosition = parcel.readInt();
        this.mSpanOffsetsSize = parcel.readInt();
        if (this.mSpanOffsetsSize > 0) {
            parcel.readIntArray(this.mSpanOffsets = new int[this.mSpanOffsetsSize]);
        }
        this.mSpanLookupSize = parcel.readInt();
        if (this.mSpanLookupSize > 0) {
            parcel.readIntArray(this.mSpanLookup = new int[this.mSpanLookupSize]);
        }
        this.mReverseLayout = (parcel.readInt() == (mLastLayoutRTL ? 1 : 0) && mLastLayoutRTL);
        this.mAnchorLayoutFromEnd = (parcel.readInt() == (mLastLayoutRTL ? 1 : 0) && mLastLayoutRTL);
        if (parcel.readInt() != (mLastLayoutRTL ? 1 : 0)) {
            mLastLayoutRTL = false;
        }
        this.mLastLayoutRTL = mLastLayoutRTL;
        this.mFullSpanItems = (List<FullSpanItem>)parcel.readArrayList(FullSpanItem.class.getClassLoader());
    }
    
    public SavedState(final SavedState savedState) {
        super();
        this.mSpanOffsetsSize = savedState.mSpanOffsetsSize;
        this.mAnchorPosition = savedState.mAnchorPosition;
        this.mVisibleAnchorPosition = savedState.mVisibleAnchorPosition;
        this.mSpanOffsets = savedState.mSpanOffsets;
        this.mSpanLookupSize = savedState.mSpanLookupSize;
        this.mSpanLookup = savedState.mSpanLookup;
        this.mReverseLayout = savedState.mReverseLayout;
        this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
        this.mLastLayoutRTL = savedState.mLastLayoutRTL;
        this.mFullSpanItems = savedState.mFullSpanItems;
    }
    
    public int describeContents() {
        return 0;
    }
    
    void invalidateAnchorPositionInfo() {
        mSpanOffsets = null;
        mSpanOffsetsSize = 0;
        mAnchorPosition = -1;
        mVisibleAnchorPosition = -1;
    }
    
    void invalidateSpanInfo() {
        mSpanOffsets = null;
        mSpanOffsetsSize = 0;
        mSpanLookupSize = 0;
        mSpanLookup = null;
        mFullSpanItems = null;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        int n2 = 1;
        parcel.writeInt(mAnchorPosition);
        parcel.writeInt(mVisibleAnchorPosition);
        parcel.writeInt(mSpanOffsetsSize);
        if (mSpanOffsetsSize > 0) {
            parcel.writeIntArray(mSpanOffsets);
        }
        parcel.writeInt(mSpanLookupSize);
        if (mSpanLookupSize > 0) {
            parcel.writeIntArray(mSpanLookup);
        }
        int n3;
        if (mReverseLayout) {
            n3 = n2;
        }
        else {
            n3 = 0;
        }
        parcel.writeInt(n3);
        int n4;
        if (mAnchorLayoutFromEnd) {
            n4 = n2;
        }
        else {
            n4 = 0;
        }
        parcel.writeInt(n4);
        if (!mLastLayoutRTL) {
            n2 = 0;
        }
        parcel.writeInt(n2);
        parcel.writeList((List)mFullSpanItems);
    }
}
