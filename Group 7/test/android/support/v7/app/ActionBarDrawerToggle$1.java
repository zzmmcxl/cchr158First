package android.support.v7.app;

import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;
import android.view.View.OnClickListener;

class ActionBarDrawerToggle$1 implements OnClickListener {
   ActionBarDrawerToggle$1(ActionBarDrawerToggle var1) {
      this.this$0 = var1;
   }

   public void onClick(View var1) {
      if(ActionBarDrawerToggle.access$000(this.this$0)) {
         ActionBarDrawerToggle.access$100(this.this$0);
      } else if(ActionBarDrawerToggle.access$200(this.this$0) != null) {
         ActionBarDrawerToggle.access$200(this.this$0).onClick(var1);
         return;
      }

   }
}
