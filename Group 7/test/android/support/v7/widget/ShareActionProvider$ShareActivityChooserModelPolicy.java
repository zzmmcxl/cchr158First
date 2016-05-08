package android.support.v7.widget;

import android.content.Intent;
import android.support.v7.widget.ActivityChooserModel;
import android.support.v7.widget.ActivityChooserModel$OnChooseActivityListener;
import android.support.v7.widget.ShareActionProvider;

class ShareActionProvider$ShareActivityChooserModelPolicy implements ActivityChooserModel$OnChooseActivityListener {
   private ShareActionProvider$ShareActivityChooserModelPolicy(ShareActionProvider var1) {
      this.this$0 = var1;
   }

   public boolean onChooseActivity(ActivityChooserModel var1, Intent var2) {
      if(ShareActionProvider.access$500(this.this$0) != null) {
         ShareActionProvider.access$500(this.this$0).onShareTargetSelected(this.this$0, var2);
      }

      return false;
   }
}
