package android.support.v7.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatDelegateImplV7$1;
import android.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState$SavedState;
import android.support.v7.appcompat.R$attr;
import android.support.v7.appcompat.R$layout;
import android.support.v7.appcompat.R$style;
import android.support.v7.appcompat.R$styleable;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.view.menu.ListMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter$Callback;
import android.support.v7.view.menu.MenuView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

final class AppCompatDelegateImplV7$PanelFeatureState {
   int background;
   View createdPanelView;
   ViewGroup decorView;
   int featureId;
   Bundle frozenActionViewState;
   Bundle frozenMenuState;
   int gravity;
   boolean isHandled;
   boolean isOpen;
   boolean isPrepared;
   ListMenuPresenter listMenuPresenter;
   Context listPresenterContext;
   MenuBuilder menu;
   public boolean qwertyMode;
   boolean refreshDecorView;
   boolean refreshMenuContent;
   View shownPanelView;
   boolean wasLastOpen;
   int windowAnimations;
   int x;
   int y;

   AppCompatDelegateImplV7$PanelFeatureState(int var1) {
      this.featureId = var1;
      this.refreshDecorView = false;
   }

   void applyFrozenState() {
      if(this.menu != null && this.frozenMenuState != null) {
         this.menu.restorePresenterStates(this.frozenMenuState);
         this.frozenMenuState = null;
      }

   }

   public void clearMenuPresenters() {
      if(this.menu != null) {
         this.menu.removeMenuPresenter(this.listMenuPresenter);
      }

      this.listMenuPresenter = null;
   }

   MenuView getListMenuView(MenuPresenter$Callback var1) {
      if(this.menu == null) {
         return null;
      } else {
         if(this.listMenuPresenter == null) {
            this.listMenuPresenter = new ListMenuPresenter(this.listPresenterContext, R$layout.abc_list_menu_item_layout);
            this.listMenuPresenter.setCallback(var1);
            this.menu.addMenuPresenter(this.listMenuPresenter);
         }

         return this.listMenuPresenter.getMenuView(this.decorView);
      }
   }

   public boolean hasPanelItems() {
      boolean var2 = true;
      boolean var1;
      if(this.shownPanelView == null) {
         var1 = false;
      } else {
         var1 = var2;
         if(this.createdPanelView == null) {
            var1 = var2;
            if(this.listMenuPresenter.getAdapter().getCount() <= 0) {
               return false;
            }
         }
      }

      return var1;
   }

   void onRestoreInstanceState(Parcelable var1) {
      AppCompatDelegateImplV7$PanelFeatureState$SavedState var2 = (AppCompatDelegateImplV7$PanelFeatureState$SavedState)var1;
      this.featureId = var2.featureId;
      this.wasLastOpen = var2.isOpen;
      this.frozenMenuState = var2.menuState;
      this.shownPanelView = null;
      this.decorView = null;
   }

   Parcelable onSaveInstanceState() {
      AppCompatDelegateImplV7$PanelFeatureState$SavedState var1 = new AppCompatDelegateImplV7$PanelFeatureState$SavedState((AppCompatDelegateImplV7$1)null);
      var1.featureId = this.featureId;
      var1.isOpen = this.isOpen;
      if(this.menu != null) {
         var1.menuState = new Bundle();
         this.menu.savePresenterStates(var1.menuState);
      }

      return var1;
   }

   void setMenu(MenuBuilder var1) {
      if(var1 != this.menu) {
         if(this.menu != null) {
            this.menu.removeMenuPresenter(this.listMenuPresenter);
         }

         this.menu = var1;
         if(var1 != null && this.listMenuPresenter != null) {
            var1.addMenuPresenter(this.listMenuPresenter);
            return;
         }
      }

   }

   void setStyle(Context var1) {
      TypedValue var3 = new TypedValue();
      Theme var2 = var1.getResources().newTheme();
      var2.setTo(var1.getTheme());
      var2.resolveAttribute(R$attr.actionBarPopupTheme, var3, true);
      if(var3.resourceId != 0) {
         var2.applyStyle(var3.resourceId, true);
      }

      var2.resolveAttribute(R$attr.panelMenuListTheme, var3, true);
      if(var3.resourceId != 0) {
         var2.applyStyle(var3.resourceId, true);
      } else {
         var2.applyStyle(R$style.Theme_AppCompat_CompactMenu, true);
      }

      ContextThemeWrapper var4 = new ContextThemeWrapper(var1, 0);
      var4.getTheme().setTo(var2);
      this.listPresenterContext = var4;
      TypedArray var5 = var4.obtainStyledAttributes(R$styleable.AppCompatTheme);
      this.background = var5.getResourceId(R$styleable.AppCompatTheme_panelBackground, 0);
      this.windowAnimations = var5.getResourceId(R$styleable.AppCompatTheme_android_windowAnimationStyle, 0);
      var5.recycle();
   }
}
