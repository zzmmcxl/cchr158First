package android.support.v7.widget;

import android.content.Context;
import android.os.Parcelable;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuPresenter$Callback;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar$LayoutParams;
import android.view.ViewGroup;

class Toolbar$ExpandedActionViewMenuPresenter implements MenuPresenter {
   MenuItemImpl mCurrentExpandedItem;
   MenuBuilder mMenu;

   private Toolbar$ExpandedActionViewMenuPresenter(Toolbar var1) {
      this.this$0 = var1;
   }

   public boolean collapseItemActionView(MenuBuilder var1, MenuItemImpl var2) {
      if(this.this$0.mExpandedActionView instanceof CollapsibleActionView) {
         ((CollapsibleActionView)this.this$0.mExpandedActionView).onActionViewCollapsed();
      }

      this.this$0.removeView(this.this$0.mExpandedActionView);
      this.this$0.removeView(Toolbar.access$300(this.this$0));
      this.this$0.mExpandedActionView = null;
      this.this$0.addChildrenForExpandedActionView();
      this.mCurrentExpandedItem = null;
      this.this$0.requestLayout();
      var2.setActionViewExpanded(false);
      return true;
   }

   public boolean expandItemActionView(MenuBuilder var1, MenuItemImpl var2) {
      Toolbar.access$200(this.this$0);
      if(Toolbar.access$300(this.this$0).getParent() != this.this$0) {
         this.this$0.addView(Toolbar.access$300(this.this$0));
      }

      this.this$0.mExpandedActionView = var2.getActionView();
      this.mCurrentExpandedItem = var2;
      if(this.this$0.mExpandedActionView.getParent() != this.this$0) {
         Toolbar$LayoutParams var3 = this.this$0.generateDefaultLayoutParams();
         var3.gravity = 8388611 | Toolbar.access$400(this.this$0) & 112;
         var3.mViewType = 2;
         this.this$0.mExpandedActionView.setLayoutParams(var3);
         this.this$0.addView(this.this$0.mExpandedActionView);
      }

      this.this$0.removeChildrenForExpandedActionView();
      this.this$0.requestLayout();
      var2.setActionViewExpanded(true);
      if(this.this$0.mExpandedActionView instanceof CollapsibleActionView) {
         ((CollapsibleActionView)this.this$0.mExpandedActionView).onActionViewExpanded();
      }

      return true;
   }

   public boolean flagActionItems() {
      return false;
   }

   public int getId() {
      return 0;
   }

   public MenuView getMenuView(ViewGroup var1) {
      return null;
   }

   public void initForMenu(Context var1, MenuBuilder var2) {
      if(this.mMenu != null && this.mCurrentExpandedItem != null) {
         this.mMenu.collapseItemActionView(this.mCurrentExpandedItem);
      }

      this.mMenu = var2;
   }

   public void onCloseMenu(MenuBuilder var1, boolean var2) {
   }

   public void onRestoreInstanceState(Parcelable var1) {
   }

   public Parcelable onSaveInstanceState() {
      return null;
   }

   public boolean onSubMenuSelected(SubMenuBuilder var1) {
      return false;
   }

   public void setCallback(MenuPresenter$Callback var1) {
   }

   public void updateMenuView(boolean var1) {
      if(this.mCurrentExpandedItem != null) {
         boolean var4 = false;
         boolean var3 = var4;
         if(this.mMenu != null) {
            int var5 = this.mMenu.size();
            int var2 = 0;

            while(true) {
               var3 = var4;
               if(var2 >= var5) {
                  break;
               }

               if(this.mMenu.getItem(var2) == this.mCurrentExpandedItem) {
                  var3 = true;
                  break;
               }

               ++var2;
            }
         }

         if(!var3) {
            this.collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
         }
      }

   }
}
