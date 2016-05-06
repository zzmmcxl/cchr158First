package android.support.v7.widget;

import android.support.v7.view.menu.SubMenuBuilder;
import android.os.Parcelable;
import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;

private class ExpandedActionViewMenuPresenter implements MenuPresenter
{
    MenuItemImpl mCurrentExpandedItem;
    MenuBuilder mMenu;
    final /* synthetic */ Toolbar this$0;
    
    private ExpandedActionViewMenuPresenter(final Toolbar this$0) {
        this$0 = this$0;
        super();
    }
    
    ExpandedActionViewMenuPresenter(final Toolbar toolbar, final Toolbar$1 onMenuItemClickListener) {
        this(toolbar);
    }
    
    @Override
    public boolean collapseItemActionView(final MenuBuilder menuBuilder, final MenuItemImpl menuItemImpl) {
        if (mExpandedActionView instanceof CollapsibleActionView) {
            ((CollapsibleActionView)mExpandedActionView).onActionViewCollapsed();
        }
        this$0.removeView(mExpandedActionView);
        this$0.removeView((View)Toolbar.access$300(this$0));
        mExpandedActionView = null;
        this$0.addChildrenForExpandedActionView();
        mCurrentExpandedItem = null;
        this$0.requestLayout();
        menuItemImpl.setActionViewExpanded(false);
        return true;
    }
    
    @Override
    public boolean expandItemActionView(final MenuBuilder menuBuilder, final MenuItemImpl mCurrentExpandedItem) {
        Toolbar.access$200(this$0);
        if (Toolbar.access$300(this$0).getParent() != this$0) {
            this$0.addView((View)Toolbar.access$300(this$0));
        }
        mExpandedActionView = mCurrentExpandedItem.getActionView();
        this.mCurrentExpandedItem = mCurrentExpandedItem;
        if (mExpandedActionView.getParent() != this$0) {
            final LayoutParams generateDefaultLayoutParams = this$0.generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (0x800003 | (0x70 & Toolbar.access$400(this$0)));
            generateDefaultLayoutParams.mViewType = 2;
            mExpandedActionView.setLayoutParams((ViewGroup$LayoutParams)generateDefaultLayoutParams);
            this$0.addView(mExpandedActionView);
        }
        this$0.removeChildrenForExpandedActionView();
        this$0.requestLayout();
        mCurrentExpandedItem.setActionViewExpanded(true);
        if (mExpandedActionView instanceof CollapsibleActionView) {
            ((CollapsibleActionView)mExpandedActionView).onActionViewExpanded();
        }
        return true;
    }
    
    @Override
    public boolean flagActionItems() {
        return false;
    }
    
    @Override
    public int getId() {
        return 0;
    }
    
    @Override
    public MenuView getMenuView(final ViewGroup viewGroup) {
        return null;
    }
    
    @Override
    public void initForMenu(final Context context, final MenuBuilder mMenu) {
        if (this.mMenu != null && mCurrentExpandedItem != null) {
            this.mMenu.collapseItemActionView(mCurrentExpandedItem);
        }
        this.mMenu = mMenu;
    }
    
    @Override
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
    }
    
    @Override
    public void onRestoreInstanceState(final Parcelable parcelable) {
    }
    
    @Override
    public Parcelable onSaveInstanceState() {
        return null;
    }
    
    @Override
    public boolean onSubMenuSelected(final SubMenuBuilder subMenuBuilder) {
        return false;
    }
    
    @Override
    public void setCallback(final Callback callback) {
    }
    
    @Override
    public void updateMenuView(final boolean b) {
        if (mCurrentExpandedItem != null) {
            final MenuBuilder mMenu = this.mMenu;
            boolean b2 = false;
            if (mMenu != null) {
                final int size = this.mMenu.size();
                int n = 0;
                while (true) {
                    b2 = false;
                    if (n >= size) {
                        break;
                    }
                    if (this.mMenu.getItem(n) == mCurrentExpandedItem) {
                        b2 = true;
                        break;
                    }
                    ++n;
                }
            }
            if (!b2) {
                this.collapseItemActionView(this.mMenu, mCurrentExpandedItem);
            }
        }
    }
}
