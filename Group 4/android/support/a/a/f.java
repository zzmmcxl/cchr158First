/*
 * Decompiled with CFR 0_115.
 */
package android.support.a.a;

import android.support.a.a.g;
import android.support.a.a.h;
import android.support.a.a.i;
import java.util.ArrayList;

class f {
    private static int a(String string, int n2) {
        while (n2 < string.length()) {
            char c2 = string.charAt(n2);
            if (((c2 - 65) * (c2 - 90) <= 0 || (c2 - 97) * (c2 - 122) <= 0) && c2 != 'e' && c2 != 'E') {
                return n2;
            }
            ++n2;
        }
        return n2;
    }

    /*
     * Unable to fully structure code
     */
    private static void a(String var0, int var1_1, h var2_2) {
        var2_2.b = false;
        var3_3 = false;
        var4_4 = false;
        var5_5 = false;
        for (var6_6 = var1_1; var6_6 < var0.length(); ++var6_6) {
            switch (var0.charAt(var6_6)) {
                case ' ': 
                case ',': {
                    var5_5 = true;
                    var3_3 = false;
                    ** GOTO lbl31
                }
                case '-': {
                    if (var6_6 == var1_1 || var3_3) ** GOTO lbl17
                    var2_2.b = true;
                    var5_5 = true;
                    var3_3 = false;
                    ** GOTO lbl31
                }
lbl17: // 2 sources:
                default: {
                    var3_3 = false;
                    ** GOTO lbl31
                }
                case '.': {
                    if (!var4_4) {
                        var4_4 = true;
                        var3_3 = false;
                    } else {
                        var2_2.b = true;
                        var5_5 = true;
                        var3_3 = false;
                    }
                    ** GOTO lbl31
                }
                case 'E': 
                case 'e': 
            }
            var3_3 = true;
lbl31: // 6 sources:
            if (var5_5) break;
        }
        var2_2.a = var6_6;
    }

    private static void a(ArrayList arrayList, char c2, float[] arrf) {
        arrayList.add(new i(c2, arrf, null));
    }

    static /* synthetic */ float[] a(float[] arrf, int n2, int n3) {
        return f.b(arrf, n2, n3);
    }

    public static i[] a(String string) {
        if (string == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int n2 = 1;
        int n3 = 0;
        do {
            if (n2 >= string.length()) {
                if (n2 - n3 != 1) return arrayList.toArray(new i[arrayList.size()]);
                if (n3 >= string.length()) return arrayList.toArray(new i[arrayList.size()]);
                f.a(arrayList, string.charAt(n3), new float[0]);
                return arrayList.toArray(new i[arrayList.size()]);
            }
            int n4 = f.a(string, n2);
            String string2 = string.substring(n3, n4).trim();
            if (string2.length() > 0) {
                float[] arrf = f.b(string2);
                f.a(arrayList, string2.charAt(0), arrf);
            }
            n2 = n4 + 1;
            n3 = n4;
        } while (true);
    }

    public static i[] a(i[] arri) {
        if (arri == null) {
            return null;
        }
        i[] arri2 = new i[arri.length];
        int n2 = 0;
        while (n2 < arri.length) {
            arri2[n2] = new i(arri[n2], null);
            ++n2;
        }
        return arri2;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private static float[] b(String var0) {
        block6 : {
            block5 : {
                var1_1 = var0.charAt(0) == 'z';
                var2_2 = var0.charAt(0) == 'Z';
                if (var1_1 | var2_2) {
                    return new float[0];
                }
                try {
                    var4_3 = new float[var0.length()];
                    var5_4 = new h(null);
                    var6_5 = var0.length();
                    var7_6 = 0;
                    var8_7 = 1;
lbl11: // 3 sources:
                    if (var8_7 >= var6_5) return f.b(var4_3, 0, var7_6);
                    f.a(var0, var8_7, var5_4);
                    var9_8 = var5_4.a;
                    if (var8_7 >= var9_8) break block5;
                    var10_9 = var7_6 + 1;
                    var4_3[var7_6] = Float.parseFloat(var0.substring(var8_7, var9_8));
                    break block6;
                }
                catch (NumberFormatException var3_11) {
                    throw new RuntimeException("error in parsing \"" + var0 + "\"", var3_11);
                }
            }
            var10_9 = var7_6;
        }
        if (!var5_4.b) ** GOTO lbl27
        var8_7 = var9_8;
        var7_6 = var10_9;
        ** GOTO lbl11
lbl27: // 1 sources:
        var8_7 = var9_8 + 1;
        var7_6 = var10_9;
        ** GOTO lbl11
    }

    private static float[] b(float[] arrf, int n2, int n3) {
        if (n2 > n3) {
            throw new IllegalArgumentException();
        }
        int n4 = arrf.length;
        if (n2 < 0) throw new ArrayIndexOutOfBoundsException();
        if (n2 > n4) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int n5 = n3 - n2;
        int n6 = Math.min(n5, n4 - n2);
        float[] arrf2 = new float[n5];
        System.arraycopy(arrf, n2, arrf2, 0, n6);
        return arrf2;
    }
}

