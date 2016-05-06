package android.support.v7.widget;

import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;

private class PopupPresenterCallback implements Callback
{
    final /* synthetic */ ActionMenuPresenter this$0;
    
    private PopupPresenterCallback(final ActionMenuPresenter this$0) {
        this$0 = this$0;
        super();
    }
    
    PopupPresenterCallback(final ActionMenuPresenter actionMenuPresenter, final ActionMenuPresenter$1 object) {
        this(actionMenuPresenter);
    }
    
    @Override
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
        if (menuBuilder instanceof SubMenuBuilder) {
            ((SubMenuBuilder)menuBuilder).getRootMenu().close(false);
        }
        final Callback callback = this$0.getCallback();
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, b);
        }
    }
    
    @Override
    public boolean onOpenSubMenu(final MenuBuilder menuBuilder) {
        if (menuBuilder == null) {
            return false;
        }
        mOpenSubMenuId = ((SubMenuBuilder)menuBuilder).getItem().getItemId();
        final Callback callback = this$0.getCallback();
        return callback != null && callback.onOpenSubMenu(menuBuilder);
    }
}
