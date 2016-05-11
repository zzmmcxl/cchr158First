package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.zze;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

public final class zzqz implements People {

    private static abstract class zza extends com.google.android.gms.plus.Plus.zza<LoadPeopleResult> {

        /* renamed from: com.google.android.gms.internal.zzqz.zza.1 */
        class C10201 implements LoadPeopleResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ zza zzbeL;

            C10201(zza com_google_android_gms_internal_zzqz_zza, Status status) {
                this.zzbeL = com_google_android_gms_internal_zzqz_zza;
                this.zzZR = status;
            }

            public String getNextPageToken() {
                return null;
            }

            public PersonBuffer getPersonBuffer() {
                return null;
            }

            public Status getStatus() {
                return this.zzZR;
            }

            public void release() {
            }
        }

        private zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadPeopleResult zzbg(Status status) {
            return new C10201(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbg(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqz.1 */
    class C12761 extends zza {
        final /* synthetic */ String zzbeA;
        final /* synthetic */ int zzbeH;
        final /* synthetic */ zzqz zzbeI;

        C12761(zzqz com_google_android_gms_internal_zzqz, GoogleApiClient googleApiClient, int i, String str) {
            this.zzbeI = com_google_android_gms_internal_zzqz;
            this.zzbeH = i;
            this.zzbeA = str;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            zza(com_google_android_gms_plus_internal_zze.zza(this, this.zzbeH, this.zzbeA));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqz.2 */
    class C12772 extends zza {
        final /* synthetic */ String zzbeA;
        final /* synthetic */ zzqz zzbeI;

        C12772(zzqz com_google_android_gms_internal_zzqz, GoogleApiClient googleApiClient, String str) {
            this.zzbeI = com_google_android_gms_internal_zzqz;
            this.zzbeA = str;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            zza(com_google_android_gms_plus_internal_zze.zzq(this, this.zzbeA));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqz.3 */
    class C12783 extends zza {
        final /* synthetic */ zzqz zzbeI;

        C12783(zzqz com_google_android_gms_internal_zzqz, GoogleApiClient googleApiClient) {
            this.zzbeI = com_google_android_gms_internal_zzqz;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            com_google_android_gms_plus_internal_zze.zzp(this);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqz.4 */
    class C12794 extends zza {
        final /* synthetic */ zzqz zzbeI;
        final /* synthetic */ Collection zzbeJ;

        C12794(zzqz com_google_android_gms_internal_zzqz, GoogleApiClient googleApiClient, Collection collection) {
            this.zzbeI = com_google_android_gms_internal_zzqz;
            this.zzbeJ = collection;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            com_google_android_gms_plus_internal_zze.zza((zzb) this, this.zzbeJ);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqz.5 */
    class C12805 extends zza {
        final /* synthetic */ zzqz zzbeI;
        final /* synthetic */ String[] zzbeK;

        C12805(zzqz com_google_android_gms_internal_zzqz, GoogleApiClient googleApiClient, String[] strArr) {
            this.zzbeI = com_google_android_gms_internal_zzqz;
            this.zzbeK = strArr;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            com_google_android_gms_plus_internal_zze.zzd(this, this.zzbeK);
        }
    }

    public Person getCurrentPerson(GoogleApiClient googleApiClient) {
        return Plus.zzf(googleApiClient, true).zzFa();
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, Collection<String> personIds) {
        return googleApiClient.zza(new C12794(this, googleApiClient, personIds));
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, String... personIds) {
        return googleApiClient.zza(new C12805(this, googleApiClient, personIds));
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<LoadPeopleResult> loadConnected(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new C12783(this, googleApiClient));
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, int orderBy, String pageToken) {
        return googleApiClient.zza(new C12761(this, googleApiClient, orderBy, pageToken));
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, String pageToken) {
        return googleApiClient.zza(new C12772(this, googleApiClient, pageToken));
    }
}
