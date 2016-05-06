package android.support.v4.media.session;

import android.text.TextUtils;
import android.os.Bundle;

public static final class Builder
{
    private final String mAction;
    private Bundle mExtras;
    private final int mIcon;
    private final CharSequence mName;
    
    public Builder(final String mAction, final CharSequence mName, final int mIcon) {
        super();
        if (TextUtils.isEmpty((CharSequence)mAction)) {
            throw new IllegalArgumentException("You must specify an action to build a CustomAction.");
        }
        if (TextUtils.isEmpty(mName)) {
            throw new IllegalArgumentException("You must specify a name to build a CustomAction.");
        }
        if (mIcon == 0) {
            throw new IllegalArgumentException("You must specify an icon resource id to build a CustomAction.");
        }
        this.mAction = mAction;
        this.mName = mName;
        this.mIcon = mIcon;
    }
    
    public CustomAction build() {
        return new CustomAction(mAction, mName, mIcon, mExtras);
    }
    
    public Builder setExtras(final Bundle mExtras) {
        this.mExtras = mExtras;
        return this;
    }
}
