package android.support.v7.app;

import android.view.Window$Callback;
import android.view.Menu;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;

private final class PanelMenuPresenterCallback implements MenuPresenter.Callback
{
    final /* synthetic */ AppCompatDelegateImplV7 this$0;
    
    private PanelMenuPresenterCallback(final AppCompatDelegateImplV7 this$0) {
        this$0 = this$0;
        super();
    }
    
    PanelMenuPresenterCallback(final AppCompatDelegateImplV7 appCompatDelegateImplV7, final AppCompatDelegateImplV7$1 runnable) {
        this(appCompatDelegateImplV7);
    }
    
    @Override
    public void onCloseMenu(MenuBuilder menuBuilder, final boolean b) {
        final Object rootMenu = menuBuilder.getRootMenu();
        boolean b2;
        if (rootMenu != menuBuilder) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        final AppCompatDelegateImplV7 this$0 = this.this$0;
        if (b2) {
            menuBuilder = (MenuBuilder)rootMenu;
        }
        final PanelFeatureState access$800 = AppCompatDelegateImplV7.access$800(this$0, (Menu)menuBuilder);
        if (access$800 != null) {
            if (!b2) {
                AppCompatDelegateImplV7.access$1000(this.this$0, access$800, b);
                return;
            }
            AppCompatDelegateImplV7.access$900(this.this$0, access$800.featureId, access$800, (Menu)rootMenu);
            AppCompatDelegateImplV7.access$1000(this.this$0, access$800, true);
        }
    }
    
    @Override
    public boolean onOpenSubMenu(final MenuBuilder menuBuilder) {
        if (menuBuilder == null && this$0.mHasActionBar) {
            final Window$Callback windowCallback = this$0.getWindowCallback();
            if (windowCallback != null && !this$0.isDestroyed()) {
                windowCallback.onMenuOpened(108, (Menu)menuBuilder);
            }
        }
        return true;
    }
}
