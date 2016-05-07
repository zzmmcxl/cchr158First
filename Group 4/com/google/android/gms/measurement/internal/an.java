/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import com.google.android.gms.measurement.internal.aj;
import com.google.android.gms.measurement.internal.ak;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class an
extends SQLiteOpenHelper {
    final /* synthetic */ ak a;

    an(ak ak2, Context context, String string) {
        this.a = ak2;
        super(context, string, null, 1);
    }

    private void a(SQLiteDatabase sQLiteDatabase, String string, String string2, String string3, Map map) {
        if (!this.a(sQLiteDatabase, string)) {
            sQLiteDatabase.execSQL(string2);
        }
        try {
            this.a(sQLiteDatabase, string, string3, map);
            return;
        }
        catch (SQLiteException var6_6) {
            this.a.s().b().a("Failed to verify columns on table that was just created", string);
            throw var6_6;
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, String string, String string2, Map map) {
        Set set = this.b(sQLiteDatabase, string);
        for (String string3 : string2.split(",")) {
            if (set.remove(string3)) continue;
            throw new SQLiteException("Table " + string + " is missing required column: " + string3);
        }
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                if (set.remove(entry.getKey())) continue;
                sQLiteDatabase.execSQL((String)entry.getValue());
            }
        }
        if (set.isEmpty()) return;
        throw new SQLiteException("Table " + string + " table has extra columns");
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private boolean a(SQLiteDatabase var1_1, String var2_2) {
        var3_3 = null;
        var6_5 = var7_4 = var1_1.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{var2_2}, null, null, null);
        try {
            var8_6 = var6_5.moveToFirst();
            if (var6_5 == null) return var8_6;
        }
        catch (SQLiteException var5_9) {
            ** continue;
        }
        var6_5.close();
        return var8_6;
        catch (SQLiteException var5_7) {
            var6_5 = null;
            ** GOTO lbl14
            catch (Throwable var4_10) {}
            ** GOTO lbl-1000
lbl14: // 2 sources:
            do {
                try {
                    this.a.s().c().a("Error querying for table", var2_2, var5_8);
                    if (var6_5 == null) return false;
                }
                catch (Throwable var4_12) {
                    var3_3 = var6_5;
                    break;
                }
                var6_5.close();
                return false;
                break;
            } while (true);
        }
lbl-1000: // 2 sources:
        {
            if (var3_3 == null) throw var4_11;
            var3_3.close();
            throw var4_11;
        }
    }

    private Set b(SQLiteDatabase sQLiteDatabase, String string) {
        HashSet hashSet = new HashSet();
        Cursor cursor = sQLiteDatabase.rawQuery("SELECT * FROM " + string + " LIMIT 0", null);
        try {
            Collections.addAll(hashSet, cursor.getColumnNames());
            return hashSet;
        }
        finally {
            cursor.close();
        }
    }

    public SQLiteDatabase getWritableDatabase() {
        if (!ak.a(this.a).a(this.a.u().G())) {
            throw new SQLiteException("Database open failed");
        }
        try {
            return super.getWritableDatabase();
        }
        catch (SQLiteException var1_2) {
            ak.a(this.a).a();
            this.a.s().b().a("Opening the database failed, dropping and recreating it");
            String string = ak.b(this.a);
            this.a.m().getDatabasePath(string).delete();
            try {
                SQLiteDatabase sQLiteDatabase = super.getWritableDatabase();
                ak.a(this.a).b();
                return sQLiteDatabase;
            }
            catch (SQLiteException var4_5) {
                this.a.s().b().a("Failed to open freshly created database", (Object)var4_5);
                throw var4_5;
            }
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (Build.VERSION.SDK_INT < 9) return;
        File file = new File(sQLiteDatabase.getPath());
        file.setReadable(false, false);
        file.setWritable(false, false);
        file.setReadable(true, true);
        file.setWritable(true, true);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        if (Build.VERSION.SDK_INT < 15) {
            cursor = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
            cursor.moveToFirst();
        }
        this.a(sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", null);
        this.a(sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", null);
        this.a(sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", ak.D());
        this.a(sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", null);
        this.a(sQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
        this.a(sQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", null);
        this.a(sQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", null);
        this.a(sQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", null);
        this.a(sQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
        return;
        finally {
            cursor.close();
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n2, int n3) {
    }
}

