package android.support.v7.app;

import android.view.Window$Callback;
import android.view.Menu;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;

private final class ActionMenuPresenterCallback implements MenuPresenter.Callback
{
    final /* synthetic */ AppCompatDelegateImplV7 this$0;
    
    private ActionMenuPresenterCallback(final AppCompatDelegateImplV7 this$0) {
        this$0 = this$0;
        super();
    }
    
    ActionMenuPresenterCallback(final AppCompatDelegateImplV7 appCompatDelegateImplV7, final AppCompatDelegateImplV7$1 runnable) {
        this(appCompatDelegateImplV7);
    }
    
    @Override
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
        AppCompatDelegateImplV7.access$1100(this$0, menuBuilder);
    }
    
    @Override
    public boolean onOpenSubMenu(final MenuBuilder menuBuilder) {
        final Window$Callback windowCallback = this$0.getWindowCallback();
        if (windowCallback != null) {
            windowCallback.onMenuOpened(108, (Menu)menuBuilder);
        }
        return true;
    }
}
