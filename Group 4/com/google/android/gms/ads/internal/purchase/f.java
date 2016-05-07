/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.ads.internal.purchase.e;
import com.google.android.gms.b.fp;

public class f
extends SQLiteOpenHelper {
    final /* synthetic */ e a;

    public f(e e2, Context context, String string) {
        this.a = e2;
        super(context, string, null, 4);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(e.d());
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n2, int n3) {
        fp.c("Database updated from version " + n2 + " to version " + n3);
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS InAppPurchase");
        this.onCreate(sQLiteDatabase);
    }
}

