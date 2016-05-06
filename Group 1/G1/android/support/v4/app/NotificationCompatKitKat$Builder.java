package android.support.v4.app;

import android.util.SparseArray;
import java.util.ArrayList;
import android.graphics.Bitmap;
import android.app.PendingIntent;
import android.widget.RemoteViews;
import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import java.util.List;
import android.app.Notification$Builder;

public static class Builder implements NotificationBuilderWithBuilderAccessor, NotificationBuilderWithActions
{
    private Notification$Builder b;
    private List<Bundle> mActionExtrasList;
    private Bundle mExtras;
    
    public Builder(final Context context, final Notification notification, final CharSequence contentTitle, final CharSequence contentText, final CharSequence contentInfo, final RemoteViews remoteViews, final int number, final PendingIntent contentIntent, final PendingIntent pendingIntent, final Bitmap largeIcon, final int n, final int n2, final boolean b, final boolean showWhen, final boolean usesChronometer, final int priority, final CharSequence subText, final boolean b2, final ArrayList<String> list, final Bundle bundle, final String s, final boolean b3, final String s2) {
        super();
        this.mActionExtrasList = new ArrayList<Bundle>();
        this.b = new Notification$Builder(context).setWhen(notification.when).setShowWhen(showWhen).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((0x2 & notification.flags) != 0x0).setOnlyAlertOnce((0x8 & notification.flags) != 0x0).setAutoCancel((0x10 & notification.flags) != 0x0).setDefaults(notification.defaults).setContentTitle(contentTitle).setContentText(contentText).setSubText(subText).setContentInfo(contentInfo).setContentIntent(contentIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent, (0x80 & notification.flags) != 0x0).setLargeIcon(largeIcon).setNumber(number).setUsesChronometer(usesChronometer).setPriority(priority).setProgress(n, n2, b);
        this.mExtras = new Bundle();
        if (bundle != null) {
            this.mExtras.putAll(bundle);
        }
        if (list != null && !list.isEmpty()) {
            this.mExtras.putStringArray("android.people", (String[])list.<String>toArray(new String[list.size()]));
        }
        if (b2) {
            this.mExtras.putBoolean("android.support.localOnly", true);
        }
        if (s != null) {
            this.mExtras.putString("android.support.groupKey", s);
            if (b3) {
                this.mExtras.putBoolean("android.support.isGroupSummary", true);
            }
            else {
                this.mExtras.putBoolean("android.support.useSideChannel", true);
            }
        }
        if (s2 != null) {
            this.mExtras.putString("android.support.sortKey", s2);
        }
    }
    
    @Override
    public void addAction(final NotificationCompatBase.Action action) {
        mActionExtrasList.add(NotificationCompatJellybean.writeActionAndGetExtras(b, action));
    }
    
    @Override
    public Notification build() {
        final SparseArray<Bundle> buildActionExtrasMap = NotificationCompatJellybean.buildActionExtrasMap(mActionExtrasList);
        if (buildActionExtrasMap != null) {
            mExtras.putSparseParcelableArray("android.support.actionExtras", (SparseArray)buildActionExtrasMap);
        }
        b.setExtras(mExtras);
        return b.build();
    }
    
    @Override
    public Notification$Builder getBuilder() {
        return b;
    }
}
