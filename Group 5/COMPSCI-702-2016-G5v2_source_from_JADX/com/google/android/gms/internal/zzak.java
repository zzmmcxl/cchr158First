package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.ads.afma.nano.NanoAfmaSignals.AFMASignals;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

public abstract class zzak implements zzaj {
    protected static GoogleApiClient zznG;
    protected long zznA;
    protected long zznB;
    protected long zznC;
    private boolean zznD;
    protected DisplayMetrics zznE;
    protected zzap zznF;
    protected MotionEvent zznx;
    protected LinkedList<MotionEvent> zzny;
    protected long zznz;

    protected zzak(Context context, zzap com_google_android_gms_internal_zzap) {
        this.zzny = new LinkedList();
        this.zznz = 0;
        this.zznA = 0;
        this.zznB = 0;
        this.zznC = 0;
        this.zznD = false;
        this.zznF = com_google_android_gms_internal_zzap;
        try {
            this.zznE = context.getResources().getDisplayMetrics();
        } catch (UnsupportedOperationException e) {
            this.zznE = new DisplayMetrics();
            this.zznE.density = TextTrackStyle.DEFAULT_FONT_SCALE;
        }
    }

    private String zza(Context context, String str, boolean z) {
        AFMASignals zzd;
        if (z) {
            try {
                zzd = zzd(context);
                this.zznD = true;
            } catch (NoSuchAlgorithmException e) {
                return Integer.toString(7);
            } catch (UnsupportedEncodingException e2) {
                return Integer.toString(7);
            } catch (IOException e3) {
                return Integer.toString(3);
            }
        }
        zzd = zzc(context);
        return (zzd == null || zzd.getSerializedSize() == 0) ? Integer.toString(5) : zza(zzd, str);
    }

    protected String zza(AFMASignals aFMASignals, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
        return zza(zzsu.toByteArray(aFMASignals), str);
    }

    String zza(byte[] bArr, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
        byte[] bArr2;
        if (bArr.length > 239) {
            zzsu aFMASignals = new AFMASignals();
            aFMASignals.psnSignal = Long.valueOf(1);
            bArr = zzsu.toByteArray(aFMASignals);
        }
        if (bArr.length < 239) {
            bArr2 = new byte[(239 - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            bArr2 = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            bArr2 = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).array();
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(bArr2);
        bArr2 = ByteBuffer.allocate(Barcode.QR_CODE).put(instance.digest()).put(bArr2).array();
        byte[] bArr3 = new byte[Barcode.QR_CODE];
        new zzai().zzb(bArr2, bArr3);
        if (str != null && str.length() > 0) {
            zza(str, bArr3);
        }
        return this.zznF.zza(bArr3, true);
    }

    public void zza(int i, int i2, int i3) {
        if (this.zznx != null) {
            this.zznx.recycle();
        }
        this.zznx = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * this.zznE.density, ((float) i2) * this.zznE.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
    }

    public void zza(MotionEvent motionEvent) {
        if (this.zznD) {
            this.zznC = 0;
            this.zznB = 0;
            this.zznA = 0;
            this.zznz = 0;
            Iterator it = this.zzny.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            this.zzny.clear();
            this.zznx = null;
            this.zznD = false;
        }
        switch (motionEvent.getAction()) {
            case Barcode.ALL_FORMATS /*0*/:
                this.zznz++;
            case CompletionEvent.STATUS_FAILURE /*1*/:
                this.zznx = MotionEvent.obtain(motionEvent);
                this.zzny.add(this.zznx);
                if (this.zzny.size() > 6) {
                    ((MotionEvent) this.zzny.remove()).recycle();
                }
                this.zznB++;
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                this.zznA += (long) (motionEvent.getHistorySize() + 1);
            case CompletionEvent.STATUS_CANCELED /*3*/:
                this.zznC++;
            default:
        }
    }

    void zza(String str, byte[] bArr) throws UnsupportedEncodingException {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        new zzsl(str.getBytes("UTF-8")).zzC(bArr);
    }

    public String zzb(Context context) {
        return zza(context, null, false);
    }

    public String zzb(Context context, String str) {
        return zza(context, str, true);
    }

    protected abstract AFMASignals zzc(Context context);

    protected abstract AFMASignals zzd(Context context);

    protected String zzk(String str) {
        if (str == null || !str.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            return str;
        }
        UUID fromString = UUID.fromString(str);
        byte[] bArr = new byte[16];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.putLong(fromString.getMostSignificantBits());
        wrap.putLong(fromString.getLeastSignificantBits());
        return this.zznF.zza(bArr, true);
    }
}
