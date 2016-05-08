package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.design.R$color;
import android.support.design.R$string;
import android.support.design.R$style;
import android.support.design.R$styleable;
import android.support.design.widget.AnimationUtils;
import android.support.design.widget.CollapsingTextHelper;
import android.support.design.widget.DrawableUtils;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout$1;
import android.support.design.widget.TextInputLayout$2;
import android.support.design.widget.TextInputLayout$3;
import android.support.design.widget.TextInputLayout$4;
import android.support.design.widget.TextInputLayout$SavedState;
import android.support.design.widget.TextInputLayout$TextInputAccessibilityDelegate;
import android.support.design.widget.ThemeUtils;
import android.support.design.widget.ValueAnimatorCompat;
import android.support.design.widget.ViewUtils;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.Space;
import android.support.v7.widget.AppCompatDrawableManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class TextInputLayout extends LinearLayout {
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

   public TextInputLayout(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public TextInputLayout(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public TextInputLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2);
      this.mCollapsingTextHelper = new CollapsingTextHelper(this);
      ThemeUtils.checkAppCompatTheme(var1);
      this.setOrientation(1);
      this.setWillNotDraw(false);
      this.setAddStatesFromChildren(true);
      this.mCollapsingTextHelper.setTextSizeInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
      this.mCollapsingTextHelper.setPositionInterpolator(new AccelerateInterpolator());
      this.mCollapsingTextHelper.setCollapsedTextGravity(8388659);
      TypedArray var6 = var1.obtainStyledAttributes(var2, R$styleable.TextInputLayout, var3, R$style.Widget_Design_TextInputLayout);
      this.mHintEnabled = var6.getBoolean(R$styleable.TextInputLayout_hintEnabled, true);
      this.setHint(var6.getText(R$styleable.TextInputLayout_android_hint));
      this.mHintAnimationEnabled = var6.getBoolean(R$styleable.TextInputLayout_hintAnimationEnabled, true);
      if(var6.hasValue(R$styleable.TextInputLayout_android_textColorHint)) {
         ColorStateList var7 = var6.getColorStateList(R$styleable.TextInputLayout_android_textColorHint);
         this.mFocusedTextColor = var7;
         this.mDefaultTextColor = var7;
      }

      if(var6.getResourceId(R$styleable.TextInputLayout_hintTextAppearance, -1) != -1) {
         this.setHintTextAppearance(var6.getResourceId(R$styleable.TextInputLayout_hintTextAppearance, 0));
      }

      this.mErrorTextAppearance = var6.getResourceId(R$styleable.TextInputLayout_errorTextAppearance, 0);
      boolean var4 = var6.getBoolean(R$styleable.TextInputLayout_errorEnabled, false);
      boolean var5 = var6.getBoolean(R$styleable.TextInputLayout_counterEnabled, false);
      this.setCounterMaxLength(var6.getInt(R$styleable.TextInputLayout_counterMaxLength, -1));
      this.mCounterTextAppearance = var6.getResourceId(R$styleable.TextInputLayout_counterTextAppearance, 0);
      this.mCounterOverflowTextAppearance = var6.getResourceId(R$styleable.TextInputLayout_counterOverflowTextAppearance, 0);
      var6.recycle();
      this.setErrorEnabled(var4);
      this.setCounterEnabled(var5);
      if(ViewCompat.getImportantForAccessibility(this) == 0) {
         ViewCompat.setImportantForAccessibility(this, 1);
      }

      ViewCompat.setAccessibilityDelegate(this, new TextInputLayout$TextInputAccessibilityDelegate(this, (TextInputLayout$1)null));
   }

   private void addIndicator(TextView var1, int var2) {
      if(this.mIndicatorArea == null) {
         this.mIndicatorArea = new LinearLayout(this.getContext());
         this.mIndicatorArea.setOrientation(0);
         this.addView(this.mIndicatorArea, -1, -2);
         Space var3 = new Space(this.getContext());
         LayoutParams var4 = new LayoutParams(0, 0, 1.0F);
         this.mIndicatorArea.addView(var3, var4);
         if(this.mEditText != null) {
            this.adjustIndicatorPadding();
         }
      }

      this.mIndicatorArea.setVisibility(0);
      this.mIndicatorArea.addView(var1, var2);
      ++this.mIndicatorsAdded;
   }

   private void adjustIndicatorPadding() {
      ViewCompat.setPaddingRelative(this.mIndicatorArea, ViewCompat.getPaddingStart(this.mEditText), 0, ViewCompat.getPaddingEnd(this.mEditText), this.mEditText.getPaddingBottom());
   }

   private void animateToExpansionFraction(float var1) {
      if(this.mCollapsingTextHelper.getExpansionFraction() != var1) {
         if(this.mAnimator == null) {
            this.mAnimator = ViewUtils.createAnimator();
            this.mAnimator.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
            this.mAnimator.setDuration(200);
            this.mAnimator.setUpdateListener(new TextInputLayout$4(this));
         }

         this.mAnimator.setFloatValues(this.mCollapsingTextHelper.getExpansionFraction(), var1);
         this.mAnimator.start();
      }
   }

   private static boolean arrayContains(int[] var0, int var1) {
      int var3 = var0.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         if(var0[var2] == var1) {
            return true;
         }
      }

      return false;
   }

   private void collapseHint(boolean var1) {
      if(this.mAnimator != null && this.mAnimator.isRunning()) {
         this.mAnimator.cancel();
      }

      if(var1 && this.mHintAnimationEnabled) {
         this.animateToExpansionFraction(1.0F);
      } else {
         this.mCollapsingTextHelper.setExpansionFraction(1.0F);
      }
   }

   private void ensureBackgroundDrawableStateWorkaround() {
      Drawable var1 = this.mEditText.getBackground();
      if(var1 != null && !this.mHasReconstructedEditTextBackground) {
         Drawable var2 = var1.getConstantState().newDrawable();
         if(var1 instanceof DrawableContainer) {
            this.mHasReconstructedEditTextBackground = DrawableUtils.setContainerConstantState((DrawableContainer)var1, var2.getConstantState());
         }

         if(!this.mHasReconstructedEditTextBackground) {
            this.mEditText.setBackgroundDrawable(var2);
            this.mHasReconstructedEditTextBackground = true;
            return;
         }
      }

   }

   private void expandHint(boolean var1) {
      if(this.mAnimator != null && this.mAnimator.isRunning()) {
         this.mAnimator.cancel();
      }

      if(var1 && this.mHintAnimationEnabled) {
         this.animateToExpansionFraction(0.0F);
      } else {
         this.mCollapsingTextHelper.setExpansionFraction(0.0F);
      }
   }

   private void removeIndicator(TextView var1) {
      if(this.mIndicatorArea != null) {
         this.mIndicatorArea.removeView(var1);
         int var2 = this.mIndicatorsAdded - 1;
         this.mIndicatorsAdded = var2;
         if(var2 == 0) {
            this.mIndicatorArea.setVisibility(8);
         }
      }

   }

   private void setEditText(EditText var1) {
      if(this.mEditText != null) {
         throw new IllegalArgumentException("We already have an EditText, can only have one");
      } else {
         if(!(var1 instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
         }

         this.mEditText = var1;
         this.mCollapsingTextHelper.setTypefaces(this.mEditText.getTypeface());
         this.mCollapsingTextHelper.setExpandedTextSize(this.mEditText.getTextSize());
         this.mCollapsingTextHelper.setExpandedTextGravity(this.mEditText.getGravity());
         this.mEditText.addTextChangedListener(new TextInputLayout$1(this));
         if(this.mDefaultTextColor == null) {
            this.mDefaultTextColor = this.mEditText.getHintTextColors();
         }

         if(this.mHintEnabled && TextUtils.isEmpty(this.mHint)) {
            this.setHint(this.mEditText.getHint());
            this.mEditText.setHint((CharSequence)null);
         }

         if(this.mCounterView != null) {
            this.updateCounter(this.mEditText.getText().length());
         }

         if(this.mIndicatorArea != null) {
            this.adjustIndicatorPadding();
         }

         this.updateLabelState(false);
      }
   }

   private void setHintInternal(CharSequence var1) {
      this.mHint = var1;
      this.mCollapsingTextHelper.setText(var1);
   }

   private void updateCounter(int var1) {
      boolean var4 = this.mCounterOverflowed;
      if(this.mCounterMaxLength == -1) {
         this.mCounterView.setText(String.valueOf(var1));
         this.mCounterOverflowed = false;
      } else {
         boolean var3;
         if(var1 > this.mCounterMaxLength) {
            var3 = true;
         } else {
            var3 = false;
         }

         this.mCounterOverflowed = var3;
         if(var4 != this.mCounterOverflowed) {
            TextView var5 = this.mCounterView;
            Context var6 = this.getContext();
            int var2;
            if(this.mCounterOverflowed) {
               var2 = this.mCounterOverflowTextAppearance;
            } else {
               var2 = this.mCounterTextAppearance;
            }

            var5.setTextAppearance(var6, var2);
         }

         this.mCounterView.setText(this.getContext().getString(R$string.character_counter_pattern, new Object[]{Integer.valueOf(var1), Integer.valueOf(this.mCounterMaxLength)}));
      }

      if(this.mEditText != null && var4 != this.mCounterOverflowed) {
         this.updateLabelState(false);
         this.updateEditTextBackground();
      }

   }

   private void updateEditTextBackground() {
      this.ensureBackgroundDrawableStateWorkaround();
      Drawable var1 = this.mEditText.getBackground();
      if(var1 != null) {
         if(this.mErrorShown && this.mErrorView != null) {
            var1.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.mErrorView.getCurrentTextColor(), Mode.SRC_IN));
         } else if(this.mCounterOverflowed && this.mCounterView != null) {
            var1.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.mCounterView.getCurrentTextColor(), Mode.SRC_IN));
         } else {
            var1.clearColorFilter();
            this.mEditText.refreshDrawableState();
         }
      }
   }

   private LayoutParams updateEditTextMargin(android.view.ViewGroup.LayoutParams var1) {
      LayoutParams var2;
      if(var1 instanceof LayoutParams) {
         var2 = (LayoutParams)var1;
      } else {
         var2 = new LayoutParams(var1);
      }

      if(this.mHintEnabled) {
         if(this.mTmpPaint == null) {
            this.mTmpPaint = new Paint();
         }

         this.mTmpPaint.setTypeface(this.mCollapsingTextHelper.getCollapsedTypeface());
         this.mTmpPaint.setTextSize(this.mCollapsingTextHelper.getCollapsedTextSize());
         var2.topMargin = (int)(-this.mTmpPaint.ascent());
         return var2;
      } else {
         var2.topMargin = 0;
         return var2;
      }
   }

   private void updateLabelState(boolean var1) {
      boolean var2;
      if(this.mEditText != null && !TextUtils.isEmpty(this.mEditText.getText())) {
         var2 = true;
      } else {
         var2 = false;
      }

      boolean var4 = arrayContains(this.getDrawableState(), 16842908);
      boolean var3;
      if(!TextUtils.isEmpty(this.getError())) {
         var3 = true;
      } else {
         var3 = false;
      }

      if(this.mDefaultTextColor != null) {
         this.mCollapsingTextHelper.setExpandedTextColor(this.mDefaultTextColor.getDefaultColor());
      }

      if(this.mCounterOverflowed && this.mCounterView != null) {
         this.mCollapsingTextHelper.setCollapsedTextColor(this.mCounterView.getCurrentTextColor());
      } else if(var4 && this.mFocusedTextColor != null) {
         this.mCollapsingTextHelper.setCollapsedTextColor(this.mFocusedTextColor.getDefaultColor());
      } else if(this.mDefaultTextColor != null) {
         this.mCollapsingTextHelper.setCollapsedTextColor(this.mDefaultTextColor.getDefaultColor());
      }

      if(!var2 && !var4 && !var3) {
         this.expandHint(var1);
      } else {
         this.collapseHint(var1);
      }
   }

   public void addView(View var1, int var2, android.view.ViewGroup.LayoutParams var3) {
      if(var1 instanceof EditText) {
         this.setEditText((EditText)var1);
         super.addView(var1, 0, this.updateEditTextMargin(var3));
      } else {
         super.addView(var1, var2, var3);
      }
   }

   public void draw(Canvas var1) {
      super.draw(var1);
      if(this.mHintEnabled) {
         this.mCollapsingTextHelper.draw(var1);
      }

   }

   public int getCounterMaxLength() {
      return this.mCounterMaxLength;
   }

   @Nullable
   public EditText getEditText() {
      return this.mEditText;
   }

   @Nullable
   public CharSequence getError() {
      return this.mErrorEnabled?this.mError:null;
   }

   @Nullable
   public CharSequence getHint() {
      return this.mHintEnabled?this.mHint:null;
   }

   @NonNull
   public Typeface getTypeface() {
      return this.mCollapsingTextHelper.getCollapsedTypeface();
   }

   public boolean isCounterEnabled() {
      return this.mCounterEnabled;
   }

   public boolean isErrorEnabled() {
      return this.mErrorEnabled;
   }

   public boolean isHintAnimationEnabled() {
      return this.mHintAnimationEnabled;
   }

   public boolean isHintEnabled() {
      return this.mHintEnabled;
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      if(this.mHintEnabled && this.mEditText != null) {
         var2 = this.mEditText.getLeft() + this.mEditText.getCompoundPaddingLeft();
         var4 = this.mEditText.getRight() - this.mEditText.getCompoundPaddingRight();
         this.mCollapsingTextHelper.setExpandedBounds(var2, this.mEditText.getTop() + this.mEditText.getCompoundPaddingTop(), var4, this.mEditText.getBottom() - this.mEditText.getCompoundPaddingBottom());
         this.mCollapsingTextHelper.setCollapsedBounds(var2, this.getPaddingTop(), var4, var5 - var3 - this.getPaddingBottom());
         this.mCollapsingTextHelper.recalculate();
      }

   }

   protected void onRestoreInstanceState(Parcelable var1) {
      TextInputLayout$SavedState var2 = (TextInputLayout$SavedState)var1;
      super.onRestoreInstanceState(var2.getSuperState());
      this.setError(var2.error);
      this.requestLayout();
   }

   public Parcelable onSaveInstanceState() {
      TextInputLayout$SavedState var1 = new TextInputLayout$SavedState(super.onSaveInstanceState());
      if(this.mErrorShown) {
         var1.error = this.getError();
      }

      return var1;
   }

   public void refreshDrawableState() {
      super.refreshDrawableState();
      this.updateLabelState(ViewCompat.isLaidOut(this));
   }

   public void setCounterEnabled(boolean var1) {
      if(this.mCounterEnabled != var1) {
         if(var1) {
            this.mCounterView = new TextView(this.getContext());
            this.mCounterView.setMaxLines(1);

            try {
               this.mCounterView.setTextAppearance(this.getContext(), this.mCounterTextAppearance);
            } catch (Exception var3) {
               this.mCounterView.setTextAppearance(this.getContext(), R$style.TextAppearance_AppCompat_Caption);
               this.mCounterView.setTextColor(ContextCompat.getColor(this.getContext(), R$color.design_textinput_error_color_light));
            }

            this.addIndicator(this.mCounterView, -1);
            if(this.mEditText == null) {
               this.updateCounter(0);
            } else {
               this.updateCounter(this.mEditText.getText().length());
            }
         } else {
            this.removeIndicator(this.mCounterView);
            this.mCounterView = null;
         }

         this.mCounterEnabled = var1;
      }

   }

   public void setCounterMaxLength(int var1) {
      if(this.mCounterMaxLength != var1) {
         if(var1 > 0) {
            this.mCounterMaxLength = var1;
         } else {
            this.mCounterMaxLength = -1;
         }

         if(this.mCounterEnabled) {
            if(this.mEditText == null) {
               var1 = 0;
            } else {
               var1 = this.mEditText.getText().length();
            }

            this.updateCounter(var1);
         }
      }

   }

   public void setError(@Nullable CharSequence var1) {
      if(!TextUtils.equals(this.mError, var1)) {
         this.mError = var1;
         if(!this.mErrorEnabled) {
            if(TextUtils.isEmpty(var1)) {
               return;
            }

            this.setErrorEnabled(true);
         }

         boolean var3 = ViewCompat.isLaidOut(this);
         boolean var2;
         if(!TextUtils.isEmpty(var1)) {
            var2 = true;
         } else {
            var2 = false;
         }

         this.mErrorShown = var2;
         if(this.mErrorShown) {
            this.mErrorView.setText(var1);
            this.mErrorView.setVisibility(0);
            if(var3) {
               if(ViewCompat.getAlpha(this.mErrorView) == 1.0F) {
                  ViewCompat.setAlpha(this.mErrorView, 0.0F);
               }

               ViewCompat.animate(this.mErrorView).alpha(1.0F).setDuration(200L).setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR).setListener(new TextInputLayout$2(this)).start();
            }
         } else if(this.mErrorView.getVisibility() == 0) {
            if(var3) {
               ViewCompat.animate(this.mErrorView).alpha(0.0F).setDuration(200L).setInterpolator(AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR).setListener(new TextInputLayout$3(this, var1)).start();
            } else {
               this.mErrorView.setVisibility(4);
            }
         }

         this.updateEditTextBackground();
         this.updateLabelState(true);
      }
   }

   public void setErrorEnabled(boolean var1) {
      if(this.mErrorEnabled != var1) {
         if(this.mErrorView != null) {
            ViewCompat.animate(this.mErrorView).cancel();
         }

         if(var1) {
            this.mErrorView = new TextView(this.getContext());

            try {
               this.mErrorView.setTextAppearance(this.getContext(), this.mErrorTextAppearance);
            } catch (Exception var3) {
               this.mErrorView.setTextAppearance(this.getContext(), R$style.TextAppearance_AppCompat_Caption);
               this.mErrorView.setTextColor(ContextCompat.getColor(this.getContext(), R$color.design_textinput_error_color_light));
            }

            this.mErrorView.setVisibility(4);
            ViewCompat.setAccessibilityLiveRegion(this.mErrorView, 1);
            this.addIndicator(this.mErrorView, 0);
         } else {
            this.mErrorShown = false;
            this.updateEditTextBackground();
            this.removeIndicator(this.mErrorView);
            this.mErrorView = null;
         }

         this.mErrorEnabled = var1;
      }

   }

   public void setHint(@Nullable CharSequence var1) {
      if(this.mHintEnabled) {
         this.setHintInternal(var1);
         this.sendAccessibilityEvent(2048);
      }

   }

   public void setHintAnimationEnabled(boolean var1) {
      this.mHintAnimationEnabled = var1;
   }

   public void setHintEnabled(boolean var1) {
      if(var1 != this.mHintEnabled) {
         this.mHintEnabled = var1;
         CharSequence var2 = this.mEditText.getHint();
         if(!this.mHintEnabled) {
            if(!TextUtils.isEmpty(this.mHint) && TextUtils.isEmpty(var2)) {
               this.mEditText.setHint(this.mHint);
            }

            this.setHintInternal((CharSequence)null);
         } else if(!TextUtils.isEmpty(var2)) {
            if(TextUtils.isEmpty(this.mHint)) {
               this.setHint(var2);
            }

            this.mEditText.setHint((CharSequence)null);
         }

         if(this.mEditText != null) {
            LayoutParams var3 = this.updateEditTextMargin(this.mEditText.getLayoutParams());
            this.mEditText.setLayoutParams(var3);
         }
      }

   }

   public void setHintTextAppearance(@StyleRes int var1) {
      this.mCollapsingTextHelper.setCollapsedTextAppearance(var1);
      this.mFocusedTextColor = ColorStateList.valueOf(this.mCollapsingTextHelper.getCollapsedTextColor());
      if(this.mEditText != null) {
         this.updateLabelState(false);
         LayoutParams var2 = this.updateEditTextMargin(this.mEditText.getLayoutParams());
         this.mEditText.setLayoutParams(var2);
         this.mEditText.requestLayout();
      }

   }

   public void setTypeface(@Nullable Typeface var1) {
      this.mCollapsingTextHelper.setTypefaces(var1);
   }
}
