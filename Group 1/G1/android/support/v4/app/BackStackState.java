package android.support.v4.app;

import java.util.List;
import android.util.Log;
import android.text.TextUtils;
import android.os.Parcel;
import java.util.ArrayList;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

final class BackStackState implements Parcelable
{
    public static final Parcelable$Creator<BackStackState> CREATOR;
    final int mBreadCrumbShortTitleRes;
    final CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final CharSequence mBreadCrumbTitleText;
    final int mIndex;
    final String mName;
    final int[] mOps;
    final ArrayList<String> mSharedElementSourceNames;
    final ArrayList<String> mSharedElementTargetNames;
    final int mTransition;
    final int mTransitionStyle;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<BackStackState>() {
            BackStackState$1() {
                super();
            }
            
            public BackStackState createFromParcel(final Parcel parcel) {
                return new BackStackState(parcel);
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.createFromParcel(parcel);
            }
            
            public BackStackState[] newArray(final int n) {
                return new BackStackState[n];
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.newArray(n);
            }
        };
    }
    
    public BackStackState(final Parcel parcel) {
        super();
        mOps = parcel.createIntArray();
        mTransition = parcel.readInt();
        mTransitionStyle = parcel.readInt();
        mName = parcel.readString();
        mIndex = parcel.readInt();
        mBreadCrumbTitleRes = parcel.readInt();
        mBreadCrumbTitleText = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        mBreadCrumbShortTitleRes = parcel.readInt();
        mBreadCrumbShortTitleText = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        mSharedElementSourceNames = (ArrayList<String>)parcel.createStringArrayList();
        mSharedElementTargetNames = (ArrayList<String>)parcel.createStringArrayList();
    }
    
    public BackStackState(final BackStackRecord backStackRecord) {
        super();
        int n = 0;
        for (BackStackRecord.Op op = backStackRecord.mHead; op != null; op = op.next) {
            if (op.removed != null) {
                n += op.removed.size();
            }
        }
        mOps = new int[n + 7 * backStackRecord.mNumOp];
        if (!backStackRecord.mAddToBackStack) {
            throw new IllegalStateException("Not on back stack");
        }
        BackStackRecord.Op op2 = backStackRecord.mHead;
        int n2 = 0;
        while (op2 != null) {
            final int[] mOps = this.mOps;
            final int n3 = n2 + 1;
            mOps[n2] = op2.cmd;
            final int[] mOps2 = this.mOps;
            final int n4 = n3 + 1;
            int mIndex;
            if (op2.fragment != null) {
                mIndex = op2.fragment.mIndex;
            }
            else {
                mIndex = -1;
            }
            mOps2[n3] = mIndex;
            final int[] mOps3 = this.mOps;
            final int n5 = n4 + 1;
            mOps3[n4] = op2.enterAnim;
            final int[] mOps4 = this.mOps;
            final int n6 = n5 + 1;
            mOps4[n5] = op2.exitAnim;
            final int[] mOps5 = this.mOps;
            final int n7 = n6 + 1;
            mOps5[n6] = op2.popEnterAnim;
            final int[] mOps6 = this.mOps;
            final int n8 = n7 + 1;
            mOps6[n7] = op2.popExitAnim;
            int n12;
            if (op2.removed != null) {
                final int size = op2.removed.size();
                final int[] mOps7 = this.mOps;
                final int n9 = n8 + 1;
                mOps7[n8] = size;
                int i = 0;
                int n10 = n9;
                while (i < size) {
                    final int[] mOps8 = this.mOps;
                    final int n11 = n10 + 1;
                    mOps8[n10] = ((Fragment)op2.removed.get(i)).mIndex;
                    ++i;
                    n10 = n11;
                }
                n12 = n10;
            }
            else {
                final int[] mOps9 = this.mOps;
                n12 = n8 + 1;
                mOps9[n8] = 0;
            }
            op2 = op2.next;
            n2 = n12;
        }
        mTransition = backStackRecord.mTransition;
        mTransitionStyle = backStackRecord.mTransitionStyle;
        mName = backStackRecord.mName;
        mIndex = backStackRecord.mIndex;
        mBreadCrumbTitleRes = backStackRecord.mBreadCrumbTitleRes;
        mBreadCrumbTitleText = backStackRecord.mBreadCrumbTitleText;
        mBreadCrumbShortTitleRes = backStackRecord.mBreadCrumbShortTitleRes;
        mBreadCrumbShortTitleText = backStackRecord.mBreadCrumbShortTitleText;
        mSharedElementSourceNames = backStackRecord.mSharedElementSourceNames;
        mSharedElementTargetNames = backStackRecord.mSharedElementTargetNames;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public BackStackRecord instantiate(final FragmentManagerImpl fragmentManagerImpl) {
        final BackStackRecord backStackRecord = new BackStackRecord(fragmentManagerImpl);
        int i = 0;
        int n = 0;
        while (i < mOps.length) {
            final BackStackRecord.Op op = new BackStackRecord.Op();
            final int[] mOps = this.mOps;
            final int n2 = i + 1;
            op.cmd = mOps[i];
            if (FragmentManagerImpl.DEBUG) {
                Log.v("FragmentManager", "Instantiate " + backStackRecord + " op #" + n + " base fragment #" + this.mOps[n2]);
            }
            final int[] mOps2 = this.mOps;
            final int n3 = n2 + 1;
            final int n4 = mOps2[n2];
            if (n4 >= 0) {
                op.fragment = fragmentManagerImpl.mActive.get(n4);
            }
            else {
                op.fragment = null;
            }
            final int[] mOps3 = this.mOps;
            final int n5 = n3 + 1;
            op.enterAnim = mOps3[n3];
            final int[] mOps4 = this.mOps;
            final int n6 = n5 + 1;
            op.exitAnim = mOps4[n5];
            final int[] mOps5 = this.mOps;
            final int n7 = n6 + 1;
            op.popEnterAnim = mOps5[n6];
            final int[] mOps6 = this.mOps;
            final int n8 = n7 + 1;
            op.popExitAnim = mOps6[n7];
            final int[] mOps7 = this.mOps;
            int n9 = n8 + 1;
            final int n10 = mOps7[n8];
            if (n10 > 0) {
                op.removed = new ArrayList<Fragment>(n10);
                int n11;
                for (int j = 0; j < n10; ++j, n9 = n11) {
                    if (FragmentManagerImpl.DEBUG) {
                        Log.v("FragmentManager", "Instantiate " + backStackRecord + " set remove fragment #" + this.mOps[n9]);
                    }
                    final ArrayList<Fragment> mActive = fragmentManagerImpl.mActive;
                    final int[] mOps8 = this.mOps;
                    n11 = n9 + 1;
                    op.removed.add(mActive.get(mOps8[n9]));
                }
            }
            i = n9;
            backStackRecord.addOp(op);
            ++n;
        }
        backStackRecord.mTransition = mTransition;
        backStackRecord.mTransitionStyle = mTransitionStyle;
        backStackRecord.mName = mName;
        backStackRecord.mIndex = mIndex;
        backStackRecord.mAddToBackStack = true;
        backStackRecord.mBreadCrumbTitleRes = mBreadCrumbTitleRes;
        backStackRecord.mBreadCrumbTitleText = mBreadCrumbTitleText;
        backStackRecord.mBreadCrumbShortTitleRes = mBreadCrumbShortTitleRes;
        backStackRecord.mBreadCrumbShortTitleText = mBreadCrumbShortTitleText;
        backStackRecord.mSharedElementSourceNames = mSharedElementSourceNames;
        backStackRecord.mSharedElementTargetNames = mSharedElementTargetNames;
        backStackRecord.bumpBackStackNesting(1);
        return backStackRecord;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeIntArray(mOps);
        parcel.writeInt(mTransition);
        parcel.writeInt(mTransitionStyle);
        parcel.writeString(mName);
        parcel.writeInt(mIndex);
        parcel.writeInt(mBreadCrumbTitleRes);
        TextUtils.writeToParcel(mBreadCrumbTitleText, parcel, 0);
        parcel.writeInt(mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(mBreadCrumbShortTitleText, parcel, 0);
        parcel.writeStringList((List)mSharedElementSourceNames);
        parcel.writeStringList((List)mSharedElementTargetNames);
    }
}
