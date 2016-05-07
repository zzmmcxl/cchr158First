/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.stats;

import com.google.android.gms.b.je;
import com.google.android.gms.common.stats.f;

public final class d {
    public static je a = je.a("gms:common:stats:connections:level", f.b);
    public static je b = je.a("gms:common:stats:connections:ignored_calling_processes", "");
    public static je c = je.a("gms:common:stats:connections:ignored_calling_services", "");
    public static je d = je.a("gms:common:stats:connections:ignored_target_processes", "");
    public static je e = je.a("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
    public static je f = je.a("gms:common:stats:connections:time_out_duration", 600000);
}

