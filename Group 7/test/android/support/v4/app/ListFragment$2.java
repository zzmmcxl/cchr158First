package android.support.v4.app;

import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

class ListFragment$2 implements OnItemClickListener {
   ListFragment$2(ListFragment var1) {
      this.this$0 = var1;
   }

   public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
      this.this$0.onListItemClick((ListView)var1, var2, var3, var4);
   }
}
