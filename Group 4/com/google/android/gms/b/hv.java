/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.webkit.ConsoleMessage;

class hv {
    static final /* synthetic */ int[] a;

    static {
        a = new int[ConsoleMessage.MessageLevel.values().length];
        try {
            hv.a[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
        }
        catch (NoSuchFieldError var0_4) {}
        try {
            hv.a[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 2;
        }
        catch (NoSuchFieldError var1_3) {}
        try {
            hv.a[ConsoleMessage.MessageLevel.LOG.ordinal()] = 3;
        }
        catch (NoSuchFieldError var2_2) {}
        try {
            hv.a[ConsoleMessage.MessageLevel.TIP.ordinal()] = 4;
        }
        catch (NoSuchFieldError var3_1) {}
        try {
            hv.a[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 5;
            return;
        }
        catch (NoSuchFieldError var4) {
            return;
        }
    }
}

