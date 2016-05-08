package android.support.v4.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.RemoteInput;
import android.support.v4.app.RemoteInput$Impl;
import android.support.v4.app.RemoteInputCompatJellybean;

class RemoteInput$ImplJellybean implements RemoteInput$Impl {
   public void addResultsToIntent(RemoteInput[] var1, Intent var2, Bundle var3) {
      RemoteInputCompatJellybean.addResultsToIntent(var1, var2, var3);
   }

   public Bundle getResultsFromIntent(Intent var1) {
      return RemoteInputCompatJellybean.getResultsFromIntent(var1);
   }
}
