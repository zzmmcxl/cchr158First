package android.support.v4.app;

import android.support.v4.app.BackStackRecord;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransitionCompat21$ViewRetriever;
import android.view.View;

class BackStackRecord$1 implements FragmentTransitionCompat21$ViewRetriever {
   BackStackRecord$1(BackStackRecord var1, Fragment var2) {
      this.this$0 = var1;
      this.val$inFragment = var2;
   }

   public View getView() {
      return this.val$inFragment.getView();
   }
}
