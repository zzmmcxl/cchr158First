package android.support.v4.app;

import java.util.ArrayList;
import java.util.List;
import android.app.PendingIntent;
import android.support.annotation.ColorInt;
import android.os.Parcelable;
import android.os.Bundle;
import android.os.Build$VERSION;
import android.app.Notification;
import android.graphics.Bitmap;

public static final class CarExtender implements NotificationCompat.Extender
{
    private static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
    private static final String EXTRA_COLOR = "app_color";
    private static final String EXTRA_CONVERSATION = "car_conversation";
    private static final String EXTRA_LARGE_ICON = "large_icon";
    private static final String TAG = "CarExtender";
    private int mColor;
    private Bitmap mLargeIcon;
    private UnreadConversation mUnreadConversation;
    
    public CarExtender() {
        super();
        this.mColor = 0;
    }
    
    public CarExtender(final Notification notification) {
        super();
        this.mColor = 0;
        if (Build$VERSION.SDK_INT >= 21) {
            Bundle bundle;
            if (NotificationCompat.getExtras(notification) == null) {
                bundle = null;
            }
            else {
                bundle = NotificationCompat.getExtras(notification).getBundle("android.car.EXTENSIONS");
            }
            if (bundle != null) {
                this.mLargeIcon = (Bitmap)bundle.getParcelable("large_icon");
                this.mColor = bundle.getInt("app_color", 0);
                this.mUnreadConversation = (UnreadConversation)NotificationCompat.access$200().getUnreadConversationFromBundle(bundle.getBundle("car_conversation"), UnreadConversation.FACTORY, RemoteInput.FACTORY);
            }
        }
    }
    
    @Override
    public NotificationCompat.Builder extend(final NotificationCompat.Builder builder) {
        if (Build$VERSION.SDK_INT < 21) {
            return builder;
        }
        final Bundle bundle = new Bundle();
        if (mLargeIcon != null) {
            bundle.putParcelable("large_icon", (Parcelable)mLargeIcon);
        }
        if (mColor != 0) {
            bundle.putInt("app_color", mColor);
        }
        if (mUnreadConversation != null) {
            bundle.putBundle("car_conversation", NotificationCompat.access$200().getBundleForUnreadConversation((NotificationCompatBase.UnreadConversation)mUnreadConversation));
        }
        builder.getExtras().putBundle("android.car.EXTENSIONS", bundle);
        return builder;
    }
    
    @ColorInt
    public int getColor() {
        return mColor;
    }
    
    public Bitmap getLargeIcon() {
        return mLargeIcon;
    }
    
    public UnreadConversation getUnreadConversation() {
        return mUnreadConversation;
    }
    
    public CarExtender setColor(@ColorInt final int mColor) {
        this.mColor = mColor;
        return this;
    }
    
    public CarExtender setLargeIcon(final Bitmap mLargeIcon) {
        this.mLargeIcon = mLargeIcon;
        return this;
    }
    
    public CarExtender setUnreadConversation(final UnreadConversation mUnreadConversation) {
        this.mUnreadConversation = mUnreadConversation;
        return this;
    }
}
