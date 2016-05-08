package android.support.v7.widget;

import android.support.v4.view.KeyEventCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView$SearchAutoComplete;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class SearchView$8 implements OnKeyListener {
   SearchView$8(SearchView var1) {
      this.this$0 = var1;
   }

   public boolean onKey(View var1, int var2, KeyEvent var3) {
      if(SearchView.access$1400(this.this$0) != null) {
         if(SearchView.access$1200(this.this$0).isPopupShowing() && SearchView.access$1200(this.this$0).getListSelection() != -1) {
            return SearchView.access$1500(this.this$0, var1, var2, var3);
         }

         if(!SearchView$SearchAutoComplete.access$1600(SearchView.access$1200(this.this$0)) && KeyEventCompat.hasNoModifiers(var3) && var3.getAction() == 1 && var2 == 66) {
            var1.cancelLongPress();
            SearchView.access$1700(this.this$0, 0, (String)null, SearchView.access$1200(this.this$0).getText().toString());
            return true;
         }
      }

      return false;
   }
}
