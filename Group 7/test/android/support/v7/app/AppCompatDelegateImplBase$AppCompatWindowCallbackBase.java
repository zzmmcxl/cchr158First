package android.support.v7.app;

import android.support.v7.app.AppCompatDelegateImplBase;
import android.support.v7.view.WindowCallbackWrapper;
import android.support.v7.view.menu.MenuBuilder;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window.Callback;

class AppCompatDelegateImplBase$AppCompatWindowCallbackBase extends WindowCallbackWrapper {
   AppCompatDelegateImplBase$AppCompatWindowCallbackBase(AppCompatDelegateImplBase var1, Callback var2) {
      super(var2);
      this.this$0 = var1;
   }

   public boolean dispatchKeyEvent(KeyEvent var1) {
      return this.this$0.dispatchKeyEvent(var1) || super.dispatchKeyEvent(var1);
   }

   public boolean dispatchKeyShortcutEvent(KeyEvent var1) {
      return super.dispatchKeyShortcutEvent(var1) || this.this$0.onKeyShortcut(var1.getKeyCode(), var1);
   }

   public void onContentChanged() {
   }

   public boolean onCreatePanelMenu(int var1, Menu var2) {
      return var1 == 0 && !(var2 instanceof MenuBuilder)?false:super.onCreatePanelMenu(var1, var2);
   }

   public boolean onMenuOpened(int var1, Menu var2) {
      super.onMenuOpened(var1, var2);
      this.this$0.onMenuOpened(var1, var2);
      return true;
   }

   public void onPanelClosed(int var1, Menu var2) {
      super.onPanelClosed(var1, var2);
      this.this$0.onPanelClosed(var1, var2);
   }

   public boolean onPreparePanel(int var1, View var2, Menu var3) {
      MenuBuilder var6;
      if(var3 instanceof MenuBuilder) {
         var6 = (MenuBuilder)var3;
      } else {
         var6 = null;
      }

      boolean var4;
      if(var1 == 0 && var6 == null) {
         var4 = false;
      } else {
         if(var6 != null) {
            var6.setOverrideVisibleItems(true);
         }

         boolean var5 = super.onPreparePanel(var1, var2, var3);
         var4 = var5;
         if(var6 != null) {
            var6.setOverrideVisibleItems(false);
            return var5;
         }
      }

      return var4;
   }
}
