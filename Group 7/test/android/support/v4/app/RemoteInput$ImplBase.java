package android.support.v4.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.RemoteInput;
import android.support.v4.app.RemoteInput$Impl;
import android.util.Log;

class RemoteInput$ImplBase implements RemoteInput$Impl {
   public void addResultsToIntent(RemoteInput[] var1, Intent var2, Bundle var3) {
      Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
   }

   public Bundle getResultsFromIntent(Intent var1) {
      Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
      return null;
   }
}
