package android.support.v4.app;

import android.support.v4.app.BackStackRecord;
import android.support.v4.app.BackStackRecord$TransitionState;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransitionCompat21;
import android.support.v4.util.ArrayMap;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;

class BackStackRecord$2 implements OnPreDrawListener {
   BackStackRecord$2(BackStackRecord var1, View var2, Object var3, ArrayList var4, BackStackRecord$TransitionState var5, boolean var6, Fragment var7, Fragment var8) {
      this.this$0 = var1;
      this.val$sceneRoot = var2;
      this.val$sharedElementTransition = var3;
      this.val$sharedElementTargets = var4;
      this.val$state = var5;
      this.val$isBack = var6;
      this.val$inFragment = var7;
      this.val$outFragment = var8;
   }

   public boolean onPreDraw() {
      this.val$sceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
      if(this.val$sharedElementTransition != null) {
         FragmentTransitionCompat21.removeTargets(this.val$sharedElementTransition, this.val$sharedElementTargets);
         this.val$sharedElementTargets.clear();
         ArrayMap var1 = BackStackRecord.access$000(this.this$0, this.val$state, this.val$isBack, this.val$inFragment);
         FragmentTransitionCompat21.setSharedElementTargets(this.val$sharedElementTransition, this.val$state.nonExistentView, var1, this.val$sharedElementTargets);
         BackStackRecord.access$100(this.this$0, var1, this.val$state);
         BackStackRecord.access$200(this.this$0, this.val$state, this.val$inFragment, this.val$outFragment, this.val$isBack, var1);
      }

      return true;
   }
}
