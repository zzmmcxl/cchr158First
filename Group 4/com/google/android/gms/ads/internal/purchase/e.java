/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.purchase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.purchase.d;
import com.google.android.gms.ads.internal.purchase.f;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import java.util.Locale;

@fi
public class e {
    private static final String a = String.format(Locale.US, "CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", "InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time");
    private static final Object c = new Object();
    private static e d;
    private final f b;

    e(Context context) {
        this.b = new f(this, context, "google_inapp_purchase.db");
    }

    public static e a(Context context) {
        Object object = c;
        // MONITORENTER : object
        if (d == null) {
            d = new e(context);
        }
        e e2 = d;
        // MONITOREXIT : object
        return e2;
    }

    static /* synthetic */ String d() {
        return a;
    }

    public SQLiteDatabase a() {
        try {
            return this.b.getWritableDatabase();
        }
        catch (SQLiteException var1_2) {
            fp.d("Error opening writable conversion tracking database");
            return null;
        }
    }

    public d a(Cursor cursor) {
        if (cursor != null) return new d(cursor.getLong(0), cursor.getString(1), cursor.getString(2));
        return null;
    }

    public void a(d d2) {
        if (d2 == null) {
            return;
        }
        Object object = c;
        // MONITORENTER : object
        SQLiteDatabase sQLiteDatabase = this.a();
        if (sQLiteDatabase == null) {
            // MONITOREXIT : object
            return;
        }
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{"purchase_id", d2.a};
        sQLiteDatabase.delete("InAppPurchase", String.format(locale, "%s = %d", arrobject), null);
        // MONITOREXIT : object
        return;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public int b() {
        block11 : {
            Cursor cursor = null;
            Object object = c;
            // MONITORENTER : object
            SQLiteDatabase sQLiteDatabase = this.a();
            if (sQLiteDatabase == null) {
                // MONITOREXIT : object
                return 0;
            }
            try {
                cursor = sQLiteDatabase.rawQuery("select count(*) from InAppPurchase", null);
                if (!cursor.moveToFirst()) break block11;
                int n2 = cursor.getInt(0);
                // MONITOREXIT : object
                return n2;
            }
            catch (SQLiteException var6_5) {
                fp.d("Error getting record count" + var6_5.getMessage());
                return 0;
            }
            finally {
                if (cursor == null) return 0;
                cursor.close();
                return 0;
            }
        }
        // MONITOREXIT : object
        return 0;
    }

    public void b(d d2) {
        if (d2 == null) {
            return;
        }
        Object object = c;
        // MONITORENTER : object
        SQLiteDatabase sQLiteDatabase = this.a();
        if (sQLiteDatabase == null) {
            // MONITOREXIT : object
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("product_id", d2.c);
        contentValues.put("developer_payload", d2.b);
        contentValues.put("record_time", Long.valueOf(SystemClock.elapsedRealtime()));
        d2.a = sQLiteDatabase.insert("InAppPurchase", null, contentValues);
        if ((long)this.b() > 20000) {
            this.c();
        }
        // MONITOREXIT : object
        return;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public void c() {
        block16 : {
            block15 : {
                var1_1 = e.c;
                // MONITORENTER : var1_1
                var3_2 = this.a();
                if (var3_2 == null) {
                    // MONITOREXIT : var1_1
                    return;
                }
                var5_4 = var7_3 = var3_2.query("InAppPurchase", null, null, null, null, null, "record_time ASC", "1");
                if (var5_4 == null) break block15;
                try {
                    if (!var5_4.moveToFirst()) break block15;
                    this.a(this.a(var5_4));
                }
                catch (SQLiteException var6_7) {
                    ** continue;
                }
            }
            if (var5_4 != null) {
                var5_4.close();
                return;
            }
            ** GOTO lbl24
            catch (SQLiteException var6_5) {
                var5_4 = null;
                ** GOTO lbl27
                catch (Throwable var4_10) {
                    var5_4 = null;
                    break block16;
                }
lbl24: // 2 sources:
                do {
                    // MONITOREXIT : var1_1
                    return;
                    break;
                } while (true);
lbl27: // 2 sources:
                do {
                    try {
                        fp.d("Error remove oldest record" + var6_6.getMessage());
                        if (var5_4 == null) ** continue;
                    }
                    catch (Throwable var4_9) {
                        break;
                    }
                    var5_4.close();
                    return;
                    break;
                } while (true);
            }
        }
        if (var5_4 == null) throw var4_8;
        var5_4.close();
        throw var4_8;
    }
}

