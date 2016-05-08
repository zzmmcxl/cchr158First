package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat$OnActionExpandListener;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl$1;
import android.support.v7.view.menu.MenuView$ItemView;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.AppCompatDrawableManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

public final class MenuItemImpl implements SupportMenuItem {
   private static final int CHECKABLE = 1;
   private static final int CHECKED = 2;
   private static final int ENABLED = 16;
   private static final int EXCLUSIVE = 4;
   private static final int HIDDEN = 8;
   private static final int IS_ACTION = 32;
   static final int NO_ICON = 0;
   private static final int SHOW_AS_ACTION_MASK = 3;
   private static final String TAG = "MenuItemImpl";
   private static String sDeleteShortcutLabel;
   private static String sEnterShortcutLabel;
   private static String sPrependShortcutLabel;
   private static String sSpaceShortcutLabel;
   private ActionProvider mActionProvider;
   private View mActionView;
   private final int mCategoryOrder;
   private OnMenuItemClickListener mClickListener;
   private int mFlags = 16;
   private final int mGroup;
   private Drawable mIconDrawable;
   private int mIconResId = 0;
   private final int mId;
   private Intent mIntent;
   private boolean mIsActionViewExpanded = false;
   private Runnable mItemCallback;
   private MenuBuilder mMenu;
   private ContextMenuInfo mMenuInfo;
   private MenuItemCompat$OnActionExpandListener mOnActionExpandListener;
   private final int mOrdering;
   private char mShortcutAlphabeticChar;
   private char mShortcutNumericChar;
   private int mShowAsAction = 0;
   private SubMenuBuilder mSubMenu;
   private CharSequence mTitle;
   private CharSequence mTitleCondensed;

   MenuItemImpl(MenuBuilder var1, int var2, int var3, int var4, int var5, CharSequence var6, int var7) {
      this.mMenu = var1;
      this.mId = var3;
      this.mGroup = var2;
      this.mCategoryOrder = var4;
      this.mOrdering = var5;
      this.mTitle = var6;
      this.mShowAsAction = var7;
   }

   public void actionFormatChanged() {
      this.mMenu.onItemActionRequestChanged(this);
   }

   public boolean collapseActionView() {
      if((this.mShowAsAction & 8) != 0) {
         if(this.mActionView == null) {
            return true;
         }

         if(this.mOnActionExpandListener == null || this.mOnActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.mMenu.collapseItemActionView(this);
         }
      }

      return false;
   }

   public boolean expandActionView() {
      return this.hasCollapsibleActionView() && (this.mOnActionExpandListener == null || this.mOnActionExpandListener.onMenuItemActionExpand(this))?this.mMenu.expandItemActionView(this):false;
   }

   public android.view.ActionProvider getActionProvider() {
      throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
   }

   public View getActionView() {
      if(this.mActionView != null) {
         return this.mActionView;
      } else if(this.mActionProvider != null) {
         this.mActionView = this.mActionProvider.onCreateActionView(this);
         return this.mActionView;
      } else {
         return null;
      }
   }

   public char getAlphabeticShortcut() {
      return this.mShortcutAlphabeticChar;
   }

   Runnable getCallback() {
      return this.mItemCallback;
   }

   public int getGroupId() {
      return this.mGroup;
   }

   public Drawable getIcon() {
      if(this.mIconDrawable != null) {
         return this.mIconDrawable;
      } else if(this.mIconResId != 0) {
         Drawable var1 = AppCompatDrawableManager.get().getDrawable(this.mMenu.getContext(), this.mIconResId);
         this.mIconResId = 0;
         this.mIconDrawable = var1;
         return var1;
      } else {
         return null;
      }
   }

   public Intent getIntent() {
      return this.mIntent;
   }

   @CapturedViewProperty
   public int getItemId() {
      return this.mId;
   }

   public ContextMenuInfo getMenuInfo() {
      return this.mMenuInfo;
   }

   public char getNumericShortcut() {
      return this.mShortcutNumericChar;
   }

   public int getOrder() {
      return this.mCategoryOrder;
   }

   public int getOrdering() {
      return this.mOrdering;
   }

   char getShortcut() {
      return this.mMenu.isQwertyMode()?this.mShortcutAlphabeticChar:this.mShortcutNumericChar;
   }

   String getShortcutLabel() {
      char var1 = this.getShortcut();
      if(var1 == 0) {
         return "";
      } else {
         StringBuilder var2 = new StringBuilder(sPrependShortcutLabel);
         switch(var1) {
         case '\b':
            var2.append(sDeleteShortcutLabel);
            break;
         case '\n':
            var2.append(sEnterShortcutLabel);
            break;
         case ' ':
            var2.append(sSpaceShortcutLabel);
            break;
         default:
            var2.append(var1);
         }

         return var2.toString();
      }
   }

   public SubMenu getSubMenu() {
      return this.mSubMenu;
   }

   public ActionProvider getSupportActionProvider() {
      return this.mActionProvider;
   }

   @CapturedViewProperty
   public CharSequence getTitle() {
      return this.mTitle;
   }

   public CharSequence getTitleCondensed() {
      CharSequence var1;
      if(this.mTitleCondensed != null) {
         var1 = this.mTitleCondensed;
      } else {
         var1 = this.mTitle;
      }

      Object var2 = var1;
      if(VERSION.SDK_INT < 18) {
         var2 = var1;
         if(var1 != null) {
            var2 = var1;
            if(!(var1 instanceof String)) {
               var2 = var1.toString();
            }
         }
      }

      return (CharSequence)var2;
   }

   CharSequence getTitleForItemView(MenuView$ItemView var1) {
      return var1 != null && var1.prefersCondensedTitle()?this.getTitleCondensed():this.getTitle();
   }

   public boolean hasCollapsibleActionView() {
      boolean var2 = false;
      boolean var1 = var2;
      if((this.mShowAsAction & 8) != 0) {
         if(this.mActionView == null && this.mActionProvider != null) {
            this.mActionView = this.mActionProvider.onCreateActionView(this);
         }

         var1 = var2;
         if(this.mActionView != null) {
            var1 = true;
         }
      }

      return var1;
   }

   public boolean hasSubMenu() {
      return this.mSubMenu != null;
   }

   public boolean invoke() {
      if((this.mClickListener == null || !this.mClickListener.onMenuItemClick(this)) && !this.mMenu.dispatchMenuItemSelected(this.mMenu.getRootMenu(), this)) {
         if(this.mItemCallback != null) {
            this.mItemCallback.run();
            return true;
         }

         if(this.mIntent != null) {
            try {
               this.mMenu.getContext().startActivity(this.mIntent);
               return true;
            } catch (ActivityNotFoundException var2) {
               Log.e("MenuItemImpl", "Can\'t find activity to handle intent; ignoring", var2);
            }
         }

         if(this.mActionProvider == null || !this.mActionProvider.onPerformDefaultAction()) {
            return false;
         }
      }

      return true;
   }

   public boolean isActionButton() {
      return (this.mFlags & 32) == 32;
   }

   public boolean isActionViewExpanded() {
      return this.mIsActionViewExpanded;
   }

   public boolean isCheckable() {
      return (this.mFlags & 1) == 1;
   }

   public boolean isChecked() {
      return (this.mFlags & 2) == 2;
   }

   public boolean isEnabled() {
      return (this.mFlags & 16) != 0;
   }

   public boolean isExclusiveCheckable() {
      return (this.mFlags & 4) != 0;
   }

   public boolean isVisible() {
      if(this.mActionProvider != null && this.mActionProvider.overridesItemVisibility()) {
         if((this.mFlags & 8) != 0 || !this.mActionProvider.isVisible()) {
            return false;
         }
      } else if((this.mFlags & 8) != 0) {
         return false;
      }

      return true;
   }

   public boolean requestsActionButton() {
      return (this.mShowAsAction & 1) == 1;
   }

   public boolean requiresActionButton() {
      return (this.mShowAsAction & 2) == 2;
   }

   public MenuItem setActionProvider(android.view.ActionProvider var1) {
      throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
   }

   public SupportMenuItem setActionView(int var1) {
      Context var2 = this.mMenu.getContext();
      this.setActionView(LayoutInflater.from(var2).inflate(var1, new LinearLayout(var2), false));
      return this;
   }

   public SupportMenuItem setActionView(View var1) {
      this.mActionView = var1;
      this.mActionProvider = null;
      if(var1 != null && var1.getId() == -1 && this.mId > 0) {
         var1.setId(this.mId);
      }

      this.mMenu.onItemActionRequestChanged(this);
      return this;
   }

   public void setActionViewExpanded(boolean var1) {
      this.mIsActionViewExpanded = var1;
      this.mMenu.onItemsChanged(false);
   }

   public MenuItem setAlphabeticShortcut(char var1) {
      if(this.mShortcutAlphabeticChar == var1) {
         return this;
      } else {
         this.mShortcutAlphabeticChar = Character.toLowerCase(var1);
         this.mMenu.onItemsChanged(false);
         return this;
      }
   }

   public MenuItem setCallback(Runnable var1) {
      this.mItemCallback = var1;
      return this;
   }

   public MenuItem setCheckable(boolean var1) {
      int var3 = this.mFlags;
      int var4 = this.mFlags;
      byte var2;
      if(var1) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      this.mFlags = var2 | var4 & -2;
      if(var3 != this.mFlags) {
         this.mMenu.onItemsChanged(false);
      }

      return this;
   }

   public MenuItem setChecked(boolean var1) {
      if((this.mFlags & 4) != 0) {
         this.mMenu.setExclusiveItemChecked(this);
         return this;
      } else {
         this.setCheckedInt(var1);
         return this;
      }
   }

   void setCheckedInt(boolean var1) {
      int var3 = this.mFlags;
      int var4 = this.mFlags;
      byte var2;
      if(var1) {
         var2 = 2;
      } else {
         var2 = 0;
      }

      this.mFlags = var2 | var4 & -3;
      if(var3 != this.mFlags) {
         this.mMenu.onItemsChanged(false);
      }

   }

   public MenuItem setEnabled(boolean var1) {
      if(var1) {
         this.mFlags |= 16;
      } else {
         this.mFlags &= -17;
      }

      this.mMenu.onItemsChanged(false);
      return this;
   }

   public void setExclusiveCheckable(boolean var1) {
      int var3 = this.mFlags;
      byte var2;
      if(var1) {
         var2 = 4;
      } else {
         var2 = 0;
      }

      this.mFlags = var2 | var3 & -5;
   }

   public MenuItem setIcon(int var1) {
      this.mIconDrawable = null;
      this.mIconResId = var1;
      this.mMenu.onItemsChanged(false);
      return this;
   }

   public MenuItem setIcon(Drawable var1) {
      this.mIconResId = 0;
      this.mIconDrawable = var1;
      this.mMenu.onItemsChanged(false);
      return this;
   }

   public MenuItem setIntent(Intent var1) {
      this.mIntent = var1;
      return this;
   }

   public void setIsActionButton(boolean var1) {
      if(var1) {
         this.mFlags |= 32;
      } else {
         this.mFlags &= -33;
      }
   }

   void setMenuInfo(ContextMenuInfo var1) {
      this.mMenuInfo = var1;
   }

   public MenuItem setNumericShortcut(char var1) {
      if(this.mShortcutNumericChar == var1) {
         return this;
      } else {
         this.mShortcutNumericChar = var1;
         this.mMenu.onItemsChanged(false);
         return this;
      }
   }

   public MenuItem setOnActionExpandListener(OnActionExpandListener var1) {
      throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
   }

   public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener var1) {
      this.mClickListener = var1;
      return this;
   }

   public MenuItem setShortcut(char var1, char var2) {
      this.mShortcutNumericChar = var1;
      this.mShortcutAlphabeticChar = Character.toLowerCase(var2);
      this.mMenu.onItemsChanged(false);
      return this;
   }

   public void setShowAsAction(int var1) {
      switch(var1 & 3) {
      case 0:
      case 1:
      case 2:
         this.mShowAsAction = var1;
         this.mMenu.onItemActionRequestChanged(this);
         return;
      default:
         throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
      }
   }

   public SupportMenuItem setShowAsActionFlags(int var1) {
      this.setShowAsAction(var1);
      return this;
   }

   public void setSubMenu(SubMenuBuilder var1) {
      this.mSubMenu = var1;
      var1.setHeaderTitle(this.getTitle());
   }

   public SupportMenuItem setSupportActionProvider(ActionProvider var1) {
      if(this.mActionProvider != null) {
         this.mActionProvider.reset();
      }

      this.mActionView = null;
      this.mActionProvider = var1;
      this.mMenu.onItemsChanged(true);
      if(this.mActionProvider != null) {
         this.mActionProvider.setVisibilityListener(new MenuItemImpl$1(this));
      }

      return this;
   }

   public SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat$OnActionExpandListener var1) {
      this.mOnActionExpandListener = var1;
      return this;
   }

   public MenuItem setTitle(int var1) {
      return this.setTitle(this.mMenu.getContext().getString(var1));
   }

   public MenuItem setTitle(CharSequence var1) {
      this.mTitle = var1;
      this.mMenu.onItemsChanged(false);
      if(this.mSubMenu != null) {
         this.mSubMenu.setHeaderTitle(var1);
      }

      return this;
   }

   public MenuItem setTitleCondensed(CharSequence var1) {
      this.mTitleCondensed = var1;
      if(var1 == null) {
         var1 = this.mTitle;
      }

      this.mMenu.onItemsChanged(false);
      return this;
   }

   public MenuItem setVisible(boolean var1) {
      if(this.setVisibleInt(var1)) {
         this.mMenu.onItemVisibleChanged(this);
      }

      return this;
   }

   boolean setVisibleInt(boolean var1) {
      boolean var5 = false;
      int var3 = this.mFlags;
      int var4 = this.mFlags;
      byte var2;
      if(var1) {
         var2 = 0;
      } else {
         var2 = 8;
      }

      this.mFlags = var2 | var4 & -9;
      var1 = var5;
      if(var3 != this.mFlags) {
         var1 = true;
      }

      return var1;
   }

   public boolean shouldShowIcon() {
      return this.mMenu.getOptionalIconsVisible();
   }

   boolean shouldShowShortcut() {
      return this.mMenu.isShortcutsVisible() && this.getShortcut() != 0;
   }

   public boolean showsTextAsAction() {
      return (this.mShowAsAction & 4) == 4;
   }

   public String toString() {
      return this.mTitle != null?this.mTitle.toString():null;
   }
}
