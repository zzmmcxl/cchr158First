package android.support.v7.widget;

import android.view.accessibility.AccessibilityEvent;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.support.v4.view.AccessibilityDelegateCompat;

public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat
{
    final AccessibilityDelegateCompat mItemDelegate;
    final RecyclerView mRecyclerView;
    
    public RecyclerViewAccessibilityDelegate(final RecyclerView mRecyclerView) {
        super();
        mItemDelegate = new AccessibilityDelegateCompat() {
            final /* synthetic */ RecyclerViewAccessibilityDelegate this$0;
            
            RecyclerViewAccessibilityDelegate$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void onInitializeAccessibilityNodeInfo(final View view, final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                if (!this$0.shouldIgnore() && mRecyclerView.getLayoutManager() != null) {
                    mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
                }
            }
            
            @Override
            public boolean performAccessibilityAction(final View view, final int n, final Bundle bundle) {
                return super.performAccessibilityAction(view, n, bundle) || (!this$0.shouldIgnore() && mRecyclerView.getLayoutManager() != null && mRecyclerView.getLayoutManager().performAccessibilityActionForItem(view, n, bundle));
            }
        };
        mRecyclerView = mRecyclerView;
    }
    
    static /* synthetic */ boolean access$000(final RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        return recyclerViewAccessibilityDelegate.shouldIgnore();
    }
    
    private boolean shouldIgnore() {
        return mRecyclerView.hasPendingAdapterUpdates();
    }
    
    AccessibilityDelegateCompat getItemDelegate() {
        return mItemDelegate;
    }
    
    @Override
    public void onInitializeAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)RecyclerView.class.getName());
        if (view instanceof RecyclerView && !this.shouldIgnore()) {
            final RecyclerView recyclerView = (RecyclerView)view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }
    }
    
    @Override
    public void onInitializeAccessibilityNodeInfo(final View view, final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName(RecyclerView.class.getName());
        if (!this.shouldIgnore() && mRecyclerView.getLayoutManager() != null) {
            mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
        }
    }
    
    @Override
    public boolean performAccessibilityAction(final View view, final int n, final Bundle bundle) {
        return super.performAccessibilityAction(view, n, bundle) || (!this.shouldIgnore() && mRecyclerView.getLayoutManager() != null && mRecyclerView.getLayoutManager().performAccessibilityAction(n, bundle));
    }
}
