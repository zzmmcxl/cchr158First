/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.google.android.gms.measurement.internal.bx;

public class AppMeasurementContentProvider
extends ContentProvider {
    public int delete(Uri uri, String string, String[] arrstring) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        bx.a(this.getContext());
        return false;
    }

    public Cursor query(Uri uri, String[] arrstring, String string, String[] arrstring2, String string2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String string, String[] arrstring) {
        return 0;
    }
}

