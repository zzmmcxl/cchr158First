package android.support.v4.util;

import android.support.v4.util.MapCollections$EntrySet;
import android.support.v4.util.MapCollections$KeySet;
import android.support.v4.util.MapCollections$ValuesCollection;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

abstract class MapCollections<K, V> {
   MapCollections<K, V>.EntrySet mEntrySet;
   MapCollections<K, V>.KeySet mKeySet;
   MapCollections<K, V>.ValuesCollection mValues;

   public static <K, V> boolean containsAllHelper(Map<K, V> var0, Collection<?> var1) {
      Iterator var2 = var1.iterator();

      do {
         if(!var2.hasNext()) {
            return true;
         }
      } while(var0.containsKey(var2.next()));

      return false;
   }

   public static <T> boolean equalsSetHelper(Set<T> var0, Object var1) {
      boolean var3 = true;
      boolean var2 = false;
      if(var0 == var1) {
         var2 = true;
      } else if(var1 instanceof Set) {
         Set var6 = (Set)var1;

         label26: {
            try {
               if(var0.size() != var6.size()) {
                  break label26;
               }

               var2 = var0.containsAll(var6);
            } catch (NullPointerException var4) {
               return false;
            } catch (ClassCastException var5) {
               return false;
            }

            if(var2) {
               var2 = var3;
               return var2;
            }
         }

         var2 = false;
         return var2;
      }

      return var2;
   }

   public static <K, V> boolean removeAllHelper(Map<K, V> var0, Collection<?> var1) {
      int var2 = var0.size();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         var0.remove(var3.next());
      }

      return var2 != var0.size();
   }

   public static <K, V> boolean retainAllHelper(Map<K, V> var0, Collection<?> var1) {
      int var2 = var0.size();
      Iterator var3 = var0.keySet().iterator();

      while(var3.hasNext()) {
         if(!var1.contains(var3.next())) {
            var3.remove();
         }
      }

      if(var2 != var0.size()) {
         return true;
      } else {
         return false;
      }
   }

   protected abstract void colClear();

   protected abstract Object colGetEntry(int var1, int var2);

   protected abstract Map<K, V> colGetMap();

   protected abstract int colGetSize();

   protected abstract int colIndexOfKey(Object var1);

   protected abstract int colIndexOfValue(Object var1);

   protected abstract void colPut(K var1, V var2);

   protected abstract void colRemoveAt(int var1);

   protected abstract V colSetValue(int var1, V var2);

   public Set<Entry<K, V>> getEntrySet() {
      if(this.mEntrySet == null) {
         this.mEntrySet = new MapCollections$EntrySet(this);
      }

      return this.mEntrySet;
   }

   public Set<K> getKeySet() {
      if(this.mKeySet == null) {
         this.mKeySet = new MapCollections$KeySet(this);
      }

      return this.mKeySet;
   }

   public Collection<V> getValues() {
      if(this.mValues == null) {
         this.mValues = new MapCollections$ValuesCollection(this);
      }

      return this.mValues;
   }

   public Object[] toArrayHelper(int var1) {
      int var3 = this.colGetSize();
      Object[] var4 = new Object[var3];

      for(int var2 = 0; var2 < var3; ++var2) {
         var4[var2] = this.colGetEntry(var2, var1);
      }

      return var4;
   }

   public <T> T[] toArrayHelper(T[] var1, int var2) {
      int var4 = this.colGetSize();
      Object[] var5 = var1;
      if(var1.length < var4) {
         var5 = (Object[])((Object[])Array.newInstance(var1.getClass().getComponentType(), var4));
      }

      for(int var3 = 0; var3 < var4; ++var3) {
         var5[var3] = this.colGetEntry(var3, var2);
      }

      if(var5.length > var4) {
         var5[var4] = null;
      }

      return var5;
   }
}
