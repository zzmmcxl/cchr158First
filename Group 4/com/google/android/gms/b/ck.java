/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.fn;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.hb;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class ck
extends fn {
    private final String a = "play.google.com";
    private final String b = "market";
    private final int c = 10;
    private final String d;
    private final hb e;

    public ck(hb hb2, String string) {
        this.e = hb2;
        this.d = string;
    }

    public Intent a(String string) {
        Uri uri = Uri.parse((String)string);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setData(uri);
        return intent;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    @Override
    public void a() {
        block21 : {
            var1_1 = 0;
            var2_2 = this.d;
            while (var1_1 < 10) {
                var5_6 = var1_1 + 1;
                var6_8 = new URL(var2_2);
                var13_10 = "play.google.com".equalsIgnoreCase(var6_8.getHost());
                if (var13_10) {
                    var3_12 = var2_2;
                    break block21;
                }
                if ("market".equalsIgnoreCase(var6_8.getProtocol())) {
                    var3_12 = var2_2;
                    break block21;
                }
                var14_11 = (HttpURLConnection)var6_8.openConnection();
                try {
                    block22 : {
                        g.c().a(this.e.getContext(), this.e.n().b, false, var14_11);
                        var16_3 = var14_11.getResponseCode();
                        var17_4 = var14_11.getHeaderFields();
                        if (var16_3 < 300 || var16_3 > 399) ** GOTO lbl36
                        if (var17_4.containsKey("Location")) {
                            var23_9 = var17_4.get("Location");
                        } else {
                            var22_7 = var17_4.containsKey("location");
                            var23_9 = null;
                            if (!var22_7) break block22;
                            var23_9 = var17_4.get("location");
                        }
                    }
                    if (var23_9 == null || var23_9.size() <= 0) ** GOTO lbl36
                    var18_5 = var23_9.get(0);
                    ** GOTO lbl37
                }
                catch (Throwable var15_14) {
                    var14_11.disconnect();
                    throw var15_14;
lbl36: // 2 sources:
                    var18_5 = "";
lbl37: // 2 sources:
                    if (TextUtils.isEmpty((CharSequence)var18_5)) {
                        fp.d("Arrived at landing page, this ideally should not happen. Will open it in browser.");
                        var14_11.disconnect();
                        var3_12 = var2_2;
                    }
                    var14_11.disconnect();
                    var1_1 = var5_6;
                    var2_2 = var18_5;
                    continue;
                    catch (IndexOutOfBoundsException var11_15) {
                        var12_16 = var11_15;
                        var3_12 = var2_2;
                        ** GOTO lbl73
                        catch (IOException var9_17) {
                            var10_18 = var9_17;
                            var3_12 = var2_2;
                            ** GOTO lbl68
                            catch (RuntimeException var7_19) {
                                var8_20 = var7_19;
                                var3_12 = var2_2;
                                ** GOTO lbl63
                                catch (RuntimeException var21_21) {
                                    var3_12 = var18_5;
                                    var8_20 = var21_21;
                                }
lbl63: // 2 sources:
                                fp.c("Error while pinging URL: " + var3_12, var8_20);
                            }
                            catch (IOException var20_22) {
                                var3_12 = var18_5;
                                var10_18 = var20_22;
                            }
lbl68: // 2 sources:
                            fp.c("Error while pinging URL: " + var3_12, var10_18);
                        }
                        catch (IndexOutOfBoundsException var19_23) {
                            var3_12 = var18_5;
                            var12_16 = var19_23;
                        }
lbl73: // 2 sources:
                        fp.c("Error while parsing ping URL: " + var3_12, var12_16);
                    }
                }
                break block21;
            }
            var3_12 = var2_2;
        }
        var4_13 = this.a(var3_12);
        g.c().a(this.e.getContext(), var4_13);
    }
}

