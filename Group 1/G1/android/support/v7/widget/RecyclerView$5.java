package android.support.v7.widget;

import android.util.Log;
import android.support.v4.view.ViewCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import android.view.ViewGroup$LayoutParams;
import android.view.View;

class RecyclerView$5 implements Callback {
    final /* synthetic */ RecyclerView this$0;
    
    RecyclerView$5(final RecyclerView this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void addView(final View view, final int n) {
        this$0.addView(view, n);
        RecyclerView.access$1100(this$0, view);
    }
    
    @Override
    public void attachViewToParent(final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        final ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt);
            }
            childViewHolderInt.clearTmpDetachFlag();
        }
        RecyclerView.access$1300(this$0, view, n, viewGroup$LayoutParams);
    }
    
    @Override
    public void detachViewFromParent(final int n) {
        final View child = this.getChildAt(n);
        if (child != null) {
            final ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(child);
            if (childViewHolderInt != null) {
                if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt);
                }
                childViewHolderInt.addFlags(256);
            }
        }
        RecyclerView.access$1400(this$0, n);
    }
    
    @Override
    public View getChildAt(final int n) {
        return this$0.getChildAt(n);
    }
    
    @Override
    public int getChildCount() {
        return this$0.getChildCount();
    }
    
    @Override
    public ViewHolder getChildViewHolder(final View view) {
        return RecyclerView.getChildViewHolderInt(view);
    }
    
    @Override
    public int indexOfChild(final View view) {
        return this$0.indexOfChild(view);
    }
    
    @Override
    public void onEnteredHiddenState(final View view) {
        final ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            childViewHolderInt.onEnteredHiddenState();
        }
    }
    
    @Override
    public void onLeftHiddenState(final View view) {
        final ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            childViewHolderInt.onLeftHiddenState();
        }
    }
    
    @Override
    public void removeAllViews() {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            RecyclerView.access$1200(this$0, this.getChildAt(i));
        }
        this$0.removeAllViews();
    }
    
    @Override
    public void removeViewAt(final int n) {
        final View child = this$0.getChildAt(n);
        if (child != null) {
            RecyclerView.access$1200(this$0, child);
        }
        this$0.removeViewAt(n);
    }
}