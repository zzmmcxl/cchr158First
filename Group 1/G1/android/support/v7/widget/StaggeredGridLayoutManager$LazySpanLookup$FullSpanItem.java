package android.support.v7.widget;

import java.util.Arrays;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

static class FullSpanItem implements Parcelable
{
    public static final Parcelable$Creator<FullSpanItem> CREATOR;
    int mGapDir;
    int[] mGapPerSpan;
    boolean mHasUnwantedGapAfter;
    int mPosition;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<FullSpanItem>() {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem$1() {
                super();
            }
            
            public FullSpanItem createFromParcel(final Parcel parcel) {
                return new FullSpanItem(parcel);
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.createFromParcel(parcel);
            }
            
            public FullSpanItem[] newArray(final int n) {
                return new FullSpanItem[n];
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.newArray(n);
            }
        };
    }
    
    public FullSpanItem() {
        super();
    }
    
    public FullSpanItem(final Parcel parcel) {
        boolean mHasUnwantedGapAfter = true;
        super();
        this.mPosition = parcel.readInt();
        this.mGapDir = parcel.readInt();
        if (parcel.readInt() != (mHasUnwantedGapAfter ? 1 : 0)) {
            mHasUnwantedGapAfter = false;
        }
        this.mHasUnwantedGapAfter = mHasUnwantedGapAfter;
        final int int1 = parcel.readInt();
        if (int1 > 0) {
            parcel.readIntArray(this.mGapPerSpan = new int[int1]);
        }
    }
    
    public int describeContents() {
        return 0;
    }
    
    int getGapForSpan(final int n) {
        if (mGapPerSpan == null) {
            return 0;
        }
        return mGapPerSpan[n];
    }
    
    @Override
    public String toString() {
        return "FullSpanItem{mPosition=" + mPosition + ", mGapDir=" + mGapDir + ", mHasUnwantedGapAfter=" + mHasUnwantedGapAfter + ", mGapPerSpan=" + Arrays.toString(mGapPerSpan) + '}';
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt(mPosition);
        parcel.writeInt(mGapDir);
        int n2;
        if (mHasUnwantedGapAfter) {
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        parcel.writeInt(n2);
        if (mGapPerSpan != null && mGapPerSpan.length > 0) {
            parcel.writeInt(mGapPerSpan.length);
            parcel.writeIntArray(mGapPerSpan);
            return;
        }
        parcel.writeInt(0);
    }
}
