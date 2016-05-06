package android.support.v7.widget;

import android.view.MenuItem;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.View;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.appcompat.R;
import android.content.Context;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;

private class ActionButtonSubmenu extends MenuPopupHelper
{
    private SubMenuBuilder mSubMenu;
    final /* synthetic */ ActionMenuPresenter this$0;
    
    public ActionButtonSubmenu(final ActionMenuPresenter this$0, final Context context, final SubMenuBuilder mSubMenu) {
        this$0 = this$0;
        super(context, mSubMenu, null, false, R.attr.actionOverflowMenuStyle);
        mSubMenu = mSubMenu;
        if (!((MenuItemImpl)mSubMenu.getItem()).isActionButton()) {
            Object access$600;
            if (ActionMenuPresenter.access$600(this$0) == null) {
                access$600 = ActionMenuPresenter.access$700(this$0);
            }
            else {
                access$600 = ActionMenuPresenter.access$600(this$0);
            }
            this.setAnchorView((View)access$600);
        }
        this.setCallback(mPopupPresenterCallback);
        final int size = mSubMenu.size();
        int n = 0;
        boolean forceShowIcon;
        while (true) {
            forceShowIcon = false;
            if (n >= size) {
                break;
            }
            final MenuItem item = mSubMenu.getItem(n);
            if (item.isVisible() && item.getIcon() != null) {
                forceShowIcon = true;
                break;
            }
            ++n;
        }
        this.setForceShowIcon(forceShowIcon);
    }
    
    @Override
    public void onDismiss() {
        super.onDismiss();
        ActionMenuPresenter.access$802(this$0, null);
        mOpenSubMenuId = 0;
    }
}
