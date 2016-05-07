/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.fk;
import com.google.android.gms.b.l;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

public class my {
    public static long a(String string) {
        try {
            return DateUtils.parseDate((String)string).getTime();
        }
        catch (DateParseException var1_2) {
            return 0;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public static l a(fk var0) {
        block15 : {
            var1_1 = System.currentTimeMillis();
            var3_2 = var0.c;
            var4_3 = 0;
            var6_4 = 0;
            var8_5 = 0;
            var10_6 = (String)var3_2.get("Date");
            if (var10_6 != null) {
                var4_3 = my.a(var10_6);
            }
            if ((var11_7 = (String)var3_2.get("Cache-Control")) != null) ** GOTO lbl13
            var12_10 = false;
            var13_18 = false;
            ** GOTO lbl38
lbl13: // 1 sources:
            var26_8 = var11_7.split(",");
            var27_9 = 0;
            var12_10 = false;
            var28_11 = var8_5;
            var30_12 = var6_4;
            do {
                if (var27_9 < var26_8.length) {
                    var32_13 = var26_8[var27_9].trim();
                    if (var32_13.equals("no-cache") != false) return null;
                    if (var32_13.equals("no-store")) {
                        return null;
                    }
                    if (var32_13.startsWith("max-age=")) {
                        var30_12 = var37_17 = Long.parseLong(var32_13.substring(8));
                        ** GOTO lbl52
                    } else {
                        if (var32_13.startsWith("stale-while-revalidate=")) {
                            var28_11 = var34_15 = Long.parseLong(var32_13.substring(23));
                        }
                        if (var32_13.equals("must-revalidate") || var32_13.equals("proxy-revalidate")) {
                            var12_10 = true;
                        }
                    }
                } else {
                    var6_4 = var30_12;
                    var8_5 = var28_11;
                    var13_18 = true;
lbl38: // 2 sources:
                    var15_20 = (var14_19 = (String)var3_2.get("Expires")) != null ? my.a(var14_19) : 0;
                    var17_21 = (String)var3_2.get("Last-Modified");
                    var18_22 = var17_21 != null ? my.a(var17_21) : 0;
                    var20_23 = (String)var3_2.get("ETag");
                    if (var13_18) {
                        var23_24 = var1_1 + 1000 * var6_4;
                        var21_25 = var12_10 ? var23_24 : var23_24 + 1000 * var8_5;
                    } else {
                        if (var4_3 <= 0 || var15_20 < var4_3) break;
                        var23_24 = var21_25 = var1_1 + (var15_20 - var4_3);
                    }
                    break block15;
                    catch (Exception var33_14) {}
                }
                ** GOTO lbl52
                catch (Exception var36_16) {}
lbl52: // 5 sources:
                ++var27_9;
            } while (true);
            var21_25 = 0;
            var23_24 = 0;
        }
        var25_26 = new l();
        var25_26.a = var0.b;
        var25_26.b = var20_23;
        var25_26.f = var23_24;
        var25_26.e = var21_25;
        var25_26.c = var4_3;
        var25_26.d = var18_22;
        var25_26.g = var3_2;
        return var25_26;
    }

    public static String a(Map map) {
        return my.a(map, "ISO-8859-1");
    }

    public static String a(Map map, String string) {
        String string2 = (String)map.get("Content-Type");
        if (string2 == null) return string;
        String[] arrstring = string2.split(";");
        int n2 = 1;
        while (n2 < arrstring.length) {
            String[] arrstring2 = arrstring[n2].trim().split("=");
            if (arrstring2.length == 2 && arrstring2[0].equals("charset")) {
                return arrstring2[1];
            }
            ++n2;
        }
        return string;
    }
}

