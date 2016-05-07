/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.b;

public final class w
extends Enum {
    public static final /* enum */ w a = new w();
    public static final /* enum */ w b = new w();
    public static final /* enum */ w c = new w();
    private static final /* synthetic */ w[] d;

    static {
        w[] arrw = new w[]{a, b, c};
        d = arrw;
    }

    private w() {
        super(string, n2);
    }

    public static w valueOf(String string) {
        return (w)((Object)Enum.valueOf(w.class, string));
    }

    public static w[] values() {
        return (w[])d.clone();
    }
}

