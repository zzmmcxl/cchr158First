package android.support.v7.widget;

import android.util.Log;
import android.view.animation.Interpolator;

public static class Action
{
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    private boolean changed;
    private int consecutiveUpdates;
    private int mDuration;
    private int mDx;
    private int mDy;
    private Interpolator mInterpolator;
    private int mJumpToPosition;
    
    public Action(final int n, final int n2) {
        this(n, n2, Integer.MIN_VALUE, null);
    }
    
    public Action(final int n, final int n2, final int n3) {
        this(n, n2, n3, null);
    }
    
    public Action(final int mDx, final int mDy, final int mDuration, final Interpolator mInterpolator) {
        super();
        this.mJumpToPosition = -1;
        this.changed = false;
        this.consecutiveUpdates = 0;
        this.mDx = mDx;
        this.mDy = mDy;
        this.mDuration = mDuration;
        this.mInterpolator = mInterpolator;
    }
    
    static /* synthetic */ void access$6100(final Action action, final RecyclerView recyclerView) {
        action.runIfNecessary(recyclerView);
    }
    
    private void runIfNecessary(final RecyclerView recyclerView) {
        if (mJumpToPosition >= 0) {
            final int mJumpToPosition = this.mJumpToPosition;
            this.mJumpToPosition = -1;
            RecyclerView.access$6200(recyclerView, mJumpToPosition);
            changed = false;
            return;
        }
        if (changed) {
            this.validate();
            if (mInterpolator == null) {
                if (mDuration == Integer.MIN_VALUE) {
                    RecyclerView.access$5900(recyclerView).smoothScrollBy(mDx, mDy);
                }
                else {
                    RecyclerView.access$5900(recyclerView).smoothScrollBy(mDx, mDy, mDuration);
                }
            }
            else {
                RecyclerView.access$5900(recyclerView).smoothScrollBy(mDx, mDy, mDuration, mInterpolator);
            }
            ++consecutiveUpdates;
            if (consecutiveUpdates > 10) {
                Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
            }
            changed = false;
            return;
        }
        consecutiveUpdates = 0;
    }
    
    private void validate() {
        if (mInterpolator != null && mDuration < 1) {
            throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        }
        if (mDuration < 1) {
            throw new IllegalStateException("Scroll duration must be a positive number");
        }
    }
    
    public int getDuration() {
        return mDuration;
    }
    
    public int getDx() {
        return mDx;
    }
    
    public int getDy() {
        return mDy;
    }
    
    public Interpolator getInterpolator() {
        return mInterpolator;
    }
    
    boolean hasJumpTarget() {
        return mJumpToPosition >= 0;
    }
    
    public void jumpTo(final int mJumpToPosition) {
        this.mJumpToPosition = mJumpToPosition;
    }
    
    public void setDuration(final int mDuration) {
        changed = true;
        this.mDuration = mDuration;
    }
    
    public void setDx(final int mDx) {
        changed = true;
        this.mDx = mDx;
    }
    
    public void setDy(final int mDy) {
        changed = true;
        this.mDy = mDy;
    }
    
    public void setInterpolator(final Interpolator mInterpolator) {
        changed = true;
        this.mInterpolator = mInterpolator;
    }
    
    public void update(final int mDx, final int mDy, final int mDuration, final Interpolator mInterpolator) {
        this.mDx = mDx;
        this.mDy = mDy;
        this.mDuration = mDuration;
        this.mInterpolator = mInterpolator;
        changed = true;
    }
}
