/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.SystemClock;
import android.support.v4.app.bm;
import android.support.v4.app.ck;
import android.support.v7.b.e;
import android.support.v7.b.g;
import android.support.v7.b.h;
import android.support.v7.b.i;
import android.support.v7.b.j;
import android.widget.RemoteViews;
import java.text.NumberFormat;
import java.util.List;

class bd {
    private static int a(int n2) {
        if (n2 > 3) return i.notification_template_big_media;
        return i.notification_template_big_media_narrow;
    }

    private static RemoteViews a(Context context, ck ck2) {
        boolean bl2 = ck2.c() == null;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), i.notification_media_action);
        remoteViews.setImageViewResource(g.action0, ck2.a());
        if (!bl2) {
            remoteViews.setOnClickPendingIntent(g.action0, ck2.c());
        }
        if (Build.VERSION.SDK_INT < 15) return remoteViews;
        remoteViews.setContentDescription(g.action0, ck2.b());
        return remoteViews;
    }

    private static RemoteViews a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n2, Bitmap bitmap, CharSequence charSequence4, boolean bl2, long l2, int n3, boolean bl3) {
        boolean bl4;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), n3);
        if (bitmap != null && Build.VERSION.SDK_INT >= 16) {
            remoteViews.setViewVisibility(g.icon, 0);
            remoteViews.setImageViewBitmap(g.icon, bitmap);
        } else {
            remoteViews.setViewVisibility(g.icon, 8);
        }
        if (charSequence != null) {
            remoteViews.setTextViewText(g.title, charSequence);
        }
        boolean bl5 = false;
        if (charSequence2 != null) {
            remoteViews.setTextViewText(g.text, charSequence2);
            bl5 = true;
        }
        if (charSequence3 != null) {
            remoteViews.setTextViewText(g.info, charSequence3);
            remoteViews.setViewVisibility(g.info, 0);
            bl4 = true;
        } else if (n2 > 0) {
            if (n2 > context.getResources().getInteger(h.status_bar_notification_info_maxnum)) {
                remoteViews.setTextViewText(g.info, (CharSequence)context.getResources().getString(j.status_bar_notification_info_overflow));
            } else {
                NumberFormat numberFormat = NumberFormat.getIntegerInstance();
                remoteViews.setTextViewText(g.info, (CharSequence)numberFormat.format(n2));
            }
            remoteViews.setViewVisibility(g.info, 0);
            bl4 = true;
        } else {
            remoteViews.setViewVisibility(g.info, 8);
            bl4 = bl5;
        }
        boolean bl6 = false;
        if (charSequence4 != null) {
            int n4 = Build.VERSION.SDK_INT;
            bl6 = false;
            if (n4 >= 16) {
                remoteViews.setTextViewText(g.text, charSequence4);
                if (charSequence2 != null) {
                    remoteViews.setTextViewText(g.text2, charSequence2);
                    remoteViews.setViewVisibility(g.text2, 0);
                    bl6 = true;
                } else {
                    remoteViews.setViewVisibility(g.text2, 8);
                    bl6 = false;
                }
                if (bl6 && Build.VERSION.SDK_INT >= 16) {
                    if (bl3) {
                        float f2 = context.getResources().getDimensionPixelSize(e.notification_subtext_size);
                        remoteViews.setTextViewTextSize(g.text, 0, f2);
                    }
                    remoteViews.setViewPadding(g.line1, 0, 0, 0, 0);
                }
            }
        }
        if (l2 != 0) {
            if (bl2) {
                remoteViews.setViewVisibility(g.chronometer, 0);
                remoteViews.setLong(g.chronometer, "setBase", l2 + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
                remoteViews.setBoolean(g.chronometer, "setStarted", true);
            } else {
                remoteViews.setViewVisibility(g.time, 0);
                remoteViews.setLong(g.time, "setTime", l2);
            }
        }
        int n5 = g.line3;
        int n6 = bl4 ? 0 : 8;
        remoteViews.setViewVisibility(n5, n6);
        return remoteViews;
    }

    private static RemoteViews a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n2, Bitmap bitmap, CharSequence charSequence4, boolean bl2, long l2, List list, boolean bl3, PendingIntent pendingIntent) {
        int n3 = Math.min(list.size(), 5);
        RemoteViews remoteViews = bd.a(context, charSequence, charSequence2, charSequence3, n2, bitmap, charSequence4, bl2, l2, bd.a(n3), false);
        remoteViews.removeAllViews(g.media_actions);
        if (n3 > 0) {
            for (int i2 = 0; i2 < n3; ++i2) {
                RemoteViews remoteViews2 = bd.a(context, (ck)list.get(i2));
                remoteViews.addView(g.media_actions, remoteViews2);
            }
        }
        if (bl3) {
            remoteViews.setViewVisibility(g.cancel_action, 0);
            remoteViews.setInt(g.cancel_action, "setAlpha", context.getResources().getInteger(h.cancel_button_image_alpha));
            remoteViews.setOnClickPendingIntent(g.cancel_action, pendingIntent);
            return remoteViews;
        }
        remoteViews.setViewVisibility(g.cancel_action, 8);
        return remoteViews;
    }

    private static RemoteViews a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n2, Bitmap bitmap, CharSequence charSequence4, boolean bl2, long l2, List list, int[] arrn, boolean bl3, PendingIntent pendingIntent) {
        RemoteViews remoteViews = bd.a(context, charSequence, charSequence2, charSequence3, n2, bitmap, charSequence4, bl2, l2, i.notification_template_media, true);
        int n3 = list.size();
        int n4 = arrn == null ? 0 : Math.min(arrn.length, 3);
        remoteViews.removeAllViews(g.media_actions);
        if (n4 > 0) {
            for (int i2 = 0; i2 < n4; ++i2) {
                if (i2 >= n3) {
                    Object[] arrobject = new Object[]{i2, n3 - 1};
                    throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", arrobject));
                }
                RemoteViews remoteViews2 = bd.a(context, (ck)list.get(arrn[i2]));
                remoteViews.addView(g.media_actions, remoteViews2);
            }
        }
        if (bl3) {
            remoteViews.setViewVisibility(g.end_padder, 8);
            remoteViews.setViewVisibility(g.cancel_action, 0);
            remoteViews.setOnClickPendingIntent(g.cancel_action, pendingIntent);
            remoteViews.setInt(g.cancel_action, "setAlpha", context.getResources().getInteger(h.cancel_button_image_alpha));
            return remoteViews;
        }
        remoteViews.setViewVisibility(g.end_padder, 0);
        remoteViews.setViewVisibility(g.cancel_action, 8);
        return remoteViews;
    }

    public static void a(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n2, Bitmap bitmap, CharSequence charSequence4, boolean bl2, long l2, List list, boolean bl3, PendingIntent pendingIntent) {
        notification.bigContentView = bd.a(context, charSequence, charSequence2, charSequence3, n2, bitmap, charSequence4, bl2, l2, list, bl3, pendingIntent);
        if (!bl3) return;
        notification.flags = 2 | notification.flags;
    }

    public static void a(bm bm2, Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n2, Bitmap bitmap, CharSequence charSequence4, boolean bl2, long l2, List list, int[] arrn, boolean bl3, PendingIntent pendingIntent) {
        RemoteViews remoteViews = bd.a(context, charSequence, charSequence2, charSequence3, n2, bitmap, charSequence4, bl2, l2, list, arrn, bl3, pendingIntent);
        bm2.a().setContent(remoteViews);
        if (!bl3) return;
        bm2.a().setOngoing(true);
    }
}

