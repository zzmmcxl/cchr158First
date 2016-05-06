package android.support.design.widget;

import android.view.ViewGroup;
import java.util.List;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.util.Log;
import android.annotation.TargetApi;
import android.view.View;
import android.support.v4.view.ViewCompat;
import android.support.annotation.NonNull;
import android.view.View$MeasureSpec;
import android.support.annotation.Nullable;
import android.os.Build$VERSION;
import android.graphics.drawable.Drawable;
import android.content.res.TypedArray;
import android.widget.ImageView;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.design.R;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatImageHelper;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;

@CoordinatorLayout.DefaultBehavior("Landroid/support/design/widget/FloatingActionButton$Behavior;")
public class FloatingActionButton extends VisibilityAwareImageButton
{
    private static final String LOG_TAG = "FloatingActionButton";
    private static final int SIZE_MINI = 1;
    private static final int SIZE_NORMAL;
    private ColorStateList mBackgroundTint;
    private PorterDuff$Mode mBackgroundTintMode;
    private int mBorderWidth;
    private boolean mCompatPadding;
    private AppCompatImageHelper mImageHelper;
    private int mImagePadding;
    private FloatingActionButtonImpl mImpl;
    private int mRippleColor;
    private final Rect mShadowPadding;
    private int mSize;
    
    public FloatingActionButton(final Context context) {
        this(context, null);
    }
    
    public FloatingActionButton(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public FloatingActionButton(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        mShadowPadding = new Rect();
        ThemeUtils.checkAppCompatTheme(context);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.FloatingActionButton, n, R.style.Widget_Design_FloatingActionButton);
        mBackgroundTint = obtainStyledAttributes.getColorStateList(R.styleable.FloatingActionButton_backgroundTint);
        mBackgroundTintMode = parseTintMode(obtainStyledAttributes.getInt(R.styleable.FloatingActionButton_backgroundTintMode, -1), null);
        mRippleColor = obtainStyledAttributes.getColor(R.styleable.FloatingActionButton_rippleColor, 0);
        mSize = obtainStyledAttributes.getInt(R.styleable.FloatingActionButton_fabSize, 0);
        mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FloatingActionButton_borderWidth, 0);
        final float dimension = obtainStyledAttributes.getDimension(R.styleable.FloatingActionButton_elevation, 0.0f);
        final float dimension2 = obtainStyledAttributes.getDimension(R.styleable.FloatingActionButton_pressedTranslationZ, 0.0f);
        mCompatPadding = obtainStyledAttributes.getBoolean(R.styleable.FloatingActionButton_useCompatPadding, false);
        obtainStyledAttributes.recycle();
        (mImageHelper = new AppCompatImageHelper((ImageView)this, AppCompatDrawableManager.get())).loadFromAttributes(set, n);
        mImagePadding = (this.getSizeDimension() - (int)this.getResources().getDimension(R.dimen.design_fab_image_size)) / 2;
        this.getImpl().setBackgroundDrawable(mBackgroundTint, mBackgroundTintMode, mRippleColor, mBorderWidth);
        this.getImpl().setElevation(dimension);
        this.getImpl().setPressedTranslationZ(dimension2);
        this.getImpl().updatePadding();
    }
    
    static /* synthetic */ void access$000(final FloatingActionButton floatingActionButton, final OnVisibilityChangedListener onVisibilityChangedListener, final boolean b) {
        floatingActionButton.hide(onVisibilityChangedListener, b);
    }
    
    static /* synthetic */ void access$100(final FloatingActionButton floatingActionButton, final OnVisibilityChangedListener onVisibilityChangedListener, final boolean b) {
        floatingActionButton.show(onVisibilityChangedListener, b);
    }
    
    static /* synthetic */ Rect access$200(final FloatingActionButton floatingActionButton) {
        return floatingActionButton.mShadowPadding;
    }
    
    static /* synthetic */ int access$400(final FloatingActionButton floatingActionButton) {
        return floatingActionButton.mImagePadding;
    }
    
    static /* synthetic */ void access$501(final FloatingActionButton floatingActionButton, final Drawable backgroundDrawable) {
        ((View)floatingActionButton).setBackgroundDrawable(backgroundDrawable);
    }
    
    static /* synthetic */ boolean access$600(final FloatingActionButton floatingActionButton) {
        return floatingActionButton.mCompatPadding;
    }
    
    private FloatingActionButtonImpl createImpl() {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 21) {
            return new FloatingActionButtonLollipop(this, new ShadowDelegateImpl(this));
        }
        if (sdk_INT >= 14) {
            return new FloatingActionButtonIcs(this, new ShadowDelegateImpl(this));
        }
        return new FloatingActionButtonEclairMr1(this, new ShadowDelegateImpl(this));
    }
    
    private FloatingActionButtonImpl getImpl() {
        if (mImpl == null) {
            mImpl = this.createImpl();
        }
        return mImpl;
    }
    
    private void hide(@Nullable final OnVisibilityChangedListener onVisibilityChangedListener, final boolean b) {
        this.getImpl().hide(this.wrapOnVisibilityChangedListener(onVisibilityChangedListener), b);
    }
    
    static PorterDuff$Mode parseTintMode(final int n, final PorterDuff$Mode porterDuff$Mode) {
        switch (n) {
            default:
                return porterDuff$Mode;
            case 3:
                return PorterDuff$Mode.SRC_OVER;
            case 5:
                return PorterDuff$Mode.SRC_IN;
            case 9:
                return PorterDuff$Mode.SRC_ATOP;
            case 14:
                return PorterDuff$Mode.MULTIPLY;
            case 15:
                return PorterDuff$Mode.SCREEN;
        }
    }
    
    private static int resolveAdjustedSize(final int n, final int n2) {
        final int mode = View$MeasureSpec.getMode(n2);
        final int size = View$MeasureSpec.getSize(n2);
        switch (mode) {
            default:
                return n;
            case 0:
                return n;
            case Integer.MIN_VALUE:
                return Math.min(n, size);
            case 1073741824:
                return size;
        }
    }
    
    private void show(final OnVisibilityChangedListener onVisibilityChangedListener, final boolean b) {
        this.getImpl().show(this.wrapOnVisibilityChangedListener(onVisibilityChangedListener), b);
    }
    
    @Nullable
    private FloatingActionButtonImpl.InternalVisibilityChangedListener wrapOnVisibilityChangedListener(@Nullable final OnVisibilityChangedListener onVisibilityChangedListener) {
        if (onVisibilityChangedListener == null) {
            return null;
        }
        return new FloatingActionButtonImpl.InternalVisibilityChangedListener() {
            final /* synthetic */ FloatingActionButton this$0;
            final /* synthetic */ OnVisibilityChangedListener val$listener;
            
            FloatingActionButton$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void onHidden() {
                onVisibilityChangedListener.onHidden(this$0);
            }
            
            @Override
            public void onShown() {
                onVisibilityChangedListener.onShown(this$0);
            }
        };
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.getImpl().onDrawableStateChanged(this.getDrawableState());
    }
    
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return mBackgroundTint;
    }
    
    @Nullable
    public PorterDuff$Mode getBackgroundTintMode() {
        return mBackgroundTintMode;
    }
    
    public float getCompatElevation() {
        return this.getImpl().getElevation();
    }
    
    @NonNull
    public Drawable getContentBackground() {
        return this.getImpl().getContentBackground();
    }
    
    public boolean getContentRect(@NonNull final Rect rect) {
        final boolean laidOut = ViewCompat.isLaidOut((View)this);
        boolean b = false;
        if (laidOut) {
            rect.set(0, 0, this.getWidth(), this.getHeight());
            rect.left += mShadowPadding.left;
            rect.top += mShadowPadding.top;
            rect.right -= mShadowPadding.right;
            rect.bottom -= mShadowPadding.bottom;
            b = true;
        }
        return b;
    }
    
    final int getSizeDimension() {
        switch (mSize) {
            default:
                return this.getResources().getDimensionPixelSize(R.dimen.design_fab_size_normal);
            case 1:
                return this.getResources().getDimensionPixelSize(R.dimen.design_fab_size_mini);
        }
    }
    
    public boolean getUseCompatPadding() {
        return mCompatPadding;
    }
    
    public void hide() {
        this.hide(null);
    }
    
    public void hide(@Nullable final OnVisibilityChangedListener onVisibilityChangedListener) {
        this.hide(onVisibilityChangedListener, true);
    }
    
    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.getImpl().jumpDrawableToCurrentState();
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.getImpl().onAttachedToWindow();
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.getImpl().onDetachedFromWindow();
    }
    
    protected void onMeasure(final int n, final int n2) {
        final int sizeDimension = this.getSizeDimension();
        final int min = Math.min(resolveAdjustedSize(sizeDimension, n), resolveAdjustedSize(sizeDimension, n2));
        this.setMeasuredDimension(min + mShadowPadding.left + mShadowPadding.right, min + mShadowPadding.top + mShadowPadding.bottom);
    }
    
    public void setBackgroundColor(final int n) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }
    
    public void setBackgroundDrawable(final Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }
    
    public void setBackgroundResource(final int n) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }
    
    public void setBackgroundTintList(@Nullable final ColorStateList list) {
        if (mBackgroundTint != list) {
            mBackgroundTint = list;
            this.getImpl().setBackgroundTintList(list);
        }
    }
    
    public void setBackgroundTintMode(@Nullable final PorterDuff$Mode porterDuff$Mode) {
        if (mBackgroundTintMode != porterDuff$Mode) {
            mBackgroundTintMode = porterDuff$Mode;
            this.getImpl().setBackgroundTintMode(porterDuff$Mode);
        }
    }
    
    public void setCompatElevation(final float elevation) {
        this.getImpl().setElevation(elevation);
    }
    
    public void setImageResource(@DrawableRes final int imageResource) {
        mImageHelper.setImageResource(imageResource);
    }
    
    public void setRippleColor(@ColorInt final int n) {
        if (mRippleColor != n) {
            mRippleColor = n;
            this.getImpl().setRippleColor(n);
        }
    }
    
    public void setUseCompatPadding(final boolean mCompatPadding) {
        if (this.mCompatPadding != mCompatPadding) {
            this.mCompatPadding = mCompatPadding;
            this.getImpl().onCompatShadowChanged();
        }
    }
    
    @Override
    public /* bridge */ void setVisibility(final int visibility) {
        super.setVisibility(visibility);
    }
    
    public void show() {
        this.show(null);
    }
    
    public void show(@Nullable final OnVisibilityChangedListener onVisibilityChangedListener) {
        this.show(onVisibilityChangedListener, true);
    }
}
