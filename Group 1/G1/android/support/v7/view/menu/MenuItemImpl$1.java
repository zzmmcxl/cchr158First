package android.support.v7.view.menu;

import android.support.v4.view.ActionProvider;

class MenuItemImpl$1 implements VisibilityListener {
    final /* synthetic */ MenuItemImpl this$0;
    
    MenuItemImpl$1(final MenuItemImpl this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void onActionProviderVisibilityChanged(final boolean b) {
        MenuItemImpl.access$000(this$0).onItemVisibleChanged(this$0);
    }
}