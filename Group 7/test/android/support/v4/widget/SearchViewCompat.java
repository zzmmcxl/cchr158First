package android.support.v4.widget;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.widget.SearchViewCompat$OnCloseListenerCompat;
import android.support.v4.widget.SearchViewCompat$OnQueryTextListenerCompat;
import android.support.v4.widget.SearchViewCompat$SearchViewCompatHoneycombImpl;
import android.support.v4.widget.SearchViewCompat$SearchViewCompatIcsImpl;
import android.support.v4.widget.SearchViewCompat$SearchViewCompatImpl;
import android.support.v4.widget.SearchViewCompat$SearchViewCompatStubImpl;
import android.view.View;

public final class SearchViewCompat {
   private static final SearchViewCompat$SearchViewCompatImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 14) {
         IMPL = new SearchViewCompat$SearchViewCompatIcsImpl();
      } else if(VERSION.SDK_INT >= 11) {
         IMPL = new SearchViewCompat$SearchViewCompatHoneycombImpl();
      } else {
         IMPL = new SearchViewCompat$SearchViewCompatStubImpl();
      }
   }

   private SearchViewCompat(Context var1) {
   }

   public static CharSequence getQuery(View var0) {
      return IMPL.getQuery(var0);
   }

   public static boolean isIconified(View var0) {
      return IMPL.isIconified(var0);
   }

   public static boolean isQueryRefinementEnabled(View var0) {
      return IMPL.isQueryRefinementEnabled(var0);
   }

   public static boolean isSubmitButtonEnabled(View var0) {
      return IMPL.isSubmitButtonEnabled(var0);
   }

   public static View newSearchView(Context var0) {
      return IMPL.newSearchView(var0);
   }

   public static void setIconified(View var0, boolean var1) {
      IMPL.setIconified(var0, var1);
   }

   public static void setImeOptions(View var0, int var1) {
      IMPL.setImeOptions(var0, var1);
   }

   public static void setInputType(View var0, int var1) {
      IMPL.setInputType(var0, var1);
   }

   public static void setMaxWidth(View var0, int var1) {
      IMPL.setMaxWidth(var0, var1);
   }

   public static void setOnCloseListener(View var0, SearchViewCompat$OnCloseListenerCompat var1) {
      IMPL.setOnCloseListener(var0, var1.mListener);
   }

   public static void setOnQueryTextListener(View var0, SearchViewCompat$OnQueryTextListenerCompat var1) {
      IMPL.setOnQueryTextListener(var0, var1.mListener);
   }

   public static void setQuery(View var0, CharSequence var1, boolean var2) {
      IMPL.setQuery(var0, var1, var2);
   }

   public static void setQueryHint(View var0, CharSequence var1) {
      IMPL.setQueryHint(var0, var1);
   }

   public static void setQueryRefinementEnabled(View var0, boolean var1) {
      IMPL.setQueryRefinementEnabled(var0, var1);
   }

   public static void setSearchableInfo(View var0, ComponentName var1) {
      IMPL.setSearchableInfo(var0, var1);
   }

   public static void setSubmitButtonEnabled(View var0, boolean var1) {
      IMPL.setSubmitButtonEnabled(var0, var1);
   }
}
