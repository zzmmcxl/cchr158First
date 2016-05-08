package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;

class CoordinatorLayout$HierarchyChangeListener implements OnHierarchyChangeListener {
   private CoordinatorLayout$HierarchyChangeListener(CoordinatorLayout var1) {
      this.this$0 = var1;
   }

   public void onChildViewAdded(View var1, View var2) {
      if(CoordinatorLayout.access$300(this.this$0) != null) {
         CoordinatorLayout.access$300(this.this$0).onChildViewAdded(var1, var2);
      }

   }

   public void onChildViewRemoved(View var1, View var2) {
      this.this$0.dispatchDependentViewRemoved(var2);
      if(CoordinatorLayout.access$300(this.this$0) != null) {
         CoordinatorLayout.access$300(this.this$0).onChildViewRemoved(var1, var2);
      }

   }
}
