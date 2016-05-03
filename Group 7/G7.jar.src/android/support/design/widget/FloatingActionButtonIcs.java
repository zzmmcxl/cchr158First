package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.view.ViewPropertyAnimator;

class FloatingActionButtonIcs
  extends FloatingActionButtonEclairMr1
{
  private boolean mIsHiding;
  
  FloatingActionButtonIcs(VisibilityAwareImageButton paramVisibilityAwareImageButton, ShadowViewDelegate paramShadowViewDelegate)
  {
    super(paramVisibilityAwareImageButton, paramShadowViewDelegate);
  }
  
  private void updateFromViewRotation(float paramFloat)
  {
    if (this.mShadowDrawable != null) {
      this.mShadowDrawable.setRotation(-paramFloat);
    }
    if (this.mBorderDrawable != null) {
      this.mBorderDrawable.setRotation(-paramFloat);
    }
  }
  
  void hide(@Nullable final FloatingActionButtonImpl.InternalVisibilityChangedListener paramInternalVisibilityChangedListener, final boolean paramBoolean)
  {
    if ((this.mIsHiding) || (this.mView.getVisibility() != 0)) {
      if (paramInternalVisibilityChangedListener != null) {
        paramInternalVisibilityChangedListener.onHidden();
      }
    }
    do
    {
      return;
      if ((ViewCompat.isLaidOut(this.mView)) && (!this.mView.isInEditMode())) {
        break;
      }
      this.mView.internalSetVisibility(8, paramBoolean);
    } while (paramInternalVisibilityChangedListener == null);
    paramInternalVisibilityChangedListener.onHidden();
    return;
    this.mView.animate().cancel();
    this.mView.animate().scaleX(0.0F).scaleY(0.0F).alpha(0.0F).setDuration(200L).setInterpolator(AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR).setListener(new AnimatorListenerAdapter()
    {
      private boolean mCancelled;
      
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        FloatingActionButtonIcs.access$002(FloatingActionButtonIcs.this, false);
        this.mCancelled = true;
      }
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        FloatingActionButtonIcs.access$002(FloatingActionButtonIcs.this, false);
        if (!this.mCancelled)
        {
          FloatingActionButtonIcs.this.mView.internalSetVisibility(8, paramBoolean);
          if (paramInternalVisibilityChangedListener != null) {
            paramInternalVisibilityChangedListener.onHidden();
          }
        }
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        FloatingActionButtonIcs.access$002(FloatingActionButtonIcs.this, true);
        this.mCancelled = false;
        FloatingActionButtonIcs.this.mView.internalSetVisibility(0, paramBoolean);
      }
    });
  }
  
  void onPreDraw()
  {
    updateFromViewRotation(this.mView.getRotation());
  }
  
  boolean requirePreDrawListener()
  {
    return true;
  }
  
  void show(@Nullable final FloatingActionButtonImpl.InternalVisibilityChangedListener paramInternalVisibilityChangedListener, final boolean paramBoolean)
  {
    if ((this.mIsHiding) || (this.mView.getVisibility() != 0))
    {
      if ((!ViewCompat.isLaidOut(this.mView)) || (this.mView.isInEditMode())) {
        break label127;
      }
      this.mView.animate().cancel();
      if (this.mView.getVisibility() != 0)
      {
        this.mView.setAlpha(0.0F);
        this.mView.setScaleY(0.0F);
        this.mView.setScaleX(0.0F);
      }
      this.mView.animate().scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(200L).setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR).setListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if (paramInternalVisibilityChangedListener != null) {
            paramInternalVisibilityChangedListener.onShown();
          }
        }
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          FloatingActionButtonIcs.this.mView.internalSetVisibility(0, paramBoolean);
        }
      });
    }
    label127:
    do
    {
      return;
      this.mView.internalSetVisibility(0, paramBoolean);
      this.mView.setAlpha(1.0F);
      this.mView.setScaleY(1.0F);
      this.mView.setScaleX(1.0F);
    } while (paramInternalVisibilityChangedListener == null);
    paramInternalVisibilityChangedListener.onShown();
  }
}


/* Location:              C:\Users\colin\Documents\GitHub\cchr158First\G7.jar!\android\support\design\widget\FloatingActionButtonIcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */