package android.support.v4.content;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ThreadFactory;

static final class ModernAsyncTask$1 implements ThreadFactory {
    private final AtomicInteger mCount = new AtomicInteger(1);
    
    ModernAsyncTask$1() {
        super();
    }
    
    @Override
    public Thread newThread(final Runnable runnable) {
        return new Thread(runnable, "ModernAsyncTask #" + mCount.getAndIncrement());
    }
}