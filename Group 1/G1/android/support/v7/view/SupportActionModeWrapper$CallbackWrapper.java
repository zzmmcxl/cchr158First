package android.support.v7.view;

import android.support.v4.internal.view.SupportMenuItem;
import android.view.MenuItem;
import android.support.v7.view.menu.MenuWrapperFactory;
import android.support.v4.internal.view.SupportMenu;
import android.view.ActionMode$Callback;
import android.view.Menu;
import android.support.v4.util.SimpleArrayMap;
import android.content.Context;
import java.util.ArrayList;

public static class CallbackWrapper implements Callback
{
    final ArrayList<SupportActionModeWrapper> mActionModes;
    final Context mContext;
    final SimpleArrayMap<Menu, Menu> mMenus;
    final ActionMode$Callback mWrappedCallback;
    
    public CallbackWrapper(final Context mContext, final ActionMode$Callback mWrappedCallback) {
        super();
        this.mContext = mContext;
        this.mWrappedCallback = mWrappedCallback;
        this.mActionModes = new ArrayList<SupportActionModeWrapper>();
        this.mMenus = new SimpleArrayMap<Menu, Menu>();
    }
    
    private Menu getMenuWrapper(final Menu menu) {
        Menu wrapSupportMenu = (Menu)mMenus.get(menu);
        if (wrapSupportMenu == null) {
            wrapSupportMenu = MenuWrapperFactory.wrapSupportMenu(mContext, (SupportMenu)menu);
            mMenus.put(menu, wrapSupportMenu);
        }
        return wrapSupportMenu;
    }
    
    public android.view.ActionMode getActionModeWrapper(final ActionMode actionMode) {
        for (int i = 0; i < mActionModes.size(); ++i) {
            final SupportActionModeWrapper supportActionModeWrapper = (SupportActionModeWrapper)mActionModes.get(i);
            if (supportActionModeWrapper != null && mWrappedObject == actionMode) {
                return supportActionModeWrapper;
            }
        }
        final SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper(mContext, actionMode);
        mActionModes.add(supportActionModeWrapper2);
        return supportActionModeWrapper2;
    }
    
    @Override
    public boolean onActionItemClicked(final ActionMode actionMode, final MenuItem menuItem) {
        return mWrappedCallback.onActionItemClicked(this.getActionModeWrapper(actionMode), MenuWrapperFactory.wrapSupportMenuItem(mContext, (SupportMenuItem)menuItem));
    }
    
    @Override
    public boolean onCreateActionMode(final ActionMode actionMode, final Menu menu) {
        return mWrappedCallback.onCreateActionMode(this.getActionModeWrapper(actionMode), this.getMenuWrapper(menu));
    }
    
    @Override
    public void onDestroyActionMode(final ActionMode actionMode) {
        mWrappedCallback.onDestroyActionMode(this.getActionModeWrapper(actionMode));
    }
    
    @Override
    public boolean onPrepareActionMode(final ActionMode actionMode, final Menu menu) {
        return mWrappedCallback.onPrepareActionMode(this.getActionModeWrapper(actionMode), this.getMenuWrapper(menu));
    }
}
