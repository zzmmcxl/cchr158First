package android.support.v4.hardware.fingerprint;

import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public class FingerprintManagerCompatApi23$CryptoObject {
   private final Cipher mCipher;
   private final Mac mMac;
   private final Signature mSignature;

   public FingerprintManagerCompatApi23$CryptoObject(Signature var1) {
      this.mSignature = var1;
      this.mCipher = null;
      this.mMac = null;
   }

   public FingerprintManagerCompatApi23$CryptoObject(Cipher var1) {
      this.mCipher = var1;
      this.mSignature = null;
      this.mMac = null;
   }

   public FingerprintManagerCompatApi23$CryptoObject(Mac var1) {
      this.mMac = var1;
      this.mCipher = null;
      this.mSignature = null;
   }

   public Cipher getCipher() {
      return this.mCipher;
   }

   public Mac getMac() {
      return this.mMac;
   }

   public Signature getSignature() {
      return this.mSignature;
   }
}
