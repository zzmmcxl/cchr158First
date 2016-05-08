package android.support.v4.app;

import android.support.v4.app.FragmentTransitionCompat21;
import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

final class FragmentTransitionCompat21$4 implements OnPreDrawListener {
   FragmentTransitionCompat21$4(View var1, Transition var2, ArrayList var3, Transition var4, ArrayList var5, Transition var6, ArrayList var7, Map var8, ArrayList var9, Transition var10, View var11) {
      this.val$sceneRoot = var1;
      this.val$enterTransition = var2;
      this.val$enteringViews = var3;
      this.val$exitTransition = var4;
      this.val$exitingViews = var5;
      this.val$sharedElementTransition = var6;
      this.val$sharedElementTargets = var7;
      this.val$renamedViews = var8;
      this.val$hiddenViews = var9;
      this.val$overallTransition = var10;
      this.val$nonExistentView = var11;
   }

   public boolean onPreDraw() {
      this.val$sceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
      if(this.val$enterTransition != null) {
         FragmentTransitionCompat21.removeTargets(this.val$enterTransition, this.val$enteringViews);
      }

      if(this.val$exitTransition != null) {
         FragmentTransitionCompat21.removeTargets(this.val$exitTransition, this.val$exitingViews);
      }

      if(this.val$sharedElementTransition != null) {
         FragmentTransitionCompat21.removeTargets(this.val$sharedElementTransition, this.val$sharedElementTargets);
      }

      Iterator var3 = this.val$renamedViews.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         ((View)var4.getValue()).setTransitionName((String)var4.getKey());
      }

      int var2 = this.val$hiddenViews.size();

      for(int var1 = 0; var1 < var2; ++var1) {
         this.val$overallTransition.excludeTarget((View)this.val$hiddenViews.get(var1), false);
      }

      this.val$overallTransition.excludeTarget(this.val$nonExistentView, false);
      return true;
   }
}
