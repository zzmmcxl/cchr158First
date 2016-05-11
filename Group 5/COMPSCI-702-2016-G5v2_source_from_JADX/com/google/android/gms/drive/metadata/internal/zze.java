package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.zznm;
import com.google.android.gms.internal.zznn;
import com.google.android.gms.internal.zzno;
import com.google.android.gms.internal.zznq;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zze {
    private static final Map<String, MetadataField<?>> zzasO;
    private static final Map<String, zza> zzasP;

    public interface zza {
        void zzb(DataHolder dataHolder);

        String zztD();
    }

    static {
        zzasO = new HashMap();
        zzasP = new HashMap();
        zzb(zznm.zzasU);
        zzb(zznm.zzatA);
        zzb(zznm.zzatr);
        zzb(zznm.zzaty);
        zzb(zznm.zzatB);
        zzb(zznm.zzath);
        zzb(zznm.zzatg);
        zzb(zznm.zzati);
        zzb(zznm.zzatj);
        zzb(zznm.zzatk);
        zzb(zznm.zzate);
        zzb(zznm.zzatm);
        zzb(zznm.zzatn);
        zzb(zznm.zzato);
        zzb(zznm.zzatw);
        zzb(zznm.zzasV);
        zzb(zznm.zzatt);
        zzb(zznm.zzasX);
        zzb(zznm.zzatf);
        zzb(zznm.zzasY);
        zzb(zznm.zzasZ);
        zzb(zznm.zzata);
        zzb(zznm.zzatb);
        zzb(zznm.zzatq);
        zzb(zznm.zzatl);
        zzb(zznm.zzats);
        zzb(zznm.zzatu);
        zzb(zznm.zzatv);
        zzb(zznm.zzatx);
        zzb(zznm.zzatC);
        zzb(zznm.zzatD);
        zzb(zznm.zzatd);
        zzb(zznm.zzatc);
        zzb(zznm.zzatz);
        zzb(zznm.zzatp);
        zzb(zznm.zzasW);
        zzb(zznm.zzatE);
        zzb(zznm.zzatF);
        zzb(zznm.zzatG);
        zzb(zznm.zzatH);
        zzb(zznm.zzatI);
        zzb(zznm.zzatJ);
        zzb(zznm.zzatK);
        zzb(zzno.zzatM);
        zzb(zzno.zzatO);
        zzb(zzno.zzatP);
        zzb(zzno.zzatQ);
        zzb(zzno.zzatN);
        zzb(zzno.zzatR);
        zzb(zznq.zzatT);
        zzb(zznq.zzatU);
        zzm com_google_android_gms_drive_metadata_internal_zzm = zznm.zzatw;
        zza(zzm.zzasT);
        zza(zznn.zzatL);
    }

    public static void zza(DataHolder dataHolder) {
        for (zza zzb : zzasP.values()) {
            zzb.zzb(dataHolder);
        }
    }

    private static void zza(zza com_google_android_gms_drive_metadata_internal_zze_zza) {
        if (zzasP.put(com_google_android_gms_drive_metadata_internal_zze_zza.zztD(), com_google_android_gms_drive_metadata_internal_zze_zza) != null) {
            throw new IllegalStateException("A cleaner for key " + com_google_android_gms_drive_metadata_internal_zze_zza.zztD() + " has already been registered");
        }
    }

    private static void zzb(MetadataField<?> metadataField) {
        if (zzasO.containsKey(metadataField.getName())) {
            throw new IllegalArgumentException("Duplicate field name registered: " + metadataField.getName());
        }
        zzasO.put(metadataField.getName(), metadataField);
    }

    public static MetadataField<?> zzdc(String str) {
        return (MetadataField) zzasO.get(str);
    }

    public static Collection<MetadataField<?>> zztC() {
        return Collections.unmodifiableCollection(zzasO.values());
    }
}
