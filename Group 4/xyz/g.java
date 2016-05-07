/*
 * Decompiled with CFR 0_115.
 */
package xyz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import xyz.a;
import xyz.c;
import xyz.d;
import xyz.f;

public class g
extends SQLiteOpenHelper {
    public static final String a = c.a("nFOXWsVf621k6n3x3lM7OA==");
    public static final String b = f.a;

    public g(Context context) {
        super(context, a, null, 1);
    }

    public List a() {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        ArrayList<d> arrayList;
        arrayList = new ArrayList<d>();
        String string = "SELECT * FROM " + b;
        sQLiteDatabase = this.getWritableDatabase();
        cursor = sQLiteDatabase.rawQuery(string, null);
        try {
            boolean bl2;
            if (!cursor.moveToFirst()) throw new NullPointerException();
            do {
                d d2 = new d();
                d2.b(new a(cursor.getInt(0)));
                d2.a(new a(cursor.getString(1)));
                d2.c(new a(cursor.getString(2)));
                arrayList.add(d2);
            } while (bl2 = cursor.moveToNext());
        }
        catch (NullPointerException var5_7) {}
        cursor.close();
        sQLiteDatabase.close();
        return arrayList;
    }

    public void a(a a2) {
        d d2 = (d)a2.a(0);
        SQLiteDatabase sQLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(f.c, d2.a());
        contentValues.put(f.d, d2.b());
        sQLiteDatabase.insert(b, null, contentValues);
        sQLiteDatabase.close();
    }

    public void b(a a2) {
        int n2 = (Integer)a2.a(0);
        SQLiteDatabase sQLiteDatabase = this.getWritableDatabase();
        String string = b;
        String string2 = f.b + " = ?";
        String[] arrstring = new String[]{String.valueOf(n2)};
        sQLiteDatabase.delete(string, string2, arrstring);
        sQLiteDatabase.close();
    }

    public d c(a a2) {
        d d2;
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        int n2 = (Integer)a2.a(0);
        sQLiteDatabase = this.getReadableDatabase();
        String string = b;
        String[] arrstring = f.e;
        String string2 = f.b + " = ?";
        String[] arrstring2 = new String[]{String.valueOf(n2)};
        cursor = sQLiteDatabase.query(string, arrstring, string2, arrstring2, null, null, null, null);
        d2 = new d();
        try {
            if (!cursor.moveToFirst()) throw new NullPointerException();
            d2.b(new a(cursor.getInt(0)));
            d2.a(new a(cursor.getString(1)));
            d2.c(new a(cursor.getString(2)));
        }
        catch (NullPointerException var10_10) {}
        cursor.close();
        sQLiteDatabase.close();
        return d2;
    }

    public int d(a a2) {
        Cursor cursor;
        int n2;
        SQLiteDatabase sQLiteDatabase;
        String string = (String)a2.a(0);
        String string2 = (String)a2.a(1);
        sQLiteDatabase = this.getReadableDatabase();
        String string3 = b;
        String[] arrstring = new String[]{f.b};
        cursor = sQLiteDatabase.query(string3, arrstring, f.c + " = ? AND " + f.d + " = ?", new String[]{string, string2}, null, null, null, null);
        n2 = -1;
        try {
            int n3;
            if (!cursor.moveToFirst()) throw new NullPointerException();
            n2 = n3 = cursor.getInt(0);
        }
        catch (NullPointerException var9_10) {}
        cursor.close();
        sQLiteDatabase.close();
        return n2;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(c.a("ozlzymnYbyggzDqeW7d3gQ==") + b + " (" + f.b + c.a("tZSAACIHQJL/B4fbZuJnojxc9yMyU9fdj48wA8/bQqBAUK9mMv53J7kROe34HGdN") + f.c + c.a("67FR0S+WuuUzpGRTmNHYyg==") + f.d + " TEXT )");
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int n2, int n3) {
        this.onUpgrade(sQLiteDatabase, n2, n3);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n2, int n3) {
        sQLiteDatabase.execSQL(c.a("04dZAlPrZjloVgIfBfqpvt43PdpKUa3PVOrOF4qTFAc=") + b);
        this.onCreate(sQLiteDatabase);
    }
}

