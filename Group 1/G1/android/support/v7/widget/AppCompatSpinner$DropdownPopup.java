package android.support.v7.widget;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow$OnDismissListener;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.graphics.drawable.Drawable;
import android.widget.SpinnerAdapter;
import android.support.v4.view.ViewCompat;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Rect;
import android.widget.ListAdapter;

private class DropdownPopup extends ListPopupWindow
{
    private ListAdapter mAdapter;
    private CharSequence mHintText;
    private final Rect mVisibleRect;
    final /* synthetic */ AppCompatSpinner this$0;
    
    public DropdownPopup(final AppCompatSpinner appCompatSpinner, final Context context, final AttributeSet set, final int n) {
        this$0 = appCompatSpinner;
        super(context, set, n);
        mVisibleRect = new Rect();
        this.setAnchorView((View)appCompatSpinner);
        this.setModal(true);
        this.setPromptPosition(0);
        this.setOnItemClickListener((AdapterView$OnItemClickListener)new AdapterView$OnItemClickListener() {
            final /* synthetic */ DropdownPopup this$1;
            final /* synthetic */ AppCompatSpinner val$this$0;
            
            AppCompatSpinner$DropdownPopup$1() {
                this$1 = this$1;
                super();
            }
            
            public void onItemClick(final AdapterView<?> adapterView, final View view, final int selection, final long n) {
                this$0.setSelection(selection);
                if (this$0.getOnItemClickListener() != null) {
                    this$0.performItemClick(view, selection, mAdapter.getItemId(selection));
                }
                this$1.dismiss();
            }
        });
    }
    
    static /* synthetic */ ListAdapter access$200(final DropdownPopup dropdownPopup) {
        return dropdownPopup.mAdapter;
    }
    
    static /* synthetic */ boolean access$600(final DropdownPopup dropdownPopup, final View view) {
        return dropdownPopup.isVisibleToUser(view);
    }
    
    static /* synthetic */ void access$701(final DropdownPopup dropdownPopup) {
        dropdownPopup.show();
    }
    
    private boolean isVisibleToUser(final View view) {
        return ViewCompat.isAttachedToWindow(view) && view.getGlobalVisibleRect(mVisibleRect);
    }
    
    void computeContentWidth() {
        final Drawable background = this.getBackground();
        int right;
        if (background != null) {
            background.getPadding(AppCompatSpinner.access$300(this$0));
            if (ViewUtils.isLayoutRtl((View)this$0)) {
                right = AppCompatSpinner.access$300(this$0).right;
            }
            else {
                right = -AppCompatSpinner.access$300(this$0).left;
            }
        }
        else {
            final Rect access$300 = AppCompatSpinner.access$300(this$0);
            AppCompatSpinner.access$300(this$0).right = 0;
            access$300.left = 0;
            right = 0;
        }
        final int paddingLeft = this$0.getPaddingLeft();
        final int paddingRight = this$0.getPaddingRight();
        final int width = this$0.getWidth();
        if (AppCompatSpinner.access$400(this$0) == -2) {
            int access$301 = AppCompatSpinner.access$500(this$0, (SpinnerAdapter)mAdapter, this.getBackground());
            final int n = this$0.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.access$300(this$0).left - AppCompatSpinner.access$300(this$0).right;
            if (access$301 > n) {
                access$301 = n;
            }
            this.setContentWidth(Math.max(access$301, width - paddingLeft - paddingRight));
        }
        else if (AppCompatSpinner.access$400(this$0) == -1) {
            this.setContentWidth(width - paddingLeft - paddingRight);
        }
        else {
            this.setContentWidth(AppCompatSpinner.access$400(this$0));
        }
        int horizontalOffset;
        if (ViewUtils.isLayoutRtl((View)this$0)) {
            horizontalOffset = right + (width - paddingRight - this.getWidth());
        }
        else {
            horizontalOffset = right + paddingLeft;
        }
        this.setHorizontalOffset(horizontalOffset);
    }
    
    public CharSequence getHintText() {
        return mHintText;
    }
    
    @Override
    public void setAdapter(final ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        mAdapter = listAdapter;
    }
    
    public void setPromptText(final CharSequence mHintText) {
        this.mHintText = mHintText;
    }
    
    @Override
    public void show() {
        final boolean showing = this.isShowing();
        this.computeContentWidth();
        this.setInputMethodMode(2);
        super.show();
        this.getListView().setChoiceMode(1);
        this.setSelection(this$0.getSelectedItemPosition());
        if (!showing) {
            final ViewTreeObserver viewTreeObserver = this$0.getViewTreeObserver();
            if (viewTreeObserver != null) {
                final ViewTreeObserver$OnGlobalLayoutListener viewTreeObserver$OnGlobalLayoutListener = (ViewTreeObserver$OnGlobalLayoutListener)new ViewTreeObserver$OnGlobalLayoutListener() {
                    final /* synthetic */ DropdownPopup this$1;
                    
                    AppCompatSpinner$DropdownPopup$2() {
                        this$1 = this$1;
                        super();
                    }
                    
                    public void onGlobalLayout() {
                        if (!this$1.isVisibleToUser((View)this$0)) {
                            this$1.dismiss();
                            return;
                        }
                        this$1.computeContentWidth();
                        this$1.show();
                    }
                };
                viewTreeObserver.addOnGlobalLayoutListener((ViewTreeObserver$OnGlobalLayoutListener)viewTreeObserver$OnGlobalLayoutListener);
                this.setOnDismissListener((PopupWindow$OnDismissListener)new PopupWindow$OnDismissListener() {
                    final /* synthetic */ DropdownPopup this$1;
                    final /* synthetic */ ViewTreeObserver$OnGlobalLayoutListener val$layoutListener;
                    
                    AppCompatSpinner$DropdownPopup$3() {
                        this$1 = this$1;
                        super();
                    }
                    
                    public void onDismiss() {
                        final ViewTreeObserver viewTreeObserver = this$0.getViewTreeObserver();
                        if (viewTreeObserver != null) {
                            viewTreeObserver.removeGlobalOnLayoutListener(viewTreeObserver$OnGlobalLayoutListener);
                        }
                    }
                });
            }
        }
    }
}
