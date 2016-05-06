package android.support.v4.view;

import android.database.DataSetObserver;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.view.View$MeasureSpec;
import android.view.ViewParent;
import android.graphics.drawable.Drawable;
import android.content.res.TypedArray;
import android.text.TextUtils$TruncateAt;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.os.Build$VERSION;
import java.lang.ref.WeakReference;
import android.widget.TextView;
import android.view.ViewGroup;

public class PagerTitleStrip extends ViewGroup implements Decor
{
    private static final int[] ATTRS;
    private static final PagerTitleStripImpl IMPL;
    private static final float SIDE_ALPHA = 0.6f;
    private static final String TAG = "PagerTitleStrip";
    private static final int[] TEXT_ATTRS;
    private static final int TEXT_SPACING = 16;
    TextView mCurrText;
    private int mGravity;
    private int mLastKnownCurrentPage;
    private float mLastKnownPositionOffset;
    TextView mNextText;
    private int mNonPrimaryAlpha;
    private final PageListener mPageListener;
    ViewPager mPager;
    TextView mPrevText;
    private int mScaledTextSpacing;
    int mTextColor;
    private boolean mUpdatingPositions;
    private boolean mUpdatingText;
    private WeakReference<PagerAdapter> mWatchingAdapter;
    
    static {
        ATTRS = new int[] { 16842804, 16842901, 16842904, 16842927 };
        TEXT_ATTRS = new int[] { 16843660 };
        if (Build$VERSION.SDK_INT >= 14) {
            IMPL = (PagerTitleStripImpl)new PagerTitleStripImplIcs();
            return;
        }
        IMPL = (PagerTitleStripImpl)new PagerTitleStripImplBase();
    }
    
    public PagerTitleStrip(final Context context) {
        this(context, null);
    }
    
    public PagerTitleStrip(final Context context, final AttributeSet set) {
        super(context, set);
        mLastKnownCurrentPage = -1;
        mLastKnownPositionOffset = -1.0f;
        mPageListener = new PageListener(this);
        this.addView((View)(mPrevText = new TextView(context)));
        this.addView((View)(mCurrText = new TextView(context)));
        this.addView((View)(mNextText = new TextView(context)));
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, ATTRS);
        final int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            mPrevText.setTextAppearance(context, resourceId);
            mCurrText.setTextAppearance(context, resourceId);
            mNextText.setTextAppearance(context, resourceId);
        }
        final int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            this.setTextSize(0, dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            final int color = obtainStyledAttributes.getColor(2, 0);
            mPrevText.setTextColor(color);
            mCurrText.setTextColor(color);
            mNextText.setTextColor(color);
        }
        mGravity = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        mTextColor = mCurrText.getTextColors().getDefaultColor();
        this.setNonPrimaryAlpha(0.6f);
        mPrevText.setEllipsize(TextUtils$TruncateAt.END);
        mCurrText.setEllipsize(TextUtils$TruncateAt.END);
        mNextText.setEllipsize(TextUtils$TruncateAt.END);
        boolean boolean1 = false;
        if (resourceId != 0) {
            final TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, TEXT_ATTRS);
            boolean1 = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (boolean1) {
            setSingleLineAllCaps(mPrevText);
            setSingleLineAllCaps(mCurrText);
            setSingleLineAllCaps(mNextText);
        }
        else {
            mPrevText.setSingleLine();
            mCurrText.setSingleLine();
            mNextText.setSingleLine();
        }
        mScaledTextSpacing = (int)(16.0f * context.getResources().getDisplayMetrics().density);
    }
    
    static /* synthetic */ float access$100(final PagerTitleStrip pagerTitleStrip) {
        return pagerTitleStrip.mLastKnownPositionOffset;
    }
    
    private static void setSingleLineAllCaps(final TextView singleLineAllCaps) {
        IMPL.setSingleLineAllCaps(singleLineAllCaps);
    }
    
    int getMinHeight() {
        final Drawable background = this.getBackground();
        int intrinsicHeight = 0;
        if (background != null) {
            intrinsicHeight = background.getIntrinsicHeight();
        }
        return intrinsicHeight;
    }
    
    public int getTextSpacing() {
        return mScaledTextSpacing;
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        final ViewParent parent = this.getParent();
        if (!(parent instanceof ViewPager)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        final ViewPager mPager = (ViewPager)parent;
        final PagerAdapter adapter = mPager.getAdapter();
        mPager.setInternalPageChangeListener((ViewPager.OnPageChangeListener)mPageListener);
        mPager.setOnAdapterChangeListener((ViewPager.OnAdapterChangeListener)mPageListener);
        this.mPager = mPager;
        PagerAdapter pagerAdapter;
        if (mWatchingAdapter != null) {
            pagerAdapter = mWatchingAdapter.get();
        }
        else {
            pagerAdapter = null;
        }
        this.updateAdapter(pagerAdapter, adapter);
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mPager != null) {
            this.updateAdapter(mPager.getAdapter(), null);
            mPager.setInternalPageChangeListener(null);
            mPager.setOnAdapterChangeListener(null);
            mPager = null;
        }
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        if (mPager != null) {
            final float n5 = fcmpl(mLastKnownPositionOffset, 0.0f);
            float mLastKnownPositionOffset = 0.0f;
            if (n5 >= 0) {
                mLastKnownPositionOffset = this.mLastKnownPositionOffset;
            }
            this.updateTextPositions(mLastKnownCurrentPage, mLastKnownPositionOffset, true);
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        if (View$MeasureSpec.getMode(n) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        final int n3 = this.getPaddingTop() + this.getPaddingBottom();
        final int childMeasureSpec = getChildMeasureSpec(n2, n3, -2);
        final int size = View$MeasureSpec.getSize(n);
        final int childMeasureSpec2 = getChildMeasureSpec(n, (int)(0.2f * size), -2);
        mPrevText.measure(childMeasureSpec2, childMeasureSpec);
        mCurrText.measure(childMeasureSpec2, childMeasureSpec);
        mNextText.measure(childMeasureSpec2, childMeasureSpec);
        int n4;
        if (View$MeasureSpec.getMode(n2) == 1073741824) {
            n4 = View$MeasureSpec.getSize(n2);
        }
        else {
            n4 = Math.max(this.getMinHeight(), mCurrText.getMeasuredHeight() + n3);
        }
        this.setMeasuredDimension(size, ViewCompat.resolveSizeAndState(n4, n2, ViewCompat.getMeasuredState((View)mCurrText) << 16));
    }
    
    public void requestLayout() {
        if (!mUpdatingText) {
            super.requestLayout();
        }
    }
    
    public void setGravity(final int mGravity) {
        this.mGravity = mGravity;
        this.requestLayout();
    }
    
    public void setNonPrimaryAlpha(@FloatRange(from = 0.0, to = 1.0) final float n) {
        mNonPrimaryAlpha = (0xFF & (int)(255.0f * n));
        final int n2 = mNonPrimaryAlpha << 24 | (0xFFFFFF & mTextColor);
        mPrevText.setTextColor(n2);
        mNextText.setTextColor(n2);
    }
    
    public void setTextColor(@ColorInt final int n) {
        mTextColor = n;
        mCurrText.setTextColor(n);
        final int n2 = mNonPrimaryAlpha << 24 | (0xFFFFFF & mTextColor);
        mPrevText.setTextColor(n2);
        mNextText.setTextColor(n2);
    }
    
    public void setTextSize(final int n, final float n2) {
        mPrevText.setTextSize(n, n2);
        mCurrText.setTextSize(n, n2);
        mNextText.setTextSize(n, n2);
    }
    
    public void setTextSpacing(final int mScaledTextSpacing) {
        this.mScaledTextSpacing = mScaledTextSpacing;
        this.requestLayout();
    }
    
    void updateAdapter(final PagerAdapter pagerAdapter, final PagerAdapter pagerAdapter2) {
        if (pagerAdapter != null) {
            pagerAdapter.unregisterDataSetObserver(mPageListener);
            mWatchingAdapter = null;
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.registerDataSetObserver(mPageListener);
            mWatchingAdapter = new WeakReference<PagerAdapter>(pagerAdapter2);
        }
        if (mPager != null) {
            mLastKnownCurrentPage = -1;
            mLastKnownPositionOffset = -1.0f;
            this.updateText(mPager.getCurrentItem(), pagerAdapter2);
            this.requestLayout();
        }
    }
    
    void updateText(final int mLastKnownCurrentPage, final PagerAdapter pagerAdapter) {
        int count;
        if (pagerAdapter != null) {
            count = pagerAdapter.getCount();
        }
        else {
            count = 0;
        }
        mUpdatingText = true;
        CharSequence pageTitle = null;
        if (mLastKnownCurrentPage >= 1) {
            pageTitle = null;
            if (pagerAdapter != null) {
                pageTitle = pagerAdapter.getPageTitle(mLastKnownCurrentPage - 1);
            }
        }
        mPrevText.setText(pageTitle);
        final TextView mCurrText = this.mCurrText;
        CharSequence pageTitle2;
        if (pagerAdapter != null && mLastKnownCurrentPage < count) {
            pageTitle2 = pagerAdapter.getPageTitle(mLastKnownCurrentPage);
        }
        else {
            pageTitle2 = null;
        }
        mCurrText.setText(pageTitle2);
        final int n = mLastKnownCurrentPage + 1;
        CharSequence pageTitle3 = null;
        if (n < count) {
            pageTitle3 = null;
            if (pagerAdapter != null) {
                pageTitle3 = pagerAdapter.getPageTitle(mLastKnownCurrentPage + 1);
            }
        }
        mNextText.setText(pageTitle3);
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(Math.max(0, (int)(0.8f * (this.getWidth() - this.getPaddingLeft() - this.getPaddingRight()))), Integer.MIN_VALUE);
        final int measureSpec2 = View$MeasureSpec.makeMeasureSpec(Math.max(0, this.getHeight() - this.getPaddingTop() - this.getPaddingBottom()), Integer.MIN_VALUE);
        mPrevText.measure(measureSpec, measureSpec2);
        this.mCurrText.measure(measureSpec, measureSpec2);
        mNextText.measure(measureSpec, measureSpec2);
        this.mLastKnownCurrentPage = mLastKnownCurrentPage;
        if (!mUpdatingPositions) {
            this.updateTextPositions(mLastKnownCurrentPage, mLastKnownPositionOffset, false);
        }
        mUpdatingText = false;
    }
    
    void updateTextPositions(final int n, final float mLastKnownPositionOffset, final boolean b) {
        if (n != mLastKnownCurrentPage) {
            this.updateText(n, mPager.getAdapter());
        }
        else if (!b && mLastKnownPositionOffset == this.mLastKnownPositionOffset) {
            return;
        }
        mUpdatingPositions = true;
        final int measuredWidth = mPrevText.getMeasuredWidth();
        final int measuredWidth2 = mCurrText.getMeasuredWidth();
        final int measuredWidth3 = mNextText.getMeasuredWidth();
        final int n2 = measuredWidth2 / 2;
        final int width = this.getWidth();
        final int height = this.getHeight();
        final int paddingLeft = this.getPaddingLeft();
        final int paddingRight = this.getPaddingRight();
        final int paddingTop = this.getPaddingTop();
        final int paddingBottom = this.getPaddingBottom();
        final int n3 = paddingLeft + n2;
        final int n4 = paddingRight + n2;
        final int n5 = width - n3 - n4;
        float n6 = mLastKnownPositionOffset + 0.5f;
        if (n6 > 1.0f) {
            --n6;
        }
        final int n7 = width - n4 - (int)(n6 * n5) - measuredWidth2 / 2;
        final int n8 = n7 + measuredWidth2;
        final int baseline = mPrevText.getBaseline();
        final int baseline2 = mCurrText.getBaseline();
        final int baseline3 = mNextText.getBaseline();
        final int max = Math.max(Math.max(baseline, baseline2), baseline3);
        final int n9 = max - baseline;
        final int n10 = max - baseline2;
        final int n11 = max - baseline3;
        final int max2 = Math.max(Math.max(n9 + mPrevText.getMeasuredHeight(), n10 + mCurrText.getMeasuredHeight()), n11 + mNextText.getMeasuredHeight());
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        switch (0x70 & mGravity) {
            default:
                n12 = paddingTop + n9;
                n13 = paddingTop + n10;
                n14 = paddingTop + n11;
                break;
            case 16: {
                final int n15 = (height - paddingTop - paddingBottom - max2) / 2;
                n12 = n15 + n9;
                n13 = n15 + n10;
                n14 = n15 + n11;
                break;
            }
            case 80: {
                final int n16 = height - paddingBottom - max2;
                n12 = n16 + n9;
                n13 = n16 + n10;
                n14 = n16 + n11;
                break;
            }
        }
        mCurrText.layout(n7, n13, n8, n13 + mCurrText.getMeasuredHeight());
        final int min = Math.min(paddingLeft, n7 - mScaledTextSpacing - measuredWidth);
        mPrevText.layout(min, n12, min + measuredWidth, n12 + mPrevText.getMeasuredHeight());
        final int max3 = Math.max(width - paddingRight - measuredWidth3, n8 + mScaledTextSpacing);
        mNextText.layout(max3, n14, max3 + measuredWidth3, n14 + mNextText.getMeasuredHeight());
        this.mLastKnownPositionOffset = mLastKnownPositionOffset;
        mUpdatingPositions = false;
    }
}
