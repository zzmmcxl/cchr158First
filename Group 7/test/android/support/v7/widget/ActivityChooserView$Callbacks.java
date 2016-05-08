package android.support.v7.widget;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.ActivityChooserView$ActivityChooserViewAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;

class ActivityChooserView$Callbacks implements OnItemClickListener, OnClickListener, OnLongClickListener, OnDismissListener {
   private ActivityChooserView$Callbacks(ActivityChooserView var1) {
      this.this$0 = var1;
   }

   private void notifyOnDismissListener() {
      if(ActivityChooserView.access$1000(this.this$0) != null) {
         ActivityChooserView.access$1000(this.this$0).onDismiss();
      }

   }

   public void onClick(View var1) {
      if(var1 == ActivityChooserView.access$700(this.this$0)) {
         this.this$0.dismissPopup();
         ResolveInfo var3 = ActivityChooserView.access$000(this.this$0).getDefaultActivity();
         int var2 = ActivityChooserView.access$000(this.this$0).getDataModel().getActivityIndex(var3);
         Intent var4 = ActivityChooserView.access$000(this.this$0).getDataModel().chooseActivity(var2);
         if(var4 != null) {
            var4.addFlags(524288);
            this.this$0.getContext().startActivity(var4);
         }

      } else if(var1 == ActivityChooserView.access$800(this.this$0)) {
         ActivityChooserView.access$602(this.this$0, false);
         ActivityChooserView.access$500(this.this$0, ActivityChooserView.access$900(this.this$0));
      } else {
         throw new IllegalArgumentException();
      }
   }

   public void onDismiss() {
      this.notifyOnDismissListener();
      if(this.this$0.mProvider != null) {
         this.this$0.mProvider.subUiVisibilityChanged(false);
      }

   }

   public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
      switch(((ActivityChooserView$ActivityChooserViewAdapter)var1.getAdapter()).getItemViewType(var3)) {
      case 0:
         this.this$0.dismissPopup();
         if(ActivityChooserView.access$600(this.this$0)) {
            if(var3 > 0) {
               ActivityChooserView.access$000(this.this$0).getDataModel().setDefaultActivity(var3);
               return;
            }
         } else {
            if(!ActivityChooserView.access$000(this.this$0).getShowDefaultActivity()) {
               ++var3;
            }

            Intent var6 = ActivityChooserView.access$000(this.this$0).getDataModel().chooseActivity(var3);
            if(var6 != null) {
               var6.addFlags(524288);
               this.this$0.getContext().startActivity(var6);
               return;
            }
         }
         break;
      case 1:
         ActivityChooserView.access$500(this.this$0, Integer.MAX_VALUE);
         break;
      default:
         throw new IllegalArgumentException();
      }

   }

   public boolean onLongClick(View var1) {
      if(var1 == ActivityChooserView.access$700(this.this$0)) {
         if(ActivityChooserView.access$000(this.this$0).getCount() > 0) {
            ActivityChooserView.access$602(this.this$0, true);
            ActivityChooserView.access$500(this.this$0, ActivityChooserView.access$900(this.this$0));
         }

         return true;
      } else {
         throw new IllegalArgumentException();
      }
   }
}
