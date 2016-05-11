package com.google.android.gms.wallet;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzsd;
import com.google.android.gms.internal.zzse;
import com.google.android.gms.internal.zzsg;
import com.google.android.gms.internal.zzsh;
import com.google.android.gms.wallet.wobs.zzj;
import java.util.Locale;

public final class Wallet {
    public static final Api<WalletOptions> API;
    public static final Payments Payments;
    private static final zzc<zzse> zzUI;
    private static final com.google.android.gms.common.api.Api.zza<zzse, WalletOptions> zzUJ;
    public static final zzj zzbpJ;
    public static final com.google.android.gms.wallet.firstparty.zza zzbpK;

    /* renamed from: com.google.android.gms.wallet.Wallet.1 */
    static class C09081 extends com.google.android.gms.common.api.Api.zza<zzse, WalletOptions> {
        C09081() {
        }

        public zzse zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, WalletOptions walletOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (walletOptions == null) {
                walletOptions = new WalletOptions();
            }
            return new zzse(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener, walletOptions.environment, walletOptions.theme, walletOptions.zzbpL);
        }
    }

    public static final class WalletOptions implements HasOptions {
        public final int environment;
        public final int theme;
        private final boolean zzbpL;

        public static final class Builder {
            private int mTheme;
            private int zzbpM;
            private boolean zzbpN;

            public Builder() {
                this.zzbpM = 3;
                this.mTheme = 0;
                this.zzbpN = true;
            }

            public WalletOptions build() {
                return new WalletOptions();
            }

            public Builder setEnvironment(int environment) {
                if (environment == 0 || environment == 2 || environment == 1 || environment == 3) {
                    this.zzbpM = environment;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", new Object[]{Integer.valueOf(environment)}));
            }

            public Builder setTheme(int theme) {
                if (theme == 0 || theme == 1) {
                    this.mTheme = theme;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", new Object[]{Integer.valueOf(theme)}));
            }

            public Builder useGoogleWallet() {
                this.zzbpN = false;
                return this;
            }
        }

        private WalletOptions() {
            this(new Builder());
        }

        private WalletOptions(Builder builder) {
            this.environment = builder.zzbpM;
            this.theme = builder.mTheme;
            this.zzbpL = builder.zzbpN;
        }
    }

    public static abstract class zza<R extends Result> extends com.google.android.gms.common.api.internal.zza.zza<R, zzse> {
        public zza(GoogleApiClient googleApiClient) {
            super(Wallet.zzUI, googleApiClient);
        }
    }

    public static abstract class zzb extends zza<Status> {
        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    static {
        zzUI = new zzc();
        zzUJ = new C09081();
        API = new Api("Wallet.API", zzUJ, zzUI);
        Payments = new zzsd();
        zzbpJ = new zzsh();
        zzbpK = new zzsg();
    }

    private Wallet() {
    }

    @Deprecated
    public static void changeMaskedWallet(GoogleApiClient googleApiClient, String googleTransactionId, String merchantTransactionId, int requestCode) {
        Payments.changeMaskedWallet(googleApiClient, googleTransactionId, merchantTransactionId, requestCode);
    }

    @Deprecated
    public static void checkForPreAuthorization(GoogleApiClient googleApiClient, int requestCode) {
        Payments.checkForPreAuthorization(googleApiClient, requestCode);
    }

    @Deprecated
    public static void loadFullWallet(GoogleApiClient googleApiClient, FullWalletRequest request, int requestCode) {
        Payments.loadFullWallet(googleApiClient, request, requestCode);
    }

    @Deprecated
    public static void loadMaskedWallet(GoogleApiClient googleApiClient, MaskedWalletRequest request, int requestCode) {
        Payments.loadMaskedWallet(googleApiClient, request, requestCode);
    }

    @Deprecated
    public static void notifyTransactionStatus(GoogleApiClient googleApiClient, NotifyTransactionStatusRequest request) {
        Payments.notifyTransactionStatus(googleApiClient, request);
    }
}
