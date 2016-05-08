package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.v7.view.SupportMenuInflater$MenuState;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SupportMenuInflater extends MenuInflater {
   private static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE;
   private static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class};
   private static final String LOG_TAG = "SupportMenuInflater";
   private static final int NO_ID = 0;
   private static final String XML_GROUP = "group";
   private static final String XML_ITEM = "item";
   private static final String XML_MENU = "menu";
   private final Object[] mActionProviderConstructorArguments;
   private final Object[] mActionViewConstructorArguments;
   private Context mContext;
   private Object mRealOwner;

   static {
      ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
   }

   public SupportMenuInflater(Context var1) {
      super(var1);
      this.mContext = var1;
      this.mActionViewConstructorArguments = new Object[]{var1};
      this.mActionProviderConstructorArguments = this.mActionViewConstructorArguments;
   }

   private Object findRealOwner(Object var1) {
      return !(var1 instanceof Activity) && var1 instanceof ContextWrapper?this.findRealOwner(((ContextWrapper)var1).getBaseContext()):var1;
   }

   private Object getRealOwner() {
      if(this.mRealOwner == null) {
         this.mRealOwner = this.findRealOwner(this.mContext);
      }

      return this.mRealOwner;
   }

   private void parseMenu(XmlPullParser var1, AttributeSet var2, Menu var3) throws XmlPullParserException, IOException {
      SupportMenuInflater$MenuState var10 = new SupportMenuInflater$MenuState(this, var3);
      int var4 = var1.getEventType();
      boolean var6 = false;
      String var9 = null;

      String var12;
      while(true) {
         if(var4 == 2) {
            var12 = var1.getName();
            if(!var12.equals("menu")) {
               throw new RuntimeException("Expecting menu, got " + var12);
            }

            var4 = var1.next();
            break;
         }

         int var5 = var1.next();
         var4 = var5;
         if(var5 == 1) {
            var4 = var5;
            break;
         }
      }

      boolean var13 = false;

      for(int var8 = var4; !var13; var9 = var12) {
         boolean var7;
         boolean var14;
         switch(var8) {
         case 1:
            throw new RuntimeException("Unexpected end of document");
         case 2:
            var14 = var6;
            var7 = var13;
            var12 = var9;
            if(!var6) {
               var12 = var1.getName();
               if(var12.equals("group")) {
                  var10.readGroup(var2);
                  var14 = var6;
                  var7 = var13;
                  var12 = var9;
               } else if(var12.equals("item")) {
                  var10.readItem(var2);
                  var14 = var6;
                  var7 = var13;
                  var12 = var9;
               } else if(var12.equals("menu")) {
                  this.parseMenu(var1, var2, var10.addSubMenuItem());
                  var14 = var6;
                  var7 = var13;
                  var12 = var9;
               } else {
                  var14 = true;
                  var7 = var13;
               }
            }
            break;
         case 3:
            String var11 = var1.getName();
            if(var6 && var11.equals(var9)) {
               var14 = false;
               var12 = null;
               var7 = var13;
            } else if(var11.equals("group")) {
               var10.resetGroup();
               var14 = var6;
               var7 = var13;
               var12 = var9;
            } else if(var11.equals("item")) {
               var14 = var6;
               var7 = var13;
               var12 = var9;
               if(!var10.hasAddedItem()) {
                  if(SupportMenuInflater$MenuState.access$000(var10) != null && SupportMenuInflater$MenuState.access$000(var10).hasSubMenu()) {
                     var10.addSubMenuItem();
                     var14 = var6;
                     var7 = var13;
                     var12 = var9;
                  } else {
                     var10.addItem();
                     var14 = var6;
                     var7 = var13;
                     var12 = var9;
                  }
               }
            } else {
               var14 = var6;
               var7 = var13;
               var12 = var9;
               if(var11.equals("menu")) {
                  var7 = true;
                  var14 = var6;
                  var12 = var9;
               }
            }
            break;
         default:
            var12 = var9;
            var7 = var13;
            var14 = var6;
         }

         var8 = var1.next();
         var6 = var14;
         var13 = var7;
      }

   }

   public void inflate(int param1, Menu param2) {
      // $FF: Couldn't be decompiled
   }
}
