package android.support.v4.app;

import java.util.ArrayList;
import android.app.PendingIntent;
import android.os.Bundle;

public static final class Builder
{
    private final Bundle mExtras;
    private final int mIcon;
    private final PendingIntent mIntent;
    private ArrayList<RemoteInput> mRemoteInputs;
    private final CharSequence mTitle;
    
    public Builder(final int n, final CharSequence charSequence, final PendingIntent pendingIntent) {
        this(n, charSequence, pendingIntent, new Bundle());
    }
    
    private Builder(final int mIcon, final CharSequence charSequence, final PendingIntent mIntent, final Bundle mExtras) {
        super();
        this.mIcon = mIcon;
        this.mTitle = NotificationCompat.Builder.limitCharSequenceLength(charSequence);
        this.mIntent = mIntent;
        this.mExtras = mExtras;
    }
    
    public Builder(final Action action) {
        this(action.icon, action.title, action.actionIntent, new Bundle(Action.access$300(action)));
    }
    
    public Builder addExtras(final Bundle bundle) {
        if (bundle != null) {
            mExtras.putAll(bundle);
        }
        return this;
    }
    
    public Builder addRemoteInput(final RemoteInput remoteInput) {
        if (mRemoteInputs == null) {
            mRemoteInputs = new ArrayList<RemoteInput>();
        }
        mRemoteInputs.add(remoteInput);
        return this;
    }
    
    public Action build() {
        RemoteInput[] array;
        if (mRemoteInputs != null) {
            array = mRemoteInputs.<RemoteInput>toArray(new RemoteInput[mRemoteInputs.size()]);
        }
        else {
            array = null;
        }
        return new Action(mIcon, mTitle, mIntent, mExtras, array);
    }
    
    public Builder extend(final Extender extender) {
        extender.extend(this);
        return this;
    }
    
    public Bundle getExtras() {
        return mExtras;
    }
}
