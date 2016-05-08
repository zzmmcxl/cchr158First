package android.support.v4.app;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentContainer;
import android.view.View;

class Fragment$1 extends FragmentContainer {
   Fragment$1(Fragment var1) {
      this.this$0 = var1;
   }

   @Nullable
   public View onFindViewById(int var1) {
      if(this.this$0.mView == null) {
         throw new IllegalStateException("Fragment does not have a view");
      } else {
         return this.this$0.mView.findViewById(var1);
      }
   }

   public boolean onHasView() {
      return this.this$0.mView != null;
   }
}
