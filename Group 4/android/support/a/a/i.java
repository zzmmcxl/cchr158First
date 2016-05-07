/*
 * Decompiled with CFR 0_115.
 */
package android.support.a.a;

import android.graphics.Path;
import android.support.a.a.f;
import android.support.a.a.g;
import android.util.Log;

public class i {
    char a;
    float[] b;

    private i(char c2, float[] arrf) {
        this.a = c2;
        this.b = arrf;
    }

    /* synthetic */ i(char c2, float[] arrf, g g2) {
        this(c2, arrf);
    }

    private i(i i2) {
        this.a = i2.a;
        this.b = f.a(i2.b, 0, i2.b.length);
    }

    /* synthetic */ i(i i2, g g2) {
        this(i2);
    }

    private static void a(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        int n2 = (int)Math.ceil(Math.abs(4.0 * d10 / 3.141592653589793));
        double d11 = Math.cos(d8);
        double d12 = Math.sin(d8);
        double d13 = Math.cos(d9);
        double d14 = Math.sin(d9);
        double d15 = d14 * (d11 * (- d4)) - d13 * (d5 * d12);
        double d16 = d14 * (d12 * (- d4)) + d13 * (d5 * d11);
        double d17 = d10 / (double)n2;
        int n3 = 0;
        double d18 = d16;
        double d19 = d15;
        while (n3 < n2) {
            double d20 = d9 + d17;
            double d21 = Math.sin(d20);
            double d22 = Math.cos(d20);
            double d23 = d2 + d22 * (d4 * d11) - d21 * (d5 * d12);
            double d24 = d3 + d22 * (d4 * d12) + d21 * (d5 * d11);
            double d25 = d21 * (d11 * (- d4)) - d22 * (d5 * d12);
            double d26 = d21 * (d12 * (- d4)) + d22 * (d5 * d11);
            double d27 = Math.tan((d20 - d9) / 2.0);
            double d28 = Math.sin(d20 - d9) * (Math.sqrt(4.0 + d27 * (3.0 * d27)) - 1.0) / 3.0;
            double d29 = d6 + d19 * d28;
            double d30 = d7 + d18 * d28;
            double d31 = d23 - d28 * d25;
            double d32 = d24 - d28 * d26;
            path.cubicTo((float)d29, (float)d30, (float)d31, (float)d32, (float)d23, (float)d24);
            ++n3;
            d19 = d25;
            d9 = d20;
            d7 = d24;
            d6 = d23;
            d18 = d26;
        }
    }

    private static void a(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean bl2, boolean bl3) {
        double d2;
        double d3;
        double d4 = Math.toRadians(f8);
        double d5 = Math.cos(d4);
        double d6 = Math.sin(d4);
        double d7 = (d5 * (double)f2 + d6 * (double)f3) / (double)f6;
        double d8 = (d6 * (double)(- f2) + d5 * (double)f3) / (double)f7;
        double d9 = (d5 * (double)f4 + d6 * (double)f5) / (double)f6;
        double d10 = (d6 * (double)(- f4) + d5 * (double)f5) / (double)f7;
        double d11 = d7 - d9;
        double d12 = d8 - d10;
        double d13 = (d7 + d9) / 2.0;
        double d14 = (d8 + d10) / 2.0;
        double d15 = d11 * d11 + d12 * d12;
        if (d15 == 0.0) {
            Log.w((String)"PathParser", (String)" Points are coincident");
            return;
        }
        double d16 = 1.0 / d15 - 0.25;
        if (d16 < 0.0) {
            Log.w((String)"PathParser", (String)("Points are too far apart " + d15));
            float f9 = (float)(Math.sqrt(d15) / 1.99999);
            i.a(path, f2, f3, f4, f5, f6 * f9, f7 * f9, f8, bl2, bl3);
            return;
        }
        double d17 = Math.sqrt(d16);
        double d18 = d11 * d17;
        double d19 = d12 * d17;
        if (bl2 == bl3) {
            d3 = d13 - d19;
            d2 = d18 + d14;
        } else {
            d3 = d19 + d13;
            d2 = d14 - d18;
        }
        double d20 = Math.atan2(d8 - d2, d7 - d3);
        double d21 = Math.atan2(d10 - d2, d9 - d3) - d20;
        boolean bl4 = d21 >= 0.0;
        if (bl3 != bl4) {
            d21 = d21 > 0.0 ? (d21 -= 6.283185307179586) : (d21 += 6.283185307179586);
        }
        double d22 = d3 * (double)f6;
        double d23 = d2 * (double)f7;
        i.a(path, d22 * d5 - d23 * d6, d22 * d6 + d23 * d5, (double)f6, (double)f7, (double)f2, (double)f3, d4, d20, d21);
    }

    /*
     * Unable to fully structure code
     */
    private static void a(Path var0, float[] var1_1, char var2_2, char var3_3, float[] var4_4) {
        var5_5 = var1_1[0];
        var6_6 = var1_1[1];
        var7_7 = var1_1[2];
        var8_8 = var1_1[3];
        var9_9 = var1_1[4];
        var10_10 = var1_1[5];
        switch (var3_3) {
            default: {
                var11_11 = 2;
                break;
            }
            case 'Z': 
            case 'z': {
                var0.close();
                var0.moveTo(var9_9, var10_10);
                var8_8 = var10_10;
                var7_7 = var9_9;
                var6_6 = var10_10;
                var5_5 = var9_9;
                var11_11 = 2;
                break;
            }
            case 'L': 
            case 'M': 
            case 'T': 
            case 'l': 
            case 'm': 
            case 't': {
                var11_11 = 2;
                break;
            }
            case 'H': 
            case 'V': 
            case 'h': 
            case 'v': {
                var11_11 = 1;
                break;
            }
            case 'C': 
            case 'c': {
                var11_11 = 6;
                break;
            }
            case 'Q': 
            case 'S': 
            case 'q': 
            case 's': {
                var11_11 = 4;
                break;
            }
            case 'A': 
            case 'a': {
                var11_11 = 7;
                break;
            }
        }
        var13_13 = var10_10;
        var14_14 = var9_9;
        var15_15 = var6_6;
        var16_16 = var5_5;
        for (var12_12 = 0; var12_12 < var4_4.length; var12_12 += var11_11) {
            switch (var3_3) {
                default: {
                    var26_26 = var13_13;
                    var27_27 = var14_14;
                    var28_28 = var7_7;
                    var29_29 = var15_15;
                    var30_30 = var16_16;
                    var31_31 = var8_8;
                    ** GOTO lbl312
                }
                case 'm': {
                    var27_27 = var16_16 + var4_4[var12_12 + 0];
                    var26_26 = var15_15 + var4_4[var12_12 + 1];
                    if (var12_12 > 0) {
                        var0.rLineTo(var4_4[var12_12 + 0], var4_4[var12_12 + 1]);
                        var28_28 = var7_7;
                        var29_29 = var26_26;
                        var30_30 = var27_27;
                        var26_26 = var13_13;
                        var27_27 = var14_14;
                        var31_31 = var8_8;
                    } else {
                        var0.rMoveTo(var4_4[var12_12 + 0], var4_4[var12_12 + 1]);
                        var28_28 = var7_7;
                        var29_29 = var26_26;
                        var30_30 = var27_27;
                        var31_31 = var8_8;
                    }
                    ** GOTO lbl312
                }
                case 'M': {
                    var27_27 = var4_4[var12_12 + 0];
                    var26_26 = var4_4[var12_12 + 1];
                    if (var12_12 > 0) {
                        var0.lineTo(var4_4[var12_12 + 0], var4_4[var12_12 + 1]);
                        var28_28 = var7_7;
                        var29_29 = var26_26;
                        var30_30 = var27_27;
                        var26_26 = var13_13;
                        var27_27 = var14_14;
                        var31_31 = var8_8;
                    } else {
                        var0.moveTo(var4_4[var12_12 + 0], var4_4[var12_12 + 1]);
                        var28_28 = var7_7;
                        var29_29 = var26_26;
                        var30_30 = var27_27;
                        var31_31 = var8_8;
                    }
                    ** GOTO lbl312
                }
                case 'l': {
                    var0.rLineTo(var4_4[var12_12 + 0], var4_4[var12_12 + 1]);
                    var86_86 = var16_16 + var4_4[var12_12 + 0];
                    var87_87 = var15_15 + var4_4[var12_12 + 1];
                    var28_28 = var7_7;
                    var29_29 = var87_87;
                    var30_30 = var86_86;
                    var26_26 = var13_13;
                    var27_27 = var14_14;
                    var31_31 = var8_8;
                    ** GOTO lbl312
                }
                case 'L': {
                    var0.lineTo(var4_4[var12_12 + 0], var4_4[var12_12 + 1]);
                    var84_84 = var4_4[var12_12 + 0];
                    var85_85 = var4_4[var12_12 + 1];
                    var28_28 = var7_7;
                    var29_29 = var85_85;
                    var30_30 = var84_84;
                    var26_26 = var13_13;
                    var27_27 = var14_14;
                    var31_31 = var8_8;
                    ** GOTO lbl312
                }
                case 'h': {
                    var0.rLineTo(var4_4[var12_12 + 0], 0.0f);
                    var83_83 = var16_16 + var4_4[var12_12 + 0];
                    var26_26 = var13_13;
                    var28_28 = var7_7;
                    var29_29 = var15_15;
                    var30_30 = var83_83;
                    var31_31 = var8_8;
                    var27_27 = var14_14;
                    ** GOTO lbl312
                }
                case 'H': {
                    var0.lineTo(var4_4[var12_12 + 0], var15_15);
                    var82_82 = var4_4[var12_12 + 0];
                    var26_26 = var13_13;
                    var28_28 = var7_7;
                    var29_29 = var15_15;
                    var30_30 = var82_82;
                    var31_31 = var8_8;
                    var27_27 = var14_14;
                    ** GOTO lbl312
                }
                case 'v': {
                    var0.rLineTo(0.0f, var4_4[var12_12 + 0]);
                    var81_81 = var15_15 + var4_4[var12_12 + 0];
                    var27_27 = var14_14;
                    var28_28 = var7_7;
                    var29_29 = var81_81;
                    var30_30 = var16_16;
                    var31_31 = var8_8;
                    var26_26 = var13_13;
                    ** GOTO lbl312
                }
                case 'V': {
                    var79_79 = var4_4[var12_12 + 0];
                    var0.lineTo(var16_16, var79_79);
                    var80_80 = var4_4[var12_12 + 0];
                    var27_27 = var14_14;
                    var28_28 = var7_7;
                    var29_29 = var80_80;
                    var30_30 = var16_16;
                    var31_31 = var8_8;
                    var26_26 = var13_13;
                    ** GOTO lbl312
                }
                case 'c': {
                    var0.rCubicTo(var4_4[var12_12 + 0], var4_4[var12_12 + 1], var4_4[var12_12 + 2], var4_4[var12_12 + 3], var4_4[var12_12 + 4], var4_4[var12_12 + 5]);
                    var75_75 = var16_16 + var4_4[var12_12 + 2];
                    var76_76 = var15_15 + var4_4[var12_12 + 3];
                    var77_77 = var16_16 + var4_4[var12_12 + 4];
                    var78_78 = var15_15 + var4_4[var12_12 + 5];
                    var28_28 = var75_75;
                    var29_29 = var78_78;
                    var30_30 = var77_77;
                    var26_26 = var13_13;
                    var27_27 = var14_14;
                    var31_31 = var76_76;
                    ** GOTO lbl312
                }
                case 'C': {
                    var0.cubicTo(var4_4[var12_12 + 0], var4_4[var12_12 + 1], var4_4[var12_12 + 2], var4_4[var12_12 + 3], var4_4[var12_12 + 4], var4_4[var12_12 + 5]);
                    var71_71 = var4_4[var12_12 + 4];
                    var72_72 = var4_4[var12_12 + 5];
                    var73_73 = var4_4[var12_12 + 2];
                    var74_74 = var4_4[var12_12 + 3];
                    var28_28 = var73_73;
                    var29_29 = var72_72;
                    var30_30 = var71_71;
                    var26_26 = var13_13;
                    var27_27 = var14_14;
                    var31_31 = var74_74;
                    ** GOTO lbl312
                }
                case 's': {
                    if (var2_2 != 'c' && var2_2 != 's' && var2_2 != 'C' && var2_2 != 'S') ** GOTO lbl299
                    var65_65 = var16_16 - var7_7;
                    var66_66 = var15_15 - var8_8;
                    ** GOTO lbl301
                }
                case 'S': {
                    if (var2_2 != 'c' && var2_2 != 's' && var2_2 != 'C' && var2_2 != 'S') ** GOTO lbl285
                    var59_59 = 2.0f * var16_16 - var7_7;
                    var60_60 = 2.0f * var15_15 - var8_8;
                    ** GOTO lbl287
                }
                case 'q': {
                    var0.rQuadTo(var4_4[var12_12 + 0], var4_4[var12_12 + 1], var4_4[var12_12 + 2], var4_4[var12_12 + 3]);
                    var55_55 = var16_16 + var4_4[var12_12 + 0];
                    var56_56 = var15_15 + var4_4[var12_12 + 1];
                    var57_57 = var16_16 + var4_4[var12_12 + 2];
                    var58_58 = var15_15 + var4_4[var12_12 + 3];
                    var28_28 = var55_55;
                    var29_29 = var58_58;
                    var30_30 = var57_57;
                    var26_26 = var13_13;
                    var27_27 = var14_14;
                    var31_31 = var56_56;
                    ** GOTO lbl312
                }
                case 'Q': {
                    var0.quadTo(var4_4[var12_12 + 0], var4_4[var12_12 + 1], var4_4[var12_12 + 2], var4_4[var12_12 + 3]);
                    var51_51 = var4_4[var12_12 + 0];
                    var52_52 = var4_4[var12_12 + 1];
                    var53_53 = var4_4[var12_12 + 2];
                    var54_54 = var4_4[var12_12 + 3];
                    var28_28 = var51_51;
                    var29_29 = var54_54;
                    var30_30 = var53_53;
                    var26_26 = var13_13;
                    var27_27 = var14_14;
                    var31_31 = var52_52;
                    ** GOTO lbl312
                }
                case 't': {
                    if (var2_2 != 'q' && var2_2 != 't' && var2_2 != 'Q' && var2_2 != 'T') break;
                    var45_45 = var16_16 - var7_7;
                    var46_46 = var15_15 - var8_8;
                    ** GOTO lbl273
                }
                case 'T': {
                    if (var2_2 == 'q' || var2_2 == 't' || var2_2 == 'Q' || var2_2 == 'T') {
                        var16_16 = 2.0f * var16_16 - var7_7;
                        var15_15 = 2.0f * var15_15 - var8_8;
                    }
                    var41_41 = var4_4[var12_12 + 0];
                    var42_42 = var4_4[var12_12 + 1];
                    var0.quadTo(var16_16, var15_15, var41_41, var42_42);
                    var43_43 = var4_4[var12_12 + 0];
                    var44_44 = var4_4[var12_12 + 1];
                    var31_31 = var15_15;
                    var28_28 = var16_16;
                    var29_29 = var44_44;
                    var30_30 = var43_43;
                    var26_26 = var13_13;
                    var27_27 = var14_14;
                    ** GOTO lbl312
                }
                case 'a': {
                    var32_32 = var16_16 + var4_4[var12_12 + 5];
                    var33_33 = var15_15 + var4_4[var12_12 + 6];
                    var34_34 = var4_4[var12_12 + 0];
                    var35_35 = var4_4[var12_12 + 1];
                    var36_36 = var4_4[var12_12 + 2];
                    var37_37 = var4_4[var12_12 + 3] != 0.0f;
                    var38_38 = var4_4[var12_12 + 4] != 0.0f;
                    i.a(var0, var16_16, var15_15, var32_32, var33_33, var34_34, var35_35, var36_36, var37_37, var38_38);
                    var39_39 = var16_16 + var4_4[var12_12 + 5];
                    var40_40 = var15_15 + var4_4[var12_12 + 6];
                    var26_26 = var13_13;
                    var27_27 = var14_14;
                    var28_28 = var39_39;
                    var29_29 = var40_40;
                    var30_30 = var39_39;
                    var31_31 = var40_40;
                    ** GOTO lbl312
                }
                case 'A': {
                    var17_17 = var4_4[var12_12 + 5];
                    var18_18 = var4_4[var12_12 + 6];
                    var19_19 = var4_4[var12_12 + 0];
                    var20_20 = var4_4[var12_12 + 1];
                    var21_21 = var4_4[var12_12 + 2];
                    var22_22 = var4_4[var12_12 + 3] != 0.0f;
                    if (var4_4[var12_12 + 4] != 0.0f) {
                        var23_23 = true;
                    } else {
                        var23_23 = false;
                        ** break;
                    }
lbl261: // 2 sources:
                    i.a(var0, var16_16, var15_15, var17_17, var18_18, var19_19, var20_20, var21_21, var22_22, var23_23);
                    var24_24 = var4_4[var12_12 + 5];
                    var25_25 = var4_4[var12_12 + 6];
                    var26_26 = var13_13;
                    var27_27 = var14_14;
                    var28_28 = var24_24;
                    var29_29 = var25_25;
                    var30_30 = var24_24;
                    var31_31 = var25_25;
                    ** GOTO lbl312
                }
            }
            var46_46 = 0.0f;
            var45_45 = 0.0f;
lbl273: // 2 sources:
            var0.rQuadTo(var45_45, var46_46, var4_4[var12_12 + 0], var4_4[var12_12 + 1]);
            var47_47 = var16_16 + var45_45;
            var48_48 = var46_46 + var15_15;
            var49_49 = var16_16 + var4_4[var12_12 + 0];
            var50_50 = var15_15 + var4_4[var12_12 + 1];
            var28_28 = var47_47;
            var29_29 = var50_50;
            var30_30 = var49_49;
            var26_26 = var13_13;
            var27_27 = var14_14;
            var31_31 = var48_48;
            ** GOTO lbl312
lbl285: // 1 sources:
            var60_60 = var15_15;
            var59_59 = var16_16;
lbl287: // 2 sources:
            var0.cubicTo(var59_59, var60_60, var4_4[var12_12 + 0], var4_4[var12_12 + 1], var4_4[var12_12 + 2], var4_4[var12_12 + 3]);
            var61_61 = var4_4[var12_12 + 0];
            var62_62 = var4_4[var12_12 + 1];
            var63_63 = var4_4[var12_12 + 2];
            var64_64 = var4_4[var12_12 + 3];
            var28_28 = var61_61;
            var29_29 = var64_64;
            var30_30 = var63_63;
            var26_26 = var13_13;
            var27_27 = var14_14;
            var31_31 = var62_62;
            ** GOTO lbl312
lbl299: // 1 sources:
            var65_65 = 0.0f;
            var66_66 = 0.0f;
lbl301: // 2 sources:
            var0.rCubicTo(var65_65, var66_66, var4_4[var12_12 + 0], var4_4[var12_12 + 1], var4_4[var12_12 + 2], var4_4[var12_12 + 3]);
            var67_67 = var16_16 + var4_4[var12_12 + 0];
            var68_68 = var15_15 + var4_4[var12_12 + 1];
            var69_69 = var16_16 + var4_4[var12_12 + 2];
            var70_70 = var15_15 + var4_4[var12_12 + 3];
            var28_28 = var67_67;
            var29_29 = var70_70;
            var30_30 = var69_69;
            var26_26 = var13_13;
            var27_27 = var14_14;
            var31_31 = var68_68;
lbl312: // 21 sources:
            var13_13 = var26_26;
            var14_14 = var27_27;
            var15_15 = var29_29;
            var16_16 = var30_30;
            var2_2 = var3_3;
            var8_8 = var31_31;
            var7_7 = var28_28;
        }
        var1_1[0] = var16_16;
        var1_1[1] = var15_15;
        var1_1[2] = var7_7;
        var1_1[3] = var8_8;
        var1_1[4] = var14_14;
        var1_1[5] = var13_13;
    }

    public static void a(i[] arri, Path path) {
        float[] arrf = new float[6];
        char c2 = 'm';
        int n2 = 0;
        while (n2 < arri.length) {
            i.a(path, arrf, c2, arri[n2].a, arri[n2].b);
            c2 = arri[n2].a;
            ++n2;
        }
    }
}

