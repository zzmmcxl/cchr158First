package android.support.graphics.drawable;

import android.graphics.drawable.VectorDrawable;
import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.graphics.Paint$Style;
import android.graphics.Region$Op;
import android.graphics.PathMeasure;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.util.ArrayMap;
import java.util.ArrayList;
import android.graphics.Paint$Join;
import android.graphics.Paint$Cap;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.Canvas;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import java.util.Stack;
import android.util.AttributeSet;
import android.content.res.XmlResourceParser;
import java.io.IOException;
import android.util.Log;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParser;
import android.util.Xml;
import android.support.v4.content.res.ResourcesCompat;
import android.os.Build$VERSION;
import android.support.annotation.Nullable;
import android.content.res.Resources$Theme;
import android.support.annotation.DrawableRes;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.PorterDuffColorFilter;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.PorterDuff$Mode;
import android.annotation.TargetApi;

@TargetApi(21)
public class VectorDrawableCompat extends VectorDrawableCommon
{
    private static final boolean DBG_VECTOR_DRAWABLE = false;
    static final PorterDuff$Mode DEFAULT_TINT_MODE;
    private static final int LINECAP_BUTT = 0;
    private static final int LINECAP_ROUND = 1;
    private static final int LINECAP_SQUARE = 2;
    private static final int LINEJOIN_BEVEL = 2;
    private static final int LINEJOIN_MITER = 0;
    private static final int LINEJOIN_ROUND = 1;
    static final String LOGTAG = "VectorDrawableCompat";
    private static final int MAX_CACHED_BITMAP_SIZE = 2048;
    private static final String SHAPE_CLIP_PATH = "clip-path";
    private static final String SHAPE_GROUP = "group";
    private static final String SHAPE_PATH = "path";
    private static final String SHAPE_VECTOR = "vector";
    private boolean mAllowCaching;
    private Drawable$ConstantState mCachedConstantStateDelegate;
    private ColorFilter mColorFilter;
    private boolean mMutated;
    private PorterDuffColorFilter mTintFilter;
    private final Rect mTmpBounds;
    private final float[] mTmpFloats;
    private final Matrix mTmpMatrix;
    private VectorDrawableCompatState mVectorState;
    
    static {
        DEFAULT_TINT_MODE = PorterDuff$Mode.SRC_IN;
    }
    
    private VectorDrawableCompat() {
        super();
        mAllowCaching = true;
        mTmpFloats = new float[9];
        mTmpMatrix = new Matrix();
        mTmpBounds = new Rect();
        mVectorState = new VectorDrawableCompatState();
    }
    
    VectorDrawableCompat(final VectorDrawableCompat$1 object) {
        this();
    }
    
    private VectorDrawableCompat(@NonNull final VectorDrawableCompatState mVectorState) {
        super();
        mAllowCaching = true;
        mTmpFloats = new float[9];
        mTmpMatrix = new Matrix();
        mTmpBounds = new Rect();
        mVectorState = mVectorState;
        mTintFilter = this.updateTintFilter(mTintFilter, mVectorState.mTint, mVectorState.mTintMode);
    }
    
    VectorDrawableCompat(final VectorDrawableCompatState vectorDrawableCompatState, final VectorDrawableCompat$1 object) {
        this(vectorDrawableCompatState);
    }
    
    static /* synthetic */ int access$900(final int n, final float n2) {
        return applyAlpha(n, n2);
    }
    
    private static int applyAlpha(final int n, final float n2) {
        return (n & 0xFFFFFF) | (int)(n2 * Color.alpha(n)) << 24;
    }
    
    @Nullable
    public static VectorDrawableCompat create(@NonNull final Resources resources, @DrawableRes final int n, @Nullable final Resources$Theme resources$Theme) {
        if (Build$VERSION.SDK_INT >= 21) {
            final VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = ResourcesCompat.getDrawable(resources, n, resources$Theme);
            vectorDrawableCompat.mCachedConstantStateDelegate = new VectorDrawableDelegateState(vectorDrawableCompat.mDelegateDrawable.getConstantState());
            return vectorDrawableCompat;
        }
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
            goto Label_0111;
        }
        catch (XmlPullParserException ex) {
            Log.e("VectorDrawableCompat", "parser error", (Throwable)ex);
        }
        catch (IOException ex2) {
            Log.e("VectorDrawableCompat", "parser error", (Throwable)ex2);
            goto Label_0109;
        }
    }
    
    public static VectorDrawableCompat createFromXmlInner(final Resources resources, final XmlPullParser xmlPullParser, final AttributeSet set, final Resources$Theme resources$Theme) throws XmlPullParserException, IOException {
        final VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, set, resources$Theme);
        return vectorDrawableCompat;
    }
    
    private void inflateInternal(final Resources resources, final XmlPullParser xmlPullParser, final AttributeSet set, final Resources$Theme resources$Theme) throws XmlPullParserException, IOException {
        final VectorDrawableCompatState mVectorState = this.mVectorState;
        final VPathRenderer mvPathRenderer = mVectorState.mVPathRenderer;
        boolean b = true;
        final Stack<VGroup> stack = new Stack<VGroup>();
        stack.push(mvPathRenderer.mRootGroup);
        for (int i = xmlPullParser.getEventType(); i != 1; i = xmlPullParser.next()) {
            if (i == 2) {
                final String name = xmlPullParser.getName();
                final VGroup vGroup = (VGroup)stack.peek();
                if ("path".equals(name)) {
                    final VFullPath vFullPath = new VFullPath();
                    vFullPath.inflate(resources, set, resources$Theme, xmlPullParser);
                    vGroup.mChildren.add(vFullPath);
                    if (((VPath)vFullPath).getPathName() != null) {
                        mvPathRenderer.mVGTargetsMap.put(((VPath)vFullPath).getPathName(), vFullPath);
                    }
                    b = false;
                    mVectorState.mChangingConfigurations |= vFullPath.mChangingConfigurations;
                }
                else if ("clip-path".equals(name)) {
                    final VClipPath vClipPath = new VClipPath();
                    vClipPath.inflate(resources, set, resources$Theme, xmlPullParser);
                    vGroup.mChildren.add(vClipPath);
                    if (((VPath)vClipPath).getPathName() != null) {
                        mvPathRenderer.mVGTargetsMap.put(((VPath)vClipPath).getPathName(), vClipPath);
                    }
                    mVectorState.mChangingConfigurations |= vClipPath.mChangingConfigurations;
                }
                else if ("group".equals(name)) {
                    final VGroup vGroup2 = new VGroup();
                    vGroup2.inflate(resources, set, resources$Theme, xmlPullParser);
                    vGroup.mChildren.add(vGroup2);
                    stack.push(vGroup2);
                    if (vGroup2.getGroupName() != null) {
                        mvPathRenderer.mVGTargetsMap.put(vGroup2.getGroupName(), vGroup2);
                    }
                    mVectorState.mChangingConfigurations |= vGroup2.mChangingConfigurations;
                }
            }
            else if (i == 3 && "group".equals(xmlPullParser.getName())) {
                stack.pop();
            }
        }
        if (b) {
            final StringBuffer sb = new StringBuffer();
            if (sb.length() > 0) {
                sb.append(" or ");
            }
            sb.append("path");
            throw new XmlPullParserException("no " + (Object)sb + " defined");
        }
    }
    
    private boolean needMirroring() {
        return false;
    }
    
    private static PorterDuff$Mode parseTintModeCompat(final int n, final PorterDuff$Mode porterDuff$Mode) {
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
            case 16:
                return PorterDuff$Mode.ADD;
        }
    }
    
    private void printGroupTree(final VGroup vGroup, final int n) {
        String string = "";
        for (int i = 0; i < n; ++i) {
            string += "    ";
        }
        Log.v("VectorDrawableCompat", string + "current group is :" + vGroup.getGroupName() + " rotation is " + vGroup.mRotate);
        Log.v("VectorDrawableCompat", string + "matrix is :" + vGroup.getLocalMatrix().toString());
        for (int j = 0; j < vGroup.mChildren.size(); ++j) {
            final Object value = vGroup.mChildren.get(j);
            if (value instanceof VGroup) {
                this.printGroupTree((VGroup)value, n + 1);
            }
            else {
                ((VPath)value).printVPath(n + 1);
            }
        }
    }
    
    private void updateStateFromTypedArray(final TypedArray typedArray, final XmlPullParser xmlPullParser) throws XmlPullParserException {
        final VectorDrawableCompatState mVectorState = this.mVectorState;
        final VPathRenderer mvPathRenderer = mVectorState.mVPathRenderer;
        mVectorState.mTintMode = parseTintModeCompat(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff$Mode.SRC_IN);
        final ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            mVectorState.mTint = colorStateList;
        }
        mVectorState.mAutoMirrored = TypedArrayUtils.getNamedBoolean(typedArray, xmlPullParser, "autoMirrored", 5, mVectorState.mAutoMirrored);
        mvPathRenderer.mViewportWidth = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportWidth", 7, mvPathRenderer.mViewportWidth);
        mvPathRenderer.mViewportHeight = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportHeight", 8, mvPathRenderer.mViewportHeight);
        if (mvPathRenderer.mViewportWidth <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (mvPathRenderer.mViewportHeight <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        mvPathRenderer.mBaseWidth = typedArray.getDimension(3, mvPathRenderer.mBaseWidth);
        mvPathRenderer.mBaseHeight = typedArray.getDimension(2, mvPathRenderer.mBaseHeight);
        if (mvPathRenderer.mBaseWidth <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (mvPathRenderer.mBaseHeight <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        mvPathRenderer.setAlpha(TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "alpha", 4, mvPathRenderer.getAlpha()));
        final String string = typedArray.getString(0);
        if (string != null) {
            mvPathRenderer.mRootName = string;
            mvPathRenderer.mVGTargetsMap.put(string, mvPathRenderer);
        }
    }
    
    @Override
    public /* bridge */ void applyTheme(final Resources$Theme resources$Theme) {
        super.applyTheme(resources$Theme);
    }
    
    public boolean canApplyTheme() {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.canApplyTheme(this.mDelegateDrawable);
        }
        return false;
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
            this.copyBounds(mTmpBounds);
            if (mTmpBounds.width() > 0 && mTmpBounds.height() > 0) {
                Object o;
                if (mColorFilter == null) {
                    o = mTintFilter;
                }
                else {
                    o = mColorFilter;
                }
                canvas.getMatrix(mTmpMatrix);
                mTmpMatrix.getValues(mTmpFloats);
                float abs = Math.abs(mTmpFloats[0]);
                float abs2 = Math.abs(mTmpFloats[4]);
                final float abs3 = Math.abs(mTmpFloats[1]);
                final float abs4 = Math.abs(mTmpFloats[3]);
                if (abs3 != 0.0f || abs4 != 0.0f) {
                    abs = 1.0f;
                    abs2 = 1.0f;
                }
                final int n = (int)(abs * mTmpBounds.width());
                final int n2 = (int)(abs2 * mTmpBounds.height());
                final int min = Math.min(2048, n);
                final int min2 = Math.min(2048, n2);
                if (min > 0 && min2 > 0) {
                    final int save = canvas.save();
                    canvas.translate((float)mTmpBounds.left, (float)mTmpBounds.top);
                    if (this.needMirroring()) {
                        canvas.translate((float)mTmpBounds.width(), 0.0f);
                        canvas.scale(-1.0f, 1.0f);
                    }
                    mTmpBounds.offsetTo(0, 0);
                    mVectorState.createCachedBitmapIfNeeded(min, min2);
                    if (!mAllowCaching) {
                        mVectorState.updateCachedBitmap(min, min2);
                    }
                    else if (!mVectorState.canReuseCache()) {
                        mVectorState.updateCachedBitmap(min, min2);
                        mVectorState.updateCacheStates();
                    }
                    mVectorState.drawCachedBitmapWithRootAlpha(canvas, (ColorFilter)o, mTmpBounds);
                    canvas.restoreToCount(save);
                }
            }
        }
    }
    
    public int getAlpha() {
        if (this.mDelegateDrawable != null) {
            return DrawableCompat.getAlpha(this.mDelegateDrawable);
        }
        return mVectorState.mVPathRenderer.getRootAlpha();
    }
    
    public int getChangingConfigurations() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | mVectorState.getChangingConfigurations();
    }
    
    @Override
    public /* bridge */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }
    
    public Drawable$ConstantState getConstantState() {
        if (this.mDelegateDrawable != null) {
            return new VectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
        }
        mVectorState.mChangingConfigurations = this.getChangingConfigurations();
        return mVectorState;
    }
    
    @Override
    public /* bridge */ Drawable getCurrent() {
        return super.getCurrent();
    }
    
    public int getIntrinsicHeight() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getIntrinsicHeight();
        }
        return (int)mVectorState.mVPathRenderer.mBaseHeight;
    }
    
    public int getIntrinsicWidth() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getIntrinsicWidth();
        }
        return (int)mVectorState.mVPathRenderer.mBaseWidth;
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
        return -3;
    }
    
    @Override
    public /* bridge */ boolean getPadding(final Rect rect) {
        return super.getPadding(rect);
    }
    
    public float getPixelSize() {
        if ((mVectorState == null && mVectorState.mVPathRenderer == null) || mVectorState.mVPathRenderer.mBaseWidth == 0.0f || mVectorState.mVPathRenderer.mBaseHeight == 0.0f || mVectorState.mVPathRenderer.mViewportHeight == 0.0f || mVectorState.mVPathRenderer.mViewportWidth == 0.0f) {
            return 1.0f;
        }
        return Math.min(mVectorState.mVPathRenderer.mViewportWidth / mVectorState.mVPathRenderer.mBaseWidth, mVectorState.mVPathRenderer.mViewportHeight / mVectorState.mVPathRenderer.mBaseHeight);
    }
    
    @Override
    public /* bridge */ int[] getState() {
        return super.getState();
    }
    
    Object getTargetByName(final String s) {
        return mVectorState.mVPathRenderer.mVGTargetsMap.get(s);
    }
    
    @Override
    public /* bridge */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }
    
    public void inflate(final Resources resources, final XmlPullParser xmlPullParser, final AttributeSet set) throws XmlPullParserException, IOException {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.inflate(resources, xmlPullParser, set);
            return;
        }
        this.inflate(resources, xmlPullParser, set, null);
    }
    
    public void inflate(final Resources resources, final XmlPullParser xmlPullParser, final AttributeSet set, final Resources$Theme resources$Theme) throws XmlPullParserException, IOException {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.inflate(this.mDelegateDrawable, resources, xmlPullParser, set, resources$Theme);
            return;
        }
        final VectorDrawableCompatState mVectorState = this.mVectorState;
        mVectorState.mVPathRenderer = new VPathRenderer();
        final TypedArray obtainAttributes = VectorDrawableCommon.obtainAttributes(resources, resources$Theme, set, AndroidResources.styleable_VectorDrawableTypeArray);
        this.updateStateFromTypedArray(obtainAttributes, xmlPullParser);
        obtainAttributes.recycle();
        mVectorState.mChangingConfigurations = this.getChangingConfigurations();
        mVectorState.mCacheDirty = true;
        this.inflateInternal(resources, xmlPullParser, set, resources$Theme);
        mTintFilter = this.updateTintFilter(mTintFilter, mVectorState.mTint, mVectorState.mTintMode);
    }
    
    public void invalidateSelf() {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.invalidateSelf();
            return;
        }
        super.invalidateSelf();
    }
    
    @Override
    public /* bridge */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }
    
    public boolean isStateful() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.isStateful();
        }
        return super.isStateful() || (mVectorState != null && mVectorState.mTint != null && mVectorState.mTint.isStateful());
    }
    
    @Override
    public /* bridge */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }
    
    public Drawable mutate() {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.mutate();
        }
        else if (!mMutated && super.mutate() == this) {
            mVectorState = new VectorDrawableCompatState(mVectorState);
            mMutated = true;
            return this;
        }
        return this;
    }
    
    protected boolean onStateChange(final int[] state) {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.setState(state);
        }
        final VectorDrawableCompatState mVectorState = this.mVectorState;
        if (mVectorState.mTint != null && mVectorState.mTintMode != null) {
            mTintFilter = this.updateTintFilter(mTintFilter, mVectorState.mTint, mVectorState.mTintMode);
            this.invalidateSelf();
            return true;
        }
        return false;
    }
    
    public void scheduleSelf(final Runnable runnable, final long n) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.scheduleSelf(runnable, n);
            return;
        }
        super.scheduleSelf(runnable, n);
    }
    
    void setAllowCaching(final boolean mAllowCaching) {
        this.mAllowCaching = mAllowCaching;
    }
    
    public void setAlpha(final int n) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setAlpha(n);
        }
        else if (mVectorState.mVPathRenderer.getRootAlpha() != n) {
            mVectorState.mVPathRenderer.setRootAlpha(n);
            this.invalidateSelf();
        }
    }
    
    @Override
    public /* bridge */ void setAutoMirrored(final boolean autoMirrored) {
        super.setAutoMirrored(autoMirrored);
    }
    
    public void setBounds(final int n, final int n2, final int n3, final int n4) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setBounds(n, n2, n3, n4);
            return;
        }
        super.setBounds(n, n2, n3, n4);
    }
    
    public void setBounds(final Rect rect) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setBounds(rect);
            return;
        }
        super.setBounds(rect);
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
        mColorFilter = colorFilter;
        this.invalidateSelf();
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
    
    public void setTint(final int n) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setTint(this.mDelegateDrawable, n);
            return;
        }
        this.setTintList(ColorStateList.valueOf(n));
    }
    
    public void setTintList(final ColorStateList mTint) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setTintList(this.mDelegateDrawable, mTint);
        }
        else {
            final VectorDrawableCompatState mVectorState = this.mVectorState;
            if (mVectorState.mTint != mTint) {
                mVectorState.mTint = mTint;
                mTintFilter = this.updateTintFilter(mTintFilter, mTint, mVectorState.mTintMode);
                this.invalidateSelf();
            }
        }
    }
    
    public void setTintMode(final PorterDuff$Mode mTintMode) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setTintMode(this.mDelegateDrawable, mTintMode);
        }
        else {
            final VectorDrawableCompatState mVectorState = this.mVectorState;
            if (mVectorState.mTintMode != mTintMode) {
                mVectorState.mTintMode = mTintMode;
                mTintFilter = this.updateTintFilter(mTintFilter, mVectorState.mTint, mTintMode);
                this.invalidateSelf();
            }
        }
    }
    
    public boolean setVisible(final boolean b, final boolean b2) {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.setVisible(b, b2);
        }
        return super.setVisible(b, b2);
    }
    
    public void unscheduleSelf(final Runnable runnable) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.unscheduleSelf(runnable);
            return;
        }
        super.unscheduleSelf(runnable);
    }
    
    PorterDuffColorFilter updateTintFilter(final PorterDuffColorFilter porterDuffColorFilter, final ColorStateList list, final PorterDuff$Mode porterDuff$Mode) {
        if (list == null || porterDuff$Mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(list.getColorForState(this.getState(), 0), porterDuff$Mode);
    }
}
