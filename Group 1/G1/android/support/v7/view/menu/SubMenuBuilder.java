package android.support.v7.view.menu;

import android.view.View;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;
import android.view.SubMenu;

public class SubMenuBuilder extends MenuBuilder implements SubMenu
{
    private MenuItemImpl mItem;
    private MenuBuilder mParentMenu;
    
    public SubMenuBuilder(final Context context, final MenuBuilder mParentMenu, final MenuItemImpl mItem) {
        super(context);
        mParentMenu = mParentMenu;
        mItem = mItem;
    }
    
    @Override
    public boolean collapseItemActionView(final MenuItemImpl menuItemImpl) {
        return mParentMenu.collapseItemActionView(menuItemImpl);
    }
    
    @Override
    boolean dispatchMenuItemSelected(final MenuBuilder menuBuilder, final MenuItem menuItem) {
        return super.dispatchMenuItemSelected(menuBuilder, menuItem) || mParentMenu.dispatchMenuItemSelected(menuBuilder, menuItem);
    }
    
    @Override
    public boolean expandItemActionView(final MenuItemImpl menuItemImpl) {
        return mParentMenu.expandItemActionView(menuItemImpl);
    }
    
    public String getActionViewStatesKey() {
        int itemId;
        if (mItem != null) {
            itemId = mItem.getItemId();
        }
        else {
            itemId = 0;
        }
        if (itemId == 0) {
            return null;
        }
        return super.getActionViewStatesKey() + ":" + itemId;
    }
    
    public MenuItem getItem() {
        return (MenuItem)mItem;
    }
    
    public Menu getParentMenu() {
        return (Menu)mParentMenu;
    }
    
    @Override
    public MenuBuilder getRootMenu() {
        return mParentMenu;
    }
    
    public boolean isQwertyMode() {
        return mParentMenu.isQwertyMode();
    }
    
    @Override
    public boolean isShortcutsVisible() {
        return mParentMenu.isShortcutsVisible();
    }
    
    @Override
    public void setCallback(final Callback callback) {
        mParentMenu.setCallback(callback);
    }
    
    public SubMenu setHeaderIcon(final int n) {
        super.setHeaderIconInt(ContextCompat.getDrawable(this.getContext(), n));
        return (SubMenu)this;
    }
    
    public SubMenu setHeaderIcon(final Drawable headerIconInt) {
        super.setHeaderIconInt(headerIconInt);
        return (SubMenu)this;
    }
    
    public SubMenu setHeaderTitle(final int n) {
        super.setHeaderTitleInt(this.getContext().getResources().getString(n));
        return (SubMenu)this;
    }
    
    public SubMenu setHeaderTitle(final CharSequence headerTitleInt) {
        super.setHeaderTitleInt(headerTitleInt);
        return (SubMenu)this;
    }
    
    public SubMenu setHeaderView(final View headerViewInt) {
        super.setHeaderViewInt(headerViewInt);
        return (SubMenu)this;
    }
    
    public SubMenu setIcon(final int icon) {
        mItem.setIcon(icon);
        return (SubMenu)this;
    }
    
    public SubMenu setIcon(final Drawable icon) {
        mItem.setIcon(icon);
        return (SubMenu)this;
    }
    
    @Override
    public void setQwertyMode(final boolean qwertyMode) {
        mParentMenu.setQwertyMode(qwertyMode);
    }
    
    @Override
    public void setShortcutsVisible(final boolean shortcutsVisible) {
        mParentMenu.setShortcutsVisible(shortcutsVisible);
    }
}
