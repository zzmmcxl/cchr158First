package android.support.v4.app;

import android.content.Context;
import android.util.Log;
import android.os.Parcel;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

final class FragmentState implements Parcelable
{
    public static final Parcelable$Creator<FragmentState> CREATOR;
    final Bundle mArguments;
    final String mClassName;
    final int mContainerId;
    final boolean mDetached;
    final int mFragmentId;
    final boolean mFromLayout;
    final int mIndex;
    Fragment mInstance;
    final boolean mRetainInstance;
    Bundle mSavedFragmentState;
    final String mTag;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<FragmentState>() {
            FragmentState$1() {
                super();
            }
            
            public FragmentState createFromParcel(final Parcel parcel) {
                return new FragmentState(parcel);
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.createFromParcel(parcel);
            }
            
            public FragmentState[] newArray(final int n) {
                return new FragmentState[n];
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.newArray(n);
            }
        };
    }
    
    public FragmentState(final Parcel parcel) {
        boolean mDetached = true;
        super();
        mClassName = parcel.readString();
        mIndex = parcel.readInt();
        mFromLayout = (parcel.readInt() != 0 && mDetached);
        mFragmentId = parcel.readInt();
        mContainerId = parcel.readInt();
        mTag = parcel.readString();
        mRetainInstance = (parcel.readInt() != 0 && mDetached);
        if (parcel.readInt() == 0) {
            mDetached = false;
        }
        this.mDetached = mDetached;
        mArguments = parcel.readBundle();
        mSavedFragmentState = parcel.readBundle();
    }
    
    public FragmentState(final Fragment fragment) {
        super();
        mClassName = fragment.getClass().getName();
        mIndex = fragment.mIndex;
        mFromLayout = fragment.mFromLayout;
        mFragmentId = fragment.mFragmentId;
        mContainerId = fragment.mContainerId;
        mTag = fragment.mTag;
        mRetainInstance = fragment.mRetainInstance;
        mDetached = fragment.mDetached;
        mArguments = fragment.mArguments;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public Fragment instantiate(final FragmentHostCallback fragmentHostCallback, final Fragment fragment) {
        if (mInstance != null) {
            return mInstance;
        }
        final Context context = fragmentHostCallback.getContext();
        if (mArguments != null) {
            mArguments.setClassLoader(context.getClassLoader());
        }
        mInstance = Fragment.instantiate(context, mClassName, mArguments);
        if (mSavedFragmentState != null) {
            mSavedFragmentState.setClassLoader(context.getClassLoader());
            mInstance.mSavedFragmentState = mSavedFragmentState;
        }
        mInstance.setIndex(mIndex, fragment);
        mInstance.mFromLayout = mFromLayout;
        mInstance.mRestored = true;
        mInstance.mFragmentId = mFragmentId;
        mInstance.mContainerId = mContainerId;
        mInstance.mTag = mTag;
        mInstance.mRetainInstance = mRetainInstance;
        mInstance.mDetached = mDetached;
        mInstance.mFragmentManager = fragmentHostCallback.mFragmentManager;
        if (FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "Instantiated fragment " + mInstance);
        }
        return mInstance;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        int n2 = 1;
        parcel.writeString(mClassName);
        parcel.writeInt(mIndex);
        int n3;
        if (mFromLayout) {
            n3 = n2;
        }
        else {
            n3 = 0;
        }
        parcel.writeInt(n3);
        parcel.writeInt(mFragmentId);
        parcel.writeInt(mContainerId);
        parcel.writeString(mTag);
        int n4;
        if (mRetainInstance) {
            n4 = n2;
        }
        else {
            n4 = 0;
        }
        parcel.writeInt(n4);
        if (!mDetached) {
            n2 = 0;
        }
        parcel.writeInt(n2);
        parcel.writeBundle(mArguments);
        parcel.writeBundle(mSavedFragmentState);
    }
}
