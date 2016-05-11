package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.AttestationData;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.safetynet.SafetyNetApi.AttestationResult;
import com.google.android.gms.safetynet.SafetyNetApi.SafeBrowsingResult;
import java.util.List;

public class zzre implements SafetyNetApi {

    static class zza implements AttestationResult {
        private final Status zzUX;
        private final AttestationData zzbgB;

        public zza(Status status, AttestationData attestationData) {
            this.zzUX = status;
            this.zzbgB = attestationData;
        }

        public String getJwsResult() {
            return this.zzbgB == null ? null : this.zzbgB.getJwsResult();
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    static class zzd implements SafeBrowsingResult {
        private Status zzUX;
        private final SafeBrowsingData zzbgF;
        private String zzbgv;

        public zzd(Status status, SafeBrowsingData safeBrowsingData) {
            this.zzUX = status;
            this.zzbgF = safeBrowsingData;
            this.zzbgv = null;
            if (this.zzbgF != null) {
                this.zzbgv = this.zzbgF.getMetadata();
            } else if (this.zzUX.isSuccess()) {
                this.zzUX = new Status(8);
            }
        }

        public String getMetadata() {
            return this.zzbgv;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    static abstract class zzb extends zzrb<AttestationResult> {
        protected zzrc zzbgC;

        /* renamed from: com.google.android.gms.internal.zzre.zzb.1 */
        class C10611 extends zzra {
            final /* synthetic */ zzb zzbgD;

            C10611(zzb com_google_android_gms_internal_zzre_zzb) {
                this.zzbgD = com_google_android_gms_internal_zzre_zzb;
            }

            public void zza(Status status, AttestationData attestationData) {
                this.zzbgD.zza(new zza(status, attestationData));
            }
        }

        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzbgC = new C10611(this);
        }

        protected AttestationResult zzbh(Status status) {
            return new zza(status, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzbh(status);
        }
    }

    static abstract class zzc extends zzrb<SafeBrowsingResult> {
        protected zzrc zzbgC;

        /* renamed from: com.google.android.gms.internal.zzre.zzc.1 */
        class C10621 extends zzra {
            final /* synthetic */ zzc zzbgE;

            C10621(zzc com_google_android_gms_internal_zzre_zzc) {
                this.zzbgE = com_google_android_gms_internal_zzre_zzc;
            }

            public void zza(Status status, SafeBrowsingData safeBrowsingData) {
                this.zzbgE.zza(new zzd(status, safeBrowsingData));
            }
        }

        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzbgC = new C10621(this);
        }

        protected SafeBrowsingResult zzbi(Status status) {
            return new zzd(status, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzbi(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzre.1 */
    class C12811 extends zzb {
        final /* synthetic */ byte[] zzbgx;
        final /* synthetic */ zzre zzbgy;

        C12811(zzre com_google_android_gms_internal_zzre, GoogleApiClient googleApiClient, byte[] bArr) {
            this.zzbgy = com_google_android_gms_internal_zzre;
            this.zzbgx = bArr;
            super(googleApiClient);
        }

        protected void zza(zzrf com_google_android_gms_internal_zzrf) throws RemoteException {
            com_google_android_gms_internal_zzrf.zza(this.zzbgC, this.zzbgx);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzre.2 */
    class C12822 extends zzc {
        final /* synthetic */ String zzbgA;
        final /* synthetic */ zzre zzbgy;
        final /* synthetic */ List zzbgz;

        C12822(zzre com_google_android_gms_internal_zzre, GoogleApiClient googleApiClient, List list, String str) {
            this.zzbgy = com_google_android_gms_internal_zzre;
            this.zzbgz = list;
            this.zzbgA = str;
            super(googleApiClient);
        }

        protected void zza(zzrf com_google_android_gms_internal_zzrf) throws RemoteException {
            com_google_android_gms_internal_zzrf.zza(this.zzbgC, this.zzbgz, 1, this.zzbgA);
        }
    }

    public PendingResult<AttestationResult> attest(GoogleApiClient googleApiClient, byte[] nonce) {
        return googleApiClient.zza(new C12811(this, googleApiClient, nonce));
    }

    public PendingResult<SafeBrowsingResult> lookupUri(GoogleApiClient googleApiClient, List<Integer> threatTypes, String uri) {
        if (threatTypes == null) {
            throw new IllegalArgumentException("Null threatTypes in lookupUri");
        } else if (!TextUtils.isEmpty(uri)) {
            return googleApiClient.zza(new C12822(this, googleApiClient, threatTypes, uri));
        } else {
            throw new IllegalArgumentException("Null or empty uri in lookupUri");
        }
    }
}
