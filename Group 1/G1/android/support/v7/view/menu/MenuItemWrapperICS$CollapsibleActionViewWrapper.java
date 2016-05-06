package android.support.v7.view.menu;

import android.view.View;
import android.support.v7.view.CollapsibleActionView;
import android.widget.FrameLayout;

static class CollapsibleActionViewWrapper extends FrameLayout implements CollapsibleActionView
{
    final android.view.CollapsibleActionView mWrappedView;
    
    CollapsibleActionViewWrapper(final View view) {
        super(view.getContext());
        this.mWrappedView = (android.view.CollapsibleActionView)view;
        this.addView(view);
    }
    
    View getWrappedView() {
        return (View)mWrappedView;
    }
    
    public void onActionViewCollapsed() {
        mWrappedView.onActionViewCollapsed();
    }
    
    public void onActionViewExpanded() {
        mWrappedView.onActionViewExpanded();
    }
}
