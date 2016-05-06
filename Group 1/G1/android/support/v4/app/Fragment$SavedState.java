package android.support.v4.app;

import android.os.Parcel;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public static class SavedState implements Parcelable
{
    public static final Parcelable$Creator<SavedState> CREATOR;
    final Bundle mState;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<SavedState>() {
            Fragment$SavedState$1() {
                super();
            }
            
            public SavedState createFromParcel(final Parcel parcel) {
                return new SavedState(parcel, null);
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
    
    SavedState(final Bundle mState) {
        super();
        this.mState = mState;
    }
    
    SavedState(final Parcel parcel, final ClassLoader classLoader) {
        super();
        this.mState = parcel.readBundle();
        if (classLoader != null && this.mState != null) {
            this.mState.setClassLoader(classLoader);
        }
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeBundle(mState);
    }
}
