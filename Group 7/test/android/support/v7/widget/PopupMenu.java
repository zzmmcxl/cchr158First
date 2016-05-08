package android.support.v7.widget;

import android.content.Context;
import android.support.annotation.MenuRes;
import android.support.v7.appcompat.R$attr;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder$Callback;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.MenuPresenter$Callback;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.PopupMenu$1;
import android.support.v7.widget.PopupMenu$OnDismissListener;
import android.support.v7.widget.PopupMenu$OnMenuItemClickListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnTouchListener;

public class PopupMenu implements MenuBuilder$Callback, MenuPresenter$Callback {
   private View mAnchor;
   private Context mContext;
   private PopupMenu$OnDismissListener mDismissListener;
   private OnTouchListener mDragListener;
   private MenuBuilder mMenu;
   private PopupMenu$OnMenuItemClickListener mMenuItemClickListener;
   private MenuPopupHelper mPopup;

   public PopupMenu(Context var1, View var2) {
      this(var1, var2, 0);
   }

   public PopupMenu(Context var1, View var2, int var3) {
      this(var1, var2, var3, R$attr.popupMenuStyle, 0);
   }

   public PopupMenu(Context var1, View var2, int var3, int var4, int var5) {
      this.mContext = var1;
      this.mMenu = new MenuBuilder(var1);
      this.mMenu.setCallback(this);
      this.mAnchor = var2;
      this.mPopup = new MenuPopupHelper(var1, this.mMenu, var2, false, var4, var5);
      this.mPopup.setGravity(var3);
      this.mPopup.setCallback(this);
   }

   public void dismiss() {
      this.mPopup.dismiss();
   }

   public OnTouchListener getDragToOpenListener() {
      if(this.mDragListener == null) {
         this.mDragListener = new PopupMenu$1(this, this.mAnchor);
      }

      return this.mDragListener;
   }

   public int getGravity() {
      return this.mPopup.getGravity();
   }

   public Menu getMenu() {
      return this.mMenu;
   }

   public MenuInflater getMenuInflater() {
      return new SupportMenuInflater(this.mContext);
   }

   public void inflate(@MenuRes int var1) {
      this.getMenuInflater().inflate(var1, this.mMenu);
   }

   public void onCloseMenu(MenuBuilder var1, boolean var2) {
      if(this.mDismissListener != null) {
         this.mDismissListener.onDismiss(this);
      }

   }

   public void onCloseSubMenu(SubMenuBuilder var1) {
   }

   public boolean onMenuItemSelected(MenuBuilder var1, MenuItem var2) {
      return this.mMenuItemClickListener != null?this.mMenuItemClickListener.onMenuItemClick(var2):false;
   }

   public void onMenuModeChange(MenuBuilder var1) {
   }

   public boolean onOpenSubMenu(MenuBuilder var1) {
      boolean var2 = true;
      if(var1 == null) {
         var2 = false;
      } else if(var1.hasVisibleItems()) {
         (new MenuPopupHelper(this.mContext, var1, this.mAnchor)).show();
         return true;
      }

      return var2;
   }

   public void setGravity(int var1) {
      this.mPopup.setGravity(var1);
   }

   public void setOnDismissListener(PopupMenu$OnDismissListener var1) {
      this.mDismissListener = var1;
   }

   public void setOnMenuItemClickListener(PopupMenu$OnMenuItemClickListener var1) {
      this.mMenuItemClickListener = var1;
   }

   public void show() {
      this.mPopup.show();
   }
}
