package android.support.v4.app;

import java.util.Iterator;
import android.util.Log;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import android.support.v4.view.PagerAdapter;

public abstract class FragmentStatePagerAdapter extends PagerAdapter
{
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentStatePagerAdapter";
    private FragmentTransaction mCurTransaction;
    private Fragment mCurrentPrimaryItem;
    private final FragmentManager mFragmentManager;
    private ArrayList<Fragment> mFragments;
    private ArrayList<Fragment.SavedState> mSavedState;
    
    public FragmentStatePagerAdapter(final FragmentManager mFragmentManager) {
        super();
        mCurTransaction = null;
        mSavedState = new ArrayList<Fragment.SavedState>();
        mFragments = new ArrayList<Fragment>();
        mCurrentPrimaryItem = null;
        mFragmentManager = mFragmentManager;
    }
    
    @Override
    public void destroyItem(final ViewGroup viewGroup, final int n, final Object o) {
        final Fragment fragment = (Fragment)o;
        if (mCurTransaction == null) {
            mCurTransaction = mFragmentManager.beginTransaction();
        }
        while (mSavedState.size() <= n) {
            mSavedState.add(null);
        }
        final ArrayList<Fragment.SavedState> mSavedState = this.mSavedState;
        Fragment.SavedState saveFragmentInstanceState;
        if (fragment.isAdded()) {
            saveFragmentInstanceState = mFragmentManager.saveFragmentInstanceState(fragment);
        }
        else {
            saveFragmentInstanceState = null;
        }
        mSavedState.set(n, saveFragmentInstanceState);
        mFragments.set(n, null);
        mCurTransaction.remove(fragment);
    }
    
    @Override
    public void finishUpdate(final ViewGroup viewGroup) {
        if (mCurTransaction != null) {
            mCurTransaction.commitAllowingStateLoss();
            mCurTransaction = null;
            mFragmentManager.executePendingTransactions();
        }
    }
    
    public abstract Fragment getItem(final int p0);
    
    @Override
    public Object instantiateItem(final ViewGroup viewGroup, final int n) {
        if (mFragments.size() > n) {
            final Fragment fragment = (Fragment)mFragments.get(n);
            if (fragment != null) {
                return fragment;
            }
        }
        if (mCurTransaction == null) {
            mCurTransaction = mFragmentManager.beginTransaction();
        }
        final Fragment item = this.getItem(n);
        if (mSavedState.size() > n) {
            final Fragment.SavedState initialSavedState = (Fragment.SavedState)mSavedState.get(n);
            if (initialSavedState != null) {
                item.setInitialSavedState(initialSavedState);
            }
        }
        while (mFragments.size() <= n) {
            mFragments.add(null);
        }
        item.setMenuVisibility(false);
        item.setUserVisibleHint(false);
        mFragments.set(n, item);
        mCurTransaction.add(viewGroup.getId(), item);
        return item;
    }
    
    @Override
    public boolean isViewFromObject(final View view, final Object o) {
        return ((Fragment)o).getView() == view;
    }
    
    @Override
    public void restoreState(final Parcelable parcelable, final ClassLoader classLoader) {
        if (parcelable != null) {
            final Bundle bundle = (Bundle)parcelable;
            bundle.setClassLoader(classLoader);
            final Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            mSavedState.clear();
            mFragments.clear();
            if (parcelableArray != null) {
                for (int i = 0; i < parcelableArray.length; ++i) {
                    mSavedState.add((Fragment.SavedState)parcelableArray[i]);
                }
            }
            for (final String s : bundle.keySet()) {
                if (s.startsWith("f")) {
                    final int int1 = Integer.parseInt(s.substring(1));
                    final Fragment fragment = mFragmentManager.getFragment(bundle, s);
                    if (fragment != null) {
                        while (mFragments.size() <= int1) {
                            mFragments.add(null);
                        }
                        fragment.setMenuVisibility(false);
                        mFragments.set(int1, fragment);
                    }
                    else {
                        Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + s);
                    }
                }
            }
        }
    }
    
    @Override
    public Parcelable saveState() {
        final int size = mSavedState.size();
        Object o = null;
        if (size > 0) {
            o = new Bundle();
            final Fragment.SavedState[] array = new Fragment.SavedState[mSavedState.size()];
            mSavedState.<Fragment.SavedState>toArray(array);
            ((Bundle)o).putParcelableArray("states", (Parcelable[])array);
        }
        for (int i = 0; i < mFragments.size(); ++i) {
            final Fragment fragment = (Fragment)mFragments.get(i);
            if (fragment != null && fragment.isAdded()) {
                if (o == null) {
                    o = new Bundle();
                }
                mFragmentManager.putFragment((Bundle)o, "f" + i, fragment);
            }
        }
        return (Parcelable)o;
    }
    
    @Override
    public void setPrimaryItem(final ViewGroup viewGroup, final int n, final Object o) {
        final Fragment mCurrentPrimaryItem = (Fragment)o;
        if (mCurrentPrimaryItem != this.mCurrentPrimaryItem) {
            if (this.mCurrentPrimaryItem != null) {
                this.mCurrentPrimaryItem.setMenuVisibility(false);
                this.mCurrentPrimaryItem.setUserVisibleHint(false);
            }
            if (mCurrentPrimaryItem != null) {
                mCurrentPrimaryItem.setMenuVisibility(true);
                mCurrentPrimaryItem.setUserVisibleHint(true);
            }
            this.mCurrentPrimaryItem = mCurrentPrimaryItem;
        }
    }
    
    @Override
    public void startUpdate(final ViewGroup viewGroup) {
    }
}
