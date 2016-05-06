package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

final class FragmentManagerState implements Parcelable
{
    public static final Parcelable$Creator<FragmentManagerState> CREATOR;
    FragmentState[] mActive;
    int[] mAdded;
    BackStackState[] mBackStack;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<FragmentManagerState>() {
            FragmentManagerState$1() {
                super();
            }
            
            public FragmentManagerState createFromParcel(final Parcel parcel) {
                return new FragmentManagerState(parcel);
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.createFromParcel(parcel);
            }
            
            public FragmentManagerState[] newArray(final int n) {
                return new FragmentManagerState[n];
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.newArray(n);
            }
        };
    }
    
    public FragmentManagerState() {
        super();
    }
    
    public FragmentManagerState(final Parcel parcel) {
        super();
        mActive = (FragmentState[])parcel.createTypedArray((Parcelable$Creator)FragmentState.CREATOR);
        mAdded = parcel.createIntArray();
        mBackStack = (BackStackState[])parcel.createTypedArray((Parcelable$Creator)BackStackState.CREATOR);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeTypedArray((Parcelable[])mActive, n);
        parcel.writeIntArray(mAdded);
        parcel.writeTypedArray((Parcelable[])mBackStack, n);
    }
}
