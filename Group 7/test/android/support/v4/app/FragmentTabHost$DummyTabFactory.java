package android.support.v4.app;

import android.content.Context;
import android.view.View;
import android.widget.TabHost.TabContentFactory;

class FragmentTabHost$DummyTabFactory implements TabContentFactory {
   private final Context mContext;

   public FragmentTabHost$DummyTabFactory(Context var1) {
      this.mContext = var1;
   }

   public View createTabContent(String var1) {
      View var2 = new View(this.mContext);
      var2.setMinimumWidth(0);
      var2.setMinimumHeight(0);
      return var2;
   }
}
