package android.support.v7.view.menu;

import android.view.SubMenu;
import android.view.View;
import android.content.Context;
import android.support.v4.view.ActionProvider;

class ActionProviderWrapper extends ActionProvider
{
    final android.view.ActionProvider mInner;
    final /* synthetic */ MenuItemWrapperICS this$0;
    
    public ActionProviderWrapper(final MenuItemWrapperICS this$0, final Context context, final android.view.ActionProvider mInner) {
        this$0 = this$0;
        super(context);
        mInner = mInner;
    }
    
    @Override
    public boolean hasSubMenu() {
        return mInner.hasSubMenu();
    }
    
    @Override
    public View onCreateActionView() {
        return mInner.onCreateActionView();
    }
    
    @Override
    public boolean onPerformDefaultAction() {
        return mInner.onPerformDefaultAction();
    }
    
    @Override
    public void onPrepareSubMenu(final SubMenu subMenu) {
        mInner.onPrepareSubMenu(this$0.getSubMenuWrapper(subMenu));
    }
}
