package android.support.v7.app;

import android.support.v7.app.AppCompatDelegateImplV7;
import android.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter$Callback;
import android.view.Window.Callback;

final class AppCompatDelegateImplV7$PanelMenuPresenterCallback implements MenuPresenter$Callback {
   private AppCompatDelegateImplV7$PanelMenuPresenterCallback(AppCompatDelegateImplV7 var1) {
      this.this$0 = var1;
   }

   public void onCloseMenu(MenuBuilder var1, boolean var2) {
      MenuBuilder var4 = var1.getRootMenu();
      boolean var3;
      if(var4 != var1) {
         var3 = true;
      } else {
         var3 = false;
      }

      AppCompatDelegateImplV7 var5 = this.this$0;
      if(var3) {
         var1 = var4;
      }

      AppCompatDelegateImplV7$PanelFeatureState var6 = AppCompatDelegateImplV7.access$800(var5, var1);
      if(var6 != null) {
         if(!var3) {
            AppCompatDelegateImplV7.access$1000(this.this$0, var6, var2);
            return;
         }

         AppCompatDelegateImplV7.access$900(this.this$0, var6.featureId, var6, var4);
         AppCompatDelegateImplV7.access$1000(this.this$0, var6, true);
      }

   }

   public boolean onOpenSubMenu(MenuBuilder var1) {
      if(var1 == null && this.this$0.mHasActionBar) {
         Callback var2 = this.this$0.getWindowCallback();
         if(var2 != null && !this.this$0.isDestroyed()) {
            var2.onMenuOpened(108, var1);
         }
      }

      return true;
   }
}
