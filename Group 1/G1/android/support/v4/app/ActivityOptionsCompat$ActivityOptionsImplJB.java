package android.support.v4.app;

import android.os.Bundle;

private static class ActivityOptionsImplJB extends ActivityOptionsCompat
{
    private final ActivityOptionsCompatJB mImpl;
    
    ActivityOptionsImplJB(final ActivityOptionsCompatJB mImpl) {
        super();
        this.mImpl = mImpl;
    }
    
    @Override
    public Bundle toBundle() {
        return mImpl.toBundle();
    }
    
    @Override
    public void update(final ActivityOptionsCompat activityOptionsCompat) {
        if (activityOptionsCompat instanceof ActivityOptionsImplJB) {
            mImpl.update(mImpl);
        }
    }
}
