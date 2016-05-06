package android.support.v4.view;

import android.util.Log;
import android.view.SubMenu;
import android.view.MenuItem;
import android.view.View;
import android.content.Context;

public abstract class ActionProvider
{
    private static final String TAG = "ActionProvider(support)";
    private final Context mContext;
    private SubUiVisibilityListener mSubUiVisibilityListener;
    private VisibilityListener mVisibilityListener;
    
    public ActionProvider(final Context mContext) {
        super();
        mContext = mContext;
    }
    
    public Context getContext() {
        return mContext;
    }
    
    public boolean hasSubMenu() {
        return false;
    }
    
    public boolean isVisible() {
        return true;
    }
    
    public abstract View onCreateActionView();
    
    public View onCreateActionView(final MenuItem menuItem) {
        return this.onCreateActionView();
    }
    
    public boolean onPerformDefaultAction() {
        return false;
    }
    
    public void onPrepareSubMenu(final SubMenu subMenu) {
    }
    
    public boolean overridesItemVisibility() {
        return false;
    }
    
    public void refreshVisibility() {
        if (mVisibilityListener != null && this.overridesItemVisibility()) {
            mVisibilityListener.onActionProviderVisibilityChanged(this.isVisible());
        }
    }
    
    public void reset() {
        mVisibilityListener = null;
        mSubUiVisibilityListener = null;
    }
    
    public void setSubUiVisibilityListener(final SubUiVisibilityListener mSubUiVisibilityListener) {
        this.mSubUiVisibilityListener = mSubUiVisibilityListener;
    }
    
    public void setVisibilityListener(final VisibilityListener mVisibilityListener) {
        if (this.mVisibilityListener != null && mVisibilityListener != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + this.getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.mVisibilityListener = mVisibilityListener;
    }
    
    public void subUiVisibilityChanged(final boolean b) {
        if (mSubUiVisibilityListener != null) {
            mSubUiVisibilityListener.onSubUiVisibilityChanged(b);
        }
    }
}
