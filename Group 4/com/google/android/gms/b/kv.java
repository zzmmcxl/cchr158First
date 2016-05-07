/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.IInterface;
import com.google.android.gms.a.a;

public interface kv
extends IInterface {
    public boolean getBooleanFlagValue(String var1, boolean var2, int var3);

    public int getIntFlagValue(String var1, int var2, int var3);

    public long getLongFlagValue(String var1, long var2, int var4);

    public String getStringFlagValue(String var1, String var2, int var3);

    public void init(a var1);
}

