package android.support.v7.widget;

import android.content.Intent;
import android.support.v7.widget.ActivityChooserModel;
import android.support.v7.widget.ShareActionProvider;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ShareActionProvider$ShareMenuItemOnMenuItemClickListener implements OnMenuItemClickListener {
   private ShareActionProvider$ShareMenuItemOnMenuItemClickListener(ShareActionProvider var1) {
      this.this$0 = var1;
   }

   public boolean onMenuItemClick(MenuItem var1) {
      Intent var3 = ActivityChooserModel.get(ShareActionProvider.access$100(this.this$0), ShareActionProvider.access$200(this.this$0)).chooseActivity(var1.getItemId());
      if(var3 != null) {
         String var2 = var3.getAction();
         if("android.intent.action.SEND".equals(var2) || "android.intent.action.SEND_MULTIPLE".equals(var2)) {
            ShareActionProvider.access$300(this.this$0, var3);
         }

         ShareActionProvider.access$100(this.this$0).startActivity(var3);
      }

      return true;
   }
}
