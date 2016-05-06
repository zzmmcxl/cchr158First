package android.support.v4.media;

import android.support.annotation.NonNull;
import android.os.Bundle;
import android.content.ComponentName;
import android.content.Context;

static class MediaBrowserImplApi23 extends MediaBrowserImplApi21
{
    public MediaBrowserImplApi23(final Context context, final ComponentName componentName, final ConnectionCallback connectionCallback, final Bundle bundle) {
        super(context, componentName, connectionCallback, bundle);
    }
    
    @Override
    public void getItem(@NonNull final String s, @NonNull final ItemCallback itemCallback) {
        MediaBrowserCompatApi23.getItem(this.mBrowserObj, s, itemCallback.mItemCallbackObj);
    }
}
