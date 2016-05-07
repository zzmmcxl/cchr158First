/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.bm;
import android.support.v4.app.ck;
import android.support.v4.app.dc;
import android.support.v4.app.de;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class cq {
    private static final Object a = new Object();
    private static Field b;
    private static boolean c;
    private static final Object d;

    static {
        d = new Object();
    }

    public static Bundle a(Notification.Builder builder, ck ck2) {
        builder.addAction(ck2.a(), ck2.b(), ck2.c());
        Bundle bundle = new Bundle(ck2.d());
        if (ck2.f() == null) return bundle;
        bundle.putParcelableArray("android.support.remoteInputs", (Parcelable[])de.a(ck2.f()));
        return bundle;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public static Bundle a(Notification var0) {
        var1_1 = cq.a;
        // MONITORENTER : var1_1
        if (cq.c) {
            // MONITOREXIT : var1_1
            return null;
        }
        try {
            if (cq.b == null) {
                var8_2 = Notification.class.getDeclaredField("extras");
                if (!Bundle.class.isAssignableFrom(var8_2.getType())) {
                    Log.e((String)"NotificationCompat", (String)"Notification.extras field is not of type Bundle");
                    cq.c = true;
                    // MONITOREXIT : var1_1
                    return null;
                }
                var8_2.setAccessible(true);
                cq.b = var8_2;
            }
            if ((var7_3 = (Bundle)cq.b.get((Object)var0)) == null) {
                var7_3 = new Bundle();
                cq.b.set((Object)var0, (Object)var7_3);
            }
            // MONITOREXIT : var1_1
            return var7_3;
        }
        catch (IllegalAccessException var5_4) {
            Log.e((String)"NotificationCompat", (String)"Unable to access notification extras", (Throwable)var5_4);
            ** GOTO lbl26
            catch (NoSuchFieldException var3_5) {
                Log.e((String)"NotificationCompat", (String)"Unable to access notification extras", (Throwable)var3_5);
            }
lbl26: // 2 sources:
            cq.c = true;
            // MONITOREXIT : var1_1
            return null;
        }
    }

    public static SparseArray a(List list) {
        SparseArray sparseArray = null;
        int n2 = list.size();
        int n3 = 0;
        while (n3 < n2) {
            Bundle bundle = (Bundle)list.get(n3);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(n3, (Object)bundle);
            }
            ++n3;
        }
        return sparseArray;
    }

    public static void a(bm bm2, CharSequence charSequence, boolean bl2, CharSequence charSequence2, Bitmap bitmap, Bitmap bitmap2, boolean bl3) {
        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(bm2.a()).setBigContentTitle(charSequence).bigPicture(bitmap);
        if (bl3) {
            bigPictureStyle.bigLargeIcon(bitmap2);
        }
        if (!bl2) return;
        bigPictureStyle.setSummaryText(charSequence2);
    }

    public static void a(bm bm2, CharSequence charSequence, boolean bl2, CharSequence charSequence2, CharSequence charSequence3) {
        Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle(bm2.a()).setBigContentTitle(charSequence).bigText(charSequence3);
        if (!bl2) return;
        bigTextStyle.setSummaryText(charSequence2);
    }

    public static void a(bm bm2, CharSequence charSequence, boolean bl2, CharSequence charSequence2, ArrayList arrayList) {
        Notification.InboxStyle inboxStyle = new Notification.InboxStyle(bm2.a()).setBigContentTitle(charSequence);
        if (bl2) {
            inboxStyle.setSummaryText(charSequence2);
        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            inboxStyle.addLine((CharSequence)iterator.next());
        }
    }
}

