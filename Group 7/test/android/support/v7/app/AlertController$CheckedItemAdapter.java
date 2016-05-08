package android.support.v7.app;

import android.content.Context;
import android.widget.ArrayAdapter;

class AlertController$CheckedItemAdapter extends ArrayAdapter<CharSequence> {
   public AlertController$CheckedItemAdapter(Context var1, int var2, int var3, CharSequence[] var4) {
      super(var1, var2, var3, var4);
   }

   public long getItemId(int var1) {
      return (long)var1;
   }

   public boolean hasStableIds() {
      return true;
   }
}
