package android.support.v4.view;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.graphics.Canvas;
import android.support.annotation.ColorInt;
import android.view.View;
import android.view.View$OnClickListener;
import android.view.ViewConfiguration;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.Paint;

public class PagerTabStrip extends PagerTitleStrip
{
    private static final int FULL_UNDERLINE_HEIGHT = 1;
    private static final int INDICATOR_HEIGHT = 3;
    private static final int MIN_PADDING_BOTTOM = 6;
    private static final int MIN_STRIP_HEIGHT = 32;
    private static final int MIN_TEXT_SPACING = 64;
    private static final int TAB_PADDING = 16;
    private static final int TAB_SPACING = 32;
    private static final String TAG = "PagerTabStrip";
    private boolean mDrawFullUnderline;
    private boolean mDrawFullUnderlineSet;
    private int mFullUnderlineHeight;
    private boolean mIgnoreTap;
    private int mIndicatorColor;
    private int mIndicatorHeight;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private int mMinPaddingBottom;
    private int mMinStripHeight;
    private int mMinTextSpacing;
    private int mTabAlpha;
    private int mTabPadding;
    private final Paint mTabPaint;
    private final Rect mTempRect;
    private int mTouchSlop;
    
    public PagerTabStrip(final Context context) {
        this(context, null);
    }
    
    public PagerTabStrip(final Context context, final AttributeSet set) {
        super(context, set);
        mTabPaint = new Paint();
        mTempRect = new Rect();
        mTabAlpha = 255;
        mDrawFullUnderline = false;
        mDrawFullUnderlineSet = false;
        mIndicatorColor = this.mTextColor;
        mTabPaint.setColor(mIndicatorColor);
        final float density = context.getResources().getDisplayMetrics().density;
        mIndicatorHeight = (int)(0.5f + 3.0f * density);
        mMinPaddingBottom = (int)(0.5f + 6.0f * density);
        mMinTextSpacing = (int)(64.0f * density);
        mTabPadding = (int)(0.5f + 16.0f * density);
        mFullUnderlineHeight = (int)(0.5f + 1.0f * density);
        mMinStripHeight = (int)(0.5f + 32.0f * density);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.setPadding(this.getPaddingLeft(), this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
        this.setTextSpacing(this.getTextSpacing());
        this.setWillNotDraw(false);
        this.mPrevText.setFocusable(true);
        this.mPrevText.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            final /* synthetic */ PagerTabStrip this$0;
            
            PagerTabStrip$1() {
                this$0 = this$0;
                super();
            }
            
            public void onClick(final View view) {
                this$0.mPager.setCurrentItem(-1 + this$0.mPager.getCurrentItem());
            }
        });
        this.mNextText.setFocusable(true);
        this.mNextText.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            final /* synthetic */ PagerTabStrip this$0;
            
            PagerTabStrip$2() {
                this$0 = this$0;
                super();
            }
            
            public void onClick(final View view) {
                this$0.mPager.setCurrentItem(1 + this$0.mPager.getCurrentItem());
            }
        });
        if (this.getBackground() == null) {
            mDrawFullUnderline = true;
        }
    }
    
    public boolean getDrawFullUnderline() {
        return mDrawFullUnderline;
    }
    
    @Override
    int getMinHeight() {
        return Math.max(super.getMinHeight(), mMinStripHeight);
    }
    
    @ColorInt
    public int getTabIndicatorColor() {
        return mIndicatorColor;
    }
    
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        final int height = this.getHeight();
        final int n = this.mCurrText.getLeft() - mTabPadding;
        final int n2 = this.mCurrText.getRight() + mTabPadding;
        final int n3 = height - mIndicatorHeight;
        mTabPaint.setColor(mTabAlpha << 24 | (0xFFFFFF & mIndicatorColor));
        canvas.drawRect((float)n, (float)n3, (float)n2, (float)height, mTabPaint);
        if (mDrawFullUnderline) {
            mTabPaint.setColor(0xFF000000 | (0xFFFFFF & mIndicatorColor));
            canvas.drawRect((float)this.getPaddingLeft(), (float)(height - mFullUnderlineHeight), (float)(this.getWidth() - this.getPaddingRight()), (float)height, mTabPaint);
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        final int action = motionEvent.getAction();
        if (action != 0 && mIgnoreTap) {
            return false;
        }
        final float x = motionEvent.getX();
        final float y = motionEvent.getY();
        switch (action) {
            case 0:
                mInitialMotionX = x;
                mInitialMotionY = y;
                mIgnoreTap = false;
                break;
            case 2:
                if (Math.abs(x - mInitialMotionX) > mTouchSlop || Math.abs(y - mInitialMotionY) > mTouchSlop) {
                    mIgnoreTap = true;
                    break;
                }
                break;
            case 1:
                if (x < this.mCurrText.getLeft() - mTabPadding) {
                    this.mPager.setCurrentItem(-1 + this.mPager.getCurrentItem());
                    break;
                }
                if (x > this.mCurrText.getRight() + mTabPadding) {
                    this.mPager.setCurrentItem(1 + this.mPager.getCurrentItem());
                    break;
                }
                break;
        }
        return true;
    }
    
    public void setBackgroundColor(@ColorInt final int backgroundColor) {
        super.setBackgroundColor(backgroundColor);
        if (!mDrawFullUnderlineSet) {
            mDrawFullUnderline = ((0xFF000000 & backgroundColor) == 0x0);
        }
    }
    
    public void setBackgroundDrawable(final Drawable backgroundDrawable) {
        super.setBackgroundDrawable(backgroundDrawable);
        if (!mDrawFullUnderlineSet) {
            mDrawFullUnderline = (backgroundDrawable == null);
        }
    }
    
    public void setBackgroundResource(@DrawableRes final int backgroundResource) {
        super.setBackgroundResource(backgroundResource);
        if (!mDrawFullUnderlineSet) {
            mDrawFullUnderline = (backgroundResource == 0);
        }
    }
    
    public void setDrawFullUnderline(final boolean mDrawFullUnderline) {
        this.mDrawFullUnderline = mDrawFullUnderline;
        mDrawFullUnderlineSet = true;
        this.invalidate();
    }
    
    public void setPadding(final int n, final int n2, final int n3, int mMinPaddingBottom) {
        if (mMinPaddingBottom < this.mMinPaddingBottom) {
            mMinPaddingBottom = this.mMinPaddingBottom;
        }
        super.setPadding(n, n2, n3, mMinPaddingBottom);
    }
    
    public void setTabIndicatorColor(@ColorInt final int mIndicatorColor) {
        this.mIndicatorColor = mIndicatorColor;
        mTabPaint.setColor(this.mIndicatorColor);
        this.invalidate();
    }
    
    public void setTabIndicatorColorResource(@ColorRes final int n) {
        this.setTabIndicatorColor(this.getContext().getResources().getColor(n));
    }
    
    @Override
    public void setTextSpacing(int mMinTextSpacing) {
        if (mMinTextSpacing < this.mMinTextSpacing) {
            mMinTextSpacing = this.mMinTextSpacing;
        }
        super.setTextSpacing(mMinTextSpacing);
    }
    
    @Override
    void updateTextPositions(final int n, final float n2, final boolean b) {
        final Rect mTempRect = this.mTempRect;
        final int height = this.getHeight();
        final int n3 = this.mCurrText.getLeft() - mTabPadding;
        final int n4 = this.mCurrText.getRight() + mTabPadding;
        final int n5 = height - mIndicatorHeight;
        mTempRect.set(n3, n5, n4, height);
        super.updateTextPositions(n, n2, b);
        mTabAlpha = (int)(255.0f * (2.0f * Math.abs(n2 - 0.5f)));
        mTempRect.union(this.mCurrText.getLeft() - mTabPadding, n5, this.mCurrText.getRight() + mTabPadding, height);
        this.invalidate(mTempRect);
    }
}
