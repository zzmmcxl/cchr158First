package android.support.v7.view;

import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.util.SimpleArrayMap;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode$Callback;
import android.support.v7.view.SupportActionModeWrapper;
import android.support.v7.view.menu.MenuWrapperFactory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ActionMode.Callback;
import java.util.ArrayList;

public class SupportActionModeWrapper$CallbackWrapper implements ActionMode$Callback {
   final ArrayList<SupportActionModeWrapper> mActionModes;
   final Context mContext;
   final SimpleArrayMap<Menu, Menu> mMenus;
   final Callback mWrappedCallback;

   public SupportActionModeWrapper$CallbackWrapper(Context var1, Callback var2) {
      this.mContext = var1;
      this.mWrappedCallback = var2;
      this.mActionModes = new ArrayList();
      this.mMenus = new SimpleArrayMap();
   }

   private Menu getMenuWrapper(Menu var1) {
      Menu var3 = (Menu)this.mMenus.get(var1);
      Menu var2 = var3;
      if(var3 == null) {
         var2 = MenuWrapperFactory.wrapSupportMenu(this.mContext, (SupportMenu)var1);
         this.mMenus.put(var1, var2);
      }

      return var2;
   }

   public android.view.ActionMode getActionModeWrapper(ActionMode var1) {
      int var2 = 0;

      for(int var3 = this.mActionModes.size(); var2 < var3; ++var2) {
         SupportActionModeWrapper var4 = (SupportActionModeWrapper)this.mActionModes.get(var2);
         if(var4 != null && var4.mWrappedObject == var1) {
            return var4;
         }
      }

      SupportActionModeWrapper var5 = new SupportActionModeWrapper(this.mContext, var1);
      this.mActionModes.add(var5);
      return var5;
   }

   public boolean onActionItemClicked(ActionMode var1, MenuItem var2) {
      return this.mWrappedCallback.onActionItemClicked(this.getActionModeWrapper(var1), MenuWrapperFactory.wrapSupportMenuItem(this.mContext, (SupportMenuItem)var2));
   }

   public boolean onCreateActionMode(ActionMode var1, Menu var2) {
      return this.mWrappedCallback.onCreateActionMode(this.getActionModeWrapper(var1), this.getMenuWrapper(var2));
   }

   public void onDestroyActionMode(ActionMode var1) {
      this.mWrappedCallback.onDestroyActionMode(this.getActionModeWrapper(var1));
   }

   public boolean onPrepareActionMode(ActionMode var1, Menu var2) {
      return this.mWrappedCallback.onPrepareActionMode(this.getActionModeWrapper(var1), this.getMenuWrapper(var2));
   }
}
