package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v4.content.IntentCompat$IntentCompatImplBase;
import android.support.v4.content.IntentCompatHoneycomb;

class IntentCompat$IntentCompatImplHC extends IntentCompat$IntentCompatImplBase {
   public Intent makeMainActivity(ComponentName var1) {
      return IntentCompatHoneycomb.makeMainActivity(var1);
   }

   public Intent makeRestartActivityTask(ComponentName var1) {
      return IntentCompatHoneycomb.makeRestartActivityTask(var1);
   }
}
