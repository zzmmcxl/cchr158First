package android.support.v4.app;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import android.net.Uri;
import android.widget.RemoteViews;
import android.content.Context;
import android.graphics.Bitmap;
import android.app.PendingIntent;
import android.os.Parcelable;
import java.util.Iterator;
import android.app.Notification;
import android.os.Bundle;
import java.util.ArrayList;
import android.os.Build$VERSION;
import android.support.annotation.ColorInt;

public class NotificationCompat
{
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    @ColorInt
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
    public static final String EXTRA_BIG_TEXT = "android.bigText";
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_INFO_TEXT = "android.infoText";
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
    public static final String EXTRA_PEOPLE = "android.people";
    public static final String EXTRA_PICTURE = "android.picture";
    public static final String EXTRA_PROGRESS = "android.progress";
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";
    public static final String EXTRA_SMALL_ICON = "android.icon";
    public static final String EXTRA_SUB_TEXT = "android.subText";
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
    public static final String EXTRA_TEMPLATE = "android.template";
    public static final String EXTRA_TEXT = "android.text";
    public static final String EXTRA_TEXT_LINES = "android.textLines";
    public static final String EXTRA_TITLE = "android.title";
    public static final String EXTRA_TITLE_BIG = "android.title.big";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    private static final NotificationCompatImpl IMPL;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;
    
    static {
        if (Build$VERSION.SDK_INT >= 21) {
            IMPL = (NotificationCompatImpl)new NotificationCompatImplApi21();
            return;
        }
        if (Build$VERSION.SDK_INT >= 20) {
            IMPL = (NotificationCompatImpl)new NotificationCompatImplApi20();
            return;
        }
        if (Build$VERSION.SDK_INT >= 19) {
            IMPL = (NotificationCompatImpl)new NotificationCompatImplKitKat();
            return;
        }
        if (Build$VERSION.SDK_INT >= 16) {
            IMPL = (NotificationCompatImpl)new NotificationCompatImplJellybean();
            return;
        }
        if (Build$VERSION.SDK_INT >= 14) {
            IMPL = (NotificationCompatImpl)new NotificationCompatImplIceCreamSandwich();
            return;
        }
        if (Build$VERSION.SDK_INT >= 11) {
            IMPL = (NotificationCompatImpl)new NotificationCompatImplHoneycomb();
            return;
        }
        if (Build$VERSION.SDK_INT >= 9) {
            IMPL = (NotificationCompatImpl)new NotificationCompatImplGingerbread();
            return;
        }
        IMPL = (NotificationCompatImpl)new NotificationCompatImplBase();
    }
    
    public NotificationCompat() {
        super();
    }
    
    static /* synthetic */ void access$000(final NotificationBuilderWithActions notificationBuilderWithActions, final ArrayList list) {
        addActionsToBuilder(notificationBuilderWithActions, list);
    }
    
    static /* synthetic */ void access$100(final NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, final Style style) {
        addStyleToBuilderJellybean(notificationBuilderWithBuilderAccessor, style);
    }
    
    static /* synthetic */ NotificationCompatImpl access$200() {
        return IMPL;
    }
    
    static /* synthetic */ Notification[] access$500(final Bundle bundle, final String s) {
        return getNotificationArrayFromBundle(bundle, s);
    }
    
    private static void addActionsToBuilder(final NotificationBuilderWithActions notificationBuilderWithActions, final ArrayList<Action> list) {
        final Iterator<Action> iterator = list.iterator();
        while (iterator.hasNext()) {
            notificationBuilderWithActions.addAction(iterator.next());
        }
    }
    
    private static void addStyleToBuilderJellybean(final NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, final Style style) {
        if (style != null) {
            if (style instanceof BigTextStyle) {
                final BigTextStyle bigTextStyle = (BigTextStyle)style;
                NotificationCompatJellybean.addBigTextStyle(notificationBuilderWithBuilderAccessor, bigTextStyle.mBigContentTitle, bigTextStyle.mSummaryTextSet, bigTextStyle.mSummaryText, bigTextStyle.mBigText);
            }
            else {
                if (style instanceof InboxStyle) {
                    final InboxStyle inboxStyle = (InboxStyle)style;
                    NotificationCompatJellybean.addInboxStyle(notificationBuilderWithBuilderAccessor, inboxStyle.mBigContentTitle, inboxStyle.mSummaryTextSet, inboxStyle.mSummaryText, inboxStyle.mTexts);
                    return;
                }
                if (style instanceof BigPictureStyle) {
                    final BigPictureStyle bigPictureStyle = (BigPictureStyle)style;
                    NotificationCompatJellybean.addBigPictureStyle(notificationBuilderWithBuilderAccessor, bigPictureStyle.mBigContentTitle, bigPictureStyle.mSummaryTextSet, bigPictureStyle.mSummaryText, bigPictureStyle.mPicture, bigPictureStyle.mBigLargeIcon, bigPictureStyle.mBigLargeIconSet);
                }
            }
        }
    }
    
    public static Action getAction(final Notification notification, final int n) {
        return IMPL.getAction(notification, n);
    }
    
    public static int getActionCount(final Notification notification) {
        return IMPL.getActionCount(notification);
    }
    
    public static String getCategory(final Notification notification) {
        return IMPL.getCategory(notification);
    }
    
    public static Bundle getExtras(final Notification notification) {
        return IMPL.getExtras(notification);
    }
    
    public static String getGroup(final Notification notification) {
        return IMPL.getGroup(notification);
    }
    
    public static boolean getLocalOnly(final Notification notification) {
        return IMPL.getLocalOnly(notification);
    }
    
    private static Notification[] getNotificationArrayFromBundle(final Bundle bundle, final String s) {
        final Parcelable[] parcelableArray = bundle.getParcelableArray(s);
        if (parcelableArray instanceof Notification[] || parcelableArray == null) {
            return (Notification[])parcelableArray;
        }
        final Notification[] array = new Notification[parcelableArray.length];
        for (int i = 0; i < parcelableArray.length; ++i) {
            array[i] = (Notification)parcelableArray[i];
        }
        bundle.putParcelableArray(s, (Parcelable[])array);
        return array;
    }
    
    public static String getSortKey(final Notification notification) {
        return IMPL.getSortKey(notification);
    }
    
    public static boolean isGroupSummary(final Notification notification) {
        return IMPL.isGroupSummary(notification);
    }
}
