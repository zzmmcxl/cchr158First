package android.support.v4.hardware.fingerprint;

import android.content.Context;
import android.os.Handler;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat$AuthenticationCallback;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat$CryptoObject;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat$FingerprintManagerCompatImpl;
import android.support.v4.os.CancellationSignal;

class FingerprintManagerCompat$LegacyFingerprintManagerCompatImpl implements FingerprintManagerCompat$FingerprintManagerCompatImpl {
   public void authenticate(Context var1, FingerprintManagerCompat$CryptoObject var2, int var3, CancellationSignal var4, FingerprintManagerCompat$AuthenticationCallback var5, Handler var6) {
   }

   public boolean hasEnrolledFingerprints(Context var1) {
      return false;
   }

   public boolean isHardwareDetected(Context var1) {
      return false;
   }
}
