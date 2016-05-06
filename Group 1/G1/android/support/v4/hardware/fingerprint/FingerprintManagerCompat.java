package android.support.v4.hardware.fingerprint;

import java.security.Signature;
import javax.crypto.Mac;
import javax.crypto.Cipher;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.os.CancellationSignal;
import android.support.annotation.Nullable;
import android.os.Build$VERSION;
import android.content.Context;

public final class FingerprintManagerCompat
{
    static final FingerprintManagerCompatImpl IMPL;
    private Context mContext;
    
    static {
        if (Build$VERSION.SDK_INT >= 23) {
            IMPL = (FingerprintManagerCompatImpl)new Api23FingerprintManagerCompatImpl();
            return;
        }
        IMPL = (FingerprintManagerCompatImpl)new LegacyFingerprintManagerCompatImpl();
    }
    
    private FingerprintManagerCompat(final Context mContext) {
        super();
        mContext = mContext;
    }
    
    public static FingerprintManagerCompat from(final Context context) {
        return new FingerprintManagerCompat(context);
    }
    
    public void authenticate(@Nullable final CryptoObject cryptoObject, final int n, @Nullable final CancellationSignal cancellationSignal, @NonNull final AuthenticationCallback authenticationCallback, @Nullable final Handler handler) {
        IMPL.authenticate(mContext, cryptoObject, n, cancellationSignal, authenticationCallback, handler);
    }
    
    public boolean hasEnrolledFingerprints() {
        return IMPL.hasEnrolledFingerprints(mContext);
    }
    
    public boolean isHardwareDetected() {
        return IMPL.isHardwareDetected(mContext);
    }
}
