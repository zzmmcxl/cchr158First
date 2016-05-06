package android.support.design.widget;

import android.support.design.R;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Bitmap$Config;
import android.text.TextUtils;
import android.text.TextUtils$TruncateAt;
import android.support.v4.text.TextDirectionHeuristicCompat;
import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.GravityCompat;
import android.graphics.Color;
import android.os.Build$VERSION;
import android.view.View;
import android.text.TextPaint;
import android.view.animation.Interpolator;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.Rect;
import android.graphics.Paint;

final class CollapsingTextHelper
{
    private static final boolean DEBUG_DRAW;
    private static final Paint DEBUG_DRAW_PAINT;
    private static final boolean USE_SCALING_TEXTURE;
    private boolean mBoundsChanged;
    private final Rect mCollapsedBounds;
    private float mCollapsedDrawX;
    private float mCollapsedDrawY;
    private int mCollapsedShadowColor;
    private float mCollapsedShadowDx;
    private float mCollapsedShadowDy;
    private float mCollapsedShadowRadius;
    private int mCollapsedTextColor;
    private int mCollapsedTextGravity;
    private float mCollapsedTextSize;
    private Typeface mCollapsedTypeface;
    private final RectF mCurrentBounds;
    private float mCurrentDrawX;
    private float mCurrentDrawY;
    private float mCurrentTextSize;
    private Typeface mCurrentTypeface;
    private boolean mDrawTitle;
    private final Rect mExpandedBounds;
    private float mExpandedDrawX;
    private float mExpandedDrawY;
    private float mExpandedFraction;
    private int mExpandedShadowColor;
    private float mExpandedShadowDx;
    private float mExpandedShadowDy;
    private float mExpandedShadowRadius;
    private int mExpandedTextColor;
    private int mExpandedTextGravity;
    private float mExpandedTextSize;
    private Bitmap mExpandedTitleTexture;
    private Typeface mExpandedTypeface;
    private boolean mIsRtl;
    private Interpolator mPositionInterpolator;
    private float mScale;
    private CharSequence mText;
    private final TextPaint mTextPaint;
    private Interpolator mTextSizeInterpolator;
    private CharSequence mTextToDraw;
    private float mTextureAscent;
    private float mTextureDescent;
    private Paint mTexturePaint;
    private boolean mUseTexture;
    private final View mView;
    
    static {
        USE_SCALING_TEXTURE = (Build$VERSION.SDK_INT < 18);
        DEBUG_DRAW_PAINT = null;
        if (DEBUG_DRAW_PAINT != null) {
            DEBUG_DRAW_PAINT.setAntiAlias(true);
            DEBUG_DRAW_PAINT.setColor(-65281);
        }
    }
    
    public CollapsingTextHelper(final View mView) {
        super();
        mExpandedTextGravity = 16;
        mCollapsedTextGravity = 16;
        mExpandedTextSize = 15.0f;
        mCollapsedTextSize = 15.0f;
        mView = mView;
        mTextPaint = new TextPaint(129);
        mCollapsedBounds = new Rect();
        mExpandedBounds = new Rect();
        mCurrentBounds = new RectF();
    }
    
    private static int blendColors(final int n, final int n2, final float n3) {
        final float n4 = 1.0f - n3;
        return Color.argb((int)(n4 * Color.alpha(n) + n3 * Color.alpha(n2)), (int)(n4 * Color.red(n) + n3 * Color.red(n2)), (int)(n4 * Color.green(n) + n3 * Color.green(n2)), (int)(n4 * Color.blue(n) + n3 * Color.blue(n2)));
    }
    
    private void calculateBaseOffsets() {
        int n = 1;
        final float mCurrentTextSize = this.mCurrentTextSize;
        this.calculateUsingTextSize(mCollapsedTextSize);
        float measureText;
        if (mTextToDraw != null) {
            measureText = mTextPaint.measureText(mTextToDraw, 0, mTextToDraw.length());
        }
        else {
            measureText = 0.0f;
        }
        final int mCollapsedTextGravity = this.mCollapsedTextGravity;
        int n2;
        if (mIsRtl) {
            n2 = n;
        }
        else {
            n2 = 0;
        }
        final int absoluteGravity = GravityCompat.getAbsoluteGravity(mCollapsedTextGravity, n2);
        switch (absoluteGravity & 0x70) {
            default:
                mCollapsedDrawY = (mTextPaint.descent() - mTextPaint.ascent()) / 2.0f - mTextPaint.descent() + mCollapsedBounds.centerY();
                break;
            case 80:
                mCollapsedDrawY = mCollapsedBounds.bottom;
                break;
            case 48:
                mCollapsedDrawY = mCollapsedBounds.top - mTextPaint.ascent();
                break;
        }
        switch (absoluteGravity & 0x7) {
            default:
                mCollapsedDrawX = mCollapsedBounds.left;
                break;
            case 1:
                mCollapsedDrawX = mCollapsedBounds.centerX() - measureText / 2.0f;
                break;
            case 5:
                mCollapsedDrawX = mCollapsedBounds.right - measureText;
                break;
        }
        this.calculateUsingTextSize(mExpandedTextSize);
        float measureText2;
        if (mTextToDraw != null) {
            measureText2 = mTextPaint.measureText(mTextToDraw, 0, mTextToDraw.length());
        }
        else {
            measureText2 = 0.0f;
        }
        final int mExpandedTextGravity = this.mExpandedTextGravity;
        if (!mIsRtl) {
            n = 0;
        }
        final int absoluteGravity2 = GravityCompat.getAbsoluteGravity(mExpandedTextGravity, n);
        switch (absoluteGravity2 & 0x70) {
            default:
                mExpandedDrawY = (mTextPaint.descent() - mTextPaint.ascent()) / 2.0f - mTextPaint.descent() + mExpandedBounds.centerY();
                break;
            case 80:
                mExpandedDrawY = mExpandedBounds.bottom;
                break;
            case 48:
                mExpandedDrawY = mExpandedBounds.top - mTextPaint.ascent();
                break;
        }
        switch (absoluteGravity2 & 0x7) {
            default:
                mExpandedDrawX = mExpandedBounds.left;
                break;
            case 1:
                mExpandedDrawX = mExpandedBounds.centerX() - measureText2 / 2.0f;
                break;
            case 5:
                mExpandedDrawX = mExpandedBounds.right - measureText2;
                break;
        }
        this.clearTexture();
        this.setInterpolatedTextSize(mCurrentTextSize);
    }
    
    private void calculateCurrentOffsets() {
        this.calculateOffsets(mExpandedFraction);
    }
    
    private boolean calculateIsRtl(final CharSequence charSequence) {
        int n = 1;
        if (ViewCompat.getLayoutDirection(mView) != n) {
            n = 0;
        }
        TextDirectionHeuristicCompat textDirectionHeuristicCompat;
        if (n != 0) {
            textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL;
        }
        else {
            textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        }
        return textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
    }
    
    private void calculateOffsets(final float n) {
        this.interpolateBounds(n);
        mCurrentDrawX = lerp(mExpandedDrawX, mCollapsedDrawX, n, mPositionInterpolator);
        mCurrentDrawY = lerp(mExpandedDrawY, mCollapsedDrawY, n, mPositionInterpolator);
        this.setInterpolatedTextSize(lerp(mExpandedTextSize, mCollapsedTextSize, n, mTextSizeInterpolator));
        if (mCollapsedTextColor != mExpandedTextColor) {
            mTextPaint.setColor(blendColors(mExpandedTextColor, mCollapsedTextColor, n));
        }
        else {
            mTextPaint.setColor(mCollapsedTextColor);
        }
        mTextPaint.setShadowLayer(lerp(mExpandedShadowRadius, mCollapsedShadowRadius, n, (Interpolator)null), lerp(mExpandedShadowDx, mCollapsedShadowDx, n, (Interpolator)null), lerp(mExpandedShadowDy, mCollapsedShadowDy, n, (Interpolator)null), blendColors(mExpandedShadowColor, mCollapsedShadowColor, n));
        ViewCompat.postInvalidateOnAnimation(mView);
    }
    
    private void calculateUsingTextSize(final float n) {
        boolean linearText = true;
        if (mText != null) {
            float n2;
            float mCurrentTextSize;
            boolean b;
            if (isClose(n, mCollapsedTextSize)) {
                n2 = mCollapsedBounds.width();
                mCurrentTextSize = mCollapsedTextSize;
                mScale = 1.0f;
                final Typeface mCurrentTypeface = this.mCurrentTypeface;
                final Typeface mCollapsedTypeface = this.mCollapsedTypeface;
                b = false;
                if (mCurrentTypeface != mCollapsedTypeface) {
                    this.mCurrentTypeface = this.mCollapsedTypeface;
                    b = true;
                }
            }
            else {
                n2 = mExpandedBounds.width();
                mCurrentTextSize = mExpandedTextSize;
                final Typeface mCurrentTypeface2 = mCurrentTypeface;
                final Typeface mExpandedTypeface = this.mExpandedTypeface;
                b = false;
                if (mCurrentTypeface2 != mExpandedTypeface) {
                    mCurrentTypeface = this.mExpandedTypeface;
                    b = true;
                }
                if (isClose(n, mExpandedTextSize)) {
                    mScale = 1.0f;
                }
                else {
                    mScale = n / mExpandedTextSize;
                }
            }
            if (n2 > 0.0f) {
                b = ((this.mCurrentTextSize != mCurrentTextSize || mBoundsChanged || b) && linearText);
                this.mCurrentTextSize = mCurrentTextSize;
                mBoundsChanged = false;
            }
            if (mTextToDraw == null || b) {
                mTextPaint.setTextSize(this.mCurrentTextSize);
                mTextPaint.setTypeface(mCurrentTypeface);
                final TextPaint mTextPaint = this.mTextPaint;
                if (mScale == 1.0f) {
                    linearText = false;
                }
                mTextPaint.setLinearText(linearText);
                final CharSequence ellipsize = TextUtils.ellipsize(mText, this.mTextPaint, n2, TextUtils$TruncateAt.END);
                if (!TextUtils.equals(ellipsize, mTextToDraw)) {
                    mTextToDraw = ellipsize;
                    mIsRtl = this.calculateIsRtl(mTextToDraw);
                }
            }
        }
    }
    
    private void clearTexture() {
        if (mExpandedTitleTexture != null) {
            mExpandedTitleTexture.recycle();
            mExpandedTitleTexture = null;
        }
    }
    
    private void ensureExpandedTexture() {
        if (mExpandedTitleTexture == null && !mExpandedBounds.isEmpty() && !TextUtils.isEmpty(mTextToDraw)) {
            this.calculateOffsets(0.0f);
            mTextureAscent = mTextPaint.ascent();
            mTextureDescent = mTextPaint.descent();
            final int round = Math.round(mTextPaint.measureText(mTextToDraw, 0, mTextToDraw.length()));
            final int round2 = Math.round(mTextureDescent - mTextureAscent);
            if (round > 0 && round2 > 0) {
                mExpandedTitleTexture = Bitmap.createBitmap(round, round2, Bitmap$Config.ARGB_8888);
                new Canvas(mExpandedTitleTexture).drawText(mTextToDraw, 0, mTextToDraw.length(), 0.0f, (float)round2 - mTextPaint.descent(), (Paint)mTextPaint);
                if (mTexturePaint == null) {
                    mTexturePaint = new Paint(3);
                }
            }
        }
    }
    
    private void interpolateBounds(final float n) {
        mCurrentBounds.left = lerp(mExpandedBounds.left, mCollapsedBounds.left, n, mPositionInterpolator);
        mCurrentBounds.top = lerp(mExpandedDrawY, mCollapsedDrawY, n, mPositionInterpolator);
        mCurrentBounds.right = lerp(mExpandedBounds.right, mCollapsedBounds.right, n, mPositionInterpolator);
        mCurrentBounds.bottom = lerp(mExpandedBounds.bottom, mCollapsedBounds.bottom, n, mPositionInterpolator);
    }
    
    private static boolean isClose(final float n, final float n2) {
        return Math.abs(n - n2) < 0.001f;
    }
    
    private static float lerp(final float n, final float n2, float interpolation, final Interpolator interpolator) {
        if (interpolator != null) {
            interpolation = interpolator.getInterpolation(interpolation);
        }
        return AnimationUtils.lerp(n, n2, interpolation);
    }
    
    private Typeface readFontFamilyTypeface(final int n) {
        final TypedArray obtainStyledAttributes = mView.getContext().obtainStyledAttributes(n, new int[] { 16843692 });
        try {
            final String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                return Typeface.create(string, 0);
            }
            return null;
        }
        finally {
            obtainStyledAttributes.recycle();
        }
    }
    
    private static boolean rectEquals(final Rect rect, final int n, final int n2, final int n3, final int n4) {
        return rect.left == n && rect.top == n2 && rect.right == n3 && rect.bottom == n4;
    }
    
    private void setInterpolatedTextSize(final float n) {
        this.calculateUsingTextSize(n);
        mUseTexture = (USE_SCALING_TEXTURE && mScale != 1.0f);
        if (mUseTexture) {
            this.ensureExpandedTexture();
        }
        ViewCompat.postInvalidateOnAnimation(mView);
    }
    
    public void draw(final Canvas canvas) {
        final int save = canvas.save();
        if (mTextToDraw != null && mDrawTitle) {
            final float mCurrentDrawX = this.mCurrentDrawX;
            float mCurrentDrawY = this.mCurrentDrawY;
            boolean b;
            if (mUseTexture && mExpandedTitleTexture != null) {
                b = true;
            }
            else {
                b = false;
            }
            float n;
            if (b) {
                n = mTextureAscent * mScale;
                final float n2 = mTextureDescent * mScale;
            }
            else {
                n = mTextPaint.ascent() * mScale;
                final float n3 = mTextPaint.descent() * mScale;
            }
            if (b) {
                mCurrentDrawY += n;
            }
            if (mScale != 1.0f) {
                canvas.scale(mScale, mScale, mCurrentDrawX, mCurrentDrawY);
            }
            if (b) {
                canvas.drawBitmap(mExpandedTitleTexture, mCurrentDrawX, mCurrentDrawY, mTexturePaint);
            }
            else {
                canvas.drawText(mTextToDraw, 0, mTextToDraw.length(), mCurrentDrawX, mCurrentDrawY, (Paint)mTextPaint);
            }
        }
        canvas.restoreToCount(save);
    }
    
    int getCollapsedTextColor() {
        return mCollapsedTextColor;
    }
    
    int getCollapsedTextGravity() {
        return mCollapsedTextGravity;
    }
    
    float getCollapsedTextSize() {
        return mCollapsedTextSize;
    }
    
    Typeface getCollapsedTypeface() {
        if (mCollapsedTypeface != null) {
            return mCollapsedTypeface;
        }
        return Typeface.DEFAULT;
    }
    
    int getExpandedTextColor() {
        return mExpandedTextColor;
    }
    
    int getExpandedTextGravity() {
        return mExpandedTextGravity;
    }
    
    float getExpandedTextSize() {
        return mExpandedTextSize;
    }
    
    Typeface getExpandedTypeface() {
        if (mExpandedTypeface != null) {
            return mExpandedTypeface;
        }
        return Typeface.DEFAULT;
    }
    
    float getExpansionFraction() {
        return mExpandedFraction;
    }
    
    CharSequence getText() {
        return mText;
    }
    
    void onBoundsChanged() {
        mDrawTitle = (mCollapsedBounds.width() > 0 && mCollapsedBounds.height() > 0 && mExpandedBounds.width() > 0 && mExpandedBounds.height() > 0);
    }
    
    public void recalculate() {
        if (mView.getHeight() > 0 && mView.getWidth() > 0) {
            this.calculateBaseOffsets();
            this.calculateCurrentOffsets();
        }
    }
    
    void setCollapsedBounds(final int n, final int n2, final int n3, final int n4) {
        if (!rectEquals(mCollapsedBounds, n, n2, n3, n4)) {
            mCollapsedBounds.set(n, n2, n3, n4);
            mBoundsChanged = true;
            this.onBoundsChanged();
        }
    }
    
    void setCollapsedTextAppearance(final int n) {
        final TypedArray obtainStyledAttributes = mView.getContext().obtainStyledAttributes(n, R.styleable.TextAppearance);
        if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textColor)) {
            mCollapsedTextColor = obtainStyledAttributes.getColor(R.styleable.TextAppearance_android_textColor, mCollapsedTextColor);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textSize)) {
            mCollapsedTextSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, (int)mCollapsedTextSize);
        }
        mCollapsedShadowColor = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_shadowColor, 0);
        mCollapsedShadowDx = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        mCollapsedShadowDy = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        mCollapsedShadowRadius = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        if (Build$VERSION.SDK_INT >= 16) {
            mCollapsedTypeface = this.readFontFamilyTypeface(n);
        }
        this.recalculate();
    }
    
    void setCollapsedTextColor(final int mCollapsedTextColor) {
        if (this.mCollapsedTextColor != mCollapsedTextColor) {
            this.mCollapsedTextColor = mCollapsedTextColor;
            this.recalculate();
        }
    }
    
    void setCollapsedTextGravity(final int mCollapsedTextGravity) {
        if (this.mCollapsedTextGravity != mCollapsedTextGravity) {
            this.mCollapsedTextGravity = mCollapsedTextGravity;
            this.recalculate();
        }
    }
    
    void setCollapsedTextSize(final float mCollapsedTextSize) {
        if (this.mCollapsedTextSize != mCollapsedTextSize) {
            this.mCollapsedTextSize = mCollapsedTextSize;
            this.recalculate();
        }
    }
    
    void setCollapsedTypeface(final Typeface mCollapsedTypeface) {
        if (this.mCollapsedTypeface != mCollapsedTypeface) {
            this.mCollapsedTypeface = mCollapsedTypeface;
            this.recalculate();
        }
    }
    
    void setExpandedBounds(final int n, final int n2, final int n3, final int n4) {
        if (!rectEquals(mExpandedBounds, n, n2, n3, n4)) {
            mExpandedBounds.set(n, n2, n3, n4);
            mBoundsChanged = true;
            this.onBoundsChanged();
        }
    }
    
    void setExpandedTextAppearance(final int n) {
        final TypedArray obtainStyledAttributes = mView.getContext().obtainStyledAttributes(n, R.styleable.TextAppearance);
        if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textColor)) {
            mExpandedTextColor = obtainStyledAttributes.getColor(R.styleable.TextAppearance_android_textColor, mExpandedTextColor);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textSize)) {
            mExpandedTextSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, (int)mExpandedTextSize);
        }
        mExpandedShadowColor = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_shadowColor, 0);
        mExpandedShadowDx = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        mExpandedShadowDy = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        mExpandedShadowRadius = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        if (Build$VERSION.SDK_INT >= 16) {
            mExpandedTypeface = this.readFontFamilyTypeface(n);
        }
        this.recalculate();
    }
    
    void setExpandedTextColor(final int mExpandedTextColor) {
        if (this.mExpandedTextColor != mExpandedTextColor) {
            this.mExpandedTextColor = mExpandedTextColor;
            this.recalculate();
        }
    }
    
    void setExpandedTextGravity(final int mExpandedTextGravity) {
        if (this.mExpandedTextGravity != mExpandedTextGravity) {
            this.mExpandedTextGravity = mExpandedTextGravity;
            this.recalculate();
        }
    }
    
    void setExpandedTextSize(final float mExpandedTextSize) {
        if (this.mExpandedTextSize != mExpandedTextSize) {
            this.mExpandedTextSize = mExpandedTextSize;
            this.recalculate();
        }
    }
    
    void setExpandedTypeface(final Typeface mExpandedTypeface) {
        if (this.mExpandedTypeface != mExpandedTypeface) {
            this.mExpandedTypeface = mExpandedTypeface;
            this.recalculate();
        }
    }
    
    void setExpansionFraction(final float n) {
        final float constrain = MathUtils.constrain(n, 0.0f, 1.0f);
        if (constrain != mExpandedFraction) {
            mExpandedFraction = constrain;
            this.calculateCurrentOffsets();
        }
    }
    
    void setPositionInterpolator(final Interpolator mPositionInterpolator) {
        this.mPositionInterpolator = mPositionInterpolator;
        this.recalculate();
    }
    
    void setText(final CharSequence mText) {
        if (mText == null || !mText.equals(this.mText)) {
            this.mText = mText;
            mTextToDraw = null;
            this.clearTexture();
            this.recalculate();
        }
    }
    
    void setTextSizeInterpolator(final Interpolator mTextSizeInterpolator) {
        this.mTextSizeInterpolator = mTextSizeInterpolator;
        this.recalculate();
    }
    
    void setTypefaces(final Typeface typeface) {
        mExpandedTypeface = typeface;
        mCollapsedTypeface = typeface;
        this.recalculate();
    }
}
