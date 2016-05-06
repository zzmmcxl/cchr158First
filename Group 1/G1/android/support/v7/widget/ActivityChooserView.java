package android.support.v7.widget;

import android.widget.AdapterView;
import android.content.Intent;
import android.support.v4.view.ViewCompat;
import android.widget.TextView;
import android.widget.BaseAdapter;
import android.view.View$MeasureSpec;
import android.view.ViewTreeObserver;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.ListAdapter;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View$OnTouchListener;
import android.view.View;
import android.view.View$OnLongClickListener;
import android.view.View$OnClickListener;
import android.view.LayoutInflater;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.content.Context;
import android.support.v4.view.ActionProvider;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.widget.PopupWindow$OnDismissListener;
import android.database.DataSetObserver;
import android.widget.ImageView;
import android.widget.FrameLayout;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;

public class ActivityChooserView extends ViewGroup implements ActivityChooserModelClient
{
    private static final String LOG_TAG = "ActivityChooserView";
    private final LinearLayoutCompat mActivityChooserContent;
    private final Drawable mActivityChooserContentBackground;
    private final ActivityChooserViewAdapter mAdapter;
    private final Callbacks mCallbacks;
    private int mDefaultActionButtonContentDescription;
    private final FrameLayout mDefaultActivityButton;
    private final ImageView mDefaultActivityButtonImage;
    private final FrameLayout mExpandActivityOverflowButton;
    private final ImageView mExpandActivityOverflowButtonImage;
    private int mInitialActivityCount;
    private boolean mIsAttachedToWindow;
    private boolean mIsSelectingDefaultActivity;
    private final int mListPopupMaxWidth;
    private ListPopupWindow mListPopupWindow;
    private final DataSetObserver mModelDataSetOberver;
    private PopupWindow$OnDismissListener mOnDismissListener;
    private final ViewTreeObserver$OnGlobalLayoutListener mOnGlobalLayoutListener;
    ActionProvider mProvider;
    
    public ActivityChooserView(final Context context) {
        this(context, null);
    }
    
    public ActivityChooserView(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public ActivityChooserView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        mModelDataSetOberver = new DataSetObserver() {
            final /* synthetic */ ActivityChooserView this$0;
            
            ActivityChooserView$1() {
                this$0 = this$0;
                super();
            }
            
            public void onChanged() {
                super.onChanged();
                mAdapter.notifyDataSetChanged();
            }
            
            public void onInvalidated() {
                super.onInvalidated();
                mAdapter.notifyDataSetInvalidated();
            }
        };
        mOnGlobalLayoutListener = (ViewTreeObserver$OnGlobalLayoutListener)new ViewTreeObserver$OnGlobalLayoutListener() {
            final /* synthetic */ ActivityChooserView this$0;
            
            ActivityChooserView$2() {
                this$0 = this$0;
                super();
            }
            
            public void onGlobalLayout() {
                if (this$0.isShowingPopup()) {
                    if (!this$0.isShown()) {
                        this$0.getListPopupWindow().dismiss();
                    }
                    else {
                        this$0.getListPopupWindow().show();
                        if (mProvider != null) {
                            mProvider.subUiVisibilityChanged(true);
                        }
                    }
                }
            }
        };
        mInitialActivityCount = 4;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.ActivityChooserView, n, 0);
        mInitialActivityCount = obtainStyledAttributes.getInt(R.styleable.ActivityChooserView_initialActivityCount, 4);
        final Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(this.getContext()).inflate(R.layout.abc_activity_chooser_view, (ViewGroup)this, true);
        mCallbacks = new Callbacks(this);
        mActivityChooserContent = (LinearLayoutCompat)this.findViewById(R.id.activity_chooser_view_content);
        mActivityChooserContentBackground = mActivityChooserContent.getBackground();
        (mDefaultActivityButton = (FrameLayout)this.findViewById(R.id.default_activity_button)).setOnClickListener((View$OnClickListener)mCallbacks);
        mDefaultActivityButton.setOnLongClickListener((View$OnLongClickListener)mCallbacks);
        mDefaultActivityButtonImage = (ImageView)mDefaultActivityButton.findViewById(R.id.image);
        final FrameLayout mExpandActivityOverflowButton = (FrameLayout)this.findViewById(R.id.expand_activities_button);
        mExpandActivityOverflowButton.setOnClickListener((View$OnClickListener)mCallbacks);
        mExpandActivityOverflowButton.setOnTouchListener((View$OnTouchListener)new ListPopupWindow.ForwardingListener(mExpandActivityOverflowButton) {
            final /* synthetic */ ActivityChooserView this$0;
            
            ActivityChooserView$3(final View view) {
                this$0 = this$0;
                super(view);
            }
            
            @Override
            public ListPopupWindow getPopup() {
                return this$0.getListPopupWindow();
            }
            
            @Override
            protected boolean onForwardingStarted() {
                this$0.showPopup();
                return true;
            }
            
            @Override
            protected boolean onForwardingStopped() {
                this$0.dismissPopup();
                return true;
            }
        });
        this.mExpandActivityOverflowButton = mExpandActivityOverflowButton;
        (mExpandActivityOverflowButtonImage = (ImageView)mExpandActivityOverflowButton.findViewById(R.id.image)).setImageDrawable(drawable);
        (mAdapter = new ActivityChooserViewAdapter(this)).registerDataSetObserver((DataSetObserver)new DataSetObserver() {
            final /* synthetic */ ActivityChooserView this$0;
            
            ActivityChooserView$4() {
                this$0 = this$0;
                super();
            }
            
            public void onChanged() {
                super.onChanged();
                this$0.updateAppearance();
            }
        });
        final Resources resources = context.getResources();
        mListPopupMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    }
    
    static /* synthetic */ ActivityChooserViewAdapter access$000(final ActivityChooserView activityChooserView) {
        return activityChooserView.mAdapter;
    }
    
    static /* synthetic */ ListPopupWindow access$100(final ActivityChooserView activityChooserView) {
        return activityChooserView.getListPopupWindow();
    }
    
    static /* synthetic */ PopupWindow$OnDismissListener access$1000(final ActivityChooserView activityChooserView) {
        return activityChooserView.mOnDismissListener;
    }
    
    static /* synthetic */ DataSetObserver access$1100(final ActivityChooserView activityChooserView) {
        return activityChooserView.mModelDataSetOberver;
    }
    
    static /* synthetic */ void access$400(final ActivityChooserView activityChooserView) {
        activityChooserView.updateAppearance();
    }
    
    static /* synthetic */ void access$500(final ActivityChooserView activityChooserView, final int n) {
        activityChooserView.showPopupUnchecked(n);
    }
    
    static /* synthetic */ boolean access$600(final ActivityChooserView activityChooserView) {
        return activityChooserView.mIsSelectingDefaultActivity;
    }
    
    static /* synthetic */ boolean access$602(final ActivityChooserView activityChooserView, final boolean mIsSelectingDefaultActivity) {
        return activityChooserView.mIsSelectingDefaultActivity = mIsSelectingDefaultActivity;
    }
    
    static /* synthetic */ FrameLayout access$700(final ActivityChooserView activityChooserView) {
        return activityChooserView.mDefaultActivityButton;
    }
    
    static /* synthetic */ FrameLayout access$800(final ActivityChooserView activityChooserView) {
        return activityChooserView.mExpandActivityOverflowButton;
    }
    
    static /* synthetic */ int access$900(final ActivityChooserView activityChooserView) {
        return activityChooserView.mInitialActivityCount;
    }
    
    private ListPopupWindow getListPopupWindow() {
        if (mListPopupWindow == null) {
            (mListPopupWindow = new ListPopupWindow(this.getContext())).setAdapter((ListAdapter)mAdapter);
            mListPopupWindow.setAnchorView((View)this);
            mListPopupWindow.setModal(true);
            mListPopupWindow.setOnItemClickListener((AdapterView$OnItemClickListener)mCallbacks);
            mListPopupWindow.setOnDismissListener((PopupWindow$OnDismissListener)mCallbacks);
        }
        return mListPopupWindow;
    }
    
    private void showPopupUnchecked(final int maxActivityCount) {
        if (mAdapter.getDataModel() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        this.getViewTreeObserver().addOnGlobalLayoutListener(mOnGlobalLayoutListener);
        final boolean b = mDefaultActivityButton.getVisibility() == 0;
        final int activityCount = mAdapter.getActivityCount();
        int n;
        if (b) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (maxActivityCount != Integer.MAX_VALUE && activityCount > maxActivityCount + n) {
            mAdapter.setShowFooterView(true);
            mAdapter.setMaxActivityCount(maxActivityCount - 1);
        }
        else {
            mAdapter.setShowFooterView(false);
            mAdapter.setMaxActivityCount(maxActivityCount);
        }
        final ListPopupWindow listPopupWindow = this.getListPopupWindow();
        if (!listPopupWindow.isShowing()) {
            if (mIsSelectingDefaultActivity || !b) {
                mAdapter.setShowDefaultActivity(true, b);
            }
            else {
                mAdapter.setShowDefaultActivity(false, false);
            }
            listPopupWindow.setContentWidth(Math.min(mAdapter.measureContentWidth(), mListPopupMaxWidth));
            listPopupWindow.show();
            if (mProvider != null) {
                mProvider.subUiVisibilityChanged(true);
            }
            listPopupWindow.getListView().setContentDescription((CharSequence)this.getContext().getString(R.string.abc_activitychooserview_choose_application));
        }
    }
    
    private void updateAppearance() {
        if (mAdapter.getCount() > 0) {
            mExpandActivityOverflowButton.setEnabled(true);
        }
        else {
            mExpandActivityOverflowButton.setEnabled(false);
        }
        final int activityCount = mAdapter.getActivityCount();
        final int historySize = mAdapter.getHistorySize();
        if (activityCount == 1 || (activityCount > 1 && historySize > 0)) {
            mDefaultActivityButton.setVisibility(0);
            final ResolveInfo defaultActivity = mAdapter.getDefaultActivity();
            final PackageManager packageManager = this.getContext().getPackageManager();
            mDefaultActivityButtonImage.setImageDrawable(defaultActivity.loadIcon(packageManager));
            if (mDefaultActionButtonContentDescription != 0) {
                mDefaultActivityButton.setContentDescription((CharSequence)this.getContext().getString(mDefaultActionButtonContentDescription, new Object[] { defaultActivity.loadLabel(packageManager) }));
            }
        }
        else {
            mDefaultActivityButton.setVisibility(8);
        }
        if (mDefaultActivityButton.getVisibility() == 0) {
            mActivityChooserContent.setBackgroundDrawable(mActivityChooserContentBackground);
            return;
        }
        mActivityChooserContent.setBackgroundDrawable((Drawable)null);
    }
    
    public boolean dismissPopup() {
        if (this.isShowingPopup()) {
            this.getListPopupWindow().dismiss();
            final ViewTreeObserver viewTreeObserver = this.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(mOnGlobalLayoutListener);
            }
        }
        return true;
    }
    
    public ActivityChooserModel getDataModel() {
        return mAdapter.getDataModel();
    }
    
    public boolean isShowingPopup() {
        return this.getListPopupWindow().isShowing();
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        final ActivityChooserModel dataModel = mAdapter.getDataModel();
        if (dataModel != null) {
            dataModel.registerObserver((Object)mModelDataSetOberver);
        }
        mIsAttachedToWindow = true;
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        final ActivityChooserModel dataModel = mAdapter.getDataModel();
        if (dataModel != null) {
            dataModel.unregisterObserver((Object)mModelDataSetOberver);
        }
        final ViewTreeObserver viewTreeObserver = this.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(mOnGlobalLayoutListener);
        }
        if (this.isShowingPopup()) {
            this.dismissPopup();
        }
        mIsAttachedToWindow = false;
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        mActivityChooserContent.layout(0, 0, n3 - n, n4 - n2);
        if (!this.isShowingPopup()) {
            this.dismissPopup();
        }
    }
    
    protected void onMeasure(final int n, int measureSpec) {
        final LinearLayoutCompat mActivityChooserContent = this.mActivityChooserContent;
        if (mDefaultActivityButton.getVisibility() != 0) {
            measureSpec = View$MeasureSpec.makeMeasureSpec(View$MeasureSpec.getSize(measureSpec), 1073741824);
        }
        this.measureChild((View)mActivityChooserContent, n, measureSpec);
        this.setMeasuredDimension(((View)mActivityChooserContent).getMeasuredWidth(), ((View)mActivityChooserContent).getMeasuredHeight());
    }
    
    public void setActivityChooserModel(final ActivityChooserModel dataModel) {
        mAdapter.setDataModel(dataModel);
        if (this.isShowingPopup()) {
            this.dismissPopup();
            this.showPopup();
        }
    }
    
    public void setDefaultActionButtonContentDescription(final int mDefaultActionButtonContentDescription) {
        this.mDefaultActionButtonContentDescription = mDefaultActionButtonContentDescription;
    }
    
    public void setExpandActivityOverflowButtonContentDescription(final int n) {
        mExpandActivityOverflowButtonImage.setContentDescription((CharSequence)this.getContext().getString(n));
    }
    
    public void setExpandActivityOverflowButtonDrawable(final Drawable imageDrawable) {
        mExpandActivityOverflowButtonImage.setImageDrawable(imageDrawable);
    }
    
    public void setInitialActivityCount(final int mInitialActivityCount) {
        this.mInitialActivityCount = mInitialActivityCount;
    }
    
    public void setOnDismissListener(final PopupWindow$OnDismissListener mOnDismissListener) {
        this.mOnDismissListener = mOnDismissListener;
    }
    
    public void setProvider(final ActionProvider mProvider) {
        this.mProvider = mProvider;
    }
    
    public boolean showPopup() {
        if (this.isShowingPopup() || !mIsAttachedToWindow) {
            return false;
        }
        mIsSelectingDefaultActivity = false;
        this.showPopupUnchecked(mInitialActivityCount);
        return true;
    }
}
