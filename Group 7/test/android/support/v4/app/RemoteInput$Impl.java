package android.support.v4.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.RemoteInput;

interface RemoteInput$Impl {
   void addResultsToIntent(RemoteInput[] var1, Intent var2, Bundle var3);

   Bundle getResultsFromIntent(Intent var1);
}
