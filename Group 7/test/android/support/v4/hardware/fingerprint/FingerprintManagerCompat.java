package android.support.v4.hardware.fingerprint;

import android.content.Context;
import android.os.Handler;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat$Api23FingerprintManagerCompatImpl;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat$AuthenticationCallback;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat$CryptoObject;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat$FingerprintManagerCompatImpl;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat$LegacyFingerprintManagerCompatImpl;
import android.support.v4.os.CancellationSignal;

public final class FingerprintManagerCompat {
   static final FingerprintManagerCompat$FingerprintManagerCompatImpl IMPL;
   private Context mContext;

   static {
      if(VERSION.SDK_INT >= 23) {
         IMPL = new FingerprintManagerCompat$Api23FingerprintManagerCompatImpl();
      } else {
         IMPL = new FingerprintManagerCompat$LegacyFingerprintManagerCompatImpl();
      }
   }

   private FingerprintManagerCompat(Context var1) {
      this.mContext = var1;
   }

   public static FingerprintManagerCompat from(Context var0) {
      return new FingerprintManagerCompat(var0);
   }

   public void authenticate(@Nullable FingerprintManagerCompat$CryptoObject var1, int var2, @Nullable CancellationSignal var3, @NonNull FingerprintManagerCompat$AuthenticationCallback var4, @Nullable Handler var5) {
      IMPL.authenticate(this.mContext, var1, var2, var3, var4, var5);
   }

   public boolean hasEnrolledFingerprints() {
      return IMPL.hasEnrolledFingerprints(this.mContext);
   }

   public boolean isHardwareDetected() {
      return IMPL.isHardwareDetected(this.mContext);
   }
}
