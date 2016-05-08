package android.support.v4.util;

import android.support.v4.util.ContainerHelpers;
import android.support.v4.util.MapCollections;
import android.support.v4.util.MapCollections$MapIterator;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

final class MapCollections$EntrySet implements Set<Entry<K, V>> {
   MapCollections$EntrySet(MapCollections var1) {
      this.this$0 = var1;
   }

   public boolean add(Entry<K, V> var1) {
      throw new UnsupportedOperationException();
   }

   public boolean addAll(Collection<? extends Entry<K, V>> var1) {
      int var2 = this.this$0.colGetSize();
      Iterator var4 = var1.iterator();

      while(var4.hasNext()) {
         Entry var3 = (Entry)var4.next();
         this.this$0.colPut(var3.getKey(), var3.getValue());
      }

      return var2 != this.this$0.colGetSize();
   }

   public void clear() {
      this.this$0.colClear();
   }

   public boolean contains(Object var1) {
      if(var1 instanceof Entry) {
         Entry var3 = (Entry)var1;
         int var2 = this.this$0.colIndexOfKey(var3.getKey());
         if(var2 >= 0) {
            return ContainerHelpers.equal(this.this$0.colGetEntry(var2, 1), var3.getValue());
         }
      }

      return false;
   }

   public boolean containsAll(Collection<?> var1) {
      Iterator var2 = var1.iterator();

      do {
         if(!var2.hasNext()) {
            return true;
         }
      } while(this.contains(var2.next()));

      return false;
   }

   public boolean equals(Object var1) {
      return MapCollections.equalsSetHelper(this, var1);
   }

   public int hashCode() {
      int var2 = 0;

      for(int var1 = this.this$0.colGetSize() - 1; var1 >= 0; --var1) {
         Object var5 = this.this$0.colGetEntry(var1, 0);
         Object var6 = this.this$0.colGetEntry(var1, 1);
         int var3;
         if(var5 == null) {
            var3 = 0;
         } else {
            var3 = var5.hashCode();
         }

         int var4;
         if(var6 == null) {
            var4 = 0;
         } else {
            var4 = var6.hashCode();
         }

         var2 += var4 ^ var3;
      }

      return var2;
   }

   public boolean isEmpty() {
      return this.this$0.colGetSize() == 0;
   }

   public Iterator<Entry<K, V>> iterator() {
      return new MapCollections$MapIterator(this.this$0);
   }

   public boolean remove(Object var1) {
      throw new UnsupportedOperationException();
   }

   public boolean removeAll(Collection<?> var1) {
      throw new UnsupportedOperationException();
   }

   public boolean retainAll(Collection<?> var1) {
      throw new UnsupportedOperationException();
   }

   public int size() {
      return this.this$0.colGetSize();
   }

   public Object[] toArray() {
      throw new UnsupportedOperationException();
   }

   public <T> T[] toArray(T[] var1) {
      throw new UnsupportedOperationException();
   }
}
