package android.support.v4.app;

import android.os.Bundle;

public static final class Builder
{
    private boolean mAllowFreeFormInput;
    private CharSequence[] mChoices;
    private Bundle mExtras;
    private CharSequence mLabel;
    private final String mResultKey;
    
    public Builder(final String mResultKey) {
        super();
        this.mAllowFreeFormInput = true;
        this.mExtras = new Bundle();
        if (mResultKey == null) {
            throw new IllegalArgumentException("Result key can't be null");
        }
        this.mResultKey = mResultKey;
    }
    
    public Builder addExtras(final Bundle bundle) {
        if (bundle != null) {
            mExtras.putAll(bundle);
        }
        return this;
    }
    
    public RemoteInput build() {
        return new RemoteInput(mResultKey, mLabel, mChoices, mAllowFreeFormInput, mExtras, null);
    }
    
    public Bundle getExtras() {
        return mExtras;
    }
    
    public Builder setAllowFreeFormInput(final boolean mAllowFreeFormInput) {
        this.mAllowFreeFormInput = mAllowFreeFormInput;
        return this;
    }
    
    public Builder setChoices(final CharSequence[] mChoices) {
        this.mChoices = mChoices;
        return this;
    }
    
    public Builder setLabel(final CharSequence mLabel) {
        this.mLabel = mLabel;
        return this;
    }
}
