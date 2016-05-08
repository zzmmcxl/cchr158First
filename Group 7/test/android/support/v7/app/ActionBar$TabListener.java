package android.support.v7.app;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar$Tab;

public interface ActionBar$TabListener {
   void onTabReselected(ActionBar$Tab var1, FragmentTransaction var2);

   void onTabSelected(ActionBar$Tab var1, FragmentTransaction var2);

   void onTabUnselected(ActionBar$Tab var1, FragmentTransaction var2);
}
