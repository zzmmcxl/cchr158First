package android.support.v4.hardware.fingerprint;

import android.support.v4.hardware.fingerprint.FingerprintManagerCompat$Api23FingerprintManagerCompatImpl;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat$AuthenticationCallback;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat$AuthenticationResult;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$AuthenticationCallback;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$AuthenticationResultInternal;

final class FingerprintManagerCompat$Api23FingerprintManagerCompatImpl$1 extends FingerprintManagerCompatApi23$AuthenticationCallback {
   FingerprintManagerCompat$Api23FingerprintManagerCompatImpl$1(FingerprintManagerCompat$AuthenticationCallback var1) {
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

   public void onAuthenticationSucceeded(FingerprintManagerCompatApi23$AuthenticationResultInternal var1) {
      this.val$callback.onAuthenticationSucceeded(new FingerprintManagerCompat$AuthenticationResult(FingerprintManagerCompat$Api23FingerprintManagerCompatImpl.access$000(var1.getCryptoObject())));
   }
}
