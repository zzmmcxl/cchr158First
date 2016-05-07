/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.support.v4.e.a;
import android.support.v7.widget.aa;
import android.support.v7.widget.ab;
import android.support.v7.widget.ac;
import android.support.v7.widget.ad;
import android.support.v7.widget.ae;
import android.support.v7.widget.af;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class z
extends DataSetObservable {
    private static final String a = z.class.getSimpleName();
    private static final Object b = new Object();
    private static final Map c = new HashMap();
    private final Object d;
    private final List e;
    private final List f;
    private final Context g;
    private final String h;
    private Intent i;
    private ac j;
    private int k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private ae p;

    static /* synthetic */ Context a(z z2) {
        return z2.g;
    }

    private boolean a(ad ad2) {
        boolean bl2 = this.f.add(ad2);
        if (!bl2) return bl2;
        this.n = true;
        this.i();
        this.d();
        this.f();
        this.notifyChanged();
        return bl2;
    }

    static /* synthetic */ boolean a(z z2, boolean bl2) {
        z2.l = bl2;
        return bl2;
    }

    static /* synthetic */ String b(z z2) {
        return z2.h;
    }

    static /* synthetic */ String c() {
        return a;
    }

    private void d() {
        if (!this.m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (!this.n) {
            return;
        }
        this.n = false;
        if (TextUtils.isEmpty((CharSequence)this.h)) return;
        af af2 = new af(this, null);
        Object[] arrobject = new Object[]{new ArrayList(this.f), this.h};
        a.a(af2, arrobject);
    }

    private void e() {
        boolean bl2 = this.g() | this.h();
        this.i();
        if (!bl2) return;
        this.f();
        this.notifyChanged();
    }

    private boolean f() {
        if (this.j == null) return false;
        if (this.i == null) return false;
        if (this.e.isEmpty()) return false;
        if (this.f.isEmpty()) return false;
        this.j.a(this.i, this.e, Collections.unmodifiableList(this.f));
        return true;
    }

    private boolean g() {
        boolean bl2 = this.o;
        boolean bl3 = false;
        if (!bl2) return bl3;
        Intent intent = this.i;
        bl3 = false;
        if (intent == null) return bl3;
        this.o = false;
        this.e.clear();
        List list = this.g.getPackageManager().queryIntentActivities(this.i, 0);
        int n2 = list.size();
        int n3 = 0;
        while (n3 < n2) {
            ResolveInfo resolveInfo = (ResolveInfo)list.get(n3);
            this.e.add(new ab(this, resolveInfo));
            ++n3;
        }
        return true;
    }

    private boolean h() {
        if (!this.l) return false;
        if (!this.n) return false;
        if (TextUtils.isEmpty((CharSequence)this.h)) return false;
        this.l = false;
        this.m = true;
        this.j();
        return true;
    }

    private void i() {
        int n2 = this.f.size() - this.k;
        if (n2 <= 0) {
            return;
        }
        this.n = true;
        int n3 = 0;
        while (n3 < n2) {
            (ad)this.f.remove(0);
            ++n3;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private void j() {
        var2_1 = this.g.openFileInput(this.h);
        try {
            var11_2 = Xml.newPullParser();
            var11_2.setInput((InputStream)var2_1, "UTF-8");
            var12_3 = 0;
            while (var12_3 != 1 && var12_3 != 2) {
                var12_3 = var11_2.next();
            }
            if (!"historical-records".equals(var11_2.getName())) {
                throw new XmlPullParserException("Share records file does not start with historical-records tag.");
            }
            var13_5 = this.f;
            var13_5.clear();
            ** GOTO lbl26
            catch (FileNotFoundException var1_13) {
                return;
            }
            {
                catch (XmlPullParserException var8_4) {
                    Log.e((String)z.a, (String)("Error reading historical recrod file: " + this.h), (Throwable)var8_4);
                    if (var2_1 == null) return;
                    try {
                        var2_1.close();
                        return;
                    }
                    catch (IOException var10_11) {
                        return;
                    }
                }
lbl26: // 1 sources:
                do {
                    if ((var14_6 = var11_2.next()) == 1) {
                        if (var2_1 == null) return;
                        try {
                            var2_1.close();
                            return;
                        }
                        catch (IOException var16_7) {
                            return;
                        }
                    }
                    if (var14_6 == 3 || var14_6 == 4) continue;
                    ** try [egrp 6[TRYBLOCK] [21 : 173->231)] { 
lbl37: // 2 sources:
                    if ("historical-record".equals(var11_2.getName())) ** break block23
                    throw new XmlPullParserException("Share records file not well-formed.");
                    break;
                } while (true);
                catch (IOException var5_8) {
                    Log.e((String)z.a, (String)("Error reading historical recrod file: " + this.h), (Throwable)var5_8);
                    if (var2_1 == null) return;
                    try {
                        var2_1.close();
                        return;
                    }
                    catch (IOException var7_9) {
                        return;
                    }
                }
                {
                    
                    var13_5.add(new ad(var11_2.getAttributeValue(null, "activity"), Long.parseLong(var11_2.getAttributeValue(null, "time")), Float.parseFloat(var11_2.getAttributeValue(null, "weight"))));
                    continue;
                }
            }
        }
lbl51: // 3 sources:
        catch (Throwable var3_10) {
            if (var2_1 == null) throw var3_10;
            try {
                var2_1.close();
            }
            catch (IOException var4_12) {
                throw var3_10;
            }
            throw var3_10;
        }
    }

    public int a() {
        Object object = this.d;
        // MONITORENTER : object
        this.e();
        int n2 = this.e.size();
        // MONITOREXIT : object
        return n2;
    }

    public int a(ResolveInfo resolveInfo) {
        Object object = this.d;
        // MONITORENTER : object
        this.e();
        List list = this.e;
        int n2 = list.size();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                // MONITOREXIT : object
                return -1;
            }
            if (((ab)list.get((int)n3)).a == resolveInfo) {
                // MONITOREXIT : object
                return n3;
            }
            ++n3;
        } while (true);
    }

    public ResolveInfo a(int n2) {
        Object object = this.d;
        // MONITORENTER : object
        this.e();
        ResolveInfo resolveInfo = ((ab)this.e.get((int)n2)).a;
        // MONITOREXIT : object
        return resolveInfo;
    }

    public Intent b(int n2) {
        Intent intent;
        Object object = this.d;
        // MONITORENTER : object
        if (this.i == null) {
            // MONITOREXIT : object
            return null;
        }
        this.e();
        ab ab2 = (ab)this.e.get(n2);
        ComponentName componentName = new ComponentName(ab2.a.activityInfo.packageName, ab2.a.activityInfo.name);
        Intent intent2 = new Intent(this.i);
        intent2.setComponent(componentName);
        if (this.p != null && this.p.a(this, intent = new Intent(intent2))) {
            // MONITOREXIT : object
            return null;
        }
        this.a(new ad(componentName, System.currentTimeMillis(), 1.0f));
        // MONITOREXIT : object
        return intent2;
    }

    public ResolveInfo b() {
        Object object = this.d;
        // MONITORENTER : object
        this.e();
        if (!this.e.isEmpty()) {
            ResolveInfo resolveInfo = ((ab)this.e.get((int)0)).a;
            // MONITOREXIT : object
            return resolveInfo;
        }
        // MONITOREXIT : object
        return null;
    }

    public void c(int n2) {
        Object object = this.d;
        // MONITORENTER : object
        this.e();
        ab ab2 = (ab)this.e.get(n2);
        ab ab3 = (ab)this.e.get(0);
        float f2 = ab3 != null ? 5.0f + (ab3.b - ab2.b) : 1.0f;
        this.a(new ad(new ComponentName(ab2.a.activityInfo.packageName, ab2.a.activityInfo.name), System.currentTimeMillis(), f2));
        // MONITOREXIT : object
        return;
    }
}

