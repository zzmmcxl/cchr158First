package android.support.design.widget;

import android.support.annotation.LayoutRes;
import android.os.Bundle;
import android.view.View$OnClickListener;
import android.widget.FrameLayout;
import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;
import android.os.Build$VERSION;
import android.support.design.R;
import android.util.TypedValue;
import android.content.DialogInterface$OnCancelListener;
import android.view.View;
import android.support.annotation.StyleRes;
import android.support.annotation.NonNull;
import android.content.Context;
import android.support.v7.app.AppCompatDialog;

public class BottomSheetDialog extends AppCompatDialog
{
    private BottomSheetBehavior.BottomSheetCallback mBottomSheetCallback;
    
    public BottomSheetDialog(@NonNull final Context context) {
        this(context, 0);
    }
    
    public BottomSheetDialog(@NonNull final Context context, @StyleRes final int n) {
        super(context, getThemeResId(context, n));
        mBottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {
            final /* synthetic */ BottomSheetDialog this$0;
            
            BottomSheetDialog$2(final BottomSheetDialog this$0) {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void onSlide(@NonNull final View view, final float n) {
            }
            
            @Override
            public void onStateChanged(@NonNull final View view, final int n) {
                if (n == 5) {
                    this$0.dismiss();
                }
            }
        };
        this.supportRequestWindowFeature(1);
    }
    
    protected BottomSheetDialog(@NonNull final Context context, final boolean b, final DialogInterface$OnCancelListener dialogInterface$OnCancelListener) {
        super(context, b, dialogInterface$OnCancelListener);
        mBottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {
            final /* synthetic */ BottomSheetDialog this$0;
            
            BottomSheetDialog$2() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void onSlide(@NonNull final View view, final float n) {
            }
            
            @Override
            public void onStateChanged(@NonNull final View view, final int n) {
                if (n == 5) {
                    this$0.dismiss();
                }
            }
        };
        this.supportRequestWindowFeature(1);
    }
    
    private static int getThemeResId(final Context context, int resourceId) {
        if (resourceId == 0) {
            final TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, typedValue, true)) {
                return R.style.Theme_Design_Light_BottomSheetDialog;
            }
            resourceId = typedValue.resourceId;
        }
        return resourceId;
    }
    
    private boolean shouldWindowCloseOnTouchOutside() {
        if (Build$VERSION.SDK_INT >= 11) {
            final TypedValue typedValue = new TypedValue();
            if (!this.getContext().getTheme().resolveAttribute(16843611, typedValue, true)) {
                return false;
            }
            if (typedValue.data == 0) {
                return false;
            }
        }
        return true;
    }
    
    private View wrapInBottomSheet(final int n, View inflate, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        final CoordinatorLayout coordinatorLayout = (CoordinatorLayout)View.inflate(this.getContext(), R.layout.design_bottom_sheet_dialog, (ViewGroup)null);
        if (n != 0 && inflate == null) {
            inflate = this.getLayoutInflater().inflate(n, (ViewGroup)coordinatorLayout, false);
        }
        final FrameLayout frameLayout = (FrameLayout)coordinatorLayout.findViewById(R.id.design_bottom_sheet);
        BottomSheetBehavior.<FrameLayout>from(frameLayout).setBottomSheetCallback(mBottomSheetCallback);
        if (viewGroup$LayoutParams == null) {
            frameLayout.addView(inflate);
        }
        else {
            frameLayout.addView(inflate, viewGroup$LayoutParams);
        }
        if (this.shouldWindowCloseOnTouchOutside()) {
            coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener((View$OnClickListener)new View$OnClickListener() {
                final /* synthetic */ BottomSheetDialog this$0;
                
                BottomSheetDialog$1() {
                    this$0 = this$0;
                    super();
                }
                
                public void onClick(final View view) {
                    if (this$0.isShowing()) {
                        this$0.cancel();
                    }
                }
            });
        }
        return (View)coordinatorLayout;
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.getWindow().setLayout(-1, -1);
    }
    
    @Override
    public void setContentView(@LayoutRes final int n) {
        super.setContentView(this.wrapInBottomSheet(n, (View)null, (ViewGroup$LayoutParams)null));
    }
    
    @Override
    public void setContentView(final View view) {
        super.setContentView(this.wrapInBottomSheet(0, view, (ViewGroup$LayoutParams)null));
    }
    
    @Override
    public void setContentView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super.setContentView(this.wrapInBottomSheet(0, view, viewGroup$LayoutParams));
    }
}
