package android.support.v7.util;

import java.util.Comparator;

public abstract class SortedList$Callback<T2> implements Comparator<T2> {
   public abstract boolean areContentsTheSame(T2 var1, T2 var2);

   public abstract boolean areItemsTheSame(T2 var1, T2 var2);

   public abstract int compare(T2 var1, T2 var2);

   public abstract void onChanged(int var1, int var2);

   public abstract void onInserted(int var1, int var2);

   public abstract void onMoved(int var1, int var2);

   public abstract void onRemoved(int var1, int var2);
}
