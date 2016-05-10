package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.LruCache;
import android.support.v7.appcompat.R;
import android.support.v7.internal.widget.ThemeUtils;
import android.support.v7.internal.widget.TintInfo;
import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class TintManager {
   private static final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY;
   private static final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED;
   private static final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL;
   private static final TintManager.ColorFilterLruCache COLOR_FILTER_CACHE;
   private static final boolean DEBUG = false;
   private static final Mode DEFAULT_MODE;
   private static final WeakHashMap INSTANCE_CACHE;
   public static final boolean SHOULD_BE_USED;
   private static final String TAG = "TintManager";
   private static final int[] TINT_CHECKABLE_BUTTON_LIST;
   private static final int[] TINT_COLOR_CONTROL_NORMAL;
   private static final int[] TINT_COLOR_CONTROL_STATE_LIST;
   private final WeakReference mContextRef;
   private ColorStateList mDefaultColorStateList;
   private SparseArray mTintLists;

   static {
      boolean var0;
      if(VERSION.SDK_INT < 21) {
         var0 = true;
      } else {
         var0 = false;
      }

      SHOULD_BE_USED = var0;
      DEFAULT_MODE = Mode.SRC_IN;
      INSTANCE_CACHE = new WeakHashMap();
      COLOR_FILTER_CACHE = new TintManager.ColorFilterLruCache(6);
      COLORFILTER_TINT_COLOR_CONTROL_NORMAL = new int[]{R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
      TINT_COLOR_CONTROL_NORMAL = new int[]{R.drawable.abc_ic_ab_back_mtrl_am_alpha, R.drawable.abc_ic_go_search_api_mtrl_alpha, R.drawable.abc_ic_search_api_mtrl_alpha, R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_ic_clear_mtrl_alpha, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha, R.drawable.abc_ic_menu_moreoverflow_mtrl_alpha, R.drawable.abc_ic_voice_search_api_mtrl_alpha};
      COLORFILTER_COLOR_CONTROL_ACTIVATED = new int[]{R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_mtrl_alpha};
      COLORFILTER_COLOR_BACKGROUND_MULTIPLY = new int[]{R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
      TINT_COLOR_CONTROL_STATE_LIST = new int[]{R.drawable.abc_edit_text_material, R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material, R.drawable.abc_spinner_mtrl_am_alpha, R.drawable.abc_spinner_textfield_background_material, R.drawable.abc_ratingbar_full_material, R.drawable.abc_switch_track_mtrl_alpha, R.drawable.abc_switch_thumb_material, R.drawable.abc_btn_default_mtrl_shape, R.drawable.abc_btn_borderless_material};
      TINT_CHECKABLE_BUTTON_LIST = new int[]{R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material};
   }

   private TintManager(Context var1) {
      this.mContextRef = new WeakReference(var1);
   }

   private static boolean arrayContains(int[] var0, int var1) {
      int var3 = var0.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         if(var0[var2] == var1) {
            return true;
         }
      }

      return false;
   }

   private ColorStateList createButtonColorStateList(Context var1) {
      int[][] var5 = new int[4][];
      int[] var6 = new int[4];
      int var2 = ThemeUtils.getThemeAttrColor(var1, R.attr.colorButtonNormal);
      int var3 = ThemeUtils.getThemeAttrColor(var1, R.attr.colorControlHighlight);
      var5[0] = ThemeUtils.DISABLED_STATE_SET;
      var6[0] = ThemeUtils.getDisabledThemeAttrColor(var1, R.attr.colorButtonNormal);
      int var4 = 0 + 1;
      var5[var4] = ThemeUtils.PRESSED_STATE_SET;
      var6[var4] = ColorUtils.compositeColors(var3, var2);
      ++var4;
      var5[var4] = ThemeUtils.FOCUSED_STATE_SET;
      var6[var4] = ColorUtils.compositeColors(var3, var2);
      var3 = var4 + 1;
      var5[var3] = ThemeUtils.EMPTY_STATE_SET;
      var6[var3] = var2;
      return new ColorStateList(var5, var6);
   }

   private ColorStateList createCheckableButtonColorStateList(Context var1) {
      int[][] var3 = new int[3][];
      int[] var4 = new int[3];
      var3[0] = ThemeUtils.DISABLED_STATE_SET;
      var4[0] = ThemeUtils.getDisabledThemeAttrColor(var1, R.attr.colorControlNormal);
      int var2 = 0 + 1;
      var3[var2] = ThemeUtils.CHECKED_STATE_SET;
      var4[var2] = ThemeUtils.getThemeAttrColor(var1, R.attr.colorControlActivated);
      ++var2;
      var3[var2] = ThemeUtils.EMPTY_STATE_SET;
      var4[var2] = ThemeUtils.getThemeAttrColor(var1, R.attr.colorControlNormal);
      return new ColorStateList(var3, var4);
   }

   private ColorStateList createEditTextColorStateList(Context var1) {
      int[][] var3 = new int[3][];
      int[] var4 = new int[3];
      var3[0] = ThemeUtils.DISABLED_STATE_SET;
      var4[0] = ThemeUtils.getDisabledThemeAttrColor(var1, R.attr.colorControlNormal);
      int var2 = 0 + 1;
      var3[var2] = ThemeUtils.NOT_PRESSED_OR_FOCUSED_STATE_SET;
      var4[var2] = ThemeUtils.getThemeAttrColor(var1, R.attr.colorControlNormal);
      ++var2;
      var3[var2] = ThemeUtils.EMPTY_STATE_SET;
      var4[var2] = ThemeUtils.getThemeAttrColor(var1, R.attr.colorControlActivated);
      return new ColorStateList(var3, var4);
   }

   private ColorStateList createSpinnerColorStateList(Context var1) {
      int[][] var3 = new int[3][];
      int[] var4 = new int[3];
      var3[0] = ThemeUtils.DISABLED_STATE_SET;
      var4[0] = ThemeUtils.getDisabledThemeAttrColor(var1, R.attr.colorControlNormal);
      int var2 = 0 + 1;
      var3[var2] = ThemeUtils.NOT_PRESSED_OR_FOCUSED_STATE_SET;
      var4[var2] = ThemeUtils.getThemeAttrColor(var1, R.attr.colorControlNormal);
      ++var2;
      var3[var2] = ThemeUtils.EMPTY_STATE_SET;
      var4[var2] = ThemeUtils.getThemeAttrColor(var1, R.attr.colorControlActivated);
      return new ColorStateList(var3, var4);
   }

   private ColorStateList createSwitchThumbColorStateList(Context var1) {
      int[][] var3 = new int[3][];
      int[] var4 = new int[3];
      ColorStateList var5 = ThemeUtils.getThemeAttrColorStateList(var1, R.attr.colorSwitchThumbNormal);
      int var2;
      if(var5 != null && var5.isStateful()) {
         var3[0] = ThemeUtils.DISABLED_STATE_SET;
         var4[0] = var5.getColorForState(var3[0], 0);
         var2 = 0 + 1;
         var3[var2] = ThemeUtils.CHECKED_STATE_SET;
         var4[var2] = ThemeUtils.getThemeAttrColor(var1, R.attr.colorControlActivated);
         ++var2;
         var3[var2] = ThemeUtils.EMPTY_STATE_SET;
         var4[var2] = var5.getDefaultColor();
      } else {
         var3[0] = ThemeUtils.DISABLED_STATE_SET;
         var4[0] = ThemeUtils.getDisabledThemeAttrColor(var1, R.attr.colorSwitchThumbNormal);
         var2 = 0 + 1;
         var3[var2] = ThemeUtils.CHECKED_STATE_SET;
         var4[var2] = ThemeUtils.getThemeAttrColor(var1, R.attr.colorControlActivated);
         ++var2;
         var3[var2] = ThemeUtils.EMPTY_STATE_SET;
         var4[var2] = ThemeUtils.getThemeAttrColor(var1, R.attr.colorSwitchThumbNormal);
      }

      return new ColorStateList(var3, var4);
   }

   private ColorStateList createSwitchTrackColorStateList(Context var1) {
      int[][] var3 = new int[3][];
      int[] var4 = new int[3];
      var3[0] = ThemeUtils.DISABLED_STATE_SET;
      var4[0] = ThemeUtils.getThemeAttrColor(var1, 16842800, 0.1F);
      int var2 = 0 + 1;
      var3[var2] = ThemeUtils.CHECKED_STATE_SET;
      var4[var2] = ThemeUtils.getThemeAttrColor(var1, R.attr.colorControlActivated, 0.3F);
      ++var2;
      var3[var2] = ThemeUtils.EMPTY_STATE_SET;
      var4[var2] = ThemeUtils.getThemeAttrColor(var1, 16842800, 0.3F);
      return new ColorStateList(var3, var4);
   }

   public static TintManager get(Context var0) {
      TintManager var2 = (TintManager)INSTANCE_CACHE.get(var0);
      TintManager var1 = var2;
      if(var2 == null) {
         var1 = new TintManager(var0);
         INSTANCE_CACHE.put(var0, var1);
      }

      return var1;
   }

   private ColorStateList getDefaultColorStateList(Context var1) {
      if(this.mDefaultColorStateList == null) {
         int var2 = ThemeUtils.getThemeAttrColor(var1, R.attr.colorControlNormal);
         int var3 = ThemeUtils.getThemeAttrColor(var1, R.attr.colorControlActivated);
         int[][] var5 = new int[7][];
         int[] var6 = new int[7];
         var5[0] = ThemeUtils.DISABLED_STATE_SET;
         var6[0] = ThemeUtils.getDisabledThemeAttrColor(var1, R.attr.colorControlNormal);
         int var4 = 0 + 1;
         var5[var4] = ThemeUtils.FOCUSED_STATE_SET;
         var6[var4] = var3;
         ++var4;
         var5[var4] = ThemeUtils.ACTIVATED_STATE_SET;
         var6[var4] = var3;
         ++var4;
         var5[var4] = ThemeUtils.PRESSED_STATE_SET;
         var6[var4] = var3;
         ++var4;
         var5[var4] = ThemeUtils.CHECKED_STATE_SET;
         var6[var4] = var3;
         ++var4;
         var5[var4] = ThemeUtils.SELECTED_STATE_SET;
         var6[var4] = var3;
         var3 = var4 + 1;
         var5[var3] = ThemeUtils.EMPTY_STATE_SET;
         var6[var3] = var2;
         this.mDefaultColorStateList = new ColorStateList(var5, var6);
      }

      return this.mDefaultColorStateList;
   }

   public static Drawable getDrawable(Context var0, int var1) {
      return isInTintList(var1)?get(var0).getDrawable(var1):ContextCompat.getDrawable(var0, var1);
   }

   private static boolean isInTintList(int var0) {
      return arrayContains(TINT_COLOR_CONTROL_NORMAL, var0) || arrayContains(COLORFILTER_TINT_COLOR_CONTROL_NORMAL, var0) || arrayContains(COLORFILTER_COLOR_CONTROL_ACTIVATED, var0) || arrayContains(TINT_COLOR_CONTROL_STATE_LIST, var0) || arrayContains(COLORFILTER_COLOR_BACKGROUND_MULTIPLY, var0) || arrayContains(TINT_CHECKABLE_BUTTON_LIST, var0) || var0 == R.drawable.abc_cab_background_top_material;
   }

   private static void setPorterDuffColorFilter(Drawable var0, int var1, Mode var2) {
      Mode var3 = var2;
      if(var2 == null) {
         var3 = DEFAULT_MODE;
      }

      PorterDuffColorFilter var4 = COLOR_FILTER_CACHE.get(var1, var3);
      PorterDuffColorFilter var5 = var4;
      if(var4 == null) {
         var5 = new PorterDuffColorFilter(var1, var3);
         COLOR_FILTER_CACHE.put(var1, var3, var5);
      }

      var0.setColorFilter(var5);
   }

   public static void tintViewBackground(View var0, TintInfo var1) {
      Drawable var3 = var0.getBackground();
      if(var1.mHasTintList) {
         int var2 = var1.mTintList.getColorForState(var0.getDrawableState(), var1.mTintList.getDefaultColor());
         Mode var4;
         if(var1.mHasTintMode) {
            var4 = var1.mTintMode;
         } else {
            var4 = null;
         }

         setPorterDuffColorFilter(var3, var2, var4);
      } else {
         var3.clearColorFilter();
      }

      if(VERSION.SDK_INT <= 10) {
         var0.invalidate();
      }

   }

   public Drawable getDrawable(int var1) {
      return this.getDrawable(var1, false);
   }

   public Drawable getDrawable(int var1, boolean var2) {
      Context var3 = (Context)this.mContextRef.get();
      Drawable var6;
      if(var3 == null) {
         var6 = null;
      } else {
         Drawable var5 = ContextCompat.getDrawable(var3, var1);
         var6 = var5;
         if(var5 != null) {
            Drawable var4 = var5;
            if(VERSION.SDK_INT >= 8) {
               var4 = var5.mutate();
            }

            ColorStateList var7 = this.getTintList(var1);
            if(var7 != null) {
               var4 = DrawableCompat.wrap(var4);
               DrawableCompat.setTintList(var4, var7);
               Mode var8 = this.getTintMode(var1);
               var6 = var4;
               if(var8 != null) {
                  DrawableCompat.setTintMode(var4, var8);
                  return var4;
               }
            } else {
               if(var1 == R.drawable.abc_cab_background_top_material) {
                  return new LayerDrawable(new Drawable[]{this.getDrawable(R.drawable.abc_cab_background_internal_bg), this.getDrawable(R.drawable.abc_cab_background_top_mtrl_alpha)});
               }

               var6 = var4;
               if(!this.tintDrawableUsingColorFilter(var1, var4)) {
                  var6 = var4;
                  if(var2) {
                     return null;
                  }
               }
            }
         }
      }

      return var6;
   }

   public final ColorStateList getTintList(int var1) {
      ColorStateList var2 = null;
      ColorStateList var3 = null;
      Context var4 = (Context)this.mContextRef.get();
      if(var4 != null) {
         if(this.mTintLists != null) {
            var2 = (ColorStateList)this.mTintLists.get(var1);
         }

         var3 = var2;
         if(var2 == null) {
            if(var1 == R.drawable.abc_edit_text_material) {
               var2 = this.createEditTextColorStateList(var4);
            } else if(var1 == R.drawable.abc_switch_track_mtrl_alpha) {
               var2 = this.createSwitchTrackColorStateList(var4);
            } else if(var1 == R.drawable.abc_switch_thumb_material) {
               var2 = this.createSwitchThumbColorStateList(var4);
            } else if(var1 != R.drawable.abc_btn_default_mtrl_shape && var1 != R.drawable.abc_btn_borderless_material) {
               if(var1 != R.drawable.abc_spinner_mtrl_am_alpha && var1 != R.drawable.abc_spinner_textfield_background_material) {
                  if(arrayContains(TINT_COLOR_CONTROL_NORMAL, var1)) {
                     var2 = ThemeUtils.getThemeAttrColorStateList(var4, R.attr.colorControlNormal);
                  } else if(arrayContains(TINT_COLOR_CONTROL_STATE_LIST, var1)) {
                     var2 = this.getDefaultColorStateList(var4);
                  } else if(arrayContains(TINT_CHECKABLE_BUTTON_LIST, var1)) {
                     var2 = this.createCheckableButtonColorStateList(var4);
                  }
               } else {
                  var2 = this.createSpinnerColorStateList(var4);
               }
            } else {
               var2 = this.createButtonColorStateList(var4);
            }

            var3 = var2;
            if(var2 != null) {
               if(this.mTintLists == null) {
                  this.mTintLists = new SparseArray();
               }

               this.mTintLists.append(var1, var2);
               return var2;
            }
         }
      }

      return var3;
   }

   final Mode getTintMode(int var1) {
      Mode var2 = null;
      if(var1 == R.drawable.abc_switch_thumb_material) {
         var2 = Mode.MULTIPLY;
      }

      return var2;
   }

   public final boolean tintDrawableUsingColorFilter(int var1, Drawable var2) {
      Context var8 = (Context)this.mContextRef.get();
      if(var8 != null) {
         Object var7 = null;
         boolean var4 = false;
         int var3 = 0;
         int var5 = -1;
         Mode var6;
         if(arrayContains(COLORFILTER_TINT_COLOR_CONTROL_NORMAL, var1)) {
            var3 = R.attr.colorControlNormal;
            var4 = true;
            var6 = (Mode)var7;
         } else if(arrayContains(COLORFILTER_COLOR_CONTROL_ACTIVATED, var1)) {
            var3 = R.attr.colorControlActivated;
            var4 = true;
            var6 = (Mode)var7;
         } else if(arrayContains(COLORFILTER_COLOR_BACKGROUND_MULTIPLY, var1)) {
            var3 = 16842801;
            var4 = true;
            var6 = Mode.MULTIPLY;
         } else {
            var6 = (Mode)var7;
            if(var1 == R.drawable.abc_list_divider_mtrl_alpha) {
               var3 = 16842800;
               var4 = true;
               var5 = Math.round(40.8F);
               var6 = (Mode)var7;
            }
         }

         if(var4) {
            setPorterDuffColorFilter(var2, ThemeUtils.getThemeAttrColor(var8, var3), var6);
            if(var5 != -1) {
               var2.setAlpha(var5);
            }

            return true;
         }
      }

      return false;
   }

   private static class ColorFilterLruCache extends LruCache {
      public ColorFilterLruCache(int var1) {
         super(var1);
      }

      private static int generateCacheKey(int var0, Mode var1) {
         return (var0 + 31) * 31 + var1.hashCode();
      }

      PorterDuffColorFilter get(int var1, Mode var2) {
         return (PorterDuffColorFilter)this.get(Integer.valueOf(generateCacheKey(var1, var2)));
      }

      PorterDuffColorFilter put(int var1, Mode var2, PorterDuffColorFilter var3) {
         return (PorterDuffColorFilter)this.put(Integer.valueOf(generateCacheKey(var1, var2)), var3);
      }
   }
}
