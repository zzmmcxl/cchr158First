package android.support.v7.widget;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow$OnDismissListener;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.support.v4.view.ViewCompat;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;
import android.database.DataSetObserver;
import android.widget.ThemedSpinnerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.annotation.DrawableRes;
import android.widget.ListAdapter;
import android.widget.Adapter;
import android.view.MotionEvent;
import android.graphics.PorterDuff$Mode;
import android.support.annotation.Nullable;
import android.content.res.ColorStateList;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.View$MeasureSpec;
import android.graphics.drawable.Drawable;
import android.content.res.TypedArray;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.support.v7.view.ContextThemeWrapper;
import android.view.View;
import android.content.res.Resources$Theme;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.os.Build$VERSION;
import android.graphics.Rect;
import android.widget.SpinnerAdapter;
import android.content.Context;
import android.support.v4.view.TintableBackgroundView;
import android.widget.Spinner;

public class AppCompatSpinner extends Spinner implements TintableBackgroundView
{
    private static final int[] ATTRS_ANDROID_SPINNERMODE;
    private static final boolean IS_AT_LEAST_JB = false;
    private static final boolean IS_AT_LEAST_M = false;
    private static final int MAX_ITEMS_MEASURED = 15;
    private static final int MODE_DIALOG = 0;
    private static final int MODE_DROPDOWN = 1;
    private static final int MODE_THEME = -1;
    private static final String TAG = "AppCompatSpinner";
    private AppCompatBackgroundHelper mBackgroundTintHelper;
    private AppCompatDrawableManager mDrawableManager;
    private int mDropDownWidth;
    private ListPopupWindow.ForwardingListener mForwardingListener;
    private DropdownPopup mPopup;
    private Context mPopupContext;
    private boolean mPopupSet;
    private SpinnerAdapter mTempAdapter;
    private final Rect mTempRect;
    
    static {
        ATTRS_ANDROID_SPINNERMODE = new int[] { 16843505 };
    }
    
    public AppCompatSpinner(final Context context) {
        this(context, null);
    }
    
    public AppCompatSpinner(final Context context, final int n) {
        this(context, null, R.attr.spinnerStyle, n);
    }
    
    public AppCompatSpinner(final Context context, final AttributeSet set) {
        this(context, set, R.attr.spinnerStyle);
    }
    
    public AppCompatSpinner(final Context context, final AttributeSet set, final int n) {
        this(context, set, n, -1);
    }
    
    public AppCompatSpinner(final Context context, final AttributeSet set, final int n, final int n2) {
        this(context, set, n, n2, null);
    }
    
    public AppCompatSpinner(final Context context, final AttributeSet set, final int n, int int1, final Resources$Theme resources$Theme) {
        super(context, set, n);
        mTempRect = new Rect();
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, set, R.styleable.Spinner, n, 0);
        mDrawableManager = AppCompatDrawableManager.get();
        mBackgroundTintHelper = new AppCompatBackgroundHelper((View)this, mDrawableManager);
    Label_0140:
        while (true) {
            Label_0327: {
                if (resources$Theme == null) {
                    break Label_0327;
                }
                mPopupContext = (Context)new ContextThemeWrapper(context, resources$Theme);
                TypedArray obtainStyledAttributes2;
                DropdownPopup mPopup;
                TintTypedArray obtainStyledAttributes3;
                CharSequence[] textArray;
                ArrayAdapter adapter;
                int resourceId;
                Context mPopupContext;
                Block_12_Outer:Label_0369_Outer:
                while (true) {
                    Label_0243: {
                        if (this.mPopupContext == null) {
                            break Label_0243;
                        }
                        if (int1 != -1) {
                            break Label_0140;
                        }
                        if (Build$VERSION.SDK_INT < 11) {
                            break Label_0327;
                        }
                        obtainStyledAttributes2 = null;
                        try {
                            obtainStyledAttributes2 = context.obtainStyledAttributes(set, ATTRS_ANDROID_SPINNERMODE, n, 0);
                            if (obtainStyledAttributes2.hasValue(0)) {
                                int1 = obtainStyledAttributes2.getInt(0, 0);
                            }
                            if (obtainStyledAttributes2 != null) {
                                obtainStyledAttributes2.recycle();
                            }
                            if (int1 == 1) {
                                mPopup = new DropdownPopup(this.mPopupContext, set, n);
                                obtainStyledAttributes3 = TintTypedArray.obtainStyledAttributes(this.mPopupContext, set, R.styleable.Spinner, n, 0);
                                mDropDownWidth = obtainStyledAttributes3.getLayoutDimension(R.styleable.Spinner_android_dropDownWidth, -2);
                                mPopup.setBackgroundDrawable(obtainStyledAttributes3.getDrawable(R.styleable.Spinner_android_popupBackground));
                                mPopup.setPromptText(obtainStyledAttributes.getString(R.styleable.Spinner_android_prompt));
                                obtainStyledAttributes3.recycle();
                                this.mPopup = mPopup;
                                mForwardingListener = new ListPopupWindow.ForwardingListener(this) {
                                    final /* synthetic */ AppCompatSpinner this$0;
                                    final /* synthetic */ DropdownPopup val$popup;
                                    
                                    AppCompatSpinner$1(final View view) {
                                        this$0 = this$0;
                                        super(view);
                                    }
                                    
                                    @Override
                                    public ListPopupWindow getPopup() {
                                        return mPopup;
                                    }
                                    
                                    public boolean onForwardingStarted() {
                                        if (!this$0.mPopup.isShowing()) {
                                            this$0.mPopup.show();
                                        }
                                        return true;
                                    }
                                };
                            }
                            textArray = obtainStyledAttributes.getTextArray(R.styleable.Spinner_android_entries);
                            if (textArray != null) {
                                adapter = new ArrayAdapter(context, R.layout.support_simple_spinner_dropdown_item, (Object[])textArray);
                                adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                                this.setAdapter((SpinnerAdapter)adapter);
                            }
                            obtainStyledAttributes.recycle();
                            mPopupSet = true;
                            if (mTempAdapter != null) {
                                this.setAdapter(mTempAdapter);
                                mTempAdapter = null;
                            }
                            mBackgroundTintHelper.loadFromAttributes(set, n);
                            return;
                            // iftrue(Label_0360:, resourceId == 0)
                            while (true) {
                                this.mPopupContext = (Context)new ContextThemeWrapper(context, resourceId);
                                continue Block_12_Outer;
                                resourceId = obtainStyledAttributes.getResourceId(R.styleable.Spinner_popupTheme, 0);
                                continue Label_0369_Outer;
                            }
                            Label_0360: {
                                mPopupContext = context;
                            }
                            // iftrue(Label_0378:, AppCompatSpinner.IS_AT_LEAST_M)
                            while (true) {
                                this.mPopupContext = mPopupContext;
                                continue Block_12_Outer;
                                Label_0378: {
                                    mPopupContext = null;
                                }
                                continue;
                            }
                        }
                        catch (Exception ex) {
                            Log.i("AppCompatSpinner", "Could not read android:spinnerMode", (Throwable)ex);
                            if (obtainStyledAttributes2 != null) {
                                obtainStyledAttributes2.recycle();
                            }
                            continue Label_0140;
                        }
                        finally {
                            if (obtainStyledAttributes2 != null) {
                                obtainStyledAttributes2.recycle();
                            }
                        }
                    }
                    break;
                }
            }
            int1 = 1;
            continue Label_0140;
        }
    }
    
    static /* synthetic */ DropdownPopup access$000(final AppCompatSpinner appCompatSpinner) {
        return appCompatSpinner.mPopup;
    }
    
    static /* synthetic */ boolean access$100() {
        return IS_AT_LEAST_M;
    }
    
    static /* synthetic */ Rect access$300(final AppCompatSpinner appCompatSpinner) {
        return appCompatSpinner.mTempRect;
    }
    
    static /* synthetic */ int access$400(final AppCompatSpinner appCompatSpinner) {
        return appCompatSpinner.mDropDownWidth;
    }
    
    static /* synthetic */ int access$500(final AppCompatSpinner appCompatSpinner, final SpinnerAdapter spinnerAdapter, final Drawable drawable) {
        return appCompatSpinner.compatMeasureContentWidth(spinnerAdapter, drawable);
    }
    
    private int compatMeasureContentWidth(final SpinnerAdapter spinnerAdapter, final Drawable drawable) {
        int max;
        if (spinnerAdapter == null) {
            max = 0;
        }
        else {
            max = 0;
            View view = null;
            int n = 0;
            final int measureSpec = View$MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 0);
            final int measureSpec2 = View$MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), 0);
            final int max2 = Math.max(0, this.getSelectedItemPosition());
            for (int min = Math.min(spinnerAdapter.getCount(), max2 + 15), i = Math.max(0, max2 - (15 - (min - max2))); i < min; ++i) {
                final int itemViewType = spinnerAdapter.getItemViewType(i);
                if (itemViewType != n) {
                    n = itemViewType;
                    view = null;
                }
                view = spinnerAdapter.getView(i, view, (ViewGroup)this);
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new ViewGroup$LayoutParams(-2, -2));
                }
                view.measure(measureSpec, measureSpec2);
                max = Math.max(max, view.getMeasuredWidth());
            }
            if (drawable != null) {
                drawable.getPadding(mTempRect);
                return max + (mTempRect.left + mTempRect.right);
            }
        }
        return max;
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.applySupportBackgroundTint();
        }
    }
    
    public int getDropDownHorizontalOffset() {
        if (mPopup != null) {
            return mPopup.getHorizontalOffset();
        }
        if (IS_AT_LEAST_JB) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }
    
    public int getDropDownVerticalOffset() {
        if (mPopup != null) {
            return mPopup.getVerticalOffset();
        }
        if (IS_AT_LEAST_JB) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }
    
    public int getDropDownWidth() {
        if (mPopup != null) {
            return mDropDownWidth;
        }
        if (IS_AT_LEAST_JB) {
            return super.getDropDownWidth();
        }
        return 0;
    }
    
    public Drawable getPopupBackground() {
        if (mPopup != null) {
            return mPopup.getBackground();
        }
        if (IS_AT_LEAST_JB) {
            return super.getPopupBackground();
        }
        return null;
    }
    
    public Context getPopupContext() {
        if (mPopup != null) {
            return mPopupContext;
        }
        if (IS_AT_LEAST_M) {
            return super.getPopupContext();
        }
        return null;
    }
    
    public CharSequence getPrompt() {
        if (mPopup != null) {
            return mPopup.getHintText();
        }
        return super.getPrompt();
    }
    
    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        if (mBackgroundTintHelper != null) {
            return mBackgroundTintHelper.getSupportBackgroundTintList();
        }
        return null;
    }
    
    @Nullable
    public PorterDuff$Mode getSupportBackgroundTintMode() {
        if (mBackgroundTintHelper != null) {
            return mBackgroundTintHelper.getSupportBackgroundTintMode();
        }
        return null;
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mPopup != null && mPopup.isShowing()) {
            mPopup.dismiss();
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n2);
        if (mPopup != null && View$MeasureSpec.getMode(n) == Integer.MIN_VALUE) {
            this.setMeasuredDimension(Math.min(Math.max(this.getMeasuredWidth(), this.compatMeasureContentWidth(this.getAdapter(), this.getBackground())), View$MeasureSpec.getSize(n)), this.getMeasuredHeight());
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        return (mForwardingListener != null && mForwardingListener.onTouch((View)this, motionEvent)) || super.onTouchEvent(motionEvent);
    }
    
    public boolean performClick() {
        if (mPopup != null && !mPopup.isShowing()) {
            mPopup.show();
            return true;
        }
        return super.performClick();
    }
    
    public /* bridge */ void setAdapter(final Adapter adapter) {
        this.setAdapter((SpinnerAdapter)adapter);
    }
    
    public void setAdapter(final SpinnerAdapter spinnerAdapter) {
        if (!mPopupSet) {
            mTempAdapter = spinnerAdapter;
        }
        else {
            super.setAdapter(spinnerAdapter);
            if (mPopup != null) {
                Context context;
                if (mPopupContext == null) {
                    context = this.getContext();
                }
                else {
                    context = mPopupContext;
                }
                mPopup.setAdapter((ListAdapter)new DropDownAdapter(spinnerAdapter, context.getTheme()));
            }
        }
    }
    
    public void setBackgroundDrawable(final Drawable backgroundDrawable) {
        super.setBackgroundDrawable(backgroundDrawable);
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.onSetBackgroundDrawable(backgroundDrawable);
        }
    }
    
    public void setBackgroundResource(@DrawableRes final int backgroundResource) {
        super.setBackgroundResource(backgroundResource);
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.onSetBackgroundResource(backgroundResource);
        }
    }
    
    public void setDropDownHorizontalOffset(final int n) {
        if (mPopup != null) {
            mPopup.setHorizontalOffset(n);
        }
        else if (IS_AT_LEAST_JB) {
            super.setDropDownHorizontalOffset(n);
        }
    }
    
    public void setDropDownVerticalOffset(final int n) {
        if (mPopup != null) {
            mPopup.setVerticalOffset(n);
        }
        else if (IS_AT_LEAST_JB) {
            super.setDropDownVerticalOffset(n);
        }
    }
    
    public void setDropDownWidth(final int n) {
        if (mPopup != null) {
            mDropDownWidth = n;
        }
        else if (IS_AT_LEAST_JB) {
            super.setDropDownWidth(n);
        }
    }
    
    public void setPopupBackgroundDrawable(final Drawable drawable) {
        if (mPopup != null) {
            mPopup.setBackgroundDrawable(drawable);
        }
        else if (IS_AT_LEAST_JB) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }
    
    public void setPopupBackgroundResource(@DrawableRes final int n) {
        this.setPopupBackgroundDrawable(ContextCompat.getDrawable(this.getPopupContext(), n));
    }
    
    public void setPrompt(final CharSequence charSequence) {
        if (mPopup != null) {
            mPopup.setPromptText(charSequence);
            return;
        }
        super.setPrompt(charSequence);
    }
    
    public void setSupportBackgroundTintList(@Nullable final ColorStateList supportBackgroundTintList) {
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.setSupportBackgroundTintList(supportBackgroundTintList);
        }
    }
    
    public void setSupportBackgroundTintMode(@Nullable final PorterDuff$Mode supportBackgroundTintMode) {
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.setSupportBackgroundTintMode(supportBackgroundTintMode);
        }
    }
}
