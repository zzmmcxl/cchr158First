package android.support.v4.hardware.fingerprint;

import java.security.Signature;
import javax.crypto.Mac;
import javax.crypto.Cipher;
import android.hardware.fingerprint.FingerprintManager$AuthenticationResult;
import android.hardware.fingerprint.FingerprintManager$AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.os.Handler;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager$CryptoObject;

public final class FingerprintManagerCompatApi23
{
    public FingerprintManagerCompatApi23() {
        super();
    }
    
    static /* synthetic */ CryptoObject access$000(final FingerprintManager$CryptoObject fingerprintManager$CryptoObject) {
        return unwrapCryptoObject(fingerprintManager$CryptoObject);
    }
    
    public static void authenticate(final Context context, final CryptoObject cryptoObject, final int n, final Object o, final AuthenticationCallback authenticationCallback, final Handler handler) {
        getFingerprintManager(context).authenticate(wrapCryptoObject(cryptoObject), (CancellationSignal)o, n, wrapCallback(authenticationCallback), handler);
    }
    
    private static FingerprintManager getFingerprintManager(final Context context) {
        return (FingerprintManager)context.getSystemService((Class)FingerprintManager.class);
    }
    
    public static boolean hasEnrolledFingerprints(final Context context) {
        return getFingerprintManager(context).hasEnrolledFingerprints();
    }
    
    public static boolean isHardwareDetected(final Context context) {
        return getFingerprintManager(context).isHardwareDetected();
    }
    
    private static CryptoObject unwrapCryptoObject(final FingerprintManager$CryptoObject fingerprintManager$CryptoObject) {
        if (fingerprintManager$CryptoObject != null) {
            if (fingerprintManager$CryptoObject.getCipher() != null) {
                return new CryptoObject(fingerprintManager$CryptoObject.getCipher());
            }
            if (fingerprintManager$CryptoObject.getSignature() != null) {
                return new CryptoObject(fingerprintManager$CryptoObject.getSignature());
            }
            if (fingerprintManager$CryptoObject.getMac() != null) {
                return new CryptoObject(fingerprintManager$CryptoObject.getMac());
            }
        }
        return null;
    }
    
    private static FingerprintManager$AuthenticationCallback wrapCallback(final AuthenticationCallback authenticationCallback) {
        return new FingerprintManager$AuthenticationCallback() {
            final /* synthetic */ AuthenticationCallback val$callback;
            
            FingerprintManagerCompatApi23$1() {
                super();
            }
            
            public void onAuthenticationError(final int n, final CharSequence charSequence) {
                authenticationCallback.onAuthenticationError(n, charSequence);
            }
            
            public void onAuthenticationFailed() {
                authenticationCallback.onAuthenticationFailed();
            }
            
            public void onAuthenticationHelp(final int n, final CharSequence charSequence) {
                authenticationCallback.onAuthenticationHelp(n, charSequence);
            }
            
            public void onAuthenticationSucceeded(final FingerprintManager$AuthenticationResult fingerprintManager$AuthenticationResult) {
                authenticationCallback.onAuthenticationSucceeded(new AuthenticationResultInternal(unwrapCryptoObject(fingerprintManager$AuthenticationResult.getCryptoObject())));
            }
        };
    }
    
    private static FingerprintManager$CryptoObject wrapCryptoObject(final CryptoObject cryptoObject) {
        if (cryptoObject != null) {
            if (cryptoObject.getCipher() != null) {
                return new FingerprintManager$CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new FingerprintManager$CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() != null) {
                return new FingerprintManager$CryptoObject(cryptoObject.getMac());
            }
        }
        return null;
    }
}
