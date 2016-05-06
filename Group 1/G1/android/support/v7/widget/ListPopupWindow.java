package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.widget.AbsListView;
import android.os.SystemClock;
import android.view.ViewConfiguration;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.os.Build$VERSION;
import android.widget.PopupWindow$OnDismissListener;
import android.view.KeyEvent$DispatcherState;
import android.view.KeyEvent;
import android.widget.ListView;
import android.view.View$OnTouchListener;
import android.view.ViewParent;
import android.view.ViewGroup;
import android.view.View$MeasureSpec;
import android.view.ViewGroup$LayoutParams;
import android.util.Log;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.AbsListView$OnScrollListener;
import android.widget.AdapterView;
import android.content.res.TypedArray;
import android.support.v4.text.TextUtilsCompat;
import android.util.AttributeSet;
import android.support.v7.appcompat.R;
import android.graphics.Rect;
import android.widget.PopupWindow;
import android.database.DataSetObserver;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.AdapterView$OnItemClickListener;
import android.os.Handler;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.content.Context;
import android.widget.ListAdapter;
import java.lang.reflect.Method;

public class ListPopupWindow
{
    private static final boolean DEBUG = false;
    private static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private static final String TAG = "ListPopupWindow";
    public static final int WRAP_CONTENT = -2;
    private static Method sClipToWindowEnabledMethod;
    private static Method sGetMaxAvailableHeightMethod;
    private ListAdapter mAdapter;
    private Context mContext;
    private boolean mDropDownAlwaysVisible;
    private View mDropDownAnchorView;
    private int mDropDownGravity;
    private int mDropDownHeight;
    private int mDropDownHorizontalOffset;
    private DropDownListView mDropDownList;
    private Drawable mDropDownListHighlight;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private int mDropDownWidth;
    private int mDropDownWindowLayoutType;
    private boolean mForceIgnoreOutsideTouch;
    private final Handler mHandler;
    private final ListSelectorHider mHideSelector;
    private AdapterView$OnItemClickListener mItemClickListener;
    private AdapterView$OnItemSelectedListener mItemSelectedListener;
    private int mLayoutDirection;
    int mListItemExpandMaximum;
    private boolean mModal;
    private DataSetObserver mObserver;
    private PopupWindow mPopup;
    private int mPromptPosition;
    private View mPromptView;
    private final ResizePopupRunnable mResizePopupRunnable;
    private final PopupScrollListener mScrollListener;
    private Runnable mShowDropDownRunnable;
    private Rect mTempRect;
    private final PopupTouchInterceptor mTouchInterceptor;
    
    static {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: iconst_1       
        //     1: anewarray       Ljava/lang/Class;
        //     4: astore          5
        //     6: aload           5
        //     8: iconst_0       
        //     9: getstatic       java/lang/Boolean.TYPE:Ljava/lang/Class;
        //    12: aastore        
        //    13: ldc             Landroid/widget/PopupWindow;.class
        //    15: ldc             "setClipToScreenEnabled"
        //    17: aload           5
        //    19: invokevirtual   java/lang/Class.getDeclaredMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //    22: putstatic       android/support/v7/widget/ListPopupWindow.sClipToWindowEnabledMethod:Ljava/lang/reflect/Method;
        //    25: iconst_3       
        //    26: anewarray       Ljava/lang/Class;
        //    29: astore          4
        //    31: aload           4
        //    33: iconst_0       
        //    34: ldc             Landroid/view/View;.class
        //    36: aastore        
        //    37: aload           4
        //    39: iconst_1       
        //    40: getstatic       java/lang/Integer.TYPE:Ljava/lang/Class;
        //    43: aastore        
        //    44: aload           4
        //    46: iconst_2       
        //    47: getstatic       java/lang/Boolean.TYPE:Ljava/lang/Class;
        //    50: aastore        
        //    51: ldc             Landroid/widget/PopupWindow;.class
        //    53: ldc             "getMaxAvailableHeight"
        //    55: aload           4
        //    57: invokevirtual   java/lang/Class.getDeclaredMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //    60: putstatic       android/support/v7/widget/ListPopupWindow.sGetMaxAvailableHeightMethod:Ljava/lang/reflect/Method;
        //    63: return         
        //    64: astore_0       
        //    65: ldc             "ListPopupWindow"
        //    67: ldc             "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well."
        //    69: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)I
        //    72: pop            
        //    73: goto            25
        //    76: astore_2       
        //    77: ldc             "ListPopupWindow"
        //    79: ldc             "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well."
        //    81: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)I
        //    84: pop            
        //    85: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  0      25     64     76     Ljava/lang/NoSuchMethodException;
        //  25     63     76     86     Ljava/lang/NoSuchMethodException;
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public ListPopupWindow(final Context context) {
        this(context, null, R.attr.listPopupWindowStyle);
    }
    
    public ListPopupWindow(final Context context, final AttributeSet set) {
        this(context, set, R.attr.listPopupWindowStyle);
    }
    
    public ListPopupWindow(final Context context, final AttributeSet set, final int n) {
        this(context, set, n, 0);
    }
    
    public ListPopupWindow(final Context mContext, final AttributeSet set, final int n, final int n2) {
        super();
        mDropDownHeight = -2;
        mDropDownWidth = -2;
        mDropDownWindowLayoutType = 1002;
        mDropDownGravity = 0;
        mDropDownAlwaysVisible = false;
        mForceIgnoreOutsideTouch = false;
        mListItemExpandMaximum = Integer.MAX_VALUE;
        mPromptPosition = 0;
        mResizePopupRunnable = new ResizePopupRunnable(this);
        mTouchInterceptor = new PopupTouchInterceptor(this);
        mScrollListener = new PopupScrollListener(this);
        mHideSelector = new ListSelectorHider(this);
        mTempRect = new Rect();
        mContext = mContext;
        mHandler = new Handler(mContext.getMainLooper());
        final TypedArray obtainStyledAttributes = mContext.obtainStyledAttributes(set, R.styleable.ListPopupWindow, n, n2);
        mDropDownHorizontalOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        mDropDownVerticalOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (mDropDownVerticalOffset != 0) {
            mDropDownVerticalOffsetSet = true;
        }
        obtainStyledAttributes.recycle();
        (mPopup = new AppCompatPopupWindow(mContext, set, n)).setInputMethodMode(1);
        mLayoutDirection = TextUtilsCompat.getLayoutDirectionFromLocale(mContext.getResources().getConfiguration().locale);
    }
    
    static /* synthetic */ PopupWindow access$1100(final ListPopupWindow listPopupWindow) {
        return listPopupWindow.mPopup;
    }
    
    static /* synthetic */ ResizePopupRunnable access$1200(final ListPopupWindow listPopupWindow) {
        return listPopupWindow.mResizePopupRunnable;
    }
    
    static /* synthetic */ Handler access$1300(final ListPopupWindow listPopupWindow) {
        return listPopupWindow.mHandler;
    }
    
    static /* synthetic */ DropDownListView access$600(final ListPopupWindow listPopupWindow) {
        return listPopupWindow.mDropDownList;
    }
    
    private int buildDropDown() {
        int n;
        if (mDropDownList == null) {
            final Context mContext = this.mContext;
            mShowDropDownRunnable = new Runnable() {
                final /* synthetic */ ListPopupWindow this$0;
                
                ListPopupWindow$2() {
                    this$0 = this$0;
                    super();
                }
                
                @Override
                public void run() {
                    final View anchorView = this$0.getAnchorView();
                    if (anchorView != null && anchorView.getWindowToken() != null) {
                        this$0.show();
                    }
                }
            };
            mDropDownList = new DropDownListView(mContext, !mModal);
            if (mDropDownListHighlight != null) {
                mDropDownList.setSelector(mDropDownListHighlight);
            }
            mDropDownList.setAdapter(mAdapter);
            mDropDownList.setOnItemClickListener(mItemClickListener);
            mDropDownList.setFocusable(true);
            mDropDownList.setFocusableInTouchMode(true);
            mDropDownList.setOnItemSelectedListener((AdapterView$OnItemSelectedListener)new AdapterView$OnItemSelectedListener() {
                final /* synthetic */ ListPopupWindow this$0;
                
                ListPopupWindow$3() {
                    this$0 = this$0;
                    super();
                }
                
                public void onItemSelected(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
                    if (n != -1) {
                        final DropDownListView access$600 = mDropDownList;
                        if (access$600 != null) {
                            access$600.mListSelectionHidden = false;
                        }
                    }
                }
                
                public void onNothingSelected(final AdapterView<?> adapterView) {
                }
            });
            mDropDownList.setOnScrollListener((AbsListView$OnScrollListener)mScrollListener);
            if (mItemSelectedListener != null) {
                mDropDownList.setOnItemSelectedListener(mItemSelectedListener);
            }
            Object mDropDownList = this.mDropDownList;
            final View mPromptView = this.mPromptView;
            n = 0;
            if (mPromptView != null) {
                final LinearLayout linearLayout = new LinearLayout(mContext);
                linearLayout.setOrientation(1);
                final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-1, 0, 1.0f);
                switch (mPromptPosition) {
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + mPromptPosition);
                        break;
                    case 1:
                        linearLayout.addView((View)mDropDownList, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
                        linearLayout.addView(mPromptView);
                        break;
                    case 0:
                        linearLayout.addView(mPromptView);
                        linearLayout.addView((View)mDropDownList, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
                        break;
                }
                int n2;
                int mDropDownWidth;
                if (this.mDropDownWidth >= 0) {
                    n2 = Integer.MIN_VALUE;
                    mDropDownWidth = this.mDropDownWidth;
                }
                else {
                    n2 = 0;
                    mDropDownWidth = 0;
                }
                mPromptView.measure(View$MeasureSpec.makeMeasureSpec(mDropDownWidth, n2), 0);
                final LinearLayout$LayoutParams linearLayout$LayoutParams2 = (LinearLayout$LayoutParams)mPromptView.getLayoutParams();
                n = mPromptView.getMeasuredHeight() + linearLayout$LayoutParams2.topMargin + linearLayout$LayoutParams2.bottomMargin;
                mDropDownList = linearLayout;
            }
            mPopup.setContentView((View)mDropDownList);
        }
        else {
            final ViewGroup viewGroup = (ViewGroup)mPopup.getContentView();
            final View mPromptView2 = mPromptView;
            n = 0;
            if (mPromptView2 != null) {
                final LinearLayout$LayoutParams linearLayout$LayoutParams3 = (LinearLayout$LayoutParams)mPromptView2.getLayoutParams();
                n = mPromptView2.getMeasuredHeight() + linearLayout$LayoutParams3.topMargin + linearLayout$LayoutParams3.bottomMargin;
            }
        }
        final Drawable background = mPopup.getBackground();
        int n3;
        if (background != null) {
            background.getPadding(mTempRect);
            n3 = mTempRect.top + mTempRect.bottom;
            if (!mDropDownVerticalOffsetSet) {
                mDropDownVerticalOffset = -mTempRect.top;
            }
        }
        else {
            mTempRect.setEmpty();
            n3 = 0;
        }
        final int maxAvailableHeight = this.getMaxAvailableHeight(this.getAnchorView(), mDropDownVerticalOffset, mPopup.getInputMethodMode() == 2);
        if (mDropDownAlwaysVisible || mDropDownHeight == -1) {
            return maxAvailableHeight + n3;
        }
        int n4 = 0;
        switch (mDropDownWidth) {
            default:
                n4 = View$MeasureSpec.makeMeasureSpec(mDropDownWidth, 1073741824);
                break;
            case -2:
                n4 = View$MeasureSpec.makeMeasureSpec(mContext.getResources().getDisplayMetrics().widthPixels - (mTempRect.left + mTempRect.right), Integer.MIN_VALUE);
                break;
            case -1:
                n4 = View$MeasureSpec.makeMeasureSpec(mContext.getResources().getDisplayMetrics().widthPixels - (mTempRect.left + mTempRect.right), 1073741824);
                break;
        }
        final int measureHeightOfChildrenCompat = mDropDownList.measureHeightOfChildrenCompat(n4, 0, -1, maxAvailableHeight - n, -1);
        if (measureHeightOfChildrenCompat > 0) {
            n += n3;
        }
        return measureHeightOfChildrenCompat + n;
    }
    
    private int getMaxAvailableHeight(final View view, final int n, final boolean b) {
        if (sGetMaxAvailableHeightMethod != null) {
            try {
                return (int)sGetMaxAvailableHeightMethod.invoke(mPopup, view, n, b);
            }
            catch (Exception ex) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return mPopup.getMaxAvailableHeight(view, n);
    }
    
    private static boolean isConfirmKey(final int n) {
        return n == 66 || n == 23;
    }
    
    private void removePromptView() {
        if (mPromptView != null) {
            final ViewParent parent = mPromptView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup)parent).removeView(mPromptView);
            }
        }
    }
    
    private void setPopupClipToScreenEnabled(final boolean b) {
        if (sClipToWindowEnabledMethod == null) {
            return;
        }
        try {
            sClipToWindowEnabledMethod.invoke(mPopup, b);
        }
        catch (Exception ex) {
            Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
    }
    
    public void clearListSelection() {
        final DropDownListView mDropDownList = this.mDropDownList;
        if (mDropDownList != null) {
            mDropDownList.mListSelectionHidden = true;
            mDropDownList.requestLayout();
        }
    }
    
    public View$OnTouchListener createDragToOpenListener(final View view) {
        return (View$OnTouchListener)new ForwardingListener(view) {
            final /* synthetic */ ListPopupWindow this$0;
            
            ListPopupWindow$1(final View view) {
                this$0 = this$0;
                super(view);
            }
            
            @Override
            public ListPopupWindow getPopup() {
                return this$0;
            }
        };
    }
    
    public void dismiss() {
        mPopup.dismiss();
        this.removePromptView();
        mPopup.setContentView((View)null);
        mDropDownList = null;
        mHandler.removeCallbacks((Runnable)mResizePopupRunnable);
    }
    
    public View getAnchorView() {
        return mDropDownAnchorView;
    }
    
    public int getAnimationStyle() {
        return mPopup.getAnimationStyle();
    }
    
    public Drawable getBackground() {
        return mPopup.getBackground();
    }
    
    public int getHeight() {
        return mDropDownHeight;
    }
    
    public int getHorizontalOffset() {
        return mDropDownHorizontalOffset;
    }
    
    public int getInputMethodMode() {
        return mPopup.getInputMethodMode();
    }
    
    public ListView getListView() {
        return mDropDownList;
    }
    
    public int getPromptPosition() {
        return mPromptPosition;
    }
    
    public Object getSelectedItem() {
        if (!this.isShowing()) {
            return null;
        }
        return mDropDownList.getSelectedItem();
    }
    
    public long getSelectedItemId() {
        if (!this.isShowing()) {
            return Long.MIN_VALUE;
        }
        return mDropDownList.getSelectedItemId();
    }
    
    public int getSelectedItemPosition() {
        if (!this.isShowing()) {
            return -1;
        }
        return mDropDownList.getSelectedItemPosition();
    }
    
    public View getSelectedView() {
        if (!this.isShowing()) {
            return null;
        }
        return mDropDownList.getSelectedView();
    }
    
    public int getSoftInputMode() {
        return mPopup.getSoftInputMode();
    }
    
    public int getVerticalOffset() {
        if (!mDropDownVerticalOffsetSet) {
            return 0;
        }
        return mDropDownVerticalOffset;
    }
    
    public int getWidth() {
        return mDropDownWidth;
    }
    
    public boolean isDropDownAlwaysVisible() {
        return mDropDownAlwaysVisible;
    }
    
    public boolean isInputMethodNotNeeded() {
        return mPopup.getInputMethodMode() == 2;
    }
    
    public boolean isModal() {
        return mModal;
    }
    
    public boolean isShowing() {
        return mPopup.isShowing();
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        if (this.isShowing() && n != 62 && (mDropDownList.getSelectedItemPosition() >= 0 || !isConfirmKey(n))) {
            final int selectedItemPosition = mDropDownList.getSelectedItemPosition();
            boolean b;
            if (!mPopup.isAboveAnchor()) {
                b = true;
            }
            else {
                b = false;
            }
            final ListAdapter mAdapter = this.mAdapter;
            int lookForSelectablePosition = Integer.MAX_VALUE;
            int lookForSelectablePosition2 = Integer.MIN_VALUE;
            if (mAdapter != null) {
                final boolean allItemsEnabled = mAdapter.areAllItemsEnabled();
                if (allItemsEnabled) {
                    lookForSelectablePosition = 0;
                }
                else {
                    lookForSelectablePosition = mDropDownList.lookForSelectablePosition(0, true);
                }
                if (allItemsEnabled) {
                    lookForSelectablePosition2 = -1 + mAdapter.getCount();
                }
                else {
                    lookForSelectablePosition2 = mDropDownList.lookForSelectablePosition(-1 + mAdapter.getCount(), false);
                }
            }
            if ((b && n == 19 && selectedItemPosition <= lookForSelectablePosition) || (!b && n == 20 && selectedItemPosition >= lookForSelectablePosition2)) {
                this.clearListSelection();
                mPopup.setInputMethodMode(1);
                this.show();
            }
            else {
                mDropDownList.mListSelectionHidden = false;
                if (mDropDownList.onKeyDown(n, keyEvent)) {
                    mPopup.setInputMethodMode(2);
                    mDropDownList.requestFocusFromTouch();
                    this.show();
                    switch (n) {
                        case 19:
                        case 20:
                        case 23:
                        case 66:
                            break;
                        default:
                            return false;
                    }
                }
                else if (b && n == 20) {
                    if (selectedItemPosition == lookForSelectablePosition2) {
                        return true;
                    }
                    return false;
                }
                else {
                    if (!b && n == 19 && selectedItemPosition == lookForSelectablePosition) {
                        return true;
                    }
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public boolean onKeyPreIme(final int n, final KeyEvent keyEvent) {
        if (n == 4 && this.isShowing()) {
            final View mDropDownAnchorView = this.mDropDownAnchorView;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                final KeyEvent$DispatcherState keyDispatcherState = mDropDownAnchorView.getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.startTracking(keyEvent, (Object)this);
                }
                return true;
            }
            if (keyEvent.getAction() == 1) {
                final KeyEvent$DispatcherState keyDispatcherState2 = mDropDownAnchorView.getKeyDispatcherState();
                if (keyDispatcherState2 != null) {
                    keyDispatcherState2.handleUpEvent(keyEvent);
                }
                if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    this.dismiss();
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean onKeyUp(final int n, final KeyEvent keyEvent) {
        if (this.isShowing() && mDropDownList.getSelectedItemPosition() >= 0) {
            final boolean onKeyUp = mDropDownList.onKeyUp(n, keyEvent);
            if (onKeyUp && isConfirmKey(n)) {
                this.dismiss();
            }
            return onKeyUp;
        }
        return false;
    }
    
    public boolean performItemClick(final int n) {
        if (this.isShowing()) {
            if (mItemClickListener != null) {
                final DropDownListView mDropDownList = this.mDropDownList;
                mItemClickListener.onItemClick((AdapterView)mDropDownList, mDropDownList.getChildAt(n - mDropDownList.getFirstVisiblePosition()), n, mDropDownList.getAdapter().getItemId(n));
            }
            return true;
        }
        return false;
    }
    
    public void postShow() {
        mHandler.post(mShowDropDownRunnable);
    }
    
    public void setAdapter(final ListAdapter mAdapter) {
        if (mObserver == null) {
            mObserver = new PopupDataSetObserver(this);
        }
        else if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(mObserver);
        }
        this.mAdapter = mAdapter;
        if (this.mAdapter != null) {
            mAdapter.registerDataSetObserver(mObserver);
        }
        if (mDropDownList != null) {
            mDropDownList.setAdapter(this.mAdapter);
        }
    }
    
    public void setAnchorView(final View mDropDownAnchorView) {
        this.mDropDownAnchorView = mDropDownAnchorView;
    }
    
    public void setAnimationStyle(final int animationStyle) {
        mPopup.setAnimationStyle(animationStyle);
    }
    
    public void setBackgroundDrawable(final Drawable backgroundDrawable) {
        mPopup.setBackgroundDrawable(backgroundDrawable);
    }
    
    public void setContentWidth(final int width) {
        final Drawable background = mPopup.getBackground();
        if (background != null) {
            background.getPadding(mTempRect);
            mDropDownWidth = width + (mTempRect.left + mTempRect.right);
            return;
        }
        this.setWidth(width);
    }
    
    public void setDropDownAlwaysVisible(final boolean mDropDownAlwaysVisible) {
        this.mDropDownAlwaysVisible = mDropDownAlwaysVisible;
    }
    
    public void setDropDownGravity(final int mDropDownGravity) {
        this.mDropDownGravity = mDropDownGravity;
    }
    
    public void setForceIgnoreOutsideTouch(final boolean mForceIgnoreOutsideTouch) {
        this.mForceIgnoreOutsideTouch = mForceIgnoreOutsideTouch;
    }
    
    public void setHeight(final int mDropDownHeight) {
        this.mDropDownHeight = mDropDownHeight;
    }
    
    public void setHorizontalOffset(final int mDropDownHorizontalOffset) {
        this.mDropDownHorizontalOffset = mDropDownHorizontalOffset;
    }
    
    public void setInputMethodMode(final int inputMethodMode) {
        mPopup.setInputMethodMode(inputMethodMode);
    }
    
    void setListItemExpandMax(final int mListItemExpandMaximum) {
        this.mListItemExpandMaximum = mListItemExpandMaximum;
    }
    
    public void setListSelector(final Drawable mDropDownListHighlight) {
        this.mDropDownListHighlight = mDropDownListHighlight;
    }
    
    public void setModal(final boolean b) {
        mModal = b;
        mPopup.setFocusable(b);
    }
    
    public void setOnDismissListener(final PopupWindow$OnDismissListener onDismissListener) {
        mPopup.setOnDismissListener(onDismissListener);
    }
    
    public void setOnItemClickListener(final AdapterView$OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
    
    public void setOnItemSelectedListener(final AdapterView$OnItemSelectedListener mItemSelectedListener) {
        this.mItemSelectedListener = mItemSelectedListener;
    }
    
    public void setPromptPosition(final int mPromptPosition) {
        this.mPromptPosition = mPromptPosition;
    }
    
    public void setPromptView(final View mPromptView) {
        final boolean showing = this.isShowing();
        if (showing) {
            this.removePromptView();
        }
        this.mPromptView = mPromptView;
        if (showing) {
            this.show();
        }
    }
    
    public void setSelection(final int selection) {
        final DropDownListView mDropDownList = this.mDropDownList;
        if (this.isShowing() && mDropDownList != null) {
            mDropDownList.mListSelectionHidden = false;
            mDropDownList.setSelection(selection);
            if (Build$VERSION.SDK_INT >= 11 && mDropDownList.getChoiceMode() != 0) {
                mDropDownList.setItemChecked(selection, true);
            }
        }
    }
    
    public void setSoftInputMode(final int softInputMode) {
        mPopup.setSoftInputMode(softInputMode);
    }
    
    public void setVerticalOffset(final int mDropDownVerticalOffset) {
        this.mDropDownVerticalOffset = mDropDownVerticalOffset;
        mDropDownVerticalOffsetSet = true;
    }
    
    public void setWidth(final int mDropDownWidth) {
        this.mDropDownWidth = mDropDownWidth;
    }
    
    public void setWindowLayoutType(final int mDropDownWindowLayoutType) {
        this.mDropDownWindowLayoutType = mDropDownWindowLayoutType;
    }
    
    public void show() {
        boolean b = true;
        int n = -1;
        final int buildDropDown = this.buildDropDown();
        final boolean inputMethodNotNeeded = this.isInputMethodNotNeeded();
        PopupWindowCompat.setWindowLayoutType(mPopup, mDropDownWindowLayoutType);
        if (mPopup.isShowing()) {
            int n2;
            if (mDropDownWidth == n) {
                n2 = -1;
            }
            else if (mDropDownWidth == -2) {
                n2 = this.getAnchorView().getWidth();
            }
            else {
                n2 = mDropDownWidth;
            }
            int mDropDownHeight;
            if (this.mDropDownHeight == n) {
                if (inputMethodNotNeeded) {
                    mDropDownHeight = buildDropDown;
                }
                else {
                    mDropDownHeight = n;
                }
                if (inputMethodNotNeeded) {
                    final PopupWindow mPopup = this.mPopup;
                    int width;
                    if (mDropDownWidth == n) {
                        width = n;
                    }
                    else {
                        width = 0;
                    }
                    mPopup.setWidth(width);
                    this.mPopup.setHeight(0);
                }
                else {
                    final PopupWindow mPopup2 = mPopup;
                    int width2;
                    if (mDropDownWidth == n) {
                        width2 = n;
                    }
                    else {
                        width2 = 0;
                    }
                    mPopup2.setWidth(width2);
                    mPopup.setHeight(n);
                }
            }
            else if (this.mDropDownHeight == -2) {
                mDropDownHeight = buildDropDown;
            }
            else {
                mDropDownHeight = this.mDropDownHeight;
            }
            final PopupWindow mPopup3 = mPopup;
            final boolean mForceIgnoreOutsideTouch = this.mForceIgnoreOutsideTouch;
            boolean outsideTouchable = false;
            if (!mForceIgnoreOutsideTouch) {
                final boolean mDropDownAlwaysVisible = this.mDropDownAlwaysVisible;
                outsideTouchable = false;
                if (!mDropDownAlwaysVisible) {
                    outsideTouchable = b;
                }
            }
            mPopup3.setOutsideTouchable(outsideTouchable);
            final PopupWindow mPopup4 = mPopup;
            final View anchorView = this.getAnchorView();
            final int mDropDownHorizontalOffset = this.mDropDownHorizontalOffset;
            final int mDropDownVerticalOffset = this.mDropDownVerticalOffset;
            int n3;
            if (n2 < 0) {
                n3 = n;
            }
            else {
                n3 = n2;
            }
            if (mDropDownHeight >= 0) {
                n = mDropDownHeight;
            }
            mPopup4.update(anchorView, mDropDownHorizontalOffset, mDropDownVerticalOffset, n3, n);
        }
        else {
            int width3;
            if (mDropDownWidth == n) {
                width3 = -1;
            }
            else if (mDropDownWidth == -2) {
                width3 = this.getAnchorView().getWidth();
            }
            else {
                width3 = mDropDownWidth;
            }
            int mDropDownHeight2;
            if (mDropDownHeight == n) {
                mDropDownHeight2 = -1;
            }
            else if (mDropDownHeight == -2) {
                mDropDownHeight2 = buildDropDown;
            }
            else {
                mDropDownHeight2 = mDropDownHeight;
            }
            mPopup.setWidth(width3);
            mPopup.setHeight(mDropDownHeight2);
            this.setPopupClipToScreenEnabled(b);
            final PopupWindow mPopup5 = mPopup;
            if (mForceIgnoreOutsideTouch || mDropDownAlwaysVisible) {
                b = false;
            }
            mPopup5.setOutsideTouchable(b);
            mPopup.setTouchInterceptor((View$OnTouchListener)mTouchInterceptor);
            PopupWindowCompat.showAsDropDown(mPopup, this.getAnchorView(), mDropDownHorizontalOffset, mDropDownVerticalOffset, mDropDownGravity);
            mDropDownList.setSelection(n);
            if (!mModal || mDropDownList.isInTouchMode()) {
                this.clearListSelection();
            }
            if (!mModal) {
                mHandler.post((Runnable)mHideSelector);
            }
        }
    }
}
