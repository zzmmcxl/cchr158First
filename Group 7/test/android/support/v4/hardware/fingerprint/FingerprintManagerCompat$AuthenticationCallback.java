package android.support.v4.hardware.fingerprint;

import android.support.v4.hardware.fingerprint.FingerprintManagerCompat$AuthenticationResult;

public abstract class FingerprintManagerCompat$AuthenticationCallback {
   public void onAuthenticationError(int var1, CharSequence var2) {
   }

   public void onAuthenticationFailed() {
   }

   public void onAuthenticationHelp(int var1, CharSequence var2) {
   }

   public void onAuthenticationSucceeded(FingerprintManagerCompat$AuthenticationResult var1) {
   }
}
