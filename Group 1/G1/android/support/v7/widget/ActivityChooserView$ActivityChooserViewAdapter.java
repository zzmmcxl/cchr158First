package android.support.v7.widget;

import android.view.View$MeasureSpec;
import android.content.pm.PackageManager;
import android.support.v4.view.ViewCompat;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.appcompat.R;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.content.pm.ResolveInfo;
import android.widget.BaseAdapter;

private class ActivityChooserViewAdapter extends BaseAdapter
{
    private static final int ITEM_VIEW_TYPE_ACTIVITY = 0;
    private static final int ITEM_VIEW_TYPE_COUNT = 3;
    private static final int ITEM_VIEW_TYPE_FOOTER = 1;
    public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
    public static final int MAX_ACTIVITY_COUNT_UNLIMITED = Integer.MAX_VALUE;
    private ActivityChooserModel mDataModel;
    private boolean mHighlightDefaultActivity;
    private int mMaxActivityCount;
    private boolean mShowDefaultActivity;
    private boolean mShowFooterView;
    final /* synthetic */ ActivityChooserView this$0;
    
    private ActivityChooserViewAdapter(final ActivityChooserView this$0) {
        this$0 = this$0;
        super();
        mMaxActivityCount = 4;
    }
    
    ActivityChooserViewAdapter(final ActivityChooserView activityChooserView, final ActivityChooserView$1 dataSetObserver) {
        this(activityChooserView);
    }
    
    public int getActivityCount() {
        return mDataModel.getActivityCount();
    }
    
    public int getCount() {
        int activityCount = mDataModel.getActivityCount();
        if (!mShowDefaultActivity && mDataModel.getDefaultActivity() != null) {
            --activityCount;
        }
        int min = Math.min(activityCount, mMaxActivityCount);
        if (mShowFooterView) {
            ++min;
        }
        return min;
    }
    
    public ActivityChooserModel getDataModel() {
        return mDataModel;
    }
    
    public ResolveInfo getDefaultActivity() {
        return mDataModel.getDefaultActivity();
    }
    
    public int getHistorySize() {
        return mDataModel.getHistorySize();
    }
    
    public Object getItem(int n) {
        switch (this.getItemViewType(n)) {
            default:
                throw new IllegalArgumentException();
            case 1:
                return null;
            case 0:
                if (!mShowDefaultActivity && mDataModel.getDefaultActivity() != null) {
                    ++n;
                }
                return mDataModel.getActivity(n);
        }
    }
    
    public long getItemId(final int n) {
        return n;
    }
    
    public int getItemViewType(final int n) {
        if (mShowFooterView && n == -1 + this.getCount()) {
            return 1;
        }
        return 0;
    }
    
    public boolean getShowDefaultActivity() {
        return mShowDefaultActivity;
    }
    
    public View getView(final int n, View view, final ViewGroup viewGroup) {
        switch (this.getItemViewType(n)) {
            default:
                throw new IllegalArgumentException();
            case 1:
                if (view == null || view.getId() != 1) {
                    view = LayoutInflater.from(this$0.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                    view.setId(1);
                    ((TextView)view.findViewById(R.id.title)).setText((CharSequence)this$0.getContext().getString(R.string.abc_activity_chooser_view_see_all));
                }
                return view;
            case 0: {
                if (view == null || view.getId() != R.id.list_item) {
                    view = LayoutInflater.from(this$0.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                }
                final PackageManager packageManager = this$0.getContext().getPackageManager();
                final ImageView imageView = (ImageView)view.findViewById(R.id.icon);
                final ResolveInfo resolveInfo = (ResolveInfo)this.getItem(n);
                imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
                ((TextView)view.findViewById(R.id.title)).setText(resolveInfo.loadLabel(packageManager));
                if (mShowDefaultActivity && n == 0 && mHighlightDefaultActivity) {
                    ViewCompat.setActivated(view, true);
                }
                else {
                    ViewCompat.setActivated(view, false);
                }
                return view;
            }
        }
    }
    
    public int getViewTypeCount() {
        return 3;
    }
    
    public int measureContentWidth() {
        final int mMaxActivityCount = this.mMaxActivityCount;
        this.mMaxActivityCount = Integer.MAX_VALUE;
        int max = 0;
        View view = null;
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(0, 0);
        final int measureSpec2 = View$MeasureSpec.makeMeasureSpec(0, 0);
        for (int count = this.getCount(), i = 0; i < count; ++i) {
            view = this.getView(i, view, null);
            view.measure(measureSpec, measureSpec2);
            max = Math.max(max, view.getMeasuredWidth());
        }
        this.mMaxActivityCount = mMaxActivityCount;
        return max;
    }
    
    public void setDataModel(final ActivityChooserModel mDataModel) {
        final ActivityChooserModel dataModel = ActivityChooserView.access$000(this$0).getDataModel();
        if (dataModel != null && this$0.isShown()) {
            dataModel.unregisterObserver((Object)ActivityChooserView.access$1100(this$0));
        }
        if ((this.mDataModel = mDataModel) != null && this$0.isShown()) {
            mDataModel.registerObserver((Object)ActivityChooserView.access$1100(this$0));
        }
        this.notifyDataSetChanged();
    }
    
    public void setMaxActivityCount(final int mMaxActivityCount) {
        if (this.mMaxActivityCount != mMaxActivityCount) {
            this.mMaxActivityCount = mMaxActivityCount;
            this.notifyDataSetChanged();
        }
    }
    
    public void setShowDefaultActivity(final boolean mShowDefaultActivity, final boolean mHighlightDefaultActivity) {
        if (this.mShowDefaultActivity != mShowDefaultActivity || this.mHighlightDefaultActivity != mHighlightDefaultActivity) {
            this.mShowDefaultActivity = mShowDefaultActivity;
            this.mHighlightDefaultActivity = mHighlightDefaultActivity;
            this.notifyDataSetChanged();
        }
    }
    
    public void setShowFooterView(final boolean mShowFooterView) {
        if (this.mShowFooterView != mShowFooterView) {
            this.mShowFooterView = mShowFooterView;
            this.notifyDataSetChanged();
        }
    }
}
