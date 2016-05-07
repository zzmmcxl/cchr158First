/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.b.kf;
import com.google.android.gms.b.lm;
import com.google.android.gms.b.ln;
import com.google.android.gms.b.lo;
import com.google.android.gms.b.lp;
import com.google.android.gms.b.lq;
import com.google.android.gms.b.lr;
import com.google.android.gms.b.ls;
import com.google.android.gms.b.mi;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.measurement.internal.ai;
import com.google.android.gms.measurement.internal.aj;
import com.google.android.gms.measurement.internal.ak;
import com.google.android.gms.measurement.internal.aq;
import com.google.android.gms.measurement.internal.ba;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.bn;
import com.google.android.gms.measurement.internal.bs;
import com.google.android.gms.measurement.internal.bt;
import com.google.android.gms.measurement.internal.bx;
import com.google.android.gms.measurement.internal.ck;
import com.google.android.gms.measurement.internal.d;
import com.google.android.gms.measurement.internal.i;
import com.google.android.gms.measurement.internal.u;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class ag
extends ck {
    ag(bx bx2) {
        super(bx2);
    }

    private Object a(int n2, Object object, boolean bl2) {
        if (object == null) {
            return null;
        }
        if (object instanceof Long) return object;
        if (object instanceof Float) return object;
        if (object instanceof Integer) {
            return (long)((Integer)object);
        }
        if (object instanceof Byte) {
            return ((Byte)object).byteValue();
        }
        if (object instanceof Short) {
            return (long)((Short)object);
        }
        if (object instanceof Boolean) {
            long l2;
            if (((Boolean)object).booleanValue()) {
                l2 = 1;
                return l2;
            }
            l2 = 0;
            return l2;
        }
        if (object instanceof Double) {
            return Float.valueOf((float)((Double)object).doubleValue());
        }
        if (!(object instanceof String) && !(object instanceof Character)) {
            if (!(object instanceof CharSequence)) return null;
        }
        if ((object = String.valueOf(object)).length() <= n2) return object;
        if (!bl2) return null;
        return object.substring(0, n2);
    }

    private void a(String string, String string2, int n2, Object object) {
        String string3;
        if (object == null) {
            this.s().w().a(string + " value can't be null. Ignoring " + string, string2);
            return;
        }
        if (object instanceof Long) return;
        if (object instanceof Float) return;
        if (object instanceof Integer) return;
        if (object instanceof Byte) return;
        if (object instanceof Short) return;
        if (object instanceof Boolean) return;
        if (object instanceof Double) return;
        if (!(object instanceof String) && !(object instanceof Character)) {
            if (!(object instanceof CharSequence)) return;
        }
        if ((string3 = String.valueOf(object)).length() <= n2) return;
        this.s().w().a("Ignoring " + string + ". Value is too long. name, value length", string2, string3.length());
    }

    private static void a(StringBuilder stringBuilder, int n2) {
        int n3 = 0;
        while (n3 < n2) {
            stringBuilder.append("  ");
            ++n3;
        }
    }

    private static void a(StringBuilder stringBuilder, int n2, lq lq2) {
        if (lq2 == null) {
            return;
        }
        ag.a(stringBuilder, n2);
        stringBuilder.append("bundle {\n");
        ag.a(stringBuilder, n2, "protocol_version", lq2.a);
        ag.a(stringBuilder, n2, "platform", lq2.i);
        ag.a(stringBuilder, n2, "gmp_version", lq2.q);
        ag.a(stringBuilder, n2, "uploading_gmp_version", lq2.r);
        ag.a(stringBuilder, n2, "gmp_app_id", lq2.y);
        ag.a(stringBuilder, n2, "app_id", lq2.o);
        ag.a(stringBuilder, n2, "app_version", lq2.p);
        ag.a(stringBuilder, n2, "dev_cert_hash", lq2.v);
        ag.a(stringBuilder, n2, "app_store", lq2.n);
        ag.a(stringBuilder, n2, "upload_timestamp_millis", lq2.d);
        ag.a(stringBuilder, n2, "start_timestamp_millis", lq2.e);
        ag.a(stringBuilder, n2, "end_timestamp_millis", lq2.f);
        ag.a(stringBuilder, n2, "previous_bundle_start_timestamp_millis", lq2.g);
        ag.a(stringBuilder, n2, "previous_bundle_end_timestamp_millis", lq2.h);
        ag.a(stringBuilder, n2, "app_instance_id", lq2.u);
        ag.a(stringBuilder, n2, "resettable_device_id", lq2.s);
        ag.a(stringBuilder, n2, "limited_ad_tracking", lq2.t);
        ag.a(stringBuilder, n2, "os_version", lq2.j);
        ag.a(stringBuilder, n2, "device_model", lq2.k);
        ag.a(stringBuilder, n2, "user_default_language", lq2.l);
        ag.a(stringBuilder, n2, "time_zone_offset_minutes", lq2.m);
        ag.a(stringBuilder, n2, "bundle_sequential_index", lq2.w);
        ag.a(stringBuilder, n2, "service_upload", lq2.z);
        ag.a(stringBuilder, n2, "health_monitor", lq2.x);
        ag.a(stringBuilder, n2, lq2.c);
        ag.a(stringBuilder, n2, lq2.A);
        ag.a(stringBuilder, n2, lq2.b);
        ag.a(stringBuilder, n2);
        stringBuilder.append("}\n");
    }

    private static void a(StringBuilder stringBuilder, int n2, String string, lr lr2) {
        int n3 = 0;
        if (lr2 == null) {
            return;
        }
        int n4 = n2 + 1;
        ag.a(stringBuilder, n4);
        stringBuilder.append(string);
        stringBuilder.append(" {\n");
        if (lr2.b != null) {
            ag.a(stringBuilder, n4 + 1);
            stringBuilder.append("results: ");
            long[] arrl = lr2.b;
            int n5 = arrl.length;
            int n6 = 0;
            for (int i2 = 0; i2 < n5; ++i2) {
                Long l2 = arrl[i2];
                int n7 = n6 + 1;
                if (n6 != 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(l2);
                n6 = n7;
            }
            stringBuilder.append('\n');
        }
        if (lr2.a != null) {
            ag.a(stringBuilder, n4 + 1);
            stringBuilder.append("status: ");
            long[] arrl = lr2.a;
            int n8 = arrl.length;
            int n9 = 0;
            while (n3 < n8) {
                Long l3 = arrl[n3];
                int n10 = n9 + 1;
                if (n9 != 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(l3);
                ++n3;
                n9 = n10;
            }
            stringBuilder.append('\n');
        }
        ag.a(stringBuilder, n4);
        stringBuilder.append("}\n");
    }

    private static void a(StringBuilder stringBuilder, int n2, String string, Object object) {
        if (object == null) {
            return;
        }
        ag.a(stringBuilder, n2 + 1);
        stringBuilder.append(string);
        stringBuilder.append(": ");
        stringBuilder.append(object);
        stringBuilder.append('\n');
    }

    private static void a(StringBuilder stringBuilder, int n2, lm[] arrlm) {
        if (arrlm == null) {
            return;
        }
        int n3 = n2 + 1;
        int n4 = arrlm.length;
        int n5 = 0;
        while (n5 < n4) {
            lm lm2 = arrlm[n5];
            if (lm2 != null) {
                ag.a(stringBuilder, n3);
                stringBuilder.append("audience_membership {\n");
                ag.a(stringBuilder, n3, "audience_id", lm2.a);
                ag.a(stringBuilder, n3, "new_audience", lm2.d);
                ag.a(stringBuilder, n3, "current_data", lm2.b);
                ag.a(stringBuilder, n3, "previous_data", lm2.c);
                ag.a(stringBuilder, n3);
                stringBuilder.append("}\n");
            }
            ++n5;
        }
    }

    private static void a(StringBuilder stringBuilder, int n2, ln[] arrln) {
        if (arrln == null) {
            return;
        }
        int n3 = n2 + 1;
        int n4 = arrln.length;
        int n5 = 0;
        while (n5 < n4) {
            ln ln2 = arrln[n5];
            if (ln2 != null) {
                ag.a(stringBuilder, n3);
                stringBuilder.append("event {\n");
                ag.a(stringBuilder, n3, "name", ln2.b);
                ag.a(stringBuilder, n3, "timestamp_millis", ln2.c);
                ag.a(stringBuilder, n3, "previous_timestamp_millis", ln2.d);
                ag.a(stringBuilder, n3, "count", ln2.e);
                ag.a(stringBuilder, n3, ln2.a);
                ag.a(stringBuilder, n3);
                stringBuilder.append("}\n");
            }
            ++n5;
        }
    }

    private static void a(StringBuilder stringBuilder, int n2, lo[] arrlo) {
        if (arrlo == null) {
            return;
        }
        int n3 = n2 + 1;
        int n4 = arrlo.length;
        int n5 = 0;
        while (n5 < n4) {
            lo lo2 = arrlo[n5];
            if (lo2 != null) {
                ag.a(stringBuilder, n3);
                stringBuilder.append("event {\n");
                ag.a(stringBuilder, n3, "name", lo2.a);
                ag.a(stringBuilder, n3, "string_value", lo2.b);
                ag.a(stringBuilder, n3, "int_value", lo2.c);
                ag.a(stringBuilder, n3, "float_value", lo2.d);
                ag.a(stringBuilder, n3);
                stringBuilder.append("}\n");
            }
            ++n5;
        }
    }

    private static void a(StringBuilder stringBuilder, int n2, ls[] arrls) {
        if (arrls == null) {
            return;
        }
        int n3 = n2 + 1;
        int n4 = arrls.length;
        int n5 = 0;
        while (n5 < n4) {
            ls ls2 = arrls[n5];
            if (ls2 != null) {
                ag.a(stringBuilder, n3);
                stringBuilder.append("user_property {\n");
                ag.a(stringBuilder, n3, "set_timestamp_millis", ls2.a);
                ag.a(stringBuilder, n3, "name", ls2.b);
                ag.a(stringBuilder, n3, "string_value", ls2.c);
                ag.a(stringBuilder, n3, "int_value", ls2.d);
                ag.a(stringBuilder, n3, "float_value", ls2.e);
                ag.a(stringBuilder, n3);
                stringBuilder.append("}\n");
            }
            ++n5;
        }
    }

    public static boolean a(Context context, Class class_) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, class_), 4);
            if (serviceInfo == null) return false;
            boolean bl2 = serviceInfo.enabled;
            if (!bl2) return false;
            return true;
        }
        catch (PackageManager.NameNotFoundException var2_4) {
            // empty catch block
        }
        return false;
    }

    public static boolean a(Context context, Class class_, boolean bl2) {
        try {
            ActivityInfo activityInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, class_), 2);
            if (activityInfo == null) return false;
            if (!activityInfo.enabled) return false;
            if (!bl2) return true;
            boolean bl3 = activityInfo.exported;
            if (!bl3) return false;
            return true;
        }
        catch (PackageManager.NameNotFoundException var3_5) {
            // empty catch block
        }
        return false;
    }

    public static boolean a(Bundle bundle) {
        if (bundle.getLong("_c") != 1) return false;
        return true;
    }

    static boolean a(String string) {
        bf.a(string);
        char c2 = string.charAt(0);
        boolean bl2 = false;
        if (c2 == '_') return bl2;
        return true;
    }

    public static boolean a(String string, String string2) {
        if (string == null && string2 == null) {
            return true;
        }
        if (string != null) return string.equals(string2);
        return false;
    }

    public static boolean a(long[] arrl, int n2) {
        if (n2 >= 64 * arrl.length) {
            return false;
        }
        if ((arrl[n2 / 64] & 1 << n2 % 64) == 0) return false;
        return true;
    }

    public static long[] a(BitSet bitSet) {
        int n2 = (63 + bitSet.length()) / 64;
        long[] arrl = new long[n2];
        int n3 = 0;
        block0 : while (n3 < n2) {
            arrl[n3] = 0;
            int n4 = 0;
            do {
                if (n4 >= 64 || n4 + n3 * 64 >= bitSet.length()) {
                    ++n3;
                    continue block0;
                }
                if (bitSet.get(n4 + n3 * 64)) {
                    arrl[n3] = arrl[n3] | 1 << n4;
                }
                ++n4;
            } while (true);
            break;
        }
        return arrl;
    }

    public static String b(lp lp2) {
        if (lp2 == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nbatch {\n");
        if (lp2.a != null) {
            for (lq lq2 : lp2.a) {
                if (lq2 == null) continue;
                ag.a(stringBuilder, 1, lq2);
            }
        }
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    static long c(byte[] arrby) {
        int n2 = 0;
        bf.a(arrby);
        boolean bl2 = arrby.length > 0;
        bf.a(bl2);
        long l2 = 0;
        int n3 = -1 + arrby.length;
        while (n3 >= 0) {
            if (n3 < -8 + arrby.length) return l2;
            l2 += (255 & (long)arrby[n3]) << n2;
            n2 += 8;
            --n3;
        }
        return l2;
    }

    static MessageDigest e(String string) {
        int n2 = 0;
        while (n2 < 2) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(string);
                if (messageDigest != null) {
                    return messageDigest;
                }
            }
            catch (NoSuchAlgorithmException var2_2) {
                // empty catch block
            }
            ++n2;
        }
        return null;
    }

    public static boolean g(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) return false;
        if (!string.startsWith("_")) return false;
        return true;
    }

    private int h(String string) {
        if (!"_ldl".equals(string)) return this.u().y();
        return this.u().z();
    }

    public Object a(String string, Object object) {
        int n2;
        if (ag.g(string)) {
            n2 = this.u().x();
            return this.a(n2, object, false);
        }
        n2 = this.u().w();
        return this.a(n2, object, false);
    }

    public void a(Bundle bundle, String string, Object object) {
        if (object instanceof Long) {
            bundle.putLong(string, ((Long)object).longValue());
            return;
        }
        if (object instanceof Float) {
            bundle.putFloat(string, ((Float)object).floatValue());
            return;
        }
        if (object instanceof String) {
            bundle.putString(string, String.valueOf(object));
            return;
        }
        if (string == null) return;
        this.s().w().a("Not putting event parameter. Invalid value type. name, type", string, object.getClass().getSimpleName());
    }

    public void a(lo lo2, Object object) {
        bf.a(object);
        lo2.b = null;
        lo2.c = null;
        lo2.d = null;
        if (object instanceof String) {
            lo2.b = (String)object;
            return;
        }
        if (object instanceof Long) {
            lo2.c = (Long)object;
            return;
        }
        if (object instanceof Float) {
            lo2.d = (Float)object;
            return;
        }
        this.s().b().a("Ignoring invalid (type) event param value", object);
    }

    public void a(ls ls2, Object object) {
        bf.a(object);
        ls2.c = null;
        ls2.d = null;
        ls2.e = null;
        if (object instanceof String) {
            ls2.c = (String)object;
            return;
        }
        if (object instanceof Long) {
            ls2.d = (Long)object;
            return;
        }
        if (object instanceof Float) {
            ls2.e = (Float)object;
            return;
        }
        this.s().b().a("Ignoring invalid (type) user attribute value", object);
    }

    void a(String string, int n2, String string2) {
        if (string2 == null) {
            throw new IllegalArgumentException(string + " name is required and can't be null");
        }
        if (string2.length() == 0) {
            throw new IllegalArgumentException(string + " name is required and can't be empty");
        }
        char c2 = string2.charAt(0);
        if (!Character.isLetter(c2) && c2 != '_') {
            throw new IllegalArgumentException(string + " name must start with a letter or _");
        }
        int n3 = 1;
        do {
            if (n3 >= string2.length()) {
                if (string2.length() <= n2) return;
                throw new IllegalArgumentException(string + " name is too long. The maximum supported length is " + n2);
            }
            char c3 = string2.charAt(n3);
            if (c3 != '_' && !Character.isLetterOrDigit(c3)) {
                throw new IllegalArgumentException(string + " name must consist of letters, digits or _ (underscores)");
            }
            ++n3;
        } while (true);
    }

    public boolean a(long l2, long l3) {
        if (l2 == 0) return true;
        if (l3 <= 0) {
            return true;
        }
        if (Math.abs(this.l().a() - l2) > l3) return true;
        return false;
    }

    public byte[] a(lp lp2) {
        try {
            byte[] arrby = new byte[lp2.e()];
            mi mi2 = mi.a(arrby);
            lp2.a(mi2);
            mi2.b();
            return arrby;
        }
        catch (IOException var2_4) {
            this.s().b().a("Data loss. Failed to serialize batch", var2_4);
            return null;
        }
    }

    public byte[] a(byte[] arrby) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(arrby);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        }
        catch (IOException var4_5) {
            this.s().b().a("Failed to gzip content", var4_5);
            throw var4_5;
        }
    }

    public void b(String string) {
        this.a("event", this.u().c(), string);
    }

    public void b(String string, Object object) {
        if ("_ldl".equals(string)) {
            this.a("user attribute referrer", string, this.h(string), object);
            return;
        }
        this.a("user attribute", string, this.h(string), object);
    }

    public byte[] b(byte[] arrby) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrby);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] arrby2 = new byte[1024];
            do {
                int n2;
                if ((n2 = gZIPInputStream.read(arrby2)) <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(arrby2, 0, n2);
            } while (true);
        }
        catch (IOException var5_7) {
            this.s().b().a("Failed to ungzip content", var5_7);
            throw var5_7;
        }
    }

    public Object c(String string, Object object) {
        if (!"_ldl".equals(string)) return this.a(this.h(string), object, false);
        return this.a(this.h(string), object, true);
    }

    public void c(String string) {
        this.a("user attribute", this.u().v(), string);
    }

    public long d(byte[] arrby) {
        bf.a(arrby);
        MessageDigest messageDigest = ag.e("MD5");
        if (messageDigest != null) return ag.c(messageDigest.digest(arrby));
        this.s().b().a("Failed to get MD5");
        return 0;
    }

    public void d(String string) {
        this.a("event param", this.u().v(), string);
    }

    public boolean f(String string) {
        this.f();
        if (this.m().checkCallingOrSelfPermission(string) == 0) {
            return true;
        }
        this.s().y().a("Permission not granted", string);
        return false;
    }
}

