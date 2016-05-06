package android.support.design.widget;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.accessibility.AccessibilityEvent;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;
import android.support.annotation.StyleRes;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.content.ContextCompat;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.support.v7.widget.AppCompatDrawableManager;
import android.graphics.PorterDuff$Mode;
import android.text.TextUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.support.v4.widget.Space;
import android.content.res.TypedArray;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.design.R;
import android.view.animation.Interpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Paint;
import android.widget.EditText;
import android.content.res.ColorStateList;
import android.widget.TextView;
import android.widget.LinearLayout;

public class TextInputLayout extends LinearLayout
{
    private static final int ANIMATION_DURATION = 200;
    private static final int INVALID_MAX_LENGTH = -1;
    private static final String LOG_TAG = "TextInputLayout";
    private ValueAnimatorCompat mAnimator;
    private final CollapsingTextHelper mCollapsingTextHelper;
    private boolean mCounterEnabled;
    private int mCounterMaxLength;
    private int mCounterOverflowTextAppearance;
    private boolean mCounterOverflowed;
    private int mCounterTextAppearance;
    private TextView mCounterView;
    private ColorStateList mDefaultTextColor;
    private EditText mEditText;
    private CharSequence mError;
    private boolean mErrorEnabled;
    private boolean mErrorShown;
    private int mErrorTextAppearance;
    private TextView mErrorView;
    private ColorStateList mFocusedTextColor;
    private boolean mHasReconstructedEditTextBackground;
    private CharSequence mHint;
    private boolean mHintAnimationEnabled;
    private boolean mHintEnabled;
    private LinearLayout mIndicatorArea;
    private int mIndicatorsAdded;
    private Paint mTmpPaint;
    
    public TextInputLayout(final Context context) {
        this(context, null);
    }
    
    public TextInputLayout(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public TextInputLayout(final Context context, final AttributeSet set, final int n) {
        super(context, set);
        mCollapsingTextHelper = new CollapsingTextHelper((View)this);
        ThemeUtils.checkAppCompatTheme(context);
        this.setOrientation(1);
        this.setWillNotDraw(false);
        this.setAddStatesFromChildren(true);
        mCollapsingTextHelper.setTextSizeInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        mCollapsingTextHelper.setPositionInterpolator((Interpolator)new AccelerateInterpolator());
        mCollapsingTextHelper.setCollapsedTextGravity(8388659);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.TextInputLayout, n, R.style.Widget_Design_TextInputLayout);
        mHintEnabled = obtainStyledAttributes.getBoolean(R.styleable.TextInputLayout_hintEnabled, true);
        this.setHint(obtainStyledAttributes.getText(R.styleable.TextInputLayout_android_hint));
        mHintAnimationEnabled = obtainStyledAttributes.getBoolean(R.styleable.TextInputLayout_hintAnimationEnabled, true);
        if (obtainStyledAttributes.hasValue(R.styleable.TextInputLayout_android_textColorHint)) {
            final ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.TextInputLayout_android_textColorHint);
            mFocusedTextColor = colorStateList;
            mDefaultTextColor = colorStateList;
        }
        if (obtainStyledAttributes.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, -1) != -1) {
            this.setHintTextAppearance(obtainStyledAttributes.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, 0));
        }
        mErrorTextAppearance = obtainStyledAttributes.getResourceId(R.styleable.TextInputLayout_errorTextAppearance, 0);
        final boolean boolean1 = obtainStyledAttributes.getBoolean(R.styleable.TextInputLayout_errorEnabled, false);
        final boolean boolean2 = obtainStyledAttributes.getBoolean(R.styleable.TextInputLayout_counterEnabled, false);
        this.setCounterMaxLength(obtainStyledAttributes.getInt(R.styleable.TextInputLayout_counterMaxLength, -1));
        mCounterTextAppearance = obtainStyledAttributes.getResourceId(R.styleable.TextInputLayout_counterTextAppearance, 0);
        mCounterOverflowTextAppearance = obtainStyledAttributes.getResourceId(R.styleable.TextInputLayout_counterOverflowTextAppearance, 0);
        obtainStyledAttributes.recycle();
        this.setErrorEnabled(boolean1);
        this.setCounterEnabled(boolean2);
        if (ViewCompat.getImportantForAccessibility((View)this) == 0) {
            ViewCompat.setImportantForAccessibility((View)this, 1);
        }
        ViewCompat.setAccessibilityDelegate(this, (AccessibilityDelegateCompat)new TextInputAccessibilityDelegate(this));
    }
    
    static /* synthetic */ void access$100(final TextInputLayout textInputLayout, final boolean b) {
        textInputLayout.updateLabelState(b);
    }
    
    static /* synthetic */ boolean access$200(final TextInputLayout textInputLayout) {
        return textInputLayout.mCounterEnabled;
    }
    
    static /* synthetic */ void access$300(final TextInputLayout textInputLayout, final int n) {
        textInputLayout.updateCounter(n);
    }
    
    static /* synthetic */ TextView access$400(final TextInputLayout textInputLayout) {
        return textInputLayout.mErrorView;
    }
    
    static /* synthetic */ CollapsingTextHelper access$500(final TextInputLayout textInputLayout) {
        return textInputLayout.mCollapsingTextHelper;
    }
    
    static /* synthetic */ EditText access$600(final TextInputLayout textInputLayout) {
        return textInputLayout.mEditText;
    }
    
    private void addIndicator(final TextView textView, final int n) {
        if (mIndicatorArea == null) {
            (mIndicatorArea = new LinearLayout(this.getContext())).setOrientation(0);
            this.addView((View)mIndicatorArea, -1, -2);
            mIndicatorArea.addView((View)new Space(this.getContext()), (ViewGroup$LayoutParams)new LinearLayout$LayoutParams(0, 0, 1.0f));
            if (mEditText != null) {
                this.adjustIndicatorPadding();
            }
        }
        mIndicatorArea.setVisibility(0);
        mIndicatorArea.addView((View)textView, n);
        ++mIndicatorsAdded;
    }
    
    private void adjustIndicatorPadding() {
        ViewCompat.setPaddingRelative((View)mIndicatorArea, ViewCompat.getPaddingStart((View)mEditText), 0, ViewCompat.getPaddingEnd((View)mEditText), mEditText.getPaddingBottom());
    }
    
    private void animateToExpansionFraction(final float n) {
        if (mCollapsingTextHelper.getExpansionFraction() == n) {
            return;
        }
        if (mAnimator == null) {
            (mAnimator = ViewUtils.createAnimator()).setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
            mAnimator.setDuration(200);
            mAnimator.setUpdateListener((ValueAnimatorCompat.AnimatorUpdateListener)new ValueAnimatorCompat.AnimatorUpdateListener() {
                final /* synthetic */ TextInputLayout this$0;
                
                TextInputLayout$4() {
                    this$0 = this$0;
                    super();
                }
                
                @Override
                public void onAnimationUpdate(final ValueAnimatorCompat valueAnimatorCompat) {
                    mCollapsingTextHelper.setExpansionFraction(valueAnimatorCompat.getAnimatedFloatValue());
                }
            });
        }
        mAnimator.setFloatValues(mCollapsingTextHelper.getExpansionFraction(), n);
        mAnimator.start();
    }
    
    private static boolean arrayContains(final int[] array, final int n) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (array[i] == n) {
                return true;
            }
        }
        return false;
    }
    
    private void collapseHint(final boolean b) {
        if (mAnimator != null && mAnimator.isRunning()) {
            mAnimator.cancel();
        }
        if (b && mHintAnimationEnabled) {
            this.animateToExpansionFraction(1.0f);
            return;
        }
        mCollapsingTextHelper.setExpansionFraction(1.0f);
    }
    
    private void ensureBackgroundDrawableStateWorkaround() {
        final Drawable background = mEditText.getBackground();
        if (background != null && !mHasReconstructedEditTextBackground) {
            final Drawable drawable = background.getConstantState().newDrawable();
            if (background instanceof DrawableContainer) {
                mHasReconstructedEditTextBackground = DrawableUtils.setContainerConstantState((DrawableContainer)background, drawable.getConstantState());
            }
            if (!mHasReconstructedEditTextBackground) {
                mEditText.setBackgroundDrawable(drawable);
                mHasReconstructedEditTextBackground = true;
            }
        }
    }
    
    private void expandHint(final boolean b) {
        if (mAnimator != null && mAnimator.isRunning()) {
            mAnimator.cancel();
        }
        if (b && mHintAnimationEnabled) {
            this.animateToExpansionFraction(0.0f);
            return;
        }
        mCollapsingTextHelper.setExpansionFraction(0.0f);
    }
    
    private void removeIndicator(final TextView textView) {
        if (mIndicatorArea != null) {
            mIndicatorArea.removeView((View)textView);
            if (--mIndicatorsAdded == 0) {
                mIndicatorArea.setVisibility(8);
            }
        }
    }
    
    private void setEditText(final EditText mEditText) {
        if (this.mEditText != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (!(mEditText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.mEditText = mEditText;
        mCollapsingTextHelper.setTypefaces(this.mEditText.getTypeface());
        mCollapsingTextHelper.setExpandedTextSize(this.mEditText.getTextSize());
        mCollapsingTextHelper.setExpandedTextGravity(this.mEditText.getGravity());
        this.mEditText.addTextChangedListener((TextWatcher)new TextWatcher() {
            final /* synthetic */ TextInputLayout this$0;
            
            TextInputLayout$1() {
                this$0 = this$0;
                super();
            }
            
            public void afterTextChanged(final Editable editable) {
                this$0.updateLabelState(true);
                if (mCounterEnabled) {
                    this$0.updateCounter(editable.length());
                }
            }
            
            public void beforeTextChanged(final CharSequence charSequence, final int n, final int n2, final int n3) {
            }
            
            public void onTextChanged(final CharSequence charSequence, final int n, final int n2, final int n3) {
            }
        });
        if (mDefaultTextColor == null) {
            mDefaultTextColor = this.mEditText.getHintTextColors();
        }
        if (mHintEnabled && TextUtils.isEmpty(mHint)) {
            this.setHint(this.mEditText.getHint());
            this.mEditText.setHint((CharSequence)null);
        }
        if (mCounterView != null) {
            this.updateCounter(this.mEditText.getText().length());
        }
        if (mIndicatorArea != null) {
            this.adjustIndicatorPadding();
        }
        this.updateLabelState(false);
    }
    
    private void setHintInternal(final CharSequence charSequence) {
        mHint = charSequence;
        mCollapsingTextHelper.setText(charSequence);
    }
    
    private void updateCounter(final int n) {
        final boolean mCounterOverflowed = this.mCounterOverflowed;
        if (mCounterMaxLength == -1) {
            mCounterView.setText((CharSequence)String.valueOf(n));
            this.mCounterOverflowed = false;
        }
        else {
            this.mCounterOverflowed = (n > mCounterMaxLength);
            if (mCounterOverflowed != this.mCounterOverflowed) {
                final TextView mCounterView = this.mCounterView;
                final Context context = this.getContext();
                int n2;
                if (this.mCounterOverflowed) {
                    n2 = mCounterOverflowTextAppearance;
                }
                else {
                    n2 = mCounterTextAppearance;
                }
                mCounterView.setTextAppearance(context, n2);
            }
            mCounterView.setText((CharSequence)this.getContext().getString(R.string.character_counter_pattern, new Object[] { n, mCounterMaxLength }));
        }
        if (mEditText != null && mCounterOverflowed != this.mCounterOverflowed) {
            this.updateLabelState(false);
            this.updateEditTextBackground();
        }
    }
    
    private void updateEditTextBackground() {
        this.ensureBackgroundDrawableStateWorkaround();
        final Drawable background = mEditText.getBackground();
        if (background == null) {
            return;
        }
        if (mErrorShown && mErrorView != null) {
            background.setColorFilter((ColorFilter)AppCompatDrawableManager.getPorterDuffColorFilter(mErrorView.getCurrentTextColor(), PorterDuff$Mode.SRC_IN));
            return;
        }
        if (mCounterOverflowed && mCounterView != null) {
            background.setColorFilter((ColorFilter)AppCompatDrawableManager.getPorterDuffColorFilter(mCounterView.getCurrentTextColor(), PorterDuff$Mode.SRC_IN));
            return;
        }
        background.clearColorFilter();
        mEditText.refreshDrawableState();
    }
    
    private LinearLayout$LayoutParams updateEditTextMargin(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        LinearLayout$LayoutParams linearLayout$LayoutParams;
        if (viewGroup$LayoutParams instanceof LinearLayout$LayoutParams) {
            linearLayout$LayoutParams = (LinearLayout$LayoutParams)viewGroup$LayoutParams;
        }
        else {
            linearLayout$LayoutParams = new LinearLayout$LayoutParams(viewGroup$LayoutParams);
        }
        if (mHintEnabled) {
            if (mTmpPaint == null) {
                mTmpPaint = new Paint();
            }
            mTmpPaint.setTypeface(mCollapsingTextHelper.getCollapsedTypeface());
            mTmpPaint.setTextSize(mCollapsingTextHelper.getCollapsedTextSize());
            linearLayout$LayoutParams.topMargin = (int)(-mTmpPaint.ascent());
            return linearLayout$LayoutParams;
        }
        linearLayout$LayoutParams.topMargin = 0;
        return linearLayout$LayoutParams;
    }
    
    private void updateLabelState(final boolean b) {
        boolean b2;
        if (mEditText != null && !TextUtils.isEmpty((CharSequence)mEditText.getText())) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        final boolean arrayContains = arrayContains(this.getDrawableState(), 16842908);
        boolean b3;
        if (!TextUtils.isEmpty(this.getError())) {
            b3 = true;
        }
        else {
            b3 = false;
        }
        if (mDefaultTextColor != null) {
            mCollapsingTextHelper.setExpandedTextColor(mDefaultTextColor.getDefaultColor());
        }
        if (mCounterOverflowed && mCounterView != null) {
            mCollapsingTextHelper.setCollapsedTextColor(mCounterView.getCurrentTextColor());
        }
        else if (arrayContains && mFocusedTextColor != null) {
            mCollapsingTextHelper.setCollapsedTextColor(mFocusedTextColor.getDefaultColor());
        }
        else if (mDefaultTextColor != null) {
            mCollapsingTextHelper.setCollapsedTextColor(mDefaultTextColor.getDefaultColor());
        }
        if (b2 || arrayContains || b3) {
            this.collapseHint(b);
            return;
        }
        this.expandHint(b);
    }
    
    public void addView(final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (view instanceof EditText) {
            this.setEditText((EditText)view);
            super.addView(view, 0, (ViewGroup$LayoutParams)this.updateEditTextMargin(viewGroup$LayoutParams));
            return;
        }
        super.addView(view, n, viewGroup$LayoutParams);
    }
    
    public void draw(final Canvas canvas) {
        super.draw(canvas);
        if (mHintEnabled) {
            mCollapsingTextHelper.draw(canvas);
        }
    }
    
    public int getCounterMaxLength() {
        return mCounterMaxLength;
    }
    
    @Nullable
    public EditText getEditText() {
        return mEditText;
    }
    
    @Nullable
    public CharSequence getError() {
        if (mErrorEnabled) {
            return mError;
        }
        return null;
    }
    
    @Nullable
    public CharSequence getHint() {
        if (mHintEnabled) {
            return mHint;
        }
        return null;
    }
    
    @NonNull
    public Typeface getTypeface() {
        return mCollapsingTextHelper.getCollapsedTypeface();
    }
    
    public boolean isCounterEnabled() {
        return mCounterEnabled;
    }
    
    public boolean isErrorEnabled() {
        return mErrorEnabled;
    }
    
    public boolean isHintAnimationEnabled() {
        return mHintAnimationEnabled;
    }
    
    public boolean isHintEnabled() {
        return mHintEnabled;
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        super.onLayout(b, n, n2, n3, n4);
        if (mHintEnabled && mEditText != null) {
            final int n5 = mEditText.getLeft() + mEditText.getCompoundPaddingLeft();
            final int n6 = mEditText.getRight() - mEditText.getCompoundPaddingRight();
            mCollapsingTextHelper.setExpandedBounds(n5, mEditText.getTop() + mEditText.getCompoundPaddingTop(), n6, mEditText.getBottom() - mEditText.getCompoundPaddingBottom());
            mCollapsingTextHelper.setCollapsedBounds(n5, this.getPaddingTop(), n6, n4 - n2 - this.getPaddingBottom());
            mCollapsingTextHelper.recalculate();
        }
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        final SavedState savedState = (SavedState)parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.setError(savedState.error);
        this.requestLayout();
    }
    
    public Parcelable onSaveInstanceState() {
        final SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (mErrorShown) {
            savedState.error = this.getError();
        }
        return (Parcelable)savedState;
    }
    
    public void refreshDrawableState() {
        super.refreshDrawableState();
        this.updateLabelState(ViewCompat.isLaidOut((View)this));
    }
    
    public void setCounterEnabled(final boolean mCounterEnabled) {
        if (this.mCounterEnabled == mCounterEnabled) {
            return;
        }
    Label_0071:
        while (true) {
            if (!mCounterEnabled) {
                this.removeIndicator(mCounterView);
                mCounterView = null;
                break Label_0071;
            }
            while (true) {
                (mCounterView = new TextView(this.getContext())).setMaxLines(1);
                while (true) {
                    try {
                        mCounterView.setTextAppearance(this.getContext(), mCounterTextAppearance);
                        this.addIndicator(mCounterView, -1);
                        if (mEditText == null) {
                            this.updateCounter(0);
                            this.mCounterEnabled = mCounterEnabled;
                            return;
                        }
                    }
                    catch (Exception ex) {
                        mCounterView.setTextAppearance(this.getContext(), R.style.TextAppearance_AppCompat_Caption);
                        mCounterView.setTextColor(ContextCompat.getColor(this.getContext(), R.color.design_textinput_error_color_light));
                        continue;
                    }
                    break;
                }
                this.updateCounter(mEditText.getText().length());
                continue Label_0071;
            }
            break;
        }
    }
    
    public void setCounterMaxLength(final int mCounterMaxLength) {
        if (this.mCounterMaxLength != mCounterMaxLength) {
            if (mCounterMaxLength > 0) {
                this.mCounterMaxLength = mCounterMaxLength;
            }
            else {
                this.mCounterMaxLength = -1;
            }
            if (mCounterEnabled) {
                int length;
                if (mEditText == null) {
                    length = 0;
                }
                else {
                    length = mEditText.getText().length();
                }
                this.updateCounter(length);
            }
        }
    }
    
    public void setError(@Nullable final CharSequence charSequence) {
        if (!TextUtils.equals(mError, charSequence)) {
            mError = charSequence;
            if (!mErrorEnabled) {
                if (TextUtils.isEmpty(charSequence)) {
                    return;
                }
                this.setErrorEnabled(true);
            }
            final boolean laidOut = ViewCompat.isLaidOut((View)this);
            mErrorShown = !TextUtils.isEmpty(charSequence);
            if (mErrorShown) {
                mErrorView.setText(charSequence);
                mErrorView.setVisibility(0);
                if (laidOut) {
                    if (ViewCompat.getAlpha((View)mErrorView) == 1.0f) {
                        ViewCompat.setAlpha((View)mErrorView, 0.0f);
                    }
                    ViewCompat.animate((View)mErrorView).alpha(1.0f).setDuration(200L).setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR).setListener(new ViewPropertyAnimatorListenerAdapter() {
                        final /* synthetic */ TextInputLayout this$0;
                        
                        TextInputLayout$2() {
                            this$0 = this$0;
                            super();
                        }
                        
                        @Override
                        public void onAnimationStart(final View view) {
                            view.setVisibility(0);
                        }
                    }).start();
                }
            }
            else if (mErrorView.getVisibility() == 0) {
                if (laidOut) {
                    ViewCompat.animate((View)mErrorView).alpha(0.0f).setDuration(200L).setInterpolator(AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR).setListener(new ViewPropertyAnimatorListenerAdapter() {
                        final /* synthetic */ TextInputLayout this$0;
                        final /* synthetic */ CharSequence val$error;
                        
                        TextInputLayout$3() {
                            this$0 = this$0;
                            super();
                        }
                        
                        @Override
                        public void onAnimationEnd(final View view) {
                            mErrorView.setText(charSequence);
                            view.setVisibility(4);
                        }
                    }).start();
                }
                else {
                    mErrorView.setVisibility(4);
                }
            }
            this.updateEditTextBackground();
            this.updateLabelState(true);
        }
    }
    
    public void setErrorEnabled(final boolean mErrorEnabled) {
        if (this.mErrorEnabled == mErrorEnabled) {
            return;
        }
        if (mErrorView != null) {
            ViewCompat.animate((View)mErrorView).cancel();
        }
        while (true) {
            Label_0125: {
                if (!mErrorEnabled) {
                    break Label_0125;
                }
                mErrorView = new TextView(this.getContext());
                while (true) {
                    try {
                        mErrorView.setTextAppearance(this.getContext(), mErrorTextAppearance);
                        mErrorView.setVisibility(4);
                        ViewCompat.setAccessibilityLiveRegion((View)mErrorView, 1);
                        this.addIndicator(mErrorView, 0);
                        this.mErrorEnabled = mErrorEnabled;
                        return;
                    }
                    catch (Exception ex) {
                        mErrorView.setTextAppearance(this.getContext(), R.style.TextAppearance_AppCompat_Caption);
                        mErrorView.setTextColor(ContextCompat.getColor(this.getContext(), R.color.design_textinput_error_color_light));
                        continue;
                    }
                    break;
                }
            }
            mErrorShown = false;
            this.updateEditTextBackground();
            this.removeIndicator(mErrorView);
            mErrorView = null;
            continue;
        }
    }
    
    public void setHint(@Nullable final CharSequence hintInternal) {
        if (mHintEnabled) {
            this.setHintInternal(hintInternal);
            this.sendAccessibilityEvent(2048);
        }
    }
    
    public void setHintAnimationEnabled(final boolean mHintAnimationEnabled) {
        this.mHintAnimationEnabled = mHintAnimationEnabled;
    }
    
    public void setHintEnabled(final boolean mHintEnabled) {
        if (mHintEnabled != this.mHintEnabled) {
            this.mHintEnabled = mHintEnabled;
            final CharSequence hint = mEditText.getHint();
            if (!this.mHintEnabled) {
                if (!TextUtils.isEmpty(mHint) && TextUtils.isEmpty(hint)) {
                    mEditText.setHint(mHint);
                }
                this.setHintInternal(null);
            }
            else if (!TextUtils.isEmpty(hint)) {
                if (TextUtils.isEmpty(mHint)) {
                    this.setHint(hint);
                }
                mEditText.setHint((CharSequence)null);
            }
            if (mEditText != null) {
                mEditText.setLayoutParams((ViewGroup$LayoutParams)this.updateEditTextMargin(mEditText.getLayoutParams()));
            }
        }
    }
    
    public void setHintTextAppearance(@StyleRes final int collapsedTextAppearance) {
        mCollapsingTextHelper.setCollapsedTextAppearance(collapsedTextAppearance);
        mFocusedTextColor = ColorStateList.valueOf(mCollapsingTextHelper.getCollapsedTextColor());
        if (mEditText != null) {
            this.updateLabelState(false);
            mEditText.setLayoutParams((ViewGroup$LayoutParams)this.updateEditTextMargin(mEditText.getLayoutParams()));
            mEditText.requestLayout();
        }
    }
    
    public void setTypeface(@Nullable final Typeface typefaces) {
        mCollapsingTextHelper.setTypefaces(typefaces);
    }
}
