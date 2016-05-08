package android.support.v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat$AccessibilityServiceInfoIcsImpl;
import android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat$AccessibilityServiceInfoJellyBeanMr2;
import android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat$AccessibilityServiceInfoStubImpl;
import android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat$AccessibilityServiceInfoVersionImpl;

public final class AccessibilityServiceInfoCompat {
   public static final int CAPABILITY_CAN_FILTER_KEY_EVENTS = 8;
   public static final int CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 4;
   public static final int CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION = 2;
   public static final int CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT = 1;
   public static final int DEFAULT = 1;
   public static final int FEEDBACK_ALL_MASK = -1;
   public static final int FEEDBACK_BRAILLE = 32;
   public static final int FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 2;
   public static final int FLAG_REPORT_VIEW_IDS = 16;
   public static final int FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 8;
   public static final int FLAG_REQUEST_FILTER_KEY_EVENTS = 32;
   public static final int FLAG_REQUEST_TOUCH_EXPLORATION_MODE = 4;
   private static final AccessibilityServiceInfoCompat$AccessibilityServiceInfoVersionImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 18) {
         IMPL = new AccessibilityServiceInfoCompat$AccessibilityServiceInfoJellyBeanMr2();
      } else if(VERSION.SDK_INT >= 14) {
         IMPL = new AccessibilityServiceInfoCompat$AccessibilityServiceInfoIcsImpl();
      } else {
         IMPL = new AccessibilityServiceInfoCompat$AccessibilityServiceInfoStubImpl();
      }
   }

   public static String capabilityToString(int var0) {
      switch(var0) {
      case 1:
         return "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT";
      case 2:
         return "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION";
      case 3:
      case 5:
      case 6:
      case 7:
      default:
         return "UNKNOWN";
      case 4:
         return "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
      case 8:
         return "CAPABILITY_CAN_FILTER_KEY_EVENTS";
      }
   }

   public static String feedbackTypeToString(int var0) {
      StringBuilder var2 = new StringBuilder();
      var2.append("[");

      while(var0 > 0) {
         int var1 = 1 << Integer.numberOfTrailingZeros(var0);
         var0 &= ~var1;
         if(var2.length() > 1) {
            var2.append(", ");
         }

         switch(var1) {
         case 1:
            var2.append("FEEDBACK_SPOKEN");
            break;
         case 2:
            var2.append("FEEDBACK_HAPTIC");
            break;
         case 4:
            var2.append("FEEDBACK_AUDIBLE");
            break;
         case 8:
            var2.append("FEEDBACK_VISUAL");
            break;
         case 16:
            var2.append("FEEDBACK_GENERIC");
         }
      }

      var2.append("]");
      return var2.toString();
   }

   public static String flagToString(int var0) {
      switch(var0) {
      case 1:
         return "DEFAULT";
      case 2:
         return "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
      case 4:
         return "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
      case 8:
         return "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
      case 16:
         return "FLAG_REPORT_VIEW_IDS";
      case 32:
         return "FLAG_REQUEST_FILTER_KEY_EVENTS";
      default:
         return null;
      }
   }

   public static boolean getCanRetrieveWindowContent(AccessibilityServiceInfo var0) {
      return IMPL.getCanRetrieveWindowContent(var0);
   }

   public static int getCapabilities(AccessibilityServiceInfo var0) {
      return IMPL.getCapabilities(var0);
   }

   public static String getDescription(AccessibilityServiceInfo var0) {
      return IMPL.getDescription(var0);
   }

   public static String getId(AccessibilityServiceInfo var0) {
      return IMPL.getId(var0);
   }

   public static ResolveInfo getResolveInfo(AccessibilityServiceInfo var0) {
      return IMPL.getResolveInfo(var0);
   }

   public static String getSettingsActivityName(AccessibilityServiceInfo var0) {
      return IMPL.getSettingsActivityName(var0);
   }
}
