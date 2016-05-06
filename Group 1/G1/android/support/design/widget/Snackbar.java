package android.support.design.widget;

import android.view.View$MeasureSpec;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.LinearLayout;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;
import android.view.MotionEvent;
import android.view.ViewGroup$LayoutParams;
import android.content.res.ColorStateList;
import android.support.annotation.ColorInt;
import android.widget.Button;
import android.text.TextUtils;
import android.view.View$OnClickListener;
import android.support.annotation.StringRes;
import android.support.annotation.NonNull;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.view.animation.Animation;
import android.view.animation.Animation$AnimationListener;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;
import android.support.v4.view.ViewCompat;
import android.os.Build$VERSION;
import android.support.design.R;
import android.view.LayoutInflater;
import android.os.Message;
import android.os.Handler$Callback;
import android.os.Looper;
import android.view.ViewGroup;
import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import android.os.Handler;

public final class Snackbar
{
    static final int ANIMATION_DURATION = 250;
    static final int ANIMATION_FADE_DURATION = 180;
    public static final int LENGTH_INDEFINITE = -2;
    public static final int LENGTH_LONG = 0;
    public static final int LENGTH_SHORT = -1;
    private static final int MSG_DISMISS = 1;
    private static final int MSG_SHOW;
    private static final Handler sHandler;
    private final AccessibilityManager mAccessibilityManager;
    private Callback mCallback;
    private final Context mContext;
    private int mDuration;
    private final SnackbarManager.Callback mManagerCallback;
    private final ViewGroup mTargetParent;
    private final SnackbarLayout mView;
    
    static {
        sHandler = new Handler(Looper.getMainLooper(), (Handler$Callback)new Handler$Callback() {
            Snackbar$1() {
                super();
            }
            
            public boolean handleMessage(final Message message) {
                switch (message.what) {
                    default:
                        return false;
                    case 0:
                        ((Snackbar)message.obj).showView();
                        return true;
                    case 1:
                        ((Snackbar)message.obj).hideView(message.arg1);
                        return true;
                }
            }
        });
    }
    
    private Snackbar(final ViewGroup mTargetParent) {
        super();
        mManagerCallback = new SnackbarManager.Callback() {
            final /* synthetic */ Snackbar this$0;
            
            Snackbar$3() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void dismiss(final int n) {
                sHandler.sendMessage(sHandler.obtainMessage(1, n, 0, (Object)this$0));
            }
            
            @Override
            public void show() {
                sHandler.sendMessage(sHandler.obtainMessage(0, (Object)this$0));
            }
        };
        mTargetParent = mTargetParent;
        ThemeUtils.checkAppCompatTheme(mContext = mTargetParent.getContext());
        mView = (SnackbarLayout)LayoutInflater.from(mContext).inflate(R.layout.design_layout_snackbar, mTargetParent, false);
        mAccessibilityManager = (AccessibilityManager)mContext.getSystemService("accessibility");
    }
    
    static /* synthetic */ void access$000(final Snackbar snackbar, final int n) {
        snackbar.dispatchDismiss(n);
    }
    
    static /* synthetic */ Handler access$100() {
        return sHandler;
    }
    
    static /* synthetic */ SnackbarManager.Callback access$200(final Snackbar snackbar) {
        return snackbar.mManagerCallback;
    }
    
    static /* synthetic */ void access$300(final Snackbar snackbar, final int n) {
        snackbar.onViewHidden(n);
    }
    
    static /* synthetic */ void access$400(final Snackbar snackbar) {
        snackbar.animateViewIn();
    }
    
    static /* synthetic */ SnackbarLayout access$500(final Snackbar snackbar) {
        return snackbar.mView;
    }
    
    static /* synthetic */ AccessibilityManager access$600(final Snackbar snackbar) {
        return snackbar.mAccessibilityManager;
    }
    
    static /* synthetic */ void access$700(final Snackbar snackbar) {
        snackbar.onViewShown();
    }
    
    private void animateViewIn() {
        if (Build$VERSION.SDK_INT >= 14) {
            ViewCompat.setTranslationY(mView, (float)mView.getHeight());
            ViewCompat.animate((View)mView).translationY(0.0f).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR).setDuration(250L).setListener(new ViewPropertyAnimatorListenerAdapter() {
                final /* synthetic */ Snackbar this$0;
                
                Snackbar$7() {
                    this$0 = this$0;
                    super();
                }
                
                @Override
                public void onAnimationEnd(final View view) {
                    this$0.onViewShown();
                }
                
                @Override
                public void onAnimationStart(final View view) {
                    if (!mAccessibilityManager.isEnabled()) {
                        mView.animateChildrenIn(70, 180);
                    }
                }
            }).start();
            return;
        }
        final Animation loadAnimation = android.view.animation.AnimationUtils.loadAnimation(mView.getContext(), R.anim.design_snackbar_in);
        loadAnimation.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        loadAnimation.setDuration(250L);
        loadAnimation.setAnimationListener((Animation$AnimationListener)new Animation$AnimationListener() {
            final /* synthetic */ Snackbar this$0;
            
            Snackbar$8() {
                this$0 = this$0;
                super();
            }
            
            public void onAnimationEnd(final Animation animation) {
                this$0.onViewShown();
            }
            
            public void onAnimationRepeat(final Animation animation) {
            }
            
            public void onAnimationStart(final Animation animation) {
            }
        });
        mView.startAnimation(loadAnimation);
    }
    
    private void animateViewOut(final int n) {
        if (Build$VERSION.SDK_INT >= 14) {
            ViewCompat.animate((View)mView).translationY(mView.getHeight()).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR).setDuration(250L).setListener(new ViewPropertyAnimatorListenerAdapter() {
                boolean mEndCalled = false;
                final /* synthetic */ Snackbar this$0;
                final /* synthetic */ int val$event;
                
                Snackbar$9() {
                    this$0 = this$0;
                    super();
                }
                
                @Override
                public void onAnimationEnd(final View view) {
                    this$0.onViewHidden(n);
                }
                
                @Override
                public void onAnimationStart(final View view) {
                    if (!mAccessibilityManager.isEnabled()) {
                        mView.animateChildrenOut(0, 180);
                    }
                }
            }).start();
            return;
        }
        final Animation loadAnimation = android.view.animation.AnimationUtils.loadAnimation(mView.getContext(), R.anim.design_snackbar_out);
        loadAnimation.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        loadAnimation.setDuration(250L);
        loadAnimation.setAnimationListener((Animation$AnimationListener)new Animation$AnimationListener() {
            final /* synthetic */ Snackbar this$0;
            final /* synthetic */ int val$event;
            
            Snackbar$10() {
                this$0 = this$0;
                super();
            }
            
            public void onAnimationEnd(final Animation animation) {
                this$0.onViewHidden(n);
            }
            
            public void onAnimationRepeat(final Animation animation) {
            }
            
            public void onAnimationStart(final Animation animation) {
            }
        });
        mView.startAnimation(loadAnimation);
    }
    
    private void dispatchDismiss(final int n) {
        SnackbarManager.getInstance().dismiss(mManagerCallback, n);
    }
    
    private static ViewGroup findSuitableParent(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup)view;
                }
                viewGroup = (ViewGroup)view;
            }
            if (view != null) {
                final ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    view = (View)parent;
                }
                else {
                    view = null;
                }
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup)view;
    }
    
    @NonNull
    public static Snackbar make(@NonNull final View view, @StringRes final int n, final int n2) {
        return make(view, view.getResources().getText(n), n2);
    }
    
    @NonNull
    public static Snackbar make(@NonNull final View view, @NonNull final CharSequence text, final int duration) {
        final Snackbar snackbar = new Snackbar(findSuitableParent(view));
        snackbar.setText(text);
        snackbar.setDuration(duration);
        return snackbar;
    }
    
    private void onViewHidden(final int n) {
        SnackbarManager.getInstance().onDismissed(mManagerCallback);
        if (mCallback != null) {
            mCallback.onDismissed(this, n);
        }
        final ViewParent parent = mView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup)parent).removeView((View)mView);
        }
    }
    
    private void onViewShown() {
        SnackbarManager.getInstance().onShown(mManagerCallback);
        if (mCallback != null) {
            mCallback.onShown(this);
        }
    }
    
    public void dismiss() {
        this.dispatchDismiss(3);
    }
    
    public int getDuration() {
        return mDuration;
    }
    
    @NonNull
    public View getView() {
        return (View)mView;
    }
    
    final void hideView(final int n) {
        if (mView.getVisibility() != 0) {
            this.onViewHidden(n);
            return;
        }
        this.animateViewOut(n);
    }
    
    public boolean isShown() {
        return SnackbarManager.getInstance().isCurrent(mManagerCallback);
    }
    
    public boolean isShownOrQueued() {
        return SnackbarManager.getInstance().isCurrentOrNext(mManagerCallback);
    }
    
    @NonNull
    public Snackbar setAction(@StringRes final int n, final View$OnClickListener view$OnClickListener) {
        return this.setAction(mContext.getText(n), view$OnClickListener);
    }
    
    @NonNull
    public Snackbar setAction(final CharSequence text, final View$OnClickListener view$OnClickListener) {
        final Button actionView = mView.getActionView();
        if (TextUtils.isEmpty(text) || view$OnClickListener == null) {
            ((TextView)actionView).setVisibility(8);
            ((TextView)actionView).setOnClickListener((View$OnClickListener)null);
            return this;
        }
        ((TextView)actionView).setVisibility(0);
        ((TextView)actionView).setText(text);
        ((TextView)actionView).setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            final /* synthetic */ Snackbar this$0;
            final /* synthetic */ View$OnClickListener val$listener;
            
            Snackbar$2() {
                this$0 = this$0;
                super();
            }
            
            public void onClick(final View view) {
                view$OnClickListener.onClick(view);
                this$0.dispatchDismiss(1);
            }
        });
        return this;
    }
    
    @NonNull
    public Snackbar setActionTextColor(@ColorInt final int textColor) {
        ((TextView)mView.getActionView()).setTextColor(textColor);
        return this;
    }
    
    @NonNull
    public Snackbar setActionTextColor(final ColorStateList textColor) {
        ((TextView)mView.getActionView()).setTextColor(textColor);
        return this;
    }
    
    @NonNull
    public Snackbar setCallback(final Callback mCallback) {
        this.mCallback = mCallback;
        return this;
    }
    
    @NonNull
    public Snackbar setDuration(final int mDuration) {
        this.mDuration = mDuration;
        return this;
    }
    
    @NonNull
    public Snackbar setText(@StringRes final int n) {
        return this.setText(mContext.getText(n));
    }
    
    @NonNull
    public Snackbar setText(@NonNull final CharSequence text) {
        mView.getMessageView().setText(text);
        return this;
    }
    
    public void show() {
        SnackbarManager.getInstance().show(mDuration, mManagerCallback);
    }
    
    final void showView() {
        if (mView.getParent() == null) {
            final ViewGroup$LayoutParams layoutParams = mView.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                final Behavior behavior = new Behavior();
                behavior.setStartAlphaSwipeDistance(0.1f);
                behavior.setEndAlphaSwipeDistance(0.6f);
                behavior.setSwipeDirection(0);
                behavior.setListener((SwipeDismissBehavior.OnDismissListener)new SwipeDismissBehavior.OnDismissListener() {
                    final /* synthetic */ Snackbar this$0;
                    
                    Snackbar$4() {
                        this$0 = this$0;
                        super();
                    }
                    
                    @Override
                    public void onDismiss(final View view) {
                        view.setVisibility(8);
                        this$0.dispatchDismiss(0);
                    }
                    
                    @Override
                    public void onDragStateChanged(final int n) {
                        switch (n) {
                            default:
                            case 1:
                            case 2:
                                SnackbarManager.getInstance().cancelTimeout(mManagerCallback);
                            case 0:
                                SnackbarManager.getInstance().restoreTimeout(mManagerCallback);
                        }
                    }
                });
                ((CoordinatorLayout.LayoutParams)layoutParams).setBehavior(behavior);
            }
            mTargetParent.addView((View)mView);
        }
        mView.setOnAttachStateChangeListener((OnAttachStateChangeListener)new OnAttachStateChangeListener() {
            final /* synthetic */ Snackbar this$0;
            
            Snackbar$5() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void onViewAttachedToWindow(final View view) {
            }
            
            @Override
            public void onViewDetachedFromWindow(final View view) {
                if (this$0.isShownOrQueued()) {
                    sHandler.post((Runnable)new Runnable() {
                        final /* synthetic */ Snackbar$5 this$1;
                        
                        Snackbar$5$1() {
                            this$1 = this$1;
                            super();
                        }
                        
                        @Override
                        public void run() {
                            this$0.onViewHidden(3);
                        }
                    });
                }
            }
        });
        if (ViewCompat.isLaidOut((View)mView)) {
            this.animateViewIn();
            return;
        }
        mView.setOnLayoutChangeListener((OnLayoutChangeListener)new OnLayoutChangeListener() {
            final /* synthetic */ Snackbar this$0;
            
            Snackbar$6() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void onLayoutChange(final View view, final int n, final int n2, final int n3, final int n4) {
                this$0.animateViewIn();
                mView.setOnLayoutChangeListener(null);
            }
        });
    }
}
