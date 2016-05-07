/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.b.bo;
import com.google.android.gms.b.fk;
import com.google.android.gms.b.hz;
import com.google.android.gms.b.ia;
import com.google.android.gms.b.iq;
import com.google.android.gms.b.jk;
import com.google.android.gms.b.jl;
import com.google.android.gms.b.kt;
import com.google.android.gms.b.l;
import com.google.android.gms.b.lt;
import com.google.android.gms.b.me;
import com.google.android.gms.b.mf;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class hy
implements Comparable {
    private final mf a;
    private final int b;
    private final String c;
    private final int d;
    private final jl e;
    private Integer f;
    private iq g;
    private boolean h;
    private boolean i;
    private boolean j;
    private long k;
    private kt l;
    private l m;

    public hy(int n2, String string, jl jl2) {
        mf mf2 = mf.a ? new mf() : null;
        this.a = mf2;
        this.h = true;
        this.i = false;
        this.j = false;
        this.k = 0;
        this.m = null;
        this.b = n2;
        this.c = string;
        this.e = jl2;
        this.a(new bo());
        this.d = hy.a(string);
    }

    private static int a(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) return 0;
        Uri uri = Uri.parse((String)string);
        if (uri == null) return 0;
        String string2 = uri.getHost();
        if (string2 == null) return 0;
        return string2.hashCode();
    }

    private byte[] a(Map map, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = iterator.next();
                stringBuilder.append(URLEncoder.encode((String)entry.getKey(), string));
                stringBuilder.append('=');
                stringBuilder.append(URLEncoder.encode((String)entry.getValue(), string));
                stringBuilder.append('&');
            }
            return stringBuilder.toString().getBytes(string);
        }
        catch (UnsupportedEncodingException var4_6) {
            throw new RuntimeException("Encoding not supported: " + string, var4_6);
        }
    }

    static /* synthetic */ mf b(hy hy2) {
        return hy2.a;
    }

    public int a(hy hy2) {
        ia ia2;
        ia ia3 = this.q();
        if (ia3 != (ia2 = hy2.q())) return ia2.ordinal() - ia3.ordinal();
        return this.f - hy2.f;
    }

    public final hy a(int n2) {
        this.f = n2;
        return this;
    }

    public hy a(iq iq2) {
        this.g = iq2;
        return this;
    }

    public hy a(kt kt2) {
        this.l = kt2;
        return this;
    }

    public hy a(l l2) {
        this.m = l2;
        return this;
    }

    protected abstract jk a(fk var1);

    protected lt a(lt lt2) {
        return lt2;
    }

    public Map a() {
        return Collections.emptyMap();
    }

    protected abstract void a(Object var1);

    public int b() {
        return this.b;
    }

    public void b(lt lt2) {
        if (this.e == null) return;
        this.e.a(lt2);
    }

    public void b(String string) {
        if (mf.a) {
            this.a.a(string, Thread.currentThread().getId());
            return;
        }
        if (this.k != 0) return;
        this.k = SystemClock.elapsedRealtime();
    }

    public int c() {
        return this.d;
    }

    void c(String string) {
        if (this.g != null) {
            this.g.b(this);
        }
        if (!mf.a) {
            long l2 = SystemClock.elapsedRealtime() - this.k;
            if (l2 < 3000) return;
            Object[] arrobject = new Object[]{l2, this.toString()};
            me.b("%d ms: %s", arrobject);
            return;
        }
        long l3 = Thread.currentThread().getId();
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post((Runnable)new hz(this, string, l3));
            return;
        }
        this.a.a(string, l3);
        this.a.a(this.toString());
    }

    public /* synthetic */ int compareTo(Object object) {
        return this.a((hy)object);
    }

    public String d() {
        return this.c;
    }

    public String e() {
        return this.d();
    }

    public l f() {
        return this.m;
    }

    public boolean g() {
        return this.i;
    }

    @Deprecated
    protected Map h() {
        return this.l();
    }

    @Deprecated
    protected String i() {
        return this.m();
    }

    @Deprecated
    public String j() {
        return this.n();
    }

    @Deprecated
    public byte[] k() {
        Map map = this.h();
        if (map == null) return null;
        if (map.size() <= 0) return null;
        return this.a(map, this.i());
    }

    protected Map l() {
        return null;
    }

    protected String m() {
        return "UTF-8";
    }

    public String n() {
        return "application/x-www-form-urlencoded; charset=" + this.m();
    }

    public byte[] o() {
        Map map = this.l();
        if (map == null) return null;
        if (map.size() <= 0) return null;
        return this.a(map, this.m());
    }

    public final boolean p() {
        return this.h;
    }

    public ia q() {
        return ia.b;
    }

    public final int r() {
        return this.l.a();
    }

    public kt s() {
        return this.l;
    }

    public void t() {
        this.j = true;
    }

    public String toString() {
        String string;
        String string2 = "0x" + Integer.toHexString(this.c());
        StringBuilder stringBuilder = new StringBuilder();
        if (this.i) {
            string = "[X] ";
            return stringBuilder.append(string).append(this.d()).append(" ").append(string2).append(" ").append((Object)((Object)this.q())).append(" ").append(this.f).toString();
        }
        string = "[ ] ";
        return stringBuilder.append(string).append(this.d()).append(" ").append(string2).append(" ").append((Object)((Object)this.q())).append(" ").append(this.f).toString();
    }

    public boolean u() {
        return this.j;
    }
}

