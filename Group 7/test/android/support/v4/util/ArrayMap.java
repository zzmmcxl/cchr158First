package android.support.v4.util;

import android.support.v4.util.ArrayMap$1;
import android.support.v4.util.MapCollections;
import android.support.v4.util.SimpleArrayMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {
   MapCollections<K, V> mCollections;

   public ArrayMap() {
   }

   public ArrayMap(int var1) {
      super(var1);
   }

   public ArrayMap(SimpleArrayMap var1) {
      super(var1);
   }

   private MapCollections<K, V> getCollection() {
      if(this.mCollections == null) {
         this.mCollections = new ArrayMap$1(this);
      }

      return this.mCollections;
   }

   public boolean containsAll(Collection<?> var1) {
      return MapCollections.containsAllHelper(this, var1);
   }

   public Set<Entry<K, V>> entrySet() {
      return this.getCollection().getEntrySet();
   }

   public Set<K> keySet() {
      return this.getCollection().getKeySet();
   }

   public void putAll(Map<? extends K, ? extends V> var1) {
      this.ensureCapacity(this.mSize + var1.size());
      Iterator var3 = var1.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var2 = (Entry)var3.next();
         this.put(var2.getKey(), var2.getValue());
      }

   }

   public boolean removeAll(Collection<?> var1) {
      return MapCollections.removeAllHelper(this, var1);
   }

   public boolean retainAll(Collection<?> var1) {
      return MapCollections.retainAllHelper(this, var1);
   }

   public Collection<V> values() {
      return this.getCollection().getValues();
   }
}
