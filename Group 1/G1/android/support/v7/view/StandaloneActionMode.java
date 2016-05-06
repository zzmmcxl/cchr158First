package android.support.v7.view;

import android.support.v7.view.menu.MenuPopupHelper;
import android.view.MenuItem;
import android.support.v7.view.menu.SubMenuBuilder;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.View;
import java.lang.ref.WeakReference;
import android.support.v7.widget.ActionBarContextView;
import android.content.Context;
import android.support.v7.view.menu.MenuBuilder;

public class StandaloneActionMode extends ActionMode implements MenuBuilder.Callback
{
    private ActionMode.Callback mCallback;
    private Context mContext;
    private ActionBarContextView mContextView;
    private WeakReference<View> mCustomView;
    private boolean mFinished;
    private boolean mFocusable;
    private MenuBuilder mMenu;
    
    public StandaloneActionMode(final Context mContext, final ActionBarContextView mContextView, final ActionMode.Callback mCallback, final boolean mFocusable) {
        super();
        mContext = mContext;
        mContextView = mContextView;
        mCallback = mCallback;
        (mMenu = new MenuBuilder(mContextView.getContext()).setDefaultShowAsAction(1)).setCallback((MenuBuilder.Callback)this);
        mFocusable = mFocusable;
    }
    
    @Override
    public void finish() {
        if (mFinished) {
            return;
        }
        mFinished = true;
        mContextView.sendAccessibilityEvent(32);
        mCallback.onDestroyActionMode(this);
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
        return new MenuInflater(mContextView.getContext());
    }
    
    @Override
    public CharSequence getSubtitle() {
        return mContextView.getSubtitle();
    }
    
    @Override
    public CharSequence getTitle() {
        return mContextView.getTitle();
    }
    
    @Override
    public void invalidate() {
        mCallback.onPrepareActionMode(this, (Menu)mMenu);
    }
    
    @Override
    public boolean isTitleOptional() {
        return mContextView.isTitleOptional();
    }
    
    @Override
    public boolean isUiFocusable() {
        return mFocusable;
    }
    
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
    }
    
    public void onCloseSubMenu(final SubMenuBuilder subMenuBuilder) {
    }
    
    @Override
    public boolean onMenuItemSelected(final MenuBuilder menuBuilder, final MenuItem menuItem) {
        return mCallback.onActionItemClicked(this, menuItem);
    }
    
    @Override
    public void onMenuModeChange(final MenuBuilder menuBuilder) {
        this.invalidate();
        mContextView.showOverflowMenu();
    }
    
    public boolean onSubMenuSelected(final SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return true;
        }
        new MenuPopupHelper(mContextView.getContext(), subMenuBuilder).show();
        return true;
    }
    
    @Override
    public void setCustomView(final View customView) {
        mContextView.setCustomView(customView);
        WeakReference<View> mCustomView;
        if (customView != null) {
            mCustomView = new WeakReference<View>(customView);
        }
        else {
            mCustomView = null;
        }
        this.mCustomView = mCustomView;
    }
    
    @Override
    public void setSubtitle(final int n) {
        this.setSubtitle(mContext.getString(n));
    }
    
    @Override
    public void setSubtitle(final CharSequence subtitle) {
        mContextView.setSubtitle(subtitle);
    }
    
    @Override
    public void setTitle(final int n) {
        this.setTitle(mContext.getString(n));
    }
    
    @Override
    public void setTitle(final CharSequence title) {
        mContextView.setTitle(title);
    }
    
    @Override
    public void setTitleOptionalHint(final boolean b) {
        super.setTitleOptionalHint(b);
        mContextView.setTitleOptional(b);
    }
}
