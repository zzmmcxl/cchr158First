package android.support.v7.widget;

import android.view.ViewGroup$LayoutParams;
import java.util.ArrayList;
import android.view.View;
import java.util.List;

class ChildHelper
{
    private static final boolean DEBUG = false;
    private static final String TAG = "ChildrenHelper";
    final Bucket mBucket;
    final Callback mCallback;
    final List<View> mHiddenViews;
    
    ChildHelper(final Callback mCallback) {
        super();
        mCallback = mCallback;
        mBucket = new Bucket();
        mHiddenViews = new ArrayList<View>();
    }
    
    private int getOffset(final int n) {
        if (n >= 0) {
            int n2;
            for (int childCount = mCallback.getChildCount(), i = n; i < childCount; i += n2) {
                n2 = n - (i - mBucket.countOnesBefore(i));
                if (n2 == 0) {
                    while (mBucket.get(i)) {
                        ++i;
                    }
                    return i;
                }
            }
            return -1;
        }
        return -1;
    }
    
    private void hideViewInternal(final View view) {
        mHiddenViews.add(view);
        mCallback.onEnteredHiddenState(view);
    }
    
    private boolean unhideViewInternal(final View view) {
        if (mHiddenViews.remove(view)) {
            mCallback.onLeftHiddenState(view);
            return true;
        }
        return false;
    }
    
    void addView(final View view, final int n, final boolean b) {
        int n2;
        if (n < 0) {
            n2 = mCallback.getChildCount();
        }
        else {
            n2 = this.getOffset(n);
        }
        mBucket.insert(n2, b);
        if (b) {
            this.hideViewInternal(view);
        }
        mCallback.addView(view, n2);
    }
    
    void addView(final View view, final boolean b) {
        this.addView(view, -1, b);
    }
    
    void attachViewToParent(final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams, final boolean b) {
        int n2;
        if (n < 0) {
            n2 = mCallback.getChildCount();
        }
        else {
            n2 = this.getOffset(n);
        }
        mBucket.insert(n2, b);
        if (b) {
            this.hideViewInternal(view);
        }
        mCallback.attachViewToParent(view, n2, viewGroup$LayoutParams);
    }
    
    void detachViewFromParent(final int n) {
        final int offset = this.getOffset(n);
        mBucket.remove(offset);
        mCallback.detachViewFromParent(offset);
    }
    
    View findHiddenNonRemovedView(final int n, final int n2) {
        for (int size = mHiddenViews.size(), i = 0; i < size; ++i) {
            final View view = (View)mHiddenViews.get(i);
            final RecyclerView.ViewHolder childViewHolder = mCallback.getChildViewHolder(view);
            if (childViewHolder.getLayoutPosition() == n && !childViewHolder.isInvalid() && !childViewHolder.isRemoved() && (n2 == -1 || childViewHolder.getItemViewType() == n2)) {
                return view;
            }
        }
        return null;
    }
    
    View getChildAt(final int n) {
        return mCallback.getChildAt(this.getOffset(n));
    }
    
    int getChildCount() {
        return mCallback.getChildCount() - mHiddenViews.size();
    }
    
    View getUnfilteredChildAt(final int n) {
        return mCallback.getChildAt(n);
    }
    
    int getUnfilteredChildCount() {
        return mCallback.getChildCount();
    }
    
    void hide(final View view) {
        final int indexOfChild = mCallback.indexOfChild(view);
        if (indexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        mBucket.set(indexOfChild);
        this.hideViewInternal(view);
    }
    
    int indexOfChild(final View view) {
        final int indexOfChild = mCallback.indexOfChild(view);
        if (indexOfChild != -1 && !mBucket.get(indexOfChild)) {
            return indexOfChild - mBucket.countOnesBefore(indexOfChild);
        }
        return -1;
    }
    
    boolean isHidden(final View view) {
        return mHiddenViews.contains(view);
    }
    
    void removeAllViewsUnfiltered() {
        mBucket.reset();
        for (int i = -1 + mHiddenViews.size(); i >= 0; --i) {
            mCallback.onLeftHiddenState(mHiddenViews.get(i));
            mHiddenViews.remove(i);
        }
        mCallback.removeAllViews();
    }
    
    void removeView(final View view) {
        final int indexOfChild = mCallback.indexOfChild(view);
        if (indexOfChild < 0) {
            return;
        }
        if (mBucket.remove(indexOfChild)) {
            this.unhideViewInternal(view);
        }
        mCallback.removeViewAt(indexOfChild);
    }
    
    void removeViewAt(final int n) {
        final int offset = this.getOffset(n);
        final View child = mCallback.getChildAt(offset);
        if (child == null) {
            return;
        }
        if (mBucket.remove(offset)) {
            this.unhideViewInternal(child);
        }
        mCallback.removeViewAt(offset);
    }
    
    boolean removeViewIfHidden(final View view) {
        final int indexOfChild = mCallback.indexOfChild(view);
        if (indexOfChild == -1) {
            if (this.unhideViewInternal(view)) {}
            return true;
        }
        if (mBucket.get(indexOfChild)) {
            mBucket.remove(indexOfChild);
            if (!this.unhideViewInternal(view)) {}
            mCallback.removeViewAt(indexOfChild);
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return mBucket.toString() + ", hidden list:" + mHiddenViews.size();
    }
    
    void unhide(final View view) {
        final int indexOfChild = mCallback.indexOfChild(view);
        if (indexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (!mBucket.get(indexOfChild)) {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
        mBucket.clear(indexOfChild);
        this.unhideViewInternal(view);
    }
}
