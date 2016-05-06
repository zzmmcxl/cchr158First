package android.support.v7.app;

import android.support.v7.view.menu.MenuPopupHelper;
import android.view.MenuItem;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.view.SupportMenuInflater;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.View;
import java.lang.ref.WeakReference;
import android.content.Context;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.ActionMode;

public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback
{
    private final Context mActionModeContext;
    private ActionMode.Callback mCallback;
    private WeakReference<View> mCustomView;
    private final MenuBuilder mMenu;
    final /* synthetic */ WindowDecorActionBar this$0;
    
    public ActionModeImpl(final WindowDecorActionBar this$0, final Context mActionModeContext, final ActionMode.Callback mCallback) {
        this$0 = this$0;
        super();
        mActionModeContext = mActionModeContext;
        mCallback = mCallback;
        (mMenu = new MenuBuilder(mActionModeContext).setDefaultShowAsAction(1)).setCallback((MenuBuilder.Callback)this);
    }
    
    public boolean dispatchOnCreate() {
        mMenu.stopDispatchingItemsChanged();
        try {
            return mCallback.onCreateActionMode(this, (Menu)mMenu);
        }
        finally {
            mMenu.startDispatchingItemsChanged();
        }
    }
    
    @Override
    public void finish() {
        if (mActionMode != this) {
            return;
        }
        if (!WindowDecorActionBar.access$700(WindowDecorActionBar.access$500(this$0), WindowDecorActionBar.access$600(this$0), false)) {
            mDeferredDestroyActionMode = this;
            mDeferredModeDestroyCallback = mCallback;
        }
        else {
            mCallback.onDestroyActionMode(this);
        }
        mCallback = null;
        this$0.animateToMode(false);
        WindowDecorActionBar.access$800(this$0).closeMode();
        WindowDecorActionBar.access$900(this$0).getViewGroup().sendAccessibilityEvent(32);
        WindowDecorActionBar.access$400(this$0).setHideOnContentScrollEnabled(mHideOnContentScroll);
        mActionMode = null;
    }
    
    @Override
    public View getCustomView() {
        if (mCustomView != null) {
            return mCustomView.get();
        }
        return null;
    }
    
    @Override
    public Menu getMenu() {
        return (Menu)mMenu;
    }
    
    @Override
    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(mActionModeContext);
    }
    
    @Override
    public CharSequence getSubtitle() {
        return WindowDecorActionBar.access$800(this$0).getSubtitle();
    }
    
    @Override
    public CharSequence getTitle() {
        return WindowDecorActionBar.access$800(this$0).getTitle();
    }
    
    @Override
    public void invalidate() {
        if (mActionMode != this) {
            return;
        }
        mMenu.stopDispatchingItemsChanged();
        try {
            mCallback.onPrepareActionMode(this, (Menu)mMenu);
        }
        finally {
            mMenu.startDispatchingItemsChanged();
        }
    }
    
    @Override
    public boolean isTitleOptional() {
        return WindowDecorActionBar.access$800(this$0).isTitleOptional();
    }
    
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
    }
    
    public void onCloseSubMenu(final SubMenuBuilder subMenuBuilder) {
    }
    
    @Override
    public boolean onMenuItemSelected(final MenuBuilder menuBuilder, final MenuItem menuItem) {
        return mCallback != null && mCallback.onActionItemClicked(this, menuItem);
    }
    
    @Override
    public void onMenuModeChange(final MenuBuilder menuBuilder) {
        if (mCallback == null) {
            return;
        }
        this.invalidate();
        WindowDecorActionBar.access$800(this$0).showOverflowMenu();
    }
    
    public boolean onSubMenuSelected(final SubMenuBuilder subMenuBuilder) {
        boolean b = true;
        if (mCallback == null) {
            b = false;
        }
        else if (subMenuBuilder.hasVisibleItems()) {
            new MenuPopupHelper(this$0.getThemedContext(), subMenuBuilder).show();
            return b;
        }
        return b;
    }
    
    @Override
    public void setCustomView(final View customView) {
        WindowDecorActionBar.access$800(this$0).setCustomView(customView);
        mCustomView = new WeakReference<View>(customView);
    }
    
    @Override
    public void setSubtitle(final int n) {
        this.setSubtitle(WindowDecorActionBar.access$1000(this$0).getResources().getString(n));
    }
    
    @Override
    public void setSubtitle(final CharSequence subtitle) {
        WindowDecorActionBar.access$800(this$0).setSubtitle(subtitle);
    }
    
    @Override
    public void setTitle(final int n) {
        this.setTitle(WindowDecorActionBar.access$1000(this$0).getResources().getString(n));
    }
    
    @Override
    public void setTitle(final CharSequence title) {
        WindowDecorActionBar.access$800(this$0).setTitle(title);
    }
    
    @Override
    public void setTitleOptionalHint(final boolean b) {
        super.setTitleOptionalHint(b);
        WindowDecorActionBar.access$800(this$0).setTitleOptional(b);
    }
}
