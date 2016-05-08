package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v7.appcompat.R$attr;
import android.support.v7.appcompat.R$drawable;
import android.support.v7.widget.AppCompatDrawableManager$1;
import android.support.v7.widget.AppCompatDrawableManager$AvdcInflateDelegate;
import android.support.v7.widget.AppCompatDrawableManager$ColorFilterLruCache;
import android.support.v7.widget.AppCompatDrawableManager$InflateDelegate;
import android.support.v7.widget.AppCompatDrawableManager$VdcInflateDelegate;
import android.support.v7.widget.DrawableUtils;
import android.support.v7.widget.ThemeUtils;
import android.support.v7.widget.TintInfo;
import android.support.v7.widget.TintResources;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class AppCompatDrawableManager {
   private static final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY;
   private static final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED;
   private static final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL;
   private static final AppCompatDrawableManager$ColorFilterLruCache COLOR_FILTER_CACHE;
   private static final boolean DEBUG = false;
   private static final Mode DEFAULT_MODE;
   private static AppCompatDrawableManager INSTANCE;
   private static final String PLATFORM_VD_CLAZZ = "android.graphics.drawable.VectorDrawable";
   private static final String SKIP_DRAWABLE_TAG = "appcompat_skip_skip";
   private static final String TAG = "AppCompatDrawableManager";
   private static final int[] TINT_CHECKABLE_BUTTON_LIST;
   private static final int[] TINT_COLOR_CONTROL_NORMAL;
   private static final int[] TINT_COLOR_CONTROL_STATE_LIST;
   private final Object mDelegateDrawableCacheLock = new Object();
   private final WeakHashMap<Context, LongSparseArray<WeakReference<ConstantState>>> mDelegateDrawableCaches = new WeakHashMap(0);
   private ArrayMap<String, AppCompatDrawableManager$InflateDelegate> mDelegates;
   private boolean mHasCheckedVectorDrawableSetup;
   private SparseArray<String> mKnownDrawableIdTags;
   private WeakHashMap<Context, SparseArray<ColorStateList>> mTintLists;
   private TypedValue mTypedValue;

   static {
      DEFAULT_MODE = Mode.SRC_IN;
      COLOR_FILTER_CACHE = new AppCompatDrawableManager$ColorFilterLruCache(6);
      COLORFILTER_TINT_COLOR_CONTROL_NORMAL = new int[]{R$drawable.abc_textfield_search_default_mtrl_alpha, R$drawable.abc_textfield_default_mtrl_alpha, R$drawable.abc_ab_share_pack_mtrl_alpha};
      TINT_COLOR_CONTROL_NORMAL = new int[]{R$drawable.abc_ic_ab_back_mtrl_am_alpha, R$drawable.abc_ic_go_search_api_mtrl_alpha, R$drawable.abc_ic_search_api_mtrl_alpha, R$drawable.abc_ic_commit_search_api_mtrl_alpha, R$drawable.abc_ic_clear_mtrl_alpha, R$drawable.abc_ic_menu_share_mtrl_alpha, R$drawable.abc_ic_menu_copy_mtrl_am_alpha, R$drawable.abc_ic_menu_cut_mtrl_alpha, R$drawable.abc_ic_menu_selectall_mtrl_alpha, R$drawable.abc_ic_menu_paste_mtrl_am_alpha, R$drawable.abc_ic_menu_moreoverflow_mtrl_alpha, R$drawable.abc_ic_voice_search_api_mtrl_alpha};
      COLORFILTER_COLOR_CONTROL_ACTIVATED = new int[]{R$drawable.abc_textfield_activated_mtrl_alpha, R$drawable.abc_textfield_search_activated_mtrl_alpha, R$drawable.abc_cab_background_top_mtrl_alpha, R$drawable.abc_text_cursor_material};
      COLORFILTER_COLOR_BACKGROUND_MULTIPLY = new int[]{R$drawable.abc_popup_background_mtrl_mult, R$drawable.abc_cab_background_internal_bg, R$drawable.abc_menu_hardkey_panel_mtrl_mult};
      TINT_COLOR_CONTROL_STATE_LIST = new int[]{R$drawable.abc_edit_text_material, R$drawable.abc_tab_indicator_material, R$drawable.abc_textfield_search_material, R$drawable.abc_spinner_mtrl_am_alpha, R$drawable.abc_spinner_textfield_background_material, R$drawable.abc_ratingbar_full_material, R$drawable.abc_switch_track_mtrl_alpha, R$drawable.abc_switch_thumb_material, R$drawable.abc_btn_default_mtrl_shape, R$drawable.abc_btn_borderless_material};
      TINT_CHECKABLE_BUTTON_LIST = new int[]{R$drawable.abc_btn_check_material, R$drawable.abc_btn_radio_material};
   }

   private boolean addCachedDelegateDrawable(@NonNull Context param1, long param2, @NonNull Drawable param4) {
      // $FF: Couldn't be decompiled
   }

   private void addDelegate(@NonNull String var1, @NonNull AppCompatDrawableManager$InflateDelegate var2) {
      if(this.mDelegates == null) {
         this.mDelegates = new ArrayMap();
      }

      this.mDelegates.put(var1, var2);
   }

   private void addTintListToCache(@NonNull Context var1, @DrawableRes int var2, @NonNull ColorStateList var3) {
      if(this.mTintLists == null) {
         this.mTintLists = new WeakHashMap();
      }

      SparseArray var5 = (SparseArray)this.mTintLists.get(var1);
      SparseArray var4 = var5;
      if(var5 == null) {
         var4 = new SparseArray();
         this.mTintLists.put(var1, var4);
      }

      var4.append(var2, var3);
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

   private ColorStateList createButtonColorStateList(Context var1, int var2) {
      int[][] var5 = new int[4][];
      int[] var6 = new int[4];
      var2 = ThemeUtils.getThemeAttrColor(var1, var2);
      int var3 = ThemeUtils.getThemeAttrColor(var1, R$attr.colorControlHighlight);
      var5[0] = ThemeUtils.DISABLED_STATE_SET;
      var6[0] = ThemeUtils.getDisabledThemeAttrColor(var1, R$attr.colorButtonNormal);
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
      var4[0] = ThemeUtils.getDisabledThemeAttrColor(var1, R$attr.colorControlNormal);
      int var2 = 0 + 1;
      var3[var2] = ThemeUtils.CHECKED_STATE_SET;
      var4[var2] = ThemeUtils.getThemeAttrColor(var1, R$attr.colorControlActivated);
      ++var2;
      var3[var2] = ThemeUtils.EMPTY_STATE_SET;
      var4[var2] = ThemeUtils.getThemeAttrColor(var1, R$attr.colorControlNormal);
      return new ColorStateList(var3, var4);
   }

   private ColorStateList createColoredButtonColorStateList(Context var1) {
      return this.createButtonColorStateList(var1, R$attr.colorAccent);
   }

   private ColorStateList createDefaultButtonColorStateList(Context var1) {
      return this.createButtonColorStateList(var1, R$attr.colorButtonNormal);
   }

   private ColorStateList createDefaultColorStateList(Context var1) {
      int var2 = ThemeUtils.getThemeAttrColor(var1, R$attr.colorControlNormal);
      int var3 = ThemeUtils.getThemeAttrColor(var1, R$attr.colorControlActivated);
      int[][] var5 = new int[7][];
      int[] var6 = new int[7];
      var5[0] = ThemeUtils.DISABLED_STATE_SET;
      var6[0] = ThemeUtils.getDisabledThemeAttrColor(var1, R$attr.colorControlNormal);
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
      return new ColorStateList(var5, var6);
   }

   private ColorStateList createEditTextColorStateList(Context var1) {
      int[][] var3 = new int[3][];
      int[] var4 = new int[3];
      var3[0] = ThemeUtils.DISABLED_STATE_SET;
      var4[0] = ThemeUtils.getDisabledThemeAttrColor(var1, R$attr.colorControlNormal);
      int var2 = 0 + 1;
      var3[var2] = ThemeUtils.NOT_PRESSED_OR_FOCUSED_STATE_SET;
      var4[var2] = ThemeUtils.getThemeAttrColor(var1, R$attr.colorControlNormal);
      ++var2;
      var3[var2] = ThemeUtils.EMPTY_STATE_SET;
      var4[var2] = ThemeUtils.getThemeAttrColor(var1, R$attr.colorControlActivated);
      return new ColorStateList(var3, var4);
   }

   private ColorStateList createSeekbarThumbColorStateList(Context var1) {
      int[][] var3 = new int[2][];
      int[] var4 = new int[2];
      var3[0] = ThemeUtils.DISABLED_STATE_SET;
      var4[0] = ThemeUtils.getDisabledThemeAttrColor(var1, R$attr.colorControlActivated);
      int var2 = 0 + 1;
      var3[var2] = ThemeUtils.EMPTY_STATE_SET;
      var4[var2] = ThemeUtils.getThemeAttrColor(var1, R$attr.colorControlActivated);
      return new ColorStateList(var3, var4);
   }

   private ColorStateList createSpinnerColorStateList(Context var1) {
      int[][] var3 = new int[3][];
      int[] var4 = new int[3];
      var3[0] = ThemeUtils.DISABLED_STATE_SET;
      var4[0] = ThemeUtils.getDisabledThemeAttrColor(var1, R$attr.colorControlNormal);
      int var2 = 0 + 1;
      var3[var2] = ThemeUtils.NOT_PRESSED_OR_FOCUSED_STATE_SET;
      var4[var2] = ThemeUtils.getThemeAttrColor(var1, R$attr.colorControlNormal);
      ++var2;
      var3[var2] = ThemeUtils.EMPTY_STATE_SET;
      var4[var2] = ThemeUtils.getThemeAttrColor(var1, R$attr.colorControlActivated);
      return new ColorStateList(var3, var4);
   }

   private ColorStateList createSwitchThumbColorStateList(Context var1) {
      int[][] var3 = new int[3][];
      int[] var4 = new int[3];
      ColorStateList var5 = ThemeUtils.getThemeAttrColorStateList(var1, R$attr.colorSwitchThumbNormal);
      int var2;
      if(var5 != null && var5.isStateful()) {
         var3[0] = ThemeUtils.DISABLED_STATE_SET;
         var4[0] = var5.getColorForState(var3[0], 0);
         var2 = 0 + 1;
         var3[var2] = ThemeUtils.CHECKED_STATE_SET;
         var4[var2] = ThemeUtils.getThemeAttrColor(var1, R$attr.colorControlActivated);
         ++var2;
         var3[var2] = ThemeUtils.EMPTY_STATE_SET;
         var4[var2] = var5.getDefaultColor();
      } else {
         var3[0] = ThemeUtils.DISABLED_STATE_SET;
         var4[0] = ThemeUtils.getDisabledThemeAttrColor(var1, R$attr.colorSwitchThumbNormal);
         var2 = 0 + 1;
         var3[var2] = ThemeUtils.CHECKED_STATE_SET;
         var4[var2] = ThemeUtils.getThemeAttrColor(var1, R$attr.colorControlActivated);
         ++var2;
         var3[var2] = ThemeUtils.EMPTY_STATE_SET;
         var4[var2] = ThemeUtils.getThemeAttrColor(var1, R$attr.colorSwitchThumbNormal);
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
      var4[var2] = ThemeUtils.getThemeAttrColor(var1, R$attr.colorControlActivated, 0.3F);
      ++var2;
      var3[var2] = ThemeUtils.EMPTY_STATE_SET;
      var4[var2] = ThemeUtils.getThemeAttrColor(var1, 16842800, 0.3F);
      return new ColorStateList(var3, var4);
   }

   private static PorterDuffColorFilter createTintFilter(ColorStateList var0, Mode var1, int[] var2) {
      return var0 != null && var1 != null?getPorterDuffColorFilter(var0.getColorForState(var2, 0), var1):null;
   }

   public static AppCompatDrawableManager get() {
      if(INSTANCE == null) {
         INSTANCE = new AppCompatDrawableManager();
         installDefaultInflateDelegates(INSTANCE);
      }

      return INSTANCE;
   }

   private Drawable getCachedDelegateDrawable(@NonNull Context param1, long param2) {
      // $FF: Couldn't be decompiled
   }

   public static PorterDuffColorFilter getPorterDuffColorFilter(int var0, Mode var1) {
      PorterDuffColorFilter var3 = COLOR_FILTER_CACHE.get(var0, var1);
      PorterDuffColorFilter var2 = var3;
      if(var3 == null) {
         var2 = new PorterDuffColorFilter(var0, var1);
         COLOR_FILTER_CACHE.put(var0, var1, var2);
      }

      return var2;
   }

   private ColorStateList getTintListFromCache(@NonNull Context var1, @DrawableRes int var2) {
      Object var4 = null;
      ColorStateList var3 = (ColorStateList)var4;
      if(this.mTintLists != null) {
         SparseArray var5 = (SparseArray)this.mTintLists.get(var1);
         var3 = (ColorStateList)var4;
         if(var5 != null) {
            var3 = (ColorStateList)var5.get(var2);
         }
      }

      return var3;
   }

   private static void installDefaultInflateDelegates(@NonNull AppCompatDrawableManager var0) {
      int var1 = VERSION.SDK_INT;
      if(var1 < 21) {
         var0.addDelegate("vector", new AppCompatDrawableManager$VdcInflateDelegate((AppCompatDrawableManager$1)null));
         if(var1 >= 11) {
            var0.addDelegate("animated-vector", new AppCompatDrawableManager$AvdcInflateDelegate((AppCompatDrawableManager$1)null));
         }
      }

   }

   private static boolean isVectorDrawable(@NonNull Drawable var0) {
      return var0 instanceof VectorDrawableCompat || "android.graphics.drawable.VectorDrawable".equals(var0.getClass().getName());
   }

   private Drawable loadDrawableFromDelegates(@NonNull Context param1, @DrawableRes int param2) {
      // $FF: Couldn't be decompiled
   }

   private void removeDelegate(@NonNull String var1, @NonNull AppCompatDrawableManager$InflateDelegate var2) {
      if(this.mDelegates != null && this.mDelegates.get(var1) == var2) {
         this.mDelegates.remove(var1);
      }

   }

   private static void setPorterDuffColorFilter(Drawable var0, int var1, Mode var2) {
      Drawable var3 = var0;
      if(DrawableUtils.canSafelyMutateDrawable(var0)) {
         var3 = var0.mutate();
      }

      Mode var4 = var2;
      if(var2 == null) {
         var4 = DEFAULT_MODE;
      }

      var3.setColorFilter(getPorterDuffColorFilter(var1, var4));
   }

   private Drawable tintDrawable(@NonNull Context var1, @DrawableRes int var2, boolean var3, @NonNull Drawable var4) {
      ColorStateList var5 = this.getTintList(var1, var2);
      Drawable var8;
      if(var5 != null) {
         Drawable var6 = var4;
         if(DrawableUtils.canSafelyMutateDrawable(var4)) {
            var6 = var4.mutate();
         }

         var6 = DrawableCompat.wrap(var6);
         DrawableCompat.setTintList(var6, var5);
         Mode var7 = this.getTintMode(var2);
         var8 = var6;
         if(var7 != null) {
            DrawableCompat.setTintMode(var6, var7);
            var8 = var6;
         }
      } else {
         if(var2 == R$drawable.abc_cab_background_top_material) {
            return new LayerDrawable(new Drawable[]{this.getDrawable(var1, R$drawable.abc_cab_background_internal_bg), this.getDrawable(var1, R$drawable.abc_cab_background_top_mtrl_alpha)});
         }

         LayerDrawable var9;
         if(var2 == R$drawable.abc_seekbar_track_material) {
            var9 = (LayerDrawable)var4;
            setPorterDuffColorFilter(var9.findDrawableByLayerId(16908288), ThemeUtils.getThemeAttrColor(var1, R$attr.colorControlNormal), DEFAULT_MODE);
            setPorterDuffColorFilter(var9.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(var1, R$attr.colorControlNormal), DEFAULT_MODE);
            setPorterDuffColorFilter(var9.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(var1, R$attr.colorControlActivated), DEFAULT_MODE);
            var8 = var4;
         } else if(var2 != R$drawable.abc_ratingbar_indicator_material && var2 != R$drawable.abc_ratingbar_small_material) {
            var8 = var4;
            if(!tintDrawableUsingColorFilter(var1, var2, var4)) {
               var8 = var4;
               if(var3) {
                  var8 = null;
               }
            }
         } else {
            var9 = (LayerDrawable)var4;
            setPorterDuffColorFilter(var9.findDrawableByLayerId(16908288), ThemeUtils.getDisabledThemeAttrColor(var1, R$attr.colorControlNormal), DEFAULT_MODE);
            setPorterDuffColorFilter(var9.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(var1, R$attr.colorControlActivated), DEFAULT_MODE);
            setPorterDuffColorFilter(var9.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(var1, R$attr.colorControlActivated), DEFAULT_MODE);
            var8 = var4;
         }
      }

      return var8;
   }

   public static void tintDrawable(Drawable var0, TintInfo var1, int[] var2) {
      if(DrawableUtils.canSafelyMutateDrawable(var0) && var0.mutate() != var0) {
         Log.d("AppCompatDrawableManager", "Mutated drawable is not the same instance as the input.");
      } else {
         if(!var1.mHasTintList && !var1.mHasTintMode) {
            var0.clearColorFilter();
         } else {
            ColorStateList var3;
            if(var1.mHasTintList) {
               var3 = var1.mTintList;
            } else {
               var3 = null;
            }

            Mode var4;
            if(var1.mHasTintMode) {
               var4 = var1.mTintMode;
            } else {
               var4 = DEFAULT_MODE;
            }

            var0.setColorFilter(createTintFilter(var3, var4, var2));
         }

         if(VERSION.SDK_INT <= 23) {
            var0.invalidateSelf();
            return;
         }
      }

   }

   private static boolean tintDrawableUsingColorFilter(@NonNull Context var0, @DrawableRes int var1, @NonNull Drawable var2) {
      Mode var7 = DEFAULT_MODE;
      boolean var4 = false;
      int var3 = 0;
      int var5 = -1;
      Mode var6;
      if(arrayContains(COLORFILTER_TINT_COLOR_CONTROL_NORMAL, var1)) {
         var3 = R$attr.colorControlNormal;
         var4 = true;
         var6 = var7;
      } else if(arrayContains(COLORFILTER_COLOR_CONTROL_ACTIVATED, var1)) {
         var3 = R$attr.colorControlActivated;
         var4 = true;
         var6 = var7;
      } else if(arrayContains(COLORFILTER_COLOR_BACKGROUND_MULTIPLY, var1)) {
         var3 = 16842801;
         var4 = true;
         var6 = Mode.MULTIPLY;
      } else {
         var6 = var7;
         if(var1 == R$drawable.abc_list_divider_mtrl_alpha) {
            var3 = 16842800;
            var4 = true;
            var5 = Math.round(40.8F);
            var6 = var7;
         }
      }

      if(var4) {
         Drawable var8 = var2;
         if(DrawableUtils.canSafelyMutateDrawable(var2)) {
            var8 = var2.mutate();
         }

         var8.setColorFilter(getPorterDuffColorFilter(ThemeUtils.getThemeAttrColor(var0, var3), var6));
         if(var5 != -1) {
            var8.setAlpha(var5);
         }

         return true;
      } else {
         return false;
      }
   }

   public Drawable getDrawable(@NonNull Context var1, @DrawableRes int var2) {
      return this.getDrawable(var1, var2, false);
   }

   public Drawable getDrawable(@NonNull Context var1, @DrawableRes int var2, boolean var3) {
      Drawable var5 = this.loadDrawableFromDelegates(var1, var2);
      Drawable var4 = var5;
      if(var5 == null) {
         var4 = ContextCompat.getDrawable(var1, var2);
      }

      var5 = var4;
      if(var4 != null) {
         var5 = this.tintDrawable(var1, var2, var3, var4);
      }

      if(var5 != null) {
         DrawableUtils.fixDrawable(var5);
      }

      return var5;
   }

   public final ColorStateList getTintList(@NonNull Context var1, @DrawableRes int var2) {
      ColorStateList var3 = this.getTintListFromCache(var1, var2);
      ColorStateList var4 = var3;
      if(var3 == null) {
         if(var2 == R$drawable.abc_edit_text_material) {
            var3 = this.createEditTextColorStateList(var1);
         } else if(var2 == R$drawable.abc_switch_track_mtrl_alpha) {
            var3 = this.createSwitchTrackColorStateList(var1);
         } else if(var2 == R$drawable.abc_switch_thumb_material) {
            var3 = this.createSwitchThumbColorStateList(var1);
         } else if(var2 != R$drawable.abc_btn_default_mtrl_shape && var2 != R$drawable.abc_btn_borderless_material) {
            if(var2 == R$drawable.abc_btn_colored_material) {
               var3 = this.createColoredButtonColorStateList(var1);
            } else if(var2 != R$drawable.abc_spinner_mtrl_am_alpha && var2 != R$drawable.abc_spinner_textfield_background_material) {
               if(arrayContains(TINT_COLOR_CONTROL_NORMAL, var2)) {
                  var3 = ThemeUtils.getThemeAttrColorStateList(var1, R$attr.colorControlNormal);
               } else if(arrayContains(TINT_COLOR_CONTROL_STATE_LIST, var2)) {
                  var3 = this.createDefaultColorStateList(var1);
               } else if(arrayContains(TINT_CHECKABLE_BUTTON_LIST, var2)) {
                  var3 = this.createCheckableButtonColorStateList(var1);
               } else if(var2 == R$drawable.abc_seekbar_thumb_material) {
                  var3 = this.createSeekbarThumbColorStateList(var1);
               }
            } else {
               var3 = this.createSpinnerColorStateList(var1);
            }
         } else {
            var3 = this.createDefaultButtonColorStateList(var1);
         }

         var4 = var3;
         if(var3 != null) {
            this.addTintListToCache(var1, var2, var3);
            var4 = var3;
         }
      }

      return var4;
   }

   final Mode getTintMode(int var1) {
      Mode var2 = null;
      if(var1 == R$drawable.abc_switch_thumb_material) {
         var2 = Mode.MULTIPLY;
      }

      return var2;
   }

   public final Drawable onDrawableLoadedFromResources(@NonNull Context var1, @NonNull TintResources var2, @DrawableRes int var3) {
      Drawable var5 = this.loadDrawableFromDelegates(var1, var3);
      Drawable var4 = var5;
      if(var5 == null) {
         var4 = var2.superGetDrawable(var3);
      }

      return var4 != null?this.tintDrawable(var1, var3, false, var4):null;
   }
}
