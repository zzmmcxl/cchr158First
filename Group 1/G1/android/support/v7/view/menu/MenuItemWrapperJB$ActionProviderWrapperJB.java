package android.support.v7.view.menu;

import android.view.View;
import android.view.MenuItem;
import android.content.Context;
import android.support.v4.view.ActionProvider;
import android.view.ActionProvider$VisibilityListener;

class ActionProviderWrapperJB extends ActionProviderWrapper implements ActionProvider$VisibilityListener
{
    VisibilityListener mListener;
    final /* synthetic */ MenuItemWrapperJB this$0;
    
    public ActionProviderWrapperJB(final MenuItemWrapperJB this$0, final Context context, final android.view.ActionProvider actionProvider) {
        this$0 = this$0;
        super(this$0, context, actionProvider);
    }
    
    public boolean isVisible() {
        return this.mInner.isVisible();
    }
    
    public void onActionProviderVisibilityChanged(final boolean b) {
        if (mListener != null) {
            mListener.onActionProviderVisibilityChanged(b);
        }
    }
    
    public View onCreateActionView(final MenuItem menuItem) {
        return this.mInner.onCreateActionView(menuItem);
    }
    
    public boolean overridesItemVisibility() {
        return this.mInner.overridesItemVisibility();
    }
    
    public void refreshVisibility() {
        this.mInner.refreshVisibility();
    }
    
    public void setVisibilityListener(final VisibilityListener mListener) {
        this.mListener = mListener;
        final android.view.ActionProvider mInner = this.mInner;
        final ActionProvider$VisibilityListener visibilityListener;
        if (mListener == null) {
            visibilityListener = null;
        }
        mInner.setVisibilityListener(visibilityListener);
    }
}
