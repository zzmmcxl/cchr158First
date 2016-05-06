package android.support.v4.hardware.fingerprint;

import android.os.Handler;
import android.support.v4.os.CancellationSignal;
import android.content.Context;

private static class Api23FingerprintManagerCompatImpl implements FingerprintManagerCompatImpl
{
    public Api23FingerprintManagerCompatImpl() {
        super();
    }
    
    static /* synthetic */ CryptoObject access$000(final FingerprintManagerCompatApi23.CryptoObject cryptoObject) {
        return unwrapCryptoObject(cryptoObject);
    }
    
    private static CryptoObject unwrapCryptoObject(final FingerprintManagerCompatApi23.CryptoObject cryptoObject) {
        if (cryptoObject != null) {
            if (cryptoObject.getCipher() != null) {
                return new CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() != null) {
                return new CryptoObject(cryptoObject.getMac());
            }
        }
        return null;
    }
    
    private static FingerprintManagerCompatApi23.AuthenticationCallback wrapCallback(final AuthenticationCallback authenticationCallback) {
        return new FingerprintManagerCompatApi23.AuthenticationCallback() {
            final /* synthetic */ FingerprintManagerCompat.AuthenticationCallback val$callback;
            
            FingerprintManagerCompat$Api23FingerprintManagerCompatImpl$1() {
                super();
            }
            
            @Override
            public void onAuthenticationError(final int n, final CharSequence charSequence) {
                authenticationCallback.onAuthenticationError(n, charSequence);
            }
            
            @Override
            public void onAuthenticationFailed() {
                authenticationCallback.onAuthenticationFailed();
            }
            
            @Override
            public void onAuthenticationHelp(final int n, final CharSequence charSequence) {
                authenticationCallback.onAuthenticationHelp(n, charSequence);
            }
            
            @Override
            public void onAuthenticationSucceeded(final AuthenticationResultInternal authenticationResultInternal) {
                authenticationCallback.onAuthenticationSucceeded(new AuthenticationResult(unwrapCryptoObject(authenticationResultInternal.getCryptoObject())));
            }
        };
    }
    
    private static FingerprintManagerCompatApi23.CryptoObject wrapCryptoObject(final CryptoObject cryptoObject) {
        if (cryptoObject != null) {
            if (cryptoObject.getCipher() != null) {
                return new FingerprintManagerCompatApi23.CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new FingerprintManagerCompatApi23.CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() != null) {
                return new FingerprintManagerCompatApi23.CryptoObject(cryptoObject.getMac());
            }
        }
        return null;
    }
    
    @Override
    public void authenticate(final Context context, final CryptoObject cryptoObject, final int n, final CancellationSignal cancellationSignal, final AuthenticationCallback authenticationCallback, final Handler handler) {
        final FingerprintManagerCompatApi23.CryptoObject wrapCryptoObject = wrapCryptoObject(cryptoObject);
        Object cancellationSignalObject;
        if (cancellationSignal != null) {
            cancellationSignalObject = cancellationSignal.getCancellationSignalObject();
        }
        else {
            cancellationSignalObject = null;
        }
        FingerprintManagerCompatApi23.authenticate(context, wrapCryptoObject, n, cancellationSignalObject, wrapCallback(authenticationCallback), handler);
    }
    
    @Override
    public boolean hasEnrolledFingerprints(final Context context) {
        return FingerprintManagerCompatApi23.hasEnrolledFingerprints(context);
    }
    
    @Override
    public boolean isHardwareDetected(final Context context) {
        return FingerprintManagerCompatApi23.isHardwareDetected(context);
    }
}
