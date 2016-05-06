package android.support.v4.app;

import android.os.Bundle;

public static final class WearableExtender implements Extender
{
    private static final int DEFAULT_FLAGS = 1;
    private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
    private static final int FLAG_AVAILABLE_OFFLINE = 1;
    private static final String KEY_CANCEL_LABEL = "cancelLabel";
    private static final String KEY_CONFIRM_LABEL = "confirmLabel";
    private static final String KEY_FLAGS = "flags";
    private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
    private CharSequence mCancelLabel;
    private CharSequence mConfirmLabel;
    private int mFlags;
    private CharSequence mInProgressLabel;
    
    public WearableExtender() {
        super();
        this.mFlags = 1;
    }
    
    public WearableExtender(final Action action) {
        super();
        this.mFlags = 1;
        final Bundle bundle = action.getExtras().getBundle("android.wearable.EXTENSIONS");
        if (bundle != null) {
            this.mFlags = bundle.getInt("flags", 1);
            this.mInProgressLabel = bundle.getCharSequence("inProgressLabel");
            this.mConfirmLabel = bundle.getCharSequence("confirmLabel");
            this.mCancelLabel = bundle.getCharSequence("cancelLabel");
        }
    }
    
    private void setFlag(final int n, final boolean b) {
        if (b) {
            mFlags |= n;
            return;
        }
        mFlags &= ~n;
    }
    
    public WearableExtender clone() {
        final WearableExtender wearableExtender = new WearableExtender();
        mFlags = mFlags;
        mInProgressLabel = mInProgressLabel;
        mConfirmLabel = mConfirmLabel;
        mCancelLabel = mCancelLabel;
        return wearableExtender;
    }
    
    public /* bridge */ Object clone() throws CloneNotSupportedException {
        return this.clone();
    }
    
    @Override
    public Builder extend(final Builder builder) {
        final Bundle bundle = new Bundle();
        if (mFlags != 1) {
            bundle.putInt("flags", mFlags);
        }
        if (mInProgressLabel != null) {
            bundle.putCharSequence("inProgressLabel", mInProgressLabel);
        }
        if (mConfirmLabel != null) {
            bundle.putCharSequence("confirmLabel", mConfirmLabel);
        }
        if (mCancelLabel != null) {
            bundle.putCharSequence("cancelLabel", mCancelLabel);
        }
        builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
        return builder;
    }
    
    public CharSequence getCancelLabel() {
        return mCancelLabel;
    }
    
    public CharSequence getConfirmLabel() {
        return mConfirmLabel;
    }
    
    public CharSequence getInProgressLabel() {
        return mInProgressLabel;
    }
    
    public boolean isAvailableOffline() {
        return (0x1 & mFlags) != 0x0;
    }
    
    public WearableExtender setAvailableOffline(final boolean b) {
        this.setFlag(1, b);
        return this;
    }
    
    public WearableExtender setCancelLabel(final CharSequence mCancelLabel) {
        this.mCancelLabel = mCancelLabel;
        return this;
    }
    
    public WearableExtender setConfirmLabel(final CharSequence mConfirmLabel) {
        this.mConfirmLabel = mConfirmLabel;
        return this;
    }
    
    public WearableExtender setInProgressLabel(final CharSequence mInProgressLabel) {
        this.mInProgressLabel = mInProgressLabel;
        return this;
    }
}
