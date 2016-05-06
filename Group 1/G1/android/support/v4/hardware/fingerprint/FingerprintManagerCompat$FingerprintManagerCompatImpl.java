package android.support.v4.hardware.fingerprint;

import android.os.Handler;
import android.support.v4.os.CancellationSignal;
import android.content.Context;

private interface FingerprintManagerCompatImpl
{
    void authenticate(final Context p0, final CryptoObject p1, final int p2, final CancellationSignal p3, final AuthenticationCallback p4, final Handler p5);
    
    boolean hasEnrolledFingerprints(final Context p0);
    
    boolean isHardwareDetected(final Context p0);
}
