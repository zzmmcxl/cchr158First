package android.support.v4.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$1;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$AuthenticationCallback;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$CryptoObject;

public final class FingerprintManagerCompatApi23 {
   public static void authenticate(Context var0, FingerprintManagerCompatApi23$CryptoObject var1, int var2, Object var3, FingerprintManagerCompatApi23$AuthenticationCallback var4, Handler var5) {
      getFingerprintManager(var0).authenticate(wrapCryptoObject(var1), (CancellationSignal)var3, var2, wrapCallback(var4), var5);
   }

   private static FingerprintManager getFingerprintManager(Context var0) {
      return (FingerprintManager)var0.getSystemService(FingerprintManager.class);
   }

   public static boolean hasEnrolledFingerprints(Context var0) {
      return getFingerprintManager(var0).hasEnrolledFingerprints();
   }

   public static boolean isHardwareDetected(Context var0) {
      return getFingerprintManager(var0).isHardwareDetected();
   }

   private static FingerprintManagerCompatApi23$CryptoObject unwrapCryptoObject(CryptoObject var0) {
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

   private static AuthenticationCallback wrapCallback(FingerprintManagerCompatApi23$AuthenticationCallback var0) {
      return new FingerprintManagerCompatApi23$1(var0);
   }

   private static CryptoObject wrapCryptoObject(FingerprintManagerCompatApi23$CryptoObject var0) {
      if(var0 != null) {
         if(var0.getCipher() != null) {
            return new CryptoObject(var0.getCipher());
         }

         if(var0.getSignature() != null) {
            return new CryptoObject(var0.getSignature());
         }

         if(var0.getMac() != null) {
            return new CryptoObject(var0.getMac());
         }
      }

      return null;
   }
}
