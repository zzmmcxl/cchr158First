package android.support.v4.widget;

import android.support.v4.view.ViewParentCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.MotionEvent;
import android.support.v4.view.accessibility.AccessibilityManagerCompat;
import android.view.ViewParent;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.view.accessibility.AccessibilityEvent;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.graphics.Rect;
import android.view.accessibility.AccessibilityManager;
import android.support.v4.view.AccessibilityDelegateCompat;

public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat
{
    private static final String DEFAULT_CLASS_NAME;
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private int mFocusedVirtualViewId;
    private int mHoveredVirtualViewId;
    private final AccessibilityManager mManager;
    private ExploreByTouchNodeProvider mNodeProvider;
    private final int[] mTempGlobalRect;
    private final Rect mTempParentRect;
    private final Rect mTempScreenRect;
    private final Rect mTempVisibleRect;
    private final View mView;
    
    static {
        DEFAULT_CLASS_NAME = View.class.getName();
    }
    
    public ExploreByTouchHelper(final View mView) {
        super();
        mTempScreenRect = new Rect();
        mTempParentRect = new Rect();
        mTempVisibleRect = new Rect();
        mTempGlobalRect = new int[2];
        mFocusedVirtualViewId = Integer.MIN_VALUE;
        mHoveredVirtualViewId = Integer.MIN_VALUE;
        if (mView == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        mView = mView;
        mManager = (AccessibilityManager)mView.getContext().getSystemService("accessibility");
    }
    
    static /* synthetic */ AccessibilityNodeInfoCompat access$100(final ExploreByTouchHelper exploreByTouchHelper, final int n) {
        return exploreByTouchHelper.createNode(n);
    }
    
    static /* synthetic */ boolean access$200(final ExploreByTouchHelper exploreByTouchHelper, final int n, final int n2, final Bundle bundle) {
        return exploreByTouchHelper.performAction(n, n2, bundle);
    }
    
    private boolean clearAccessibilityFocus(final int n) {
        if (this.isAccessibilityFocused(n)) {
            mFocusedVirtualViewId = Integer.MIN_VALUE;
            mView.invalidate();
            this.sendEventForVirtualView(n, 65536);
            return true;
        }
        return false;
    }
    
    private AccessibilityEvent createEvent(final int n, final int n2) {
        switch (n) {
            default:
                return this.createEventForChild(n, n2);
            case -1:
                return this.createEventForHost(n2);
        }
    }
    
    private AccessibilityEvent createEventForChild(final int n, final int n2) {
        final AccessibilityEvent obtain = AccessibilityEvent.obtain(n2);
        obtain.setEnabled(true);
        obtain.setClassName((CharSequence)DEFAULT_CLASS_NAME);
        this.onPopulateEventForVirtualView(n, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setPackageName((CharSequence)mView.getContext().getPackageName());
        AccessibilityEventCompat.asRecord(obtain).setSource(mView, n);
        return obtain;
    }
    
    private AccessibilityEvent createEventForHost(final int n) {
        final AccessibilityEvent obtain = AccessibilityEvent.obtain(n);
        ViewCompat.onInitializeAccessibilityEvent(mView, obtain);
        return obtain;
    }
    
    private AccessibilityNodeInfoCompat createNode(final int n) {
        switch (n) {
            default:
                return this.createNodeForChild(n);
            case -1:
                return this.createNodeForHost();
        }
    }
    
    private AccessibilityNodeInfoCompat createNodeForChild(final int n) {
        final AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        obtain.setEnabled(true);
        obtain.setClassName(DEFAULT_CLASS_NAME);
        this.onPopulateNodeForVirtualView(n, obtain);
        if (obtain.getText() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        obtain.getBoundsInParent(mTempParentRect);
        if (mTempParentRect.isEmpty()) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        final int actions = obtain.getActions();
        if ((actions & 0x40) != 0x0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & 0x80) != 0x0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        obtain.setPackageName(mView.getContext().getPackageName());
        obtain.setSource(mView, n);
        obtain.setParent(mView);
        if (mFocusedVirtualViewId == n) {
            obtain.setAccessibilityFocused(true);
            obtain.addAction(128);
        }
        else {
            obtain.setAccessibilityFocused(false);
            obtain.addAction(64);
        }
        if (this.intersectVisibleToUser(mTempParentRect)) {
            obtain.setVisibleToUser(true);
            obtain.setBoundsInParent(mTempParentRect);
        }
        mView.getLocationOnScreen(mTempGlobalRect);
        final int n2 = mTempGlobalRect[0];
        final int n3 = mTempGlobalRect[1];
        mTempScreenRect.set(mTempParentRect);
        mTempScreenRect.offset(n2, n3);
        obtain.setBoundsInScreen(mTempScreenRect);
        return obtain;
    }
    
    private AccessibilityNodeInfoCompat createNodeForHost() {
        final AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(mView);
        ViewCompat.onInitializeAccessibilityNodeInfo(mView, obtain);
        this.onPopulateNodeForHost(obtain);
        final LinkedList<Integer> list = new LinkedList<Integer>();
        this.getVisibleVirtualViews(list);
        final Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            obtain.addChild(mView, iterator.next());
        }
        return obtain;
    }
    
    private boolean intersectVisibleToUser(final Rect rect) {
        if (rect != null && !rect.isEmpty() && mView.getWindowVisibility() == 0) {
            ViewParent viewParent;
            View view;
            for (viewParent = mView.getParent(); viewParent instanceof View; viewParent = view.getParent()) {
                view = (View)viewParent;
                if (ViewCompat.getAlpha(view) <= 0.0f || view.getVisibility() != 0) {
                    return false;
                }
            }
            if (viewParent != null && mView.getLocalVisibleRect(mTempVisibleRect)) {
                return rect.intersect(mTempVisibleRect);
            }
        }
        return false;
    }
    
    private boolean isAccessibilityFocused(final int n) {
        return mFocusedVirtualViewId == n;
    }
    
    private boolean manageFocusForChild(final int n, final int n2, final Bundle bundle) {
        switch (n2) {
            default:
                return false;
            case 64:
                return this.requestAccessibilityFocus(n);
            case 128:
                return this.clearAccessibilityFocus(n);
        }
    }
    
    private boolean performAction(final int n, final int n2, final Bundle bundle) {
        switch (n) {
            default:
                return this.performActionForChild(n, n2, bundle);
            case -1:
                return this.performActionForHost(n2, bundle);
        }
    }
    
    private boolean performActionForChild(final int n, final int n2, final Bundle bundle) {
        switch (n2) {
            default:
                return this.onPerformActionForVirtualView(n, n2, bundle);
            case 64:
            case 128:
                return this.manageFocusForChild(n, n2, bundle);
        }
    }
    
    private boolean performActionForHost(final int n, final Bundle bundle) {
        return ViewCompat.performAccessibilityAction(mView, n, bundle);
    }
    
    private boolean requestAccessibilityFocus(final int mFocusedVirtualViewId) {
        if (mManager.isEnabled() && AccessibilityManagerCompat.isTouchExplorationEnabled(mManager) && !this.isAccessibilityFocused(mFocusedVirtualViewId)) {
            if (this.mFocusedVirtualViewId != Integer.MIN_VALUE) {
                this.sendEventForVirtualView(this.mFocusedVirtualViewId, 65536);
            }
            this.mFocusedVirtualViewId = mFocusedVirtualViewId;
            mView.invalidate();
            this.sendEventForVirtualView(mFocusedVirtualViewId, 32768);
            return true;
        }
        return false;
    }
    
    private void updateHoveredVirtualView(final int mHoveredVirtualViewId) {
        if (this.mHoveredVirtualViewId == mHoveredVirtualViewId) {
            return;
        }
        final int mHoveredVirtualViewId2 = this.mHoveredVirtualViewId;
        this.sendEventForVirtualView(this.mHoveredVirtualViewId = mHoveredVirtualViewId, 128);
        this.sendEventForVirtualView(mHoveredVirtualViewId2, 256);
    }
    
    public boolean dispatchHoverEvent(final MotionEvent motionEvent) {
        boolean b = true;
        if (mManager.isEnabled() && AccessibilityManagerCompat.isTouchExplorationEnabled(mManager)) {
            switch (motionEvent.getAction()) {
                default:
                    return false;
                case 7:
                case 9: {
                    final int virtualView = this.getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
                    this.updateHoveredVirtualView(virtualView);
                    if (virtualView == Integer.MIN_VALUE) {
                        b = false;
                    }
                    return b;
                }
                case 10:
                    if (mFocusedVirtualViewId != Integer.MIN_VALUE) {
                        this.updateHoveredVirtualView(Integer.MIN_VALUE);
                        return b;
                    }
                    break;
            }
        }
        return false;
    }
    
    @Override
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(final View view) {
        if (mNodeProvider == null) {
            mNodeProvider = new ExploreByTouchNodeProvider(this);
        }
        return mNodeProvider;
    }
    
    public int getFocusedVirtualView() {
        return mFocusedVirtualViewId;
    }
    
    protected abstract int getVirtualViewAt(final float p0, final float p1);
    
    protected abstract void getVisibleVirtualViews(final List<Integer> p0);
    
    public void invalidateRoot() {
        this.invalidateVirtualView(-1);
    }
    
    public void invalidateVirtualView(final int n) {
        this.sendEventForVirtualView(n, 2048);
    }
    
    protected abstract boolean onPerformActionForVirtualView(final int p0, final int p1, final Bundle p2);
    
    protected abstract void onPopulateEventForVirtualView(final int p0, final AccessibilityEvent p1);
    
    public void onPopulateNodeForHost(final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }
    
    protected abstract void onPopulateNodeForVirtualView(final int p0, final AccessibilityNodeInfoCompat p1);
    
    public boolean sendEventForVirtualView(final int n, final int n2) {
        if (n != Integer.MIN_VALUE && mManager.isEnabled()) {
            final ViewParent parent = mView.getParent();
            if (parent != null) {
                return ViewParentCompat.requestSendAccessibilityEvent(parent, mView, this.createEvent(n, n2));
            }
        }
        return false;
    }
}
