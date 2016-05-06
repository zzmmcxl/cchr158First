package android.support.v4.hardware.fingerprint;

import android.hardware.fingerprint.FingerprintManager$AuthenticationResult;
import android.hardware.fingerprint.FingerprintManager$AuthenticationCallback;

static final class FingerprintManagerCompatApi23$1 extends FingerprintManager$AuthenticationCallback {
    final /* synthetic */ AuthenticationCallback val$callback;
    
    FingerprintManagerCompatApi23$1(final AuthenticationCallback val$callback) {
        this.val$callback = val$callback;
        super();
    }
    
    public void onAuthenticationError(final int n, final CharSequence charSequence) {
        val$callback.onAuthenticationError(n, charSequence);
    }
    
    public void onAuthenticationFailed() {
        val$callback.onAuthenticationFailed();
    }
    
    public void onAuthenticationHelp(final int n, final CharSequence charSequence) {
        val$callback.onAuthenticationHelp(n, charSequence);
    }
    
    public void onAuthenticationSucceeded(final FingerprintManager$AuthenticationResult fingerprintManager$AuthenticationResult) {
        val$callback.onAuthenticationSucceeded(new AuthenticationResultInternal(FingerprintManagerCompatApi23.access$000(fingerprintManager$AuthenticationResult.getCryptoObject())));
    }
}