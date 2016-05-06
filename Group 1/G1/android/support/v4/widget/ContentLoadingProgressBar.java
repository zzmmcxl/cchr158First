package android.support.v4.widget;

import android.util.AttributeSet;
import android.content.Context;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar
{
    private static final int MIN_DELAY = 500;
    private static final int MIN_SHOW_TIME = 500;
    private final Runnable mDelayedHide;
    private final Runnable mDelayedShow;
    private boolean mDismissed;
    private boolean mPostedHide;
    private boolean mPostedShow;
    private long mStartTime;
    
    public ContentLoadingProgressBar(final Context context) {
        this(context, null);
    }
    
    public ContentLoadingProgressBar(final Context context, final AttributeSet set) {
        super(context, set, 0);
        mStartTime = -1L;
        mPostedHide = false;
        mPostedShow = false;
        mDismissed = false;
        mDelayedHide = new Runnable() {
            final /* synthetic */ ContentLoadingProgressBar this$0;
            
            ContentLoadingProgressBar$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                mPostedHide = false;
                mStartTime = -1L;
                this$0.setVisibility(8);
            }
        };
        mDelayedShow = new Runnable() {
            final /* synthetic */ ContentLoadingProgressBar this$0;
            
            ContentLoadingProgressBar$2() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                mPostedShow = false;
                if (!mDismissed) {
                    mStartTime = System.currentTimeMillis();
                    this$0.setVisibility(0);
                }
            }
        };
    }
    
    static /* synthetic */ boolean access$002(final ContentLoadingProgressBar contentLoadingProgressBar, final boolean mPostedHide) {
        return contentLoadingProgressBar.mPostedHide = mPostedHide;
    }
    
    static /* synthetic */ long access$102(final ContentLoadingProgressBar contentLoadingProgressBar, final long mStartTime) {
        return contentLoadingProgressBar.mStartTime = mStartTime;
    }
    
    static /* synthetic */ boolean access$202(final ContentLoadingProgressBar contentLoadingProgressBar, final boolean mPostedShow) {
        return contentLoadingProgressBar.mPostedShow = mPostedShow;
    }
    
    static /* synthetic */ boolean access$300(final ContentLoadingProgressBar contentLoadingProgressBar) {
        return contentLoadingProgressBar.mDismissed;
    }
    
    private void removeCallbacks() {
        this.removeCallbacks(mDelayedHide);
        this.removeCallbacks(mDelayedShow);
    }
    
    public void hide() {
        mDismissed = true;
        this.removeCallbacks(mDelayedShow);
        final long n = System.currentTimeMillis() - mStartTime;
        if (n >= 500L || mStartTime == -1L) {
            this.setVisibility(8);
        }
        else if (!mPostedHide) {
            this.postDelayed(mDelayedHide, 500L - n);
            mPostedHide = true;
        }
    }
    
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.removeCallbacks();
    }
    
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.removeCallbacks();
    }
    
    public void show() {
        mStartTime = -1L;
        mDismissed = false;
        this.removeCallbacks(mDelayedHide);
        if (!mPostedShow) {
            this.postDelayed(mDelayedShow, 500L);
            mPostedShow = true;
        }
    }
}
