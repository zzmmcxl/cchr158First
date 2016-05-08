package android.support.v7.app;

import android.content.Context;
import android.support.v7.app.WindowDecorActionBar;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode$Callback;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder$Callback;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.SubMenuBuilder;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public class WindowDecorActionBar$ActionModeImpl extends ActionMode implements MenuBuilder$Callback {
   private final Context mActionModeContext;
   private ActionMode$Callback mCallback;
   private WeakReference<View> mCustomView;
   private final MenuBuilder mMenu;

   public WindowDecorActionBar$ActionModeImpl(WindowDecorActionBar var1, Context var2, ActionMode$Callback var3) {
      this.this$0 = var1;
      this.mActionModeContext = var2;
      this.mCallback = var3;
      this.mMenu = (new MenuBuilder(var2)).setDefaultShowAsAction(1);
      this.mMenu.setCallback(this);
   }

   public boolean dispatchOnCreate() {
      this.mMenu.stopDispatchingItemsChanged();
      boolean var4 = false;

      boolean var1;
      try {
         var4 = true;
         var1 = this.mCallback.onCreateActionMode(this, this.mMenu);
         var4 = false;
      } finally {
         if(var4) {
            this.mMenu.startDispatchingItemsChanged();
         }
      }

      this.mMenu.startDispatchingItemsChanged();
      return var1;
   }

   public void finish() {
      if(this.this$0.mActionMode == this) {
         if(!WindowDecorActionBar.access$700(WindowDecorActionBar.access$500(this.this$0), WindowDecorActionBar.access$600(this.this$0), false)) {
            this.this$0.mDeferredDestroyActionMode = this;
            this.this$0.mDeferredModeDestroyCallback = this.mCallback;
         } else {
            this.mCallback.onDestroyActionMode(this);
         }

         this.mCallback = null;
         this.this$0.animateToMode(false);
         WindowDecorActionBar.access$800(this.this$0).closeMode();
         WindowDecorActionBar.access$900(this.this$0).getViewGroup().sendAccessibilityEvent(32);
         WindowDecorActionBar.access$400(this.this$0).setHideOnContentScrollEnabled(this.this$0.mHideOnContentScroll);
         this.this$0.mActionMode = null;
      }
   }

   public View getCustomView() {
      return this.mCustomView != null?(View)this.mCustomView.get():null;
   }

   public Menu getMenu() {
      return this.mMenu;
   }

   public MenuInflater getMenuInflater() {
      return new SupportMenuInflater(this.mActionModeContext);
   }

   public CharSequence getSubtitle() {
      return WindowDecorActionBar.access$800(this.this$0).getSubtitle();
   }

   public CharSequence getTitle() {
      return WindowDecorActionBar.access$800(this.this$0).getTitle();
   }

   public void invalidate() {
      if(this.this$0.mActionMode == this) {
         this.mMenu.stopDispatchingItemsChanged();
         boolean var3 = false;

         try {
            var3 = true;
            this.mCallback.onPrepareActionMode(this, this.mMenu);
            var3 = false;
         } finally {
            if(var3) {
               this.mMenu.startDispatchingItemsChanged();
            }
         }

         this.mMenu.startDispatchingItemsChanged();
      }
   }

   public boolean isTitleOptional() {
      return WindowDecorActionBar.access$800(this.this$0).isTitleOptional();
   }

   public void onCloseMenu(MenuBuilder var1, boolean var2) {
   }

   public void onCloseSubMenu(SubMenuBuilder var1) {
   }

   public boolean onMenuItemSelected(MenuBuilder var1, MenuItem var2) {
      return this.mCallback != null?this.mCallback.onActionItemClicked(this, var2):false;
   }

   public void onMenuModeChange(MenuBuilder var1) {
      if(this.mCallback != null) {
         this.invalidate();
         WindowDecorActionBar.access$800(this.this$0).showOverflowMenu();
      }
   }

   public boolean onSubMenuSelected(SubMenuBuilder var1) {
      boolean var2 = true;
      if(this.mCallback == null) {
         var2 = false;
      } else if(var1.hasVisibleItems()) {
         (new MenuPopupHelper(this.this$0.getThemedContext(), var1)).show();
         return true;
      }

      return var2;
   }

   public void setCustomView(View var1) {
      WindowDecorActionBar.access$800(this.this$0).setCustomView(var1);
      this.mCustomView = new WeakReference(var1);
   }

   public void setSubtitle(int var1) {
      this.setSubtitle(WindowDecorActionBar.access$1000(this.this$0).getResources().getString(var1));
   }

   public void setSubtitle(CharSequence var1) {
      WindowDecorActionBar.access$800(this.this$0).setSubtitle(var1);
   }

   public void setTitle(int var1) {
      this.setTitle(WindowDecorActionBar.access$1000(this.this$0).getResources().getString(var1));
   }

   public void setTitle(CharSequence var1) {
      WindowDecorActionBar.access$800(this.this$0).setTitle(var1);
   }

   public void setTitleOptionalHint(boolean var1) {
      super.setTitleOptionalHint(var1);
      WindowDecorActionBar.access$800(this.this$0).setTitleOptional(var1);
   }
}
