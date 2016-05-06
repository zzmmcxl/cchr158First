package android.support.v7.widget;

import android.content.res.TypedArray;
import android.view.ViewGroup$MarginLayoutParams;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;
import android.view.accessibility.AccessibilityNodeInfo;
import android.os.Build$VERSION;
import android.view.accessibility.AccessibilityEvent;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.graphics.Canvas;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.view.View$MeasureSpec;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;

public class LinearLayoutCompat extends ViewGroup
{
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;
    
    public LinearLayoutCompat(final Context context) {
        this(context, null);
    }
    
    public LinearLayoutCompat(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public LinearLayoutCompat(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        mBaselineAligned = true;
        mBaselineAlignedChildIndex = -1;
        mBaselineChildTop = 0;
        mGravity = 8388659;
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, set, R.styleable.LinearLayoutCompat, n, 0);
        final int int1 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (int1 >= 0) {
            this.setOrientation(int1);
        }
        final int int2 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (int2 >= 0) {
            this.setGravity(int2);
        }
        final boolean boolean1 = obtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!boolean1) {
            this.setBaselineAligned(boolean1);
        }
        mWeightSum = obtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        mBaselineAlignedChildIndex = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        mUseLargestChild = obtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        this.setDividerDrawable(obtainStyledAttributes.getDrawable(R.styleable.LinearLayoutCompat_divider));
        mShowDividers = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
        mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        obtainStyledAttributes.recycle();
    }
    
    private void forceUniformHeight(final int n, final int n2) {
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), 1073741824);
        for (int i = 0; i < n; ++i) {
            final View virtualChild = this.getVirtualChildAt(i);
            if (virtualChild.getVisibility() != 8) {
                final LayoutParams layoutParams = (LayoutParams)virtualChild.getLayoutParams();
                if (layoutParams.height == -1) {
                    final int width = layoutParams.width;
                    layoutParams.width = virtualChild.getMeasuredWidth();
                    this.measureChildWithMargins(virtualChild, n2, 0, measureSpec, 0);
                    layoutParams.width = width;
                }
            }
        }
    }
    
    private void forceUniformWidth(final int n, final int n2) {
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 1073741824);
        for (int i = 0; i < n; ++i) {
            final View virtualChild = this.getVirtualChildAt(i);
            if (virtualChild.getVisibility() != 8) {
                final LayoutParams layoutParams = (LayoutParams)virtualChild.getLayoutParams();
                if (layoutParams.width == -1) {
                    final int height = layoutParams.height;
                    layoutParams.height = virtualChild.getMeasuredHeight();
                    this.measureChildWithMargins(virtualChild, measureSpec, 0, n2, 0);
                    layoutParams.height = height;
                }
            }
        }
    }
    
    private void setChildFrame(final View view, final int n, final int n2, final int n3, final int n4) {
        view.layout(n, n2, n + n3, n2 + n4);
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof LayoutParams;
    }
    
    void drawDividersHorizontal(final Canvas canvas) {
        final int virtualChildCount = this.getVirtualChildCount();
        final boolean layoutRtl = ViewUtils.isLayoutRtl((View)this);
        for (int i = 0; i < virtualChildCount; ++i) {
            final View virtualChild = this.getVirtualChildAt(i);
            if (virtualChild != null && virtualChild.getVisibility() != 8 && this.hasDividerBeforeChildAt(i)) {
                final LayoutParams layoutParams = (LayoutParams)virtualChild.getLayoutParams();
                int n;
                if (layoutRtl) {
                    n = virtualChild.getRight() + layoutParams.rightMargin;
                }
                else {
                    n = virtualChild.getLeft() - layoutParams.leftMargin - mDividerWidth;
                }
                this.drawVerticalDivider(canvas, n);
            }
        }
        if (this.hasDividerBeforeChildAt(virtualChildCount)) {
            final View virtualChild2 = this.getVirtualChildAt(virtualChildCount - 1);
            int paddingLeft;
            if (virtualChild2 == null) {
                if (layoutRtl) {
                    paddingLeft = this.getPaddingLeft();
                }
                else {
                    paddingLeft = this.getWidth() - this.getPaddingRight() - mDividerWidth;
                }
            }
            else {
                final LayoutParams layoutParams2 = (LayoutParams)virtualChild2.getLayoutParams();
                if (layoutRtl) {
                    paddingLeft = virtualChild2.getLeft() - layoutParams2.leftMargin - mDividerWidth;
                }
                else {
                    paddingLeft = virtualChild2.getRight() + layoutParams2.rightMargin;
                }
            }
            this.drawVerticalDivider(canvas, paddingLeft);
        }
    }
    
    void drawDividersVertical(final Canvas canvas) {
        final int virtualChildCount = this.getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; ++i) {
            final View virtualChild = this.getVirtualChildAt(i);
            if (virtualChild != null && virtualChild.getVisibility() != 8 && this.hasDividerBeforeChildAt(i)) {
                this.drawHorizontalDivider(canvas, virtualChild.getTop() - ((LayoutParams)virtualChild.getLayoutParams()).topMargin - mDividerHeight);
            }
        }
        if (this.hasDividerBeforeChildAt(virtualChildCount)) {
            final View virtualChild2 = this.getVirtualChildAt(virtualChildCount - 1);
            int n;
            if (virtualChild2 == null) {
                n = this.getHeight() - this.getPaddingBottom() - mDividerHeight;
            }
            else {
                n = virtualChild2.getBottom() + ((LayoutParams)virtualChild2.getLayoutParams()).bottomMargin;
            }
            this.drawHorizontalDivider(canvas, n);
        }
    }
    
    void drawHorizontalDivider(final Canvas canvas, final int n) {
        mDivider.setBounds(this.getPaddingLeft() + mDividerPadding, n, this.getWidth() - this.getPaddingRight() - mDividerPadding, n + mDividerHeight);
        mDivider.draw(canvas);
    }
    
    void drawVerticalDivider(final Canvas canvas, final int n) {
        mDivider.setBounds(n, this.getPaddingTop() + mDividerPadding, n + mDividerWidth, this.getHeight() - this.getPaddingBottom() - mDividerPadding);
        mDivider.draw(canvas);
    }
    
    protected LayoutParams generateDefaultLayoutParams() {
        if (mOrientation == 0) {
            return new LayoutParams(-2, -2);
        }
        if (mOrientation == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }
    
    protected /* bridge */ ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup$LayoutParams)this.generateDefaultLayoutParams();
    }
    
    public LayoutParams generateLayoutParams(final AttributeSet set) {
        return new LayoutParams(this.getContext(), set);
    }
    
    protected LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return new LayoutParams(viewGroup$LayoutParams);
    }
    
    public /* bridge */ ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return (ViewGroup$LayoutParams)this.generateLayoutParams(set);
    }
    
    protected /* bridge */ ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return (ViewGroup$LayoutParams)this.generateLayoutParams(viewGroup$LayoutParams);
    }
    
    public int getBaseline() {
        int baseline = -1;
        if (mBaselineAlignedChildIndex < 0) {
            baseline = super.getBaseline();
        }
        else {
            if (this.getChildCount() <= mBaselineAlignedChildIndex) {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
            }
            final View child = this.getChildAt(mBaselineAlignedChildIndex);
            final int baseline2 = child.getBaseline();
            if (baseline2 != baseline) {
                int mBaselineChildTop = this.mBaselineChildTop;
                if (mOrientation == 1) {
                    final int n = 0x70 & mGravity;
                    if (n != 48) {
                        switch (n) {
                            case 80:
                                mBaselineChildTop = this.getBottom() - this.getTop() - this.getPaddingBottom() - mTotalLength;
                                break;
                            case 16:
                                mBaselineChildTop += (this.getBottom() - this.getTop() - this.getPaddingTop() - this.getPaddingBottom() - mTotalLength) / 2;
                                break;
                        }
                    }
                }
                return baseline2 + (mBaselineChildTop + ((LayoutParams)child.getLayoutParams()).topMargin);
            }
            if (mBaselineAlignedChildIndex != 0) {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
        }
        return baseline;
    }
    
    public int getBaselineAlignedChildIndex() {
        return mBaselineAlignedChildIndex;
    }
    
    int getChildrenSkipCount(final View view, final int n) {
        return 0;
    }
    
    public Drawable getDividerDrawable() {
        return mDivider;
    }
    
    public int getDividerPadding() {
        return mDividerPadding;
    }
    
    public int getDividerWidth() {
        return mDividerWidth;
    }
    
    int getLocationOffset(final View view) {
        return 0;
    }
    
    int getNextLocationOffset(final View view) {
        return 0;
    }
    
    public int getOrientation() {
        return mOrientation;
    }
    
    public int getShowDividers() {
        return mShowDividers;
    }
    
    View getVirtualChildAt(final int n) {
        return this.getChildAt(n);
    }
    
    int getVirtualChildCount() {
        return this.getChildCount();
    }
    
    public float getWeightSum() {
        return mWeightSum;
    }
    
    protected boolean hasDividerBeforeChildAt(final int n) {
        if (n == 0) {
            if ((0x1 & mShowDividers) == 0x0) {
                return false;
            }
        }
        else if (n == this.getChildCount()) {
            if ((0x4 & mShowDividers) == 0x0) {
                return false;
            }
        }
        else {
            if ((0x2 & mShowDividers) != 0x0) {
                int n2 = n - 1;
                boolean b;
                while (true) {
                    b = false;
                    if (n2 < 0) {
                        break;
                    }
                    if (this.getChildAt(n2).getVisibility() != 8) {
                        b = true;
                        break;
                    }
                    --n2;
                }
                return b;
            }
            return false;
        }
        return true;
    }
    
    public boolean isBaselineAligned() {
        return mBaselineAligned;
    }
    
    public boolean isMeasureWithLargestChildEnabled() {
        return mUseLargestChild;
    }
    
    void layoutHorizontal(final int n, final int n2, final int n3, final int n4) {
        final boolean layoutRtl = ViewUtils.isLayoutRtl((View)this);
        final int paddingTop = this.getPaddingTop();
        final int n5 = n4 - n2;
        final int n6 = n5 - this.getPaddingBottom();
        final int n7 = n5 - paddingTop - this.getPaddingBottom();
        final int virtualChildCount = this.getVirtualChildCount();
        final int n8 = 0x800007 & mGravity;
        final int n9 = 0x70 & mGravity;
        final boolean mBaselineAligned = this.mBaselineAligned;
        final int[] mMaxAscent = this.mMaxAscent;
        final int[] mMaxDescent = this.mMaxDescent;
        int paddingLeft = 0;
        switch (GravityCompat.getAbsoluteGravity(n8, ViewCompat.getLayoutDirection((View)this))) {
            default:
                paddingLeft = this.getPaddingLeft();
                break;
            case 5:
                paddingLeft = n3 + this.getPaddingLeft() - n - mTotalLength;
                break;
            case 1:
                paddingLeft = this.getPaddingLeft() + (n3 - n - mTotalLength) / 2;
                break;
        }
        int n10 = 1;
        int n11 = 0;
        if (layoutRtl) {
            n11 = virtualChildCount - 1;
            n10 = -1;
        }
        for (int i = 0; i < virtualChildCount; ++i) {
            final int n12 = n11 + n10 * i;
            final View virtualChild = this.getVirtualChildAt(n12);
            if (virtualChild == null) {
                paddingLeft += this.measureNullChild(n12);
            }
            else if (virtualChild.getVisibility() != 8) {
                final int measuredWidth = virtualChild.getMeasuredWidth();
                final int measuredHeight = virtualChild.getMeasuredHeight();
                int baseline = -1;
                final LayoutParams layoutParams = (LayoutParams)virtualChild.getLayoutParams();
                if (mBaselineAligned && layoutParams.height != -1) {
                    baseline = virtualChild.getBaseline();
                }
                int gravity = layoutParams.gravity;
                if (gravity < 0) {
                    gravity = n9;
                }
                int n13 = 0;
                switch (gravity & 0x70) {
                    default:
                        n13 = paddingTop;
                        break;
                    case 48:
                        n13 = paddingTop + layoutParams.topMargin;
                        if (baseline != -1) {
                            n13 += mMaxAscent[1] - baseline;
                            break;
                        }
                        break;
                    case 16:
                        n13 = paddingTop + (n7 - measuredHeight) / 2 + layoutParams.topMargin - layoutParams.bottomMargin;
                        break;
                    case 80:
                        n13 = n6 - measuredHeight - layoutParams.bottomMargin;
                        if (baseline != -1) {
                            n13 -= mMaxDescent[2] - (virtualChild.getMeasuredHeight() - baseline);
                            break;
                        }
                        break;
                }
                if (this.hasDividerBeforeChildAt(n12)) {
                    paddingLeft += mDividerWidth;
                }
                final int n14 = paddingLeft + layoutParams.leftMargin;
                this.setChildFrame(virtualChild, n14 + this.getLocationOffset(virtualChild), n13, measuredWidth, measuredHeight);
                paddingLeft = n14 + (measuredWidth + layoutParams.rightMargin + this.getNextLocationOffset(virtualChild));
                i += this.getChildrenSkipCount(virtualChild, n12);
            }
        }
    }
    
    void layoutVertical(final int n, final int n2, final int n3, final int n4) {
        final int paddingLeft = this.getPaddingLeft();
        final int n5 = n3 - n;
        final int n6 = n5 - this.getPaddingRight();
        final int n7 = n5 - paddingLeft - this.getPaddingRight();
        final int virtualChildCount = this.getVirtualChildCount();
        final int n8 = 0x70 & mGravity;
        final int n9 = 0x800007 & mGravity;
        int paddingTop = 0;
        switch (n8) {
            default:
                paddingTop = this.getPaddingTop();
                break;
            case 80:
                paddingTop = n4 + this.getPaddingTop() - n2 - mTotalLength;
                break;
            case 16:
                paddingTop = this.getPaddingTop() + (n4 - n2 - mTotalLength) / 2;
                break;
        }
        for (int i = 0; i < virtualChildCount; ++i) {
            final View virtualChild = this.getVirtualChildAt(i);
            if (virtualChild == null) {
                paddingTop += this.measureNullChild(i);
            }
            else if (virtualChild.getVisibility() != 8) {
                final int measuredWidth = virtualChild.getMeasuredWidth();
                final int measuredHeight = virtualChild.getMeasuredHeight();
                final LayoutParams layoutParams = (LayoutParams)virtualChild.getLayoutParams();
                int gravity = layoutParams.gravity;
                if (gravity < 0) {
                    gravity = n9;
                }
                int n10 = 0;
                switch (0x7 & GravityCompat.getAbsoluteGravity(gravity, ViewCompat.getLayoutDirection((View)this))) {
                    default:
                        n10 = paddingLeft + layoutParams.leftMargin;
                        break;
                    case 1:
                        n10 = paddingLeft + (n7 - measuredWidth) / 2 + layoutParams.leftMargin - layoutParams.rightMargin;
                        break;
                    case 5:
                        n10 = n6 - measuredWidth - layoutParams.rightMargin;
                        break;
                }
                if (this.hasDividerBeforeChildAt(i)) {
                    paddingTop += mDividerHeight;
                }
                final int n11 = paddingTop + layoutParams.topMargin;
                this.setChildFrame(virtualChild, n10, n11 + this.getLocationOffset(virtualChild), measuredWidth, measuredHeight);
                paddingTop = n11 + (measuredHeight + layoutParams.bottomMargin + this.getNextLocationOffset(virtualChild));
                i += this.getChildrenSkipCount(virtualChild, i);
            }
        }
    }
    
    void measureChildBeforeLayout(final View view, final int n, final int n2, final int n3, final int n4, final int n5) {
        this.measureChildWithMargins(view, n2, n3, n4, n5);
    }
    
    void measureHorizontal(final int n, final int n2) {
        mTotalLength = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int max = 0;
        int n6 = 1;
        float n7 = 0.0f;
        final int virtualChildCount = this.getVirtualChildCount();
        final int mode = View$MeasureSpec.getMode(n);
        final int mode2 = View$MeasureSpec.getMode(n2);
        boolean b = false;
        boolean b2 = false;
        if (mMaxAscent == null || mMaxDescent == null) {
            mMaxAscent = new int[4];
            mMaxDescent = new int[4];
        }
        final int[] mMaxAscent = this.mMaxAscent;
        final int[] mMaxDescent = this.mMaxDescent;
        mMaxAscent[2] = (mMaxAscent[3] = -1);
        mMaxAscent[0] = (mMaxAscent[1] = -1);
        mMaxDescent[2] = (mMaxDescent[3] = -1);
        mMaxDescent[0] = (mMaxDescent[1] = -1);
        final boolean mBaselineAligned = this.mBaselineAligned;
        final boolean mUseLargestChild = this.mUseLargestChild;
        final boolean b3 = mode == 1073741824;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < virtualChildCount; ++i) {
            final View virtualChild = this.getVirtualChildAt(i);
            if (virtualChild == null) {
                mTotalLength += this.measureNullChild(i);
            }
            else if (virtualChild.getVisibility() == 8) {
                i += this.getChildrenSkipCount(virtualChild, i);
            }
            else {
                if (this.hasDividerBeforeChildAt(i)) {
                    mTotalLength += mDividerWidth;
                }
                final LayoutParams layoutParams = (LayoutParams)virtualChild.getLayoutParams();
                n7 += layoutParams.weight;
                if (mode == 1073741824 && layoutParams.width == 0 && layoutParams.weight > 0.0f) {
                    if (b3) {
                        mTotalLength += layoutParams.leftMargin + layoutParams.rightMargin;
                    }
                    else {
                        final int mTotalLength = this.mTotalLength;
                        this.mTotalLength = Math.max(mTotalLength, mTotalLength + layoutParams.leftMargin + layoutParams.rightMargin);
                    }
                    if (mBaselineAligned) {
                        final int measureSpec = View$MeasureSpec.makeMeasureSpec(0, 0);
                        virtualChild.measure(measureSpec, measureSpec);
                    }
                    else {
                        b2 = true;
                    }
                }
                else {
                    int width = Integer.MIN_VALUE;
                    if (layoutParams.width == 0 && layoutParams.weight > 0.0f) {
                        width = 0;
                        layoutParams.width = -2;
                    }
                    int mTotalLength2;
                    if (n7 == 0.0f) {
                        mTotalLength2 = mTotalLength;
                    }
                    else {
                        mTotalLength2 = 0;
                    }
                    this.measureChildBeforeLayout(virtualChild, i, n, mTotalLength2, n2, 0);
                    if (width != Integer.MIN_VALUE) {
                        layoutParams.width = width;
                    }
                    final int measuredWidth = virtualChild.getMeasuredWidth();
                    if (b3) {
                        mTotalLength += measuredWidth + layoutParams.leftMargin + layoutParams.rightMargin + this.getNextLocationOffset(virtualChild);
                    }
                    else {
                        final int mTotalLength3 = mTotalLength;
                        mTotalLength = Math.max(mTotalLength3, mTotalLength3 + measuredWidth + layoutParams.leftMargin + layoutParams.rightMargin + this.getNextLocationOffset(virtualChild));
                    }
                    if (mUseLargestChild) {
                        max2 = Math.max(measuredWidth, max2);
                    }
                }
                boolean b4 = false;
                if (mode2 != 1073741824) {
                    final int height = layoutParams.height;
                    b4 = false;
                    if (height == -1) {
                        b = true;
                        b4 = true;
                    }
                }
                int n8 = layoutParams.topMargin + layoutParams.bottomMargin;
                final int n9 = n8 + virtualChild.getMeasuredHeight();
                n4 = ViewUtils.combineMeasuredStates(n4, ViewCompat.getMeasuredState(virtualChild));
                if (mBaselineAligned) {
                    final int baseline = virtualChild.getBaseline();
                    if (baseline != -1) {
                        int n10;
                        if (layoutParams.gravity < 0) {
                            n10 = mGravity;
                        }
                        else {
                            n10 = layoutParams.gravity;
                        }
                        final int n11 = (0xFFFFFFFE & (n10 & 0x70) >> 4) >> 1;
                        mMaxAscent[n11] = Math.max(mMaxAscent[n11], baseline);
                        mMaxDescent[n11] = Math.max(mMaxDescent[n11], n9 - baseline);
                    }
                }
                n3 = Math.max(n3, n9);
                if (n6 != 0 && layoutParams.height == -1) {
                    n6 = 1;
                }
                else {
                    n6 = 0;
                }
                if (layoutParams.weight > 0.0f) {
                    if (!b4) {
                        n8 = n9;
                    }
                    max = Math.max(max, n8);
                }
                else {
                    if (!b4) {
                        n8 = n9;
                    }
                    n5 = Math.max(n5, n8);
                }
                i += this.getChildrenSkipCount(virtualChild, i);
            }
        }
        if (mTotalLength > 0 && this.hasDividerBeforeChildAt(virtualChildCount)) {
            mTotalLength += mDividerWidth;
        }
        if (mMaxAscent[1] != -1 || mMaxAscent[0] != -1 || mMaxAscent[2] != -1 || mMaxAscent[3] != -1) {
            n3 = Math.max(n3, Math.max(mMaxAscent[3], Math.max(mMaxAscent[0], Math.max(mMaxAscent[1], mMaxAscent[2]))) + Math.max(mMaxDescent[3], Math.max(mMaxDescent[0], Math.max(mMaxDescent[1], mMaxDescent[2]))));
        }
        if (mUseLargestChild && (mode == Integer.MIN_VALUE || mode == 0)) {
            mTotalLength = 0;
            for (int j = 0; j < virtualChildCount; ++j) {
                final View virtualChild2 = this.getVirtualChildAt(j);
                if (virtualChild2 == null) {
                    mTotalLength += this.measureNullChild(j);
                }
                else if (virtualChild2.getVisibility() == 8) {
                    j += this.getChildrenSkipCount(virtualChild2, j);
                }
                else {
                    final LayoutParams layoutParams2 = (LayoutParams)virtualChild2.getLayoutParams();
                    if (b3) {
                        mTotalLength += max2 + layoutParams2.leftMargin + layoutParams2.rightMargin + this.getNextLocationOffset(virtualChild2);
                    }
                    else {
                        final int mTotalLength4 = mTotalLength;
                        mTotalLength = Math.max(mTotalLength4, mTotalLength4 + max2 + layoutParams2.leftMargin + layoutParams2.rightMargin + this.getNextLocationOffset(virtualChild2));
                    }
                }
            }
        }
        mTotalLength += this.getPaddingLeft() + this.getPaddingRight();
        final int resolveSizeAndState = ViewCompat.resolveSizeAndState(Math.max(mTotalLength, this.getSuggestedMinimumWidth()), n, 0);
        int n12 = (resolveSizeAndState & 0xFFFFFF) - mTotalLength;
        if (b2 || (n12 != 0 && n7 > 0.0f)) {
            float mWeightSum;
            if (this.mWeightSum > 0.0f) {
                mWeightSum = this.mWeightSum;
            }
            else {
                mWeightSum = n7;
            }
            mMaxAscent[2] = (mMaxAscent[3] = -1);
            mMaxAscent[0] = (mMaxAscent[1] = -1);
            mMaxDescent[2] = (mMaxDescent[3] = -1);
            mMaxDescent[0] = (mMaxDescent[1] = -1);
            n3 = -1;
            mTotalLength = 0;
            for (int k = 0; k < virtualChildCount; ++k) {
                final View virtualChild3 = this.getVirtualChildAt(k);
                if (virtualChild3 != null && virtualChild3.getVisibility() != 8) {
                    final LayoutParams layoutParams3 = (LayoutParams)virtualChild3.getLayoutParams();
                    final float weight = layoutParams3.weight;
                    if (weight > 0.0f) {
                        int n13 = (int)(weight * n12 / mWeightSum);
                        mWeightSum -= weight;
                        n12 -= n13;
                        final int childMeasureSpec = getChildMeasureSpec(n2, this.getPaddingTop() + this.getPaddingBottom() + layoutParams3.topMargin + layoutParams3.bottomMargin, layoutParams3.height);
                        if (layoutParams3.width != 0 || mode != 1073741824) {
                            int n14 = n13 + virtualChild3.getMeasuredWidth();
                            if (n14 < 0) {
                                n14 = 0;
                            }
                            virtualChild3.measure(View$MeasureSpec.makeMeasureSpec(n14, 1073741824), childMeasureSpec);
                        }
                        else {
                            if (n13 <= 0) {
                                n13 = 0;
                            }
                            virtualChild3.measure(View$MeasureSpec.makeMeasureSpec(n13, 1073741824), childMeasureSpec);
                        }
                        n4 = ViewUtils.combineMeasuredStates(n4, 0xFF000000 & ViewCompat.getMeasuredState(virtualChild3));
                    }
                    if (b3) {
                        mTotalLength += virtualChild3.getMeasuredWidth() + layoutParams3.leftMargin + layoutParams3.rightMargin + this.getNextLocationOffset(virtualChild3);
                    }
                    else {
                        final int mTotalLength5 = mTotalLength;
                        mTotalLength = Math.max(mTotalLength5, mTotalLength5 + virtualChild3.getMeasuredWidth() + layoutParams3.leftMargin + layoutParams3.rightMargin + this.getNextLocationOffset(virtualChild3));
                    }
                    int n15;
                    if (mode2 != 1073741824 && layoutParams3.height == -1) {
                        n15 = 1;
                    }
                    else {
                        n15 = 0;
                    }
                    int n16 = layoutParams3.topMargin + layoutParams3.bottomMargin;
                    final int n17 = n16 + virtualChild3.getMeasuredHeight();
                    n3 = Math.max(n3, n17);
                    if (n15 == 0) {
                        n16 = n17;
                    }
                    n5 = Math.max(n5, n16);
                    if (n6 != 0 && layoutParams3.height == -1) {
                        n6 = 1;
                    }
                    else {
                        n6 = 0;
                    }
                    if (mBaselineAligned) {
                        final int baseline2 = virtualChild3.getBaseline();
                        if (baseline2 != -1) {
                            int n18;
                            if (layoutParams3.gravity < 0) {
                                n18 = mGravity;
                            }
                            else {
                                n18 = layoutParams3.gravity;
                            }
                            final int n19 = (0xFFFFFFFE & (n18 & 0x70) >> 4) >> 1;
                            mMaxAscent[n19] = Math.max(mMaxAscent[n19], baseline2);
                            mMaxDescent[n19] = Math.max(mMaxDescent[n19], n17 - baseline2);
                        }
                    }
                }
            }
            mTotalLength += this.getPaddingLeft() + this.getPaddingRight();
            if (mMaxAscent[1] != -1 || mMaxAscent[0] != -1 || mMaxAscent[2] != -1 || mMaxAscent[3] != -1) {
                n3 = Math.max(n3, Math.max(mMaxAscent[3], Math.max(mMaxAscent[0], Math.max(mMaxAscent[1], mMaxAscent[2]))) + Math.max(mMaxDescent[3], Math.max(mMaxDescent[0], Math.max(mMaxDescent[1], mMaxDescent[2]))));
            }
        }
        else {
            n5 = Math.max(n5, max);
            if (mUseLargestChild && mode != 1073741824) {
                for (int l = 0; l < virtualChildCount; ++l) {
                    final View virtualChild4 = this.getVirtualChildAt(l);
                    if (virtualChild4 != null && virtualChild4.getVisibility() != 8 && ((LayoutParams)virtualChild4.getLayoutParams()).weight > 0.0f) {
                        virtualChild4.measure(View$MeasureSpec.makeMeasureSpec(max2, 1073741824), View$MeasureSpec.makeMeasureSpec(virtualChild4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
        }
        if (n6 == 0 && mode2 != 1073741824) {
            n3 = n5;
        }
        this.setMeasuredDimension(resolveSizeAndState | (0xFF000000 & n4), ViewCompat.resolveSizeAndState(Math.max(n3 + (this.getPaddingTop() + this.getPaddingBottom()), this.getSuggestedMinimumHeight()), n2, n4 << 16));
        if (b) {
            this.forceUniformHeight(virtualChildCount, n);
        }
    }
    
    int measureNullChild(final int n) {
        return 0;
    }
    
    void measureVertical(final int n, final int n2) {
        mTotalLength = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int max = 0;
        int n6 = 1;
        float n7 = 0.0f;
        final int virtualChildCount = this.getVirtualChildCount();
        final int mode = View$MeasureSpec.getMode(n);
        final int mode2 = View$MeasureSpec.getMode(n2);
        boolean b = false;
        boolean b2 = false;
        final int mBaselineAlignedChildIndex = this.mBaselineAlignedChildIndex;
        final boolean mUseLargestChild = this.mUseLargestChild;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < virtualChildCount; ++i) {
            final View virtualChild = this.getVirtualChildAt(i);
            if (virtualChild == null) {
                mTotalLength += this.measureNullChild(i);
            }
            else if (virtualChild.getVisibility() == 8) {
                i += this.getChildrenSkipCount(virtualChild, i);
            }
            else {
                if (this.hasDividerBeforeChildAt(i)) {
                    mTotalLength += mDividerHeight;
                }
                final LayoutParams layoutParams = (LayoutParams)virtualChild.getLayoutParams();
                n7 += layoutParams.weight;
                if (mode2 == 1073741824 && layoutParams.height == 0 && layoutParams.weight > 0.0f) {
                    final int mTotalLength = this.mTotalLength;
                    this.mTotalLength = Math.max(mTotalLength, mTotalLength + layoutParams.topMargin + layoutParams.bottomMargin);
                    b2 = true;
                }
                else {
                    int height = Integer.MIN_VALUE;
                    if (layoutParams.height == 0 && layoutParams.weight > 0.0f) {
                        height = 0;
                        layoutParams.height = -2;
                    }
                    int mTotalLength2;
                    if (n7 == 0.0f) {
                        mTotalLength2 = mTotalLength;
                    }
                    else {
                        mTotalLength2 = 0;
                    }
                    this.measureChildBeforeLayout(virtualChild, i, n, 0, n2, mTotalLength2);
                    if (height != Integer.MIN_VALUE) {
                        layoutParams.height = height;
                    }
                    final int measuredHeight = virtualChild.getMeasuredHeight();
                    final int mTotalLength3 = mTotalLength;
                    mTotalLength = Math.max(mTotalLength3, mTotalLength3 + measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin + this.getNextLocationOffset(virtualChild));
                    if (mUseLargestChild) {
                        max2 = Math.max(measuredHeight, max2);
                    }
                }
                if (mBaselineAlignedChildIndex >= 0 && mBaselineAlignedChildIndex == i + 1) {
                    mBaselineChildTop = mTotalLength;
                }
                if (i < mBaselineAlignedChildIndex && layoutParams.weight > 0.0f) {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                }
                boolean b3 = false;
                if (mode != 1073741824) {
                    final int width = layoutParams.width;
                    b3 = false;
                    if (width == -1) {
                        b = true;
                        b3 = true;
                    }
                }
                int n8 = layoutParams.leftMargin + layoutParams.rightMargin;
                final int n9 = n8 + virtualChild.getMeasuredWidth();
                n3 = Math.max(n3, n9);
                n4 = ViewUtils.combineMeasuredStates(n4, ViewCompat.getMeasuredState(virtualChild));
                if (n6 != 0 && layoutParams.width == -1) {
                    n6 = 1;
                }
                else {
                    n6 = 0;
                }
                if (layoutParams.weight > 0.0f) {
                    if (!b3) {
                        n8 = n9;
                    }
                    max = Math.max(max, n8);
                }
                else {
                    if (!b3) {
                        n8 = n9;
                    }
                    n5 = Math.max(n5, n8);
                }
                i += this.getChildrenSkipCount(virtualChild, i);
            }
        }
        if (mTotalLength > 0 && this.hasDividerBeforeChildAt(virtualChildCount)) {
            mTotalLength += mDividerHeight;
        }
        if (mUseLargestChild && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            mTotalLength = 0;
            for (int j = 0; j < virtualChildCount; ++j) {
                final View virtualChild2 = this.getVirtualChildAt(j);
                if (virtualChild2 == null) {
                    mTotalLength += this.measureNullChild(j);
                }
                else if (virtualChild2.getVisibility() == 8) {
                    j += this.getChildrenSkipCount(virtualChild2, j);
                }
                else {
                    final LayoutParams layoutParams2 = (LayoutParams)virtualChild2.getLayoutParams();
                    final int mTotalLength4 = mTotalLength;
                    mTotalLength = Math.max(mTotalLength4, mTotalLength4 + max2 + layoutParams2.topMargin + layoutParams2.bottomMargin + this.getNextLocationOffset(virtualChild2));
                }
            }
        }
        mTotalLength += this.getPaddingTop() + this.getPaddingBottom();
        final int resolveSizeAndState = ViewCompat.resolveSizeAndState(Math.max(mTotalLength, this.getSuggestedMinimumHeight()), n2, 0);
        int n10 = (resolveSizeAndState & 0xFFFFFF) - mTotalLength;
        if (b2 || (n10 != 0 && n7 > 0.0f)) {
            float mWeightSum;
            if (this.mWeightSum > 0.0f) {
                mWeightSum = this.mWeightSum;
            }
            else {
                mWeightSum = n7;
            }
            mTotalLength = 0;
            for (int k = 0; k < virtualChildCount; ++k) {
                final View virtualChild3 = this.getVirtualChildAt(k);
                if (virtualChild3.getVisibility() != 8) {
                    final LayoutParams layoutParams3 = (LayoutParams)virtualChild3.getLayoutParams();
                    final float weight = layoutParams3.weight;
                    if (weight > 0.0f) {
                        int n11 = (int)(weight * n10 / mWeightSum);
                        mWeightSum -= weight;
                        n10 -= n11;
                        final int childMeasureSpec = getChildMeasureSpec(n, this.getPaddingLeft() + this.getPaddingRight() + layoutParams3.leftMargin + layoutParams3.rightMargin, layoutParams3.width);
                        if (layoutParams3.height != 0 || mode2 != 1073741824) {
                            int n12 = n11 + virtualChild3.getMeasuredHeight();
                            if (n12 < 0) {
                                n12 = 0;
                            }
                            virtualChild3.measure(childMeasureSpec, View$MeasureSpec.makeMeasureSpec(n12, 1073741824));
                        }
                        else {
                            if (n11 <= 0) {
                                n11 = 0;
                            }
                            virtualChild3.measure(childMeasureSpec, View$MeasureSpec.makeMeasureSpec(n11, 1073741824));
                        }
                        n4 = ViewUtils.combineMeasuredStates(n4, 0xFFFFFF00 & ViewCompat.getMeasuredState(virtualChild3));
                    }
                    int n13 = layoutParams3.leftMargin + layoutParams3.rightMargin;
                    final int n14 = n13 + virtualChild3.getMeasuredWidth();
                    n3 = Math.max(n3, n14);
                    int n15;
                    if (mode != 1073741824 && layoutParams3.width == -1) {
                        n15 = 1;
                    }
                    else {
                        n15 = 0;
                    }
                    if (n15 == 0) {
                        n13 = n14;
                    }
                    n5 = Math.max(n5, n13);
                    if (n6 != 0 && layoutParams3.width == -1) {
                        n6 = 1;
                    }
                    else {
                        n6 = 0;
                    }
                    final int mTotalLength5 = mTotalLength;
                    mTotalLength = Math.max(mTotalLength5, mTotalLength5 + virtualChild3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin + this.getNextLocationOffset(virtualChild3));
                }
            }
            mTotalLength += this.getPaddingTop() + this.getPaddingBottom();
        }
        else {
            n5 = Math.max(n5, max);
            if (mUseLargestChild && mode2 != 1073741824) {
                for (int l = 0; l < virtualChildCount; ++l) {
                    final View virtualChild4 = this.getVirtualChildAt(l);
                    if (virtualChild4 != null && virtualChild4.getVisibility() != 8 && ((LayoutParams)virtualChild4.getLayoutParams()).weight > 0.0f) {
                        virtualChild4.measure(View$MeasureSpec.makeMeasureSpec(virtualChild4.getMeasuredWidth(), 1073741824), View$MeasureSpec.makeMeasureSpec(max2, 1073741824));
                    }
                }
            }
        }
        if (n6 == 0 && mode != 1073741824) {
            n3 = n5;
        }
        this.setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(n3 + (this.getPaddingLeft() + this.getPaddingRight()), this.getSuggestedMinimumWidth()), n, n4), resolveSizeAndState);
        if (b) {
            this.forceUniformWidth(virtualChildCount, n2);
        }
    }
    
    protected void onDraw(final Canvas canvas) {
        if (mDivider == null) {
            return;
        }
        if (mOrientation == 1) {
            this.drawDividersVertical(canvas);
            return;
        }
        this.drawDividersHorizontal(canvas);
    }
    
    public void onInitializeAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        if (Build$VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName((CharSequence)LinearLayoutCompat.class.getName());
        }
    }
    
    public void onInitializeAccessibilityNodeInfo(final AccessibilityNodeInfo accessibilityNodeInfo) {
        if (Build$VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName((CharSequence)LinearLayoutCompat.class.getName());
        }
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        if (mOrientation == 1) {
            this.layoutVertical(n, n2, n3, n4);
            return;
        }
        this.layoutHorizontal(n, n2, n3, n4);
    }
    
    protected void onMeasure(final int n, final int n2) {
        if (mOrientation == 1) {
            this.measureVertical(n, n2);
            return;
        }
        this.measureHorizontal(n, n2);
    }
    
    public void setBaselineAligned(final boolean mBaselineAligned) {
        this.mBaselineAligned = mBaselineAligned;
    }
    
    public void setBaselineAlignedChildIndex(final int mBaselineAlignedChildIndex) {
        if (mBaselineAlignedChildIndex < 0 || mBaselineAlignedChildIndex >= this.getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + this.getChildCount() + ")");
        }
        this.mBaselineAlignedChildIndex = mBaselineAlignedChildIndex;
    }
    
    public void setDividerDrawable(final Drawable mDivider) {
        if (mDivider == this.mDivider) {
            return;
        }
        if ((this.mDivider = mDivider) != null) {
            mDividerWidth = mDivider.getIntrinsicWidth();
            mDividerHeight = mDivider.getIntrinsicHeight();
        }
        else {
            mDividerWidth = 0;
            mDividerHeight = 0;
        }
        boolean willNotDraw = false;
        if (mDivider == null) {
            willNotDraw = true;
        }
        this.setWillNotDraw(willNotDraw);
        this.requestLayout();
    }
    
    public void setDividerPadding(final int mDividerPadding) {
        this.mDividerPadding = mDividerPadding;
    }
    
    public void setGravity(int mGravity) {
        if (this.mGravity != mGravity) {
            if ((0x800007 & mGravity) == 0x0) {
                mGravity |= 0x800003;
            }
            if ((mGravity & 0x70) == 0x0) {
                mGravity |= 0x30;
            }
            this.mGravity = mGravity;
            this.requestLayout();
        }
    }
    
    public void setHorizontalGravity(final int n) {
        final int n2 = n & 0x800007;
        if ((0x800007 & mGravity) != n2) {
            mGravity = (n2 | (0xFF7FFFF8 & mGravity));
            this.requestLayout();
        }
    }
    
    public void setMeasureWithLargestChildEnabled(final boolean mUseLargestChild) {
        this.mUseLargestChild = mUseLargestChild;
    }
    
    public void setOrientation(final int mOrientation) {
        if (this.mOrientation != mOrientation) {
            this.mOrientation = mOrientation;
            this.requestLayout();
        }
    }
    
    public void setShowDividers(final int mShowDividers) {
        if (mShowDividers != this.mShowDividers) {
            this.requestLayout();
        }
        this.mShowDividers = mShowDividers;
    }
    
    public void setVerticalGravity(final int n) {
        final int n2 = n & 0x70;
        if ((0x70 & mGravity) != n2) {
            mGravity = (n2 | (0xFFFFFF8F & mGravity));
            this.requestLayout();
        }
    }
    
    public void setWeightSum(final float n) {
        mWeightSum = Math.max(0.0f, n);
    }
    
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
