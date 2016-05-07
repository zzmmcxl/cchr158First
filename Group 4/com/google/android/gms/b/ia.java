/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

public final class ia
extends Enum {
    public static final /* enum */ ia a = new ia();
    public static final /* enum */ ia b = new ia();
    public static final /* enum */ ia c = new ia();
    public static final /* enum */ ia d = new ia();
    private static final /* synthetic */ ia[] e;

    static {
        ia[] arria = new ia[]{a, b, c, d};
        e = arria;
    }

    private ia() {
        super(string, n2);
    }

    public static ia valueOf(String string) {
        return (ia)((Object)Enum.valueOf(ia.class, string));
    }

    public static ia[] values() {
        return (ia[])e.clone();
    }
}

