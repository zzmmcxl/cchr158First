package android.support.v4.hardware.fingerprint;

import android.support.v4.hardware.fingerprint.FingerprintManagerCompat$CryptoObject;

public final class FingerprintManagerCompat$AuthenticationResult {
   private FingerprintManagerCompat$CryptoObject mCryptoObject;

   public FingerprintManagerCompat$AuthenticationResult(FingerprintManagerCompat$CryptoObject var1) {
      this.mCryptoObject = var1;
   }

   public FingerprintManagerCompat$CryptoObject getCryptoObject() {
      return this.mCryptoObject;
   }
}
