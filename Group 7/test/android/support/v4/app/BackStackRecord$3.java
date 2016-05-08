package android.support.v4.app;

import android.support.v4.app.BackStackRecord;
import android.support.v4.app.BackStackRecord$TransitionState;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;

class BackStackRecord$3 implements OnPreDrawListener {
   BackStackRecord$3(BackStackRecord var1, View var2, BackStackRecord$TransitionState var3, int var4, Object var5) {
      this.this$0 = var1;
      this.val$sceneRoot = var2;
      this.val$state = var3;
      this.val$containerId = var4;
      this.val$transition = var5;
   }

   public boolean onPreDraw() {
      this.val$sceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
      BackStackRecord.access$300(this.this$0, this.val$state, this.val$containerId, this.val$transition);
      return true;
   }
}
