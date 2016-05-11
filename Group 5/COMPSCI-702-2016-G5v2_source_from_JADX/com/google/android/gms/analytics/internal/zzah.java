package com.google.android.gms.analytics.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.vision.barcode.Barcode;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.zip.GZIPOutputStream;

class zzah extends zzd {
    private static final byte[] zzTd;
    private final zzaj zzTc;
    private final String zzzN;

    private class zza {
        private int zzTe;
        private ByteArrayOutputStream zzTf;
        final /* synthetic */ zzah zzTg;

        public zza(zzah com_google_android_gms_analytics_internal_zzah) {
            this.zzTg = com_google_android_gms_analytics_internal_zzah;
            this.zzTf = new ByteArrayOutputStream();
        }

        public byte[] getPayload() {
            return this.zzTf.toByteArray();
        }

        public boolean zzj(zzab com_google_android_gms_analytics_internal_zzab) {
            zzx.zzz(com_google_android_gms_analytics_internal_zzab);
            if (this.zzTe + 1 > this.zzTg.zzjn().zzkD()) {
                return false;
            }
            String zza = this.zzTg.zza(com_google_android_gms_analytics_internal_zzab, false);
            if (zza == null) {
                this.zzTg.zzjm().zza(com_google_android_gms_analytics_internal_zzab, "Error formatting hit");
                return true;
            }
            byte[] bytes = zza.getBytes();
            int length = bytes.length;
            if (length > this.zzTg.zzjn().zzkv()) {
                this.zzTg.zzjm().zza(com_google_android_gms_analytics_internal_zzab, "Hit size exceeds the maximum size limit");
                return true;
            }
            if (this.zzTf.size() > 0) {
                length++;
            }
            if (length + this.zzTf.size() > this.zzTg.zzjn().zzkx()) {
                return false;
            }
            try {
                if (this.zzTf.size() > 0) {
                    this.zzTf.write(zzah.zzTd);
                }
                this.zzTf.write(bytes);
                this.zzTe++;
                return true;
            } catch (IOException e) {
                this.zzTg.zze("Failed to write payload when batching hits", e);
                return true;
            }
        }

        public int zzlE() {
            return this.zzTe;
        }
    }

    static {
        zzTd = "\n".getBytes();
    }

    zzah(zzf com_google_android_gms_analytics_internal_zzf) {
        super(com_google_android_gms_analytics_internal_zzf);
        this.zzzN = zza("GoogleAnalytics", zze.VERSION, VERSION.RELEASE, zzam.zza(Locale.getDefault()), Build.MODEL, Build.ID);
        this.zzTc = new zzaj(com_google_android_gms_analytics_internal_zzf.zzjl());
    }

    private int zza(URL url, byte[] bArr) {
        HttpURLConnection zzc;
        int responseCode;
        Object e;
        Throwable th;
        OutputStream outputStream = null;
        zzx.zzz(url);
        zzx.zzz(bArr);
        zzb("POST bytes, url", Integer.valueOf(bArr.length), url);
        if (zzhp()) {
            zza("Post payload\n", new String(bArr));
        }
        try {
            zzc = zzc(url);
            try {
                zzc.setDoOutput(true);
                zzc.setFixedLengthStreamingMode(bArr.length);
                zzc.connect();
                outputStream = zzc.getOutputStream();
                outputStream.write(bArr);
                zzb(zzc);
                responseCode = zzc.getResponseCode();
                if (responseCode == Callback.DEFAULT_DRAG_ANIMATION_DURATION) {
                    zziH().zzjh();
                }
                zzb("POST status", Integer.valueOf(responseCode));
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e2) {
                        zze("Error closing http post connection output stream", e2);
                    }
                }
                if (zzc != null) {
                    zzc.disconnect();
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    zzd("Network POST connection error", e);
                    responseCode = 0;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e22) {
                            zze("Error closing http post connection output stream", e22);
                        }
                    }
                    if (zzc != null) {
                        zzc.disconnect();
                    }
                    return responseCode;
                } catch (Throwable th2) {
                    th = th2;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e222) {
                            zze("Error closing http post connection output stream", e222);
                        }
                    }
                    if (zzc != null) {
                        zzc.disconnect();
                    }
                    throw th;
                }
            }
        } catch (IOException e4) {
            e = e4;
            zzc = outputStream;
            zzd("Network POST connection error", e);
            responseCode = 0;
            if (outputStream != null) {
                outputStream.close();
            }
            if (zzc != null) {
                zzc.disconnect();
            }
            return responseCode;
        } catch (Throwable th3) {
            th = th3;
            zzc = outputStream;
            if (outputStream != null) {
                outputStream.close();
            }
            if (zzc != null) {
                zzc.disconnect();
            }
            throw th;
        }
        return responseCode;
    }

    private static String zza(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    private void zza(StringBuilder stringBuilder, String str, String str2) throws UnsupportedEncodingException {
        if (stringBuilder.length() != 0) {
            stringBuilder.append('&');
        }
        stringBuilder.append(URLEncoder.encode(str, "UTF-8"));
        stringBuilder.append('=');
        stringBuilder.append(URLEncoder.encode(str2, "UTF-8"));
    }

    private int zzb(URL url) {
        int responseCode;
        zzx.zzz(url);
        zzb("GET request", url);
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = zzc(url);
            httpURLConnection.connect();
            zzb(httpURLConnection);
            responseCode = httpURLConnection.getResponseCode();
            if (responseCode == Callback.DEFAULT_DRAG_ANIMATION_DURATION) {
                zziH().zzjh();
            }
            zzb("GET status", Integer.valueOf(responseCode));
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (IOException e) {
            zzd("Network GET connection error", e);
            responseCode = 0;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return responseCode;
    }

    private int zzb(URL url, byte[] bArr) {
        HttpURLConnection zzc;
        OutputStream outputStream;
        Object e;
        HttpURLConnection httpURLConnection;
        int i;
        Throwable th;
        OutputStream outputStream2 = null;
        zzx.zzz(url);
        zzx.zzz(bArr);
        try {
            byte[] zzg = zzg(bArr);
            zza("POST compressed size, ratio %, url", Integer.valueOf(zzg.length), Long.valueOf((100 * ((long) zzg.length)) / ((long) bArr.length)), url);
            if (zzg.length > bArr.length) {
                zzc("Compressed payload is larger then uncompressed. compressed, uncompressed", Integer.valueOf(zzg.length), Integer.valueOf(bArr.length));
            }
            if (zzhp()) {
                zza("Post payload", "\n" + new String(bArr));
            }
            zzc = zzc(url);
            try {
                zzc.setDoOutput(true);
                zzc.addRequestProperty("Content-Encoding", "gzip");
                zzc.setFixedLengthStreamingMode(zzg.length);
                zzc.connect();
                outputStream = zzc.getOutputStream();
            } catch (IOException e2) {
                e = e2;
                httpURLConnection = zzc;
                try {
                    zzd("Network compressed POST connection error", e);
                    i = 0;
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (IOException e3) {
                            zze("Error closing http compressed post connection output stream", e3);
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return i;
                } catch (Throwable th2) {
                    th = th2;
                    zzc = httpURLConnection;
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (IOException e32) {
                            zze("Error closing http compressed post connection output stream", e32);
                        }
                    }
                    if (zzc != null) {
                        zzc.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (outputStream2 != null) {
                    outputStream2.close();
                }
                if (zzc != null) {
                    zzc.disconnect();
                }
                throw th;
            }
            try {
                outputStream.write(zzg);
                outputStream.close();
                outputStream = null;
                zzb(zzc);
                i = zzc.getResponseCode();
                if (i == Callback.DEFAULT_DRAG_ANIMATION_DURATION) {
                    zziH().zzjh();
                }
                zzb("POST status", Integer.valueOf(i));
                if (null != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e322) {
                        zze("Error closing http compressed post connection output stream", e322);
                    }
                }
                if (zzc != null) {
                    zzc.disconnect();
                }
            } catch (IOException e4) {
                e = e4;
                outputStream2 = outputStream;
                httpURLConnection = zzc;
                zzd("Network compressed POST connection error", e);
                i = 0;
                if (outputStream2 != null) {
                    outputStream2.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return i;
            } catch (Throwable th4) {
                th = th4;
                outputStream2 = outputStream;
                if (outputStream2 != null) {
                    outputStream2.close();
                }
                if (zzc != null) {
                    zzc.disconnect();
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            httpURLConnection = null;
            zzd("Network compressed POST connection error", e);
            i = 0;
            if (outputStream2 != null) {
                outputStream2.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return i;
        } catch (Throwable th5) {
            th = th5;
            zzc = null;
            if (outputStream2 != null) {
                outputStream2.close();
            }
            if (zzc != null) {
                zzc.disconnect();
            }
            throw th;
        }
        return i;
    }

    private URL zzb(zzab com_google_android_gms_analytics_internal_zzab, String str) {
        try {
            return new URL(com_google_android_gms_analytics_internal_zzab.zzlt() ? zzjn().zzkF() + zzjn().zzkH() + "?" + str : zzjn().zzkG() + zzjn().zzkH() + "?" + str);
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private void zzb(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            do {
            } while (inputStream.read(new byte[Barcode.UPC_E]) > 0);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    zze("Error closing http connection input stream", e);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    zze("Error closing http connection input stream", e2);
                }
            }
        }
    }

    private boolean zzg(zzab com_google_android_gms_analytics_internal_zzab) {
        zzx.zzz(com_google_android_gms_analytics_internal_zzab);
        String zza = zza(com_google_android_gms_analytics_internal_zzab, !com_google_android_gms_analytics_internal_zzab.zzlt());
        if (zza == null) {
            zzjm().zza(com_google_android_gms_analytics_internal_zzab, "Error formatting hit for upload");
            return true;
        } else if (zza.length() <= zzjn().zzku()) {
            URL zzb = zzb(com_google_android_gms_analytics_internal_zzab, zza);
            if (zzb != null) {
                return zzb(zzb) == Callback.DEFAULT_DRAG_ANIMATION_DURATION;
            } else {
                zzbh("Failed to build collect GET endpoint url");
                return false;
            }
        } else {
            zza = zza(com_google_android_gms_analytics_internal_zzab, false);
            if (zza == null) {
                zzjm().zza(com_google_android_gms_analytics_internal_zzab, "Error formatting hit for POST upload");
                return true;
            }
            byte[] bytes = zza.getBytes();
            if (bytes.length > zzjn().zzkw()) {
                zzjm().zza(com_google_android_gms_analytics_internal_zzab, "Hit payload exceeds size limit");
                return true;
            }
            URL zzh = zzh(com_google_android_gms_analytics_internal_zzab);
            if (zzh != null) {
                return zza(zzh, bytes) == Callback.DEFAULT_DRAG_ANIMATION_DURATION;
            } else {
                zzbh("Failed to build collect POST endpoint url");
                return false;
            }
        }
    }

    private static byte[] zzg(byte[] bArr) throws IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private URL zzh(zzab com_google_android_gms_analytics_internal_zzab) {
        try {
            return new URL(com_google_android_gms_analytics_internal_zzab.zzlt() ? zzjn().zzkF() + zzjn().zzkH() : zzjn().zzkG() + zzjn().zzkH());
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private String zzi(zzab com_google_android_gms_analytics_internal_zzab) {
        return String.valueOf(com_google_android_gms_analytics_internal_zzab.zzlq());
    }

    private URL zzlC() {
        try {
            return new URL(zzjn().zzkF() + zzjn().zzkI());
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    String zza(zzab com_google_android_gms_analytics_internal_zzab, boolean z) {
        zzx.zzz(com_google_android_gms_analytics_internal_zzab);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (Entry entry : com_google_android_gms_analytics_internal_zzab.zzn().entrySet()) {
                String str = (String) entry.getKey();
                if (!("ht".equals(str) || "qt".equals(str) || "AppUID".equals(str) || "z".equals(str) || "_gmsv".equals(str))) {
                    zza(stringBuilder, str, (String) entry.getValue());
                }
            }
            zza(stringBuilder, "ht", String.valueOf(com_google_android_gms_analytics_internal_zzab.zzlr()));
            zza(stringBuilder, "qt", String.valueOf(zzjl().currentTimeMillis() - com_google_android_gms_analytics_internal_zzab.zzlr()));
            if (zzjn().zzkr()) {
                zza(stringBuilder, "_gmsv", zze.VERSION);
            }
            if (z) {
                long zzlu = com_google_android_gms_analytics_internal_zzab.zzlu();
                zza(stringBuilder, "z", zzlu != 0 ? String.valueOf(zzlu) : zzi(com_google_android_gms_analytics_internal_zzab));
            }
            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            zze("Failed to encode name or value", e);
            return null;
        }
    }

    List<Long> zza(List<zzab> list, boolean z) {
        zzx.zzac(!list.isEmpty());
        zza("Uploading batched hits. compression, count", Boolean.valueOf(z), Integer.valueOf(list.size()));
        zza com_google_android_gms_analytics_internal_zzah_zza = new zza(this);
        List<Long> arrayList = new ArrayList();
        for (zzab com_google_android_gms_analytics_internal_zzab : list) {
            if (!com_google_android_gms_analytics_internal_zzah_zza.zzj(com_google_android_gms_analytics_internal_zzab)) {
                break;
            }
            arrayList.add(Long.valueOf(com_google_android_gms_analytics_internal_zzab.zzlq()));
        }
        if (com_google_android_gms_analytics_internal_zzah_zza.zzlE() == 0) {
            return arrayList;
        }
        URL zzlC = zzlC();
        if (zzlC == null) {
            zzbh("Failed to build batching endpoint url");
            return Collections.emptyList();
        }
        int zzb = z ? zzb(zzlC, com_google_android_gms_analytics_internal_zzah_zza.getPayload()) : zza(zzlC, com_google_android_gms_analytics_internal_zzah_zza.getPayload());
        if (Callback.DEFAULT_DRAG_ANIMATION_DURATION == zzb) {
            zza("Batched upload completed. Hits batched", Integer.valueOf(com_google_android_gms_analytics_internal_zzah_zza.zzlE()));
            return arrayList;
        }
        zza("Network error uploading hits. status code", Integer.valueOf(zzb));
        if (zzjn().zzkL().contains(Integer.valueOf(zzb))) {
            zzbg("Server instructed the client to stop batching");
            this.zzTc.start();
        }
        return Collections.emptyList();
    }

    HttpURLConnection zzc(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(zzjn().zzkU());
            httpURLConnection.setReadTimeout(zzjn().zzkV());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty("User-Agent", this.zzzN);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain http connection");
    }

    protected void zziJ() {
        zza("Network initialized. User agent", this.zzzN);
    }

    public boolean zzlB() {
        NetworkInfo activeNetworkInfo;
        zzjk();
        zzjv();
        try {
            activeNetworkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzbd("No network connectivity");
        return false;
    }

    public List<Long> zzq(List<zzab> list) {
        boolean z;
        boolean z2 = true;
        zzjk();
        zzjv();
        zzx.zzz(list);
        if (zzjn().zzkL().isEmpty() || !this.zzTc.zzv(zzjn().zzkE() * 1000)) {
            z2 = false;
            z = false;
        } else {
            z = zzjn().zzkJ() != zzm.NONE;
            if (zzjn().zzkK() != zzo.GZIP) {
                z2 = false;
            }
        }
        return z ? zza((List) list, z2) : zzr(list);
    }

    List<Long> zzr(List<zzab> list) {
        List<Long> arrayList = new ArrayList(list.size());
        for (zzab com_google_android_gms_analytics_internal_zzab : list) {
            if (!zzg(com_google_android_gms_analytics_internal_zzab)) {
                break;
            }
            arrayList.add(Long.valueOf(com_google_android_gms_analytics_internal_zzab.zzlq()));
            if (arrayList.size() >= zzjn().zzkC()) {
                break;
            }
        }
        return arrayList;
    }
}
