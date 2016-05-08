package android.support.v4.app;

import android.support.v4.app.FragmentTransitionCompat21;
import android.support.v4.app.FragmentTransitionCompat21$ViewRetriever;
import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

final class FragmentTransitionCompat21$2 implements OnPreDrawListener {
   FragmentTransitionCompat21$2(View var1, Transition var2, View var3, FragmentTransitionCompat21$ViewRetriever var4, Map var5, Map var6, ArrayList var7) {
      this.val$container = var1;
      this.val$enterTransition = var2;
      this.val$nonExistentView = var3;
      this.val$inFragment = var4;
      this.val$nameOverrides = var5;
      this.val$renamedViews = var6;
      this.val$enteringViews = var7;
   }

   public boolean onPreDraw() {
      this.val$container.getViewTreeObserver().removeOnPreDrawListener(this);
      if(this.val$enterTransition != null) {
         this.val$enterTransition.removeTarget(this.val$nonExistentView);
      }

      View var1 = this.val$inFragment.getView();
      if(var1 != null) {
         if(!this.val$nameOverrides.isEmpty()) {
            FragmentTransitionCompat21.findNamedViews(this.val$renamedViews, var1);
            this.val$renamedViews.keySet().retainAll(this.val$nameOverrides.values());
            Iterator var2 = this.val$nameOverrides.entrySet().iterator();

            while(var2.hasNext()) {
               Entry var3 = (Entry)var2.next();
               String var4 = (String)var3.getValue();
               View var5 = (View)this.val$renamedViews.get(var4);
               if(var5 != null) {
                  var5.setTransitionName((String)var3.getKey());
               }
            }
         }

         if(this.val$enterTransition != null) {
            FragmentTransitionCompat21.access$000(this.val$enteringViews, var1);
            this.val$enteringViews.removeAll(this.val$renamedViews.values());
            this.val$enteringViews.add(this.val$nonExistentView);
            FragmentTransitionCompat21.addTargets(this.val$enterTransition, this.val$enteringViews);
         }
      }

      return true;
   }
}
