package android.support.design.internal;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.internal.NavigationMenuItemView;
import android.support.design.internal.NavigationMenuPresenter;
import android.support.design.internal.NavigationMenuPresenter$1;
import android.support.design.internal.NavigationMenuPresenter$HeaderViewHolder;
import android.support.design.internal.NavigationMenuPresenter$NavigationMenuHeaderItem;
import android.support.design.internal.NavigationMenuPresenter$NavigationMenuItem;
import android.support.design.internal.NavigationMenuPresenter$NavigationMenuSeparatorItem;
import android.support.design.internal.NavigationMenuPresenter$NavigationMenuTextItem;
import android.support.design.internal.NavigationMenuPresenter$NormalViewHolder;
import android.support.design.internal.NavigationMenuPresenter$SeparatorViewHolder;
import android.support.design.internal.NavigationMenuPresenter$SubheaderViewHolder;
import android.support.design.internal.NavigationMenuPresenter$ViewHolder;
import android.support.design.internal.ParcelableSparseArray;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.widget.RecyclerView$Adapter;
import android.util.SparseArray;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

class NavigationMenuPresenter$NavigationMenuAdapter extends RecyclerView$Adapter<NavigationMenuPresenter$ViewHolder> {
   private static final String STATE_ACTION_VIEWS = "android:menu:action_views";
   private static final String STATE_CHECKED_ITEM = "android:menu:checked";
   private static final int VIEW_TYPE_HEADER = 3;
   private static final int VIEW_TYPE_NORMAL = 0;
   private static final int VIEW_TYPE_SEPARATOR = 2;
   private static final int VIEW_TYPE_SUBHEADER = 1;
   private MenuItemImpl mCheckedItem;
   private final ArrayList<NavigationMenuPresenter$NavigationMenuItem> mItems;
   private ColorDrawable mTransparentIcon;
   private boolean mUpdateSuspended;

   NavigationMenuPresenter$NavigationMenuAdapter(NavigationMenuPresenter var1) {
      this.this$0 = var1;
      this.mItems = new ArrayList();
      this.prepareMenuItems();
   }

   private void appendTransparentIconIfMissing(int var1, int var2) {
      for(; var1 < var2; ++var1) {
         MenuItemImpl var3 = ((NavigationMenuPresenter$NavigationMenuTextItem)this.mItems.get(var1)).getMenuItem();
         if(var3.getIcon() == null) {
            if(this.mTransparentIcon == null) {
               this.mTransparentIcon = new ColorDrawable(0);
            }

            var3.setIcon(this.mTransparentIcon);
         }
      }

   }

   private void prepareMenuItems() {
      if(!this.mUpdateSuspended) {
         this.mUpdateSuspended = true;
         this.mItems.clear();
         this.mItems.add(new NavigationMenuPresenter$NavigationMenuHeaderItem((NavigationMenuPresenter$1)null));
         int var6 = -1;
         int var3 = 0;
         boolean var4 = false;
         int var5 = 0;

         int var8;
         for(int var9 = NavigationMenuPresenter.access$000(this.this$0).getVisibleItems().size(); var5 < var9; var3 = var8) {
            MenuItemImpl var11 = (MenuItemImpl)NavigationMenuPresenter.access$000(this.this$0).getVisibleItems().get(var5);
            if(var11.isChecked()) {
               this.setCheckedItem(var11);
            }

            if(var11.isCheckable()) {
               var11.setExclusiveCheckable(false);
            }

            boolean var2;
            int var7;
            if(!var11.hasSubMenu()) {
               var7 = var11.getGroupId();
               int var14;
               if(var7 != var6) {
                  int var16 = this.mItems.size();
                  boolean var15;
                  if(var11.getIcon() != null) {
                     var15 = true;
                  } else {
                     var15 = false;
                  }

                  var2 = var15;
                  var14 = var16;
                  if(var5 != 0) {
                     var14 = var16 + 1;
                     this.mItems.add(new NavigationMenuPresenter$NavigationMenuSeparatorItem(NavigationMenuPresenter.access$1100(this.this$0), NavigationMenuPresenter.access$1100(this.this$0)));
                     var2 = var15;
                  }
               } else {
                  var2 = var4;
                  var14 = var3;
                  if(!var4) {
                     var2 = var4;
                     var14 = var3;
                     if(var11.getIcon() != null) {
                        var2 = true;
                        this.appendTransparentIconIfMissing(var3, this.mItems.size());
                        var14 = var3;
                     }
                  }
               }

               if(var2 && var11.getIcon() == null) {
                  var11.setIcon(17170445);
               }

               this.mItems.add(new NavigationMenuPresenter$NavigationMenuTextItem(var11, (NavigationMenuPresenter$1)null));
               var8 = var14;
            } else {
               SubMenu var12 = var11.getSubMenu();
               var2 = var4;
               var7 = var6;
               var8 = var3;
               if(var12.hasVisibleItems()) {
                  if(var5 != 0) {
                     this.mItems.add(new NavigationMenuPresenter$NavigationMenuSeparatorItem(NavigationMenuPresenter.access$1100(this.this$0), 0));
                  }

                  this.mItems.add(new NavigationMenuPresenter$NavigationMenuTextItem(var11, (NavigationMenuPresenter$1)null));
                  boolean var1 = false;
                  int var10 = this.mItems.size();
                  var7 = 0;

                  for(var8 = var12.size(); var7 < var8; var1 = var2) {
                     MenuItemImpl var13 = (MenuItemImpl)var12.getItem(var7);
                     var2 = var1;
                     if(var13.isVisible()) {
                        var2 = var1;
                        if(!var1) {
                           var2 = var1;
                           if(var13.getIcon() != null) {
                              var2 = true;
                           }
                        }

                        if(var13.isCheckable()) {
                           var13.setExclusiveCheckable(false);
                        }

                        if(var11.isChecked()) {
                           this.setCheckedItem(var11);
                        }

                        this.mItems.add(new NavigationMenuPresenter$NavigationMenuTextItem(var13, (NavigationMenuPresenter$1)null));
                     }

                     ++var7;
                  }

                  var2 = var4;
                  var7 = var6;
                  var8 = var3;
                  if(var1) {
                     this.appendTransparentIconIfMissing(var10, this.mItems.size());
                     var8 = var3;
                     var7 = var6;
                     var2 = var4;
                  }
               }
            }

            ++var5;
            var4 = var2;
            var6 = var7;
         }

         this.mUpdateSuspended = false;
      }
   }

   public Bundle createInstanceState() {
      Bundle var2 = new Bundle();
      if(this.mCheckedItem != null) {
         var2.putInt("android:menu:checked", this.mCheckedItem.getItemId());
      }

      SparseArray var3 = new SparseArray();
      Iterator var4 = this.mItems.iterator();

      while(var4.hasNext()) {
         NavigationMenuPresenter$NavigationMenuItem var1 = (NavigationMenuPresenter$NavigationMenuItem)var4.next();
         if(var1 instanceof NavigationMenuPresenter$NavigationMenuTextItem) {
            MenuItemImpl var5 = ((NavigationMenuPresenter$NavigationMenuTextItem)var1).getMenuItem();
            View var7;
            if(var5 != null) {
               var7 = var5.getActionView();
            } else {
               var7 = null;
            }

            if(var7 != null) {
               ParcelableSparseArray var6 = new ParcelableSparseArray();
               var7.saveHierarchyState(var6);
               var3.put(var5.getItemId(), var6);
            }
         }
      }

      var2.putSparseParcelableArray("android:menu:action_views", var3);
      return var2;
   }

   public int getItemCount() {
      return this.mItems.size();
   }

   public long getItemId(int var1) {
      return (long)var1;
   }

   public int getItemViewType(int var1) {
      NavigationMenuPresenter$NavigationMenuItem var2 = (NavigationMenuPresenter$NavigationMenuItem)this.mItems.get(var1);
      if(var2 instanceof NavigationMenuPresenter$NavigationMenuSeparatorItem) {
         return 2;
      } else if(var2 instanceof NavigationMenuPresenter$NavigationMenuHeaderItem) {
         return 3;
      } else if(var2 instanceof NavigationMenuPresenter$NavigationMenuTextItem) {
         return ((NavigationMenuPresenter$NavigationMenuTextItem)var2).getMenuItem().hasSubMenu()?1:0;
      } else {
         throw new RuntimeException("Unknown item type.");
      }
   }

   public void onBindViewHolder(NavigationMenuPresenter$ViewHolder var1, int var2) {
      switch(this.getItemViewType(var2)) {
      case 0:
         NavigationMenuItemView var5 = (NavigationMenuItemView)var1.itemView;
         var5.setIconTintList(NavigationMenuPresenter.access$500(this.this$0));
         if(NavigationMenuPresenter.access$600(this.this$0)) {
            var5.setTextAppearance(var5.getContext(), NavigationMenuPresenter.access$700(this.this$0));
         }

         if(NavigationMenuPresenter.access$800(this.this$0) != null) {
            var5.setTextColor(NavigationMenuPresenter.access$800(this.this$0));
         }

         Drawable var4;
         if(NavigationMenuPresenter.access$900(this.this$0) != null) {
            var4 = NavigationMenuPresenter.access$900(this.this$0).getConstantState().newDrawable();
         } else {
            var4 = null;
         }

         var5.setBackgroundDrawable(var4);
         var5.initialize(((NavigationMenuPresenter$NavigationMenuTextItem)this.mItems.get(var2)).getMenuItem(), 0);
         return;
      case 1:
         ((TextView)var1.itemView).setText(((NavigationMenuPresenter$NavigationMenuTextItem)this.mItems.get(var2)).getMenuItem().getTitle());
         return;
      case 2:
         NavigationMenuPresenter$NavigationMenuSeparatorItem var3 = (NavigationMenuPresenter$NavigationMenuSeparatorItem)this.mItems.get(var2);
         var1.itemView.setPadding(0, var3.getPaddingTop(), 0, var3.getPaddingBottom());
         return;
      default:
      }
   }

   public NavigationMenuPresenter$ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      switch(var2) {
      case 0:
         return new NavigationMenuPresenter$NormalViewHolder(NavigationMenuPresenter.access$200(this.this$0), var1, NavigationMenuPresenter.access$300(this.this$0));
      case 1:
         return new NavigationMenuPresenter$SubheaderViewHolder(NavigationMenuPresenter.access$200(this.this$0), var1);
      case 2:
         return new NavigationMenuPresenter$SeparatorViewHolder(NavigationMenuPresenter.access$200(this.this$0), var1);
      case 3:
         return new NavigationMenuPresenter$HeaderViewHolder(NavigationMenuPresenter.access$400(this.this$0));
      default:
         return null;
      }
   }

   public void onViewRecycled(NavigationMenuPresenter$ViewHolder var1) {
      if(var1 instanceof NavigationMenuPresenter$NormalViewHolder) {
         ((NavigationMenuItemView)var1.itemView).recycle();
      }

   }

   public void restoreInstanceState(Bundle var1) {
      int var2 = var1.getInt("android:menu:checked", 0);
      if(var2 != 0) {
         this.mUpdateSuspended = true;
         Iterator var3 = this.mItems.iterator();

         while(var3.hasNext()) {
            NavigationMenuPresenter$NavigationMenuItem var4 = (NavigationMenuPresenter$NavigationMenuItem)var3.next();
            if(var4 instanceof NavigationMenuPresenter$NavigationMenuTextItem) {
               MenuItemImpl var9 = ((NavigationMenuPresenter$NavigationMenuTextItem)var4).getMenuItem();
               if(var9 != null && var9.getItemId() == var2) {
                  this.setCheckedItem(var9);
                  break;
               }
            }
         }

         this.mUpdateSuspended = false;
         this.prepareMenuItems();
      }

      SparseArray var8 = var1.getSparseParcelableArray("android:menu:action_views");
      Iterator var10 = this.mItems.iterator();

      while(var10.hasNext()) {
         NavigationMenuPresenter$NavigationMenuItem var6 = (NavigationMenuPresenter$NavigationMenuItem)var10.next();
         if(var6 instanceof NavigationMenuPresenter$NavigationMenuTextItem) {
            MenuItemImpl var5 = ((NavigationMenuPresenter$NavigationMenuTextItem)var6).getMenuItem();
            View var7;
            if(var5 != null) {
               var7 = var5.getActionView();
            } else {
               var7 = null;
            }

            if(var7 != null) {
               var7.restoreHierarchyState((SparseArray)var8.get(var5.getItemId()));
            }
         }
      }

   }

   public void setCheckedItem(MenuItemImpl var1) {
      if(this.mCheckedItem != var1 && var1.isCheckable()) {
         if(this.mCheckedItem != null) {
            this.mCheckedItem.setChecked(false);
         }

         this.mCheckedItem = var1;
         var1.setChecked(true);
      }
   }

   public void setUpdateSuspended(boolean var1) {
      this.mUpdateSuspended = var1;
   }

   public void update() {
      this.prepareMenuItems();
      this.notifyDataSetChanged();
   }
}
