package android.support.v4.hardware.fingerprint;

import java.security.Signature;
import javax.crypto.Mac;
import javax.crypto.Cipher;

public static class CryptoObject
{
    private final Cipher mCipher;
    private final Mac mMac;
    private final Signature mSignature;
    
    public CryptoObject(final Signature mSignature) {
        super();
        this.mSignature = mSignature;
        this.mCipher = null;
        this.mMac = null;
    }
    
    public CryptoObject(final Cipher mCipher) {
        super();
        this.mCipher = mCipher;
        this.mSignature = null;
        this.mMac = null;
    }
    
    public CryptoObject(final Mac mMac) {
        super();
        this.mMac = mMac;
        this.mCipher = null;
        this.mSignature = null;
    }
    
    public Cipher getCipher() {
        return mCipher;
    }
    
    public Mac getMac() {
        return mMac;
    }
    
    public Signature getSignature() {
        return mSignature;
    }
}
