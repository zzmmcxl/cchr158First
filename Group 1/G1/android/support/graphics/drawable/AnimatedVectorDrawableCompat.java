package android.support.graphics.drawable;

import android.graphics.drawable.VectorDrawable;
import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.graphics.Paint$Style;
import android.graphics.Region$Op;
import android.graphics.PathMeasure;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Paint$Join;
import android.graphics.Paint$Cap;
import java.util.Stack;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PorterDuffColorFilter;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.animation.AnimatorInflater;
import android.graphics.Region;
import android.graphics.Rect;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.ColorFilter;
import android.graphics.Canvas;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.animation.TypeEvaluator;
import android.animation.ObjectAnimator;
import android.animation.AnimatorSet;
import android.support.v4.util.ArrayMap;
import android.content.res.TypedArray;
import java.util.ArrayList;
import android.animation.Animator;
import android.content.res.Resources$Theme;
import android.util.AttributeSet;
import android.content.res.XmlResourceParser;
import java.io.IOException;
import android.util.Log;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParser;
import android.util.Xml;
import android.support.v4.content.res.ResourcesCompat;
import android.os.Build$VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.content.res.Resources;
import android.content.Context;
import android.graphics.drawable.Drawable$Callback;
import android.animation.ArgbEvaluator;
import android.annotation.TargetApi;
import android.graphics.drawable.Animatable;

@TargetApi(21)
public class AnimatedVectorDrawableCompat extends VectorDrawableCommon implements Animatable
{
    private static final String ANIMATED_VECTOR = "animated-vector";
    private static final boolean DBG_ANIMATION_VECTOR_DRAWABLE = false;
    private static final String LOGTAG = "AnimatedVDCompat";
    private static final String TARGET = "target";
    private AnimatedVectorDrawableCompatState mAnimatedVectorState;
    private ArgbEvaluator mArgbEvaluator;
    AnimatedVectorDrawableDelegateState mCachedConstantStateDelegate;
    private final Drawable$Callback mCallback;
    private Context mContext;
    
    private AnimatedVectorDrawableCompat() {
        this(null, null, null);
    }
    
    private AnimatedVectorDrawableCompat(@Nullable final Context context) {
        this(context, null, null);
    }
    
    private AnimatedVectorDrawableCompat(@Nullable final Context mContext, @Nullable final AnimatedVectorDrawableCompatState mAnimatedVectorState, @Nullable final Resources resources) {
        super();
        mArgbEvaluator = null;
        mCallback = (Drawable$Callback)new Drawable$Callback() {
            final /* synthetic */ AnimatedVectorDrawableCompat this$0;
            
            AnimatedVectorDrawableCompat$1() {
                this$0 = this$0;
                super();
            }
            
            public void invalidateDrawable(final Drawable drawable) {
                this$0.invalidateSelf();
            }
            
            public void scheduleDrawable(final Drawable drawable, final Runnable runnable, final long n) {
                this$0.scheduleSelf(runnable, n);
            }
            
            public void unscheduleDrawable(final Drawable drawable, final Runnable runnable) {
                this$0.unscheduleSelf(runnable);
            }
        };
        mContext = mContext;
        if (mAnimatedVectorState != null) {
            mAnimatedVectorState = mAnimatedVectorState;
            return;
        }
        mAnimatedVectorState = new AnimatedVectorDrawableCompatState(mContext, mAnimatedVectorState, mCallback, resources);
    }
    
    AnimatedVectorDrawableCompat(final AnimatedVectorDrawableCompat$1 drawable$Callback) {
        this();
    }
    
    static /* synthetic */ Drawable$Callback access$100(final AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
        return animatedVectorDrawableCompat.mCallback;
    }
    
    @Nullable
    public static AnimatedVectorDrawableCompat create(@NonNull final Context context, @DrawableRes final int n) {
        if (Build$VERSION.SDK_INT >= 21) {
            final AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
            (animatedVectorDrawableCompat.mDelegateDrawable = ResourcesCompat.getDrawable(context.getResources(), n, context.getTheme())).setCallback(animatedVectorDrawableCompat.mCallback);
            animatedVectorDrawableCompat.mCachedConstantStateDelegate = new AnimatedVectorDrawableDelegateState(animatedVectorDrawableCompat.mDelegateDrawable.getConstantState());
            return animatedVectorDrawableCompat;
        }
        final Resources resources = context.getResources();
        try {
            final XmlResourceParser xml = resources.getXml(n);
            Xml.asAttributeSet((XmlPullParser)xml);
            int next;
            do {
                next = ((XmlPullParser)xml).next();
            } while (next != 2 && next != 1);
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            goto Label_0134;
        }
        catch (XmlPullParserException ex) {
            Log.e("AnimatedVDCompat", "parser error", (Throwable)ex);
        }
        catch (IOException ex2) {
            Log.e("AnimatedVDCompat", "parser error", (Throwable)ex2);
            goto Label_0132;
        }
    }
    
    public static AnimatedVectorDrawableCompat createFromXmlInner(final Context context, final Resources resources, final XmlPullParser xmlPullParser, final AttributeSet set, final Resources$Theme resources$Theme) throws XmlPullParserException, IOException {
        final AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
        animatedVectorDrawableCompat.inflate(resources, xmlPullParser, set, resources$Theme);
        return animatedVectorDrawableCompat;
    }
    
    private boolean isStarted() {
        final ArrayList<Animator> mAnimators = mAnimatedVectorState.mAnimators;
        if (mAnimators != null) {
            for (int size = mAnimators.size(), i = 0; i < size; ++i) {
                if (((Animator)mAnimators.get(i)).isRunning()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    static TypedArray obtainAttributes(final Resources resources, final Resources$Theme resources$Theme, final AttributeSet set, final int[] array) {
        if (resources$Theme == null) {
            return resources.obtainAttributes(set, array);
        }
        return resources$Theme.obtainStyledAttributes(set, array, 0, 0);
    }
    
    private void setupAnimatorsForTarget(final String s, final Animator animator) {
        animator.setTarget(mAnimatedVectorState.mVectorDrawable.getTargetByName(s));
        if (Build$VERSION.SDK_INT < 21) {
            this.setupColorAnimator(animator);
        }
        if (mAnimatedVectorState.mAnimators == null) {
            mAnimatedVectorState.mAnimators = new ArrayList<Animator>();
            mAnimatedVectorState.mTargetNameMap = new ArrayMap<Animator, String>();
        }
        mAnimatedVectorState.mAnimators.add(animator);
        mAnimatedVectorState.mTargetNameMap.put(animator, s);
    }
    
    private void setupColorAnimator(final Animator animator) {
        if (animator instanceof AnimatorSet) {
            final ArrayList childAnimations = ((AnimatorSet)animator).getChildAnimations();
            if (childAnimations != null) {
                for (int i = 0; i < childAnimations.size(); ++i) {
                    this.setupColorAnimator((Animator)childAnimations.get(i));
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            final ObjectAnimator objectAnimator = (ObjectAnimator)animator;
            final String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (mArgbEvaluator == null) {
                    mArgbEvaluator = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator((TypeEvaluator)mArgbEvaluator);
            }
        }
    }
    
    @Override
    public void applyTheme(final Resources$Theme resources$Theme) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.applyTheme(this.mDelegateDrawable, resources$Theme);
        }
    }
    
    public boolean canApplyTheme() {
        return this.mDelegateDrawable != null && DrawableCompat.canApplyTheme(this.mDelegateDrawable);
    }
    
    @Override
    public /* bridge */ void clearColorFilter() {
        super.clearColorFilter();
    }
    
    public void draw(final Canvas canvas) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.draw(canvas);
        }
        else {
            mAnimatedVectorState.mVectorDrawable.draw(canvas);
            if (this.isStarted()) {
                this.invalidateSelf();
            }
        }
    }
    
    public int getAlpha() {
        if (this.mDelegateDrawable != null) {
            return DrawableCompat.getAlpha(this.mDelegateDrawable);
        }
        return mAnimatedVectorState.mVectorDrawable.getAlpha();
    }
    
    public int getChangingConfigurations() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | mAnimatedVectorState.mChangingConfigurations;
    }
    
    @Override
    public /* bridge */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }
    
    public Drawable$ConstantState getConstantState() {
        if (this.mDelegateDrawable != null) {
            return new AnimatedVectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
        }
        return null;
    }
    
    @Override
    public /* bridge */ Drawable getCurrent() {
        return super.getCurrent();
    }
    
    public int getIntrinsicHeight() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getIntrinsicHeight();
        }
        return mAnimatedVectorState.mVectorDrawable.getIntrinsicHeight();
    }
    
    public int getIntrinsicWidth() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getIntrinsicWidth();
        }
        return mAnimatedVectorState.mVectorDrawable.getIntrinsicWidth();
    }
    
    @Override
    public /* bridge */ int getLayoutDirection() {
        return super.getLayoutDirection();
    }
    
    @Override
    public /* bridge */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }
    
    @Override
    public /* bridge */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }
    
    public int getOpacity() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getOpacity();
        }
        return mAnimatedVectorState.mVectorDrawable.getOpacity();
    }
    
    @Override
    public /* bridge */ boolean getPadding(final Rect rect) {
        return super.getPadding(rect);
    }
    
    @Override
    public /* bridge */ int[] getState() {
        return super.getState();
    }
    
    @Override
    public /* bridge */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }
    
    public void inflate(final Resources resources, final XmlPullParser xmlPullParser, final AttributeSet set) throws XmlPullParserException, IOException {
        this.inflate(resources, xmlPullParser, set, null);
    }
    
    public void inflate(final Resources resources, final XmlPullParser xmlPullParser, final AttributeSet set, final Resources$Theme resources$Theme) throws XmlPullParserException, IOException {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.inflate(this.mDelegateDrawable, resources, xmlPullParser, set, resources$Theme);
        }
        else {
            for (int i = xmlPullParser.getEventType(); i != 1; i = xmlPullParser.next()) {
                if (i == 2) {
                    final String name = xmlPullParser.getName();
                    if ("animated-vector".equals(name)) {
                        final TypedArray obtainAttributes = obtainAttributes(resources, resources$Theme, set, AndroidResources.styleable_AnimatedVectorDrawable);
                        final int resourceId = obtainAttributes.getResourceId(0, 0);
                        if (resourceId != 0) {
                            final VectorDrawableCompat create = VectorDrawableCompat.create(resources, resourceId, resources$Theme);
                            create.setAllowCaching(false);
                            create.setCallback(mCallback);
                            if (mAnimatedVectorState.mVectorDrawable != null) {
                                mAnimatedVectorState.mVectorDrawable.setCallback((Drawable$Callback)null);
                            }
                            mAnimatedVectorState.mVectorDrawable = create;
                        }
                        obtainAttributes.recycle();
                    }
                    else if ("target".equals(name)) {
                        final TypedArray obtainAttributes2 = resources.obtainAttributes(set, AndroidResources.styleable_AnimatedVectorDrawableTarget);
                        final String string = obtainAttributes2.getString(0);
                        final int resourceId2 = obtainAttributes2.getResourceId(1, 0);
                        if (resourceId2 != 0) {
                            if (mContext == null) {
                                throw new IllegalStateException("Context can't be null when inflating animators");
                            }
                            this.setupAnimatorsForTarget(string, AnimatorInflater.loadAnimator(mContext, resourceId2));
                        }
                        obtainAttributes2.recycle();
                    }
                }
            }
        }
    }
    
    @Override
    public /* bridge */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }
    
    public boolean isRunning() {
        if (this.mDelegateDrawable != null) {
            return ((AnimatedVectorDrawable)this.mDelegateDrawable).isRunning();
        }
        final ArrayList<Animator> mAnimators = mAnimatedVectorState.mAnimators;
        for (int size = mAnimators.size(), i = 0; i < size; ++i) {
            if (((Animator)mAnimators.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isStateful() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.isStateful();
        }
        return mAnimatedVectorState.mVectorDrawable.isStateful();
    }
    
    @Override
    public /* bridge */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }
    
    public Drawable mutate() {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.mutate();
            return this;
        }
        throw new IllegalStateException("Mutate() is not supported for older platform");
    }
    
    @Override
    protected void onBoundsChange(final Rect rect) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setBounds(rect);
            return;
        }
        mAnimatedVectorState.mVectorDrawable.setBounds(rect);
    }
    
    @Override
    protected boolean onLevelChange(final int n) {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.setLevel(n);
        }
        return mAnimatedVectorState.mVectorDrawable.setLevel(n);
    }
    
    protected boolean onStateChange(final int[] array) {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.setState(array);
        }
        return mAnimatedVectorState.mVectorDrawable.setState(array);
    }
    
    public void setAlpha(final int n) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setAlpha(n);
            return;
        }
        mAnimatedVectorState.mVectorDrawable.setAlpha(n);
    }
    
    @Override
    public /* bridge */ void setAutoMirrored(final boolean autoMirrored) {
        super.setAutoMirrored(autoMirrored);
    }
    
    @Override
    public /* bridge */ void setChangingConfigurations(final int changingConfigurations) {
        super.setChangingConfigurations(changingConfigurations);
    }
    
    @Override
    public /* bridge */ void setColorFilter(final int n, final PorterDuff$Mode porterDuff$Mode) {
        super.setColorFilter(n, porterDuff$Mode);
    }
    
    public void setColorFilter(final ColorFilter colorFilter) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setColorFilter(colorFilter);
            return;
        }
        mAnimatedVectorState.mVectorDrawable.setColorFilter(colorFilter);
    }
    
    @Override
    public /* bridge */ void setFilterBitmap(final boolean filterBitmap) {
        super.setFilterBitmap(filterBitmap);
    }
    
    @Override
    public /* bridge */ void setHotspot(final float n, final float n2) {
        super.setHotspot(n, n2);
    }
    
    @Override
    public /* bridge */ void setHotspotBounds(final int n, final int n2, final int n3, final int n4) {
        super.setHotspotBounds(n, n2, n3, n4);
    }
    
    @Override
    public /* bridge */ boolean setState(final int[] state) {
        return super.setState(state);
    }
    
    public void setTint(final int tint) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setTint(this.mDelegateDrawable, tint);
            return;
        }
        mAnimatedVectorState.mVectorDrawable.setTint(tint);
    }
    
    public void setTintList(final ColorStateList tintList) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setTintList(this.mDelegateDrawable, tintList);
            return;
        }
        mAnimatedVectorState.mVectorDrawable.setTintList(tintList);
    }
    
    public void setTintMode(final PorterDuff$Mode tintMode) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setTintMode(this.mDelegateDrawable, tintMode);
            return;
        }
        mAnimatedVectorState.mVectorDrawable.setTintMode(tintMode);
    }
    
    public boolean setVisible(final boolean b, final boolean b2) {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.setVisible(b, b2);
        }
        mAnimatedVectorState.mVectorDrawable.setVisible(b, b2);
        return super.setVisible(b, b2);
    }
    
    public void start() {
        if (this.mDelegateDrawable != null) {
            ((AnimatedVectorDrawable)this.mDelegateDrawable).start();
        }
        else if (!this.isStarted()) {
            final ArrayList<Animator> mAnimators = mAnimatedVectorState.mAnimators;
            for (int size = mAnimators.size(), i = 0; i < size; ++i) {
                ((Animator)mAnimators.get(i)).start();
            }
            this.invalidateSelf();
        }
    }
    
    public void stop() {
        if (this.mDelegateDrawable != null) {
            ((AnimatedVectorDrawable)this.mDelegateDrawable).stop();
        }
        else {
            final ArrayList<Animator> mAnimators = mAnimatedVectorState.mAnimators;
            for (int size = mAnimators.size(), i = 0; i < size; ++i) {
                ((Animator)mAnimators.get(i)).end();
            }
        }
    }
}
