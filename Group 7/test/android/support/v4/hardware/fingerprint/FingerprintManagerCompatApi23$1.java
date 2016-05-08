package android.support.v4.hardware.fingerprint;

import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$AuthenticationCallback;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$AuthenticationResultInternal;

final class FingerprintManagerCompatApi23$1 extends AuthenticationCallback {
   FingerprintManagerCompatApi23$1(FingerprintManagerCompatApi23$AuthenticationCallback var1) {
      this.val$callback = var1;
   }

   public void onAuthenticationError(int var1, CharSequence var2) {
      this.val$callback.onAuthenticationError(var1, var2);
   }

   public void onAuthenticationFailed() {
      this.val$callback.onAuthenticationFailed();
   }

   public void onAuthenticationHelp(int var1, CharSequence var2) {
      this.val$callback.onAuthenticationHelp(var1, var2);
   }

   public void onAuthenticationSucceeded(AuthenticationResult var1) {
      this.val$callback.onAuthenticationSucceeded(new FingerprintManagerCompatApi23$AuthenticationResultInternal(FingerprintManagerCompatApi23.access$000(var1.getCryptoObject())));
   }
}
