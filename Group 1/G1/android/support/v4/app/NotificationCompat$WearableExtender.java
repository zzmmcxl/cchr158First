package android.support.v4.app;

import java.util.List;
import android.os.Bundle;
import java.util.Collection;
import java.util.Collections;
import android.os.Parcelable;
import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import java.util.ArrayList;

public static final class WearableExtender implements NotificationCompat.Extender
{
    private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
    private static final int DEFAULT_FLAGS = 1;
    private static final int DEFAULT_GRAVITY = 80;
    private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
    private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
    private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
    private static final int FLAG_HINT_HIDE_ICON = 2;
    private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
    private static final int FLAG_START_SCROLL_BOTTOM = 8;
    private static final String KEY_ACTIONS = "actions";
    private static final String KEY_BACKGROUND = "background";
    private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
    private static final String KEY_CONTENT_ICON = "contentIcon";
    private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
    private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
    private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
    private static final String KEY_DISPLAY_INTENT = "displayIntent";
    private static final String KEY_FLAGS = "flags";
    private static final String KEY_GRAVITY = "gravity";
    private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
    private static final String KEY_PAGES = "pages";
    public static final int SCREEN_TIMEOUT_LONG = -1;
    public static final int SCREEN_TIMEOUT_SHORT = 0;
    public static final int SIZE_DEFAULT = 0;
    public static final int SIZE_FULL_SCREEN = 5;
    public static final int SIZE_LARGE = 4;
    public static final int SIZE_MEDIUM = 3;
    public static final int SIZE_SMALL = 2;
    public static final int SIZE_XSMALL = 1;
    public static final int UNSET_ACTION_INDEX = -1;
    private ArrayList<Action> mActions;
    private Bitmap mBackground;
    private int mContentActionIndex;
    private int mContentIcon;
    private int mContentIconGravity;
    private int mCustomContentHeight;
    private int mCustomSizePreset;
    private PendingIntent mDisplayIntent;
    private int mFlags;
    private int mGravity;
    private int mHintScreenTimeout;
    private ArrayList<Notification> mPages;
    
    public WearableExtender() {
        super();
        this.mActions = new ArrayList<Action>();
        this.mFlags = 1;
        this.mPages = new ArrayList<Notification>();
        this.mContentIconGravity = 8388613;
        this.mContentActionIndex = -1;
        this.mCustomSizePreset = 0;
        this.mGravity = 80;
    }
    
    public WearableExtender(final Notification notification) {
        super();
        this.mActions = new ArrayList<Action>();
        this.mFlags = 1;
        this.mPages = new ArrayList<Notification>();
        this.mContentIconGravity = 8388613;
        this.mContentActionIndex = -1;
        this.mCustomSizePreset = 0;
        this.mGravity = 80;
        final Bundle extras = NotificationCompat.getExtras(notification);
        Bundle bundle;
        if (extras != null) {
            bundle = extras.getBundle("android.wearable.EXTENSIONS");
        }
        else {
            bundle = null;
        }
        if (bundle != null) {
            final Action[] actionsFromParcelableArrayList = NotificationCompat.access$200().getActionsFromParcelableArrayList(bundle.getParcelableArrayList("actions"));
            if (actionsFromParcelableArrayList != null) {
                Collections.<Action>addAll(this.mActions, actionsFromParcelableArrayList);
            }
            this.mFlags = bundle.getInt("flags", 1);
            this.mDisplayIntent = (PendingIntent)bundle.getParcelable("displayIntent");
            final Notification[] access$500 = NotificationCompat.access$500(bundle, "pages");
            if (access$500 != null) {
                Collections.<Notification>addAll(this.mPages, access$500);
            }
            this.mBackground = (Bitmap)bundle.getParcelable("background");
            this.mContentIcon = bundle.getInt("contentIcon");
            this.mContentIconGravity = bundle.getInt("contentIconGravity", 8388613);
            this.mContentActionIndex = bundle.getInt("contentActionIndex", -1);
            this.mCustomSizePreset = bundle.getInt("customSizePreset", 0);
            this.mCustomContentHeight = bundle.getInt("customContentHeight");
            this.mGravity = bundle.getInt("gravity", 80);
            this.mHintScreenTimeout = bundle.getInt("hintScreenTimeout");
        }
    }
    
    private void setFlag(final int n, final boolean b) {
        if (b) {
            mFlags |= n;
            return;
        }
        mFlags &= ~n;
    }
    
    public WearableExtender addAction(final Action action) {
        mActions.add(action);
        return this;
    }
    
    public WearableExtender addActions(final List<Action> list) {
        mActions.addAll(list);
        return this;
    }
    
    public WearableExtender addPage(final Notification notification) {
        mPages.add(notification);
        return this;
    }
    
    public WearableExtender addPages(final List<Notification> list) {
        mPages.addAll(list);
        return this;
    }
    
    public WearableExtender clearActions() {
        mActions.clear();
        return this;
    }
    
    public WearableExtender clearPages() {
        mPages.clear();
        return this;
    }
    
    public WearableExtender clone() {
        final WearableExtender wearableExtender = new WearableExtender();
        mActions = new ArrayList<Action>(mActions);
        mFlags = mFlags;
        mDisplayIntent = mDisplayIntent;
        mPages = new ArrayList<Notification>(mPages);
        mBackground = mBackground;
        mContentIcon = mContentIcon;
        mContentIconGravity = mContentIconGravity;
        mContentActionIndex = mContentActionIndex;
        mCustomSizePreset = mCustomSizePreset;
        mCustomContentHeight = mCustomContentHeight;
        mGravity = mGravity;
        mHintScreenTimeout = mHintScreenTimeout;
        return wearableExtender;
    }
    
    public /* bridge */ Object clone() throws CloneNotSupportedException {
        return this.clone();
    }
    
    @Override
    public NotificationCompat.Builder extend(final NotificationCompat.Builder builder) {
        final Bundle bundle = new Bundle();
        if (!mActions.isEmpty()) {
            bundle.putParcelableArrayList("actions", (ArrayList)NotificationCompat.access$200().getParcelableArrayListForActions(mActions.<Action>toArray(new Action[mActions.size()])));
        }
        if (mFlags != 1) {
            bundle.putInt("flags", mFlags);
        }
        if (mDisplayIntent != null) {
            bundle.putParcelable("displayIntent", (Parcelable)mDisplayIntent);
        }
        if (!mPages.isEmpty()) {
            bundle.putParcelableArray("pages", (Parcelable[])mPages.<Parcelable>toArray((Parcelable[])new Notification[mPages.size()]));
        }
        if (mBackground != null) {
            bundle.putParcelable("background", (Parcelable)mBackground);
        }
        if (mContentIcon != 0) {
            bundle.putInt("contentIcon", mContentIcon);
        }
        if (mContentIconGravity != 8388613) {
            bundle.putInt("contentIconGravity", mContentIconGravity);
        }
        if (mContentActionIndex != -1) {
            bundle.putInt("contentActionIndex", mContentActionIndex);
        }
        if (mCustomSizePreset != 0) {
            bundle.putInt("customSizePreset", mCustomSizePreset);
        }
        if (mCustomContentHeight != 0) {
            bundle.putInt("customContentHeight", mCustomContentHeight);
        }
        if (mGravity != 80) {
            bundle.putInt("gravity", mGravity);
        }
        if (mHintScreenTimeout != 0) {
            bundle.putInt("hintScreenTimeout", mHintScreenTimeout);
        }
        builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
        return builder;
    }
    
    public List<Action> getActions() {
        return mActions;
    }
    
    public Bitmap getBackground() {
        return mBackground;
    }
    
    public int getContentAction() {
        return mContentActionIndex;
    }
    
    public int getContentIcon() {
        return mContentIcon;
    }
    
    public int getContentIconGravity() {
        return mContentIconGravity;
    }
    
    public boolean getContentIntentAvailableOffline() {
        return (0x1 & mFlags) != 0x0;
    }
    
    public int getCustomContentHeight() {
        return mCustomContentHeight;
    }
    
    public int getCustomSizePreset() {
        return mCustomSizePreset;
    }
    
    public PendingIntent getDisplayIntent() {
        return mDisplayIntent;
    }
    
    public int getGravity() {
        return mGravity;
    }
    
    public boolean getHintAvoidBackgroundClipping() {
        return (0x10 & mFlags) != 0x0;
    }
    
    public boolean getHintHideIcon() {
        return (0x2 & mFlags) != 0x0;
    }
    
    public int getHintScreenTimeout() {
        return mHintScreenTimeout;
    }
    
    public boolean getHintShowBackgroundOnly() {
        return (0x4 & mFlags) != 0x0;
    }
    
    public List<Notification> getPages() {
        return mPages;
    }
    
    public boolean getStartScrollBottom() {
        return (0x8 & mFlags) != 0x0;
    }
    
    public WearableExtender setBackground(final Bitmap mBackground) {
        this.mBackground = mBackground;
        return this;
    }
    
    public WearableExtender setContentAction(final int mContentActionIndex) {
        this.mContentActionIndex = mContentActionIndex;
        return this;
    }
    
    public WearableExtender setContentIcon(final int mContentIcon) {
        this.mContentIcon = mContentIcon;
        return this;
    }
    
    public WearableExtender setContentIconGravity(final int mContentIconGravity) {
        this.mContentIconGravity = mContentIconGravity;
        return this;
    }
    
    public WearableExtender setContentIntentAvailableOffline(final boolean b) {
        this.setFlag(1, b);
        return this;
    }
    
    public WearableExtender setCustomContentHeight(final int mCustomContentHeight) {
        this.mCustomContentHeight = mCustomContentHeight;
        return this;
    }
    
    public WearableExtender setCustomSizePreset(final int mCustomSizePreset) {
        this.mCustomSizePreset = mCustomSizePreset;
        return this;
    }
    
    public WearableExtender setDisplayIntent(final PendingIntent mDisplayIntent) {
        this.mDisplayIntent = mDisplayIntent;
        return this;
    }
    
    public WearableExtender setGravity(final int mGravity) {
        this.mGravity = mGravity;
        return this;
    }
    
    public WearableExtender setHintAvoidBackgroundClipping(final boolean b) {
        this.setFlag(16, b);
        return this;
    }
    
    public WearableExtender setHintHideIcon(final boolean b) {
        this.setFlag(2, b);
        return this;
    }
    
    public WearableExtender setHintScreenTimeout(final int mHintScreenTimeout) {
        this.mHintScreenTimeout = mHintScreenTimeout;
        return this;
    }
    
    public WearableExtender setHintShowBackgroundOnly(final boolean b) {
        this.setFlag(4, b);
        return this;
    }
    
    public WearableExtender setStartScrollBottom(final boolean b) {
        this.setFlag(8, b);
        return this;
    }
}
