package android.support.v4.hardware.fingerprint;

import android.content.Context;
import android.os.Handler;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat$Api23FingerprintManagerCompatImpl$1;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat$AuthenticationCallback;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat$CryptoObject;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat$FingerprintManagerCompatImpl;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$AuthenticationCallback;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$CryptoObject;
import android.support.v4.os.CancellationSignal;

class FingerprintManagerCompat$Api23FingerprintManagerCompatImpl implements FingerprintManagerCompat$FingerprintManagerCompatImpl {
   private static FingerprintManagerCompat$CryptoObject unwrapCryptoObject(FingerprintManagerCompatApi23$CryptoObject var0) {
      if(var0 != null) {
         if(var0.getCipher() != null) {
            return new FingerprintManagerCompat$CryptoObject(var0.getCipher());
         }

         if(var0.getSignature() != null) {
            return new FingerprintManagerCompat$CryptoObject(var0.getSignature());
         }

         if(var0.getMac() != null) {
            return new FingerprintManagerCompat$CryptoObject(var0.getMac());
         }
      }

      return null;
   }

   private static FingerprintManagerCompatApi23$AuthenticationCallback wrapCallback(FingerprintManagerCompat$AuthenticationCallback var0) {
      return new FingerprintManagerCompat$Api23FingerprintManagerCompatImpl$1(var0);
   }

   private static FingerprintManagerCompatApi23$CryptoObject wrapCryptoObject(FingerprintManagerCompat$CryptoObject var0) {
      if(var0 != null) {
         if(var0.getCipher() != null) {
            return new FingerprintManagerCompatApi23$CryptoObject(var0.getCipher());
         }

         if(var0.getSignature() != null) {
            return new FingerprintManagerCompatApi23$CryptoObject(var0.getSignature());
         }

         if(var0.getMac() != null) {
            return new FingerprintManagerCompatApi23$CryptoObject(var0.getMac());
         }
      }

      return null;
   }

   public void authenticate(Context var1, FingerprintManagerCompat$CryptoObject var2, int var3, CancellationSignal var4, FingerprintManagerCompat$AuthenticationCallback var5, Handler var6) {
      FingerprintManagerCompatApi23$CryptoObject var7 = wrapCryptoObject(var2);
      Object var8;
      if(var4 != null) {
         var8 = var4.getCancellationSignalObject();
      } else {
         var8 = null;
      }

      FingerprintManagerCompatApi23.authenticate(var1, var7, var3, var8, wrapCallback(var5), var6);
   }

   public boolean hasEnrolledFingerprints(Context var1) {
      return FingerprintManagerCompatApi23.hasEnrolledFingerprints(var1);
   }

   public boolean isHardwareDetected(Context var1) {
      return FingerprintManagerCompatApi23.isHardwareDetected(var1);
   }
}
