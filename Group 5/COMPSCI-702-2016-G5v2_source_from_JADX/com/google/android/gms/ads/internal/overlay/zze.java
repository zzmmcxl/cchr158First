package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzne;

@zzhb
public class zze {
    public void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel) {
        zza(context, adOverlayInfoParcel, true);
    }

    public void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        if (adOverlayInfoParcel.zzEJ == 4 && adOverlayInfoParcel.zzEC == null) {
            if (adOverlayInfoParcel.zzEB != null) {
                adOverlayInfoParcel.zzEB.onAdClicked();
            }
            zzr.zzbz().zza(context, adOverlayInfoParcel.zzEA, adOverlayInfoParcel.zzEI);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.zzrl.zzNb);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        AdOverlayInfoParcel.zza(intent, adOverlayInfoParcel);
        if (!zzne.isAtLeastL()) {
            intent.addFlags(AccessibilityNodeInfoCompat.ACTION_COLLAPSE);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(DriveFile.MODE_READ_ONLY);
        }
        zzr.zzbC().zzb(context, intent);
    }
}
