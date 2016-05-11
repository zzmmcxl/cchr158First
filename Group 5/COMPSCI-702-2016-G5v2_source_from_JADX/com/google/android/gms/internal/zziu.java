package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Map;

@zzhb
public class zziu {
    private final Context mContext;
    private int mState;
    private final float zzDB;
    private String zzMh;
    private float zzMi;
    private float zzMj;
    private float zzMk;

    /* renamed from: com.google.android.gms.internal.zziu.1 */
    class C04561 implements OnClickListener {
        final /* synthetic */ String zzMl;
        final /* synthetic */ zziu zzMm;

        C04561(zziu com_google_android_gms_internal_zziu, String str) {
            this.zzMm = com_google_android_gms_internal_zziu;
            this.zzMl = str;
        }

        public void onClick(DialogInterface dialog, int which) {
            zzr.zzbC().zzb(this.zzMm.mContext, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", this.zzMl), "Share via"));
        }
    }

    /* renamed from: com.google.android.gms.internal.zziu.2 */
    class C04572 implements OnClickListener {
        final /* synthetic */ zziu zzMm;

        C04572(zziu com_google_android_gms_internal_zziu) {
            this.zzMm = com_google_android_gms_internal_zziu;
        }

        public void onClick(DialogInterface dialog, int which) {
        }
    }

    public zziu(Context context) {
        this.mState = 0;
        this.mContext = context;
        this.zzDB = context.getResources().getDisplayMetrics().density;
    }

    public zziu(Context context, String str) {
        this(context);
        this.zzMh = str;
    }

    private void showDialog() {
        if (this.mContext instanceof Activity) {
            Object zzaG = zzaG(this.zzMh);
            Builder builder = new Builder(this.mContext);
            builder.setMessage(zzaG);
            builder.setTitle("Ad Information");
            builder.setPositiveButton("Share", new C04561(this, zzaG));
            builder.setNegativeButton("Close", new C04572(this));
            builder.create().show();
            return;
        }
        zzb.zzaJ("Can not create dialog without Activity Context");
    }

    static String zzaG(String str) {
        if (TextUtils.isEmpty(str)) {
            return "No debug information";
        }
        Uri build = new Uri.Builder().encodedQuery(str.replaceAll("\\+", "%20")).build();
        StringBuilder stringBuilder = new StringBuilder();
        Map zze = zzr.zzbC().zze(build);
        for (String str2 : zze.keySet()) {
            stringBuilder.append(str2).append(" = ").append((String) zze.get(str2)).append("\n\n");
        }
        Object trim = stringBuilder.toString().trim();
        return TextUtils.isEmpty(trim) ? "No debug information" : trim;
    }

    void zza(int i, float f, float f2) {
        if (i == 0) {
            this.mState = 0;
            this.zzMi = f;
            this.zzMj = f2;
            this.zzMk = f2;
        } else if (this.mState == -1) {
        } else {
            if (i == 2) {
                if (f2 > this.zzMj) {
                    this.zzMj = f2;
                } else if (f2 < this.zzMk) {
                    this.zzMk = f2;
                }
                if (this.zzMj - this.zzMk > BitmapDescriptorFactory.HUE_ORANGE * this.zzDB) {
                    this.mState = -1;
                    return;
                }
                if (this.mState == 0 || this.mState == 2) {
                    if (f - this.zzMi >= 50.0f * this.zzDB) {
                        this.zzMi = f;
                        this.mState++;
                    }
                } else if ((this.mState == 1 || this.mState == 3) && f - this.zzMi <= -50.0f * this.zzDB) {
                    this.zzMi = f;
                    this.mState++;
                }
                if (this.mState == 1 || this.mState == 3) {
                    if (f > this.zzMi) {
                        this.zzMi = f;
                    }
                } else if (this.mState == 2 && f < this.zzMi) {
                    this.zzMi = f;
                }
            } else if (i == 1 && this.mState == 4) {
                showDialog();
            }
        }
    }

    public void zzaF(String str) {
        this.zzMh = str;
    }

    public void zze(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            zza(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        zza(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }
}
