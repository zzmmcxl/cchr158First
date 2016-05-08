package android.support.v7.widget;

import android.support.v7.widget.ScrollingTabContainerView;
import android.support.v7.widget.ScrollingTabContainerView$TabView;
import android.view.View;
import android.view.View.OnClickListener;

class ScrollingTabContainerView$TabClickListener implements OnClickListener {
   private ScrollingTabContainerView$TabClickListener(ScrollingTabContainerView var1) {
      this.this$0 = var1;
   }

   public void onClick(View var1) {
      ((ScrollingTabContainerView$TabView)var1).getTab().select();
      int var3 = ScrollingTabContainerView.access$200(this.this$0).getChildCount();

      for(int var2 = 0; var2 < var3; ++var2) {
         View var5 = ScrollingTabContainerView.access$200(this.this$0).getChildAt(var2);
         boolean var4;
         if(var5 == var1) {
            var4 = true;
         } else {
            var4 = false;
         }

         var5.setSelected(var4);
      }

   }
}
