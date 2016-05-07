/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.os.Looper;
import android.text.TextUtils;

public final class bf {
    public static Object a(Object object) {
        if (object != null) return object;
        throw new NullPointerException("null reference");
    }

    public static Object a(Object object, Object object2) {
        if (object != null) return object;
        throw new NullPointerException(String.valueOf(object2));
    }

    public static String a(String string) {
        if (!TextUtils.isEmpty((CharSequence)string)) return string;
        throw new IllegalArgumentException("Given String is empty or null");
    }

    public static String a(String string, Object object) {
        if (!TextUtils.isEmpty((CharSequence)string)) return string;
        throw new IllegalArgumentException(String.valueOf(object));
    }

    public static void a(boolean bl2) {
        if (bl2) return;
        throw new IllegalStateException();
    }

    public static void a(boolean bl2, Object object) {
        if (bl2) return;
        throw new IllegalStateException(String.valueOf(object));
    }

    public static /* varargs */ void a(boolean bl2, String string, Object ... arrobject) {
        if (bl2) return;
        throw new IllegalStateException(String.format(string, arrobject));
    }

    public static void b(String string) {
        if (Looper.myLooper() == Looper.getMainLooper()) return;
        throw new IllegalStateException(string);
    }

    public static void b(boolean bl2) {
        if (bl2) return;
        throw new IllegalArgumentException();
    }

    public static void b(boolean bl2, Object object) {
        if (bl2) return;
        throw new IllegalArgumentException(String.valueOf(object));
    }

    public static /* varargs */ void b(boolean bl2, String string, Object ... arrobject) {
        if (bl2) return;
        throw new IllegalArgumentException(String.format(string, arrobject));
    }

    public static void c(String string) {
        if (Looper.myLooper() != Looper.getMainLooper()) return;
        throw new IllegalStateException(string);
    }
}

