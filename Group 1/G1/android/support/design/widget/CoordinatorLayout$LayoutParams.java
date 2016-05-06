package android.support.design.widget;

import android.view.ViewParent;
import android.view.ViewGroup$LayoutParams;
import android.content.res.TypedArray;
import android.support.design.R;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup$MarginLayoutParams;

public static class LayoutParams extends ViewGroup$MarginLayoutParams
{
    public int anchorGravity;
    public int gravity;
    public int keyline;
    View mAnchorDirectChild;
    int mAnchorId;
    View mAnchorView;
    Behavior mBehavior;
    boolean mBehaviorResolved;
    Object mBehaviorTag;
    private boolean mDidAcceptNestedScroll;
    private boolean mDidBlockInteraction;
    private boolean mDidChangeAfterNestedScroll;
    final Rect mLastChildRect;
    
    public LayoutParams(final int n, final int n2) {
        super(n, n2);
        this.mBehaviorResolved = false;
        this.gravity = 0;
        this.anchorGravity = 0;
        this.keyline = -1;
        this.mAnchorId = -1;
        this.mLastChildRect = new Rect();
    }
    
    LayoutParams(final Context context, final AttributeSet set) {
        super(context, set);
        this.mBehaviorResolved = false;
        this.gravity = 0;
        this.anchorGravity = 0;
        this.keyline = -1;
        this.mAnchorId = -1;
        this.mLastChildRect = new Rect();
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.CoordinatorLayout_LayoutParams);
        this.gravity = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_LayoutParams_android_layout_gravity, 0);
        this.mAnchorId = obtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_LayoutParams_layout_anchor, -1);
        this.anchorGravity = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_LayoutParams_layout_anchorGravity, 0);
        this.keyline = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_LayoutParams_layout_keyline, -1);
        this.mBehaviorResolved = obtainStyledAttributes.hasValue(R.styleable.CoordinatorLayout_LayoutParams_layout_behavior);
        if (this.mBehaviorResolved) {
            this.mBehavior = CoordinatorLayout.parseBehavior(context, set, obtainStyledAttributes.getString(R.styleable.CoordinatorLayout_LayoutParams_layout_behavior));
        }
        obtainStyledAttributes.recycle();
    }
    
    public LayoutParams(final LayoutParams layoutParams) {
        super((ViewGroup$MarginLayoutParams)layoutParams);
        this.mBehaviorResolved = false;
        this.gravity = 0;
        this.anchorGravity = 0;
        this.keyline = -1;
        this.mAnchorId = -1;
        this.mLastChildRect = new Rect();
    }
    
    public LayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super(viewGroup$LayoutParams);
        this.mBehaviorResolved = false;
        this.gravity = 0;
        this.anchorGravity = 0;
        this.keyline = -1;
        this.mAnchorId = -1;
        this.mLastChildRect = new Rect();
    }
    
    public LayoutParams(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        super(viewGroup$MarginLayoutParams);
        this.mBehaviorResolved = false;
        this.gravity = 0;
        this.anchorGravity = 0;
        this.keyline = -1;
        this.mAnchorId = -1;
        this.mLastChildRect = new Rect();
    }
    
    private void resolveAnchorView(final View view, final CoordinatorLayout coordinatorLayout) {
        mAnchorView = coordinatorLayout.findViewById(mAnchorId);
        if (mAnchorView != null) {
            if (mAnchorView != coordinatorLayout) {
                View mAnchorView = this.mAnchorView;
                ViewParent viewParent = this.mAnchorView.getParent();
                while (viewParent != coordinatorLayout && viewParent != null) {
                    if (viewParent == view) {
                        if (coordinatorLayout.isInEditMode()) {
                            mAnchorDirectChild = null;
                            this.mAnchorView = null;
                            return;
                        }
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    else {
                        if (viewParent instanceof View) {
                            mAnchorView = (View)viewParent;
                        }
                        viewParent = viewParent.getParent();
                    }
                }
                mAnchorDirectChild = mAnchorView;
                return;
            }
            if (coordinatorLayout.isInEditMode()) {
                mAnchorDirectChild = null;
                mAnchorView = null;
                return;
            }
            throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
        }
        else {
            if (coordinatorLayout.isInEditMode()) {
                mAnchorDirectChild = null;
                mAnchorView = null;
                return;
            }
            throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(mAnchorId) + " to anchor view " + view);
        }
    }
    
    private boolean verifyAnchorView(final View view, final CoordinatorLayout coordinatorLayout) {
        if (mAnchorView.getId() != mAnchorId) {
            return false;
        }
        View mAnchorView = this.mAnchorView;
        for (ViewParent viewParent = this.mAnchorView.getParent(); viewParent != coordinatorLayout; viewParent = viewParent.getParent()) {
            if (viewParent == null || viewParent == view) {
                mAnchorDirectChild = null;
                this.mAnchorView = null;
                return false;
            }
            if (viewParent instanceof View) {
                mAnchorView = (View)viewParent;
            }
        }
        mAnchorDirectChild = mAnchorView;
        return true;
    }
    
    void acceptNestedScroll(final boolean mDidAcceptNestedScroll) {
        this.mDidAcceptNestedScroll = mDidAcceptNestedScroll;
    }
    
    boolean checkAnchorChanged() {
        return mAnchorView == null && mAnchorId != -1;
    }
    
    boolean dependsOn(final CoordinatorLayout coordinatorLayout, final View view, final View view2) {
        return view2 == mAnchorDirectChild || (mBehavior != null && mBehavior.layoutDependsOn(coordinatorLayout, view, view2));
    }
    
    boolean didBlockInteraction() {
        if (mBehavior == null) {
            mDidBlockInteraction = false;
        }
        return mDidBlockInteraction;
    }
    
    View findAnchorView(final CoordinatorLayout coordinatorLayout, final View view) {
        if (mAnchorId == -1) {
            mAnchorDirectChild = null;
            return mAnchorView = null;
        }
        if (mAnchorView == null || !this.verifyAnchorView(view, coordinatorLayout)) {
            this.resolveAnchorView(view, coordinatorLayout);
        }
        return mAnchorView;
    }
    
    public int getAnchorId() {
        return mAnchorId;
    }
    
    public Behavior getBehavior() {
        return mBehavior;
    }
    
    boolean getChangedAfterNestedScroll() {
        return mDidChangeAfterNestedScroll;
    }
    
    Rect getLastChildRect() {
        return mLastChildRect;
    }
    
    void invalidateAnchor() {
        mAnchorDirectChild = null;
        mAnchorView = null;
    }
    
    boolean isBlockingInteractionBelow(final CoordinatorLayout coordinatorLayout, final View view) {
        return mDidBlockInteraction || (mDidBlockInteraction |= (mBehavior != null && mBehavior.blocksInteractionBelow(coordinatorLayout, view)));
    }
    
    boolean isDirty(final CoordinatorLayout coordinatorLayout, final View view) {
        return mBehavior != null && mBehavior.isDirty(coordinatorLayout, view);
    }
    
    boolean isNestedScrollAccepted() {
        return mDidAcceptNestedScroll;
    }
    
    void resetChangedAfterNestedScroll() {
        mDidChangeAfterNestedScroll = false;
    }
    
    void resetNestedScroll() {
        mDidAcceptNestedScroll = false;
    }
    
    void resetTouchBehaviorTracking() {
        mDidBlockInteraction = false;
    }
    
    public void setAnchorId(final int mAnchorId) {
        this.invalidateAnchor();
        this.mAnchorId = mAnchorId;
    }
    
    public void setBehavior(final Behavior mBehavior) {
        if (this.mBehavior != mBehavior) {
            this.mBehavior = mBehavior;
            mBehaviorTag = null;
            mBehaviorResolved = true;
        }
    }
    
    void setChangedAfterNestedScroll(final boolean mDidChangeAfterNestedScroll) {
        this.mDidChangeAfterNestedScroll = mDidChangeAfterNestedScroll;
    }
    
    void setLastChildRect(final Rect rect) {
        mLastChildRect.set(rect);
    }
}
