package android.support.v7.widget;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R$id;
import android.support.v7.appcompat.R$layout;
import android.support.v7.appcompat.R$string;
import android.support.v7.widget.ActivityChooserModel;
import android.support.v7.widget.ActivityChooserView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class ActivityChooserView$ActivityChooserViewAdapter extends BaseAdapter {
   private static final int ITEM_VIEW_TYPE_ACTIVITY = 0;
   private static final int ITEM_VIEW_TYPE_COUNT = 3;
   private static final int ITEM_VIEW_TYPE_FOOTER = 1;
   public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
   public static final int MAX_ACTIVITY_COUNT_UNLIMITED = Integer.MAX_VALUE;
   private ActivityChooserModel mDataModel;
   private boolean mHighlightDefaultActivity;
   private int mMaxActivityCount;
   private boolean mShowDefaultActivity;
   private boolean mShowFooterView;

   private ActivityChooserView$ActivityChooserViewAdapter(ActivityChooserView var1) {
      this.this$0 = var1;
      this.mMaxActivityCount = 4;
   }

   public int getActivityCount() {
      return this.mDataModel.getActivityCount();
   }

   public int getCount() {
      int var2 = this.mDataModel.getActivityCount();
      int var1 = var2;
      if(!this.mShowDefaultActivity) {
         var1 = var2;
         if(this.mDataModel.getDefaultActivity() != null) {
            var1 = var2 - 1;
         }
      }

      var2 = Math.min(var1, this.mMaxActivityCount);
      var1 = var2;
      if(this.mShowFooterView) {
         var1 = var2 + 1;
      }

      return var1;
   }

   public ActivityChooserModel getDataModel() {
      return this.mDataModel;
   }

   public ResolveInfo getDefaultActivity() {
      return this.mDataModel.getDefaultActivity();
   }

   public int getHistorySize() {
      return this.mDataModel.getHistorySize();
   }

   public Object getItem(int var1) {
      switch(this.getItemViewType(var1)) {
      case 0:
         int var2 = var1;
         if(!this.mShowDefaultActivity) {
            var2 = var1;
            if(this.mDataModel.getDefaultActivity() != null) {
               var2 = var1 + 1;
            }
         }

         return this.mDataModel.getActivity(var2);
      case 1:
         return null;
      default:
         throw new IllegalArgumentException();
      }
   }

   public long getItemId(int var1) {
      return (long)var1;
   }

   public int getItemViewType(int var1) {
      return this.mShowFooterView && var1 == this.getCount() - 1?1:0;
   }

   public boolean getShowDefaultActivity() {
      return this.mShowDefaultActivity;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      View var4;
      switch(this.getItemViewType(var1)) {
      case 0:
         label36: {
            if(var2 != null) {
               var4 = var2;
               if(var2.getId() == R$id.list_item) {
                  break label36;
               }
            }

            var4 = LayoutInflater.from(this.this$0.getContext()).inflate(R$layout.abc_activity_chooser_view_list_item, var3, false);
         }

         PackageManager var6 = this.this$0.getContext().getPackageManager();
         ImageView var7 = (ImageView)var4.findViewById(R$id.icon);
         ResolveInfo var5 = (ResolveInfo)this.getItem(var1);
         var7.setImageDrawable(var5.loadIcon(var6));
         ((TextView)var4.findViewById(R$id.title)).setText(var5.loadLabel(var6));
         if(this.mShowDefaultActivity && var1 == 0 && this.mHighlightDefaultActivity) {
            ViewCompat.setActivated(var4, true);
         } else {
            ViewCompat.setActivated(var4, false);
         }

         return var4;
      case 1:
         if(var2 != null) {
            var4 = var2;
            if(var2.getId() == 1) {
               return var4;
            }
         }

         var4 = LayoutInflater.from(this.this$0.getContext()).inflate(R$layout.abc_activity_chooser_view_list_item, var3, false);
         var4.setId(1);
         ((TextView)var4.findViewById(R$id.title)).setText(this.this$0.getContext().getString(R$string.abc_activity_chooser_view_see_all));
         return var4;
      default:
         throw new IllegalArgumentException();
      }
   }

   public int getViewTypeCount() {
      return 3;
   }

   public int measureContentWidth() {
      int var3 = this.mMaxActivityCount;
      this.mMaxActivityCount = Integer.MAX_VALUE;
      int var2 = 0;
      View var7 = null;
      int var4 = MeasureSpec.makeMeasureSpec(0, 0);
      int var5 = MeasureSpec.makeMeasureSpec(0, 0);
      int var6 = this.getCount();

      for(int var1 = 0; var1 < var6; ++var1) {
         var7 = this.getView(var1, var7, (ViewGroup)null);
         var7.measure(var4, var5);
         var2 = Math.max(var2, var7.getMeasuredWidth());
      }

      this.mMaxActivityCount = var3;
      return var2;
   }

   public void setDataModel(ActivityChooserModel var1) {
      ActivityChooserModel var2 = ActivityChooserView.access$000(this.this$0).getDataModel();
      if(var2 != null && this.this$0.isShown()) {
         var2.unregisterObserver(ActivityChooserView.access$1100(this.this$0));
      }

      this.mDataModel = var1;
      if(var1 != null && this.this$0.isShown()) {
         var1.registerObserver(ActivityChooserView.access$1100(this.this$0));
      }

      this.notifyDataSetChanged();
   }

   public void setMaxActivityCount(int var1) {
      if(this.mMaxActivityCount != var1) {
         this.mMaxActivityCount = var1;
         this.notifyDataSetChanged();
      }

   }

   public void setShowDefaultActivity(boolean var1, boolean var2) {
      if(this.mShowDefaultActivity != var1 || this.mHighlightDefaultActivity != var2) {
         this.mShowDefaultActivity = var1;
         this.mHighlightDefaultActivity = var2;
         this.notifyDataSetChanged();
      }

   }

   public void setShowFooterView(boolean var1) {
      if(this.mShowFooterView != var1) {
         this.mShowFooterView = var1;
         this.notifyDataSetChanged();
      }

   }
}
