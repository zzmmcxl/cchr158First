package android.support.v7.widget;

import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuPresenter$OverflowPopup;
import android.view.View;

class ActionMenuPresenter$OpenOverflowRunnable implements Runnable {
   private ActionMenuPresenter$OverflowPopup mPopup;

   public ActionMenuPresenter$OpenOverflowRunnable(ActionMenuPresenter var1, ActionMenuPresenter$OverflowPopup var2) {
      this.this$0 = var1;
      this.mPopup = var2;
   }

   public void run() {
      ActionMenuPresenter.access$900(this.this$0).changeMenuMode();
      View var1 = (View)ActionMenuPresenter.access$1000(this.this$0);
      if(var1 != null && var1.getWindowToken() != null && this.mPopup.tryShow()) {
         ActionMenuPresenter.access$202(this.this$0, this.mPopup);
      }

      ActionMenuPresenter.access$302(this.this$0, (ActionMenuPresenter$OpenOverflowRunnable)null);
   }
}
