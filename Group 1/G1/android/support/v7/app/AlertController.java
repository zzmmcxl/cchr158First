package android.support.v7.app;

import java.lang.ref.WeakReference;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.SimpleCursorAdapter;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ArrayAdapter;
import android.content.DialogInterface$OnKeyListener;
import android.widget.AdapterView$OnItemSelectedListener;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface$OnMultiChoiceClickListener;
import android.content.DialogInterface$OnCancelListener;
import android.database.Cursor;
import android.content.DialogInterface$OnClickListener;
import android.view.KeyEvent;
import android.util.TypedValue;
import android.widget.LinearLayout$LayoutParams;
import android.widget.FrameLayout;
import android.view.LayoutInflater;
import android.view.ViewGroup$LayoutParams;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.AbsListView$OnScrollListener;
import android.os.Build$VERSION;
import android.view.ViewParent;
import android.view.ViewStub;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.view.ViewGroup;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.support.v7.appcompat.R;
import android.content.DialogInterface;
import android.view.Window;
import android.support.v4.widget.NestedScrollView;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.ImageView;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.content.Context;
import android.os.Message;
import android.widget.Button;
import android.view.View$OnClickListener;
import android.widget.ListAdapter;

class AlertController
{
    private ListAdapter mAdapter;
    private int mAlertDialogLayout;
    private final View$OnClickListener mButtonHandler;
    private Button mButtonNegative;
    private Message mButtonNegativeMessage;
    private CharSequence mButtonNegativeText;
    private Button mButtonNeutral;
    private Message mButtonNeutralMessage;
    private CharSequence mButtonNeutralText;
    private int mButtonPanelLayoutHint;
    private int mButtonPanelSideLayout;
    private Button mButtonPositive;
    private Message mButtonPositiveMessage;
    private CharSequence mButtonPositiveText;
    private int mCheckedItem;
    private final Context mContext;
    private View mCustomTitleView;
    private final AppCompatDialog mDialog;
    private Handler mHandler;
    private Drawable mIcon;
    private int mIconId;
    private ImageView mIconView;
    private int mListItemLayout;
    private int mListLayout;
    private ListView mListView;
    private CharSequence mMessage;
    private TextView mMessageView;
    private int mMultiChoiceItemLayout;
    private NestedScrollView mScrollView;
    private int mSingleChoiceItemLayout;
    private CharSequence mTitle;
    private TextView mTitleView;
    private View mView;
    private int mViewLayoutResId;
    private int mViewSpacingBottom;
    private int mViewSpacingLeft;
    private int mViewSpacingRight;
    private boolean mViewSpacingSpecified;
    private int mViewSpacingTop;
    private final Window mWindow;
    
    public AlertController(final Context mContext, final AppCompatDialog mDialog, final Window mWindow) {
        super();
        mViewSpacingSpecified = false;
        mIconId = 0;
        mCheckedItem = -1;
        mButtonPanelLayoutHint = 0;
        mButtonHandler = (View$OnClickListener)new View$OnClickListener() {
            final /* synthetic */ AlertController this$0;
            
            AlertController$1() {
                this$0 = this$0;
                super();
            }
            
            public void onClick(final View view) {
                Message message;
                if (view == mButtonPositive && mButtonPositiveMessage != null) {
                    message = Message.obtain(mButtonPositiveMessage);
                }
                else if (view == mButtonNegative && mButtonNegativeMessage != null) {
                    message = Message.obtain(mButtonNegativeMessage);
                }
                else if (view == mButtonNeutral && mButtonNeutralMessage != null) {
                    message = Message.obtain(mButtonNeutralMessage);
                }
                else {
                    message = null;
                }
                if (message != null) {
                    message.sendToTarget();
                }
                mHandler.obtainMessage(1, (Object)mDialog).sendToTarget();
            }
        };
        mContext = mContext;
        mDialog = mDialog;
        mWindow = mWindow;
        mHandler = new ButtonHandler((DialogInterface)mDialog);
        final TypedArray obtainStyledAttributes = mContext.obtainStyledAttributes((AttributeSet)null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
        mAlertDialogLayout = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_android_layout, 0);
        mButtonPanelSideLayout = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        mListLayout = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listLayout, 0);
        mMultiChoiceItemLayout = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        mSingleChoiceItemLayout = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        mListItemLayout = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
        obtainStyledAttributes.recycle();
    }
    
    static /* synthetic */ Button access$000(final AlertController alertController) {
        return alertController.mButtonPositive;
    }
    
    static /* synthetic */ Message access$100(final AlertController alertController) {
        return alertController.mButtonPositiveMessage;
    }
    
    static /* synthetic */ ListView access$1000(final AlertController alertController) {
        return alertController.mListView;
    }
    
    static /* synthetic */ ListView access$1002(final AlertController alertController, final ListView mListView) {
        return alertController.mListView = mListView;
    }
    
    static /* synthetic */ int access$1100(final AlertController alertController) {
        return alertController.mListLayout;
    }
    
    static /* synthetic */ int access$1200(final AlertController alertController) {
        return alertController.mMultiChoiceItemLayout;
    }
    
    static /* synthetic */ int access$1300(final AlertController alertController) {
        return alertController.mSingleChoiceItemLayout;
    }
    
    static /* synthetic */ int access$1400(final AlertController alertController) {
        return alertController.mListItemLayout;
    }
    
    static /* synthetic */ ListAdapter access$1502(final AlertController alertController, final ListAdapter mAdapter) {
        return alertController.mAdapter = mAdapter;
    }
    
    static /* synthetic */ int access$1602(final AlertController alertController, final int mCheckedItem) {
        return alertController.mCheckedItem = mCheckedItem;
    }
    
    static /* synthetic */ Button access$200(final AlertController alertController) {
        return alertController.mButtonNegative;
    }
    
    static /* synthetic */ Message access$300(final AlertController alertController) {
        return alertController.mButtonNegativeMessage;
    }
    
    static /* synthetic */ Button access$400(final AlertController alertController) {
        return alertController.mButtonNeutral;
    }
    
    static /* synthetic */ Message access$500(final AlertController alertController) {
        return alertController.mButtonNeutralMessage;
    }
    
    static /* synthetic */ AppCompatDialog access$600(final AlertController alertController) {
        return alertController.mDialog;
    }
    
    static /* synthetic */ Handler access$700(final AlertController alertController) {
        return alertController.mHandler;
    }
    
    static /* synthetic */ void access$800(final View view, final View view2, final View view3) {
        manageScrollIndicators(view, view2, view3);
    }
    
    static /* synthetic */ NestedScrollView access$900(final AlertController alertController) {
        return alertController.mScrollView;
    }
    
    static boolean canTextInput(final View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        final ViewGroup viewGroup = (ViewGroup)view;
        int i = viewGroup.getChildCount();
        while (i > 0) {
            --i;
            if (canTextInput(viewGroup.getChildAt(i))) {
                return true;
            }
        }
        return false;
    }
    
    private static void manageScrollIndicators(final View view, final View view2, final View view3) {
        if (view2 != null) {
            int visibility;
            if (ViewCompat.canScrollVertically(view, -1)) {
                visibility = 0;
            }
            else {
                visibility = 4;
            }
            view2.setVisibility(visibility);
        }
        if (view3 != null) {
            final boolean canScrollVertically = ViewCompat.canScrollVertically(view, 1);
            int visibility2 = 0;
            if (!canScrollVertically) {
                visibility2 = 4;
            }
            view3.setVisibility(visibility2);
        }
    }
    
    @Nullable
    private ViewGroup resolvePanel(@Nullable View inflate, @Nullable View inflate2) {
        if (inflate == null) {
            if (inflate2 instanceof ViewStub) {
                inflate2 = ((ViewStub)inflate2).inflate();
            }
            return (ViewGroup)inflate2;
        }
        if (inflate2 != null) {
            final ViewParent parent = inflate2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup)parent).removeView(inflate2);
            }
        }
        if (inflate instanceof ViewStub) {
            inflate = ((ViewStub)inflate).inflate();
        }
        return (ViewGroup)inflate;
    }
    
    private int selectContentView() {
        if (mButtonPanelSideLayout == 0) {
            return mAlertDialogLayout;
        }
        if (mButtonPanelLayoutHint == 1) {
            return mButtonPanelSideLayout;
        }
        return mAlertDialogLayout;
    }
    
    private void setScrollIndicators(final ViewGroup viewGroup, final View view, final int n, final int n2) {
        View viewById = mWindow.findViewById(R.id.scrollIndicatorUp);
        View viewById2 = mWindow.findViewById(R.id.scrollIndicatorDown);
        if (Build$VERSION.SDK_INT >= 23) {
            ViewCompat.setScrollIndicators(view, n, n2);
            if (viewById != null) {
                viewGroup.removeView(viewById);
            }
            if (viewById2 != null) {
                viewGroup.removeView(viewById2);
            }
        }
        else {
            if (viewById != null && (n & 0x1) == 0x0) {
                viewGroup.removeView(viewById);
                viewById = null;
            }
            if (viewById2 != null && (n & 0x2) == 0x0) {
                viewGroup.removeView(viewById2);
                viewById2 = null;
            }
            if (viewById != null || viewById2 != null) {
                final View view2 = viewById;
                final View view3 = viewById2;
                if (mMessage != null) {
                    mScrollView.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener)new NestedScrollView.OnScrollChangeListener() {
                        final /* synthetic */ AlertController this$0;
                        final /* synthetic */ View val$bottom;
                        final /* synthetic */ View val$top;
                        
                        AlertController$2() {
                            this$0 = this$0;
                            super();
                        }
                        
                        @Override
                        public void onScrollChange(final NestedScrollView nestedScrollView, final int n, final int n2, final int n3, final int n4) {
                            manageScrollIndicators((View)nestedScrollView, view2, view3);
                        }
                    });
                    mScrollView.post((Runnable)new Runnable() {
                        final /* synthetic */ AlertController this$0;
                        final /* synthetic */ View val$bottom;
                        final /* synthetic */ View val$top;
                        
                        AlertController$3() {
                            this$0 = this$0;
                            super();
                        }
                        
                        @Override
                        public void run() {
                            manageScrollIndicators((View)mScrollView, view2, view3);
                        }
                    });
                    return;
                }
                if (mListView != null) {
                    mListView.setOnScrollListener((AbsListView$OnScrollListener)new AbsListView$OnScrollListener() {
                        final /* synthetic */ AlertController this$0;
                        final /* synthetic */ View val$bottom;
                        final /* synthetic */ View val$top;
                        
                        AlertController$4() {
                            this$0 = this$0;
                            super();
                        }
                        
                        public void onScroll(final AbsListView absListView, final int n, final int n2, final int n3) {
                            manageScrollIndicators((View)absListView, view2, view3);
                        }
                        
                        public void onScrollStateChanged(final AbsListView absListView, final int n) {
                        }
                    });
                    mListView.post((Runnable)new Runnable() {
                        final /* synthetic */ AlertController this$0;
                        final /* synthetic */ View val$bottom;
                        final /* synthetic */ View val$top;
                        
                        AlertController$5() {
                            this$0 = this$0;
                            super();
                        }
                        
                        @Override
                        public void run() {
                            manageScrollIndicators((View)mListView, view2, view3);
                        }
                    });
                    return;
                }
                if (view2 != null) {
                    viewGroup.removeView(view2);
                }
                if (view3 != null) {
                    viewGroup.removeView(view3);
                }
            }
        }
    }
    
    private void setupButtons(final ViewGroup viewGroup) {
        int n = 0;
        (mButtonPositive = (Button)viewGroup.findViewById(16908313)).setOnClickListener(mButtonHandler);
        if (TextUtils.isEmpty(mButtonPositiveText)) {
            mButtonPositive.setVisibility(8);
        }
        else {
            mButtonPositive.setText(mButtonPositiveText);
            mButtonPositive.setVisibility(0);
            n = ((false | true) ? 1 : 0);
        }
        (mButtonNegative = (Button)viewGroup.findViewById(16908314)).setOnClickListener(mButtonHandler);
        if (TextUtils.isEmpty(mButtonNegativeText)) {
            mButtonNegative.setVisibility(8);
        }
        else {
            mButtonNegative.setText(mButtonNegativeText);
            mButtonNegative.setVisibility(0);
            n |= 0x2;
        }
        (mButtonNeutral = (Button)viewGroup.findViewById(16908315)).setOnClickListener(mButtonHandler);
        if (TextUtils.isEmpty(mButtonNeutralText)) {
            mButtonNeutral.setVisibility(8);
        }
        else {
            mButtonNeutral.setText(mButtonNeutralText);
            mButtonNeutral.setVisibility(0);
            n |= 0x4;
        }
        boolean b = false;
        if (n != 0) {
            b = true;
        }
        if (!b) {
            viewGroup.setVisibility(8);
        }
    }
    
    private void setupContent(final ViewGroup viewGroup) {
        (mScrollView = (NestedScrollView)mWindow.findViewById(R.id.scrollView)).setFocusable(false);
        mScrollView.setNestedScrollingEnabled(false);
        mMessageView = (TextView)viewGroup.findViewById(16908299);
        if (mMessageView == null) {
            return;
        }
        if (mMessage != null) {
            mMessageView.setText(mMessage);
            return;
        }
        mMessageView.setVisibility(8);
        mScrollView.removeView((View)mMessageView);
        if (mListView != null) {
            final ViewGroup viewGroup2 = (ViewGroup)mScrollView.getParent();
            final int indexOfChild = viewGroup2.indexOfChild((View)mScrollView);
            viewGroup2.removeViewAt(indexOfChild);
            viewGroup2.addView((View)mListView, indexOfChild, new ViewGroup$LayoutParams(-1, -1));
            return;
        }
        viewGroup.setVisibility(8);
    }
    
    private void setupCustomContent(final ViewGroup viewGroup) {
        View view;
        if (mView != null) {
            view = mView;
        }
        else if (mViewLayoutResId != 0) {
            view = LayoutInflater.from(mContext).inflate(mViewLayoutResId, viewGroup, false);
        }
        else {
            view = null;
        }
        boolean b = false;
        if (view != null) {
            b = true;
        }
        if (!b || !canTextInput(view)) {
            mWindow.setFlags(131072, 131072);
        }
        if (b) {
            final FrameLayout frameLayout = (FrameLayout)mWindow.findViewById(R.id.custom);
            frameLayout.addView(view, new ViewGroup$LayoutParams(-1, -1));
            if (mViewSpacingSpecified) {
                frameLayout.setPadding(mViewSpacingLeft, mViewSpacingTop, mViewSpacingRight, mViewSpacingBottom);
            }
            if (mListView != null) {
                ((LinearLayout$LayoutParams)viewGroup.getLayoutParams()).weight = 0.0f;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }
    
    private void setupTitle(final ViewGroup viewGroup) {
        if (mCustomTitleView != null) {
            viewGroup.addView(mCustomTitleView, 0, new ViewGroup$LayoutParams(-1, -2));
            mWindow.findViewById(R.id.title_template).setVisibility(8);
            return;
        }
        mIconView = (ImageView)mWindow.findViewById(16908294);
        final boolean empty = TextUtils.isEmpty(mTitle);
        boolean b = false;
        if (!empty) {
            b = true;
        }
        if (!b) {
            mWindow.findViewById(R.id.title_template).setVisibility(8);
            mIconView.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        (mTitleView = (TextView)mWindow.findViewById(R.id.alertTitle)).setText(mTitle);
        if (mIconId != 0) {
            mIconView.setImageResource(mIconId);
            return;
        }
        if (mIcon != null) {
            mIconView.setImageDrawable(mIcon);
            return;
        }
        mTitleView.setPadding(mIconView.getPaddingLeft(), mIconView.getPaddingTop(), mIconView.getPaddingRight(), mIconView.getPaddingBottom());
        mIconView.setVisibility(8);
    }
    
    private void setupView() {
        final View viewById = mWindow.findViewById(R.id.parentPanel);
        final View viewById2 = viewById.findViewById(R.id.topPanel);
        final View viewById3 = viewById.findViewById(R.id.contentPanel);
        final View viewById4 = viewById.findViewById(R.id.buttonPanel);
        final ViewGroup viewGroup = (ViewGroup)viewById.findViewById(R.id.customPanel);
        this.setupCustomContent(viewGroup);
        final View viewById5 = viewGroup.findViewById(R.id.topPanel);
        final View viewById6 = viewGroup.findViewById(R.id.contentPanel);
        final View viewById7 = viewGroup.findViewById(R.id.buttonPanel);
        final ViewGroup resolvePanel = this.resolvePanel(viewById5, viewById2);
        final ViewGroup resolvePanel2 = this.resolvePanel(viewById6, viewById3);
        final ViewGroup resolvePanel3 = this.resolvePanel(viewById7, viewById4);
        this.setupContent(resolvePanel2);
        this.setupButtons(resolvePanel3);
        this.setupTitle(resolvePanel);
        int n;
        if (viewGroup != null && viewGroup.getVisibility() != 8) {
            n = 1;
        }
        else {
            n = 0;
        }
        boolean b;
        if (resolvePanel != null && resolvePanel.getVisibility() != 8) {
            b = true;
        }
        else {
            b = false;
        }
        boolean b2;
        if (resolvePanel3 != null && resolvePanel3.getVisibility() != 8) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        if (!b2 && resolvePanel2 != null) {
            final View viewById8 = resolvePanel2.findViewById(R.id.textSpacerNoButtons);
            if (viewById8 != null) {
                viewById8.setVisibility(0);
            }
        }
        if (b && mScrollView != null) {
            mScrollView.setClipToPadding(true);
        }
        if (n == 0) {
            Object o;
            if (mListView != null) {
                o = mListView;
            }
            else {
                o = mScrollView;
            }
            if (o != null) {
                boolean b3;
                if (b) {
                    b3 = true;
                }
                else {
                    b3 = false;
                }
                int n2;
                if (b2) {
                    n2 = 2;
                }
                else {
                    n2 = 0;
                }
                this.setScrollIndicators(resolvePanel2, (View)o, (b3 ? 1 : 0) | n2, 3);
            }
        }
        final ListView mListView = this.mListView;
        if (mListView != null && mAdapter != null) {
            mListView.setAdapter(mAdapter);
            final int mCheckedItem = this.mCheckedItem;
            if (mCheckedItem > -1) {
                mListView.setItemChecked(mCheckedItem, true);
                mListView.setSelection(mCheckedItem);
            }
        }
    }
    
    public Button getButton(final int n) {
        switch (n) {
            default:
                return null;
            case -1:
                return mButtonPositive;
            case -2:
                return mButtonNegative;
            case -3:
                return mButtonNeutral;
        }
    }
    
    public int getIconAttributeResId(final int n) {
        final TypedValue typedValue = new TypedValue();
        mContext.getTheme().resolveAttribute(n, typedValue, true);
        return typedValue.resourceId;
    }
    
    public ListView getListView() {
        return mListView;
    }
    
    public void installContent() {
        mDialog.supportRequestWindowFeature(1);
        mDialog.setContentView(this.selectContentView());
        this.setupView();
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        return mScrollView != null && mScrollView.executeKeyEvent(keyEvent);
    }
    
    public boolean onKeyUp(final int n, final KeyEvent keyEvent) {
        return mScrollView != null && mScrollView.executeKeyEvent(keyEvent);
    }
    
    public void setButton(final int n, final CharSequence mButtonNeutralText, final DialogInterface$OnClickListener dialogInterface$OnClickListener, Message obtainMessage) {
        if (obtainMessage == null && dialogInterface$OnClickListener != null) {
            obtainMessage = mHandler.obtainMessage(n, (Object)dialogInterface$OnClickListener);
        }
        switch (n) {
            default:
                throw new IllegalArgumentException("Button does not exist");
            case -1:
                mButtonPositiveText = mButtonNeutralText;
                mButtonPositiveMessage = obtainMessage;
            case -2:
                mButtonNegativeText = mButtonNeutralText;
                mButtonNegativeMessage = obtainMessage;
            case -3:
                this.mButtonNeutralText = mButtonNeutralText;
                mButtonNeutralMessage = obtainMessage;
        }
    }
    
    public void setButtonPanelLayoutHint(final int mButtonPanelLayoutHint) {
        this.mButtonPanelLayoutHint = mButtonPanelLayoutHint;
    }
    
    public void setCustomTitle(final View mCustomTitleView) {
        this.mCustomTitleView = mCustomTitleView;
    }
    
    public void setIcon(final int mIconId) {
        mIcon = null;
        this.mIconId = mIconId;
        if (mIconView != null) {
            if (mIconId == 0) {
                mIconView.setVisibility(8);
                return;
            }
            mIconView.setVisibility(0);
            mIconView.setImageResource(this.mIconId);
        }
    }
    
    public void setIcon(final Drawable drawable) {
        mIcon = drawable;
        mIconId = 0;
        if (mIconView != null) {
            if (drawable == null) {
                mIconView.setVisibility(8);
                return;
            }
            mIconView.setVisibility(0);
            mIconView.setImageDrawable(drawable);
        }
    }
    
    public void setMessage(final CharSequence charSequence) {
        mMessage = charSequence;
        if (mMessageView != null) {
            mMessageView.setText(charSequence);
        }
    }
    
    public void setTitle(final CharSequence charSequence) {
        mTitle = charSequence;
        if (mTitleView != null) {
            mTitleView.setText(charSequence);
        }
    }
    
    public void setView(final int mViewLayoutResId) {
        mView = null;
        this.mViewLayoutResId = mViewLayoutResId;
        mViewSpacingSpecified = false;
    }
    
    public void setView(final View mView) {
        this.mView = mView;
        mViewLayoutResId = 0;
        mViewSpacingSpecified = false;
    }
    
    public void setView(final View mView, final int mViewSpacingLeft, final int mViewSpacingTop, final int mViewSpacingRight, final int mViewSpacingBottom) {
        this.mView = mView;
        mViewLayoutResId = 0;
        mViewSpacingSpecified = true;
        this.mViewSpacingLeft = mViewSpacingLeft;
        this.mViewSpacingTop = mViewSpacingTop;
        this.mViewSpacingRight = mViewSpacingRight;
        this.mViewSpacingBottom = mViewSpacingBottom;
    }
}
