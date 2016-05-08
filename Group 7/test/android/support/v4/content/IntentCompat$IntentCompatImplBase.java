package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v4.content.IntentCompat$IntentCompatImpl;

class IntentCompat$IntentCompatImplBase implements IntentCompat$IntentCompatImpl {
   public Intent makeMainActivity(ComponentName var1) {
      Intent var2 = new Intent("android.intent.action.MAIN");
      var2.setComponent(var1);
      var2.addCategory("android.intent.category.LAUNCHER");
      return var2;
   }

   public Intent makeMainSelectorActivity(String var1, String var2) {
      Intent var3 = new Intent(var1);
      var3.addCategory(var2);
      return var3;
   }

   public Intent makeRestartActivityTask(ComponentName var1) {
      Intent var2 = this.makeMainActivity(var1);
      var2.addFlags(268468224);
      return var2;
   }
}
