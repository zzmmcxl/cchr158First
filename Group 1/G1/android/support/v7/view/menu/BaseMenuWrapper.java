package android.support.v7.view.menu;

import java.util.Iterator;
import android.support.v4.util.ArrayMap;
import android.view.SubMenu;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.MenuItem;
import android.support.v4.internal.view.SupportMenuItem;
import java.util.Map;
import android.content.Context;

abstract class BaseMenuWrapper<T> extends BaseWrapper<T>
{
    final Context mContext;
    private Map<SupportMenuItem, MenuItem> mMenuItems;
    private Map<SupportSubMenu, SubMenu> mSubMenus;
    
    BaseMenuWrapper(final Context mContext, final T t) {
        super(t);
        mContext = mContext;
    }
    
    final MenuItem getMenuItemWrapper(final MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            final SupportMenuItem supportMenuItem = (SupportMenuItem)menuItem;
            if (mMenuItems == null) {
                mMenuItems = new ArrayMap<SupportMenuItem, MenuItem>();
            }
            MenuItem wrapSupportMenuItem = (MenuItem)mMenuItems.get(menuItem);
            if (wrapSupportMenuItem == null) {
                wrapSupportMenuItem = MenuWrapperFactory.wrapSupportMenuItem(mContext, supportMenuItem);
                mMenuItems.put(supportMenuItem, wrapSupportMenuItem);
            }
            return wrapSupportMenuItem;
        }
        return menuItem;
    }
    
    final SubMenu getSubMenuWrapper(final SubMenu subMenu) {
        if (subMenu instanceof SupportSubMenu) {
            final SupportSubMenu supportSubMenu = (SupportSubMenu)subMenu;
            if (mSubMenus == null) {
                mSubMenus = new ArrayMap<SupportSubMenu, SubMenu>();
            }
            SubMenu wrapSupportSubMenu = (SubMenu)mSubMenus.get(supportSubMenu);
            if (wrapSupportSubMenu == null) {
                wrapSupportSubMenu = MenuWrapperFactory.wrapSupportSubMenu(mContext, supportSubMenu);
                mSubMenus.put(supportSubMenu, wrapSupportSubMenu);
            }
            return wrapSupportSubMenu;
        }
        return subMenu;
    }
    
    final void internalClear() {
        if (mMenuItems != null) {
            mMenuItems.clear();
        }
        if (mSubMenus != null) {
            mSubMenus.clear();
        }
    }
    
    final void internalRemoveGroup(final int n) {
        if (mMenuItems != null) {
            final Iterator<SupportMenuItem> iterator = mMenuItems.keySet().iterator();
            while (iterator.hasNext()) {
                if (n == ((MenuItem)iterator.next()).getGroupId()) {
                    iterator.remove();
                }
            }
        }
    }
    
    final void internalRemoveItem(final int n) {
        if (mMenuItems != null) {
            final Iterator<SupportMenuItem> iterator = mMenuItems.keySet().iterator();
            while (iterator.hasNext()) {
                if (n == ((MenuItem)iterator.next()).getItemId()) {
                    iterator.remove();
                }
            }
        }
    }
}
