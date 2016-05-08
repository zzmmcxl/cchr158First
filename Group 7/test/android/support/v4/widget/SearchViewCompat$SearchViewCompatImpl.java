package android.support.v4.widget;

import android.content.ComponentName;
import android.content.Context;
import android.support.v4.widget.SearchViewCompat$OnCloseListenerCompat;
import android.support.v4.widget.SearchViewCompat$OnQueryTextListenerCompat;
import android.view.View;

interface SearchViewCompat$SearchViewCompatImpl {
   CharSequence getQuery(View var1);

   boolean isIconified(View var1);

   boolean isQueryRefinementEnabled(View var1);

   boolean isSubmitButtonEnabled(View var1);

   Object newOnCloseListener(SearchViewCompat$OnCloseListenerCompat var1);

   Object newOnQueryTextListener(SearchViewCompat$OnQueryTextListenerCompat var1);

   View newSearchView(Context var1);

   void setIconified(View var1, boolean var2);

   void setImeOptions(View var1, int var2);

   void setInputType(View var1, int var2);

   void setMaxWidth(View var1, int var2);

   void setOnCloseListener(Object var1, Object var2);

   void setOnQueryTextListener(Object var1, Object var2);

   void setQuery(View var1, CharSequence var2, boolean var3);

   void setQueryHint(View var1, CharSequence var2);

   void setQueryRefinementEnabled(View var1, boolean var2);

   void setSearchableInfo(View var1, ComponentName var2);

   void setSubmitButtonEnabled(View var1, boolean var2);
}
