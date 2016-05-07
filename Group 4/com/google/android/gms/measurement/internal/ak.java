/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.support.v4.g.a;
import android.text.TextUtils;
import com.google.android.gms.b.kf;
import com.google.android.gms.b.la;
import com.google.android.gms.b.lb;
import com.google.android.gms.b.le;
import com.google.android.gms.b.ln;
import com.google.android.gms.b.lo;
import com.google.android.gms.b.lq;
import com.google.android.gms.b.lr;
import com.google.android.gms.b.mi;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.measurement.internal.EventParams;
import com.google.android.gms.measurement.internal.ac;
import com.google.android.gms.measurement.internal.af;
import com.google.android.gms.measurement.internal.ag;
import com.google.android.gms.measurement.internal.aj;
import com.google.android.gms.measurement.internal.al;
import com.google.android.gms.measurement.internal.am;
import com.google.android.gms.measurement.internal.an;
import com.google.android.gms.measurement.internal.ar;
import com.google.android.gms.measurement.internal.as;
import com.google.android.gms.measurement.internal.b;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.bn;
import com.google.android.gms.measurement.internal.bq;
import com.google.android.gms.measurement.internal.bx;
import com.google.android.gms.measurement.internal.cl;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class ak
extends cl {
    private static final Map a = new a(13);
    private final an b;
    private final ac c;

    static {
        a.put("app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;");
        a.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
        a.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
        a.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
        a.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
        a.put("last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;");
        a.put("day", "ALTER TABLE apps ADD COLUMN day INTEGER;");
        a.put("daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;");
        a.put("daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;");
        a.put("daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;");
        a.put("remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;");
        a.put("config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;");
        a.put("failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;");
    }

    ak(bx bx2) {
        super(bx2);
        this.c = new ac(this.l());
        String string = this.I();
        this.b = new an(this, this.m(), string);
    }

    static /* synthetic */ Map D() {
        return a;
    }

    private String I() {
        if (!this.u().N()) {
            return this.u().K();
        }
        if (this.u().O()) {
            return this.u().K();
        }
        this.s().v().a("Using secondary database");
        return this.u().L();
    }

    private boolean J() {
        return this.m().getDatabasePath(this.I()).exists();
    }

    @TargetApi(value=11)
    static int a(Cursor cursor, int n2) {
        int n3;
        if (Build.VERSION.SDK_INT >= 11) {
            return cursor.getType(n2);
        }
        CursorWindow cursorWindow = ((SQLiteCursor)cursor).getWindow();
        if (cursorWindow.isNull(n3 = cursor.getPosition(), n2)) {
            return 0;
        }
        if (cursorWindow.isLong(n3, n2)) {
            return 1;
        }
        if (cursorWindow.isFloat(n3, n2)) {
            return 2;
        }
        if (cursorWindow.isString(n3, n2)) {
            return 3;
        }
        if (!cursorWindow.isBlob(n3, n2)) return -1;
        return 4;
    }

    private long a(String string, String[] arrstring) {
        SQLiteDatabase sQLiteDatabase = this.w();
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery(string, arrstring);
            if (cursor.moveToFirst()) {
                long l2 = cursor.getLong(0);
                return l2;
            }
            throw new SQLiteException("Database returned empty set");
        }
        catch (SQLiteException var6_6) {
            this.s().b().a("Database error", string, (Object)var6_6);
            throw var6_6;
        }
        finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private long a(String string, String[] arrstring, long l2) {
        Cursor cursor;
        block4 : {
            SQLiteDatabase sQLiteDatabase = this.w();
            cursor = null;
            try {
                long l3;
                cursor = sQLiteDatabase.rawQuery(string, arrstring);
                if (!cursor.moveToFirst()) break block4;
                l2 = l3 = cursor.getLong(0);
                if (cursor == null) return l2;
            }
            catch (SQLiteException var8_7) {
                try {
                    this.s().b().a("Database error", string, (Object)var8_7);
                    throw var8_7;
                }
                catch (Throwable var7_8) {
                    if (cursor == null) throw var7_8;
                    cursor.close();
                    throw var7_8;
                }
            }
            cursor.close();
            return l2;
        }
        if (cursor == null) return l2;
        cursor.close();
        return l2;
    }

    static /* synthetic */ ac a(ak ak2) {
        return ak2.c;
    }

    /*
     * Unable to fully structure code
     */
    private void a(String var1_1, la var2_2) {
        block9 : {
            block8 : {
                this.G();
                this.f();
                bf.a(var1_1);
                bf.a(var2_2);
                bf.a(var2_2.c);
                bf.a(var2_2.b);
                if (var2_2.a == null) {
                    this.s().c().a("Audience with no ID");
                    return;
                }
                var7_3 = var2_2.a;
                var8_4 = var2_2.c;
                var9_5 = var8_4.length;
                for (var10_6 = 0; var10_6 < var9_5; ++var10_6) {
                    if (var8_4[var10_6].a != null) continue;
                    this.s().c().a("Event filter with no ID. Audience definition ignored. appId, audienceId", var1_1, var2_2.a);
                    return;
                }
                var11_7 = var2_2.b;
                var12_8 = var11_7.length;
                for (var13_9 = 0; var13_9 < var12_8; ++var13_9) {
                    if (var11_7[var13_9].a != null) continue;
                    this.s().c().a("Property filter with no ID. Audience definition ignored. appId, audienceId", var1_1, var2_2.a);
                    return;
                }
                var14_10 = true;
                var15_11 = var2_2.c;
                var16_12 = var15_11.length;
                var17_13 = 0;
                do {
                    if (var17_13 >= var16_12) ** GOTO lbl31
                    if (!this.a(var1_1, var7_3, var15_11[var17_13])) {
                        var14_10 = false;
lbl31: // 2 sources:
                        if (var14_10) {
                            var19_14 = var2_2.b;
                            var20_15 = var19_14.length;
                            break;
                        }
                        break block8;
                    }
                    ++var17_13;
                } while (true);
                for (var21_16 = 0; var21_16 < var20_15; ++var21_16) {
                    var22_18 = this.a(var1_1, var7_3, var19_14[var21_16]);
                    var18_17 = false;
                    if (var22_18) {
                        continue;
                    }
                    break block9;
                }
            }
            var18_17 = var14_10;
        }
        if (var18_17 != false) return;
        this.b(var1_1, var7_3);
    }

    private boolean a(String string, int n2, lb lb2) {
        byte[] arrby;
        this.G();
        this.f();
        bf.a(string);
        bf.a(lb2);
        if (TextUtils.isEmpty((CharSequence)lb2.b)) {
            this.s().c().a("Event filter had no event name. Audience definition ignored. audienceId, filterId", n2, String.valueOf(lb2.a));
            return false;
        }
        try {
            arrby = new byte[lb2.e()];
            mi mi2 = mi.a(arrby);
            lb2.a(mi2);
            mi2.b();
        }
        catch (IOException var6_7) {
            this.s().b().a("Configuration loss. Failed to serialize event filter", var6_7);
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", string);
        contentValues.put("audience_id", Integer.valueOf(n2));
        contentValues.put("filter_id", lb2.a);
        contentValues.put("event_name", lb2.b);
        contentValues.put("data", arrby);
        try {
            if (this.w().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) return true;
            this.s().b().a("Failed to insert event filter (got -1)");
            return true;
        }
        catch (SQLiteException var10_8) {
            this.s().b().a("Error storing event filter", (Object)var10_8);
            return false;
        }
    }

    private boolean a(String string, int n2, le le2) {
        byte[] arrby;
        this.G();
        this.f();
        bf.a(string);
        bf.a(le2);
        if (TextUtils.isEmpty((CharSequence)le2.b)) {
            this.s().c().a("Property filter had no property name. Audience definition ignored. audienceId, filterId", n2, String.valueOf(le2.a));
            return false;
        }
        try {
            arrby = new byte[le2.e()];
            mi mi2 = mi.a(arrby);
            le2.a(mi2);
            mi2.b();
        }
        catch (IOException var6_8) {
            this.s().b().a("Configuration loss. Failed to serialize property filter", var6_8);
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", string);
        contentValues.put("audience_id", Integer.valueOf(n2));
        contentValues.put("filter_id", le2.a);
        contentValues.put("property_name", le2.b);
        contentValues.put("data", arrby);
        try {
            if (this.w().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) return true;
            this.s().b().a("Failed to insert property filter (got -1)");
            return false;
        }
        catch (SQLiteException var10_7) {
            this.s().b().a("Error storing property filter", (Object)var10_7);
            return false;
        }
    }

    static /* synthetic */ String b(ak ak2) {
        return ak2.I();
    }

    public long A() {
        return this.a("select max(bundle_end_timestamp) from queue", null, 0);
    }

    public long B() {
        return this.a("select max(timestamp) from raw_events", null, 0);
    }

    public boolean C() {
        if (this.a("select count(1) > 0 from raw_events", (String[])null) == 0) return false;
        return true;
    }

    /*
     * Exception decompiling
     */
    public al a(long var1_1, String var3_2, boolean var4_3, boolean var5_4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[CATCHBLOCK]], but top level block is 5[CATCHBLOCK]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public as a(String var1_1, String var2_2) {
        block10 : {
            var3_3 = null;
            bf.a(var1_1);
            bf.a(var2_2);
            this.f();
            this.G();
            var9_4 = this.w().query("events", new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp"}, "app_id=? and name=?", new String[]{var1_1, var2_2}, null, null, null);
            var10_5 = var9_4.moveToFirst();
            if (var10_5) break block10;
            if (var9_4 == null) return null;
            var9_4.close();
            return null;
        }
        var11_6 = new as(var1_1, var2_2, var9_4.getLong(0), var9_4.getLong(1), var9_4.getLong(2));
        if (var9_4.moveToNext()) {
            this.s().b().a("Got multiple records for event aggregates, expected one");
        }
        if (var9_4 == null) return var11_6;
        var9_4.close();
        return var11_6;
        catch (SQLiteException var7_7) {
            var8_10 = null;
            ** GOTO lbl32
            catch (Throwable var6_11) {}
            ** GOTO lbl-1000
            catch (Throwable var6_13) {
                var3_3 = var9_4;
                ** GOTO lbl-1000
            }
            catch (SQLiteException var7_9) {
                var8_10 = var9_4;
            }
lbl32: // 2 sources:
            try {
                this.s().b().a("Error querying events", var1_1, var2_2, var7_8);
                if (var8_10 == null) return null;
            }
            catch (Throwable var6_14) {
                var3_3 = var8_10;
            }
            var8_10.close();
            return null;
        }
lbl-1000: // 3 sources:
        {
            if (var3_3 == null) throw var6_12;
            var3_3.close();
            throw var6_12;
        }
    }

    /*
     * Exception decompiling
     */
    public List a(String var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 12[SIMPLE_IF_TAKEN]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    public List a(String var1_1, int var2_2, int var3_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK], 4[TRYBLOCK]], but top level block is 10[CATCHBLOCK]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    protected void a() {
    }

    public void a(long l2) {
        this.f();
        this.G();
        SQLiteDatabase sQLiteDatabase = this.w();
        String[] arrstring = new String[]{String.valueOf(l2)};
        if (sQLiteDatabase.delete("queue", "rowid=?", arrstring) == 1) return;
        this.s().b().a("Deleted fewer rows from queue than expected");
    }

    void a(ContentValues contentValues, String string, Object object) {
        bf.a(string);
        bf.a(object);
        if (object instanceof String) {
            contentValues.put(string, (String)object);
            return;
        }
        if (object instanceof Long) {
            contentValues.put(string, (Long)object);
            return;
        }
        if (!(object instanceof Float)) throw new IllegalArgumentException("Invalid value type");
        contentValues.put(string, (Float)object);
    }

    public void a(lq lq2) {
        byte[] arrby;
        this.f();
        this.G();
        bf.a(lq2);
        bf.a(lq2.o);
        bf.a(lq2.f);
        this.y();
        long l2 = this.l().a();
        if (lq2.f < l2 - this.u().P() || lq2.f > l2 + this.u().P()) {
            this.s().c().a("Storing bundle outside of the max uploading time span. now, timestamp", l2, lq2.f);
        }
        try {
            byte[] arrby2 = new byte[lq2.e()];
            mi mi2 = mi.a(arrby2);
            lq2.a(mi2);
            mi2.b();
            arrby = this.o().a(arrby2);
            this.s().z().a("Saving bundle, size", arrby.length);
        }
        catch (IOException var7_7) {
            this.s().b().a("Data loss. Failed to serialize bundle", var7_7);
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", lq2.o);
        contentValues.put("bundle_end_timestamp", lq2.f);
        contentValues.put("data", arrby);
        try {
            if (this.w().insert("queue", null, contentValues) != -1) return;
            this.s().b().a("Failed to insert bundle (got -1)");
            return;
        }
        catch (SQLiteException var12_8) {
            this.s().b().a("Error storing bundle", (Object)var12_8);
            return;
        }
    }

    public void a(ar ar2, long l2) {
        byte[] arrby;
        this.f();
        this.G();
        bf.a(ar2);
        bf.a(ar2.a);
        ln ln2 = new ln();
        ln2.d = ar2.e;
        ln2.a = new lo[ar2.f.a()];
        Iterator iterator = ar2.f.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            lo lo2 = new lo();
            lo[] arrlo = ln2.a;
            int n3 = n2 + 1;
            arrlo[n2] = lo2;
            lo2.a = string;
            Object object = ar2.f.a(string);
            this.o().a(lo2, object);
            n2 = n3;
        }
        try {
            arrby = new byte[ln2.e()];
            mi mi2 = mi.a(arrby);
            ln2.a(mi2);
            mi2.b();
            this.s().z().a("Saving event, name, data size", ar2.b, arrby.length);
        }
        catch (IOException var9_14) {
            this.s().b().a("Data loss. Failed to serialize event params/data", var9_14);
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", ar2.a);
        contentValues.put("name", ar2.b);
        contentValues.put("timestamp", Long.valueOf(ar2.d));
        contentValues.put("metadata_fingerprint", Long.valueOf(l2));
        contentValues.put("data", arrby);
        try {
            if (this.w().insert("raw_events", null, contentValues) != -1) return;
            this.s().b().a("Failed to insert raw event (got -1)");
            return;
        }
        catch (SQLiteException var13_15) {
            this.s().b().a("Error storing raw event", (Object)var13_15);
            return;
        }
    }

    public void a(as as2) {
        bf.a(as2);
        this.f();
        this.G();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", as2.a);
        contentValues.put("name", as2.b);
        contentValues.put("lifetime_count", Long.valueOf(as2.c));
        contentValues.put("current_bundle_count", Long.valueOf(as2.d));
        contentValues.put("last_fire_timestamp", Long.valueOf(as2.e));
        try {
            if (this.w().insertWithOnConflict("events", null, contentValues, 5) != -1) return;
            this.s().b().a("Failed to insert/update event aggregates (got -1)");
            return;
        }
        catch (SQLiteException var4_3) {
            this.s().b().a("Error storing event aggregates", (Object)var4_3);
            return;
        }
    }

    public void a(b b2) {
        bf.a(b2);
        this.f();
        this.G();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", b2.b());
        contentValues.put("app_instance_id", b2.c());
        contentValues.put("gmp_app_id", b2.d());
        contentValues.put("resettable_device_id_hash", b2.e());
        contentValues.put("last_bundle_index", Long.valueOf(b2.m()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(b2.f()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(b2.g()));
        contentValues.put("app_version", b2.h());
        contentValues.put("app_store", b2.i());
        contentValues.put("gmp_version", Long.valueOf(b2.j()));
        contentValues.put("dev_cert_hash", Long.valueOf(b2.k()));
        contentValues.put("measurement_enabled", Boolean.valueOf(b2.l()));
        contentValues.put("day", Long.valueOf(b2.q()));
        contentValues.put("daily_public_events_count", Long.valueOf(b2.r()));
        contentValues.put("daily_events_count", Long.valueOf(b2.s()));
        contentValues.put("daily_conversions_count", Long.valueOf(b2.t()));
        contentValues.put("config_fetched_time", Long.valueOf(b2.n()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(b2.o()));
        try {
            if (this.w().insertWithOnConflict("apps", null, contentValues, 5) != -1) return;
            this.s().b().a("Failed to insert/update app (got -1)");
            return;
        }
        catch (SQLiteException var4_3) {
            this.s().b().a("Error storing app", (Object)var4_3);
            return;
        }
    }

    public void a(String string, int n2) {
        bf.a(string);
        this.f();
        this.G();
        try {
            SQLiteDatabase sQLiteDatabase = this.w();
            Object[] arrobject = new String[]{string, string, String.valueOf(n2)};
            sQLiteDatabase.execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", arrobject);
            return;
        }
        catch (SQLiteException var4_5) {
            this.s().b().a("Error pruning currencies", string, (Object)var4_5);
            return;
        }
    }

    void a(String string, int n2, lr lr2) {
        byte[] arrby;
        this.G();
        this.f();
        bf.a(string);
        bf.a(lr2);
        try {
            arrby = new byte[lr2.e()];
            mi mi2 = mi.a(arrby);
            lr2.a(mi2);
            mi2.b();
        }
        catch (IOException var6_7) {
            this.s().b().a("Configuration loss. Failed to serialize filter results", var6_7);
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", string);
        contentValues.put("audience_id", Integer.valueOf(n2));
        contentValues.put("current_results", arrby);
        try {
            if (this.w().insertWithOnConflict("audience_filter_values", null, contentValues, 5) != -1) return;
            this.s().b().a("Failed to insert filter results (got -1)");
            return;
        }
        catch (SQLiteException var10_8) {
            this.s().b().a("Error storing filter results", (Object)var10_8);
            return;
        }
    }

    /*
     * Exception decompiling
     */
    public void a(String var1_1, long var2_2, am var4_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [11[TRYBLOCK]], but top level block is 26[SIMPLE_IF_TAKEN]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    public void a(String string, byte[] arrby) {
        bf.a(string);
        this.f();
        this.G();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", arrby);
        try {
            if ((long)this.w().update("apps", contentValues, "app_id = ?", new String[]{string}) != 0) return;
            this.s().b().a("Failed to update remote config (got 0)");
            return;
        }
        catch (SQLiteException var5_4) {
            this.s().b().a("Error storing remote config", (Object)var5_4);
            return;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    void a(String var1_1, la[] var2_2) {
        this.G();
        this.f();
        bf.a(var1_1);
        bf.a(var2_2);
        var5_3 = this.w();
        var5_3.beginTransaction();
        this.e(var1_1);
        var7_4 = var2_2.length;
        for (var8_5 = 0; var8_5 < var7_4; ++var8_5) {
            this.a(var1_1, var2_2[var8_5]);
        }
        ** try [egrp 1[TRYBLOCK] [2 : 63->68)] { 
lbl17: // 1 sources:
        var5_3.setTransactionSuccessful();
        return;
lbl19: // 1 sources:
        finally {
            var5_3.endTransaction();
        }
    }

    public void a(List list) {
        bf.a(list);
        this.f();
        this.G();
        StringBuilder stringBuilder = new StringBuilder("rowid in (");
        int n2 = 0;
        do {
            if (n2 >= list.size()) {
                stringBuilder.append(")");
                int n3 = this.w().delete("raw_events", stringBuilder.toString(), null);
                if (n3 == list.size()) return;
                this.s().b().a("Deleted fewer rows from raw events table than expected", n3, list.size());
                return;
            }
            if (n2 != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append((Long)list.get(n2));
            ++n2;
        } while (true);
    }

    public boolean a(af af2) {
        bf.a(af2);
        this.f();
        this.G();
        if (this.c(af2.a, af2.b) == null) {
            if (ag.a(af2.b)) {
                String[] arrstring = new String[]{af2.a};
                if (this.a("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", arrstring) >= (long)this.u().E()) {
                    return false;
                }
            } else {
                String[] arrstring = new String[]{af2.a};
                if (this.a("select count(1) from user_attributes where app_id=?", arrstring) >= (long)this.u().F()) return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", af2.a);
        contentValues.put("name", af2.b);
        contentValues.put("set_timestamp", Long.valueOf(af2.c));
        this.a(contentValues, "value", af2.d);
        try {
            if (this.w().insertWithOnConflict("user_attributes", null, contentValues, 5) != -1) return true;
            this.s().b().a("Failed to insert/update user property (got -1)");
            return true;
        }
        catch (SQLiteException var4_5) {
            this.s().b().a("Error storing user property", (Object)var4_5);
            return true;
        }
    }

    public long b(lq lq2) {
        long l2;
        byte[] arrby;
        this.f();
        this.G();
        bf.a(lq2);
        bf.a(lq2.o);
        try {
            arrby = new byte[lq2.e()];
            mi mi2 = mi.a(arrby);
            lq2.a(mi2);
            mi2.b();
            l2 = this.o().d(arrby);
        }
        catch (IOException var4_6) {
            this.s().b().a("Data loss. Failed to serialize event metadata", var4_6);
            throw var4_6;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", lq2.o);
        contentValues.put("metadata_fingerprint", Long.valueOf(l2));
        contentValues.put("metadata", arrby);
        try {
            this.w().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return l2;
        }
        catch (SQLiteException var10_7) {
            this.s().b().a("Error storing raw event metadata", (Object)var10_7);
            throw var10_7;
        }
    }

    /*
     * Exception decompiling
     */
    public b b(String var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK]], but top level block is 5[CATCHBLOCK]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    Object b(Cursor cursor, int n2) {
        int n3 = ak.a(cursor, n2);
        switch (n3) {
            default: {
                this.s().b().a("Loaded invalid unknown value type, ignoring it", n3);
                return null;
            }
            case 0: {
                this.s().b().a("Loaded invalid null value from database");
                return null;
            }
            case 1: {
                return cursor.getLong(n2);
            }
            case 2: {
                return Float.valueOf(cursor.getFloat(n2));
            }
            case 3: {
                return cursor.getString(n2);
            }
            case 4: 
        }
        this.s().b().a("Loaded invalid blob type value, ignoring it");
        return null;
    }

    /*
     * Exception decompiling
     */
    public String b(long var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[CATCHBLOCK]], but top level block is 5[CATCHBLOCK]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    public void b() {
        this.G();
        this.w().beginTransaction();
    }

    void b(String string, int n2) {
        this.G();
        this.f();
        bf.a(string);
        SQLiteDatabase sQLiteDatabase = this.w();
        String[] arrstring = new String[]{string, String.valueOf(n2)};
        sQLiteDatabase.delete("property_filters", "app_id=? and audience_id=?", arrstring);
        String[] arrstring2 = new String[]{string, String.valueOf(n2)};
        sQLiteDatabase.delete("event_filters", "app_id=? and audience_id=?", arrstring2);
    }

    public void b(String string, String string2) {
        bf.a(string);
        bf.a(string2);
        this.f();
        this.G();
        try {
            int n2 = this.w().delete("user_attributes", "app_id=? and name=?", new String[]{string, string2});
            this.s().z().a("Deleted user attribute rows:", n2);
            return;
        }
        catch (SQLiteException var5_4) {
            this.s().b().a("Error deleting user attribute", string, string2, (Object)var5_4);
            return;
        }
    }

    public long c(String string) {
        int n2;
        bf.a(string);
        this.f();
        this.G();
        try {
            n2 = this.w().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{string, String.valueOf(this.u().e(string))});
        }
        catch (SQLiteException var3_3) {
            this.s().b().a("Error deleting over the limit events", (Object)var3_3);
            return 0;
        }
        return n2;
    }

    /*
     * Exception decompiling
     */
    lr c(String var1_1, int var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 4[TRYBLOCK]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public af c(String var1_1, String var2_2) {
        block10 : {
            var3_3 = null;
            bf.a(var1_1);
            bf.a(var2_2);
            this.f();
            this.G();
            var9_4 = this.w().query("user_attributes", new String[]{"set_timestamp", "value"}, "app_id=? and name=?", new String[]{var1_1, var2_2}, null, null, null);
            var10_5 = var9_4.moveToFirst();
            if (var10_5) break block10;
            if (var9_4 == null) return null;
            var9_4.close();
            return null;
        }
        var11_6 = new af(var1_1, var2_2, var9_4.getLong(0), this.b(var9_4, 1));
        if (var9_4.moveToNext()) {
            this.s().b().a("Got multiple records for user property, expected one");
        }
        if (var9_4 == null) return var11_6;
        var9_4.close();
        return var11_6;
        catch (SQLiteException var7_7) {
            var8_10 = null;
            ** GOTO lbl32
            catch (Throwable var6_11) {}
            ** GOTO lbl-1000
            catch (Throwable var6_13) {
                var3_3 = var9_4;
                ** GOTO lbl-1000
            }
            catch (SQLiteException var7_9) {
                var8_10 = var9_4;
            }
lbl32: // 2 sources:
            try {
                this.s().b().a("Error querying user property", var1_1, var2_2, var7_8);
                if (var8_10 == null) return null;
            }
            catch (Throwable var6_14) {
                var3_3 = var8_10;
            }
            var8_10.close();
            return null;
        }
lbl-1000: // 3 sources:
        {
            if (var3_3 == null) throw var6_12;
            var3_3.close();
            throw var6_12;
        }
    }

    public void c() {
        this.G();
        this.w().setTransactionSuccessful();
    }

    /*
     * Exception decompiling
     */
    Map d(String var1_1, String var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 13[SIMPLE_IF_TAKEN]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    public byte[] d(String var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[CATCHBLOCK]], but top level block is 5[CATCHBLOCK]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    Map e(String var1_1, String var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 13[SIMPLE_IF_TAKEN]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    void e(String string) {
        this.G();
        this.f();
        bf.a(string);
        SQLiteDatabase sQLiteDatabase = this.w();
        sQLiteDatabase.delete("property_filters", "app_id=?", new String[]{string});
        sQLiteDatabase.delete("event_filters", "app_id=?", new String[]{string});
    }

    public void f(String string) {
        SQLiteDatabase sQLiteDatabase = this.w();
        try {
            sQLiteDatabase.execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", (Object[])new String[]{string, string});
            return;
        }
        catch (SQLiteException var3_3) {
            this.s().b().a("Failed to remove unused event metadata", (Object)var3_3);
            return;
        }
    }

    public long g(String string) {
        bf.a(string);
        return this.a("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{string}, 0);
    }

    public void v() {
        this.G();
        this.w().endTransaction();
    }

    SQLiteDatabase w() {
        this.f();
        try {
            return this.b.getWritableDatabase();
        }
        catch (SQLiteException var1_2) {
            this.s().c().a("Error opening database", (Object)var1_2);
            throw var1_2;
        }
    }

    /*
     * Exception decompiling
     */
    public String x() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[CATCHBLOCK]], but top level block is 4[CATCHBLOCK]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    void y() {
        this.f();
        this.G();
        if (!this.J()) {
            return;
        }
        long l2 = this.t().f.a();
        long l3 = this.l().b();
        if (Math.abs(l3 - l2) <= this.u().Q()) return;
        this.t().f.a(l3);
        this.z();
    }

    void z() {
        this.f();
        this.G();
        if (!this.J()) {
            return;
        }
        SQLiteDatabase sQLiteDatabase = this.w();
        String[] arrstring = new String[]{String.valueOf(this.l().a()), String.valueOf(this.u().P())};
        int n2 = sQLiteDatabase.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", arrstring);
        if (n2 <= 0) return;
        this.s().z().a("Deleted stale rows. rowsDeleted", n2);
    }
}

