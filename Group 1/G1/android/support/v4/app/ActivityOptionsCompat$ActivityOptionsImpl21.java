package android.support.v4.app;

import android.os.Bundle;

private static class ActivityOptionsImpl21 extends ActivityOptionsCompat
{
    private final ActivityOptionsCompat21 mImpl;
    
    ActivityOptionsImpl21(final ActivityOptionsCompat21 mImpl) {
        super();
        this.mImpl = mImpl;
    }
    
    @Override
    public Bundle toBundle() {
        return mImpl.toBundle();
    }
    
    @Override
    public void update(final ActivityOptionsCompat activityOptionsCompat) {
        if (activityOptionsCompat instanceof ActivityOptionsImpl21) {
            mImpl.update(mImpl);
        }
    }
}
