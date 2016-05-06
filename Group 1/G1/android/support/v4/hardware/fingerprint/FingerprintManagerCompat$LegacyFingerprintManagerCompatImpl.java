package android.support.v4.hardware.fingerprint;

import android.os.Handler;
import android.support.v4.os.CancellationSignal;
import android.content.Context;

private static class LegacyFingerprintManagerCompatImpl implements FingerprintManagerCompatImpl
{
    public LegacyFingerprintManagerCompatImpl() {
        super();
    }
    
    @Override
    public void authenticate(final Context context, final CryptoObject cryptoObject, final int n, final CancellationSignal cancellationSignal, final AuthenticationCallback authenticationCallback, final Handler handler) {
    }
    
    @Override
    public boolean hasEnrolledFingerprints(final Context context) {
        return false;
    }
    
    @Override
    public boolean isHardwareDetected(final Context context) {
        return false;
    }
}
