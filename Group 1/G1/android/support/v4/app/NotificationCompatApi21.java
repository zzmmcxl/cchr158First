package android.support.v4.app;

import java.util.Iterator;
import java.util.ArrayList;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import android.content.Context;
import android.app.Notification$Builder;
import android.app.PendingIntent;
import android.app.Notification;
import android.os.Parcelable;
import android.os.Bundle;
import android.app.RemoteInput$Builder;
import android.app.RemoteInput;

class NotificationCompatApi21
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
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_MESSAGES = "messages";
    private static final String KEY_ON_READ = "on_read";
    private static final String KEY_ON_REPLY = "on_reply";
    private static final String KEY_PARTICIPANTS = "participants";
    private static final String KEY_REMOTE_INPUT = "remote_input";
    private static final String KEY_TEXT = "text";
    private static final String KEY_TIMESTAMP = "timestamp";
    
    NotificationCompatApi21() {
        super();
    }
    
    private static RemoteInput fromCompatRemoteInput(final RemoteInputCompatBase.RemoteInput remoteInput) {
        return new RemoteInput$Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras()).build();
    }
    
    static Bundle getBundleForUnreadConversation(final NotificationCompatBase.UnreadConversation unreadConversation) {
        if (unreadConversation == null) {
            return null;
        }
        final Bundle bundle = new Bundle();
        final String[] participants = unreadConversation.getParticipants();
        String s = null;
        if (participants != null) {
            final int length = unreadConversation.getParticipants().length;
            s = null;
            if (length > 1) {
                s = unreadConversation.getParticipants()[0];
            }
        }
        final Parcelable[] array = new Parcelable[unreadConversation.getMessages().length];
        for (int i = 0; i < array.length; ++i) {
            final Bundle bundle2 = new Bundle();
            bundle2.putString("text", unreadConversation.getMessages()[i]);
            bundle2.putString("author", s);
            array[i] = (Parcelable)bundle2;
        }
        bundle.putParcelableArray("messages", array);
        final RemoteInputCompatBase.RemoteInput remoteInput = unreadConversation.getRemoteInput();
        if (remoteInput != null) {
            bundle.putParcelable("remote_input", (Parcelable)fromCompatRemoteInput(remoteInput));
        }
        bundle.putParcelable("on_reply", (Parcelable)unreadConversation.getReplyPendingIntent());
        bundle.putParcelable("on_read", (Parcelable)unreadConversation.getReadPendingIntent());
        bundle.putStringArray("participants", unreadConversation.getParticipants());
        bundle.putLong("timestamp", unreadConversation.getLatestTimestamp());
        return bundle;
    }
    
    public static String getCategory(final Notification notification) {
        return notification.category;
    }
    
    static NotificationCompatBase.UnreadConversation getUnreadConversationFromBundle(final Bundle bundle, final NotificationCompatBase.UnreadConversation.Factory factory, final RemoteInputCompatBase.RemoteInput.Factory factory2) {
        if (bundle != null) {
            final Parcelable[] parcelableArray = bundle.getParcelableArray("messages");
            String[] array = null;
            if (parcelableArray != null) {
                final String[] array2 = new String[parcelableArray.length];
                int n = 1;
                for (int i = 0; i < array2.length; ++i) {
                    if (!(parcelableArray[i] instanceof Bundle)) {
                        n = 0;
                        break;
                    }
                    array2[i] = ((Bundle)parcelableArray[i]).getString("text");
                    if (array2[i] == null) {
                        n = 0;
                        break;
                    }
                }
                if (n == 0) {
                    return null;
                }
                array = array2;
            }
            final PendingIntent pendingIntent = (PendingIntent)bundle.getParcelable("on_read");
            final PendingIntent pendingIntent2 = (PendingIntent)bundle.getParcelable("on_reply");
            final RemoteInput remoteInput = (RemoteInput)bundle.getParcelable("remote_input");
            final String[] stringArray = bundle.getStringArray("participants");
            if (stringArray != null && stringArray.length == 1) {
                RemoteInputCompatBase.RemoteInput compatRemoteInput = null;
                if (remoteInput != null) {
                    compatRemoteInput = toCompatRemoteInput(remoteInput, factory2);
                }
                return factory.build(array, compatRemoteInput, pendingIntent2, pendingIntent, stringArray, bundle.getLong("timestamp"));
            }
        }
        return null;
    }
    
    private static RemoteInputCompatBase.RemoteInput toCompatRemoteInput(final RemoteInput remoteInput, final RemoteInputCompatBase.RemoteInput.Factory factory) {
        return factory.build(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), remoteInput.getExtras());
    }
}
