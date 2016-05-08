package android.support.v7.view;

import android.content.res.TypedArray;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.R$styleable;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.SupportMenuInflater$InflatedOnMenuItemClickListener;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuItemWrapperICS;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;

class SupportMenuInflater$MenuState {
   private static final int defaultGroupId = 0;
   private static final int defaultItemCategory = 0;
   private static final int defaultItemCheckable = 0;
   private static final boolean defaultItemChecked = false;
   private static final boolean defaultItemEnabled = false;
   private static final int defaultItemId = 0;
   private static final int defaultItemOrder = 0;
   private static final boolean defaultItemVisible = false;
   private int groupCategory;
   private int groupCheckable;
   private boolean groupEnabled;
   private int groupId;
   private int groupOrder;
   private boolean groupVisible;
   private ActionProvider itemActionProvider;
   private String itemActionProviderClassName;
   private String itemActionViewClassName;
   private int itemActionViewLayout;
   private boolean itemAdded;
   private char itemAlphabeticShortcut;
   private int itemCategoryOrder;
   private int itemCheckable;
   private boolean itemChecked;
   private boolean itemEnabled;
   private int itemIconResId;
   private int itemId;
   private String itemListenerMethodName;
   private char itemNumericShortcut;
   private int itemShowAsAction;
   private CharSequence itemTitle;
   private CharSequence itemTitleCondensed;
   private boolean itemVisible;
   private Menu menu;

   public SupportMenuInflater$MenuState(SupportMenuInflater var1, Menu var2) {
      this.this$0 = var1;
      this.menu = var2;
      this.resetGroup();
   }

   private char getShortcut(String var1) {
      return var1 == null?'\u0000':var1.charAt(0);
   }

   private <T> T newInstance(String var1, Class<?>[] var2, Object[] var3) {
      try {
         Constructor var5 = SupportMenuInflater.access$100(this.this$0).getClassLoader().loadClass(var1).getConstructor(var2);
         var5.setAccessible(true);
         Object var6 = var5.newInstance(var3);
         return var6;
      } catch (Exception var4) {
         Log.w("SupportMenuInflater", "Cannot instantiate class: " + var1, var4);
         return null;
      }
   }

   private void setItem(MenuItem var1) {
      MenuItem var4 = var1.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled);
      boolean var3;
      if(this.itemCheckable >= 1) {
         var3 = true;
      } else {
         var3 = false;
      }

      var4.setCheckable(var3).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId).setAlphabeticShortcut(this.itemAlphabeticShortcut).setNumericShortcut(this.itemNumericShortcut);
      if(this.itemShowAsAction >= 0) {
         MenuItemCompat.setShowAsAction(var1, this.itemShowAsAction);
      }

      if(this.itemListenerMethodName != null) {
         if(SupportMenuInflater.access$100(this.this$0).isRestricted()) {
            throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
         }

         var1.setOnMenuItemClickListener(new SupportMenuInflater$InflatedOnMenuItemClickListener(SupportMenuInflater.access$400(this.this$0), this.itemListenerMethodName));
      }

      if(var1 instanceof MenuItemImpl) {
         MenuItemImpl var5 = (MenuItemImpl)var1;
      }

      if(this.itemCheckable >= 2) {
         if(var1 instanceof MenuItemImpl) {
            ((MenuItemImpl)var1).setExclusiveCheckable(true);
         } else if(var1 instanceof MenuItemWrapperICS) {
            ((MenuItemWrapperICS)var1).setExclusiveCheckable(true);
         }
      }

      boolean var2 = false;
      if(this.itemActionViewClassName != null) {
         MenuItemCompat.setActionView(var1, (View)this.newInstance(this.itemActionViewClassName, SupportMenuInflater.access$500(), SupportMenuInflater.access$600(this.this$0)));
         var2 = true;
      }

      if(this.itemActionViewLayout > 0) {
         if(!var2) {
            MenuItemCompat.setActionView(var1, this.itemActionViewLayout);
         } else {
            Log.w("SupportMenuInflater", "Ignoring attribute \'itemActionViewLayout\'. Action view already specified.");
         }
      }

      if(this.itemActionProvider != null) {
         MenuItemCompat.setActionProvider(var1, this.itemActionProvider);
      }

   }

   public void addItem() {
      this.itemAdded = true;
      this.setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
   }

   public SubMenu addSubMenuItem() {
      this.itemAdded = true;
      SubMenu var1 = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
      this.setItem(var1.getItem());
      return var1;
   }

   public boolean hasAddedItem() {
      return this.itemAdded;
   }

   public void readGroup(AttributeSet var1) {
      TypedArray var2 = SupportMenuInflater.access$100(this.this$0).obtainStyledAttributes(var1, R$styleable.MenuGroup);
      this.groupId = var2.getResourceId(R$styleable.MenuGroup_android_id, 0);
      this.groupCategory = var2.getInt(R$styleable.MenuGroup_android_menuCategory, 0);
      this.groupOrder = var2.getInt(R$styleable.MenuGroup_android_orderInCategory, 0);
      this.groupCheckable = var2.getInt(R$styleable.MenuGroup_android_checkableBehavior, 0);
      this.groupVisible = var2.getBoolean(R$styleable.MenuGroup_android_visible, true);
      this.groupEnabled = var2.getBoolean(R$styleable.MenuGroup_android_enabled, true);
      var2.recycle();
   }

   public void readItem(AttributeSet var1) {
      TypedArray var3 = SupportMenuInflater.access$100(this.this$0).obtainStyledAttributes(var1, R$styleable.MenuItem);
      this.itemId = var3.getResourceId(R$styleable.MenuItem_android_id, 0);
      this.itemCategoryOrder = -65536 & var3.getInt(R$styleable.MenuItem_android_menuCategory, this.groupCategory) | '\uffff' & var3.getInt(R$styleable.MenuItem_android_orderInCategory, this.groupOrder);
      this.itemTitle = var3.getText(R$styleable.MenuItem_android_title);
      this.itemTitleCondensed = var3.getText(R$styleable.MenuItem_android_titleCondensed);
      this.itemIconResId = var3.getResourceId(R$styleable.MenuItem_android_icon, 0);
      this.itemAlphabeticShortcut = this.getShortcut(var3.getString(R$styleable.MenuItem_android_alphabeticShortcut));
      this.itemNumericShortcut = this.getShortcut(var3.getString(R$styleable.MenuItem_android_numericShortcut));
      if(var3.hasValue(R$styleable.MenuItem_android_checkable)) {
         byte var2;
         if(var3.getBoolean(R$styleable.MenuItem_android_checkable, false)) {
            var2 = 1;
         } else {
            var2 = 0;
         }

         this.itemCheckable = var2;
      } else {
         this.itemCheckable = this.groupCheckable;
      }

      this.itemChecked = var3.getBoolean(R$styleable.MenuItem_android_checked, false);
      this.itemVisible = var3.getBoolean(R$styleable.MenuItem_android_visible, this.groupVisible);
      this.itemEnabled = var3.getBoolean(R$styleable.MenuItem_android_enabled, this.groupEnabled);
      this.itemShowAsAction = var3.getInt(R$styleable.MenuItem_showAsAction, -1);
      this.itemListenerMethodName = var3.getString(R$styleable.MenuItem_android_onClick);
      this.itemActionViewLayout = var3.getResourceId(R$styleable.MenuItem_actionLayout, 0);
      this.itemActionViewClassName = var3.getString(R$styleable.MenuItem_actionViewClass);
      this.itemActionProviderClassName = var3.getString(R$styleable.MenuItem_actionProviderClass);
      boolean var4;
      if(this.itemActionProviderClassName != null) {
         var4 = true;
      } else {
         var4 = false;
      }

      if(var4 && this.itemActionViewLayout == 0 && this.itemActionViewClassName == null) {
         this.itemActionProvider = (ActionProvider)this.newInstance(this.itemActionProviderClassName, SupportMenuInflater.access$200(), SupportMenuInflater.access$300(this.this$0));
      } else {
         if(var4) {
            Log.w("SupportMenuInflater", "Ignoring attribute \'actionProviderClass\'. Action view already specified.");
         }

         this.itemActionProvider = null;
      }

      var3.recycle();
      this.itemAdded = false;
   }

   public void resetGroup() {
      this.groupId = 0;
      this.groupCategory = 0;
      this.groupOrder = 0;
      this.groupCheckable = 0;
      this.groupVisible = true;
      this.groupEnabled = true;
   }
}
