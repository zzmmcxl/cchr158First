package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.RemoteInput;
import android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory;

final class RemoteInput$1 implements RemoteInputCompatBase$RemoteInput$Factory {
   public RemoteInput build(String var1, CharSequence var2, CharSequence[] var3, boolean var4, Bundle var5) {
      return new RemoteInput(var1, var2, var3, var4, var5, (RemoteInput$1)null);
   }

   public RemoteInput[] newArray(int var1) {
      return new RemoteInput[var1];
   }
}
