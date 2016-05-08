package android.support.v7.app;

import android.support.v7.app.AppCompatDelegateImplV7;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter$Callback;
import android.view.Window.Callback;

final class AppCompatDelegateImplV7$ActionMenuPresenterCallback implements MenuPresenter$Callback {
   private AppCompatDelegateImplV7$ActionMenuPresenterCallback(AppCompatDelegateImplV7 var1) {
      this.this$0 = var1;
   }

   public void onCloseMenu(MenuBuilder var1, boolean var2) {
      AppCompatDelegateImplV7.access$1100(this.this$0, var1);
   }

   public boolean onOpenSubMenu(MenuBuilder var1) {
      Callback var2 = this.this$0.getWindowCallback();
      if(var2 != null) {
         var2.onMenuOpened(108, var1);
      }

      return true;
   }
}
