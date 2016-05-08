package android.support.v7.view.menu;

import android.support.v7.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

class MenuItemWrapperICS$CollapsibleActionViewWrapper extends FrameLayout implements CollapsibleActionView {
   final android.view.CollapsibleActionView mWrappedView;

   MenuItemWrapperICS$CollapsibleActionViewWrapper(View var1) {
      super(var1.getContext());
      this.mWrappedView = (android.view.CollapsibleActionView)var1;
      this.addView(var1);
   }

   View getWrappedView() {
      return (View)this.mWrappedView;
   }

   public void onActionViewCollapsed() {
      this.mWrappedView.onActionViewCollapsed();
   }

   public void onActionViewExpanded() {
      this.mWrappedView.onActionViewExpanded();
   }
}
